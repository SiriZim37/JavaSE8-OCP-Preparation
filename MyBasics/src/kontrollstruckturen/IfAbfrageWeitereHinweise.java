package kontrollstruckturen;

public class IfAbfrageWeitereHinweise {

	public static void main(String[] args) {
		int x = 0;
		
		if(x==0) {
			System.out.println("1.1"); // Ausgabe
		} else if(x==1) {
			System.out.println("1.2");
		} else {
			System.out.println("1.3");
		}

		/*
		 * Wenn nach if (oder nach else if, oder nach else)
		 * keine geschweiften Klammer stehen, ergibt
		 * die nächste Anweisung (bis zum Semikolon) den Zweig-Block
		 */
		if(x==0) 
			System.out.println("2.1"); // Ausgabe
		else if(x==1)
			System.out.println("2.2");
		else
			System.out.println("2.3");
		
		/*
		 * Exam
		 */
		x = 0;
		
		if(x==22) 
			System.out.println("3");
			System.out.println("4"); // Die Ausgabe gibt es, da diese Zeile
									 // zu der if-Abfragen NICHT gehört
		
		/*
		 * Exam
		 */
		if(x==0) 
			System.out.println("5.1.a");	// Block der if-Abfgrage.
			System.out.println("5.1.b");	// Einfach eine Zeile aus der main.
//		else								// cf: kein if-Zweig vor else.
//			System.out.println("5.2");
			
			
		/*
		 * Exam.
		 * 
		 * Das Ergebnis einer Zuweisung ist der neue Wert der Variable!
		 */
		int day = 0;
		
//		if(day=1) {						// cf: Zuweisung day=1 liefert int
//			System.out.println("mo");
//		}
		
		boolean b = true;
		if(b = false) {				// evtl. ein Gedankenfehler, aber kompiliert
			// wird nicht aktiviert, da b jetzt gleich false ist:
			System.out.println("wird nicht laufen");
		}
		System.out.println("6. b = " + b); // false
		
		/*
		 * Exam
		 */
//		if(x==1) {
//			
//		} else if {		// cf: Bedingung fehlt
//			
//		}
		
	}

}
