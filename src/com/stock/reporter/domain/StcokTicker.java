package com.stock.reporter.domain;

import java.io.Serializable;

/**
 * Load and store stock ticker names
 * @date Mar 17, 2019
 */
public class StcokTicker implements Serializable {

	private static final long serialVersionUID = 1L;

	private long tickerId;
	
	private String symbol;
	
	private String name;

	public long getTickerId() {
		return tickerId;
	}

	public void setTickerId(long tickerId) {
		this.tickerId = tickerId;
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