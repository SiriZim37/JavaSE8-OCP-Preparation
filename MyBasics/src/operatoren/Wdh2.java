package operatoren;

public class Wdh2 {

	public static void main(String[] args) {
		int x = 0;
		
		/*
		 * Was ist das Ergebnis für die nächsten zwei Zeilen?
		 * 
		 * A. Compilerfehler
		 * B. a
		 * C. b
		 * D. Ausgabe kann nicht genau ermittelt werden
		 */
		char v1 = x > 0 ? 'a' : 'b';
		System.out.println(v1); // b

		/*
		 * Stellen Sie sich vor, dass die nächste Zeile
		 * aktiviert wird (die Kommentarzeichen werden entfernt).
		 * Wird dann die Zeile kompilieren?
		 */
		// int v2 = x > 0 ? 12 : 2e3; // cf: int <- double
		int v2 = (int)(x > 0 ? 12f : 2e3); 
	}
}
