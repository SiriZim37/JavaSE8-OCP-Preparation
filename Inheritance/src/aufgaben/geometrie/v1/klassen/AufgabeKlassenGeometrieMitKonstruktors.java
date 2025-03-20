//package Aufgaben;
//
//import java.util.Random;
//
//class Geometrie {
//	/*
//	 * Ein Konstruktor in Java (und anderen objektorientierten Programmiersprachen) 
//	 * ist eine spezielle Methode, die verwendet wird, um Objekte einer Klasse zu initialisieren. 
//	 * Konstruktoren haben den gleichen Namen wie die Klasse und haben keinen Rückgabewert, 
//	 * nicht einmal void. Sie werden automatisch aufgerufen, wenn eine Instanz der Klasse erstellt wird.
//	 * 
//	 */
//	
//	class Rechteck {
//		
//		int breite;
//		int hoehe;
//
//		 // Statische Methode
//		void printRechteck(int i) {		
//			 System.out.println(i +".Rechteck (" + breite + " X " + hoehe + ")");
//		}
//		
//		Rechteck(int neuBreite, int neuHoehe) {
//			hoehe = neuHoehe; 
//			breite = neuBreite;
//		}
//
//	 }
//	
//	 class Circle {
//
//		int radius;
//
//		void printKreise() {
//			 System.out.println("Kreis. R = " + radius);
//		}
//		
//		void Kreise(int rad){
//			radius = rad;  // oder radius = rad
//		}
//			
//	 }
//	
//	
//	
//}
//
//public class AufgabeKlassenGeometrieMitKonstruktors {
//
//	public static void main(String[] args) {
//		
//Random random = new Random();
//		
//		Geometrie geo = new Geometrie();
//
//		System.out.println("#--Statische Methode--#");
//		Rechteck(geo , 19 , 11 ); // Konstante Werte// Test
//		printRechteck(geo ,0);
//		
//		System.out.println("#--Nicht-statische Methode-#");
//		int i = 1 ;
//		while(i <= 100) {
//			// Nicht-statische Methode, 
//			geo.Rechteck(random.nextInt(20) + 1 , random.nextInt(20) + 1);
//			geo.printRechteck(i);
//			i++;
//		}
//		
//		System.out.println("#--Statische Methode--#");
//		//Statische Methode,
//		Geometrie.Kreise(geo, 5);
//		Geometrie.printKreise(geo);
//		
//		System.out.println("#--Nicht-statische Methode-#");
//		// Nicht-statische Methode, 
//		geo.Kreise(5);
//		geo.printKreise();
//		
//		
//	}
//}
package aufgaben.geometrie.v1.klassen;


