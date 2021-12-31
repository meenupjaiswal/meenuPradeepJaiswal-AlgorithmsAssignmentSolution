package com.stockers.util;

public class BinarySearchImplementation {
	
	public int binarySearch(double inputArray[], int left, int right, double searchValue)
	    {
	        if (right >= left) {
	            int mid = left + (right - left) / 2;
	 
	            if (inputArray[mid] == searchValue)
	                return mid;
	 
	            if (inputArray[mid] > searchValue)
	                return binarySearch(inputArray, left, mid - 1, searchValue);
	 
	            return binarySearch(inputArray, mid + 1, right, searchValue);
	        }
	 
	        return -1;
	    }

}
