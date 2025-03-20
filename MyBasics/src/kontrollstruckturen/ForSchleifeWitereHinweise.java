package kontrollstruckturen;

public class ForSchleifeWitereHinweise {

	public static void main(String[] args) {
//		b1();
//		b2();
//		b3();
//		b4();
		b5();
	}

	static void b5() {
		System.out.println("*** Bsp. 5");
		
		for(int i=0; i<3; i++, System.out.print("a")) {
			System.out.print(i);
		}
		/*
		 * Ausgaben: 0a1a2a
		 */
	}
	
	static void b4() {
		System.out.println("*** Bsp. 4");
		
		int v1, v2;
		int v3 = 3, v4 = 4;
		int v5, v6=6, v7, v8=0;
		
		boolean tmp = false;
		
		/*
		 * Mehrere Schleifenvariablen
		 */
		for(int i1, i2; tmp;) {
			//...
		}
		
		for(int i1=333, i2=111; tmp;) {
			//...
		}

		// Test mit Ausgaben:
		/*
		 * i = 5, k = 1
		 * i = 7, k = 0
		 * i = 9, k = -1
		 */
		for(int i=5, k=1; i<10 && k>-5; i+=2, k--) {
			System.out.println("i = " + i + ", k = " + k);
		}
	}
	
	static void b3() {
		System.out.println("*** Bsp. 3");
		
		/*
		 * Endlose Schleife
		 */
		int x = 3;
		
		for(;x<100 || x+3==707;) {
			System.out.println("laufe...");
		}
		
		System.out.println("moin"); // ok, obwohl die Zeile nicht erreichbar ist
	}
	
	static void b2() {
		System.out.println("*** Bsp. 2");
		
		/*
		 * Endlose Schleife
		 */
		final boolean b = true;
		
		for(;b;) {
			System.out.println("laufe...");
		}
		
		// System.out.println("moin"); // cf: unreachable code
	}
	
	static void b1() {
		System.out.println("*** Bsp. 1");
		
		/*
		 * Endlose Schleife
		 */
		for(;;) {
			System.out.println("laufe...");
		}
		
		// System.out.println("moin"); // cf: unreachable code
	}
	
}
