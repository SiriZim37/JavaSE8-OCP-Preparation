package methoden;

public class B03_LokaleVariablen {

	/*
	 * Lokale Variable ist die Variable, 
	 * die in einer Methode definiert wurde.
	 * 
	 * Lokale Variable ist ab der Stelle ihrer Definition
	 * bis zum Ende der Methode gültig
	 * 
	 */
	public static void main(String[] args) {
	
		// System.out.println(x1); // cf: keine x1
		
		int x1 = 12; // x1 ist gültig ab hier bis zum Ende der main-Methode
		
		System.out.println(x1); // x1 ist hier gültig

		/*
		 * Keine zwei gleichnamigen lokalen Variablen sind möglich
		 */
		// double x1; // cf: es gibt bereits eine lokale x1
		
		/*
		 * Lokale Variablen muss man vor 
		 * dem 1. Lesen manuell initialisieren
		 */
		int x2; // deklariert, aber nicht initialisiert

		// System.out.println(x2); // cf: nicht initialisiert
		
		x2 = 42;
		
		System.out.println(x2);
		
		/*
		 * Blockvariablen sind nur bis zum Ende ihres Blocks gültig
		 */
		{
			System.out.println(x1);
			System.out.println(x2);
			
			int x3 = 77; // gültig bis zum Ende des Blocks
			System.out.println(x3); // x3 ist gültig
		}
		// System.out.println(x3); // cf: x3 ist nicht mehr gültig
		
		{
			byte x3 = -3; // gültig bis zum Ende des Blocks
			System.out.println(x3); // x3 ist gültig
		}
		
		/*
		 * Schleifenvariable einer for-Schleife ist eine 
		 * solche Blockvariable, die nur gültig ist,
		 * wenn die Schleife läuft
		 * 
		 * Achtung!
		 * Im nächsten Bsp:
		 * - i bleibt gültig für die ganze Zeit der Arbeit der for-Schleife
		 * - j wird in jedem Schleifendurchlauf erstellt und zerstört
		 */
		for (int i=0; i<2; i++) {
			int j=0;
			System.out.println("i = " + i + ", j = " + j);
			j++;
		}
		// System.out.println(i); // cf: i ist nicht mehr gültig
		
	} // end of main
	
	static void testAccess() {
		// System.out.println(x1); // cf: keine x1
	}

}
