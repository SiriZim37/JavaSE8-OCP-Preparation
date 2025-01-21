package func;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class B07_JavaUtilFucntion {

	public static void main(String[] args) {
		/*
		 * Überblick:
		 * 
		 * https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
		 */
		
		/*
		 * Die vier wichtigsten Interfaces : 
		 * 
		 *  - Predicate<T>	  		: 
		 *  		: boolean test(T t)
		 *  		- Represents a predicate (boolean-valued function) of one argument. 
		 *  - Consumer<T>
		 *  		: void accept(T t); 
		 *  		- Represents an operation that accepts a single input argument and returns no result.
		 *  - Supplier<T>  
		 *  		: T get();
		 *  		-  Represents a supplier of results.  
		 *  - Function<T,R>	
		 *  		: R apply(T t);
		 *  		- Represents a function that accepts one argument and produces a result.
		 */

		/*
		 * Gruppe der Bi- und Binary-Interface
		 * 
		 * - BiConsumer<T,U>  
		 * 			:  void accept(T t, U u) 
		 * 			- Represents an operation that accepts two input arguments and returns no result.
		 * - BiFunction<T,U,R>	
		 * 			:  R apply(T t, U u)
		 * 			- Represents a function that accepts two arguments and produces a result.
		 * - BiPredicate<T,U>  
		 * 			: boolean 	test(T t, U u)	
		 * 			- Represents a predicate (boolean-valued function) of two arguments.
		 * - BinaryOperator<T>	(BinaryOperator <T> extends BiFuntion<T, T, T>)
		 * 			: R apply(T t, U u);
		 * 			- Represents an operation upon two operands of the same type, producing a result of the same type as the operands.
		 */
		
		/*
		 * Gruppe der Operatoren
		 * - UnaryOperator<T>	(Interface UnaryOperator<T> extends Function<T, T>)
		 * 			 : R apply(T t);
		 * 			- Represents an operation on a single operand that produces a result of the same type as its operand.
		 * - BinaryOperator<T>	
		 * 			 : R apply(T t, U u);
		 * 			- Represents an operation upon two operands of the same type, producing a result of the same type as the operands.

		 */
		
		
	}

}
