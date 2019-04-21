package stockreporter.scrappers;
import java.util.Date;
import java.util.List;
import stockreporter.StockDao;
import stockreporter.daomodels.StockTicker;

/**
 * Initialize stock scrapper with dao and stock tickers
 */
public class StockScraper {
    
    protected StockDao dao;
    protected List<StockTicker> stockTickers;
    protected Date latestScrappedDate;
    
    public StockScraper(){
        dao = StockDao.getInstance();
        stockTickers = dao.getAllstockTickers();
        latestScrappedDate = dao.getLatestScrappedDate();
    }
}
