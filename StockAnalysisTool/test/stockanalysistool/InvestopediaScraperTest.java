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
public class InvestopediaScraperTest {
    
    public InvestopediaScraperTest() {
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
     * Test of scrape method, of class InvestopediaScraper.
     */
    @Test
    public void testScrape() {
        System.out.println("scrape");
        InvestopediaScraper instance = new InvestopediaScraper();
        instance.scrape();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scapeSingleHistoricalTables method, of class InvestopediaScraper.
     */
    @Test
    public void testScapeSingleHistoricalTables() {
        System.out.println("scapeSingleHistoricalTables");
        String symbolString = "";
        InvestopediaScraper instance = new InvestopediaScraper();
        instance.scapeSingleHistoricalTables(symbolString);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
