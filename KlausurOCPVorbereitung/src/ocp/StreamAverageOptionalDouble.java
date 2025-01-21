package ocp;

import java.util.OptionalDouble;
import java.util.stream.Stream;

public class StreamAverageOptionalDouble {

	public static void main(String[] args) {
	
		Stream<Double> ds = Stream.of(406.0, 407.2, 408.1, 406.5, 407.8);
		OptionalDouble avg = ds.mapToDouble(l -> l.doubleValue()).average();
		avg.ifPresent(System.out::println);
		
		/*
		Stream<Double> ds = Stream.of(406.0, 407.2, 408.1, 406.5, 407.8);
		OptionalDouble avg = ____F1____;
		avg.ifPresent(System.out::println);
		
		
		 Which, inserted independently at F1, will allow the code to compile
		  and produce the average of the values in the stream ds?
		
		A.ds.average();

		B.ds.average().getAsDouble();

		C.ds.mapToDouble(l -> l.doubleValue()).average()

		D.ds.map(l -> l.doubleValue()).average()

		E.ds.map(l -> l.getAsDouble()).average()
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		C is correct. We have a Stream<Double> so we first need to map this to a DoubleStream (a stream of double values), which we do with mapToDouble(). Once we have double values, we can take the average(), which produces an OptionalDouble.
		
		A, B, D, and E are incorrect.
		 */
	}
}
