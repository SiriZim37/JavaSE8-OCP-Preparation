package streams;

import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamsAverage {

	public static void main(String[] args) {

		/*
		 * OptionalDouble average() !!! 
		 * 
		 * funktioniert nur mit primitive type:  ( int double , long )
		 * 
		 * Integer -> stream.mapToInt( i -> i.intValue())
		 * Long -> stream.mapToLong( i -> i.doubleValue())
		 * Double -> stream.mapToDouble( i -> i.longValue())
		 */
		
		Stream<Integer> stream = Stream.of(3, 4, 2, 1, 6, 5, 4, 3, 2, 1, 4, 5, 3, 2);
		
		IntStream intStream = IntStream.of(3, 4, 2, 1, 6, 5, 4, 3, 2, 1, 4, 5, 3, 2);
		
		OptionalDouble op1 =  stream.mapToInt( i -> i.intValue()).average();
		System.out.println(op1);
		OptionalDouble op2 =  intStream.average();
		System.out.println(op1);
		
		
//		OptionalDouble op1 =  intStream.mapToInt( i -> i.intValue()).average(); // cf 
		
		
//		Double aveAge = stream.mapToDouble(d -> d).average();					 // cf 

	}

}
