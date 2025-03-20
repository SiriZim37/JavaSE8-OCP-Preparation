package exceptions.wdh;

public class B05_Werfen extends B {

	
	public static void main(String[] args) {

		b1();
		b2();
		b22();
	}

	/*
	 * 	Geworfen kann nur etwas vom Typ Throwable
	 */
		
	static void b1() {
//		throw "moin" ; // cf ; String ist nicht Throwable
		
	}
	
	/*
	 * Der Compiler erkennt , dass throw das Ausführen beendet
	 */
	
	static void b2() {
		throw new NullPointerException();
		
//		System.out.println("end of b2");	// cf : Unreachable code
	}
	
	static void b22() {
		final int x = 1 ; 
		
		if(x==1) 
			throw new NullPointerException();
			
		System.out.println("end of b22");	// warning : dead code 
		
		
		
	}
}
