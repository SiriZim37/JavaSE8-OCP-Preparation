package exceptions.wdh;

public class B02_Propagieren {

	public static void main(String[] args) {
		System.out.println("a");
		m1();						// Zeile A.
									// ArithmeticException wird hier auftauchen
									// Anders gesagt : m1 hat ArithmeticException
									// geworfen.
									// Die 'main' wird kritische beendet.
									// Die Exception wird zu der Stelle.
									// im Code der JVM propagiert, wo die main aufgerufen wurde.
		System.out.println("b");
	}

	/* 
	Run : 
		a
		c
		e
		g
		Exception in thread "main" java.lang.ArithmeticException:
	*/
	
	static void m1() {
		System.out.println("c");
		m2();					// Zeile B.
								// ArithmeticException wird hier auftauchen
								// Anders gesagt : m2 hat ArithmeticException
								// geworfen.
								// Die m1 wird kritische beendet.
								// Die Exception wird zu der Zeile B
								// propagiert.!
		System.out.println("d");
	}
	
	static void m2() {
		System.out.println("e");
		m3();					// Zeile C.
								// ArithmeticException wird hier auftauchen
								// Anders gesagt : m3 hat ArithmeticException
								// geworfen.
								// Die m1 wird kritische beendet.
								// Die Exception wird zu der Zeile B
								// propagiert.!
		
		
		System.out.println("f");
	}

	static void m3() {
		System.out.println("g");
		System.out.println(5/0);	// ArithmeticException: / by zero wird geworfen
									// Die m3 wird kritisch beendet.
									// Die Exception wird zu der Zeile C propogiert.!
		System.out.println("5");
	}
}
