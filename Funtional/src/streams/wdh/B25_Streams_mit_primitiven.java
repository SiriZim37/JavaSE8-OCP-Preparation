package streams.wdh;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class B25_Streams_mit_primitiven {

	/*
	 * 	XxxStream. Xxx steht für Int , Long , Double : 
	 * 
	 * 		IntStream
	 * 		LongStream
	 * 		DoubleStream
	 */
	public static void main(String[] args) {
		
		/*
		 * 	- Erzeugen und Datenquelle besteimmen änhlich wie Stream<T>
		 * 	- Intermediate Operation ähnlich wie im Stream<T>
		 * 	- Terminal Operations ähnlich wie im Stream<T>
		 */
		
		IntStream.of(11,-7,22,3,5,-4)
				 .filter( i -> i > 0 )
				 .map( i ->  i*2)					// IntStream 
				 .forEach(System.out::println);
		
		System.out.println("\n-------------------------------------------------------------------------"); 
		
		Stream.of(11,-7,22,3,5,-4)
			 .filter( i -> i > 0 )					// Stream <Integer>
			 .map( i ->  i*2)						// Stream <Integer>
			 .forEach(System.out::println);
		
		Stream.of(11,-7,22,3,5,-4)
			 .filter( i -> i > 0 )					// Stream <Integer>
			 .mapToInt( i ->  i*2)					// IntStream 
			 .forEach(System.out::println);
		
		System.out.println("\n-------------------------------------------------------------------------"); 
		
		
		/*
		 * Spezielle terminal Operations
		 */
		
		double sum = DoubleStream.iterate(1.0 , d -> d + 1.0)	// DoubleStream
								 .limit(3)						// DoubleStream
								 .sum();						// double
		
		System.out.println("sum : " + sum);		// 6.0
	}

}
