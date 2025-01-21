package wdh.funtional;

import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class LambdaSyntax {

	public static void main(String[] args) {
		
		/*
		 * 1. Parameter-list. Detailed notation
		 */
		
		Runnable v1 = () -> {};
		Consumer<String> v2 = (String param) -> System.out.println(param);
		Consumer<String> v3 = (String param) -> {} ;
		BiFunction<Integer, Boolean, String> v4 
					= (Integer x , Boolean y) -> String.valueOf(x) + y; 
					
		/*
		 * 2. Parameter-list. Compact notaion (without Typ)
		 */		
		Consumer<String> v22 = (param) -> System.out.println(param);
		Consumer<String> v33 = (param) -> {} ;
		BiFunction<Integer, Boolean, String> v44 = (x , y) -> String.valueOf(x) + y; 
//		BiFunction<Integer, Boolean, String> v44 = (Integerx , y) -> String.valueOf(x) + y; 		// cf 
//		BiFunction<Integer, Boolean, String> v44 = (x , Booleany) -> String.valueOf(x) + y;  		// cf 
		
		/*
		 * 3. Parameter-list. Compact notaion (without bracket (Klammar))
		 * 
		 * - Only with exactly one parameter
		 * - Only without Parameter typ
		 */	
//		Runnable v111 =  -> {}; 																	// cf 
		Consumer<String> v222 = param -> System.out.println(param);
		Consumer<String> v333 = param -> {} ;
//		BiFunction<Integer, Boolean, String> v444 = x , y -> String.valueOf(x) + y; 		 		// cf 
		
		/*
		 * 4. Rumpf (Body Detailed notation)
		 */
		Runnable v1111 = () -> {};
		Callable<String> v5 = () -> {
			return "mo";
		};
		
		
		/*
		* Body.Compact notation (without the curly bracket, without semicolon, with return without return)
		*
		* - Only if the body consists of exactly one statement
		* - If the statement is the return statement, return must also be removed.
		*/
		 
		Runnable compactRunnable = () -> System.out.println("Compact body with one statement");
	    Consumer<String> compactConsumer = param -> System.out.println(param.toUpperCase());
	    // 3. BiFunction with one statement (return inferred)
	    BiFunction<Integer, Boolean, String> compactBiFunction =  (x, y) -> x + " is " + (y ? "true" : "false");
		
	}
}
