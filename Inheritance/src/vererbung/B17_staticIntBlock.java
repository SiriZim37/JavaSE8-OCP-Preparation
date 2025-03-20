package vererbung;

class Schiff {
	static {
		System.out.println("Schiff. static init 1");
	}
	
	static int maxGeschwindigkeit = 12;
	
	static {
		System.out.println("Schiff. static init 2");
	}
}


class Zug {
	static {
		System.out.println("Zug. static init");
	}
}

class Schnellzug extends Zug {
	static {
		System.out.println("Schnellzug. static init");
	}
}

public class B17_staticIntBlock {
	/*
	 * - statische Init-Blöcke einer Klasse
	 *   werden beim Laden der Klasse ausgeführt
	 */
	public static void main(String[] args) {
		
		System.out.println("main 1.");

		/*
		 * Klasse Schiff wird gleich geladen.
		 * 
		 * Ausgaben dabei:
		 * Schiff. static init 1
		 * Schiff. static init 2
		 * 
		 * Danach wird die Variable maxGeschwindigkeit gefunden und gelesen
		 */
		System.out.println("main 2. /" + Schiff.maxGeschwindigkeit);
		
		// Die Klasse Schiff muss nicht mehr geladen werden.
		// Keine Ausgaben aus dem static init block.
		System.out.println("main 3. /" + Schiff.maxGeschwindigkeit);
		
		
		/*
		 * Bevor eine Klasse geladen wird, wird ihre 
		 * Basisklasse geladen.
		 * 
		 * Ausgaben beim Laden der Klasse Schnellzug 
		 * (und dafür der Basisklasse Zug):
		 * 
		 * Zug. static init
		 * Schnellzug. static init
		 * 
		 * Danach kann das neue Schnellzug-Objekt erzeugt werden
		 */
		new Schnellzug();
		
		System.out.println("main 4.");
		
		/*
		 * Die klassen Zug und Schnellzug wurden bereits geladen.
		 * Keine Ausgaben aus ihren static init blocks.
		 */
		new Schnellzug();
		new Schnellzug();
		new Schnellzug();
		new Schnellzug();
	}

}
