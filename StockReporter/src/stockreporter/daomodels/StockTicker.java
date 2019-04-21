package stockreporter.daomodels;

/**
 * Entity object for stock ticker with setter/getters
 */
public class StockTicker{ 
    
    private long id;
    private String symbol;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
