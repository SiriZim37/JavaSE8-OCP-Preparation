package oca;

public class ExceptionExamTheories {
/*
 * Assume are creating a methode that u know might thrown checked Exception  which are true?
 * 
 *  A: Your methode signature must declare that an exception might be thrown 
 *  
 *  **** correct B: The methode can optionally include a finally clause 
 *  
 *  C: the methode return an object that extends java.lang.Exception (Choose all that apply)? 
 */
	
	public static void main(String[] args) {
		 try {
	            System.out.println("A");
	            throw new NullPointerException();
	        } catch (ArithmeticException e) {
	            System.out.println("B");
	        } finally {
	            System.out.println("C");
	        }
	}
}
