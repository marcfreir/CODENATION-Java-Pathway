package br.com.codenation;

public class StatisticUtil {

	public static int average(int[] elements) {
		int sum = 0;
		//Sum all values inside the array
		for (int element : elements) {
			sum = sum + element;
		}
		//Calculates the mean
		//double mean = ((double) sum) / ((double) elements.length);
		//return mean;
		//return ((double) sum) / ((double) elements.length);
		return sum / elements.length;
	}

	public static int mode(int[] elements) {

		int modeCount = 0;
		int mode = 0;

		int currentCount = 0;
		//int currentElement;

		for (int elementMode : elements) {
			//Reset the number of times of the current value
			currentCount = 0;

			//Count the number of times the current element is seen
			for (int element : elements) {
				//If they match, increment the current count
				if (elementMode == element) {
					currentCount++;
				}
			}
			//If the count of the current element is greater than the current element
			if (currentCount > modeCount) {
				modeCount = currentCount;
				mode = elementMode;
			}
		}
		return mode;
	}


	//Using bubbleSort algorithm
	public static int[] bubbleSort(int[] elementsArray) {
		//boolean performedSwap = true;
		//int tempValue = 0;
		int tempValue;

		for (int indexOut = 0; indexOut < elementsArray.length; indexOut++) {
			for (int indexIn = 0; indexIn < elementsArray.length; indexIn++) {
				if (elementsArray[indexOut] < elementsArray[indexIn]) {
					tempValue = elementsArray[indexOut];
					elementsArray[indexOut] = elementsArray[indexIn];
					elementsArray[indexIn] = tempValue;
				}
			}
		}

		/*
		while (performedSwap) {
			performedSwap = false;

			for (int index = 0; index < elementsArray.length; index++) {
				if (elementsArray[index] > elementsArray[index + 1]) {
					tempValue = elementsArray[index];
					elementsArray[index] = elementsArray[index + 1];
					elementsArray[index + 1] = tempValue;

					performedSwap = true;
				}
			}
		}
		 */
		return elementsArray;
	}


	public static int median(int[] elements) {
		//Sort the array with bubbleSort algorithm
		int[] sortedElements = bubbleSort(elements);
		int median = 0;

		//If the array's length is even, then we need to find the average of two centered values
		if (elements.length % 2 == 0) {
			int indexA = (elements.length - 1) / 2;
			int indexB = (elements.length) / 2;

			median = (sortedElements[indexA] + sortedElements[indexB]) / 2;
		}
		//Else, in case of the array's length is odd, then we need to find the value centered inside the array
		else {
			int index = (sortedElements.length - 1) / 2;
			median = sortedElements[index];
		}
		return median;
	}
}