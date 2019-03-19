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
	
	public StockTickerService() {
		stockDao = new StockDao();
	}
	
	public int insert(StockTicker stockTicker) {
		return insert(stockTicker, true);
	}
	public int insert(StockTicker stockTicker, boolean isTransactional) {
		
		System.out.println("Inside StockTickerService -> insert");
		int result = stockDao.insert(stockTicker, isTransactional);
		
		return result;
	}
}