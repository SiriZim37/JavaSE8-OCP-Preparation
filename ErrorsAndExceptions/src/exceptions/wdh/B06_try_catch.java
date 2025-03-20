package exceptions.wdh;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class B06_try_catch {

	public static void main(String[] args) {

		
		
		/*
		 * Alle Möglichen Exceptions gleich behandeln
		 * 
		 */
		try {
			
			methodeMitExceptions();
			System.out.println("1. keine Exception");
			
		} catch (RuntimeException e) {
			System.out.println("1. abgefangen : " + e.getMessage());
			e.printStackTrace();
		}

		/*
		 * Jede möglicheException besonders behandeln
		 */
		
		try {
			
			methodeMitExceptions();
			System.out.println("2. keine Exception");
			
		} catch (IllegalStateException e) {
			System.out.println("2. IllegalStateException abgefangen : " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("2. NumberFormatException abgefangen : " + e.getMessage());
		}catch (IllegalArgumentException e) {
			System.out.println("2. IllegalArgumentException abgefangen : " + e.getMessage());
		}
		
		/*
		 * Achtung! Exam! 
		 * 
		 * - Die Reihenfolge der catch-Blöcke für Geschwisterklassen-Exceptions ist egal.
		 * 
		 * - Zuerts den catch-Block für abgeleitete Exception-Klasse , 
		 * 	 danach den catch-Block für Exception-Basisklasse
		 */
		
		// NumberFormatException && IllegalArgumentException sind geschwister klasse ( in diagram Thorable)
		try {
		} catch (IllegalStateException e) {			// Geschwister Klasse
		} catch (NumberFormatException e) {			// Geschwister Klasse
		}
		
		try {
		} catch (NumberFormatException e) {			// Geschwister Klasse
		} catch (IllegalStateException e) {			// Geschwister Klasse
		}
		
		try {
		} catch (NumberFormatException e) {			// Abgeleitete Klasse
		} catch (IllegalArgumentException e) {		// Basisklasse
		}
		
//		try {
//		} catch (IllegalArgumentException e) {	 //     Basisklasse
//		} catch (NumberFormatException e) {		// cf:	Abgeleitete Klasse
//		}
		
		/*
		 * alle unchecked Exceptions abfangen
		 */
		try {
			
		}catch (RuntimeException e) {
			//... 
		}
		/*
		 * alle Exceptions abfangen
		 */
		try {
			
		}catch (Exception e) {
			//... 
		}	
		
		/*
		 * alle Throwable abfangen
		 */
		try {
			
		}catch (Throwable e) {
			//... 
		}	
	
		/*
		 *  catch mit Nicht-Throwable kompiliert nicht
		 */
//		try {
//			
//		}catch (String e) { // cf 
//			//... 
//		}
		
		// alles mögliche kombiniert
		try {
			
		}catch (Exception e) {
			//... 
		}catch (Throwable e) {
			//... 
		}
//		catch (RuntimeException e) {		// cf : RuntimeException erbt Exception
//			//... 
//		}
		
		/*
		 * viele catch-Blöcke kombiniert
		 */
		try {
			
		}catch (NullPointerException e) {
			//... 
		}catch (RuntimeException e) {
			//... 
	
		}catch (Exception e) {
			
		
			//... 
		}catch (Error e) {
			//... 
		}catch (Throwable e) {
			//... 
		}

		
		

	}
	/**
	 * 	Die Methode kann (muss aber nicht) ein der
	 * drei Exceptions werfen : </br>
	 * 
	 * IllegalStateException </br>
	 * IllegalArgumentException </br>
	 * NumberFormatException </br>
	 */
	static void methodeMitExceptions() {
		Random rnd = new Random();
		switch (rnd.nextInt(4)) {	// |0|1|2|3|
			case 0 : throw new IllegalStateException();
			case 1 : throw new IllegalArgumentException();
			case 2 : throw new NumberFormatException();
			default :
		}
	}
	
	

	static void testIOException() throws IOException {
	    try {
	        // Code that might throw IOException
	        File file = new File("nonexistentfile.txt");
	        FileReader fr = new FileReader(file); // This line throws IOException
	        fr.close();
	    } catch (IOException e) {
	        // Handle IOException
	        System.out.println("IOException occurred: " + e.getMessage());
	    } catch (Exception e) {
	        // Handle other exceptions
	        System.out.println("Exception occurred: " + e.getMessage());
	    }
	}

}
