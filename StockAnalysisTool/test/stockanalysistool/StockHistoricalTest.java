/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockanalysistool;

import java.util.Date;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;


public class StockHistoricalTest {
    
    StockHistorical master;
    
    public StockHistoricalTest() {
        master = new StockHistorical();
        master.setAdjClose(1);
        master.setClose(1);
        master.setHigh(1);
        master.setHistoricalId(1);
        master.setLow(1);
        master.setVolume(1);
        master.setOpen(1);
    }

    /**
     * Test of getHistoricalId method, of class StockHistorical.
     */
    @Test
    public void testGetHistoricalId() {
        System.out.println("getHistoricalId");
        StockHistorical instance;
        instance = master;
        int expResult = 1;
        int result = instance.getHistoricalId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHistoricalId method, of class StockHistorical.
     */
    @Test
    public void testSetHistoricalId() {
        System.out.println("setHistoricalId");
        int historicalId = 1;
        StockHistorical instance = new StockHistorical();
        instance.setHistoricalId(historicalId);
        assertEquals(master.getHistoricalId(), instance.getHistoricalId());
    }

    /**
     * Test of getOpen method, of class StockHistorical.
     */
    @Test
    public void testGetOpen() {
        System.out.println("getOpen");
        StockHistorical instance;
        instance = master;
        int expResult = 1;
        int result = instance.getOpen();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOpen method, of class StockHistorical.
     */
    @Test
    public void testSetOpen() {
        System.out.println("setOpen");
        int open = 1;
        StockHistorical instance = new StockHistorical();
        instance.setOpen(open);
        assertEquals(master.getOpen(), instance.getOpen());
    }

    /**
     * Test of getHigh method, of class StockHistorical.
     */
    @Test
    public void testGetHigh() {
        System.out.println("getHigh");
        StockHistorical instance;
        instance = master;
        int expResult = 1;
        int result = instance.getHigh();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHigh method, of class StockHistorical.
     */
    @Test
    public void testSetHigh() {
        System.out.println("setHigh");
        int high = 1;
        StockHistorical instance = new StockHistorical();
        instance.setHigh(high);
        assertEquals(master.getHigh(), instance.getHigh());
    }

    /**
     * Test of getLow method, of class StockHistorical.
     */
    @Test
    public void testGetLow() {
        System.out.println("getLow");
        StockHistorical instance;
        instance = master;
        int expResult = 1;
        int result = instance.getLow();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLow method, of class StockHistorical.
     */
    @Test
    public void testSetLow() {
        System.out.println("setLow");
        int low = 1;
        StockHistorical instance = new StockHistorical();
        instance.setLow(low);
        assertEquals(master.getLow(), instance.getLow());
    }

    /**
     * Test of getClose method, of class StockHistorical.
     */
    @Test
    public void testGetClose() {
        System.out.println("getClose");
        StockHistorical instance;
        instance = master;
        int expResult = 1;
        int result = instance.getClose();
        assertEquals(expResult, result);
    }

    /**
     * Test of setClose method, of class StockHistorical.
     */
    @Test
    public void testSetClose() {
        System.out.println("setClose");
        int close = 1;
        StockHistorical instance = new StockHistorical();
        instance.setClose(close);
        assertEquals(master.getClose(), instance.getClose());
    }

    /**
     * Test of getAdjClose method, of class StockHistorical.
     */
    @Test
    public void testGetAdjClose() {
        System.out.println("getAdjClose");
        StockHistorical instance;
        instance = master;
        int expResult = 1;
        int result = instance.getAdjClose();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdjClose method, of class StockHistorical.
     */
    @Test
    public void testSetAdjClose() {
        System.out.println("setAdjClose");
        int adjClose = 1;
        StockHistorical instance = new StockHistorical();
        instance.setAdjClose(adjClose);
        assertEquals(master.getAdjClose(), instance.getAdjClose());
    }

    /**
     * Test of getVolume method, of class StockHistorical.
     */
    @Test
    public void testGetVolume() {
        System.out.println("getVolume");
        StockHistorical instance;
        instance = master;
        int expResult = 1;
        int result = instance.getVolume();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVolume method, of class StockHistorical.
     */
    @Test
    public void testSetVolume() {
        System.out.println("setVolume");
        int volume = 1;
        StockHistorical instance = new StockHistorical();
        instance.setVolume(volume);
        assertEquals(master.getVolume(), instance.getVolume());
    }
    
}
