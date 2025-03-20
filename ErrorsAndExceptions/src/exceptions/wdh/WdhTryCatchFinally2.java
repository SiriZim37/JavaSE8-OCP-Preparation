package exceptions.wdh;

import java.io.IOException;

	/*
	 * Was ist das Ergebnis : 
	 * A.   a b d f 
	 * B.  a d e f
	 * C. a gefoglt von einer nicht abgefangene  Exception
	 * D. a b d e f  
	 * 
	 * Antwort : B. a d e f
	 */



public class WdhTryCatchFinally2 {


	public static void main(String[] args) {

		try {
			try {
				System.out.print("a");
				m();
				System.out.print("b");
			} catch (RuntimeException e) {
				System.out.print("c");
			}finally {
				System.out.print("d");
			}
			
		} catch (Exception e) {
			System.out.print("e");
		}finally {
			System.out.print("f");
		}

	}
	
	static void m() throws IOException {
		throw new IOException();

	}

}
