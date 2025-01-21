package ocp;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamAverageOptionalDouble2 {

	public static void main(String[] args) {
		
		DoubleStream ds = DoubleStream.of(406.0,407.2,408.1,406.5,407.8);
		OptionalDouble avg = ds.average();
		double avgd = avg.getAsDouble();
		System.out.println(avgd);
		
		
		/*
		 DoubleStream ds = DoubleStream.of(406.0,407.2,408.1,406.5,407.8);
		 
		___F1___ avg = ds.average();
		___F2___ avgd = avg.___F3___();
		System.out.println(avgd);
		
		
		
		Which, inserted independently at F1, F2, and F3, will cause the code to compile and display 407.12 in the console?



			A.
			F1: Optional<Double>, F2: double, F3: getAsDouble
	
	
			B.
			F1: Optional<Double>, F2: Double, F3: getAsDouble
	
	
			C.
			F1: OptionalDouble, F2: double, F3:get`
	
	
			D.
			F1: OptionalDouble, F2: double, F3: getAsDouble
	
	
			E.
			F1: OptionalDouble, F2: Double, F3: get
	
			D is correct. average() returns an OptionalDouble.
	
			A, B, C, and E are incorrect.
	
		*/
	}
}
