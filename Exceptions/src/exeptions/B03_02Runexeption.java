package exeptions;


/*
 * RuntimeException :  (unchecked exceptions)
 * 			1. NullpointerException
 * 			2. ClassCastException
 * 			3. ArrayIndexOutofBound
 * 			4. ArithmeticException
 * 
 *  		5.IllegalArgumentException
 *  		6.NumberFormatException (Abgeleitete Klass von IllegalArgumentException)
 *  
 *  		7. IllegalStateException
 */
public class B03_02Runexeption {


	  public static void main(String[] args) {

		  
	        triggerNullPointerException();
	        triggerClassCastException();
	        triggerArrayIndexOutOfBoundsException();
	        triggerArithmeticException();
	        triggerIllegalArgumentException();
	        triggerNumberFormatException();
	        triggerIllegalStateException();


	    }


	    public static void triggerNullPointerException() {
	        try {
	            String str = null;
	            str.length(); // This will throw NullPointerException
	        } catch (NullPointerException e) {
	            System.out.println("Caught NullPointerException: " + e);
	        }
	    }

	    public static void triggerClassCastException() {
	        try {
	            Object obj = "Hello";
	            Integer num = (Integer) obj; // This will throw ClassCastException
	        } catch (ClassCastException e) {
	            System.out.println("Caught ClassCastException: " + e);
	        }
	    }

	    public static void triggerArrayIndexOutOfBoundsException() {
	        try {
	            int[] arr = new int[3];
	            int val = arr[5]; // This will throw ArrayIndexOutOfBoundsException
	        } catch (ArrayIndexOutOfBoundsException e) {
	            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e);
	        }
	    }

	    public static void triggerArithmeticException() {
	        try {
	            int result = 10 / 0; // This will throw ArithmeticException
	        } catch (ArithmeticException e) {
	            System.out.println("Caught ArithmeticException: " + e);
	        }
	    }

	    public static void triggerIllegalArgumentException() {
	        try {
	            printPositiveNumber(-5); // This will throw IllegalArgumentException
	        } catch (IllegalArgumentException e) {
	            System.out.println("Caught IllegalArgumentException: " + e);
	        }
	    }

	    public static void printPositiveNumber(int num) {
	        if (num < 0) {
	            throw new IllegalArgumentException("Number must be positive");
	        }
	        System.out.println("The number is: " + num);
	    }

	    public static void triggerNumberFormatException() {
	        try {
	            int num = Integer.parseInt("abc"); // This will throw NumberFormatException
	        } catch (NumberFormatException e) {
	            System.out.println("Caught NumberFormatException: " + e);
	        }
	    }

	    public static void triggerIllegalStateException() {
	        try {
	            throw new IllegalStateException("This is an IllegalStateException");
	        } catch (IllegalStateException e) {
	            System.out.println("Caught IllegalStateException: " + e);
	        }
	    }


}