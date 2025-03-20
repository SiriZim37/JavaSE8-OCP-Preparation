package oca;

public class VarargsWithOverloading {

	public static void main(String[] args) {
		    
			printValue(1, 2);	// Varargs method
	        printValue(1);		// Single int method
	        printValue();		// Varargs method
	}

	    static void printValue(int... values) {
	        System.out.println("Varargs method");
	    }

	    static void printValue(int value) {
	        System.out.println("Single int method");
	    }

}
