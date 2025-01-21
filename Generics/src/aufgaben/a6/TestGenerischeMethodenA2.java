package aufgaben.a6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Random;
import java.util.function.Supplier;

public class TestGenerischeMethodenA2 {

	public static void main(String[] args) {

		// ###### A2. `IntPositive`	
		TestGenerischeMethodenA2 a1 = new TestGenerischeMethodenA2();
		
		System.out.println("Test1 : 5 , -5 ");
		try {	
			a1.setValue(5);
			a1.writeValue(-5);	
		}catch (IOException e) {
			System.out.println("IOException : " + e);
		} catch (IllegalArgumentException  e) {
			System.out.println("IllegalArgumentException : " + e);
		}
		
	}

	// ###### A2. `IntPositive`
	private static <T extends Exception>  void checkAndThrow(boolean check, Supplier<T> s)  throws T {
		
		if(!check) {
			throw s.get();
		}
	}

	void setValue(int value)  {
		/*
		 *  IllegalArgumentException::new
		 *  
		 * 	class Blabla implements Supplier<Exception>{
		 * 		public Exception get(){
		 * 			return new IllegalArgumentException
		 * 		}
		 * 	}
		 */
		checkAndThrow(value>0, IllegalArgumentException::new);
	}	
	
//	void writeValue(int value){	 
		/*
		 *  java.io.IOException::new
		 * 	class Blabla implements Supplier<Exception>{
		 * 		public Exception get(){
		 * 			return new java.io.IOException
		 * 		}
		 * 	}
		 */
//		checkAndThrow(value>0, java.io.IOException::new); 	// cf 
//	}
	
	void writeValue(int value) throws IOException {
		checkAndThrow(value>0, java.io.IOException::new);
//		checkAndThrow(value>0, StackOverflowError::new);		// cf 
	}
	
}
