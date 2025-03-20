package methoden;

public class B10_Rekursion {

	/*
	 * Rekursiver Aufruf: eine Methode ruft sich selbst auf
	 */
	public static void main(String[] args) {
		
		int result = sum(5);
		System.out.println("1. result = " + result); // 15

		result = sumRekursiv(5);
		System.out.println("2. result = " + result); // 15
	}

	/*
	 * Summe der Werte 1 bis to. Rekursiv
	 * 
	 * return 5 + sumRekursiv(4){
	 * 				  return 4 + sumRekursiv(3) {
	 * 								return 3 + sumRekursiv(2) {
	 * 												return 2 + sumRekursiv(1) {
	 * 																return 1;
	 * 														    }
	 * 										   }
	 * 							 }
	 * 			  }
	 */
	static int sumRekursiv(int to) {
		if(to<=0) {
			return -1;  // Methode kann von 0 bis negativ nicht addieren
		}
		
		if(to==1) {
			return 1;
		}
		
		return to + sumRekursiv(to-1);
	}
	
	/*
	 * Summe der Werte 1 bis to. Iterativ
	 */
	static int sum(int to) {
		if(to<=0) {
			return -1; // Methode kann von 0 bis negativ nicht addieren
		}
		
		int result = 0;
		for(int i=1; i<=to; i++) {
			result += i;
		}
		return result;
	}
}
