package inheritance;


class Bird{
	
	Bird() {
		// super();
		/*
		 * {
		 *		System.out.println("b1");
		 * }
		 */
		
		System.out.println("b2");
	}	
	{
		System.out.println("b1");
	}
}

class Raptor extends Bird{
	
	static { System.out.println("r1");}	// Ausgabe 1 
	
	static { System.out.println("r4");}	// Ausgabe 2
	
	Raptor() {
		// super();
		/*
		 * {
		 *		System.out.println("r3");
		 * }
		 */
		System.out.println("r2");
	}
	
	{
		System.out.println("r3");
	}
}


public class Hawk extends Raptor {

	/*
	 * Befehl : 
	 * 			
	 * 		java Hawk
	 * 
	 * 1. Die JVM muss die Klasse laden :
	 * 
	 *  lade die Klasse Hawk{
	 *  	lade die Basisklasse Raptor{
	 *  		lade die Basisklasse Bird{
	 *  			...
	 *  			statische Init-Blöcke ausführen (falls es welche gibt)
	 *  		}
	 *  		...
	 *  		statische Init-Blöcke ausführen (falls es welche gibt)
	 *  			Ausgabe 1 : r4
	 *  			Ausgabe 2 : r4
	 *  	}
	 *  	...
	 *  	statische Init-Blöcke ausführen (falls es welche gibt)
	 *  }
	 *  
	 *  Die JVM startet die main-Methode
	 *  	// *Asugabe 3 : pre
	 *  
	 *  	Hawk(){
	 *  		Raptor(){	// das ist super()-Aufruf im Hawk-Konstruktor
	 *  				Bird(){	// das ist super-Aufruf im Raptor-Konstruktor
	 *  					super();	// <- Objekt-Konstruktor
	 * 						{	// <- der init-Block aus Bird
     *  						Ausgabe 4 : b2
	 *  					}
	 * 					 	Ausgabe 5 : b2
	 *  				}
	 *  
	 *  			{	// <- der init-Block aus Raptor
	 *  				Ausgabe 6 : r3
	 *  			}
	 *  			Ausgabe 7 : r2
	 *  		}
	 *  		
	 *  	}
	 *  
	 *  	Ausgabe 8 : hawk
	 * 
	 * 	
	 * 1. Statische Block
	 * 2. Konstruktor
	 * 		- initblock 
	 * 		- inhalt von Konstruktor
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		System.out.println("pre");		// *Asugabe 3 : pre 
		
		new Hawk(); 	
		
		System.out.println("hawk");

	}

}
