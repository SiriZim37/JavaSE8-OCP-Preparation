package aufgaben.a6;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.function.Supplier;

public class IntPositiveA2 {

	public static void main(String[] args) {

		// ###### A2. `IntPositive`
		
		IntPositiveA2 a2 = new IntPositiveA2();
		
		System.out.println("Test1 : 5 , -5 ");
		try {
			
			a2.setValue(5);
			a2.writeValue(-5);
		} catch (IllegalArgumentException  e) {
			System.out.println("IllegalArgumentException : " + e);
		}catch (IOException e) {
			System.out.println("IOException : " + e);
		}
		
		System.out.println("Test2 : -5 , 5 ");
		try {			
			a2.setValue(-5);
			a2.writeValue(5);
		} catch (IOException e) {
	        System.out.println("IOException: " + e);
	    } catch (IllegalArgumentException e) {
	        System.out.println("IllegalArgumentException: " + e);
	    }
		
		System.out.println("Test3 : 5 , 5 ");
		try {			
			a2.setValue(5);
			a2.writeValue(5);
		} catch (IOException e) {
	        System.out.println("IOException: " + e);
	    } catch (IllegalArgumentException e) {
	        System.out.println("IllegalArgumentException: " + e);
	    }
		
		System.out.println("Test4 : -5 , -5 ");
		try {			
			a2.setValue(-5);
			a2.writeValue(-5);
		} catch (IOException e) {
	        System.out.println("IOException: " + e);
	    } catch (IllegalArgumentException e) {
	        System.out.println("IllegalArgumentException: " + e);
	    }
		
	}
	
	private static <E extends Exception>  void checkAndThrow(boolean check, Supplier<E> s)  throws E {
			
		if(!check) {
			throw s.get();
		}
	}

	void setValue(int value)  {
		checkAndThrow(value>0, IllegalArgumentException::new);
	}	
	
//	void writeValue(int value){	 
//		checkAndThrow(value>0, java.io.IOException::new); 	// cf 
//	}
	
	void writeValue(int value) throws IOException {
		checkAndThrow(value>0, java.io.IOException::new);
	}
	
}
