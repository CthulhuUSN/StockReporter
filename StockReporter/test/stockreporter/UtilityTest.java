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
        String stringCurrency = "1M";
        BigDecimal expResult = new BigDecimal("1000000.0");
        BigDecimal result = util.convertStringCurrency(stringCurrency);
        assertEquals(expResult, result);  
    }
    
    @Test
    public void testConvertStringCurrencyUsingB() {
        String stringCurrency = "1B";
        BigDecimal expResult = new BigDecimal("1000000000.0");
        BigDecimal result = util.convertStringCurrency(stringCurrency);
        assertEquals(expResult, result);  
    }
    
    @Test
    public void testConvertStringCurrencyUsingOther() {
        String stringCurrency = "100";
        BigDecimal expResult = new BigDecimal("100.0");
        BigDecimal result = util.convertStringCurrency(stringCurrency);
        assertEquals(expResult, result);  
    }
    
    @Test
    public void testGetThousandsUsingM() {
        char letter = 'M';
        double expResult = 1000000.0;
        double result = Utility.getThousands(letter);
        assertEquals(expResult, result, 0.0);      
    }
    
    @Test
    public void testGetThousandsUsingB() {
        char letter = 'B';
        double expResult = 1000000000.0;
        double result = Utility.getThousands(letter);
        assertEquals(expResult, result, 0.0);      
    }
    
     @Test
    public void testGetThousandsUsingOther() {
        char letter = 'X';
        double expResult = 1.0;
        double result = Utility.getThousands(letter);
        assertEquals(expResult, result, 0.0);      
    }

    @Test
    public void testGetDoubleCurrency() {
        String stringCurrency = "1";
        double expResult = 1.0;
        double result = Utility.getDoubleCurrency(stringCurrency);
        assertEquals(expResult, result, 0.0); 
    }
    
}
