package functonal;


import java.util.function.Predicate;

class MyStringPredicateAll implements Predicate<String> {
	public boolean test(String s) {
		return true;
	}
}

public class B06_Predicate {

	/*
	 * public interface Predicate <T> {
	 * 		boolean test(T x);
	 * }
	 */
	public static void main(String[] args) {

		String[] arrStr = {
			"aa", "b", "cc", "ddd", "ee", "f"	
		};

		System.out.println("*** Alle Strings mit Predicate-Klasse: ");
		printSelected(arrStr, new MyStringPredicateAll());
		
		System.out.println("*** Alle Strings: ");
		printSelected(arrStr, s -> true);
		
		System.out.println("\n*** Keine Strings: ");
		printSelected(arrStr, s -> false);
		
		System.out.println("\n*** Strings der Länge 2: ");
		printSelected(arrStr, s -> s.length()==2);
	}
	
	static void printSelected(String[] arr, Predicate<String> tester) {
		for (int i = 0, count=1; i < arr.length; i++) {
			String s = arr[i];
			if(tester.test(s)) {
				System.out.println(count++ + ". " + s);
			}
		}
	}

}

