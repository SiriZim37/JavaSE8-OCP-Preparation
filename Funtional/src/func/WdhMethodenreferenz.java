package func;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class WdhMethodenreferenz {

	public static void main(String[] args) {
		
		double d = Math.random();
		
		
		/*
		 * Ausgabe : compiler ok
		 */
		Supplier<Double> s1 = Math::random;      
		/*
		 * Klass nachbilden
		 * 
		 * 		class Blabla implements Supplier<Double>{
		 * 			public Double get(){
		 * 				return Math.random();
		 * 			}
		 * 		}
		 */
		int rnd = new Random().nextInt();
	
		
		
		/*
		 * Ausgabe : compiler ok
		 */
		Supplier<Integer> s3 = new Random()::nextInt;		

		/*
		 * Klass nachbilden
		 * 
		 * 		class Blabla implements Supplier<Double>{
		 * 			public Integer get(){
		 * 				return new Random().nextInt();
		 * 			}
		 * 		}
		 */
		int absolut = Math.abs(-10);
//		Supplier<Integer> s4 = Math::abs;
		Function<Integer, Integer> s41 = Math::abs;
		System.out.println( s41.apply(-10));
		
		
		
		/*
		 * Ausgabe : compiler ok
		 */
		Consumer<String> c1 = StringBuilder::new;
		/*
		 * Klass nachbilden
		 * 
		 * 		class Blabla implements Consumer<String>{
		 * 			public void accept(String s){	
		 * 			}
		 * 		}
		 */
		c1.accept("mo");
		
		
		
		
		
		String str = "ja";
		
		/*
		 * Ausgabe : compiler ok
		 */
		Function<String, String> f77 = str::concat;		// 		str.concat(str);
		/*
		 * Klass nachbilden
		 * 
		 * 		class Blabla implements Function<String, String>{
		 * 			public String apply(){
		 * 				return str.concat(str);
		 * 			}
		 * 		}
		 */
		
		System.out.println( f77.apply(str));
		
		
		
	}





}
