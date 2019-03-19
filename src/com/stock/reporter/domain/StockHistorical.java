package com.stock.reporter.domain;

import java.io.Serializable;

/**
 * Historical domain class to store historical data
 * @date Mar 17, 2019
 */
public class StockHistorical implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private long historicalId;
	
	private float open;
	
	private float high;
	
	private float low;
	
	private float close;
	
	private float adjClose;
	
	private long volume;
	
	private long stockDtMapId;

	public long getHistoricalId() {
		return historicalId;
	}

	public void setHistoricalId(long historicalId) {
		this.historicalId = historicalId;
	}

	public float getOpen() {
		return open;
	}

	public void setOpen(float open) {
		this.open = open;
	}

	public float getHigh() {
		return high;
	}

	public void setHigh(float high) {
		this.high = high;
	}

	public float getLow() {
		return low;
	}

	public void setLow(float low) {
		this.low = low;
	}

	public float getClose() {
		return close;
	}

	public void setClose(float close) {
		this.close = close;
	}

	public float getAdjClose() {
		return adjClose;
	}

	public void setAdjClose(float adjClose) {
		this.adjClose = adjClose;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public long getStockDtMapId() {
		return stockDtMapId;
	}

	public void setStockDtMapId(long stockDtMapId) {
		this.stockDtMapId = stockDtMapId;
	}

	@Override
	public String toString() {
		return "StockHistorical [historicalId=" + historicalId + ", open=" + open + ", high=" + high + ", low=" + low
				+ ", close=" + close + ", adjClose=" + adjClose + ", volume=" + volume + ", stockDtMapId="
				+ stockDtMapId + "]";
	}
}
