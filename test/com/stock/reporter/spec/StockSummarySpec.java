
package com.stock.reporter.spec;

import org.junit.jupiter.api.Test;

import com.stock.reporter.domain.StockSummary;

/**
 * Test cases for stock summary
 * @date Mar 18, 2019
 *
 */
class StockSummarySpec {

	StockSummary stockSummary = null;
	
	public StockSummarySpec() {
		
	}
	
	@Test
	void insertYahooData() {
		stockSummary = new StockSummary();
	}
	
	@Test
	void insertInvestopediaData() {
		stockSummary = new StockSummary();
	}

}
