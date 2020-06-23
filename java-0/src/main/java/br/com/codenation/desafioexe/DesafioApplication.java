package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {

		List<Integer> fibonacciList = new ArrayList<Integer>();

		//Initialize the list
		Integer currentFibonacciNumber = 0;
		fibonacciList.add(currentFibonacciNumber);
		fibonacciList.add(currentFibonacciNumber + 1);

		//Calculate the Fibonacci Sequence
		int amountOfIndexes = 350;
		int index = 1;

		do {
			currentFibonacciNumber = fibonacciList.get(index) + fibonacciList.get(index - 1);
			fibonacciList.add(currentFibonacciNumber);
			index++;
		} while (currentFibonacciNumber <= amountOfIndexes);
		return fibonacciList;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}