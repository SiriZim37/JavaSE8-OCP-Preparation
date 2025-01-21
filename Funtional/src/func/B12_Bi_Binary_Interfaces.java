package func;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class B12_Bi_Binary_Interfaces {

	public static void main(String[] args) {

		// zum Vergleich : Predicate 
		Predicate<Integer> p1 = (Integer param ) -> true;
		
		/*
		 * BiPredicate (boolean	test(T t, U u))
		 */
		BiPredicate<Integer, String> p2 = (Integer param , String param2) -> true;
		
		// Zum Vergleich 
		Consumer<String> c1 = (String param) ->{};
		
		/*
		 * BiConsumer
		 */
		BiConsumer<String,Integer> c2 = (String param1 , Integer param2) ->{};
		
		
		// Zum Vergleich : Function
		Function<Integer, String> f1 = (Integer param) -> "moin";
		
		
//		BiSupplier<String,Integer> c3 ; 		// cf : Suppiler hat keine paramrter

		/*		
			public interface Supplier<T> {
			
			    T get();
			}
		*/
		
		BiFunction<Integer, Double, String> f2 = (Integer i, Double d) -> "moin"; // Function hat 2 Parameters
		
		/*		
			public interface Function<T , R> {
			
			   R apply(T t);
		}
		 */
		
		/*
		 * BinaryOperator ist B13_Operator_Interfaces
		 */

		    
	}

}
