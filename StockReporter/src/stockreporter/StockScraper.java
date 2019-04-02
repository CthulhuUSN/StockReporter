/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockreporter;

import stockreporter.daomodels.StockSummary;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Herve Tchoufong
 */
public class StockScraper {
    protected List<String> stockSymbols = new ArrayList();
    protected StockSummary ss = new StockSummary();
    protected StockDao dao = StockDao.getInstance();
    protected List<String> symbols = new ArrayList();
}
