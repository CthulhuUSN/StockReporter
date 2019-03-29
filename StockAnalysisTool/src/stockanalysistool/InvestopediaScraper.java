/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockanalysistool;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Herve Tchoufong
 */
public class InvestopediaScraper extends StockScraper {
    
    public InvestopediaScraper(){
        super();
    }
    
    public void scrape(){
        getStickersSymnols();
        scapeAllHistoricalTables();
    }
    
    private void getStickersSymnols(){
        
        for(int i=0; i<47; i++){
            try {
                Connection jsoupConn = Jsoup.connect("https://www.investopedia.com/markets/stocks/?page="+i);
                Document document = jsoupConn.referrer("http://www.google.com") 
                                       .timeout(1000*5)              
                                       .get();
                Element allSymbolsContent = document.select("div.all-symbols-content").first(); 
                Elements symbolsElements = allSymbolsContent.select("a[href]");
                
                for(int j=0; j<symbolsElements.size()-1; j++){
                   stockSymbols.add(symbolsElements.get(j).text());
                }
            } catch (IOException ex) {
                Logger.getLogger(InvestopediaScraper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void scapeAllSummaryData(){
        for(String symbolString: stockSymbols)
            scapeSingleSummaryData(symbolString);
    }
    
    public void scapeSingleSummaryData(String symbolString){
        
        System.out.println(symbolString);
        String url = "https://www.investopedia.com/markets/stocks/"+symbolString.toLowerCase()+"#Summary";
        try {
            Connection jsoupConn = Jsoup.connect(url);
            Document document = jsoupConn.referrer("http://www.google.com") 
                                   .timeout(1000*5)              
                                   .get();

            Element table = document.select("table").last();
            Elements rows = table.select("tr"); 
            for(int i=1; i<rows.size()-1; i++){
                Element row = rows.get(i);
                StockSummary summaryData = new StockSummary();
                Elements columns = row.select("td");
                if(columns.size() == 6){
                    summaryData.setSymbol(symbolString);
                    summaryData.setSource(Constants.INVESTOPEDIA);
                    summaryData.setDate(columns.get(0).text());
                    summaryData.setOpen(columns.get(1).text());
                    summaryData.setHigh(columns.get(2).text());
                    summaryData.setLow(columns.get(3).text());
                    summaryData.setClose(columns.get(4).text());
                    summaryData.setAdjusted_close(columns.get(4).text());
                    summaryData.setVolume(columns.get(5).text());
                    dao.insertStockSummaryData(summaryData);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(StockAnalysisTool.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
