package com.stock.reporter.service;

import com.stock.reporter.domain.StockHistorical;
import com.stock.reporter.domain.StockSummary;

/**
 * Abstract class for stock scraper
 * @date Mar 17, 2019
 */
public abstract class StockScraper {

	public abstract int insertSummaryData(StockSummary stockSummary);
	
	public abstract int insertHistoricalData(StockHistorical stockHistorical);
}
