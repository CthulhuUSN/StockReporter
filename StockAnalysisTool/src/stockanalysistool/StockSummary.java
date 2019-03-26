/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockanalysistool;

import java.util.Date;

/**
 *
 * @author 
 */
public class StockSummary {
    private int summaryId;
    private int prevClosePrice;
    private float openPrice;
    private float bidPrice;
    private float askPrice;
    private int daysRange;
    private int fiftytwoWeeksRange;
    private int volume;
    private int avgVolume;
    private int marketCap;
    private int betaCoefficient;
    private int peRatio;
    private int eps;
    private Date earningDate;
    private int dividendYield;
    private Date exDividendDate;
    private Date oneYearTargetEst;

    public int getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(int summaryId) {
        this.summaryId = summaryId;
    }

    public int getPrevClosePrice() {
        return prevClosePrice;
    }

    public void setPrevClosePrice(int prevClosePrice) {
        this.prevClosePrice = prevClosePrice;
    }

    public float getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(float openPrice) {
        this.openPrice = openPrice;
    }

    public float getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(float bidPrice) {
        this.bidPrice = bidPrice;
    }

    public float getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(float askPrice) {
        this.askPrice = askPrice;
    }

    public int getDaysRange() {
        return daysRange;
    }

    public void setDaysRange(int daysRange) {
        this.daysRange = daysRange;
    }

    public int getFiftytwoWeeksRange() {
        return fiftytwoWeeksRange;
    }

    public void setFiftytwoWeeksRange(int fiftytwoWeeksRange) {
        this.fiftytwoWeeksRange = fiftytwoWeeksRange;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getAvgVolume() {
        return avgVolume;
    }

    public void setAvgVolume(int avgVolume) {
        this.avgVolume = avgVolume;
    }

    public int getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(int marketCap) {
        this.marketCap = marketCap;
    }

    public int getBetaCoefficient() {
        return betaCoefficient;
    }

    public void setBetaCoefficient(int betaCoefficient) {
        this.betaCoefficient = betaCoefficient;
    }

    public int getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(int peRatio) {
        this.peRatio = peRatio;
    }

    public int getEps() {
        return eps;
    }

    public void setEps(int eps) {
        this.eps = eps;
    }

    public Date getEarningDate() {
        return earningDate;
    }

    public void setEarningDate(Date earningDate) {
        this.earningDate = earningDate;
    }

    public int getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield(int dividendYield) {
        this.dividendYield = dividendYield;
    }

    public Date getExDividendDate() {
        return exDividendDate;
    }

    public void setExDividendDate(Date exDividendDate) {
        this.exDividendDate = exDividendDate;
    }

    public Date getOneYearTargetEst() {
        return oneYearTargetEst;
    }

    public void setOneYearTargetEst(Date oneYearTargetEst) {
        this.oneYearTargetEst = oneYearTargetEst;
    }
    
}
