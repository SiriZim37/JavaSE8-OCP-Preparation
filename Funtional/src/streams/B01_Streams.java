package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class B01_Streams {

	/*
	 * Stream API :
	 * 
	 * 		https://docs.oracle.com/javase/8/docs/api/?java/util/stream/Stream.html
	 * 
	 * Wichtige Typen und Begriffe
	 * 		
	 * 		https://docs.oracle.com/javase/8/docs/api/?java/util/stream/package-summary.html
	 */
	public static void main(String[] args) {
		
		System.out.println("***1.");
		List<Integer> datenQuelle = Arrays.asList(5,2,3,-6,-7,42,null,0,77,3);
		
		Stream<Integer> stream = datenQuelle.stream();
		
		// filter mit Predicate erzeugt 
		// wieder einen Stream (intermediatly)
		Stream<Integer> streamTemp = stream.filter(i -> i!= null).filter(i -> i > 0 );  

		
		// man kan einen terminierten Stream nicht noch einmal verwenden.
		
		int summe = streamTemp.mapToInt( i -> i ).sum();		
		
		System.out.println("summe = " + summe);
		
		System.out.println("\n***2.");
		
		// Sequenzieler Stream als Einzeiler :
		//Filter nach not null Filter nach neativen Zahlen ,
		//Ausgabe untereinander
		datenQuelle.stream().filter(i -> i!= null).filter(i -> i < 0 ).forEach(System.out::println);

		
		
		System.out.println("\n***3.");
		//Paraller Stream
		datenQuelle.parallelStream().filter(i -> i!= null).map(i -> i+1).map( i -> i*2).forEach(System.out::println);
		
		System.out.println("\n***4.");
		// Paralleler Stream 
		datenQuelle.parallelStream().map(i -> i + 1).map(i -> i * 2).forEach(System.out::println);
		
	}

}
