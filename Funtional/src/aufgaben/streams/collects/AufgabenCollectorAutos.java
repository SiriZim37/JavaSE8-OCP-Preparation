package aufgaben.streams.collects;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AufgabenCollectorAutos {
	
	public static void main(String[] args) {
		
	/*
	 * interface Collector<T, A, R> 
	 *  * @param <T> the type of input elements to the reduction operation
	 *    @param <A> the mutable accumulation type of the reduction operation (often
	 *            hidden as an implementation detail)
	 *    @param <R> the result type of the reduction operation
	 */
		List<Auto> autos = Arrays.asList(
				new Auto("VW", "Golf"),
				new Auto("VW", "Polo"),
				new Auto("Opel", "Corsa"),
				new Auto("Opel", "Astra")
			);
		
		autos.stream().forEach(System.out::println);
		
		System.out.println();
		
		// A1 mapping
		/*
		 *	mögliche Ausgabe: [VW, Opel]
		 */
		Collector<String, ?, Set<String>> downstream = Collectors.toSet();				
		Function<Auto, String> mapper = auto -> auto.getHersteller();		
		Collector<Auto, ?, Set<String>> collector = Collectors.mapping(mapper, downstream);		
		
		Set<String> set = autos.stream().collect(collector);
		System.out.println("A1. " + set); 		 // 
		
		
		split() ;
		
		// A2 	groupingBy 
		/*
		 * mögliche Ausgabe: {VW=[VW/Golf, VW/Polo], Opel=[Opel/Corsa, Opel/Astra]}
		 * 
		 */
		
		
		Collector<Auto, ?, Map<String, List<Auto>>> coll2 = 
				Collectors.groupingBy( auto -> auto.getHersteller() );		
		
		Map<String, List<Auto>> mapper2 = autos.stream().collect(coll2);	
		System.out.println("A2. " + (mapper2)); 		
		
		
		split() ;
		
		// A3  groupingBy	
		/*
		 *	mögliche Ausgabe: {VW=[Golf, Polo], Opel=[Corsa, Astra]}
		 */
		Function<Auto, String> classifier = Auto::getHersteller;  
		
		Collector<Auto, ?, List<String>> mapper3 = 
				Collectors.mapping(Auto::getModell, Collectors.toList()); 	

		Collector<Auto, ?, Map<String, List<String>>> coll3 =  
				Collectors.groupingBy(classifier, mapper3);
		 																	 
		Map<String, List<String>> map3 = autos.stream().collect(coll3);	
		System.out.println("A3. " + map3);  		
		
		
		split() ;
		
		// A4 groupingBy
		/*
		 * Ausgabe: {Opel=[Opel/Corsa, Opel/Astra], VW=[VW/Golf, VW/Polo]}
		 */		
			
		Comparator<String> cmp = (s1,s2) -> s1.compareTo(s2);
		  
		Collector<Auto, ?, Map<String, List<Auto>>> coll4 = 
				Collectors.groupingBy(  Auto::getHersteller,	//  classifier
										TreeMap::new,  
										Collectors.toList() 
									  );		
		
		Map<String, List<Auto>> map4 = autos.stream().collect(coll4);
		System.out.println("A4. " + map4); 
		
		
		split() ;
		
		// A5. partitioningBy
		
		
		Predicate<Auto> pred = auto -> auto.getModell().contains("o");  
		
		Collector<Auto, ?, Map<Boolean, List<Auto>>> coll5 = Collectors.partitioningBy(pred);
		
		Map<Boolean, List<Auto>> partitionedMap = autos.stream().collect(coll5); 
		
	
		
		System.out.println("A5. " + partitionedMap); 
		
		partitionedMap.forEach((key,value)-> System.out.println(key.equals(true) + ":" + value));
		
		System.out.println("\ntrue  : " + partitionedMap.get(true));		//true  : [VW/Golf, VW/Polo, Opel/Corsa]
		
		System.out.println("false : " + partitionedMap.get(false));		//false : [Opel/Astra]
		
	}
	
	static void split() {
		System.out.println("\n------------------------------------------------------");
	}
}
