package stockreporter.scrappers;

import java.io.File;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import static org.junit.Assert.*;

public class InvestopediaScraperTest {
    
    public InvestopediaScraperTest() {}

    @Test
    public void testScapeSingleSummaryData() {
        InvestopediaScraper instance = new InvestopediaScraper();
        File input = new File("Apr_4_2019_AAPL_Investopedia.html");
        //Document doc = Jsoup.parse(input, "UTF-8", "");
    }
    
}
