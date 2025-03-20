package functonal;



interface Lauffaehig{
	void laufen();
}


public class B05_LambdasVerstehen {

	/*
	 * - Java generiert aus Lambdas Klassen (eigentlich zur Laufzeit)
	 * 
	 * - Lambda kann so interpretiert werden:
	 * 	 Es ist die Beschreibung davon, wie die abstrakte Methode
	 *   der zu realisierenden (zu generierenden) Klasse definiert 
	 *   werden soll.
	 *   
	 * - Aus dem Kontext der Zuweisung(!!!) erkennt der Compiler,
	 *   welches Interface die generierte Klasse implementieren soll.
	 */
	public static void main(String[] args) {

		/*	Gegeben : 
		 * 		Lauffaehig ref = () -> {
		 * 			System.out.println("laufe...");
		 * 		};
		 * 
		 * Kompiliert der Code ????
		 * 
		 * Es ist eine Lambda.
		 * 
		 * 1. Java generiert die neue Klasse:
		 * 
		 * class Blabla implements {
		 * 
		 * }
		 * 
		 * 
		 * 2. Java analysiert die Zuweisung (!)
		 *    und erkennt aus der linken Seite, welches Interface
		 *    realisiert werden soll
		 *    
		 * class Blabla implements Lauffaehig {
		 * 
		 * }
		 *    
		 * 3. Java analysiert das Interface
		 *    und erkennt, welche Methode
		 *    realisiert werden soll
		 *    
		 * class Blabla implements Lauffaehig {
		 * 		public void laufen
		 * }
		 *    
		 * 4. Java übernimmt die Liste der Parameter und 
		 *    den Rumpf aus Lambda.
		 *    Aus kompakter Notation wird die normale:
		 *    
		 * class Blabla implements Lauffaehig {
		 * 		public void laufen() {
		 * 			System.out.println("laufe...");
		 * 		}
		 * }
		 * 
		 * 5. Lambda dur das neue Objekt ersetzen
		 *    
		 * 		Lauffaehig ref = new Blabla();
		 */
		Lauffaehig ref = () -> {
			System.out.println("laufe...");
		};
		
		System.out.println(ref.getClass().getSimpleName());

	}

}
