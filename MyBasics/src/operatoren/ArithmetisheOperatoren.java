package operatoren;

public class ArithmetisheOperatoren {

	/*
	 * Rechenoperationen für ganze Zahlen
	 * 	+
	 * 	-
	 * 	*
	 * 	/
	 * 	% Modulo (Rest beim Dividieren)
	 */	
	
	public static void main(String[] args) {

		/*
		 *  Exam!
		 *  
		 *  Das Ergebnis einer arimetischen Operation
		 *  hat MINDESTENS den Typ int!!!
		 *  Sonst hat das Ergebnis den Typ des 'breitesten' Operatoren.
		 */
		
		byte b1 = 12;
		short s0 = 12;
//		byte b2 = b1 + b1 ; 	 	// cf : byte <- int ( compiler doesnt know that is byte )
//		short s1 = b1 + 3;   		// cf : short <- int 
		int x1 = b1+3;   	 		// ok	
		System.out.println("x1 =" +x1);   // x1 =
		
//		byte b3 = (byte)b1 + 3 ; //cf : byte <- int : 
						 		/* Kopier von b1 to byte and sum mit 3 
								und dann macht es compiler failer */
		byte b4 = (byte)(b1 + 3);  // ok : explizities Casting  : Variable muss in Klama grouppen.
		System.out.println("b4 =" +b4);   // b4 = 15
		
//		int x2 = b1 + 12.0;			 // cf : int <- double
		int x2 = (int) (b1 + 12.0);  // x2 =24  ok : explizities Casting 
//		int x3 = s0 + 12.0;			 // cf : short <- double
		int x3 = (int) (s0 + 12.0);  // x3 =24  ok : explizities Casting 
//		int x4 = 2e3 + b1; 			 // cf : int <- double  
		int x4 = (int)(2e3 + b1); 	// x4 = x4 =2012
			
		System.out.println("x2 =" +x2); 
		System.out.println("x3 =" +x3); 
		System.out.println("x4 =" +x4); 
		/* 
		 * Punkt vor Strich!
		 */
		System.out.println("2+3*4 = " +2+3*4);          // priorität Opration macht 2+3*4 = 212
		System.out.println("2+3*4 = " + ( 2 + 3 * 4)); // 3*4 =12  > 12+2 = 14 ( muss immer in Klarma )
	
		
		/* 
		 * Test Modulo
		 */

		System.out.println("10 % 3 = " + 10 % 3);   // 3*3 +1  --  10 % 3 = 1
		/* Opreatoren (%) Module hat höher priorität als ( = ) Zuweisung 
		 * Dann können nicht in string rehnen. Aber hier Zuweisung is in string.
		 */		
		System.out.println("3 % 10 = " + 3 % 10);  //// 3*3 +1 --  3 % 10 = 3
	
		/* 
		 * Test Division
		 */
	
		System.out.println("5.0 / 0 = " + 5.0/0); // Infinity
//		System.out.println(5/0);  // cf:  Exception! das Programm by zero  wird kritish beendet.
		System.out.println("end of main"); // Diese Zeile wird nicht erreicht
		
		
	}


}
