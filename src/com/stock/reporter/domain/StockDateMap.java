package com.stock.reporter.domain;

import java.io.Serializable;

/**
 * Stock date mapper
 * @date Mar 17, 2019
 */
public class StockDateMap implements Serializable {

	private static final long serialVersionUID = 1L;

	private long stockDtMapId;
	
	private String stockDate;
	
	private long tickerId;
	
	private long sourceId;

	public long getStockDtMapId() {
		return stockDtMapId;
	}

	public void setStockDtMapId(long stockDtMapId) {
		this.stockDtMapId = stockDtMapId;
	}

	public String getStockDate() {
		return stockDate;
	}

	public void setStockDate(String stockDate) {
		this.stockDate = stockDate;
	}

	public long getTickerId() {
		return tickerId;
	}

	public void setTickerId(long tickerId) {
		this.tickerId = tickerId;
	}

	public long getSourceId() {
		return sourceId;
	}

	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	} 
}
