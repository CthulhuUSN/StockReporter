package stockreporter;

import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilityTest {
    Utility util;
    
    public UtilityTest() {
        util = new Utility();
    }

    @Test
    public void testConvertStringCurrencyUsingM() {
        System.out.println("convertStringCurrencyUsingM");
        String stringCurrency = "1M";
        BigDecimal expResult = new BigDecimal("1000000.0");
        BigDecimal result = util.convertStringCurrency(stringCurrency);
        assertEquals(expResult, result);  
    }
    
    @Test
    public void testConvertStringCurrencyUsingB() {
        System.out.println("convertStringCurrencyUsingB");
        String stringCurrency = "1B";
        BigDecimal expResult = new BigDecimal("1000000000.0");
        BigDecimal result = util.convertStringCurrency(stringCurrency);
        assertEquals(expResult, result);  
    }
    
    @Test
    public void testConvertStringCurrencyUsingOther() {
        System.out.println("convertStringCurrencyUsingOther");
        String stringCurrency = "100";
        BigDecimal expResult = new BigDecimal("100.0");
        BigDecimal result = util.convertStringCurrency(stringCurrency);
        assertEquals(expResult, result);  
    }
    
    @Test
    public void testGetThousandsUsingM() {
        System.out.println("getThousandsUsingM");
        char letter = 'M';
        double expResult = 1000000.0;
        double result = Utility.getThousands(letter);
        assertEquals(expResult, result, 0.0);      
    }
    
    @Test
    public void testGetThousandsUsingB() {
        System.out.println("getThousandsUsingB");
        char letter = 'B';
        double expResult = 1000000000.0;
        double result = Utility.getThousands(letter);
        assertEquals(expResult, result, 0.0);      
    }
    
     @Test
    public void testGetThousandsUsingOther() {
        System.out.println("getThousandsUsingOther");
        char letter = 'X';
        double expResult = 1.0;
        double result = Utility.getThousands(letter);
        assertEquals(expResult, result, 0.0);      
    }

    @Test
    public void testGetDoubleCurrency() {
        System.out.println("getDoubleCurrency");
        String stringCurrency = "1";
        double expResult = 1.0;
        double result = Utility.getDoubleCurrency(stringCurrency);
        assertEquals(expResult, result, 0.0); 
    }
    
}
