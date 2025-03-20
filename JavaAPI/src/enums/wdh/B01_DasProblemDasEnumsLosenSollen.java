package enums.wdh;

import java.util.Random;

public class B01_DasProblemDasEnumsLosenSollen {

	public static final int ROT = 0; 
	public static final int GELB = 1; 
	public static final int GRUEN = 2; 
	
	/*
	 * 	Aufgabe : 
	 * 		
	 * 	Ein Auto kommt zu einer Ampel und muss : 
	 * 		
	 * 			anhalten , wenn die Ampel rot ist
	 * 			langsamer fahren wenn die Ampel gelb ist
	 * 			weiter fahren , wenn die Ampel grün ist.
	 * 
	 * Vereinbarung : 
	 * 		
	 * 		0 = rot 
	 * 		1 = gelb
	 * 		2 = grün
	 * 
	 * Das Problem , dass enum-Klasse lösen : 
	 * 
	 * Der Typ int für Ampelfarbe ist zwar ok , aber nicht der beste Typ.
	 * Es gibt viele sinnlose int-Werte (wenn int für eine Ampelfarbe steht)
	 * 
	 * Klassen können das Problem lösen: 
	 * 	neue Typen definieren , die für die Lösung nötig ist.
	 *  und dabei die genaue Anzahl der Werte von dem Typ bestimmen.
	 */
	public static void main(String[] args) {

		int farbe = getAmpelFarbe();
		
		if(farbe == ROT ) {
			System.out.println("Anhalten!");
		}else if(farbe == 1 ) {
			System.out.println("Langsamer fahren!!");
		}else if(farbe == 2 ) {
			System.out.println("Weiter fahren");
		}else {
			System.out.println("Fehler! Unbekannte Farbe : " + farbe);
		}
	}
	
	static int getAmpelFarbe() {
		return new Random().nextInt(4);	// bug hier! 3 kann auch vorkommen

	}
	
	

}
