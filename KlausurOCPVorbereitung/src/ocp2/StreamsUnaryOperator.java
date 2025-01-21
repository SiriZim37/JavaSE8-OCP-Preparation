package ocp2;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;


/*
  Given the code fragment:
 UnaryOperator<Integer> uo1 = s -> s*2;        line n1
 List<Double> loanValues = Arrays.asList(1000.0, 2000.0); line n1
 loanValues.stream()
    .filter(lv -> lv >= 1500)
	.map(lv -> uo1.apply(lv))
    .forEach(s -> System.out.print(s + “ “));
 What is the result?
 A. 4000.0
 B. 4000
 C. A compilation error occurs at line n1.
 D. A compilation error occurs at line n2.
 
 
 
 Correct Answer: D
 */
public class StreamsUnaryOperator {

	
	public static void main(String[] args) {
		
		 UnaryOperator<Double> uo1 = s -> s*2;       
		 List<Double> loanValues = Arrays.asList(1000.0, 2000.0);
		 loanValues.stream()
		    .filter(lv -> lv >= 1500)
		     .map(lv -> uo1.apply(lv))
		    .forEach(s -> System.out.print(s + " "));
		    
		 
	}
}
