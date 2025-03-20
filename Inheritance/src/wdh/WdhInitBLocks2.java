package wdh;

class Bird{
	static { 
		System.out.println("static init Bird.");
	} 

}

class Eagle extends Bird{
	
	static { 
		System.out.println("static init Eagle.");
	} 
}


public class WdhInitBLocks2 {
	
	public static void main(String[] args) {
		
		/*
		 * 	Befehle: 
		 * 	
		 * - reserviere ein neues Eagle-Objekt
		 * - initialisiere ein neues Eagle-Objekt
		 * 
		 * JVM überprüft , ob die Klasse Eagle geladen ist.
		 * Die Klasse Klass Eagle ist noch nicht geladen. : 
		 * 
		 * JVM sucht die Datei Eagle.class und öffnet sie. 
		 * Dort steht , dass Eagle als Basisklasse Klasse Bird hat.
		 * 
		 * JVM überprüft , ob die Klasse Bird geladen ist.
		 * Die Klasse Bird ist noch nicht geladen.
		 * 
		 * JVM sucht die Datei Bird.class und öffnet sie. 
		 * Dort steht , dass Eagle als Basisklasse Klasse Bird hat.
		 * 
		 * Klasse Objekt ist bereits geladen.
		 * Die Klasse Bird wird auch geladen.
		 * Statische Init-Blöcke der Klasse Bird werden dabei ausgeführt.
		 *
		 */
		
		new Eagle();
		
	}

}
