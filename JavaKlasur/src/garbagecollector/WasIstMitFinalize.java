package garbagecollector;

class Auto{
	
	/*
	 * nur ein Test. bitte finalize-Technik
	 */
	
	public void finalize() {
		System.out.println("in der finalize");

	}
	
}

public class WasIstMitFinalize {

	/*
	 * 	Es ist dringend davon abzuraten die finalize()-Texhnik zu verwenden.
	 * 
	 * 	- Die Methode finalize() ist nicht mehr aktuell
	 * 
	 * 	* Auch den Garbage Collector sollte die Anwendung nicht versuchen zu aktivieren.
	 * 	  Der GC soll selbst entscheiden , wann er die Objeckte sammelt 
	 * 
	 * Früher konnte man unter Umständen in der finalize()-Methode 
	 * die Resourcen freigeben , die das Objekt reserviert hat.
	 * 
	 * finalize()-Methode wird automatisch aufgerufen , wenn der GC das Objekt löscht.
	 * 
	 */

	public static void main(String[] args) throws Exception {
		
		Auto a = new Auto();
		
		a = null ; 
		
		System.gc();	// sollte man nicht aufrunfen. Hier nut ein Test! 
		Thread.sleep(3000);	// Pause für 3 sek.
		
		System.out.println("end of main");

	}

}
