package com.stock.reporter.util;

import java.util.ArrayList;
import java.util.List;

import com.stock.reporter.domain.StockTicker;
import com.stock.reporter.service.StockTickerService;

/**
 * Utility to initialize stock ticker with initial stocks
 * @date Mar 18, 2019
 */
public class StockTickerInitialStocks {

	private List<StockTicker> tickerList = new ArrayList<StockTicker>();
	private StockTickerService stockTickerService = null;
	private StockTicker ticker = null;
	
	/**
	 * Initialize data
	 */
	private void initializeData() {
		ticker = new StockTicker();
		ticker.setSymbol("MSFT");
		ticker.setName("Microsoft Corporation");
		tickerList.add(ticker);
		
		ticker = new StockTicker();
		ticker.setSymbol("AAPL");
		ticker.setName("Apple Inc.");
		tickerList.add(ticker);
		
		ticker = new StockTicker();
		ticker.setSymbol("GOOG");
		ticker.setName("Alphabet Inc.");
		tickerList.add(ticker);
		
		ticker = new StockTicker();
		ticker.setSymbol("BA");
		ticker.setName("The Boeing Company");
		tickerList.add(ticker);
		
		ticker = new StockTicker();
		ticker.setSymbol("NFLX");
		ticker.setName("Netflix Inc.");
		tickerList.add(ticker);
		
		ticker = new StockTicker();
		ticker.setSymbol("AMAZ");
		ticker.setName("Amazon.com Inc.");
		tickerList.add(ticker);
		
		ticker = new StockTicker();
		ticker.setSymbol("FB");
		ticker.setName("Facebook Inc.");
		tickerList.add(ticker);
		
		ticker = new StockTicker();
		ticker.setSymbol("CSCO");
		ticker.setName("Cisco Systems Inc.");
		tickerList.add(ticker);
		
		ticker = new StockTicker();
		ticker.setSymbol("TSLA");
		ticker.setName("Tesla Inc.");
		tickerList.add(ticker);
		
		ticker = new StockTicker();
		ticker.setSymbol("TIF");
		ticker.setName("Tiffany & Co.");
		tickerList.add(ticker);
	}
	
	public void insertInitialStocks() {
		
		System.out.println("Initialize stock ticker data...");
		initializeData();
		
		stockTickerService =  new StockTickerService();
		
		
		for(StockTicker obj: tickerList) {
			
			/**
			 * check initial data in the db table
			 */
			if(stockTickerService.findBySymbol(obj.getSymbol()).getName() != null) {
				System.out.println("Initial data already exist in STOCK_TICKER table?");
				return;
			}
			System.out.println("Inserting record for " + obj.getName());
			stockTickerService.insert(obj);
		}
		System.out.println("Initialize stock ticker data insertion completed...");
	}
	
	public static void main(String[] args) {
		StockTickerInitialStocks initObj = new StockTickerInitialStocks();
		initObj.insertInitialStocks();
	}
}