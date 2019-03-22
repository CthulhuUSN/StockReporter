/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockanalysistool;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Herve Tchoufong
 */
public class StockScrapper {
    protected StockDao db;
    protected List<String> symbols = new ArrayList();
    
    public StockScrapper(){
        db = StockDao.getInstance();
        db.deleteAll();
    }
}
