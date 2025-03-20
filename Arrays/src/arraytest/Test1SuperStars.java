package arraytest;

import java.util.Scanner;

public class Test1SuperStars {

	/*
	 * 	## TEST 1
		Aufgabe 1:
			Wir simulieren die Abstimmung bei "Deutschland sucht den Superstar". Die
			Zuschauer können anrufen und ihren Favoriten aus einer bestimmten Anzahl an
			Sängerinnen und Sängern wählen. Auf dem TV ausgeben wird letztendlich pro
			Sängerin bzw. Sänger die Anzahl an Zuschauern, die für sie bzw. ihn gestimmt
			haben, und zwar prozentual.
			1. Schreiben Sie Java-Programm, in dem der Benutzer zunächst die Anzahl an
			Sängern und anschließend für jeden Sänger die Anzahl an Anrufen eingeben muss.
			2.Speichern Sie die Daten in einem geeigneten Array ab. 
			3. Anschließend soll das Ergebnis der Abstimmung in Form eines Balkendiagramms 
			auf den Bildschirm ausgegeben werden. 
			4. Und zwar sollen entsprechend der prozentualen Verteilung der
			Telefonanrufe jeweils Balken aus *-Zeichen (100 % entsprechen dabei 100 *-
			Zeichen) sowie anschließend der absolute Wert der Telefonanrufe auf den Bildschirm
			ausgegeben werden.
			
			Beispiel für einen Programmablauf (Eingaben stehen in <>):
			Anzahl der Saenger (> 0): <4>
			Anrufe für Saenger 1 (>= 0): <50>
			Anrufe für Saenger 2 (>= 0): <50>
			Anrufe für Saenger 3 (>= 0): <40>
			Anrufe für Saenger 4 (>= 0): <60>
			Abstimmungsergebnis:
			************************* 50
			************************* 50
			******************** 40
			****************************** 60

	*+
	*/
	
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	     // Anzahl der Sänger abfragen
	     System.out.print("Anzahl der Sänger (> 0): ");
	     int anzahlSaenger = scanner.nextInt();
	     
	     int[] aufrufe = new int[anzahlSaenger];
	     
	     for( int i = 0 ; i < aufrufe.length ; i++ ) {
	    	 System.out.print("Anrufe für Sänger " + i + "(>=0) :") ;
	    	 aufrufe[i] = scanner.nextInt();
	     }
	     
	     System.out.println("Abstimmungsergebnis:");
	     
	     for( int i = 0 ; i< aufrufe.length ; i++) {
	    	 System.out.print(aufrufe[i]);
	    	 for(int j = 0 ; j<aufrufe[i] ; j++) {
	    		 
	    	 }
	     }
	     
	     
	     

	     
	     
	     
	     scanner.close();
		
	}
	
	
	static void test1(int length) {
		
		char[] ch = new char[length];
		for(int i = 0 ; i < ch.length ; i++) {
			System.out.print('*');
		}
		System.out.print(" " + length);
		System.out.println();
	}

}
