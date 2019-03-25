/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockanalysistool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Herve Thcoufong
 */
public class StockDao {
    private static StockDao instance = null;
    private Connection conn = null;
    private static String databasePath = "StockAnalysisTool/stocksdb.sqlite";
    private static String databaseUrl = "jdbc:sqlite:stocksdb.sqlite";
    
    public StockDao(){}
    
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
