package operatoren;

public class ZuweisungUndCasting {

	/*
	 * Exam!
	 */
	
	/*
	 *  - Achtung! 
	 *  	Der Compiler vergleicht die Typen, nicht die Werte!
	 *  	Der Compiler kennt (fast) NIE den Wert einer Variable! 
	 *    
	 *    Ausnahme: bei int-Literalen (und char-Literalen) berücksichtigt 
	 *    der Compiler den Wert
	 * 
	 * 	- In einer 'breitere' Zahlenvariable kann man
	 *    immer eine 'engere' Zahlenvariable kopieren
	 *        
	 *     byte -> short -> int -> long -> float -> double
	 *             char  -> int -> long -> float -> double
	 *     
	 *    Beim Kopieren in die von 'breit' in 'eng' muss man
	 *    explizites Casting durchführen und. evtl Daten/Genauigkeit
	 *    verlieren. Ausnahme gibt es bei int-Literalen (und char-Literalen)
	 *    
	 *  - boolean ist nur mit boolean kompatibel
	 */
	public static void main(String[] args) {
		
		int x1 = 12; 	// int <- int
		float f1 = x1; 	// float <- int

//		byte b1 = x1;	// cf: byte <- int
		byte b2 = 12;	// ok: implizites Casting
//		byte b22 = 1200;// cf: Wert ist zu groß
		byte b3 = (byte)x1; // explizites Casting
		
		short s1 = 97; 	// ok: implizites Casting
		int x2 = s1;	// int <- short
		char ch1 = 97;  // ok: implizites Casting
//		ch1 = s1;		// cf: char <- short
		ch1 = (char)s1; // ok: explizites Casting
		
		System.out.println("ch1 = " + ch1); // ch1 = a
		
		s1 = -22;
		ch1 = (char)s1;
		System.out.println("ch1 = " + ch1); // ch1 = irgend etwas komisches
		
		boolean v1 = true; 	// boolean <- boolean
		boolean v2 = v1;	// boolean <- boolean
		
//		v1 = x1;			// cf
//		v1 = (boolean)x1;	// cf
		
		System.out.println("---- Test overflow");
		
		short s12 = Short.MAX_VALUE;
		System.out.println("a. s12 = " + s12); // 32767
		
		s12 = (short)(s12 + 1);
		System.out.println("b. s12 = " + s12); // falscher Wert
		
		System.out.println("--- Ausnahme nur für int- (und char-) Literale: ");

		short v3 = 12; 	// Ausnahme mit int-Literal
//		short v4 = 12L; // cf: short <- long
//		float v5 = 12.0;// cf: float <- double 
	}

}
