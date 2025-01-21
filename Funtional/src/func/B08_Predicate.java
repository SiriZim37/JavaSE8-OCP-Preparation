package func;

import java.util.function.Predicate;

public class B08_Predicate {
	/*
	 *  interface Predicate <T>{
	 *  boolean test(T param);
	 */
	public static void main(String[] args) {
		
		/*
		 * anonyme Klasse :
		 */	
		Predicate<String> p1 = new Predicate<String>() {
			public boolean test(String s) {
				return s != null;
			}
		};
		System.out.println(p1.test("ok"));
		
		/*
		 * Lamda ausfühlich 
		 */
		Predicate<String> p2 = (String s) ->{
			return s != null;
		};
		System.out.println(p2.test("ok"));
		
		/*
		 * Lamda kompakt 
		 */
		Predicate<String> p3 = (s) ->  s != null;
		System.out.println(p3.test("ok"));
	
		
	}

}
