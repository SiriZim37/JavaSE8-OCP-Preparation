package classes;

class Kreis{
	int radius ;
	
	Kreis(int radius) {
		
		System.out.println("im Konstrukto Kreis(int)");
		this.radius = radius;   // then parameter radius kopieren 
		
	}
	Kreis(){  // in dem dieser KOnstruktor wurde nicht programmiert
		System.out.println("im Konstrukto Kreis()");
	}
	
	/*
	 *  Actung! Da ist kein Konstruktor!
	 *  Bitte in der Praxis keine Methoden definieren !!!! 
	 *  die denselben Namen wie die Klasse haben.
	 */
	
	
	void Kreis(String name){  
	
	}
	
	
	public String toString() {  // schreiben damit bequeme code 
		return "Kreis R= " + radius;
	}
}


public class B05_Konstruktoren {

	/*
	 *  - Constructor : Speziele Moethode , die beim Erzeugen
	 *    einen Objektes aufgerufen wird.   
	 *    
	 *   - Konstrktor hat keinen Rückgabetyp! 
	 *   - Jede Klasse hat mindestens einen Konstrktor
	 *   
	 *   - Man darf keine Konstruktoren direkt mit ihren Namen aufrufen!!!!!!!
	 * 
	 * 	 - Wenn die Klasse keinen expliziten Konstruktor hat ,
	 * 	   generiert der Compiler für die Klassse den 
	 * 	   paramaterlosen Konstruktor ( den default-Konstruktor)
	 * 		//////  Konstruktor heißt genaunso wie die Klassse /////
	 * 
	 *   - Konstruktoren könen überladen werden.
	 */
	
	
	public final static void main(String...args) {
		
		
		// Kreis();   /// mit der Name kann Konstruktor nicht rufen.

		Kreis k1 = new Kreis(5);
		System.out.println(k1); // classes.Kreis@4aa8f0b4 before create public String toString() 
		System.out.println(k1); // R = 5 before // R = 0 if no have toString
		
		Kreis k2 = new Kreis();  // Knstruktor können überladen
		System.out.println(k2); // R = 0
	}

}
