package exceptions;

import java.util.ArrayList;

public class B07_Errors {
	public static void main(String[] args) {
	/*
		try {
			recursiveMethod(); // java.lang.StackOverflowError
			
		} catch (StackOverflowError e) {
			e.printStackTrace();
		}
	*/
		
	/*	Test t = new Test();  // Exception in thread "main" java.lang.ExceptionInInitializerError, ausgelöscht
							  // durch die NullPointerException: im statischen Init-Block
	*/
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0 ; i <1_000_000_000 ; i++) {
			list.add(Integer.MAX_VALUE);  // OutOfMemoryError: Java heap space
			/* Dieser Fehler tritt auf, wenn die JVM den verfügbaren Heap-Speicher nicht mehr erweitern kann, 
			 * um neue Objekte zu speichern. In diesem Fall können die vielen Integer-Objekte und 
			 * die wachsende ArrayList den verfügbaren Speicherplatz überschreiten.
			 */
		}
		
		int[] largeArray = new int[Integer.MAX_VALUE]; // OutOfMemoryError: Java heap space
//		 MissingClass obj = new MissingClass();  // NoClassDefFoundError: MissingClass
		assert false : "Assertion failed"; // AssertionError: Assertion failed
		
		
		System.out.println("servus"); 
	}
	
	
	public static void recursiveMethod() {
		recursiveMethod();
	}
}

class Test{
	static int[] intArr ;
	static {
		intArr[2] = 0;
	}
}

