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
public class StockDaoTest {
    
    public StockDaoTest() {
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
     * Test of getInstance method, of class StockDao.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        StockDao expResult = null;
        StockDao result = StockDao.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of connect method, of class StockDao.
     */
    @Test
    public void testConnect() {
        System.out.println("connect");
        StockDao instance = new StockDao();
        instance.connect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStockTickerData method, of class StockDao.
     */
    @Test
    public void testSetStockTickerData() {
        System.out.println("setStockTickerData");
        String stockName = "";
        String stockSymbol = "";
        StockDao instance = new StockDao();
        instance.setStockTickerData(stockName, stockSymbol);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertStockHistoricalData method, of class StockDao.
     */
    @Test
    public void testInsertStockHistoricalData() {
        System.out.println("insertStockHistoricalData");
        StockHistorical stockHistorical = null;
        StockDao instance = new StockDao();
        instance.insertStockHistoricalData(stockHistorical);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertStockSummaryData method, of class StockDao.
     */
    @Test
    public void testInsertStockSummaryData() {
        System.out.println("insertStockSummaryData");
        StockSummary stockSummary = null;
        StockDao instance = new StockDao();
        instance.insertStockSummaryData(stockSummary);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStockHistoricalData method, of class StockDao.
     */
    @Test
    public void testUpdateStockHistoricalData() {
        System.out.println("updateStockHistoricalData");
        StockHistorical stockHistorical = null;
        StockDao instance = new StockDao();
        instance.updateStockHistoricalData(stockHistorical);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStockSummaryData method, of class StockDao.
     */
    @Test
    public void testUpdateStockSummaryData() {
        System.out.println("updateStockSummaryData");
        StockSummary stockSummary = null;
        StockDao instance = new StockDao();
        instance.updateStockSummaryData(stockSummary);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvgStockSummaryView method, of class StockDao.
     */
    @Test
    public void testGetAvgStockSummaryView() {
        System.out.println("getAvgStockSummaryView");
        StockDao instance = new StockDao();
        instance.getAvgStockSummaryView();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvgStockHistoricalView method, of class StockDao.
     */
    @Test
    public void testGetAvgStockHistoricalView() {
        System.out.println("getAvgStockHistoricalView");
        StockDao instance = new StockDao();
        instance.getAvgStockHistoricalView();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAll method, of class StockDao.
     */
    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        StockDao instance = new StockDao();
        instance.deleteAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
