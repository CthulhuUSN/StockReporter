/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockanalysistool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class InvestopediaScrapper extends JsoupScrapper {
    private Database db;
    
    public InvestopediaScrapper(){
        db = new Database();
        db.deleteAll();
    }
    
    public void scrape(){
        scrapeAllSymbols();
        scapeAllHistoricalTables();
    }
    
    private void scrapeAllSymbols(){
        for(int i=0; i<47; i++){
            try {
                Connection jsoupConn = Jsoup.connect("https://www.investopedia.com/markets/stocks/?page="+i);
                Document document = jsoupConn.referrer("http://www.google.com") 
                                       .timeout(1000*5)              
                                       .get();
                Element allSymbolsContent = document.select("div.all-symbols-content").first(); 
                Elements symbolsElements = allSymbolsContent.select("a[href]");
                
                for(int j=0; j<symbolsElements.size()-1; j++){
                   symbols.add(symbolsElements.get(j).text());
                }
            } catch (IOException ex) {
                Logger.getLogger(InvestopediaScrapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void scapeAllHistoricalTables(){
        for(String symbolString: symbols)
            scapeSingleHistoricalTables(symbolString);
    }
    
    public void scapeSingleHistoricalTables(String symbolString){
        System.out.println(symbolString);
        String url = "https://www.investopedia.com/markets/stocks/"+symbolString.toLowerCase()+"#Historical";
        try {
            Connection jsoupConn = Jsoup.connect(url);
            Document document = jsoupConn.referrer("http://www.google.com") 
                                   .timeout(1000*5)              
                                   .get();

            Element table = document.select("table").last();
            Elements rows = table.select("tr"); 
            for(int i=1; i<rows.size()-1; i++){
                Element row = rows.get(i);
                HistoricalData historicalData = new HistoricalData();
                Elements columns = row.select("td");
                if(columns.size() == 6){
                    historicalData.setSymbol(symbolString);
                    historicalData.setSource(Constants.INVESTOPEDIA);
                    historicalData.setDate(columns.get(0).text());
                    historicalData.setOpen(columns.get(1).text());
                    historicalData.setHigh(columns.get(2).text());
                    historicalData.setLow(columns.get(3).text());
                    historicalData.setClose(columns.get(4).text());
                    historicalData.setAdjusted_close(columns.get(4).text());
                    historicalData.setVolume(columns.get(5).text());
                    db.insert(historicalData);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(StockAnalysisTool.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
