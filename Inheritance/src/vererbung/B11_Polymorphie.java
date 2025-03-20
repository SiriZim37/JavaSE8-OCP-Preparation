package vererbung;

import java.util.Random;

class Karotte{
	public String toString() {
		return "mein Farbe : Orange" ; 
	}
}


public class B11_Polymorphie {

	public static void main(String[] args) {
		/*
		 * Polymorphie (Vielgestaltigkeit)
		 * Polymorphie gibt es nur beim Aufruf von Instanymethoden.
		 */
		
		/*
		 * Basistyp-Referenz
		 */
		Object obj = new Object();
		
		/*
		 * Universeller Code mit dem polymorphischen
		 * Aufruf einer Instanzmethode mit der Basistyp-Referenz.
		 * 
		 * Polymorphischer Aufruf (obj.toString()) wird so
		 * vom Compiler übersetzt.
		 * 
		 * 	- suche das referenzierte Objekt.
		 *  - ermittle die Klasse vom Objekt.
		 *  - starte die toString() aus der so ermittelten Klasse
		 */

		String s = obj.toString(); // <- polymorphisher Aufruf
		System.out.println(s); // java.lang.Object@4d591d15
		
		
		obj = new Karotte();    // das Objekt referenziert
		s = obj.toString(); 	//<- suche das referenzierte Objekt. 
		System.out.println(s);  // mein Farbe : Orange -> ermittle die Klasse vom Objekt. 
								// starte die toString() aus der so ermittelten Klasse 
		
		
		obj = new Object(); 
		s = obj.toString(); 	 // <- polymorphisher Aufruf ( Aufruf Instanz Methode )
		System.out.println(s);   // java.lang.Object@7960847b
		
		
		if(new Random().nextBoolean()) {
			obj = new Karotte();
		}
		s = obj.toString(); 	 // <- polymorphisher Aufruf ( Aufruf Instanz Methode )
		System.out.println(s);  // ???
		
		if(new Random().nextBoolean()) {
			System.out.println("--Test--");
			universelleKomponente(new Karotte());
		}
		
	}
	
	
	static void universelleKomponente(Object obj) {
		String s = obj.toString();
		s = obj.toString();  // <- polymorphisher Aufruf 
		System.out.println(s);  // ???
	} 

}
