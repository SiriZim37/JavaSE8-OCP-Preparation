package errors;

import java.util.ArrayList;
import java.util.List;

public class B001_StackOverflowErrorErkennen {

	
	/*
	 * Exam : 
	 * 
	 * 	- eine (auch endlose) Schleife ist kein Grund für StackOverflow
	 * 	
	 * 
	 * 	- StackOverflowError ist unendlicher rekursiver Aufruf
	 * 	  Rekursiver Aufruf ohne Abbreuch verursacht StackOverflowError !! *** 
	 */
	
	public static void main(String[] args) {
	
//		dasIstNichtStackOverflow();				// compiler ohne error
		
//		dasIstStackOverflowError();				// StackOverflowError
		
//		print(0);								// StackOverflowError
				
		testArrayInWhhileSchleife(); 			//  OutOfMemoryError 

	}
	
	/*
	 * Es ist nicht StackOverflowError 
	 * 
	 * Ausgaben : 
	 * 			OutOfMemoryError: Java heap space
	 */
	static void testArrayInWhhileSchleife() {
		
		List<Integer> list = new ArrayList<>();
		while (true) {
			list.add(5);
		}
		
	}
	
	/*
	 * Ausgaben : 0 0 0 ... StackOverflowError
	 */
	
	static void print(int x) {
		if(x>3) {
			return;
		}
		System.out.println(x);
		print(x++);
		
	}
	/*
	 * StackOverflowError
	 */
	static void dasIstStackOverflowError() {
		dasIstStackOverflowError();
	}
	
	/*
	 * Methode hat eine endlose Schleife aber kein StackOverflowError
	 */
	static void dasIstNichtStackOverflow() {
		for (int i = 0; i < 1_000; i++) {
			if( i > 100) {
				i = 0;		// kein StackOverflow#
			}
		}
	}

}
