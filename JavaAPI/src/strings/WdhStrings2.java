package strings;

public class WdhStrings2 {

	/*
	 * 	Beim laden der Klasse (bevor die main Startet)
	 * wird der String-Pool mit den Strings erweitert : 
	 * 
	 *	 "mo" , "MO" , "m " , "o"
	 * 
	 */
	public static void main(String[] args) {

		/* Wie viele String-Objekte erzeugt folgende Schleife ? 
		 * 
		 * 	Ergebnis : 300
		 * 
		 */
		for (int i = 0; i < 100; i++) {
			m();
		}

	}
	
	static void m() {
		
		String s1 = "mo";	// finde "mo" im String-Pool
		String s2 =  new String("mo"); // finde "mo" im String-Pool
									   // und kopieren die Zeichen 
										// in das neue String-Objekt ( +1 )
		String s3 = "MO".toLowerCase(); // finde im String-Pool "MO"
										// und erstelle ein neues
										// String-Objekt mit Kleinbuchstaben ( +1 )
		
		String s4 = "m";  // finde "m" im String-Pool
		String s5 = s4 + "o";  // finde das von s4 referenzierte String-Objekt , 
								// String-Objekt (Operand links)
								// finde "o" im String-Pool (Operand rechts) , 
								// erstelle ein String-Objekt mit 
							    // dem Inhalt der beiden Operaden ( +1 )
		
	}

}
