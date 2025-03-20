package aufgaben;

public class AufgabeMethodenRekursion {

	public static void main(String[] args) {
		
		System.out.println("*** A1");
		testGetFaultaetRekursiv(-22, -1); // negative Werte sind nicht erlaubt
		testGetFaultaetRekursiv(0, 1);
		testGetFaultaetRekursiv(1, 1);
		testGetFaultaetRekursiv(3, 6);
		testGetFaultaetRekursiv(10, 3_628_800);
		testGetFaultaetRekursiv(12, 479_001_600 );
		testGetFaultaetRekursiv(13, 0); // 13 kann nicht mehr berechnet werden
		
		System.out.println("\n*** A2");
		testGetFaultaet(-22, -1); // negative Werte sind nicht erlaubt
		testGetFaultaet(0, 1);
		testGetFaultaet(1, 1);
		testGetFaultaet(3, 6);
		testGetFaultaet(10, 3_628_800);
		testGetFaultaet(12, 479_001_600 );
		testGetFaultaet(13, 0); // 13 kann nicht mehr berechnet werden
	}
	
	static int getFakultaet(int n) {
		if(n<0) {
			return -1;
		}
		if(n>12) {
			return 0;
		}
		
		int result = 1;
		for(int i=1; i<=n; i++) {
			result *= i;
		}

		return result;
	}
	

	/*
	 * return 3 * getFakultaetRekursiv(2) {
	 * 					return 2 * getFakultaetRekursiv(1) {
	 * 									return 1;
	 *           				   }
	 *            }
	 */
	static int getFakultaetRekursiv(int n) {
		if(n>12) {
			return 0; // 0 liefern, wenn das Argument zu int-Iverflow führt
		}
		
		if(n<0) {
			return -1; // negative Werte werden nicht akzeptiert 
		}
		
		if(n==1 || n==0) {
			return 1;
		}
		
		return n * getFakultaetRekursiv(n-1);
	}
	
	static void testGetFaultaetRekursiv(int n, int expected) {
		int actual = getFakultaetRekursiv(n);
		
		if(expected!=actual) {
			System.out.println("Fehler bei " + n + "! expected: " + expected + ", actual: " + actual);
		} else {
			System.out.println(n + "! = " + actual);
		}
	}

	static void testGetFaultaet(int n, int expected) {
		int actual = getFakultaet(n);
		
		if(expected!=actual) {
			System.out.println("Fehler bei " + n + "! expected: " + expected + ", actual: " + actual);
		} else {
			System.out.println(n + "! = " + actual);
		}
	}
}
