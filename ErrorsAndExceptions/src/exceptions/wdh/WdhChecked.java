package exceptions.wdh;

import java.io.IOException;
import java.sql.SQLException;

public class WdhChecked {

	public static void main(String[] args)  {
		/*
		 * try-Analyse : 
		 * 			der Compiler analysiert den try-Block nach 
		 * 			potentellen checked-Exceptions  
		 */
		try {
			
		} catch (ArithmeticException e) {	// ok , unchecked
			e.printStackTrace();
		}	
		/*s
		 * Der Compilierfehler ist nicht in der Prüfung: 
		 */
//		try {
//			
//		} catch (IOException e) {	 // cf : unreachable checked  Ex.-catch-Block
//			//..
//		}
		
	
		try {
			throw new IOException();  //ok behalbeln oder deklarieren
		} catch (IOException e) {	
			//..
		}
		
		try {
			
		} catch (Exception e) {	 // ok , kann auch unchecked-Exceptions abfangen
			//..
		}
		
		try {
			
		}catch (RuntimeException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			
		}catch (RuntimeException e) {
//			try {
//			} catch (Exception e) { // cf : e kann nicht noch mal benutzen.
//				//...
//			}
			
			try {
				
			} catch (Exception e2) { // ok : 
				//...
			}
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	static void m1(){
		RuntimeException e = new ArithmeticException();
		throw e;
	}
	
	static void m2() {
		Exception e = new ArithmeticException();
//		throw e;	// cf :  e referenziert evtl. checked Exceptioon
	}

	static void m3() throws Exception{ // oder throws IOException{
		throw new IOException();
	}
	
	static void m4() throws SQLException, IOException {
		try {
			mmm();
		} catch (Exception e) {
			 e = new Exception();  // ok
			 e = new IOException(); // ok
			 e = new SQLException(); // ok
		}
		
		try {
			mmm();
		} catch (Exception e) {
			throw e;  // ok 
		}
		
		try {
			mmm();
		} catch (SQLException| IOException e) {
			throw e;  // ok 
		}
		
//		try {
//			mmm();
//		} catch (SQLException| IOException e) {
//			e = new IOException();  // cf The parameter e of a multi-catch block cannot be assigned
//			throw e;  				// cf Unhandled exception type Exception
//		}
		
		try {
			mmm();
		} catch (SQLException e) {
			throw e;  // ok 
		} catch (IOException e) {
			throw e;  // ok 
		}
		
	}
	static void mmm() throws SQLException , IOException{}
	
}
