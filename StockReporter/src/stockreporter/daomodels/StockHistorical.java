/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockreporter.daomodels;

/**
 *
 * @author Herve Tchoufong
 */
public class StockHistorical {
    private int historicalId;
    private int open;
    private int high;
    private int low;
    private int close;
    private int adjClose;
    private int volume;

    public int getHistoricalId() {
        return historicalId;
    }

    public void setHistoricalId(int historicalId) {
        this.historicalId = historicalId;
    }

    public int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getClose() {
        return close;
    }

    public void setClose(int close) {
        this.close = close;
    }

    public int getAdjClose() {
        return adjClose;
    }

    public void setAdjClose(int adjClose) {
        this.adjClose = adjClose;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    
}
