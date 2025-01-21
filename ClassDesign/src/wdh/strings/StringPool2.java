package wdh.strings;

class Woche{
	static String besterTag = "sa";
	/*
	 * Wenn der Compiler dise Klasse übersetzr , erzeugzt
	 * der Compiler die Liste mit String-Literalen dieser Klasse :
	 * 
	 * 	"sa" , "mo" , "MO"
	 * 
	 * Wenn die JVM die Klasse laden wird , wird sie die Strings 
	 * aus dieser Listen in den String-Pool übernehmen
	 */
	
	String getTag() {
		String s = "mo";					// suche im String-Pool nach "mo"
		String s2 = new String("mo");		// +1 String-Objekt
		String s3 = "MO".toLowerCase();		// +1 String-Objekt
		String s4 = "sa";					// suche im String-Pool nach "sa"	
		return s+s2+s3+s4;					// s+s2 -> Zwischenstring1  				+1 String-Objekt
											// Zwischenstring1 + s3 -> Zwischenstring2  +1 String-Objekt
											// Zwischenstring2 + s4 -> Ergebnisstring   +1 String-Objekt
	}
	
	static void m() {
		
	}
}

public class StringPool2 {

	public static void main(String[] args) {

		
		// Zeile A : ? String Objekte  = 0 
		
		Woche.m(); // Hier wird die Klasse Woche zum ersten Mal verwendet.
					// java lädt die Klasse Woche
					// String-Pool wird mit Strings "sa" , "mo" und "MO" 
					// vervollständigt
		
		String s = new Woche().getTag();  // Zeile B : ? String Objekte erstellt  = 5 String-Objekte
		
		/*
		 * 4. erzeugt String Objekte stehen nach dem Aufruf dem GC zur Verfügung
		 */
		

	}

}
