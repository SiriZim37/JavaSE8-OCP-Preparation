package exeptions;

import java.util.ArrayList;
import java.util.List;

public class B03_03Error {

	 /*  3. Error 
	 *  		1. StackOverflowError
	 *  		2. OutOfMemoryError
	 *  		3. NoClassDefFoundError
	 *  		4. VirtualMachineError 
	 *  		5. UnknownError
	 */
	
	  public static void main(String[] args) {


		  try {
	            triggerStackOverflowError();
	      } catch (StackOverflowError e) {
	            System.out.println("Caught StackOverflowError: " + e);
	      }
		  
		  
		  try {
	            triggerOutOfMemoryError();
	      } catch (OutOfMemoryError e) {
	            System.out.println("Caught OutOfMemoryError: " + e);
	      }
		  
		  try {
	           triggerNoClassDefFoundError();
	      } catch (NoClassDefFoundError e) {
	           System.out.println("Caught NoClassDefFoundError: " + e);
	      }
 
	 }

	 
	    public static void triggerStackOverflowError() {
	        // Recursive call with no base case, leading to StackOverflowError
	        triggerStackOverflowError();
	    }
	    
	    public static void triggerOutOfMemoryError() {
	        // Attempt to create a huge list of objects, leading to OutOfMemoryError
	        List<int[]> memoryHog = new ArrayList<>();
	        while (true) {
	            memoryHog.add(new int[1_000_000]); // Allocating large arrays repeatedly
	        }
	    }
	    
	    public static void triggerNoClassDefFoundError() {
	        // Manually simulate the error if you try to reference a non-existing class.
	        throw new NoClassDefFoundError("Simulating NoClassDefFoundError");
	    }
}