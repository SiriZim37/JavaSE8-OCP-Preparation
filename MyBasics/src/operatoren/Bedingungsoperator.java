package operatoren;

public class Bedingungsoperator {

	/*
	 * Bedingungsoperator ist ein ternärer Operator 
	 * (hat drei Operanden)
	 */
	public static void main(String[] args) {
		
		/*
		 *  a ? b : c
		 *  
		 *  	a ist ein boolean!
		 */
		
		int x = 12;

		char ch = x > 0 ? 'p' : 'o';
		System.out.println("ch = " + ch); // p
		
		double v1 = x > 100 ? 7.2 : -3; // double <- double
		
//		int v2 = x == 5 ? true : 33; // cf: int v2 soll sowohl true als auch 33
									 //     kopiert werden können
//		int v2 = (int) (x == 12 ? true : 33);	 		// Exception : ClassCastExeption
//		int v22 = (int) (x == 12 ? "Test" : 33);	 	// Exception : ClassCastExeption
//		int v222 = (int) (x == 12 ? 3e2 : 33);	 		// Exception : ClassCastExeption
//		System.out.println("v2 = " + v2);
//		System.out.println("v22 = " + v22);
//		System.out.println("v222 = " + v222);
		
		String v3 = x > 0 ? "positiv" : "negativ oder 0";
		System.out.println("v3 = " + v3); // positiv
	
		/*
		 * Verschachteln
		 */
		
		float f = 3.1f;
		
		String tmp = f < 0 ? "negativ" : "Null";
		String result2 = f > 0 ? "positiv" : tmp;
		
		String result = f > 0 ? "positiv" : f < 0 ? "negativ" : "Null";
		
		System.out.println("f = " + f); // 3.1
		System.out.println("f ist " + result); // positiv
		
		f = -12;
		
		result = f > 0 ? "positiv" : f < 0 ? "negativ" : "Null";
		
		System.out.println("f = " + f); // -12.0
		System.out.println("f ist " + result); // negativ
		
		f = 0;
		
		result = f > 0 ? "positiv" : f < 0 ? "negativ" : "Null";
		
		System.out.println("f = " + f); // 0.0
		System.out.println("f ist " + result); // Null
	}

}
