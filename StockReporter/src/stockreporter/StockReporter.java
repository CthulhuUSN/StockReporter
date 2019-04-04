package stockreporter;

import stockreporter.scrappers.YahooScraper;
import stockreporter.scrappers.InvestopediaScraper;

/**
 * Main class for scrapping the data
 */
public class StockReporter {
    
    public static void main(String[] args) {    
        //create the database instance
        StockDao dao = StockDao.getInstance();
        
        //create the scrapers
        InvestopediaScraper investopediaScraper = new InvestopediaScraper();
        YahooScraper yahooScraper = new YahooScraper();
        
        //scrape the summary data
        investopediaScraper.scrapeAllSummaryData();
        yahooScraper.scrapeAllSummaryData();
    }
}