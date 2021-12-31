package com.stockers.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.stockers.model.Company;
import com.stockers.service.StockersOperationsServiceImpl;

public class StockersApplication {

	public static void main(String[] args) {
		try {
			startApplication();
		} catch (Exception e) {
			System.out.println("Exception Occured! Please enter valid values");
			startApplication();
		}

	}

	private static void startApplication() {
		Scanner inputScan = new Scanner(System.in);
		System.out.println("Enter the no of companies");
		int noOfCompanies = inputScan.nextInt();
		List<Company> companyList = loadStockPrices(noOfCompanies, inputScan);
		performOperations(companyList, inputScan);

	}

	private static void performOperations(List<Company> companyList, Scanner inputScan) {
		System.out.println("Enter the operation that you want to perform");
		int selectedOperation;
		StockersOperationsServiceImpl stockersOperationsServiceImpl = new StockersOperationsServiceImpl(companyList);
		do {
			displayOperations();
			selectedOperation = inputScan.nextInt();
			switch (selectedOperation) {
			case 1:
				System.out.println(
						"Stock prices in ascending order are : " + stockersOperationsServiceImpl.ascendingOrder());
				break;
			case 2:
				System.out.println(
						"Stock prices in descending order are : " + stockersOperationsServiceImpl.descendingOrder());
				break;
			case 3:
				System.out.println("Total no of companies whose stock price rose today : "
						+ stockersOperationsServiceImpl.totalCompaniesWithGreaterStockPrice());
				break;
			case 4:
				System.out.println("Total no of companies whose stock price declined today : "
						+ stockersOperationsServiceImpl.totalCompaniesWithLesserStockPrice());
				break;
			case 5:
				System.out.println("Enter the key value");
				double stockValue = inputScan.nextDouble();
				String isStockPresent = stockersOperationsServiceImpl.isStockPresent(stockValue) == Boolean.TRUE
						? "present"
						: "not present";
				System.out.println("Stock of value " + stockValue + " is " + isStockPresent);
				break;
			case 0:
				System.out.println("Exited successfully");
				break;
			default:
				System.out.println("Please enter valid value");
				break;
			}
		} while (selectedOperation != 0);
	}

	private static void displayOperations() {
		System.out.println("1. Display the companies stock prices in ascending order\r\n"
				+ "2. Display the companies stock prices in descending order\r\n"
				+ "3. Display the total no of companies for which stock prices rose today\r\n"
				+ "4. Display the total no of companies for which stock prices declined today\r\n"
				+ "5. Search a specific stock price\r\n" + "6. press 0 to exit");
	}

	private static List<Company> loadStockPrices(int noOfCompanies, Scanner inputScan) {
		List<Company> companyList = new ArrayList<>();
		for (int i = 1; i <= noOfCompanies; i++) {
			Company company = new Company();
			System.out.println("Enter current stock price of the company " + i);
			company.setStockPrice(inputScan.nextDouble());
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			company.setStockPriceGreater(inputScan.nextBoolean());
			companyList.add(company);
		}
		return companyList;
	}

}
