package com.stock.reporter.domain;

import java.io.Serializable;

/**
 * Summary domain class to store summary data
 * @date Mar 17, 2019
 */
public class StockSummary implements Serializable {

	private static final long serialVersionUID = 1L;

	private long summaryId;
	
	private float prevClosePrice;
	
	private float openPrice;
	
	private float bidPrice;
	
	private float askPrice;
	
	private float daysRangeMin;
	
	private float daysRangeMax;
	
	private float fiftyTwoWeeksMin;
	
	private float fiftyTwoWeeksMax;
	
	private long volume;
	
	private long avgVolume;
	
	private float marketCap;
	
	private float betaCoefficient;
	
	private float peRatio;
	
	private float eps;
	
	private String earningDate;
	
	private float dividentYield;
	
	private String exDividentDate;
	
	private float oneYearTargetEst;
	
	private long stockDtMapId;

	public long getSummaryId() {
		return summaryId;
	}

	public void setSummaryId(long summaryId) {
		this.summaryId = summaryId;
	}

	public float getPrevClosePrice() {
		return prevClosePrice;
	}

	public void setPrevClosePrice(float prevClosePrice) {
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

	public float getDaysRangeMin() {
		return daysRangeMin;
	}

	public void setDaysRangeMin(float daysRangeMin) {
		this.daysRangeMin = daysRangeMin;
	}

	public float getDaysRangeMax() {
		return daysRangeMax;
	}

	public void setDaysRangeMax(float daysRangeMax) {
		this.daysRangeMax = daysRangeMax;
	}

	public float getFiftyTwoWeeksMin() {
		return fiftyTwoWeeksMin;
	}

	public void setFiftyTwoWeeksMin(float fiftyTwoWeeksMin) {
		this.fiftyTwoWeeksMin = fiftyTwoWeeksMin;
	}

	public float getFiftyTwoWeeksMax() {
		return fiftyTwoWeeksMax;
	}

	public void setFiftyTwoWeeksMax(float fiftyTwoWeeksMax) {
		this.fiftyTwoWeeksMax = fiftyTwoWeeksMax;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public long getAvgVolume() {
		return avgVolume;
	}

	public void setAvgVolume(long avgVolume) {
		this.avgVolume = avgVolume;
	}

	public float getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(float marketCap) {
		this.marketCap = marketCap;
	}

	public float getBetaCoefficient() {
		return betaCoefficient;
	}

	public void setBetaCoefficient(float betaCoefficient) {
		this.betaCoefficient = betaCoefficient;
	}

	public float getPeRatio() {
		return peRatio;
	}

	public void setPeRatio(float peRatio) {
		this.peRatio = peRatio;
	}

	public float getEps() {
		return eps;
	}

	public void setEps(float eps) {
		this.eps = eps;
	}

	public String getEarningDate() {
		return earningDate;
	}

	public void setEarningDate(String earningDate) {
		this.earningDate = earningDate;
	}

	public float getDividentYield() {
		return dividentYield;
	}

	public void setDividentYield(float dividentYield) {
		this.dividentYield = dividentYield;
	}

	public String getExDividentDate() {
		return exDividentDate;
	}

	public void setExDividentDate(String exDividentDate) {
		this.exDividentDate = exDividentDate;
	}

	public float getOneYearTargetEst() {
		return oneYearTargetEst;
	}

	public void setOneYearTargetEst(float oneYearTargetEst) {
		this.oneYearTargetEst = oneYearTargetEst;
	}

	public long getStockDtMapId() {
		return stockDtMapId;
	}

	public void setStockDtMapId(long stockDtMapId) {
		this.stockDtMapId = stockDtMapId;
	}
}