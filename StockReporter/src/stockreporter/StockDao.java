/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockreporter;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.ArrayList;

public final class StockDao {
    private static StockDao instance = null;
    private Connection conn = null;
    String fileName = "stockreporter.prod";
    String url = "jdbc:sqlite:stockreporter.prod";

    public StockDao(){
        
        connect();
        
        //check to see if the DB already exists
        File file = new File(fileName);
        if (!file.exists()) {
        
        try {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("The database has been created");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        ArrayList<String> sqlStrings = new ArrayList<>();
        
        //Create the tables
        String stockTicker = "CREATE TABLE IF NOT EXISTS STOCK_TICKER (\n"
                + "	TICKER_ID INTEGER PRIMARY KEY,\n"
                + "	SYMBOL TEXT NOT NULL UNIQUE,\n"
                + "	NAME TEXT NOT NULL UNIQUE\n"
                + ");";
        
        sqlStrings.add(stockTicker);
        
        String stockSource = "CREATE TABLE IF NOT EXISTS STOCK_SOURCE (\n"
                + "	SOURCE_ID INTEGER PRIMARY KEY,\n"
                + "	NAME TEXT NOT NULL UNIQUE\n"
                + ");";
        
        sqlStrings.add(stockSource);
        
        String stockDateMap = "CREATE TABLE IF NOT EXISTS STOCK_DATE_MAP (\n"
                + "	STOCK_DT_MAP_ID INTEGER PRIMARY KEY,\n"
                + "	STOCK_DATE INTEGER,\n"
                + "	TICKER_ID INTEGER REFERENCES STOCK_TICKET(TICKET_ID),\n"
                + "	SOURCE_ID INTEGER REFERENCES STOCK_SOURCE(SOURCE_ID)\n"
                + ");";
        
        sqlStrings.add(stockDateMap);
        
        String stockSummary = "CREATE TABLE IF NOT EXISTS STOCK_SUMMARY (\n"
                + "	SUMMARY_ID INTEGER PRIMARY KEY,\n"
                + "	PREV_CLOSE_PRICE REAL,\n"
                + "	OPEN_PRICE REAL,\n"
                + "	BID_PRICE REAL,\n"
                + "	ASK_PRICE REAL,\n"
                + "	DAYS_RANGE_MIN REAL,\n"
                + "	DAYS_RANGE_MAX REAL,\n"
                + "	FIFTY_TWO_WEEKS_MIN REAL,\n"
                + "	FIFTY_TWO_WEEKS_MAX REAL,\n"
                + "	VOLUME INTEGER,\n"
                + "	AVG_VOLUME INTEGER,\n"
                + "	MARKET_CAP REAL,\n"
                + "	BETA_COEFFICIENT REAL,\n"
                + "	PE_RATIO REAL,\n"
                + "	EPS REAL,\n"
                + "	EARNING_DATE INTEGER,\n"
                + "	DIVIDEND_YIELD REAL,\n"
                + "	EX_DIVIDEND_DATE INTEGER,\n"
                + "	ONE_YEAR_TARGET_EST REAL,\n"
                + "	STOCK_DT_MAP_ID INTEGER REFERENCES STOCK_DATE_MAP(STOCK_DT_MAP_ID)\n"
                + ");";
        
        sqlStrings.add(stockSummary);
        
        //Placeholder for the StockHistorical string.
        
        //Creating the index
        String index = "CREATE INDEX STOCK_DATE_IDX ON STOCK_DATE_MAP(STOCK_DATE);";
        
        sqlStrings.add(index);
        
        //Creating the View strings
        String stockSummaryView = "CREATE OR REPLACE VIEW STOCK_SUMMARY_VIEW AS\n"
                + "	SELECT SDP.TICKER_ID, SDP.SOURCE_ID, MAX(SS.OPEN_PRICE) AS PRICE_MAX,\n"
                + "	MIN(SS.OPEN_PRICE) AS PRICE_MIN, AVG(SS.OPEN_PRICE) AS PRICE_AVERAGE\n"
                + "	FROM STOCK_SUMMARY SS\n"
                + "	INNER JOIN STOCK_DATE_MAP SDP ON SS.STOCK_DT_MAP_ID =\n"
                + "	SDP.STOCK_DT_MAP_ID\n"
                + "	GROUP BY STOCK_DATE, SDP.SOURCE_ID;";
        
        sqlStrings.add(stockSummaryView);
        
        //Placeholder for stockhistorical view
        
        //Execute the SQL strings in the DB.
        for(String str:sqlStrings){
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(str);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        //this.disconnect();
      }
    }
    
    public static StockDao getInstance(){
        if(instance == null){
            instance = new StockDao();
        }
        return instance;
    }
    
   public void connect() {   //Connects to the database
        try {
            conn = DriverManager.getConnection(url);            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private void disconnect(){//Disconnects from the database
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void setStockTickerData(String stockName, String stockSymbol){
        String sql = "INSERT INTO STOCK_TICKER (SYMBOL, NAME) VALUES (?, ?);";
                    
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, stockName);
            pstmt.setString(2, stockSymbol);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void setStockSource(String stockSource){
        String sql = "INSERT INTO STOCK_SOURCE (NAME) VALUES (?);";
        
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, stockSource);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertStockSummaryData(StockSummary stockSummary){
        String sql = "INSERT INTO STOCK_TICKER (SUMMARY_ID,"
                + " PREV_CLOSE_PRICE,"
                + " OPEN_PRICE,"
                + " BID_PRICE,"
                + " ASK_PRICE,"
                + " DAYS_RANGE_MIN,"
                + " DAYS_RANGE_MAX,"
                + " FIFTY_TWO_WEEKS_MIN,"
                + " FIFTY_TWO_WEEKS_MAX,"
                + " VOLUME,"
                + " AVG_VOLUME,"
                + " MARKET_CAP,"
                + " BETA_COEFFICIENT,"
                + " PE_RATIO,"
                + " EPS,"
                + " EARNING_DATE,"
                + " DIVIDEND_YIELD,"
                + " EX_DIVIDEND_DATE,"
                + " ONE_YEAR_TARGET) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, stockSummary.getSummaryId());
            pstmt.setBigDecimal(2, stockSummary.getPrevClosePrice());
            pstmt.setBigDecimal(3, stockSummary.getOpenPrice());
            pstmt.setBigDecimal(4, stockSummary.getBidPrice());
            pstmt.setBigDecimal(5, stockSummary.getAskPrice());
            pstmt.setBigDecimal(6, stockSummary.getDaysRangeMax());
            pstmt.setBigDecimal(7, stockSummary.getDaysRangeMin());
            pstmt.setBigDecimal(8, stockSummary.getFiftyTwoWeeksMax());
            pstmt.setBigDecimal(9, stockSummary.getFiftyTwoWeeksMin());
            pstmt.setLong(10,stockSummary.getVolume());
            pstmt.setLong(11,stockSummary.getAvgVolume());
            pstmt.setBigDecimal(12,stockSummary.getMarketCap());
            pstmt.setBigDecimal(13,stockSummary.getBetaCoefficient());
            pstmt.setBigDecimal(14,stockSummary.getPeRatio());
            pstmt.setBigDecimal(15,stockSummary.getEps());
            pstmt.setDate(16,stockSummary.getEarningDate());
            pstmt.setBigDecimal(17,stockSummary.getDividentYield());
            pstmt.setDate(18,stockSummary.getExDividentDate());
            pstmt.setBigDecimal(19,stockSummary.getOneYearTargetEst());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void getAvgStockSummaryView(){
        String sql = "SELECT * FROM STOCK_SUMMARY_VIEW;";
        
        try (
             Statement statement  = conn.createStatement();
             ResultSet results    = statement.executeQuery(sql)){
            System.out.println(results);
            while (results.next()) {
                System.out.println(results.getInt("SDP.TICKER_ID") +  "\t" + 
                                   results.getString("SDP.SOURCE_ID") + "\t" +
                                   results.getBigDecimal("PRICE_MAX") +  "\t" + 
                                   results.getBigDecimal("PRICE_MIN") + "\t" +
                                   results.getBigDecimal("PRICE_AVERAGE"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void deleteAll(){
        String sql ="DELETE FROM "+ Constants.TABLE_STOCKS;
        try{
            Statement stmt  = conn.createStatement();
            stmt.executeQuery(sql);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
        }
    }
    
}
