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
public class Database {
    private Connection conn = null;
    
    public void connect() {
        try {
            String url = "jdbc:sqlite:stocksdb.sqlite";
            conn = DriverManager.getConnection(url);            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
    
    public void insert(HistoricalData historicalData){
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
            connect();
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
            disconnect();
        }
    }
    private void disconnect(){
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
