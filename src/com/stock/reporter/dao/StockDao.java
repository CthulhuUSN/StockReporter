package com.stock.reporter.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Data implementation
 * @date Mar 17, 2019
 */
public class StockDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * <TODO> remove this method later
	 * Sample to test db connection and SQL
	 */
	public void selectFromStockTicker() {
		
		try {
			Statement stmt = DBConnect.getInstance().createStatement();
			ResultSet rs = stmt.executeQuery("select * from stock_ticker");
			while(rs.next()) {
				System.out.println(rs.getInt("TICKER_ID"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * <TODO> remove this method later
	 * To test db connection.
	 */
    public static void main(String ar[]) {
    	StockDao obj = new StockDao();
    	obj.selectFromStockTicker();
    }
}