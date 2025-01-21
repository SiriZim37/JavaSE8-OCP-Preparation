package ocp2;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class CollectionUnaryOpertator {

	/*
	 
	 QUESTION 54
	 Given the code fragment:
	 List<Integer> codes = Arrays.asList (10, 20);
	 UnaryOperator<Double> uo = s -> s +10.0;
	 codes.replaceAll(uo);
	 codes.forEach(c -> System.out.println(c));
	
	 What is the result?
	 A. 20.0
	 30.0
	 B. 10
	 20
	 C. A compilation error occurs.
	 D. A NumberFormatException is thrown at run time.
 
	 */
	
	
	public static void main(String[] args) {
		
//		List<Integer> codes = Arrays.asList (10, 20);		// cf : es muss DOuble
		List<Double> codes = Arrays.asList(10.0, 20.0);   
		UnaryOperator<Double> uo = s -> s + 10.0;
		codes.replaceAll(uo);
		codes.forEach(c -> System.out.println(c));
		
	}
}
