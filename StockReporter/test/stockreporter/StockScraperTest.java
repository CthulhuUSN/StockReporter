/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockreporter;

import stockreporter.StockScraper;
import java.util.Date;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;

/**
 *
 * @author ArvidsJE
 */
public class StockScraperTest {
    
    public StockScraperTest() {
    }

    /**
     * Test of scrapeAllSummaryData method, of class StockScraper.
     */
    @Test
    public void testScrapeAllSummaryData() {
        System.out.println("scrapeAllSummaryData");
        StockScraper instance = new StockScraper();
        instance.scrapeAllSummaryData();
    }

    /**
     * Test of scrapeAllHistoricalData method, of class StockScraper.
     */
    
}
