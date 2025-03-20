package enums.wdh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

enum Ampelfarbe {
	ROT , GELB , GRUEN
}

public class B01_DasProblemMitEnum {

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

		Ampelfarbe farbe = getAmpelFarbe();
		
		if (farbe == Ampelfarbe.ROT) {
			System.out.println("Anhalten!");
		} else if (farbe == Ampelfarbe.GELB) {
			System.out.println("Langsamer fahren");
		} else if (farbe == Ampelfarbe.GRUEN) {
			System.out.println("Weiter fahren");
		} else {
			System.out.println("Fehler! Unbekannte Farbe: " + farbe);
		}
		
		StringBuilder b = new StringBuilder("-");
		
		Predicate<StringBuilder> p = (StringBuilder v) ->  true ;
		
		StringBuilder a = new StringBuilder("A");
		a = new StringBuilder("A");
		System.out.println(a);
	}
	
	static Ampelfarbe getAmpelFarbe() {
		Ampelfarbe[] farben = Ampelfarbe.values();
		return farben[new Random().nextInt(farben.length)];
	}
	
	

}
