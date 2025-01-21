package func;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class B13_Operator_Interfaces {

	public static void main(String[] args) {
		// zum Vergleich: Function
		Function<Integer, Integer> f1 = (Integer param) -> param * 2;
				
		/*
		 * interface UnaryOperator <T> extends Function <T, T>
		 */
		UnaryOperator<Integer> f2 = (Integer param) -> param * 2;
		System.out.println(f2.apply(5));
		
		
		// zum Vergleich: BiFunction
		BiFunction<Integer, Integer, Integer> f3 = 
				(Integer param1, Integer param2) -> param1 + param2;
						
		/*
		 * interface BinaryOperator <T> extends BiFuntion<T, T, T>
		 */
		BinaryOperator<Integer> f4 = 
				(Integer param1, Integer param2) -> param1 + param2;
				
		System.out.println(f4.apply(5, 5));
		System.out.println(f4.andThen(f1));
		
	}

}
