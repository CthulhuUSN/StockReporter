/*
 * UtilityTest.java
 * JUnit Class to test the Utility.java class
 * 
 */
package stockreporter;

import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author klacayo
 */
public class UtilityTest {
    Utility util;
    
    public UtilityTest() {
        util = new Utility();
    }

    /*
    * Test of convertStringCurrency utilizing 'M'
    */
    @Test
    public void testConvertStringCurrencyUsingM() {
        String stringCurrency = "1M";
        BigDecimal expResult = BigDecimal.valueOf(1000000.0);
        BigDecimal result = util.convertStringCurrency(stringCurrency);
        assertEquals(expResult, result);  
    }
    
    /*
    * Test of convertStringCurrency utilizing 'B'
    */
    @Test
    public void testConvertStringCurrencyUsingB() {
        String stringCurrency = "1B";
        BigDecimal expResult = BigDecimal.valueOf(1000000000.0);
        BigDecimal result = util.convertStringCurrency(stringCurrency);
        assertEquals(expResult, result); 
    }
    
    /*
    * Test of convertStringCurrency utilizing numerical value
    */    
    @Test
    public void testConvertStringCurrencyUsingOther() {
        String stringCurrency = "100";
        BigDecimal expResult = BigDecimal.valueOf(100.0);
        BigDecimal result = util.convertStringCurrency(stringCurrency);
        assertEquals(expResult, result);  
    }
    
    /*
    * Test of getThousands utilizing M
    */ 
    @Test
    public void testGetThousandsUsingM() {
        char letter = 'M';
        double expResult = 1000000.0;
        double result = Utility.getThousands(letter);
        assertEquals(expResult, result, 0.0);      
    }
    
     /*
    * Test of getThousands utilizing B
    */     
    @Test
    public void testGetThousandsUsingB() {
        System.out.println("getThousandsUsingB");
        char letter = 'B';
        double expResult = 1000000000.0;
        double result = Utility.getThousands(letter);
        assertEquals(expResult, result, 0.0);      
    }
    
     /*
    * Test of getThousands utilizing X
    */ 
     @Test
    public void testGetThousandsUsingOther() {
        System.out.println("getThousandsUsingOther");
        char letter = 'X';
        double expResult = 1.0;
        double result = Utility.getThousands(letter);
        assertEquals(expResult, result, 0.0);      
    }
    
     /*
    * Test of getDoubleCurrency utilizing 1
    */ 
    @Test
    public void testGetDoubleCurrency() {
        System.out.println("getDoubleCurrency");
        String stringCurrency = "1";
        double expResult = 1.0;
        double result = Utility.getDoubleCurrency(stringCurrency);
        assertEquals(expResult, result, 0.0); 
    }
    
}
