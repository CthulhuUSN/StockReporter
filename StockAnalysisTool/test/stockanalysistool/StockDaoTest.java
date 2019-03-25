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
 * @author jasonarvidson
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
     * Test of insertStockHistoricalData method, of class StockDao.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        StockHistorical historicalData = null;
        StockDao instance = new StockDao();
        instance.insertStockHistoricalData(historicalData);
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

    /**
     * Test of selectAll method, of class StockDao.
     */
    @Test
    public void testSelectAll() {
        System.out.println("selectAll");
        StockDao instance = new StockDao();
        instance.selectAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
