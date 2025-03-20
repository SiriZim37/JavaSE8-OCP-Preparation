package classes;


/*
 *  Klasse ist sowohl ein Code-Container
 *  als auch Schablone für Onjekte
 */
class Sportler{
	/*
	 * 	statische Elemente
	 */
	
	static int maxTempo;	// (statische(s) oder Klassen-) Attribut oder Feld oder Variable
	
	static void print() {}	// statsche Methode
	
	/*
	 * 	Objekt-Elemente
	 */
	
	String name ; 			// (Instanz , Objekt-) Attribut oder Feld oder Variable
	
	void laufen() {}		// (Instanz- oder Objekt-) Methode
	
	
	
}

public class B03_Begriffe {

	public static void main(String[] args) {
	
		new Sportler();		// Objekt (Instanz)
		new String();		// Objekt (Instanz)
		
		Sportler s1; 	// Referenz
		String s2;		// Referenz		
		s1 = new Sportler();		
		System.out.println(s1.name);	// Zugriff auf eine Instanz-Variable
		
		s1.laufen();	// Aufruf einer Instantz-Methode		
		System.out.println(Sportler.maxTempo);	// Zugriff auf eine Instanz-Variable	
		
		// nur Lokale Variable muss man selbst initialisiert		
	}

}
