/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockreporter;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import stockreporter.daomodels.StockHistorical;
import stockreporter.daomodels.StockSummary;
import stockreporter.daomodels.StockDateMap;
import stockreporter.daomodels.StockTicker;
import stockreporter.StockDao;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;
import stockreporter.daomodels.StockSummary;
import stockreporter.daomodels.StockTicker;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import stockreporter.daomodels.StockDateMap;
import static org.junit.Assert.assertNotNull;

public class StockDaoTest {
    
    StockDao dao;
    private String url = "jdbc:sqlite:stockreporter.prod";
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
        StockDao instance = StockDao.getInstance();
        String tableName= null;
        instance.databaseAlreadyInitialized();
        assertNotNull(tableName);
    }

    @Test
    public void testGetAllstockTickers() {
        StockDao instance = StockDao.getInstance();
        instance.getAllstockTickers();
    }

    @Test
    public void testSetStockSource() {
        StockDao instance = StockDao.getInstance();
        String stocksource = "yahoo";
        instance.setStockSource(stocksource);
    }

    @Test
    public void testInsertStockDateMap() {
        StockDao instance = StockDao.getInstance();
        StockDateMap StockDateMap = null;
        instance.insertStockDateMap(StockDateMap);
    }

    @Test
    public void testGetStockDateMapID() {
        StockDao instance = StockDao.getInstance();
        String Date = "02/19/2019";
        String Symbol = "x";
        String StockSource = "yahoo";
        instance.getStockDateMapID(Date, Symbol, StockSource);
    }
    @Test
    public void testgetStockSourceIdByName(){
        StockDao instance = StockDao.getInstance();
        String name = "test";
        instance.getStockSourceIdByName(name);
    }
    @Test
    public void testdeleteFromStockSource(){
        StockDao instance = StockDao.getInstance();
        instance.deleteFromStockSource();
    }
    @Test
    public void testdeleteFromStockTicker () {
        StockDao instance = StockDao.getInstance();
        instance.deleteFromStockTicker();
    }
}
