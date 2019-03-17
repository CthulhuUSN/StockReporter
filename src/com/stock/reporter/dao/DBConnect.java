package com.stock.reporter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection
 * @date Mar 17, 2019
 *
 */
public class DBConnect {

	private static Connection connect = null;

	/**
	 * Entablish database connection
	 */
	static {
		try {
            String url = "jdbc:sqlite:stockreporter.db";
            connect = DriverManager.getConnection(url);  
            System.out.println("Connection to SQLite has been established.");
        } catch(SQLException ex) {
        	System.out.println(ex.getMessage());
        }
	}
	
	/**
	 * private constructor to prevent class instance.
	 */
	private DBConnect() {
		
	}
	
	/**
	 * get database connection instance
	 * @return connection instance
	 */
	public static Connection getInstance() {
		 return connect;
	}
	
	/**
	 * Disconnect the connection
	 */
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
