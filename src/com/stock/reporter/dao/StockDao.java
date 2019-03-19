package com.stock.reporter.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	Connection conn;
	
	/**
	 * Retrieve database connection
	 */
	public StockDao() {
		conn = DBConnect.getInstance(); 
	}
	
	public <T> int insert(T object) {
		return insert(object, true);
	}
	/**
	 * Generic save method for all classes
	 * @param object
	 * @return
	 */
	public <T> int insert(T object, boolean isTransactional) {
		int result = 0;
		if(object instanceof StockSummary) {
			result = insertStockSummary((StockSummary)object, isTransactional);
		}else if(object instanceof StockHistorical) {
			
		}else if(object instanceof StockTicker) {
			result = insertStockTicker((StockTicker)object, isTransactional);
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
	public <T> int insertStockSummary(StockSummary obj, boolean isTransactional) {
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
			if(!isTransactional) {
				conn.setAutoCommit(false);
			}
			pstmt = conn.prepareStatement(builder.toString());
			
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
			
			//Execution success
			if(result == 1)
				System.out.println("Record inserted...");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				if(!isTransactional) {
					conn.rollback();
				}
				
				if(pstmt != null)
					pstmt.close();
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return result;
	}
	
	/**
	 * Insert method for a stock historical class
	 * @param obj
	 * @return
	 */
	public <T> int insertStockHistorical(StockHistorical obj, boolean isTransactional) {
		int result = 0;
		
		return result;
	}
	
	/**
	 * Insert method for a stock ticker class
	 * @param obj
	 * @return
	 */
	public <T> int insertStockTicker(StockTicker obj, boolean isTransactional) {
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
			if(!isTransactional) {
				conn.setAutoCommit(false);
				System.out.println("Autocommit set to false...");
			}
			
			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setString(1, obj.getSymbol());
			pstmt.setString(2, obj.getName());
			result = pstmt.executeUpdate();
			
			//Execution success
			if(result == 1)
				System.out.println("Record inserted...");
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				if(!isTransactional) {
					conn.rollback();
					System.out.println("Transaction rollback...");
				}
				if(pstmt != null)
					pstmt.close();
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		return result;
	}
	
	/**
	 * Insert method for a stock source class
	 * @param obj
	 * @return
	 */
	public <T> int insertStockSource(StockSource obj, boolean isTransactional) {
		int result = 0;
		
		return result;
	}
	
	/**
	 * Insert method for a stock date mapper class
	 * @param obj
	 * @return
	 */
	public <T> int insertStockDateMap(StockDateMap obj, boolean isTransactional) {
		int result = 0;
		
		return result;
	}
	
	/**
	 * find stock ticker by name
	 * @param name
	 * @return
	 */
	public StockTicker findStockTickerBySymbol(String symbol) {
		StockTicker result = null;
		
		builder = new StringBuilder();
		builder.append("SELECT * FROM STOCK_TICKER WHERE SYMBOL=?");
		System.out.println(builder.toString());
		
		try {
			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setString(1,  symbol);
			ResultSet rs = pstmt.executeQuery();
			result = new StockTicker();
			while(rs.next()) {
				result.setTickerId(rs.getLong("TICKER_ID"));
				result.setSymbol(rs.getString("SYMBOL"));
				result.setName(rs.getString("NAME"));
			}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return result;
	}
	
	/**
	 * find stock ticker by id
	 * @param name
	 * @return
	 */
	public StockTicker findStockTickerById(long id) {
		StockTicker result = null;
		
		builder = new StringBuilder();
		builder.append("SELECT * FROM STOCK_TICKER WHERE TICKER_ID=?");
		System.out.println(builder.toString());
		
		try {
			pstmt = conn.prepareStatement(builder.toString());
			pstmt.setLong(1,  id);
			ResultSet rs = pstmt.executeQuery();
			result = new StockTicker();
			while(rs.next()) {
				result.setTickerId(rs.getLong("TICKER_ID"));
				result.setSymbol(rs.getString("SYMBOL"));
				result.setName(rs.getString("NAME"));
			}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				if(pstmt != null)
					pstmt.close();
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return result;
	}
	
	/**
	 * <TODO> remove this method later
	 * To test db connection.
	 */
    public static void main(String ar[]) {
    	StockDao obj = new StockDao();
    	/*StockTicker ticker = new StockTicker();
    	ticker.setSymbol("GOOG");
    	ticker.setName("Google");

    	obj.insert(ticker);*/
    	//obj.selectFromStockTicker();
    	/*StockTicker ticker = obj.findStockTickerBySymbol("MSFT");
    	System.out.println(ticker.toString());*/
    	
    	StockTicker ticker = obj.findStockTickerById(10);
    	System.out.println(ticker.toString());
    }
}