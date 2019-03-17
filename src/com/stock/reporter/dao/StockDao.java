package com.stock.reporter.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Data implementation
 * @date Mar 17, 2019
 */
public class StockDao implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Connection connect = null;
	private static StockDao instance = null;
	
	/**
	 * Initialize database connection
	 */
	private StockDao() {
		try {
            String url = "jdbc:sqlite:stockreporter.db";
            connect = DriverManager.getConnection(url);  
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	/**
	 * get database connection instance
	 * @return db connection instance
	 */
	public static StockDao getInstance() {
		if(instance == null) {
			instance = new StockDao();
		}
		return instance;
	}
	
    private void disconnect(){
        try {
            if (connect != null) {
            	connect.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}