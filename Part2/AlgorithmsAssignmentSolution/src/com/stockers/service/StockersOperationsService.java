package com.stockers.service;

public interface StockersOperationsService {

	public String ascendingOrder();

	public String descendingOrder();

	public long totalCompaniesWithGreaterStockPrice();
	
	public long totalCompaniesWithLesserStockPrice();

	public boolean isStockPresent(double stockPrice);

}
