/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockreporter;

import java.io.IOException;
import stockreporter.daomodels.StockSummary;
import stockreporter.daomodels.StockTicker;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import stockreporter.daomodels.StockDateMap;


/**
 *
 * @author Herve Tchoufong
 */
public class InvestopediaScraper extends StockScraper {
    
    public InvestopediaScraper(){
        super();
    }
    
    public void scrapeAllSummaryData(){
        List<StockTicker> stockTickers = dao.getAllstockTickers();
        for(StockTicker stockTicker: stockTickers)
            scapeSingleSummaryTables(stockTicker);
    }
    
    public void scapeSingleSummaryTables(StockTicker stockTicker){        
        System.out.println(stockTicker.getSymbol());
        String url = "https://www.investopedia.com/markets/stocks/"+stockTicker.getSymbol().toLowerCase();
        try {
            Connection jsoupConn = Jsoup.connect(url);
            Document document = jsoupConn.referrer("http://www.google.com") .timeout(1000*5).get();

            StockDateMap stockDateMap = new StockDateMap();
            stockDateMap.setSourceId(2);
            stockDateMap.setTickerId(stockTicker.getId());
            stockDateMap.setDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
            int last_inserted_id = dao.insertStockDateMap(stockDateMap);
        
            Element table2 = document.select("table").get(2);
            Elements rows = table2.select("tr");    
            StockSummary summaryData = new StockSummary();
            
            summaryData.setStockDtMapId(last_inserted_id);
            
            String prevClosePrice = rows.get(0).select("td").get(1).text();
            summaryData.setPrevClosePrice(Utility.convertStringCurrency(prevClosePrice.equals("-")?"0":prevClosePrice));
            
            String openPrice = rows.get(1).select("td").get(1).text();
            summaryData.setOpenPrice(Utility.convertStringCurrency(openPrice.equals("-")?"0":openPrice));
            
            String daysRangeMax = Utility.getRangeMinAndMax(rows.get(2).select("td").get(1).text())[0].trim();
            summaryData.setDaysRangeMin(Utility.convertStringCurrency(daysRangeMax.equals("-")?"0":daysRangeMax));
            
            String daysRangeMin = Utility.getRangeMinAndMax(rows.get(2).select("td").get(1).text())[1].trim();
            summaryData.setDaysRangeMax(Utility.convertStringCurrency(daysRangeMin.equals("-")?"0":daysRangeMin));
            
            String fiftyTwoWeeksMin = Utility.getRangeMinAndMax(rows.get(3).select("td").get(1).text())[0].trim();
            summaryData.setFiftyTwoWeeksMin(Utility.convertStringCurrency(fiftyTwoWeeksMin.equals("-")?"0":fiftyTwoWeeksMin));
            
            String fiftyTwoWeeksMax = Utility.getRangeMinAndMax(rows.get(3).select("td").get(1).text().trim())[1].trim();
            summaryData.setFiftyTwoWeeksMax(Utility.convertStringCurrency(fiftyTwoWeeksMax.equals("-")?"0":fiftyTwoWeeksMax));
            
            String peRatio = rows.get(4).select("td").get(1).text();
            summaryData.setPeRatio(Utility.convertStringCurrency(peRatio.equals("-")?"0":peRatio));
            
            Element table3 = document.select("table").get(3);
            rows = table3.select("tr");    
            
            String betaCoefficient = rows.get(0).select("td").get(1).text();
            summaryData.setBetaCoefficient(Utility.convertStringCurrency(betaCoefficient.equals("-")?"0":betaCoefficient));
            
            String volume = rows.get(1).select("td").get(1).text();
            summaryData.setVolume(Utility.convertStringCurrency(volume.equals("-")?"0":volume).longValue());
            
            String dividend = Utility.getNumeratorAndDenominator(rows.get(2).select("td").get(1).text())[0].trim();
            summaryData.setDividentYield(Utility.convertStringCurrency(dividend.equals("-")?"0":dividend));
            
            String marketCap = rows.get(3).select("td").get(1).text();
            summaryData.setMarketCap(Utility.convertStringCurrency(marketCap.equals("-")?"0":marketCap));
            
            String eps = rows.get(4).select("td").get(1).text();
            summaryData.setEps(Utility.convertStringCurrency(eps.equals("-")?"0":eps));
            
            dao.insertStockSummaryData(summaryData);
            
        } catch (IOException ex) {
            Logger.getLogger(StockReporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
