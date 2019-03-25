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
    private String datbaseUrl = "jdbc:sqlite:stocksdb.sqlite";
    private String databasePath;
    
    public static StockDao getInstance(){
        if(instance == null){
            instance = new StockDao();
        }
        return instance;
    }
    
    public void connect() {   //Connects to the database
        try {
            conn = DriverManager.getConnection(datbaseUrl);            
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
    
    public void insert(StockHistorical historicalData){
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
            pstmt.setString(1, historicalData.getSymbol());
            pstmt.setString(2, historicalData.getSource());
            pstmt.setString(3, historicalData.getDate());
            pstmt.setString(4, historicalData.getOpen());
            pstmt.setString(5, historicalData.getHigh());
            pstmt.setString(6, historicalData.getLow());
            pstmt.setString(7, historicalData.getClose());
            pstmt.setString(8, historicalData.getAdjusted_close());
            pstmt.setString(9, historicalData.getVolume());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            disconnect(); //<--DISCONNECTS FROM DATABASE AFTER COMPLETING THE OPERATION
        }
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
    
    public void selectAll(){
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
    }
}
