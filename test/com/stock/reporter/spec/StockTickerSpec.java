
package com.stock.reporter.spec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

import com.stock.reporter.domain.StockTicker;
import com.stock.reporter.service.StockTickerService;

import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * Test cases for stock ticker
 * @date Mar 18, 2019
 *
 */
class StockTickerSpec {

	private StockTicker stockTicker = null;
	private StockTickerService stockTickerService = null;
	
	public StockTickerSpec() {
		stockTicker = new StockTicker();
		stockTickerService =  new StockTickerService();
	}
	
	@DisplayName("Insert StockTicker data")
	@Test
	void insertData() {
		stockTicker.setSymbol("MSFT");
		stockTicker.setName("Microsoft");
		int result = stockTickerService.insert(stockTicker, false);
		
		assertTrue(() -> result == 1, "Insert opoeration failed for ticker id:" + stockTicker.getTickerId());
	}
	
	@DisplayName("Delete StockTicker data")
	@Ignore
	@Test
	void deleteData() {
		
	}

}
