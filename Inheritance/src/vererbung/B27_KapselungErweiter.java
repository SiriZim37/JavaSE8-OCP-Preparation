package vererbung;

import java.util.Date;
import java.util.Random;

public class B27_KapselungErweiter {
/*
 * Kapselung zielt darauf ab, die inneren Details eines Objekts zu verbergen und 
 * den Zugriff auf die Daten nur über definierte Schnittstellen zu erlauben. 
 * Das schützt die Daten vor unerwünschtem Zugriff oder Änderungen von außen.
 *
 * Wenn Ihre Klasse jedoch ein mutable Objekt (wie StringBuilder) als Feld hat
 * und dieses Objekt über eine Getter-Methode zugänglich macht, 
 * kann der Aufrufer die Daten direkt ändern, was die Kapselung untergräbt.
 */
	public static void main(String[] args) {
	
		Logger logger = new Logger();
//		System.out.println(logger.getLog());
		logger.getLogSB().insert(500, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXIch bin Superhacker mehr XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		logger.getLogSB().delete(0, logger.getLogSB().length());
		System.out.println(logger.getLogSB()); // Diese Zeile zeigt das veränderte LogSB, nicht das interne Log
		
	}

}

// Die Klasse Logger ist gekapselt (well encapsulated)
class Logger{
	
	private String log = "";
	private StringBuilder logSB = new StringBuilder("");

	
	Logger() {
		for(int i = 0 ; i < 1000 ; i++) {
			log += "Test : IP 192.168.0.2 , Datum " + new Random().nextInt(200)+40 + " , Datum " + new Date() + System.lineSeparator();
			logSB.append("Test : IP 192.168.0.2 , Datum " + new Random().nextInt(200)+40 + " , Datum " + new Date() + System.lineSeparator());
		
		}
	}

	public String getLog() {
		return log;
	}

	// Problem bei der Kapselung : das Objekt ist mutable (veränderlich)!! 
	// Lösung : es wird nicht das <originalobjekt zurückgegeben , sondern eine Kopie !
	public StringBuilder getLogSB() {
//		return logSB; // nicht korrekt , das Originalobjekt kann von außer verändert werden // 
					  // Das Originalobjekt wird zurückgegeben, was zu Sicherheitsproblemen führen kann
		
		return new StringBuilder(logSB); // Es gibt keine Superhacker mehr : Copy-Konstruktor verwenden und Kopie des Originalobjekts zurückgeben.
										// Durch die Rückgabe einer Kopie des StringBuilder-Objekts können Benutzer der Klasse Änderungen an der Kopie vornehmen,
										//ohne die interne Struktur der Klasse zu beeinflussen.
	}
	
//	public void setLog(String log) {
//		this.log = log;
//	}
	
}
