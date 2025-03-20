package aufgaben.strings;

public class StringEinfachIsTextFile {


	/*
	 * Aufgabe:
	 * 
	 * 	Erstellen Sie eine Methode 'isTextFile', an die man einen 
	 * 	Dateinamen als String übergeben kann. 
	 * 	Die Methode liefert true, wenn die Dateierweiterung "txt" 
	 * 	(in allen Kombinationen der Klein- und Großbuchstaben) ist. 
	 * 	Sonst liefert die Methode false. 
	 * 
	 * 	Testen Sie Ihre Lösung mit unterschiedlichen Strings.
	 * 
	 * -----------------------------------------------------------
	 * 
	 * Die Unit-Tests mit JUnit.
	 * 
	 * - Wenn noch nicht geschenen: test-Verzeichnis im Projekt 
	 *   vorbereiten:
	 *   - Ein neues Verzeichnis 'test' im Projekt erzeugen 
	 *   - Im Package Explorer auf das Verzeichnis 'test' 
	 *     rechtsklicken und dann im Menu: 
	 *     'Build Path' -> 'Use as Source Folder'
	 * 
	 * Unter Eclipse JUnit-Test für eine Klasse erzeugen:
	 * 
	 * 	- Rechtsklick auf den Klassennamen im Package Explorer
	 *  - Im Kontextmenu: New -> Other...
	 *  - Im Wizar-Fenster: Java -> JUnit -> JUnit Test Case
	 *  - Im JUnit-Test-Case-Fenster:
	 *  	- unter 'Source folder' mit Button 'browse...' 
	 *        den Ordner 'test' festlegen
	 *       (Falls es keinen Ordner 'test' noch gibt: Unit-Test 
	 *        abbrechen und zuerst das Verzeichnis 'test' im 
	 *        Projekt erzeugen)
	 *         
	 * Die Tests der Methode 'isTextFile' finden Sie also
	 * im Verzeichnis 'test' in der Klasse 'AufgabeStringEinfachA2Test'
	 * 
	 * Mehr zu JUnit:
	 * 		https://junit.org/junit5/docs/current/user-guide/
	 * 		
	 */
	
	public static void main(String[] args) {
	    // isTextFile ??
	    System.out.println("Ist aaa.png eine Textdatei? : " + isTextFile("aaa.png"));
	    System.out.println("Ist document.txt eine Textdatei? : " + isTextFile("document.txt"));
	    System.out.println("Ist document.pdf eine Textdatei? : " + isTextFile("document.pdf"));
	    System.out.println("Ist document.txt eine Textdatei? : " + isTextFile("document.txt"));
	    System.out.println("Ist script.TxT eine Textdatei? : " + isTextFile("script.TxT"));
	    System.out.println("Ist example.TXT eine Textdatei? : " + isTextFile("example.TXT"));

	}
	
	static boolean isTextFile(String filename) {
		 if (filename == null || !filename.contains(".")) {
	            return false;
	        }
		 String extension = filename.substring(filename.lastIndexOf(".") + 1);
	     return extension.equalsIgnoreCase("txt");
	}

}
