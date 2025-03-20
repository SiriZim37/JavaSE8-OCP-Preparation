package exceptions.wdh;

public class B01_WasTunInAusnahmesituation {

	/*
	 * Aufgabe : Methode 'int add (int , int ) entwickeln , 
	 * 			 die immmer korrekt funktioniert.
	 * 
	 */
	
	public static void main(String[] args) {


		int res = add(2,3);
		System.out.println("2 + 3 = " + res);

		try {
			res = add(-2 ,  Integer.MAX_VALUE);
			System.out.println("-2 + Integer.MAX_VALUE = " + res  );
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static boolean addOK;
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @throws IllegalArgumentException wenn  a + b int Overflow
	 */
	public static int add(int a, int b) throws IllegalArgumentException {
		long result =  a + b ;  // ok implizit
		
		if(result > Integer.MAX_VALUE || result < Integer.MAX_VALUE) {
			/*
			 * Variante 1 : System.exit
			 * Es ist aber keine gute Lösung, die JVM einfach zu beheben.
			 */
			//System.out.println("Kritisches Beenden der Anwendung!");
			//System.exit(-1);
			
			/*
			 * Variante 2 : Speziallewert liefern.
			 * z.B. liefert die Methode indexOf der Klasse String -1 zurück , 
			 * wenn sie nichts findet.
			 */
			//return Integer.MIN_VALUE;	// <- solle in der Dokumentation 
										// als ungültiger Wert beschreiben werden.
			
			/*
			 * Variante 3 : Flag setzen.
			 * Der Benutzer der Methode soll das Ergebnis wegwerfen , 
			 * wenn der Flag gesetzt wurde.
			 */
			//addOK = false;
			
			/*
			 * Variante 4 : Exception werfen.
			 * 
			 */
			throw new IllegalArgumentException("int Overflow bei " + a + " + " + b);
			
		}
		return (int) result ; // cf :long <- int ( es muss casting (Explizit))
	}

}
