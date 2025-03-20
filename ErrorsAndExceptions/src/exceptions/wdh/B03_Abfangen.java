package exceptions.wdh;

public class B03_Abfangen {

	public static void main(String[] args) {

		System.out.println("a");
		m1();					// Zeile A.
		System.out.println("b");

	}
	/* 
	Run : 
		a
		c
		e
		ex
		d
		b
	*/

	static void m1() {
		System.out.println("c");
		try {
			m2();					// Zeile B.	
		
									// ArithmeticException wird vom m2() geworgen 
									// Der try-Block wird kritische beendet.
									// die ArithmeticException wird dem passenden
									// catch-Bloack übergeben , der aktivieret wird
		} catch (ArithmeticException e) {
			System.out.println("ex");
		}
		
		// hier geht es 
		System.out.println("d");
	}
	static void m2() {
		System.out.println("e");
		System.out.println(5/0);	// ArithmeticException: / by zero wird geworfen
									// Die m2 wird kritisch beendet.
									// Die ArithmeticException wird zu der Zeile B 
									// propogiert.!
		System.out.println("f");
	}
	
}
