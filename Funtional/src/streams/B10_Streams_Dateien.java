package streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B10_Streams_Dateien {

	/*
	 	toList()			Collects elements into a List.
		toSet()				Collects elements into a Set.
		toMap()				Collects elements into a Map.
		joining()			Concatenates all elements into a single String.
		groupingBy()		Groups elements by a classifier function.
		partitioningBy()	Splits elements into two groups based on a predicate.
		summarizingInt()	Collects statistics such as count, sum, and average.
		reducing()			Reduces elements using a binary operation.
		collectingAndThen()	Applies an additional transformation after collection.
		mapping()			Maps elements before collecting them
	 */
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("herrscher.txt");
	  
		
		//
		Files.lines(path).forEach(System.out::println);
		
		
		split() ;
		// 
		long anzahl = Files.lines(path).count();
		System.out.println("Anzahl = " + anzahl) ;
		
		
		split() ;
		//
		Files.lines(path)
			.filter(name -> name.startsWith("Heinrich"))
			.reduce( (name1 , name2) -> name1 + " , " + name2)
			.ifPresent(System.out::println);
		
		
		split() ;
		
		// 
		System.out.println(Files.lines(path)
				.filter(name -> name.startsWith("Konrad"))
				.collect(Collectors.joining(", ")));
		
		split() ;
		
		// Grupping  
		/*
		  	Konrad 		: [Konrad I., Konrad II., Konrad III., Konrad IV.]
		 	Friedrich 	: [Friedrich I. Barbarossa, Friedrich II.]
			Heinrich 	: [Heinrich I., Heinrich II., Heinrich III., Heinrich IV., Heinrich V., Heinrich VI.]
			Otto 		: [Otto I. der Große, Otto II., Otto III., Otto IV.]
			Philipp 	: [Philipp]
			Lothar 		: [Lothar III.]
		*/
		Function<String, String> classifiert = name -> name.split(" ")[0] ; 
	    
		Files.lines(path)
			 .collect(Collectors.groupingBy(classifiert))
			 .forEach((key , value) -> System.out.println( key + " : " + value));
		
		System.out.println();
		// Grupping  Count 
		/*
		  	Konrad : 	4
			Friedrich : 2
			Heinrich : 	6
			Otto : 		4
			Philipp : 	1
			Lothar : 	1
		*/
		
		Files.lines(path)
		 .collect(Collectors.groupingBy(classifiert , Collectors.counting()))
		 .forEach((key , value) -> System.out.println( key + " : " + value));
		
		// Anzahl der Gesamt-Zahchen (mit Leerzeichen) im Stream (erwartes Ergebnis ca. 200)
		
		Integer identity = 0 ;
		
		BiFunction<Integer , String , Integer> acc = ( Integer gesamt , String line) -> {
	        // นับจำนวนอักขระในแต่ละบรรทัด
			System.out.println("gesamt :" + gesamt + " line.length() : " + + line.length()  + " = "  + (gesamt + line.length()));
	        return gesamt + line.length();
	    };
	    
	    BinaryOperator<Integer> comb = (Integer line1  , Integer line2 ) -> line1 + line2;
	     
	    // Alternativ 2 
	    Integer totalCharacters = Files.lines(path).reduce(identity, acc , comb);
        System.out.println("Anzahl der Gesamt-Zeichen: " + totalCharacters); 		// 207 
        	   
        long countProcess = Files.lines(path).count();  // 18 
       System.out.println("countProcess = " + countProcess);    
       
        // Alternativ 3
        long anZahlZeichenAsLong = Files.lines(path)
        							.mapToInt(String::length)
        							.sum();;
        System.out.println("anZahlZeichenAsLong mit mapToInt, sum : "+ anZahlZeichenAsLong ); // 207 
        
        
		
	}
	static void split() {
		System.out.println("\n------------------------------------------------------");
	}
}
