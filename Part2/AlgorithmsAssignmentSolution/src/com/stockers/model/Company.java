package com.stockers.model;

public class Company {

	private double stockPrice;
	private boolean isStockPriceGreater;

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public boolean isStockPriceGreater() {
		return isStockPriceGreater;
	}

	public void setStockPriceGreater(boolean isStockPriceGreater) {
		this.isStockPriceGreater = isStockPriceGreater;
	}

}
