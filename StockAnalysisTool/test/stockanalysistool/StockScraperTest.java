/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockanalysistool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ArvidsJE
 */
public class StockScraperTest {
    
    public StockScraperTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of scrapeAllSummaryData method, of class StockScraper.
     */
    @Test
    public void testScrapeAllSummaryData() {
        System.out.println("scrapeAllSummaryData");
        StockScraper instance = new StockScraper();
        instance.scrapeAllSummaryData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scrapeAllHistoricalData method, of class StockScraper.
     */
    @Test
    public void testScrapeAllHistoricalData() {
        System.out.println("scrapeAllHistoricalData");
        StockScraper instance = new StockScraper();
        instance.scrapeAllHistoricalData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
