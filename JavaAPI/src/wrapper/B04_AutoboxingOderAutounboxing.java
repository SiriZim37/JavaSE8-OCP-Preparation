package wrapper;

public class B04_AutoboxingOderAutounboxing {

	public static void main(String[] args) {

		
		/*
		 * 	Diese Operatoren gibt es nur für primitive Typen : 
		 * 
		 *  	< , <= , > , >=
		 *  
		 *  	+ , - , * , /
		 */
		
		int x1 = 12;       // Primitive int
		Integer x2 = 12;   // Autoboxing
		Double d1 = 12.0;  // Autoboxing
		
		System.out.println( x1 < x2 );	// true			// Autounboxing für x2 
		System.out.println( x2 >= d1);	// true			// Autounboxing für x2 und d1
		System.out.println( x2 * d1);   // 144.0		// Autounboxing für x2 und d1
		System.out.println( d1 * d1);   // 144.0	    // Autounboxing für d1 und d1
		
		/*
		 * 	Diese Operatoren gibt es sowohl für primitive Typen 
		 * als auch für Referentzentypen : 
		 * 
		 * 		== , !=
		 * 
		 * - Wenn ein Operand primitive ist , wird der andere Operand unboxt.
		 * - Wenn beide Operanden Referenzen sind , 
		 *   bleibt es beim Referenzenvergleich!!!!!!!!!
		 */
		
		System.out.println("x1 == x2 : " + (x1 == x2) ) ; 	 // Autounboxing für x2 
		System.out.println("x1 == d1 . " + (x1 == d1) ) ;  	 // Autounboxing für d1 
//		System.out.println( x2 == d1 ) ;  	 // cf : Vergleich von Integer
											// und Double (Geschwisterklasse)
		
		Double da = 12.0 ; // neues Double-Objekt beim Autoboxing
		Double db = 12.0;  // neues Double-Objekt beim Autoboxing
		
		System.out.println( da == db ); // false : da und db zeigen auf unterschiedliche Objekte .
		/* 
		 *  Die Referenzen der beiden Double-Objekte vergleicht, 
		 *  und da da und db auf unterschiedliche Objekte zeigen
		 */

		
				

	}

}
