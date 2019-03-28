/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockanalysistool;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;

public final class StockDao {
    private static StockDao instance = null;
    private Connection conn = null;
    private static String databaseName = "stocksdb.sqlite";
    private static String databaseUrl = "jdbc:sqlite:stocksdb.sqlite";
    
    public StockDao(){
        
        //check to see if the DB already exists
        File file = new File(databaseName);
        if (!file.exists()) {
        //Create the database
        this.connect();
        
        try {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("The database has been created");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        ArrayList<String> sqlStrings = new ArrayList<String>();
        
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
        
        this.disconnect();
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
            conn = DriverManager.getConnection(databaseUrl);            
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
    
    public void setStockTickerData(String stockName, String stockSymbol){}
    
    public void insertStockHistoricalData(StockHistorical stockHistorical){
        //Commenting this out until we get to the historical data part of the project. -Jason
        /*
        String sql = "INSERT INTO "+Constants.TABLE_STOCKS+" ("
                + Constants.FIELD_SYMBOL + ","
                + Constants.FIELD_SOURCE + ","
                + Constants.FIELD_DATE + ","
                + Constants.FIELD_OPEN + ","
                + Constants.FIELD_HIGH + ","
                + Constants.FIELD_LOW + ","
                + Constants.FIELD_CLOSE + ","
                + Constants.FIELD_ADJUSTED_CLOSE + ","
                + Constants.FIELD_VOLUME + ")"
                + " values (?,?,?,?,?,?,?,?,?)";
        try{
            connect(); //<--CONNECTS TO DATABASE BEFORE STARTING AN OPERATION
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, stockHistorical.getSymbol());
            pstmt.setString(2, stockHistorical.getSource());
            pstmt.setDate(3, stockHistorical.getDate());
            pstmt.setInt(4, stockHistorical.getOpen());
            pstmt.setInt(5, stockHistorical.getHigh());
            pstmt.setInt(6, stockHistorical.getLow());
            pstmt.setInt(7, stockHistorical.getClose());
            pstmt.setInt(8, stockHistorical.getAdjClose());
            pstmt.setInt(9, stockHistorical.getVolume());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            disconnect(); //<--DISCONNECTS FROM DATABASE AFTER COMPLETING THE OPERATION
        }
        */
    }
    
    public void insertStockSummaryData(StockSummary stockSummary){}
    
    public void updateStockHistoricalData(StockHistorical stockHistorical){}
    
    public void updateStockSummaryData(StockSummary stockSummary){}
    
    public void getAvgStockSummaryView(){}
    
    public void getAvgStockHistoricalView(){
    //Moved this here from selectAll() to keep the class organized and to keep the code - Jason
    //Commenting this out until we get to the historical data part of the project -Jason
    /*
        String sql = "SELECT "+Constants.FIELD_ID+", "
                +Constants.FIELD_SYMBOL+", "
                +Constants.FIELD_SOURCE+", "
                +Constants.FIELD_DATE+", "
                +Constants.FIELD_OPEN+", "
                +Constants.FIELD_HIGH+", "
                +Constants.FIELD_LOW+", "
                +Constants.FIELD_CLOSE+", "
                +Constants.FIELD_ADJUSTED_CLOSE+", "
                +Constants.FIELD_VOLUME
                +" FROM "+Constants.TABLE_STOCKS;
        try{
            connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt(Constants.FIELD_ID) + "\t" 
                        +  rs.getString(Constants.FIELD_SYMBOL)  + "\t" 
                        +  rs.getString(Constants.FIELD_DATE)  + "\t" 
                        +  rs.getString(Constants.FIELD_OPEN)  + "\t" 
                        +  rs.getString(Constants.FIELD_HIGH)  + "\t" 
                        +  rs.getString(Constants.FIELD_LOW)  + "\t" 
                        +  rs.getString(Constants.FIELD_CLOSE)  + "\t" 
                        +  rs.getString(Constants.FIELD_ADJUSTED_CLOSE)  + "\t" 
                        +  rs.getString(Constants.FIELD_VOLUME)
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            disconnect();
        }
    */
    }
    
    public void deleteAll(){
        String sql ="DELETE FROM "+ Constants.TABLE_STOCKS;
        try{
            connect();
            Statement stmt  = conn.createStatement();
            stmt.executeQuery(sql);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            disconnect();
        }
    }
    
}
