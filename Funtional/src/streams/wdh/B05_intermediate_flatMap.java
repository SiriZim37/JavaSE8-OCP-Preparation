package streams.wdh;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class B05_intermediate_flatMap {

	/*
	 *  <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
	 */
	
	public static void main(String[] args) {
		
		wdh1();
		wdh2();

	}

	 static void wdh2() {
			
		System.out.println("\n***Bsp. 2");
		
		Integer[] a1 = {1,2,3};
		Integer[] a2 = {4,5};
		Integer[] a3 = { 6 , 7, 8};
		Integer[] a4  = {9,10,11,12};
		/*
		 * mit flatMap
		 * 	- aus einem Element eines Streams einen Stream erzeugen,
		 *  - alle solche erzeugten Streams kontateniere.
		 */
		long sCount = Stream.of(a1,a2,a3,a4)			// Elemente sind Array
							.flatMap(Arrays::stream)	// aus jedem Array ein Stream erzeugen und solche Stream konkatenieren.
							.count();					// count Elelemte
			
		System.out.println("count : " + sCount);
	 }
	 
	 static void wdh1() {
		System.out.println("***Bsp. 1");
		
		Integer[] a1 = {1,2,3};
		Integer[] a2 = {4,5};
		
		Stream<Integer> s1 = Stream.of(a1);
		Stream<Integer> s2 = Stream.of(a2);
		
		Stream<Integer> sA = Stream.concat(s1, s2);		//Daten : 1 2 3 4 5
		
		Integer[] a3 = { 6 , 7, 8};
		
		Stream<Integer> s3 = Stream.of(a3);
		
		Stream<Integer> sB = Stream.concat(sA , s3);    //Daten : 1 2 3 4 5 6 7 8
		
		Integer[] a4  = {9,10,11,12};
		
		Stream<Integer> s4 = Stream.of(a4);
		
		Stream<Integer> sC = Stream.concat(sB, s4);     //Daten : 1 2 3 4 5 6 7 8 9 10 11 12
		
		long count = sC.count();
		
		System.out.println("count : " + count);
	 }
	 
}
