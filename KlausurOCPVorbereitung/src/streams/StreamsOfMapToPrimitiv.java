package streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsOfMapToPrimitiv {

	// LongStream , DoubleStream , IntStream
	public static void main(String[] args) {

		Stream<Integer> streamInteger = Stream.of(1,2,3,4,5,6,7);
		IntStream intStream = streamInteger.mapToInt( i -> i); // Integer to int  ( unboxing ) 
		
		
		Stream<Double> streamDouble = Stream.of(1.1, 2.2 , 3.3 , 4.4 , 5.5);
		DoubleStream  doubleSteram= streamDouble.mapToDouble( i -> i); // Double to double  ( unboxing ) 

		
		Stream<Long> streamLong = Stream.of(1_000l,2_000l,3_000l,4_000l,5_000l,6_000l,7_000l);
		LongStream longSteram= streamLong.mapToLong( i -> i); // Double to double  ( unboxing ) 
	}

}
