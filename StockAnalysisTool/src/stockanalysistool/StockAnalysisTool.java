/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockanalysistool;

/**
 *
 * @author Herve Tchoufong
 */
public class StockAnalysisTool {
    
    public static void main(String[] args) {
        //Still need to add the stock symbols and names to the array.
        String[][] stockArray = new String[5][2];
                
        StockDao dao = StockDao.getInstance();
        InvestopediaScraper investopediaScraper = new InvestopediaScraper();
        YahooScraper yahooScraper = new YahooScraper();
        
        investopediaScraper.scrapeAllSummaryData();
        yahooScraper.scrapeAllSummaryData();
    }
}