package ocp;

import java.util.Arrays;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class Funtional10 {
	
	
	public static void main(String[] args) {
		
//		Supplier<List<Double>> s = Arrays.asList(1.0,2.0,3.0,4.0);  // cf
		
		List<Double> list = Arrays.asList(1.0,2.0,3.0,4.0); 
		
		Supplier<List<Double>> s = () -> Arrays.asList(1.0,2.0,3.0,4.0);
		
		for (Double d : s.get()) {
			System.out.println(d);
		}
		
		Supplier<Integer> ss= null;
		IntSupplier is = null ;
		is.getAsInt();
		
		DoubleSupplier ds = null ;
		ds.getAsDouble();
		
		LongSupplier ls = null ;
		ls.getAsLong();
		
		BooleanSupplier bs = null;
		bs.getAsBoolean();
		
		
		
	}

	
}
