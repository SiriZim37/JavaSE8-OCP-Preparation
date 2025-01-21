package streams.wdh;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class B03_intermediate_skip_limit {

	/*
	 *   Stream<T> skip(long n)
	 *   
	 *   Stream<T> limit(long maxSize)
	 */
	
	public static void main(String[] args) {
		
		System.out.println("***Bsp. 1");
		
		Stream.of(1,2,3,4,5,6,7,8,9)
				.skip(3)					// 1 2 3 wurde wegschmeizen dann : 4 5 6 7 8 9
				.limit(2)					// 4 5
				.forEach(System.out::println);	 // Ergebnis :  4 5
		
		System.out.println("***Bsp. 2");
		Stream.of(1,2,3,4,5,6,7,8,9)
				.limit(2)						 // nur 1 2 
				.skip(3)						 // _______	
				.forEach(System.out::println);	 // Ergebnis :  keine Ausgaben
		
		
		System.out.println("\n*** Bsp. 3");
		
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
			.limit(5)
			.skip(3)
			.forEach(System.out::println); // 4, 5
		
	}

}
