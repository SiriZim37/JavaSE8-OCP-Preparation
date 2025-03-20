package exceptions.wdh;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;

public class B07_checked_und_unchecked {

	public static void main(String[] args) throws IOException {
		myMethod();		// deklariert IOException
		
		try {
			DateFormat.getDateInstance().parse("1.1.2003");	// handlung checked Exception
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		int n =	Integer.parseInt("12");	// deklariert unchecked Exception
	}
	
	static void m0() {
		throw new ArithmeticException();
//		System.out.println("");		// cf : Unreachable code
	}
	
	/*
	 * Compiler überprüft bei einer potentiellen checked 
	 * Exception, ob der Entwickler die Möglichkeit
	 * berücksichtigt.
	 * 
	 * Bei unchecked Exception wird der Compiler es nicht überprüfen.
	 */
	static void m1() {
		throw new ArithmeticException();	// unchecked 
	}
	
	static void m2()  {
//		throw new IOException();	// cf : checked 
	}
	
	/*
	 * Cehcked Exception berücksichtigen. 
	 * 
	 * Variante 1 : try-catch
	 */
	static void m3() {
		try {
			throw new IOException();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Cehcked Exception berücksichtigen. 
	 * 
	 * Variante 2 : throws
	 */
	static void m4() throws IOException {
		throw new IOException();
	}
	
	/*
	 * Auch nur potentielle Möglichkeit einer checked Exception 
	 * muss berücksichtigt werden
	 */
	static void myMethod() throws IOException{}
	
	static void m5() {
//		myMethod(); 	// cf : Es muss behandeln oder declarieren 
						// checked Exception laut throws-Klasusel möglich
	}
	
	static void m6() throws IOException {
		myMethod();
	}
	
	static void m7(){
		try {
			myMethod();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
