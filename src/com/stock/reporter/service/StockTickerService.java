package com.stock.reporter.service;

import com.stock.reporter.dao.StockDao;
import com.stock.reporter.domain.StockTicker;

/**
 * Stock ticker service
 * @date Mar 18, 2019
 *
 */
public class StockTickerService {
	StockDao stockDao = null;
	
	/**
	 * Initialize dao object
	 */
	public StockTickerService() {
		stockDao = new StockDao();
	}
	
	/**
	 * Transaction enabled
	 * @param stockTicker
	 * @return
	 */
	public int insert(StockTicker stockTicker) {
		return insert(stockTicker, true);
	}
	
	/**
	 * Transaction flag is set
	 * Will be useful for running unit test cases with transaction off
	 * @param stockTicker
	 * @param isTransactional
	 * @return
	 */
	public int insert(StockTicker stockTicker, boolean isTransactional) {
		
		System.out.println("Inside StockTickerService -> insert");
		int result = stockDao.insert(stockTicker, isTransactional);
		
		return result;
	}
	
	/**
	 * find stock ticker by symbol
	 * @param symbol
	 * @return
	 */
	public StockTicker findBySymbol(String symbol) {
		System.out.println("Inside StockTickerService -> findBySymbol");
		return stockDao.findStockTickerBySymbol(symbol);
	}
	
	/**
	 * find stock ticker by id
	 * @param id
	 * @return
	 */
	public StockTicker findById(long id) {
		System.out.println("Inside StockTickerService -> findById");
		return stockDao.findStockTickerById(id);
	}
}