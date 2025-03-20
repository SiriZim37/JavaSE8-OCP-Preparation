package strings;

class Hello{
	static void m() {
		
	}
	
	static void testStrings() {
		String s1 = "mo";	// sucht nach id "mo" und copie zu referenz s1 
		String s2 = "di";   // sucht nach id "mo" und copie zu referenz s2
		String s3 = s1.toString(); // referenz s1 copie zu referenz s3
	}
	
	static String s = "do";
	
}
public class B05_StringPool {

	/*
	 *  1. Kompileren 'Hello' kompilieren ,unter anderem : 
	 *  
	 *  		1.1 Compiler erzeugt die Liste mit eindeutigen Literalen der Klasse
	 *  			Literalen der Klasse : 
	 *  				"mo" , "do"
	 *  
	 * 			1.2 Alle Stellen im Code der Klasse werden als 'suche im String-Pool' übersetzt
	 *  
	 *  2. Zur Laufzeit : Klasse beim 'Hello' 1. Benutzen laden.
	 *  	Dabei erweitert die JVM den String-Pool mit Strings aus der Lister
	 *  	der Literale der Klasse 'Hello'
	 */
	public static void main(String[] args) {
	
			Hello.m();  // Klaase Hello wird geladen, String "mo" und "di"
						// erscheinen im String-Pool
			
			Hello.testStrings(); //  keine String-Objekte auf dem Heap (String-Objekt im String-Pool)
			Hello.testStrings(); //  keine String-Objekte auf dem Heap (String-Objekt im String-Pool)
			Hello.testStrings(); //  keine String-Objekte auf dem Heap (String-Objekt im String-Pool)
			Hello.testStrings(); //  keine String-Objekte auf dem Heap (String-Objekt im String-Pool)
			Hello.testStrings(); //  keine String-Objekte auf dem Heap (String-Objekt im String-Pool)
			
	/*
	 * Beim Aufruf von Hello.testStrings() existieren also 1 String-Objekt im String-Pool (das ist "mo"). 
	 * Es werden keine zusätzlichen String-Objekte auf dem Heap erstellt. 
	 * Alle Variablen (s1, s2, und s3) zeigen auf dasselbe String-Objekt im Pool.		
	 */
	}

}
