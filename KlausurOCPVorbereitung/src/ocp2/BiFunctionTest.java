package ocp2;

import java.util.function.BiFunction;

public class BiFunctionTest {

	/*
	 Given the code fragment:
	
	 BiFunction<Integer, Double, Integer> val = (t1, t2) -> t1 + t2;    //line n1
	 System.out.println(val.apply(10, 10.5));
	 What is the result?
	 A. 20
	 B. 20.5
	 C. A compilation error occurs at line n1.
	 D. A compilation error occurs at line n2.
	 */
	public static void main(String[] args) {
		
		
//		BiFunction<Integer, Double, Integer> val = (t1, t2) -> t1 + t2;    //line n1
//		 System.out.println(val.apply(10, 10.5));
		
		
		BiFunction<Integer, Double, Integer> val = (t1, t2) -> (int) (t1 + t2);
		System.out.println(val.apply(10, 10.5));
	}
}
