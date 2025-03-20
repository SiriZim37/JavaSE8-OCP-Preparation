package vererbung;

abstract class Figur {
	/*
	 * - abstract-Klasse ist nur als Basisklasse verwendbar:
	 *   mit new können keine Objekte erzeugt werden
	 *   
	 * - abstrakte Klasse dürfen (aber nicht müssen) abstrakte 
	 *   Methoden haben
	 */
	

	/*
	 * - Es gibt keine sinnvolle Realisierung 
	 *   der getFlaeche in der Klasse Figur
	 *   
	 * - Aber die getFlaeche ist in der Klasse Figur nötig,
	 *   als Kontrakt (und Vorlage für polymorphische Aufrufe)
	 */
	abstract double getFlaeche();
	 
	// Die abstrakte Klasse kann weiteren Code haben ,
	// den die Kreis und Rechteck erben sollen.
	int x , y ; 
	void bewegen(int x , int y) {
		this.x = x ;
		this.y = y;
	}
	//..
}

class Kreis extends Figur {
	private int radius;

	Kreis(int radius) {
		this.radius = radius;
	}
	
	double getFlaeche() { return Math.PI * radius * radius; }
}

class Rechteck extends Figur {
	private int breite, hoehe;

	Rechteck(int breite, int hoehe) {
		this.breite = breite;
		this.hoehe = hoehe;
	}
	
	double getFlaeche() { return breite * hoehe; }
}

/*
 * Konkrete Klasse muss die abstrakten Methoden 
 * der Basisklasse realisieren (implementieren)
 */
//class Dreieck extends Figur { // cf: muss getFlaeche realisieren
//	
//}



public class B13_abstrakte_Klassen  {

	public static void main(String[] args)  {

		/*
		 * Mit f kann man sowohl Kreis- als auch Rechteck-Objekte 
		 * referenzieren:
		 */
		Figur f;
		//f = new Figur(); // cf: Klasse ist abstract!!! 
		
		
		Figur f1 = new Rechteck(2, 3); // Figur <- IS-A <- Rechteck
		universelleKomponente(f1);
		Figur f2 = new Kreis(3); // Figur <- IS-A <- Kreis
		universelleKomponente(f2);
		

		
//		double flaeche = f.getFlaeche();
//		System.out.println( "Fläche: " + flaeche );
		

	}
	
	/*
	 * Universelle Komponent mit einer
	 * universelle Referenz (Referenz vom Basistyp),
	 * mit der polymorphische Aufrufe in einer
	 * universellen Komponente möglich sind. 
	 */

	static void universelleKomponente(Figur f) {  // mit Referenz vom Typ Figur
		System.out.println( "Bearbeite Objekt vom Type" + f.getClass() );    // 1st : class vererbung.Rechteck
											   //  2nd : class vererbung.Kreis
		/*
		 * Mit f kann man polymorfisch eine Instanzmethode aufrufen.
		 * Zur Laufzeit wird die richtige getFlache für 
		 * das referenzierte Objekt ausgewählt
		 */
		double flaeche = f.getFlaeche();  // Auf ruf UnstanzMethode
		System.out.println("Fläche: " + flaeche);   // 1st : Fläche: 6.0
													//  2nd : 28.274333882308138
	}
	

}
