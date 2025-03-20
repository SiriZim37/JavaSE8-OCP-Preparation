package wrapper;

class Blume{
	Integer preis = 200 ;   // 1 Integer-Pool , 1 Integer-Objekt
	/*
	 * 	Beim dem fpr die Anwendung ersten Aufruf der Integer.valueOf 
	 *  wie der Integer-Pool erzeugt. 
	 * 	Da aber der Wert 200 nicht aus dem Bereich[-128...127] ist,
	 *  wird ein neues Integer Objekz aus fem Heap
	 */

}


public class WdhWrapperTestGC {
	
	public static void main(String[] args) {
	
		Blume b = new Blume(); // 1 Objekt
		b = null ; 
		// Zeile A : Wie viele Object in Garbage Collector ? 
		
		// Ausgabe :  2 !! 
		 
		// This explains why the result is "2" objects being eligible for garbage collection at Line A.
		
		/* -The Integer object preis is initialized with the value 200.
		 * -Integer is a wrapper class, so 200 is an instance of Integer.
		 * -Java caches Integer objects for values in the range -128 to 127.
		 * -Since 200 is outside this caching range, a 'new Integer object' is created on the heap.
		 */
		
	}

}
