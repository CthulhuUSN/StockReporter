/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockanalysistool;

import java.util.Date;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

public class StockSummaryTest {
    
    StockSummary master;
    
    public StockSummaryTest() {
        master = new StockSummary();
        master.setAskPrice(1);
        master.setAvgVolume(1);
        master.setBetaCoefficient(1);
        master.setBidPrice(1);
        master.setDaysRange(1);
        master.setDividendYield(1);
        master.setEarningDate(null);
        master.setExDividendDate(null);
        master.setEps(1);
        master.setFiftytwoWeeksRange(1);
        master.setMarketCap(1);
        master.setOneYearTargetEst(null);
        master.setOpenPrice(1);
        master.setPeRatio(1);
        master.setPrevClosePrice(1);
        master.setSummaryId(1);
        master.setVolume(1);
    }
    
    
    /**
     * Test of getSummaryId method, of class StockSummary.
     */
    @Test
    public void testGetSummaryId() {
        System.out.println("getSummaryId");
        StockSummary instance;
        instance = master;
        int expResult = 1;
        int result = instance.getSummaryId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSummaryId method, of class StockSummary.
     */
    @Test
    public void testSetSummaryId() {
        System.out.println("setSummaryId");
        int summaryId = 1;
        StockSummary instance = new StockSummary();
        instance.setSummaryId(summaryId);
        assertEquals(master.getSummaryId(), instance.getSummaryId());
    }

    /**
     * Test of getPrevClosePrice method, of class StockSummary.
     */
    @Test
    public void testGetPrevClosePrice() {
        System.out.println("getPrevClosePrice");
        StockSummary instance;
        instance = master;
        int expResult = 1;
        int result = instance.getPrevClosePrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPrevClosePrice method, of class StockSummary.
     */
    @Test
    public void testSetPrevClosePrice() {
        System.out.println("setPrevClosePrice");
        int prevClosePrice = 1;
        StockSummary instance = new StockSummary();
        instance.setPrevClosePrice(prevClosePrice);
        assertEquals(master.getPrevClosePrice(), instance.getPrevClosePrice());
    }

    /**
     * Test of getOpenPrice method, of class StockSummary.
     */
    @Test
    public void testGetOpenPrice() {
        System.out.println("getOpenPrice");
        StockSummary instance;
        instance = master;
        float expResult = 1.0F;
        float result = instance.getOpenPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setOpenPrice method, of class StockSummary.
     */
    @Test
    public void testSetOpenPrice() {
        System.out.println("setOpenPrice");
        float openPrice = 1.0F;
        StockSummary instance = new StockSummary();
        instance.setOpenPrice(openPrice);
        assertEquals(master.getOpenPrice(), instance.getOpenPrice());
    }

    /**
     * Test of getBidPrice method, of class StockSummary.
     */
    @Test
    public void testGetBidPrice() {
        System.out.println("getBidPrice");
        StockSummary instance;
        instance = master;
        float expResult = 1.0F;
        float result = instance.getBidPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setBidPrice method, of class StockSummary.
     */
    @Test
    public void testSetBidPrice() {
        System.out.println("setBidPrice");
        float bidPrice = 1.0F;
        StockSummary instance = new StockSummary();
        instance.setBidPrice(bidPrice);
        assertEquals(master.getBidPrice(), instance.getBidPrice());
    }

    /**
     * Test of getAskPrice method, of class StockSummary.
     */
    @Test
    public void testGetAskPrice() {
        System.out.println("getAskPrice");
        StockSummary instance;
        instance = master;
        float expResult = 1.0F;
        float result = instance.getAskPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAskPrice method, of class StockSummary.
     */
    @Test
    public void testSetAskPrice() {
        System.out.println("setAskPrice");
        float askPrice = 1.0F;
        StockSummary instance = new StockSummary();
        instance.setAskPrice(askPrice);
        assertEquals(master.getAskPrice(), instance.getAskPrice());
    }

    /**
     * Test of getDaysRange method, of class StockSummary.
     */
    @Test
    public void testGetDaysRange() {
        System.out.println("getDaysRange");
        StockSummary instance;
        instance = master;
        int expResult = 1;
        int result = instance.getDaysRange();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDaysRange method, of class StockSummary.
     */
    @Test
    public void testSetDaysRange() {
        System.out.println("setDaysRange");
        int daysRange = 1;
        StockSummary instance = new StockSummary();
        instance.setDaysRange(daysRange);
        assertEquals(master.getDaysRange(), instance.getDaysRange());
    }

    /**
     * Test of getFiftytwoWeeksRange method, of class StockSummary.
     */
    @Test
    public void testGetFiftytwoWeeksRange() {
        System.out.println("getFiftytwoWeeksRange");
        StockSummary instance;
        instance = master;
        int expResult = 1;
        int result = instance.getFiftytwoWeeksRange();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFiftytwoWeeksRange method, of class StockSummary.
     */
    @Test
    public void testSetFiftytwoWeeksRange() {
        System.out.println("setFiftytwoWeeksRange");
        int fiftytwoWeeksRange = 1;
        StockSummary instance = new StockSummary();
        instance.setFiftytwoWeeksRange(fiftytwoWeeksRange);
        assertEquals(master.getFiftytwoWeeksRange(), instance.getFiftytwoWeeksRange());
    }

    /**
     * Test of getVolume method, of class StockSummary.
     */
    @Test
    public void testGetVolume() {
        System.out.println("getVolume");
        StockSummary instance;
        instance = master;
        int expResult = 1;
        int result = instance.getVolume();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVolume method, of class StockSummary.
     */
    @Test
    public void testSetVolume() {
        System.out.println("setVolume");
        int volume = 1;
        StockSummary instance = new StockSummary();
        instance.setVolume(volume);
        assertEquals(master.getVolume(), instance.getVolume());
    }

    /**
     * Test of getAvgVolume method, of class StockSummary.
     */
    @Test
    public void testGetAvgVolume() {
        System.out.println("getAvgVolume");
        StockSummary instance;
        instance = master;
        int expResult = 1;
        int result = instance.getAvgVolume();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAvgVolume method, of class StockSummary.
     */
    @Test
    public void testSetAvgVolume() {
        System.out.println("setAvgVolume");
        int avgVolume = 1;
        StockSummary instance = new StockSummary();
        instance.setAvgVolume(avgVolume);
        assertEquals(master.getAvgVolume(), instance.getAvgVolume());
    }

    /**
     * Test of getMarketCap method, of class StockSummary.
     */
    @Test
    public void testGetMarketCap() {
        System.out.println("getMarketCap");
        StockSummary instance;
        instance = master;
        int expResult = 1;
        int result = instance.getMarketCap();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMarketCap method, of class StockSummary.
     */
    @Test
    public void testSetMarketCap() {
        System.out.println("setMarketCap");
        int marketCap = 1;
        StockSummary instance = new StockSummary();
        instance.setMarketCap(marketCap);
        assertEquals(master.getMarketCap(), instance.getMarketCap());
    }

    /**
     * Test of getBetaCoefficient method, of class StockSummary.
     */
    @Test
    public void testGetBetaCoefficient() {
        System.out.println("getBetaCoefficient");
        StockSummary instance;
        instance = master;
        int expResult = 1;
        int result = instance.getBetaCoefficient();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBetaCoefficient method, of class StockSummary.
     */
    @Test
    public void testSetBetaCoefficient() {
        System.out.println("setBetaCoefficient");
        int betaCoefficient = 1;
        StockSummary instance = new StockSummary();
        instance.setBetaCoefficient(betaCoefficient);
        assertEquals(master.getBetaCoefficient(), instance.getBetaCoefficient());
    }

    /**
     * Test of getPeRatio method, of class StockSummary.
     */
    @Test
    public void testGetPeRatio() {
        System.out.println("getPeRatio");
        StockSummary instance;
        instance = master;
        int expResult = 1;
        int result = instance.getPeRatio();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPeRatio method, of class StockSummary.
     */
    @Test
    public void testSetPeRatio() {
        System.out.println("setPeRatio");
        int peRatio = 1;
        StockSummary instance = new StockSummary();
        instance.setPeRatio(peRatio);
        assertEquals(master.getPeRatio(), instance.getPeRatio());
    }

    /**
     * Test of getEps method, of class StockSummary.
     */
    @Test
    public void testGetEps() {
        System.out.println("getEps");
        StockSummary instance;
        instance = master;
        int expResult = 1;
        int result = instance.getEps();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEps method, of class StockSummary.
     */
    @Test
    public void testSetEps() {
        System.out.println("setEps");
        int eps = 1;
        StockSummary instance = new StockSummary();
        instance.setEps(eps);
        assertEquals(master.getEps(), instance.getEps());
    }

    /**
     * Test of getEarningDate method, of class StockSummary.
     */
    @Test
    public void testGetEarningDate() {
        System.out.println("getEarningDate");
        StockSummary instance;
        instance = master;
        Date expResult = null;
        Date result = instance.getEarningDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEarningDate method, of class StockSummary.
     */
    @Test
    public void testSetEarningDate() {
        System.out.println("setEarningDate");
        Date earningDate = null;
        StockSummary instance = new StockSummary();
        instance.setEarningDate(earningDate);
        assertEquals(master.getEarningDate(), instance.getEarningDate());
    }

    /**
     * Test of getDividendYield method, of class StockSummary.
     */
    @Test
    public void testGetDividendYield() {
        System.out.println("getDividendYield");
        StockSummary instance;
        instance = master;
        int expResult = 1;
        int result = instance.getDividendYield();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDividendYield method, of class StockSummary.
     */
    @Test
    public void testSetDividendYield() {
        System.out.println("setDividendYield");
        int dividendYield = 1;
        StockSummary instance = new StockSummary();
        instance.setDividendYield(dividendYield);
        assertEquals(master.getDividendYield(), instance.getDividendYield());
    }

    /**
     * Test of getExDividendDate method, of class StockSummary.
     */
    @Test
    public void testGetExDividendDate() {
        System.out.println("getExDividendDate");
        StockSummary instance;
        instance = master;
        Date expResult = null;
        Date result = instance.getExDividendDate();
        assertEquals(expResult, result);
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
        assertEquals(master.getExDividendDate(), instance.getExDividendDate());
    }

    /**
     * Test of getOneYearTargetEst method, of class StockSummary.
     */
    @Test
    public void testGetOneYearTargetEst() {
        System.out.println("getOneYearTargetEst");
        StockSummary instance;
        instance = master;
        Date expResult = null;
        Date result = instance.getOneYearTargetEst();
        assertEquals(expResult, result);
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
        assertEquals(master.getOneYearTargetEst(), instance.getOneYearTargetEst());
    }
    
}
