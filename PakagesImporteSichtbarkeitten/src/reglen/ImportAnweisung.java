package reglen;



import personen.Person; // importiert Person
import java.util.*; // importert all Top-level-Typen
//import test.String; // cf : es kann nicht importiert
//import personen.Dozent; // cf : Dozent ist nicht public , The type personen.Dozent is not visible

public class ImportAnweisung {

	/*
	 * 	-Mit der impoer-Anweisung importiert man 
	 * 	 Namen der public-Toplevel-Typen aus einem Pakage
	 * 
	 *  - Compiler sucht Klassen/Interfaces
	 *  	- im aktuellen Pakage-
	 *  	- nach import-Anweisungen
	 *   	- im Pakage java.lang
	 *   
	 *  import personen.Person; 	- importiert eine Klasse aus personen
	 *  import java.util.*; 		- importiert alle Klasse/Interfaces aus java util
	 */
	public static void main(String[] args) {
		
		
//		IOException v1; // cf : Klaase Auto nicht gefunden
//		Auto auto;	// cf : Klaase Auto nicht gefunden
		
		autos.Auto v11; 	// ok : vollqualifizierter Name
		
		String v2 ; 	    // java.lang.String
		java.lang.String v21;
		
		Person v3;	// import
		personen.Person v31;
		
		List<String> v4;
		ArrayList<String> v5;  // java.util.ArrayList;
		
	}

}
