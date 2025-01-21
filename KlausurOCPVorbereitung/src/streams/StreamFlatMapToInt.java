package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFlatMapToInt {

	public static void main(String[] args) {
		
		/*
		 	Stream<List<String>> iStr= Stream.of (
			    Arrays.asList ("1", "John"),
			    Arrays.asList ("2", null));
			Stream<String> nInSt = iStr.flatMapToInt ((x) -> x.stream ());  // cf 
			nInSt.forEach (System.out :: print);
		*/

			 
		//----------------------------------------
		/*
		 * Lösung
		 */
		Stream<List<String>> iStr= Stream.of (
			    Arrays.asList ("1", "John"),
			    Arrays.asList ("2", null));
		Stream<String> nInSt = iStr
	            .flatMap(x -> x.stream()) 	// Flacht den Stream zu einem Stream<String> ab
	            .filter(Objects::nonNull); 	// Entfernt null-Werte

	        nInSt.forEach(System.out::print); // Gibt die Strings aus
	}
}
