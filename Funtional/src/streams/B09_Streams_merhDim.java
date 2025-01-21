package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class B09_Streams_merhDim {

	public static void main(String[] args) {

		Integer[] umsaetze2021 = { 2000 , 15000 , 35000 ,2750};
		Integer[] umsaetze2022 = { 2000 , 15000 , 35000 ,2750};
		Integer[] umsaetze2023 = { 2000 , 15000 , 35000 ,2750};
		
	
		Stream<Integer> stream2021 = Arrays.stream(umsaetze2021);
		Stream<Integer> stream2022 = Arrays.stream(umsaetze2022);
		Stream<Integer> stream2023 = Arrays.stream(umsaetze2023);
		
		Stream<Stream<Integer>> streamGesamt = Stream.of(stream2021 , stream2022 , stream2023);
		
		Function<Stream<Integer>, Stream<Integer>> func = innerStream -> innerStream; 

		// Variante 1
//		streamGesamt.flatMap(func) 
//	            .filter(umsatz -> umsatz >= 2000) 
//	            .forEach(System.out::println); 

		System.out.println();
		
		// Variante 2 
		streamGesamt.flatMap(Function.identity()) 
		        .filter(umsatz -> umsatz >= 2000) 
		        .forEach(System.out::println); 
	}

}
