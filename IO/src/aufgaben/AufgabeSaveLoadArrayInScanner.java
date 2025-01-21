package aufgaben;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AufgabeSaveLoadArrayInScanner {

	public static void main(String[] args) {

		// #A5 
		boolean runProgramm = true; 
		
		Scanner scanner = new Scanner(System.in); 
		
		while (runProgramm) {
		
			System.out.println("Möchten Sie ein int-Array erzeugen (E/e) oder laden (L/l) (Geben Sie X zum Beenden ein)?");
	       
			String input = scanner.nextLine().trim().toUpperCase();
			
			 if (input.equals("E")) {
				 System.out.println("Geben Sie die Größe des Arrays ein : ");
				 int length = scanner.nextInt();
		         scanner.nextLine();
		         
		         int min , max;
		         
		         while (true) {
		        	    System.out.println("Geben Sie die zufällige minimale Zahl : ");
		        	    min = scanner.nextInt();
		        	    scanner.nextLine();
	
		        	    System.out.println("Geben Sie die zufällige maximale Zahl  : ");
		        	    max = scanner.nextInt() + 1; // exklusive Zahl
		        	    scanner.nextLine();
		        	    
		        	    if (min < max) {
		        	        break;
		        	    } else {
		        	        System.out.println("Die minimale Zahl muss kleiner als die maximale Zahl sein. Bitte versuchen Sie es erneut.");
		        	    }
		        }
		         
		       
		         String fileName;
		        
		         while (true)  {
		        	  System.out.print("Geben Sie einen Dateinamen ein, um das Array zu speichern: ");
		        	  fileName = scanner.nextLine();
		        	  if(checkValidFileName(fileName)){
		        		  break;
		        	  }else {
		        		  System.out.println("Invalid Datai Name");
		        	  }
		         }
	
		         System.out.println("zufällige Minimale Zahl: " + min);
			     System.out.println("zufällige Maximale Zahl: " + max);
			     System.out.println("Filename : " + fileName +".txt");
	
			     int[] array = MyArrayUtils.createArray(length, min, max); 
				 FileUtils.saveArray(array, fileName); 
				 System.out.println("Datei gespeichert in " + fileName);
	
			 }else if(input.equals("L")) {
		         
				 System.out.print("Geben Sie den Dateinamen ein, um das Array zu laden: ");
		         
				 String fileName = scanner.nextLine();
	                
		         int[] loadedArray = FileUtils.loadArray(fileName); 
		            
		         System.out.println("Geladenes  Array: ");
		         
		         for (int value : loadedArray) {
		             System.out.print(value + " ");
		         }
		         
		         System.out.println();
		         
			 }else if (input.equals("X")) {
	             System.out.println("Programm beendet...");
	             runProgramm = false;      
			 }else {
				 System.out.println("Program beendet...");
				 scanner.close();
			 }
		}
		scanner.close();
	}



	 static boolean checkValidFileName(String fileName) {
		 if (fileName == null || fileName.trim().isEmpty()) {
		     return false;
		 }

		 if (fileName.contains(".")) {
		     return false; 
		 }
		 
		 if (fileName.length() > 255) {
		     return false; 
		 }
	
		 return true;
	  }
	
}
