package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class B02_Streams_erzeugen {

	public static void main(String[] args) {

		System.out.println("***Stream einer Collection-------------------------------");
		
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8));
		
		/*
		 * Stream aus einer Collection erzeugen
		 */
		Stream<Integer> streamCollection= list.stream();
		streamCollection.forEach(System.out::println);
		
		
		
		System.out.println("\n***Stream aus Array-------------------------------");
		/*
		 * Stream aus Array erzeugen
		 */
		
		Integer[] arr = { 10 , 11 ,12 ,13 ,14 ,15 ,16 ,17};
		
		
		/*
		 *  vorher : 10 11 12 13 14 15 16 17
		 */
		Stream<Integer> streamArray = Arrays.stream(arr);
		streamArray.forEach(System.out::println);
		
		System.out.println();
		/*	
		 * Stream aus Array (specified) erzeugen 
		 * 			 0   1   2  3   4  5  6  7
		 *  vorher : 10 11  12  13  14 15 16 17
		 *  nacher : 10 11  12  13
		 */
		streamArray = Arrays.stream(arr , 0 , 4 ); //  (Inklusive 0 to exklusive 4 )
		streamArray.forEach(System.out::println);
		
		
		System.out.println("\n***Stream mit statische Methode 'of'-------------------------------");
		/*
		 * Stream mit statische Methode 'of' erzeugen
		 */
		Stream<Integer> streamOfInt = Stream.of(1,2,3,4,5,6,7);
		streamOfInt.forEach(System.out::println);
		
		System.out.println();
		
		
		Stream<String> streamOfString = Stream.of("Montag" , "Di");
		streamOfString.forEach(System.out::println);
		
		System.out.println("\n***Stream Empty");
		
		/*
		 * Stream Leerer
		 */
		Stream<Integer> streamEmpty = Stream.empty();
		streamEmpty.forEach(System.out::println);
		
		
		System.out.println("\n***Stream Generate mit Supplier-------------------------------");
		
		/*
		 * Generate mit Supplier (Liferant für Object)
		 * Nur im Zusammenhang mit limit sinnvoll !
		 * 
		 * 		<T> Stream<T> generate(Supplier<? extends T> s)
		 * 
		 */
//		Supplier<Integer> sup = () -> 42 ;
//		Stream.generate(sup).forEach(System.out::print);   // infinity loop
		
		
		/*
		 * Random Num Max 6 Number:  33	26 	37	32	8  24
		 */
		Supplier<Integer> sup = () -> new Random().nextInt(49)+1;
		Stream.generate(sup).limit(6).forEach(System.out::println);   
		
		System.out.println("\n***Iterate mit Seed und UnaryOperator-------------------------------");
		/*
		 * Iterate mit Seed und UnaryOperator
		 * Nur im Zusammenhang mit limit sinnvoll !
		 * 
		 * 		<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
		 * 			: seed the initial element
		 * 			: UnaryOperator produce a new element
		 */
		UnaryOperator<Integer> unaryOperator =  i -> i+1;
		Stream.iterate(100, unaryOperator).limit(10).forEach(System.out::println);   
	
	
		System.out.println("\n***Stream mit Zufallszahlen-------------------------------");
		/*
		 * Stream mit Zufallszahlen
		 */
		Random rnd = new Random();
		
		/*
		 * IntStream ints(long streamSize)
		 */
		rnd.ints(30).forEach(System.out::println);
		
		/*
		 *  IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) 
		 */
		rnd.ints(6 , 1 , 50).forEach(System.out::println);
		
		
		System.out.println("\n***Stream aus String-------------------------------");
		/*
		 *Stream aus String
		 *
		 *	<U> Stream<U> mapToObj(IntFunction<? extends U> mapper);
		 *
		 *  IntStream chars() 
		 */
		String s = "Das ist das Haus von Nikolus";
		
		s.chars().mapToObj( c -> (char) c ).forEach(System.out::println);
		
	}

}
