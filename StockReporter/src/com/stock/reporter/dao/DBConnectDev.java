/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stock.reporter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Manage database connection for DEV test data
 */
public class DBConnectDev {
        private static Connection connect = null;

	/**
	 * Establish database connection
	 */
	static {
            try {
                String url = "jdbc:sqlite:stockreporter.dev";
                connect = DriverManager.getConnection(url);  
                System.out.println("Connection to SQLite has been established.");
            } catch(SQLException ex) {
                System.out.println(ex.getMessage());
            }
	}
	
	/**
	 * private constructor to prevent class instance.
	 */
	private DBConnectDev() {
		
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
    public static void disconnect(){
        try {
            if (connect != null) {
            	connect.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
