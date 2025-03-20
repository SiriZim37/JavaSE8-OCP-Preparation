package wrapper;

public class B05_KonstantebPools {

	public static void main(String[] args) {

		/*
		 * 	Die Klassen Byte , Short ,Integer und Long haben jeder einen Konstanten-Pool.
		 * 
		 * z.B. Integer hat den Integer-Pool mit 256 Objekten
		 * mit den Wertern von -128 bis 127
		 * Die valueOf-Methode liefert ein Konstanten-Pool-Element , 
		 * wenn sie als Argument einen Wert aus dem Bereich [ -128 ...127]
		 * bekommt. Ansonsten erzeugt sie ein neues Objekt.
		 * 
		 * 
		 * Der Vergleich x1 == x2 gibt true zurück, weil x1 und x2 
		 * auf dasselbe Integer-Objekt im Cache zeigen. 
		 * Dieser Cache wird in Java für Integer-Werte im Bereich 
		 * von -128 bis 127 verwendet, um Speicher zu sparen 
		 * und die Leistung zu verbessern
		 */
		Integer x1 = 1200;	//	Integer.valueOf(1200)  erzeugt sie ein neues Integer-Objekt.
		Integer x2 = 1200;  //	Integer.valueOf(1200)  erzeugt sie ein neues Integer-Objekt.
		
		System.out.println("x1 == x2  : " +  (x1 == x2) ); // Gibt false zurück
		System.out.println("x1.equals(x2) : " +  (x1.equals(x2)) ); // Gibt true zurück

		Integer x3 = 12; //	Integer.valueOf(12)  liefert Integer aus dem Integer Bereich [ -128 ...127]
		Integer x4 = 12; //	Integer.valueOf(12)  liefert Integer aus dem Integer Bereich [ -128 ...127]
		
		System.out.println("x3 == x4 : " +  (x3 == x4) ); // Gibt true zurück
		System.out.println("x3.equals(x4) : " +  (x3.equals(x4)) );  // Gibt true zurück
		
		Integer y1 = 128; //	Integer.valueOf(128)  erzeugt sie ein neues Integer-Objekt.
		Integer y2 = 128; //	Integer.valueOf(128)  erzeugt sie ein neues Integer-Objekt.

		System.out.println("y1 == y2  : " +  (y1 == y2));  // Gibt false zurück
		
		
		/*
		 *  a++  ist a = a+1
		 *  	 ist a = Long.valueOd( a.longValue()+1) 	// selber Objekt
		 *  b++  ist b = b+1
		 *  	 ist b = Long.valueOd( b.longValue()+1)	    // selber Objekt
		 * 
		 */
		Long a = 125L;
		Long b = 125L;
		System.out.println("1  : " +  (a == b));  // true
		
		a++; b++;  // Long aus dem Pool für den Wert a = 126 , b = 126
		System.out.println("2 : " +  (a == b)); // true
		
		a++; b++;  // Long aus dem Pool für den Wert  a = 127 , b = 127
		System.out.println("3 : " +  (a == b)); // true
		
		a++; b++;  // Long aus dem Pool für den Wert  a = 128 , b = 128
		System.out.println("4 : " +  (a == b)); // false	 
		
	
		/*
		 *  Character hat auch eigenen Pool (nicht in der Prüfung)
		 *  
		 *  Boolean hat zwei Konstanten TRUE und FALSE
		 */
		
		
		
		
	}

}
