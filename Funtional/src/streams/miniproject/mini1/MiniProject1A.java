package streams.miniproject.mini1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MiniProject1A {

	public static void main(String[] args) throws IOException {
		
		Stream<String> filesStream = Files.lines(Paths.get("plz_ort.csv"));
		List<String[]> data = filesStream.skip(1)  							// skip zeile 1
				 						.map(zeile -> zeile.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")) // split bei Kommas außerhalb von Anführungszeichen
										.collect(Collectors.toList());
		
		/*
		 *  entry[1] OSM-ID
		 *  entry[2] Ort
		 *  entry[3] PLZ
		 *  entry[4] Bundesland
		 *  
		 */
		
//		data.forEach( entry -> System.out.println("OSM-ID : " + entry[0] +
//												  " Ort :" + entry[1] + 
//												  " PLZ : " + entry[2] +
//												  " Bundesland : " + entry[3] ));
	
		a1(data);
		a2(data);
		a3(data);
		a4(data);				
		
	}
	
	// A1. Geben alle Datei aus.
	static void a1(List<String[]> data) {
		split();
		System.out.println("***A1");
//		data.forEach( entry -> System.out.println(String.join(", ", entry)));
		
		data.forEach( entry -> System.out.println(printTabelle(entry)));

	}
	
	// A2. Für eine bestimmte Postleitzahl 
	static void a2(List<String[]> data) {
		split();
		System.out.println("***A2 ");
		
		String myPostalCode = "29664";
		
		data.stream().filter(entry -> entry[2].contains(myPostalCode))
		        	 .forEach(entry -> System.out.println(String.join(", ", entry)));
	
	}
	
	// A3. Für eine bestimmte Postleitzahl Ohne OSM-ID 
	static void a3(List<String[]> data) {
		split();
		System.out.println("***A3 ");
		
		String myPostalCode = "29664";
		
		data.stream().filter(entry -> entry[2].contains(myPostalCode))
		   			 .forEach(entry -> System.out.println(entry[1] + ", " + entry[2] + ", " + entry[3]));		
	}
	
	// A4. Nur den Ort
	static void a4(List<String[]> data) {
		split();
		System.out.println("***A4 ");
		
		String myPostalCode = "29664";
		
		data.stream().filter(entry -> entry[2].contains(myPostalCode))
					.forEach(entry -> System.out.println(entry[1]));		
	}
	

	
	static String printTabelle(String[] entry) {
		String sf = String.format("| %-8s | %-30s | %-5s | %-25s|", entry[0] ,  entry[1] ,  entry[2]  ,  entry[3] );
		return sf;
	}
	
	static void split() {
		System.out.println("\n----------------------------------------------------\n");
	}
}
