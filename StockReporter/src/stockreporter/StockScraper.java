package stockreporter;

import stockreporter.daomodels.StockSummary;
import java.util.ArrayList;
import java.util.List;

public class StockScraper {
    protected List<String> stockSymbols = new ArrayList();
    protected StockSummary ss = new StockSummary();
    protected StockDao dao = StockDao.getInstance();
    protected List<String> symbols = new ArrayList();
}
