package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class StreamsOptionalOrOptionalMitTypen {

	public static void main(String[] args) {
		
		// min or max
		
		List<Integer> myList = Arrays.asList( 5 , 10 , 7 , 2 , 8 );
		
		/*
		 *  OptionalInt 
		 */
		OptionalInt  optInt = myList.stream().mapToInt(i -> i).min();
		System.out.println("OptionalInt 	  : " +  optInt.getAsInt() );
		
		/*
		 * Optional<Integer>
		 */
		Comparator<Integer> cmp = ( n1 , n2 ) -> n1 - n2;
		Optional<Integer> optionalInteger = myList.stream().min(cmp);
		System.out.println("Optional<Integer> : " +  optionalInteger.get());

		
		// Average
		
		/*
		 *  OptionalDouble  
		 */
		OptionalDouble  optDouble = myList.stream().mapToInt(i -> i).average();
		System.out.println("OptionalDouble 	  : " +  optDouble.getAsDouble());
		

		
	}

}
