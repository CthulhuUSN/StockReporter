/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockreporter;

import stockreporter.StockHistorical;
import stockreporter.StockSummary;
import stockreporter.StockDao;
import java.util.Date;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;

public class StockDaoTest {
    
    StockDao dao;
    
    public StockDaoTest() {}
    
    /**
     * Test of getInstance method, of class StockDao.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        StockDao expResult = dao;
        StockDao result = StockDao.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of connect method, of class StockDao.
     */
    @Test
    public void testConnect() {
        System.out.println("connect");
        StockDao instance = StockDao.getInstance();
        instance.connect();
    }

    /**
     * Test of setStockTickerData method, of class StockDao.
     */
    @Test
    public void testSetStockTickerData() {
        System.out.println("setStockTickerData");
        String stockName = "";
        String stockSymbol = "";
        StockDao instance = StockDao.getInstance();
        instance.setStockTickerData(stockName, stockSymbol);
    }

    /**
     * Test of insertStockHistoricalData method, of class StockDao.
     */
    @Test
    public void testInsertStockHistoricalData() {
        System.out.println("insertStockHistoricalData");
        StockHistorical stockHistorical = null;
        StockDao instance = StockDao.getInstance();
        instance.insertStockHistoricalData(stockHistorical);
    }

    /**
     * Test of insertStockSummaryData method, of class StockDao.
     */
    @Test
    public void testInsertStockSummaryData() {
        System.out.println("insertStockSummaryData");
        StockSummary stockSummary = null;
        StockDao instance = StockDao.getInstance();
        instance.insertStockSummaryData(stockSummary);
    }

    /**
     * Test of updateStockHistoricalData method, of class StockDao.
     */
    @Test
    public void testUpdateStockHistoricalData() {
        System.out.println("updateStockHistoricalData");
        StockHistorical stockHistorical = null;
        StockDao instance = StockDao.getInstance();
        instance.updateStockHistoricalData(stockHistorical);
    }

    /**
     * Test of updateStockSummaryData method, of class StockDao.
     */
    @Test
    public void testUpdateStockSummaryData() {
        System.out.println("updateStockSummaryData");
        StockSummary stockSummary = null;
        StockDao instance = StockDao.getInstance();
        instance.updateStockSummaryData(stockSummary);
    }

    /**
     * Test of getAvgStockSummaryView method, of class StockDao.
     */
    @Test
    public void testGetAvgStockSummaryView() {
        System.out.println("getAvgStockSummaryView");
        StockDao instance = StockDao.getInstance();
        instance.getAvgStockSummaryView();
    }

    /**
     * Test of getAvgStockHistoricalView method, of class StockDao.
     */
    @Test
    public void testGetAvgStockHistoricalView() {
        System.out.println("getAvgStockHistoricalView");
        StockDao instance = StockDao.getInstance();
        instance.getAvgStockHistoricalView();
    }

    /**
     * Test of deleteAll method, of class StockDao.
     */
    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        StockDao instance = StockDao.getInstance();
        instance.deleteAll();
    }
    
}
