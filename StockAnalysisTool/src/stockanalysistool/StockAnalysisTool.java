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
    //Still need to add the stock symbols and names to the array.
    private String stockArray[][];
    private String databasePath;
    private String databaseUrl = "jdbc:sqlite:stocksdb.sqlite";
    public StockDao dao = new StockDao(databasePath, databaseUrl);
    public InvestopediaScraper investopediaScraper = new InvestopediaScraper();
    public YahooScraper yahooScraper = new YahooScraper();
    
    public static void main(String[] args) {
        investopediaScraper.scrapeAllSummaryData();
        yahooScraper.scrapeAllSummaryData();
    }
}
