package arrays;

public class B05_SeltsamerSyntax {

	public static void main(String[] args) {
		/*
		 * Das letzte Komma wird ignoriert :  
		 * 
		 * 	Beide Arrays a1 = a2 sind gleich lang.
		 */

		
		int[] a1 = { 12 , 13 , 14 };
		System.out.println("a1.lenght " + a1.length); // 3 
		
		int[] a2 = { 12 , 13 , 14  , };
		System.out.println("a2.lenght " + a2.length); // 3
		
		/*
		 *	Folgende Referenzen haben denselben Typ int[] 
		 */
		int[] r1;
		int []r2;
		int r3[];
		
		r1 = new int[2];	// int[] <- int[]
		r2 = new int[2];	// int[] <- int[]
		r3 = new int[2];	// int[] <- int[]
		
		/*
		 * Leere Arrays sind auch Objekte!
		 */
		
		String[] strArr1 = {};  // kein Variable
		System.out.println("strArr1.length : " + strArr1.length);
		
		
//		int[] intArrN = new int[]; // cf : Variable must provide either dimension expressions or an array initializer
		
		int[] intArr1 = new int[0]; //  // Leeres Array als Platzhalter für zukünftige Daten 
		intArr1 = new int[]{1, 2, 3, 4, 5};
		
	}

}
