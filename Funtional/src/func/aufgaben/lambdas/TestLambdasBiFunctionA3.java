package func.aufgaben.lambdas;

import java.util.function.BiFunction;

/*
	interface BiFunction<T> {
		R apply(T t, U u);
	}
*/

public class TestLambdasBiFunctionA3 {

	public static void main(String[] args) {
		
		class F1 implements BiFunction<String, String, Integer> {
    		@Override
    		public Integer apply(String t1, String t2) {
    			return t1.length() + t2.length();
    		}
    	}
		
	 	BiFunction<String, String, Integer> f1 = new F1();
    	System.out.println( f1.apply("ab", "cde") );
		
		 // c2: Anonyme Klasse
    	BiFunction<String, String, Integer> f2 = new BiFunction<String, String, Integer>() {
			public Integer apply(String s1, String s2) {
				return s1.length() + s2.length();
			}
		};
    	System.out.println( f2.apply("ab", "cde") );	
		
		// c3: Lambda ausführlich 
    	BiFunction<String, String, Integer> f3 = (s1 , s2 ) ->{
    		return  s1.length() + s2.length() ;
    	};
    	System.out.println( f3.apply("ab", "cde") );
    	
    	
		// c4: Lambda kompakt
    	BiFunction<String, String, Integer> f4 = (s1 , s2) -> s1.length() + s2.length();
    	System.out.println( f4.apply("ab", "cde") );

	}

}
