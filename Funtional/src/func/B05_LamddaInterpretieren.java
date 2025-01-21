package func;

public class B05_LamddaInterpretieren {

	public static void main(String[] args) {

		Runnable r1 = () -> {
			System.out.println("mo");
			System.out.println("di");
		};
		
		
		
		/*
		 * Ob eine Lambda kompiliert ? 
		 * 
		 * Lamdda ist die Beschreibung der Realisierung 
		 * der abstrakten Methode : 
		 * 
		 * 	1. es soll eine Klasse genereiert werden , 
		 * 		die das funktionale Interface implementiert
		 * 
		 * 		Der Name der Klasse soll auch generiert werden.
		 * 		Welches Interface realisiert werden soll , wird 
		 * 		aus der Zuweisung erkannt.
		 * 
		 * 
		 *  class Blablaimplements Runnable {
		 *  
		 *  
		 *  }
		 */  
		 
		class Blabla implements Runnable {
			public void run() {
				System.out.println("mo");
		 		System.out.println("di");
					
			}
		}
		
		
		/*
		 *  2. es soll die abstrakte Methode so realisiert werden ,
		 *     wie die lambsa Beschreibt.
		 *     
		 *  class Blabla implements Runnable {
		 *  	public void run() {
		 *  		System.out.println("mo");
		 *			System.out.println("di");
		 *  	}
		 *  }
		 */ 
		
		Runnable r3 = new Blabla();
		
		/*
		 *  3. Es soll eine neues Objekt der generierten Klassen erzeugt werden : 
		 *  
		 *  	Runnable r1 = new Blabla();
		 * 
		 * 
		 */
		System.out.println("main");
		
		r1.run();
		
		r3.run();

	}

}
