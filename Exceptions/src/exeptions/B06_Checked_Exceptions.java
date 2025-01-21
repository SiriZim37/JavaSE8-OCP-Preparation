package exeptions;

import java.io.IOException;

public class B06_Checked_Exceptions {

	public static void main(String[] args) {


	}
	
	static void m1() {
		throw new RuntimeException();    // unchecked
	}
	
	static void m2() {
//		throw new IOException();    // cf : checked
	}

	static void m22() throws IOException {
		throw new IOException();    // ok
	}

	static void m222() throws Exception  {
		throw new Exception();    // ok
	}
	
	static void someMethod() throws IOException{} // ok 
	
	static void m3() {
//		someMethod(); // cf : checked  : Unhandled exception type IOException
	}
	
	/*
	 * 	1. Möglichkeit eine checed Eception zu berücksichtigen
	 */
	static void m4() { // ok 
		try {
			someMethod();	// deklariert checked Exception
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 	2. Möglichkeit eine checed Eception zu berücksichtigen
	 */
	static void m5() throws IOException {
		someMethod(); 
	}
	
//	static void m6() {	 // cf 
//		try {
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	


}
