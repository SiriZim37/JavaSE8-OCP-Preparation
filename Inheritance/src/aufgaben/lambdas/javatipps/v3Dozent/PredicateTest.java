package aufgaben.lambdas.javatipps.v3Dozent;

import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		// A2
		Integer[] intArr = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		// A3
		Predicate<Integer> predPositive = (Integer n) -> n > 0;
		Integer[] results = printIf(intArr, predPositive);
		System.out.println("alle positiven Elemente");
		for (Integer integer : results) {
			if (integer != null) {
				System.out.print(integer + " ");
			}
		}
		System.out.println();
		// A4
		results = printIf(intArr, i -> i % 2 == 0);
		System.out.println("alle geraden Elemente");
		for (Integer integer : results) {
			if (integer != null) {
				System.out.print(integer + " ");
			}
		}
		System.out.println();
		// A5
		results = printIf(intArr, i -> i % 2 == 0 && i > 0);
		System.out.println("alle geraden, positiven Elemente");
		for (Integer integer : results) {
			if (integer != null) {
				System.out.print(integer + " ");
			}
		}
	}
	
	// A1
	public static Integer[] printIf(Integer[] intArr, Predicate<Integer> pred) {
		Integer[] results = new Integer[intArr.length];
		int index = 0;
		for (Integer integer : intArr) {
			if (pred.test(integer)) {
				results[index++] = integer;
			}
		}	
		return results;
	}

}
