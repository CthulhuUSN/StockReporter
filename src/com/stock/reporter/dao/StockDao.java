package com.stock.reporter.dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.stock.reporter.db.table.constant.StockSummaryTblCol;
import com.stock.reporter.db.table.constant.StockTickerTblCol;
import com.stock.reporter.domain.StockDateMap;
import com.stock.reporter.domain.StockHistorical;
import com.stock.reporter.domain.StockSource;
import com.stock.reporter.domain.StockSummary;
import com.stock.reporter.domain.StockTicker;

/**
 * Data Access Layer implementation implementation
 * @date Mar 17, 2019
 */
public class StockDao implements Serializable {

	private static final long serialVersionUID = 1L;
	StringBuilder builder = null;
	PreparedStatement pstmt = null;
	
	/**
	 * Generic save method for all classes
	 * @param object
	 * @return
	 */
	public <T> int insert(T object) {
		int result = 0;
		if(object instanceof StockSummary) {
			result = insertStockSummary((StockSummary)object);
		}else if(object instanceof StockHistorical) {
			
		}else if(object instanceof StockTicker) {
			result = insertStockTicker((StockTicker)object);
		}else if(object instanceof StockSource) {
			
		}else if(object instanceof StockDateMap) {
			
		}
		
		return result;
	}
	
	/**
	 * Insert method for a stock summary class
	 * @param obj
	 * @return
	 */
	public <T> int insertStockSummary(StockSummary obj) {
		int result = 0;
		builder = new StringBuilder();
	
		builder.append("INSERT INTO STOCK_SUMMARY (");
		
		
		for(StockSummaryTblCol col: StockSummaryTblCol.values()) {
			builder.append(col + ",");
		}
		//remove last extra comma
		builder.setLength(builder.length()-1);
		
		builder.append(") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		System.out.println(builder.toString());
		
		try {
			pstmt = DBConnect.getInstance().prepareStatement(builder.toString());
			
			pstmt.setFloat(1, obj.getPrevClosePrice());
			pstmt.setFloat(2, obj.getOpenPrice());
			pstmt.setFloat(3, obj.getBidPrice());
			pstmt.setFloat(4, obj.getAskPrice());
			pstmt.setFloat(5, obj.getDaysRangeMin());
			pstmt.setFloat(6, obj.getDaysRangeMax());
			pstmt.setFloat(7, obj.getFiftyTwoWeeksMin());
			pstmt.setFloat(8, obj.getFiftyTwoWeeksMax());
			pstmt.setFloat(9, obj.getVolume());
			pstmt.setFloat(10, obj.getAvgVolume());
			pstmt.setFloat(11, obj.getMarketCap());
			pstmt.setFloat(12, obj.getBetaCoefficient());
			pstmt.setFloat(13, obj.getPeRatio());
			pstmt.setFloat(14, obj.getEps());
			pstmt.setString(15, obj.getEarningDate());
			pstmt.setFloat(16, obj.getDividentYield());
			pstmt.setString(17, obj.getExDividentDate());
			pstmt.setFloat(18, obj.getOneYearTargetEst());
			pstmt.setLong(19,  obj.getStockDtMapId());
			result = pstmt.executeUpdate();
			
			System.out.println("Record inserted with id " + obj.getSummaryId());
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			DBConnect.disconnect();
		}
		return result;
	}
	
	/**
	 * Insert method for a stock historical class
	 * @param obj
	 * @return
	 */
	public <T> int insertStockHistorical(StockHistorical obj) {
		int result = 0;
		
		return result;
	}
	
	/**
	 * Insert method for a stock ticker class
	 * @param obj
	 * @return
	 */
	public <T> int insertStockTicker(StockTicker obj) {
		int result = 0;
		builder = new StringBuilder();
		
		builder.append("INSERT INTO STOCK_TICKER (");
		for(StockTickerTblCol col: StockTickerTblCol.values()) {
			builder.append(col + ",");
		}
		//remove last extra comma
		builder.setLength(builder.length()-1);
		
		builder.append(") VALUES (?,?)");
		
		System.out.println(builder.toString());
		
		try {
			pstmt = DBConnect.getInstance().prepareStatement(builder.toString());
			pstmt.setString(1, obj.getSymbol());
			pstmt.setString(2, obj.getName());
			result = pstmt.executeUpdate();
			
			System.out.println("Record inserted with id " + obj.getTickerId());
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			DBConnect.disconnect();
		}
		
		return result;
	}
	
	/**
	 * Insert method for a stock source class
	 * @param obj
	 * @return
	 */
	public <T> int insertStockSource(StockSource obj) {
		int result = 0;
		
		return result;
	}
	
	/**
	 * Insert method for a stock date mapper class
	 * @param obj
	 * @return
	 */
	public <T> int insertStockDateMap(StockDateMap obj) {
		int result = 0;
		
		return result;
	}
	
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
    	StockSummary summary = new StockSummary();
    	summary.setSummaryId(100);
    	summary.setPrevClosePrice(15.21f);
    	summary.setEarningDate("2019-05-12");

    	System.out.println(obj.insert(summary));
    	//obj.selectFromStockTicker();
    }
}