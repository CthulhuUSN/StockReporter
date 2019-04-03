/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockreporter;

import stockreporter.daomodels.StockHistorical;
import stockreporter.daomodels.StockSummary;
import stockreporter.daomodels.StockDateMap;
import stockreporter.daomodels.StockTicker;
import stockreporter.StockDao;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.assertNotNull;

public class StockDaoTest {
    
    StockDao dao;
    
    public StockDaoTest() {}
    
    /**
     * Test of getInstance method, of class StockDao.
     */
    @Test
    public void testGetInstance() {
        StockDao result = StockDao.getInstance();
        assertNotNull(result);
    }

    /**
     * Test of connect method, of class StockDao.
     */
    @Test
    public void testConnect() {
        StockDao instance = StockDao.getInstance();
        instance.connect();
    }

    /**
     * Test of setStockTickerData method, of class StockDao.
     */
    @Test
    public void testSetStockTickerData() {
        String stockName = "";
        String stockSymbol = "";
        StockDao instance = StockDao.getInstance();
        instance.setStockTickerData(stockName, stockSymbol);
    }


    /**
     * Test of insertStockSummaryData method, of class StockDao.
     */
    @Test
    public void testInsertStockSummaryData() {
        StockSummary stockSummary = null;
        StockDao instance = StockDao.getInstance();
        instance.insertStockSummaryData(stockSummary);
    }

    /**
     * Test of getAvgStockSummaryView method, of class StockDao.
     */
    @Test
    public void testGetAvgStockSummaryView() {
        StockDao instance = StockDao.getInstance();
        instance.getAvgStockSummaryView();
    }

    /**
     * Test of deleteAll method, of class StockDao.
     */
    @Test
    public void testDeleteAll() {
        StockDao instance = StockDao.getInstance();
        instance.deleteAll();
    }

    @Test
    public void testDatabaseAlreadyInitialized() {
    }

    @Test
    public void testGetAllstockTickers() {
    }

    @Test
    public void testSetStockSource() {
    }

    @Test
    public void testInsertStockDateMap() {
    }

    @Test
    public void testGetStockDateMapID() {
    }
    
}
