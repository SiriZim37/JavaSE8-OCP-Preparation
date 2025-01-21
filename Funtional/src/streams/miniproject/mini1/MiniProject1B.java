package streams.miniproject.mini1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.crypto.Data;

public class MiniProject1B {

	public static void main(String[] args) throws IOException {
		
		
		Stream<String> filesStream = Files.lines(Paths.get("plz_ort.csv"));
		
		
		List<Ort> orte = filesStream.skip(1)  	
								 .map(zeile -> zeile.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")) // split bei Kommas außerhalb von Anführungszeichen
								 .map(entry -> new Ort(  Integer.parseInt(entry[0]), 	// OSM_ID
										 				 entry[1], 						// Ort (Ohne quotes)
										 				 entry[2] ,   // PLZ
										 				 entry[3]))						// Bundesland
								 .collect(Collectors.toList());
	
//		orte.forEach(System.out::println);

		b1(orte);
		b2(orte);
		b3(orte);
		b4(orte);		
		b5(orte);	
		
	}
	
	// 1 Sortieren nach PLZ 
	private static void b1(List<Ort> orte) {
		split() ;		
		System.out.println("***B1 ");

		orte.stream().sorted(Comparator.comparing(Ort::getPostleitzahl))
					 .forEach(System.out::println);
	}

	// 2 Ort mit der größten Postleihzahl
	private static void b2(List<Ort> orte) {
		split() ;
		System.out.println("***B2 ");
	
		orte.stream().max(Comparator.comparing(Ort::getPostleitzahl)).ifPresent(System.out::println);
	
	}	
	
	// 3 eine Komma-Separierte Liste mit allen Bundesländern (Ohne Dup)
	private static void b3(List<Ort> orte) {
		split() ;
		System.out.println("***B3 ");
		
		orte.stream()
			.sorted(Comparator.comparing(Ort::getBundesland))
	        .map(Ort::getBundesland)
	        .distinct()
	        .forEach(System.out::println);
		
		String myPostalCode = "29664";
		
		orte.stream().filter(ort -> ort.getBundesland().contains(myPostalCode))
		        	 .forEach(System.out::println);
	}
	
	// Welcher Ort die meisten Postleitzahl
	private static void b4(List<Ort> orte) {
		split() ;
		System.out.println("***B4 ");
		
		Map<String, Long> mapOrt = 
				orte.stream().collect(Collectors.groupingBy(
								Ort::getOrt,  
								Collectors.counting() 	// unique Postleitzahl 
							));
		
//		mapOrt.forEach((ort, count) -> System.out.println(ort + " = " + count));
		
		System.out.print("Welcher Ort die meisten Postleitzahl : ");

		mapOrt.entrySet().stream()
						 .max( Map.Entry.comparingByValue())
						 .ifPresent( entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));

	}
	
	//5. Erzeugen Sie eine Grupping nach bundesländern mit Anzahl der Ort Objekte pro bundesland ?
	private static void b5(List<Ort> orte) {
		split() ;
		System.out.println("***B5 ");
		
		Map<String, Set<String>> mapBundesland = 
					 orte.stream()
		            .collect(Collectors.groupingBy(
		                Ort::getBundesland,
		                Collectors.mapping(Ort::getOrt, Collectors.toSet()) 	//  unique Ort
		            ));
		
		// 
		Map<String, Long>  map = mapBundesland.entrySet().stream()
					.collect(Collectors.toMap(
		                Map.Entry::getKey, 
		                entry -> (long) entry.getValue().size() 
		            ));
		
		map.forEach( (bundesland, anzahl) -> System.out.println(bundesland + " = " + anzahl ) );


	}
	


	
	static void split() {
		System.out.println("\n----------------------------------------------------\n");
	}

}
