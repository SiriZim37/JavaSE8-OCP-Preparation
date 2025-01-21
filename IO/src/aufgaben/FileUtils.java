package aufgaben;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	 // A2
		public static void saveArray(int[] array, String fileName) {

			try (BufferedWriter out = new BufferedWriter( new FileWriter(fileName))){
				
			    for (int value : array) {
//			    	out.write(value); // falsch! Diese Methode ist zum Speichern von einem char! 	
			    	
			    	out.write(String.valueOf(value)); 
			    	out.newLine();
	            }
				
			} catch (IOException e) {
				System.err.println("Fehler beim Schreiben : " + e);
				throw new UncheckedIOException(e);
			}

		}
		
		
		// A3 
		public static int[] loadArray(String fileName) {
			List<Integer> values = new ArrayList<>();
		    
			try (BufferedReader read = new BufferedReader(new FileReader(fileName))) {
		        
				String line;
				
		         while ((line = read.readLine()) != null) {
		        	 int x = Integer.parseInt(line.trim());
		             values.add(x); 
		         }
		         
		     } catch (FileNotFoundException e) {
		         System.out.println("'" + fileName + "'  wurde nicht gefunden: " );	         
		     } catch (IOException e) {
		         System.out.println("Fehler beim Lesen " + e.getMessage());
		         throw new UncheckedIOException(e);
		         
		     }
		    
		     return values.stream().mapToInt( x -> x ).toArray();
		}
		
}
