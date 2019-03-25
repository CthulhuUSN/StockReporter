/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockanalysistool;

import java.util.Date;
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
public class StockSummaryTest {
    
    public StockSummaryTest() {
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
     * Test of getSummaryId method, of class StockSummary.
     */
    @Test
    public void testGetSummaryId() {
        System.out.println("getSummaryId");
        StockSummary instance = new StockSummary();
        int expResult = 0;
        int result = instance.getSummaryId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSummaryId method, of class StockSummary.
     */
    @Test
    public void testSetSummaryId() {
        System.out.println("setSummaryId");
        int summaryId = 0;
        StockSummary instance = new StockSummary();
        instance.setSummaryId(summaryId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrevClosePrice method, of class StockSummary.
     */
    @Test
    public void testGetPrevClosePrice() {
        System.out.println("getPrevClosePrice");
        StockSummary instance = new StockSummary();
        int expResult = 0;
        int result = instance.getPrevClosePrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrevClosePrice method, of class StockSummary.
     */
    @Test
    public void testSetPrevClosePrice() {
        System.out.println("setPrevClosePrice");
        int prevClosePrice = 0;
        StockSummary instance = new StockSummary();
        instance.setPrevClosePrice(prevClosePrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOpenPrice method, of class StockSummary.
     */
    @Test
    public void testGetOpenPrice() {
        System.out.println("getOpenPrice");
        StockSummary instance = new StockSummary();
        float expResult = 0.0F;
        float result = instance.getOpenPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOpenPrice method, of class StockSummary.
     */
    @Test
    public void testSetOpenPrice() {
        System.out.println("setOpenPrice");
        float openPrice = 0.0F;
        StockSummary instance = new StockSummary();
        instance.setOpenPrice(openPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBidPrice method, of class StockSummary.
     */
    @Test
    public void testGetBidPrice() {
        System.out.println("getBidPrice");
        StockSummary instance = new StockSummary();
        float expResult = 0.0F;
        float result = instance.getBidPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBidPrice method, of class StockSummary.
     */
    @Test
    public void testSetBidPrice() {
        System.out.println("setBidPrice");
        float bidPrice = 0.0F;
        StockSummary instance = new StockSummary();
        instance.setBidPrice(bidPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAskPrice method, of class StockSummary.
     */
    @Test
    public void testGetAskPrice() {
        System.out.println("getAskPrice");
        StockSummary instance = new StockSummary();
        float expResult = 0.0F;
        float result = instance.getAskPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAskPrice method, of class StockSummary.
     */
    @Test
    public void testSetAskPrice() {
        System.out.println("setAskPrice");
        float askPrice = 0.0F;
        StockSummary instance = new StockSummary();
        instance.setAskPrice(askPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDaysRange method, of class StockSummary.
     */
    @Test
    public void testGetDaysRange() {
        System.out.println("getDaysRange");
        StockSummary instance = new StockSummary();
        int expResult = 0;
        int result = instance.getDaysRange();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDaysRange method, of class StockSummary.
     */
    @Test
    public void testSetDaysRange() {
        System.out.println("setDaysRange");
        int daysRange = 0;
        StockSummary instance = new StockSummary();
        instance.setDaysRange(daysRange);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFiftytwoWeeksRange method, of class StockSummary.
     */
    @Test
    public void testGetFiftytwoWeeksRange() {
        System.out.println("getFiftytwoWeeksRange");
        StockSummary instance = new StockSummary();
        int expResult = 0;
        int result = instance.getFiftytwoWeeksRange();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFiftytwoWeeksRange method, of class StockSummary.
     */
    @Test
    public void testSetFiftytwoWeeksRange() {
        System.out.println("setFiftytwoWeeksRange");
        int fiftytwoWeeksRange = 0;
        StockSummary instance = new StockSummary();
        instance.setFiftytwoWeeksRange(fiftytwoWeeksRange);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVolume method, of class StockSummary.
     */
    @Test
    public void testGetVolume() {
        System.out.println("getVolume");
        StockSummary instance = new StockSummary();
        int expResult = 0;
        int result = instance.getVolume();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVolume method, of class StockSummary.
     */
    @Test
    public void testSetVolume() {
        System.out.println("setVolume");
        int volume = 0;
        StockSummary instance = new StockSummary();
        instance.setVolume(volume);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvgVolume method, of class StockSummary.
     */
    @Test
    public void testGetAvgVolume() {
        System.out.println("getAvgVolume");
        StockSummary instance = new StockSummary();
        int expResult = 0;
        int result = instance.getAvgVolume();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvgVolume method, of class StockSummary.
     */
    @Test
    public void testSetAvgVolume() {
        System.out.println("setAvgVolume");
        int avgVolume = 0;
        StockSummary instance = new StockSummary();
        instance.setAvgVolume(avgVolume);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMarketCap method, of class StockSummary.
     */
    @Test
    public void testGetMarketCap() {
        System.out.println("getMarketCap");
        StockSummary instance = new StockSummary();
        int expResult = 0;
        int result = instance.getMarketCap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMarketCap method, of class StockSummary.
     */
    @Test
    public void testSetMarketCap() {
        System.out.println("setMarketCap");
        int marketCap = 0;
        StockSummary instance = new StockSummary();
        instance.setMarketCap(marketCap);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBetaCoefficient method, of class StockSummary.
     */
    @Test
    public void testGetBetaCoefficient() {
        System.out.println("getBetaCoefficient");
        StockSummary instance = new StockSummary();
        int expResult = 0;
        int result = instance.getBetaCoefficient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBetaCoefficient method, of class StockSummary.
     */
    @Test
    public void testSetBetaCoefficient() {
        System.out.println("setBetaCoefficient");
        int betaCoefficient = 0;
        StockSummary instance = new StockSummary();
        instance.setBetaCoefficient(betaCoefficient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPeRatio method, of class StockSummary.
     */
    @Test
    public void testGetPeRatio() {
        System.out.println("getPeRatio");
        StockSummary instance = new StockSummary();
        int expResult = 0;
        int result = instance.getPeRatio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPeRatio method, of class StockSummary.
     */
    @Test
    public void testSetPeRatio() {
        System.out.println("setPeRatio");
        int peRatio = 0;
        StockSummary instance = new StockSummary();
        instance.setPeRatio(peRatio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEps method, of class StockSummary.
     */
    @Test
    public void testGetEps() {
        System.out.println("getEps");
        StockSummary instance = new StockSummary();
        int expResult = 0;
        int result = instance.getEps();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEps method, of class StockSummary.
     */
    @Test
    public void testSetEps() {
        System.out.println("setEps");
        int eps = 0;
        StockSummary instance = new StockSummary();
        instance.setEps(eps);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEarningDate method, of class StockSummary.
     */
    @Test
    public void testGetEarningDate() {
        System.out.println("getEarningDate");
        StockSummary instance = new StockSummary();
        int expResult = 0;
        int result = instance.getEarningDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEarningDate method, of class StockSummary.
     */
    @Test
    public void testSetEarningDate() {
        System.out.println("setEarningDate");
        int earningDate = 0;
        StockSummary instance = new StockSummary();
        instance.setEarningDate(earningDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDividendYield method, of class StockSummary.
     */
    @Test
    public void testGetDividendYield() {
        System.out.println("getDividendYield");
        StockSummary instance = new StockSummary();
        int expResult = 0;
        int result = instance.getDividendYield();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDividendYield method, of class StockSummary.
     */
    @Test
    public void testSetDividendYield() {
        System.out.println("setDividendYield");
        int dividendYield = 0;
        StockSummary instance = new StockSummary();
        instance.setDividendYield(dividendYield);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExDividendDate method, of class StockSummary.
     */
    @Test
    public void testGetExDividendDate() {
        System.out.println("getExDividendDate");
        StockSummary instance = new StockSummary();
        Date expResult = null;
        Date result = instance.getExDividendDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExDividendDate method, of class StockSummary.
     */
    @Test
    public void testSetExDividendDate() {
        System.out.println("setExDividendDate");
        Date exDividendDate = null;
        StockSummary instance = new StockSummary();
        instance.setExDividendDate(exDividendDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOneYearTargetEst method, of class StockSummary.
     */
    @Test
    public void testGetOneYearTargetEst() {
        System.out.println("getOneYearTargetEst");
        StockSummary instance = new StockSummary();
        Date expResult = null;
        Date result = instance.getOneYearTargetEst();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOneYearTargetEst method, of class StockSummary.
     */
    @Test
    public void testSetOneYearTargetEst() {
        System.out.println("setOneYearTargetEst");
        Date oneYearTargetEst = null;
        StockSummary instance = new StockSummary();
        instance.setOneYearTargetEst(oneYearTargetEst);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
