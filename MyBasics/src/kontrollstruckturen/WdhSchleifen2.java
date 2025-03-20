package kontrollstruckturen;

public class WdhSchleifen2 {

	public static void main(String[] args) {
//		b1();
//		b2();
//		b3();
//		b4();
		b5();
	}

	static void b5() {
		int x = 0;
		/*
		 * Ausgaben in der Schleife: 1 2  
		 */
		while(++x < 3) {
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.println("x nach der Schleife: " + x); // 3
	}
	
	static void b4() {
		int x = 0;
		/*
		 * Ausgaben in der Schleife: 1 2 3
		 */
		while(x++ < 3) {
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.println("x nach der Schleife: " + x); // 4
	}
	
	static void b3() {
//		do {
//			
//		} while(true)  // cf: Semikolon fehlt
	}
	
	static void b2() {
		// endlose while
		do {
			System.out.println("b2");
		} while(true);
	}
	
	static void b1() {
		// endlose while
		while(true) {
			System.out.println("b1");
		}
	}
}
