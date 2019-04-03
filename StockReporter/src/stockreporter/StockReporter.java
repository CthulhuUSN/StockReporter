package stockreporter;

public class StockReporter {
    
    public static void main(String[] args) {    
        //create the database oject
        StockDao dao = StockDao.getInstance();
        //create the scrapers
        InvestopediaScraper investopediaScraper = new InvestopediaScraper();
        YahooScraper yahooScraper = new YahooScraper();
        //scrape the data
        investopediaScraper.scrapeAllSummaryData();
        yahooScraper.scrapeAllSummaryData();
    }
}