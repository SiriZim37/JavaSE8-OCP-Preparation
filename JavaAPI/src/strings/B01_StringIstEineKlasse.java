package strings;

public class B01_StringIstEineKlasse {

	public static void main(String[] args) {

		String s1; // Referenz
		
		new String(); // neues Objekt (es geht, ist aber nicht empfohlen)
		
		s1 = new String();
		
		s1.length(); // Instanz-Methode der Klasse String aufrufen

		String.valueOf(false); // statische Methode der Klasse String aufrufen
		
	}

}
