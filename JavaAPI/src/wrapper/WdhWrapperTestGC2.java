package wrapper;

class Blume2{
	Integer preis = 120 ;  // // 1 Integer-Pool

	/*
	 * 	Beim dem fpr die Anwendung ersten Aufruf der Integer.valueOf 
	 *  wie der Integer-Pool erzeugt. 
	 * 	Da aber der Wert 200 nicht aus dem Bereich[-128...127] ist,
	 *  wird ein 'kein' neues Integer Objekz aus fem Heap
	 */
	
}

public class WdhWrapperTestGC2 {
	
	public static void main(String[] args) {
	
		Blume b = new Blume(); // 1 Objekt
		b = null ; 
		
		// Zeile A : Wie viele java-Object stehen dem Garbage Collector zur Verfügung ? 
		// how many objects are eligible for garbage collection at line A.
		
		// Ausgabe :  1 !! 
		
	}

}
