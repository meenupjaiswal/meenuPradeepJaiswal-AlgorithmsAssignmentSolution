package com.stockers.util;

import java.util.Arrays;

public class MergeSortImplementation {

	public void sort(double inputArray[], int left, int right) {

		if (left < right) {
			int middle = left + (right - left) / 2;

			sort(inputArray, left, middle);
			sort(inputArray, middle + 1, right);

			merge(inputArray, left, middle, right);
		}
	}

	private void merge(double inputArray[], int left, int middle, int right) {
		int firstSubArrayLength = middle - left + 1;
		int secondSubArrayLength = right - middle;

		double leftTempArray[] = new double[firstSubArrayLength];
		double rightTempArray[] = new double[secondSubArrayLength];

		for (int i = 0; i < firstSubArrayLength; ++i)
			leftTempArray[i] = inputArray[left + i];
		for (int j = 0; j < secondSubArrayLength; ++j)
			rightTempArray[j] = inputArray[middle + 1 + j];

		/* Merge the temp arrays */

		int i = 0, j = 0;

		int k = left;
		while (i < firstSubArrayLength && j < secondSubArrayLength) {
			if (leftTempArray[i] < rightTempArray[j]) {
				inputArray[k] = leftTempArray[i];
				i++;
			} else {
				inputArray[k] = rightTempArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of leftTempArray[] if any */
		while (i < firstSubArrayLength) {
			inputArray[k] = leftTempArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of rightTempArray[] if any */
		while (j < secondSubArrayLength) {
			inputArray[k] = rightTempArray[j];
			j++;
			k++;
		}
	}

	public void sortReverse(double inputArray[], int left, int right) {

		if (left < right) {
			int middle = left + (right - left) / 2;

			sortReverse(inputArray, left, middle);
			sortReverse(inputArray, middle + 1, right);

			mergeReverse(inputArray, left, middle, right);
		}
	}

	private void mergeReverse(double inputArray[], int left, int middle, int right) {
		int firstSubArrayLength = middle - left + 1;
		int secondSubArrayLength = right - middle;

		double leftTempArray[] = new double[firstSubArrayLength];
		double rightTempArray[] = new double[secondSubArrayLength];

		for (int i = 0; i < firstSubArrayLength; ++i)
			leftTempArray[i] = inputArray[left + i];
		for (int j = 0; j < secondSubArrayLength; ++j)
			rightTempArray[j] = inputArray[middle + 1 + j];

		/* Merge the temp arrays */

		int i = 0, j = 0;

		int k = left;
		while (i < firstSubArrayLength && j < secondSubArrayLength) {
			if (leftTempArray[i] > rightTempArray[j]) {
				inputArray[k] = leftTempArray[i];
				i++;
			} else {
				inputArray[k] = rightTempArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of leftTempArray[] if any */
		while (i < firstSubArrayLength) {
			inputArray[k] = leftTempArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of rightTempArray[] if any */
		while (j < secondSubArrayLength) {
			inputArray[k] = rightTempArray[j];
			j++;
			k++;
		}
	}

}
