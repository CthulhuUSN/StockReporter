/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockreporter;

import stockreporter.scrappers.YahooScraper;
import stockreporter.scrappers.InvestopediaScraper;

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