package exceptions.wdh;

import java.io.IOException;

public class B08_thorws_Klausel {

	public static void main(String[] args) {
		try {
			throw new IOException();
		} catch (Exception e) {
			System.out.println('d');
	
		}

	}
	/*
	 * Die Methode mit throws muss keine Exception werfen
	 */
	static void m1() throws ArithmeticException{
		
	}

	/*
	 * Die Methode , die eine 'unchecked' Exception wirft ,
	 * muss sie nicht in der throws-Klausel deklarieren
	 */
	static void m2() {
		throw new ArithmeticException();
	}
	static void m22() {
		throw new IllegalStateException();
	}
	
	/*
	 * Die Methode , die eine 'checked' Exception wirft und diese
	 * nicht behandeln kann/will , muss die checked Exception 
 	 * in der throws-Klausel deklarieren
	 */
	static void m3() throws IOException {
		throw new IOException();
	}
	
	/*
	 * Die Methode , die eine 'checked' Exception wirft und diese
	 * nicht behandeln kann/will ,kann auch die Basistyp-checked-Exception 
 	 * in der throws-Klausel deklarieren
	 */
	static void m4() throws Exception{
		throw new IOException();
	}
	
//	static void m5() throws IOException{ 
//		throw new Exception();		// cf :  The Exception class is the parent class of all checked exceptions (except RuntimeException and its subclasses). 
//								   // However, IOException is a specific type of Exception and is not a superclass of Exception.
//	}
	
	/*
	 * Eine Methode kann mehrere Exceptions in der 
	 * throws-Klausel deklarieren
	 */

	static void m6() throws  IOException , Exception {
		throw new IOException();
		
	}
	


}
