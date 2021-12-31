package com.stockers.service;

import java.util.Arrays;
import java.util.List;

import com.stockers.model.Company;
import com.stockers.util.BinarySearchImplementation;
import com.stockers.util.MergeSortImplementation;

public class StockersOperationsServiceImpl implements StockersOperationsService {

	public List<Company> companyList;
	public double[] stockArray;
	public boolean isAscending = false;
	public boolean isDescending = false;

	public StockersOperationsServiceImpl(List<Company> companyList) {
		this.companyList = companyList;
		stockArray = new double[companyList.size()];
		for (int i = 0; i < companyList.size(); i++) {
			stockArray[i] = companyList.get(i).getStockPrice();
		}
	}

	@Override
	public String ascendingOrder() {
		if (isAscending) {
			return stockArray.toString();
		} else {
			getMergeSort().sort(stockArray, 0, companyList.size() - 1);
			isAscending = true;
			isDescending = false;
			return Arrays.toString(stockArray);
		}
	}

	@Override
	public String descendingOrder() {
		if (isDescending) {
			return stockArray.toString();
		} else {
			getMergeSort().sortReverse(stockArray, 0, companyList.size() - 1);
			isAscending = false;
			isDescending = true;
			return Arrays.toString(stockArray);
		}
	}

	@Override
	public long totalCompaniesWithGreaterStockPrice() {
		return companyList.stream().filter(company -> company.isStockPriceGreater() == Boolean.TRUE).count();
	}

	@Override
	public long totalCompaniesWithLesserStockPrice() {
		return companyList.size() - totalCompaniesWithGreaterStockPrice();
	}

	@Override
	public boolean isStockPresent(double stockPrice) {
		if (isAscending) {
			return getBinarySearch().binarySearch(stockArray, 0, companyList.size() - 1, stockPrice) != -1;
		} else {
			getMergeSort().sort(stockArray, 0, companyList.size() - 1);
			isAscending = true;
			return getBinarySearch().binarySearch(stockArray, 0, companyList.size() - 1, stockPrice) != -1;
		}
	}

	private MergeSortImplementation getMergeSort() {
		return new MergeSortImplementation();
	}

	private BinarySearchImplementation getBinarySearch() {
		return new BinarySearchImplementation();
	}

}
