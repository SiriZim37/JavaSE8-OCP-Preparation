package wrapper;

public class B03_Autoboxing_Aotounboxing {

	/*
	 * 	Autoboxing : dort , wo eine Wrapper-Klassen-Referenz nötig ist , 
	 * 						aber ein primitiver Wert steht , ersetzt der 
	 * 						Compiler den primitiven Wert durch den Aufruf 
	 * 						der boxenden Methode , die für den primitiven Type passt
	 * 
	 * Autounboxing : dort , wo ein primitiver Wert nötig ist , 
	 * 				  aber eine Wrapper-Klassen-Referenz steht , 
	 * 				  ersetzt der Compiler die Referenz durch den 
	 * 				  aufruf der unboxen Methode
	 */
	
	public static void main(String[] args) {

		Integer x1 = Integer.valueOf(12);  // manuelles Boxing 
		Integer x2 = 12; 				   // Autoboxing : integer.valueOf(12)
		
		Boolean b1 = Boolean.valueOf(true);	// manuelles Boxing 
		Boolean b2 = true;	// Autoboxing : Boolean.valueOf(true)
		
		int x111 = x1.intValue(); // // manuelles UnBoxing  (nicht nötig)
		int x222 = x1; // // AutoUnBooxing  x2.intValue()
		
		boolean b111 = b1.booleanValue(); // // manuelles UnBoxing 
		boolean b222 = b2; // // AutounBoxing 
		
		/*
		 *  Ohne Auto-Boxing / Auto-Unboxing
		 */
		
		Integer a = Integer.valueOf(42);
		a = Integer.valueOf( a.intValue() + 1)  ; 
		
		/*
		 * mit Autoboxing / Autounboxing
		 */
		Integer b = 42 ; // Integer.valueOf(42);
		b++; // Integer.valueOf( b.intValue() + 1)  ; 
		
		/*
		 *  Mögliche Probleme
		 *  
		 *  Beim Autoboxing entsheidet der primitiver Typ , 
		 *  zu welchem Wrapper-Klassen-Typ Autoboxong durchgeführt wird.
		 *  
		 *  Ausnahme : implizites Cast int-Literal 
		 *  für Byte oder Short referenzen
		 */
		
//		Integer v1 = (byte)12 ;  // cf : Integer <- IS KEIN <- Byte ( Byte ist kein Integer)
//		Integer v1 = (short)12 ; // cf : Integer <- IS KEIN <- Short ( Short ist kein Integer)
		Integer v3 = 12;  // cf : Integer  <- IS <- Integer
//		Integer v4 = 12L;  // cf : Integer <- IS KEIN <- Long
//		Integer v5 = 12f;  // cf : Integer <- IS KEIN<- Float
//		Integer v6 = 12d;  // cf : Integer <- IS KEIN <- Double
		
		Byte v7 = 12 ; 	// Ausnahme! Implizites Cast vor dem Autoboxing : (byte)12
		Short v8 = 12; 	// (short)12
		
		float f1 = 12;
//		Float v9 = 12 ; // cf : Float <- IS KEIN <- Integer
		
		float f2 = 12;
//		Double v10 = f2; // cf : Double <- IS KEIN <- Float
		
		
	}

}
