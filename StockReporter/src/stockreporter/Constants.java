package stockreporter;

/**
 * This will keep the initial stocks for scraping
 * The program will insert these stocks if the table is empty
 */
public class Constants {
    public static final String TABLE_STOCK_SOURCE = "STOCK_SOURCE";
    public static final String[] stockSymbols = {"MSFT", "AAPL", "GOOG", "BA", "NFLX", "AMZN", "FB", "CSCO", "TSLA", "TIF"};
    public static final String[] stockNames = {"Microsoft Corporation.", "Apple Inc.", "Alphabet Inc.", "The Boeing Company", "Netflix Inc.", "Amazon.com Inc.", "Facebook Inc.", "Cisco Systems Inc.", "Tesla Inc.", "Tiffany & Co."};
}
