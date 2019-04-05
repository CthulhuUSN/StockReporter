/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockreporter.scrappers;

import org.junit.Test;
import static org.junit.Assert.*;
import stockreporter.daomodels.StockTicker;

/**
 *
 * @author klacayo
 */
public class YahooScraperTest {
    
    public YahooScraperTest() {
    }
    /**
     * Test of scrapeAllSummaryData method, of class YahooScraper.
     */
    @Test
    public void testScrapeAllSummaryData() {
        YahooScraper instance = new YahooScraper();
        instance.scrapeAllSummaryData();
        
    }

    /**
     * Test of scapeSingleSummaryData method, of class YahooScraper.
     */
    @Test
    public void testScapeSingleSummaryData() {
        StockTicker stockTicker = new StockTicker();
        YahooScraper instance = new YahooScraper();
        instance.scapeSingleSummaryData(stockTicker);
        
    }
    
    
    
}
