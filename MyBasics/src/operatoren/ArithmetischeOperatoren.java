package operatoren;

public class ArithmetischeOperatoren {

	/*
	 * 		+
	 * 		-
	 * 		*
	 * 		/
	 * 		%	Modulo (Rest beim Dividieren)
	 */
	public static void main(String[] args) {
		
		/*
		 * 	byte < short < int < float < long < double
		 */
		/*
		 * Exam!
		 * 
		 * Das Ergebnis einer arithmetischen Operation
		 * hat MINDESTENS den Typ int.
		 * Sonst hat das Ergebnis den Typ des 'breitesten' Operanden.
		 */
		
		byte b1 = 12;
		System.out.println("b1 = " + b1);
		
//		byte b2 = b1 + b1;				// cf: byte <- int
		byte b2 = (byte) (b1 + b1);		// downcasting 
		System.out.println("b2 = " + b2);
		
		
//		short s1 = b1 + 3;				// cf: short <- int
		short s1 = (short) (b1 + 3);	// downcasting 
		int x1 = b1 + 3;				// b1 upcasting
		
//		byte b3 = (byte)b1 + 3;			// cf: byte <- int
		byte b4 = (byte)(b1 + 3);
		System.out.println("b4 = " + b4); // 15
		
//		int x2 = b1 + 12.0;					// cf: int <- double
		int x2 = (int) (b1 + 12.0);			// byte + double : Result double es muss downcasting 
		
//		int x3 = 2e3 + b1;  				// cf: int <- double
		int x3 = (int) (2e3 + b1);  		// double : (2 * (10^3) = 2000.0) + b1 (b1 will be promoted to double) 
											// Result double muss downcasting 
		/*
		 * Punkt vor Strich!
		 */
		System.out.println("2 + 3 * 4 = " + (2 + 3 * 4));
		
		/*
		 * test Modulo
		 */
		System.out.println("10 % 3 = " + 10 % 3); // 1
		System.out.println("3 % 10 = " + 3 % 10); // 3
		
		/*
		 * test Division
		 */
		System.out.println("5.0 / 0 = " + 5.0 / 0 ); // Infinity
		
		System.out.println( 5 / 0 ); // Exception! Das Programm 
									 // wird kritisch beendet
		
		System.out.println("end of main"); // Diese Zeile wird nicht erreicht
	}

}
