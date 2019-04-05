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
    YahooScraper instance;
    public YahooScraperTest() {
    instance = new YahooScraper();    
    }
    /**
     * Test of scrapeAllSummaryData method, of class YahooScraper.
     */
    @Test
    public void testScrapeAllSummaryData() {
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
