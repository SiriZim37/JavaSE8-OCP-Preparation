package aufgaben.geometrie.v1.klassen;

import java.util.Random;

public class AufgabeKlassenGeometrie {

	public static void main(String[] args) {
						
		
		Recteck r1 = new Recteck(); 
		System.out.println("r1.breite :" + r1.breite);
		System.out.println("r1.hoehe :" + r1.hoehe );
		
		
		Kreis k1 = new Kreis();
		k1.getDisplayRadius();
		System.out.println("k1 : Kreis mit dem Radius : " + k1.radius);
		System.out.println("k1 : Kreis mit dem Radius : " + k1.getDisplayRadius());
		
		System.out.println("\n*** 100 Recteck : ");
		Random rnd = new Random();
		
		
		int i = 1 ;
		while(i <= 10) {
			Recteck r = new Recteck(); 
			r.breite = rnd.nextInt(20)+1; // [0..21 ) + 1   : [ exklusive symbol  ) Inklusive Symbol
			r.hoehe  = rnd.nextInt(20)+1; 
			System.out.println(i + ". " + r );
			
			i++;
		}
		
		Recteck r2 = new Recteck(); 
		System.out.println(r2); 	// wir bekommen Kopie refernz von Objekt ( address ) 
									// >> public void println(Object x) Methode
		System.out.println(r2.toString()); // Es wird von objekt String aufgerufen 
									// >>  public void println(String x) Methode
		System.out.println(r2.toString()); // Es wird von toString in Recteck klass aufgerufen
	
		
		/*
		 * - wenn keine public String toString() in Class schreiben , 
		 *  wird comilieren and dann zeig 'aufgaben.Recteck@2c13da15'
		 * - wenn public String toString() in Klass wurde aufgerufen wird Value zeigen
		 * 
		 */
		
		System.out.println("\n***  Kreis testen");
		Kreis k = new Kreis();
		k.radius = 5;
		
		System.out.println(k);  // aufgaben.Kreis@2c13da15 
								// Prints an Object and then terminates the line.  
								// This method calls * at first String.valueOf(x) 
								// to get the printed object's string value,
		
		//... bequeme Ausgaben
		// wenn public String toString() in Klass wurde aufgerufen wird Value zeigen
		System.out.println(k); // Kreis. R = 5
		
		
		System.out.println("\n***  Dimensionen in einem Rechteck ändern ");
		Recteck r = new Recteck();
		System.out.println("a.0 "+ r); // Rechteck( 0 x 0 )	
		Recteck.changeDimension(r ,3, 5);
		System.out.println("a.1 "+ r); // Rechteck( 3 x 3 )
		r.changeDimension(7, 8);	
		System.out.println("a.2 "+ r); // Rechteck( 7 x 8 )
		
		System.out.println("\n***  Dimensionen in einem Kreis ändern ");
		
		
		
	}	// end of main
}
