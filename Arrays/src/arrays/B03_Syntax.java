package arrays;

public class B03_Syntax {

	public static void main(String[] args) {
		
		/*
		 *  1 . Möglihkeit
		 * 	
		 * 		Für große Arrays
		 */
		
		int[] a1 = new int[3];
		a1[0] = 40;
		a1[1] = 41;
		a1[2] = 43;
		
		System.out.println("a1.length:	" + a1.length);
		System.out.println("a1[1]:	" + a1[1]);
		
		/*
		 *  2. Möglichkeit
		 *  
		 *  	Passt für kleine Array mit gewünschten Anfangswerten
		 *  
		 *  Actung!! Diese Natation funktionier NUR beim 
		 *  direkten expliziten Initialisieren einer neuen 
		 *  Array-Referenz!
		 */
		int[] a2 = { 42, 43 , 44};
		System.out.println("a2.length:	" + a2.length);
		System.out.println("a2[1]:	" + a2[1]);
		
//		a2 = {1 , 2, 3 , 4 , 5 } ; // cf : es geht nur beim Initialisieren einer neuen Array-Referenz
		a2 = new int[] {1,2,3,4};
		a2 = new int[4];
		
		
		
		/*
		 *  3. Möglichkeit
		 *  
		 * 	Nötig dort , wo man ein kleines Array ohne 
		 *  Zwischenrefernz einsetzen will.
		 */
		
		int[] a3 = new int[] {40,41,42} ;
//		int[] a4 = new int[3] {40,41,42} ; // cf : over index
		System.out.println("a3.length:	" + a3.length);
		System.out.println("a3[1]:	" + a3[1]);
		
		m1(a3);	
		m1( new int[2] );
//		m1( { 3 , 4 } );  // cf : 
//		m1({});  // cf : 
		m1( new int[] { 3 , 4 } );
		
	}
	
	static void m1(int[] a) {
		//...
	}
	
	static int[] m2() {
		int[] a = {3,4};
		return a ;
	}
	
	
//	static int[] m3() {
//		return  {3,4} ; // cf
//	}
	
	static int[] m4() {
		return (new int[] {3,4}) ; 
	}

}
