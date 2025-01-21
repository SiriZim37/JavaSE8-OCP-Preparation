package func.aufgaben.lambdas;

import java.util.function.Supplier;

/*
	interface Supplier<T> {
		T get();
	}
*/

public class TestLambdasSupplierA2 {

	public static void main(String[] args) {
	
		class S1 implements Supplier<String> {
    		@Override
    		public String get() {
    			return "Montag";
    		}
    	}
    	
    	Supplier<String> s1 = new S1();
    	System.out.println("Heute ist " + s1.get());
    	
    	 // s2: Anonyme Klasse
    	Supplier<String> s2 = new Supplier<String>() {
			public String get() {
				return "Montag";
			}
		};
    	System.out.println("Heute ist " + s2.get());
    	
    	
    	// s3: Lambda ausführlich 
    	Supplier<String> s3 = ()-> {
    		return "Montag";
    	};
    	System.out.println("Heute ist " + s3.get());
    	
    	// s4: Lambda kompakt
    	Supplier<String> s4 = ()-> "Montag" ;
    	System.out.println("Heute ist " + s4.get());
	}

}
