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
                + "	TICKER_ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "	SYMBOL TEXT NOT NULL UNIQUE,\n"
                + "	NAME TEXT NOT NULL UNIQUE\n"
                + ");";
        
        sqlStrings.add(stockTicker);
        
        String stockSource = "CREATE TABLE IF NOT EXISTS STOCK_SOURCE (\n"
                + "	SOURCE_ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "	NAME TEXT NOT NULL UNIQUE\n"
                + ");";
        
        sqlStrings.add(stockSource);
        
        String stockDateMap = "CREATE TABLE IF NOT EXISTS STOCK_DATE_MAP (\n"
                + "	STOCK_DT_MAP_ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "	STOCK_DATE TEXT,\n"
                + "	TICKER_ID INTEGER REFERENCES STOCK_TICKET(TICKET_ID),\n"
                + "	SOURCE_ID INTEGER REFERENCES STOCK_SOURCE(SOURCE_ID)\n"
                + ");";
        
        sqlStrings.add(stockDateMap);
        
        String stockSummary = "CREATE TABLE IF NOT EXISTS STOCK_SUMMARY (\n"
                + "	SUMMARY_ID INTEGER PRIMARY KEY AUTOINCREMENT,\n"
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
                + "	EARNING_DATE TEXT,\n"
                + "	DIVIDEND_YIELD REAL,\n"
                + "	EX_DIVIDEND_DATE TEXT,\n"
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
        try{
            Statement stmt = conn.createStatement();
            for(String str:sqlStrings){
                stmt.execute(str);
            }
        } catch (SQLException e) {
                System.out.println(e.getMessage());
        } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
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
        } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
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
        } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
    }
    
    public void insertStockDateMap(String date, String symbol, String stockSource) {
        int tickerID = -1;
        String symbolQuery = "SELECT TICKER_ID FROM STOCK_TICKER WHERE SYMBOL = ?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(symbolQuery);
            pstmt.setString(1, symbol);
            ResultSet rs = pstmt.executeQuery();
            tickerID = rs.getInt("ticker_id");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
        
        int sourceID = -1;
        String sourceIdQuery = "SELECT SOURCE_ID FROM STOCK_SOURCE WHERE NAME = ?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sourceIdQuery);
            pstmt.setString(1, stockSource);
            ResultSet rs = pstmt.executeQuery();
            sourceID = rs.getInt("source_id");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
        
        String sql = "INSERT INTO STOCK_DATE_MAP (STOCK_DATE,"
                + " TICKER_ID,"
                + " SOURCE_ID) VALUES (?, ?, ?);";
        if (tickerID != -1 && sourceID != -1){
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, date);
            pstmt.setInt(2, tickerID);
            pstmt.setInt(3, sourceID);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
        }
    }
    
    public int getStockDateMapID(String date, String symbol, String stockSource){
        int stockDateMapID = -1;
        int tickerID = -1;
        String symbolQuery = "SELECT TICKER_ID FROM STOCK_TICKER WHERE SYMBOL = ?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(symbolQuery);
            pstmt.setString(1, symbol);
            ResultSet rs = pstmt.executeQuery();
            tickerID = rs.getInt("ticker_id");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
        
        int sourceID = -1;
        String sourceIdQuery = "SELECT SOURCE_ID FROM STOCK_SOURCE WHERE NAME = ?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sourceIdQuery);
            pstmt.setString(1, stockSource);
            ResultSet rs = pstmt.executeQuery();
            sourceID = rs.getInt("source_id");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
        if (tickerID != -1 && sourceID != -1){
        String stockDtMapId = "SELECT STOCK_DT_MAP_ID FROM STOCK_DATE_MAP WHERE STOCK_DATE = ? AND TICKER_ID = ? AND SOURCE_ID = ?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(stockDtMapId);
            pstmt.setString(1, date);
            pstmt.setInt(2, tickerID);
            pstmt.setInt(3, sourceID);
            ResultSet rs = pstmt.executeQuery();
            stockDateMapID = rs.getInt("stock_dt_map_id");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
        
        }
        return stockDateMapID;
    }
    
    public void insertStockSummaryData(StockSummary stockSummary){
        String sql = "INSERT INTO STOCK_TICKER (PREV_CLOSE_PRICE,"
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
                + " ONE_YEAR_TARGET,"
                + " STOCK_DT_MAP_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setBigDecimal(1, stockSummary.getPrevClosePrice());
            pstmt.setBigDecimal(2, stockSummary.getOpenPrice());
            pstmt.setBigDecimal(3, stockSummary.getBidPrice());
            pstmt.setBigDecimal(4, stockSummary.getAskPrice());
            pstmt.setBigDecimal(5, stockSummary.getDaysRangeMax());
            pstmt.setBigDecimal(6, stockSummary.getDaysRangeMin());
            pstmt.setBigDecimal(7, stockSummary.getFiftyTwoWeeksMax());
            pstmt.setBigDecimal(8, stockSummary.getFiftyTwoWeeksMin());
            pstmt.setLong(9,stockSummary.getVolume());
            pstmt.setLong(10,stockSummary.getAvgVolume());
            pstmt.setBigDecimal(11,stockSummary.getMarketCap());
            pstmt.setBigDecimal(12,stockSummary.getBetaCoefficient());
            pstmt.setBigDecimal(13,stockSummary.getPeRatio());
            pstmt.setBigDecimal(14,stockSummary.getEps());
            pstmt.setString(15,stockSummary.getEarningDate());
            pstmt.setBigDecimal(16,stockSummary.getDividentYield());
            pstmt.setString(17,stockSummary.getExDividentDate());
            pstmt.setBigDecimal(18,stockSummary.getOneYearTargetEst());
            pstmt.setLong(19,stockSummary.getStockDtMapId());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
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
        } finally {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
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
