package aufgaben;

import java.util.Scanner;

public class AufgebeIfAbfrage {
	
	
	/*# Aufgabe 'if-Abfrage'

	Gegeben ist die aktuelle Ampelfarbe, die in einer Variable `farbe` gespeichert ist.

	Benutzen Sie bitte die if-Abfrage (beliebige if/else-if/else-Kombinationen) um die Farbe zu analysieren. 
	Setzen Sie folgende Zeichenketten ein, um den Zustand der Ampel auszugeben:

		    "Rot. Bitte warten"
		    "Gelb. Gleich geht es los"
		    "Grün. Weg frei"
		    "Fehler! Diese Farbe gibt es nicht."
	 */


	public static void main(String[] args) {
		
		res1();
		inputData();

	}
	
	static void res1() {
		System.out.println("\n\n*** result 1 Variablen definieren ****");
		String[] farbe = {"Rot" , "Gelb" , "Grün", "Schwarz"}; 
		
		for( int i= 0 ; i < farbe.length ; i++) {
			System.out.println("Farbe : " + farbe[i]);
			if(farbe[i]=="Rot") {
				System.out.println("Rot. Bitte warten");
			}else if(farbe[i]=="Gelb") {
				System.out.println("Gelb. Gleich geht es los");
			}else if(farbe[i]=="Grün") {
				System.out.println("Grün. Weg frei");
			}else {
				System.out.println("Fehler! Diese Farbe gibt es nicht.");
			}	
		}
		
	}
	
	static void inputData() {
		System.out.println("\n\n*** Input Variable ****");
		/*
		 *  console input data
		 */	
		Scanner scan = new Scanner(System.in);		
	    System.out.print("\n\nGeben Sie eine Farbe ein: ");
	    String iFarbe = scan.nextLine(); 
//	    iFarbe += scan.nextLine(); 
	    scan.close();
		if(iFarbe.equalsIgnoreCase("Rot")) {
			System.out.println("Rot. Bitte warten");
		}else if(iFarbe.equalsIgnoreCase("Gelb")) {
			System.out.println("Gelb. Gleich geht es los");
		}else if(iFarbe.equalsIgnoreCase("Grün")) {
			System.out.println("Grün. Weg frei");
		}else {
			System.out.println("Fehler! Diese Farbe gibt es nicht.");
		}

		
			
	}

}
