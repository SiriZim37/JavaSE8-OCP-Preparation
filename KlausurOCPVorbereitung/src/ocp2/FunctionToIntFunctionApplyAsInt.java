package ocp2;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

/*
 
  QUESTION 58
	 Given the code fragment:
	 String str = "Java is a programming language"; 
	 ToIntFunction<String> indexVal = str:: indexOf;  //line n1 
	 int x = indexVal.applyAsInt("Java");        
	 System.out.println(x);
	 What is the result?
	 A. 0
	 B. 1
	 C. A compilation error occurs at line n1.
	 D. A compilation error occurs at line n2.
 
 
 */
public class FunctionToIntFunctionApplyAsInt {

	public static void main(String[] args) {
		
		String str = "Java is a programming language"; 
		ToIntFunction<String> indexVal = str::indexOf;  // line n1
		int x = indexVal.applyAsInt("Java"); 
		System.out.println(x);
		
		
			    
		
	}
}
