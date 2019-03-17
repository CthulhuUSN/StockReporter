package com.stock.reporter.domain;

import java.io.Serializable;

/**
 * Load and store stock source data
 * @date Mar 17, 2019
 */
public class StockSource implements Serializable {

	private static final long serialVersionUID = 1L;

	private long sourceId;
	
	private String name;

	public long getSourceId() {
		return sourceId;
	}

	public void setSourceId(long sourceId) {
		this.sourceId = sourceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
