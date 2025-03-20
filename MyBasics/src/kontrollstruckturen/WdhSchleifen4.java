package kontrollstruckturen;

public class WdhSchleifen4 {

	public static void main(String[] args) { 
		b5(); 
	}
	
	static void b5() {
		for (int i = 0; i < 3; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	static void b4() {
//		System.out.println("*** Bsp. 4");

		tom:
		for (int i = 0; i < 3; i++) {
			
			int x = 0;
			while (x < 3) {
				if(x==1) {
					continue tom;
				}
				x++;
			}
			
			System.out.print(i + " ");
		}
		
		System.out.println("done");
	}
	
	static void b3() {
		System.out.println("*** Bsp. 3");
		
		for (int i = 0; i < 3; i++) {
			
			int x = 0;
			/*
			 * Läuft endlos mit x = 1
			 */
			while (x < 3) {
				if(x==1) {
					continue;
				}
				x++;
			}
			
			System.out.print(i + " ");
		}
		
		System.out.println("done");
	}
	
	static void b2() {
		int x = 0;
		tom:
		while(x==1) {
			break tom;
		}
//		while(x==0) {
//			if(x==0) break tom; // cf: tom ist nicht definiert 
//		}
		System.out.println(x);
	}
	
	static void b1() {
//		int x = 0;
//		do { x--; } 
//		while(x==1)				// cf: Semikolon fehlt
//		System.out.println(x);
	}

}
