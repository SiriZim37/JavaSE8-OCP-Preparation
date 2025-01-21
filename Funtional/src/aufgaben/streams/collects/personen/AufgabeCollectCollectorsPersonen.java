package aufgaben.streams.collects.personen;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class AufgabeCollectCollectorsPersonen {

	public static void main(String[] args) {
	
		Person[] personen = {
			new Person("Tom", "Bauarbeiter(in)"),	
			new Person("Jerry", "Lehrer(in)"),	
			new Person("Peter", "Metzger(in)"),	
			new Person("Paul", "Bauarbeiter(in)"),	
			new Person("Mary", "Lehrer(in)"),	
		};
			
		Arrays.stream(personen).forEach(System.out::println);
		
		// A1
		TreeSet<Person> personTreeSet = Arrays.stream(personen)
								    	  .collect( Collectors.toCollection( 
								    			  			() -> new TreeSet<>( Comparator.comparing(p->p.getName()) ) 
								    			   ));	
		
		System.out.println("\nA1. " );
		personTreeSet.forEach( p -> System.out.print( p + " " ));
		/*
		 * Jerry Mary Paul Peter Tom 
		 */
		
		
		// A2 toMap
		// Alternativ 1
		System.out.println();
		System.out.println("\n\nA2. "  );
		Map<String, List<Person>> mapPerson = Arrays.stream(personen)
													.collect(Collectors.groupingBy(Person::getName));
		mapPerson.forEach((k,v) -> System.out.println( k + v ));
													
		System.out.println();
		// Alternativ 2
		Map<String, Person> personMap  =  Arrays.stream(personen)
		 								 	  .collect( Collectors.toMap( 
		 								 			   	  p-> p.getName(),		 // key   : String-Namen
		 								 			      person -> person 		 // value : eine Person
		 								 			   ));
		
		personMap.forEach((name, person) -> System.out.println(name + " = " + person));
		/*
		  	Tom = Tom
			Peter = Peter
			Jerry = Jerry
			Paul = Paul
			Mary = Mary
		 */
		
		
		// A3. mapping
		Set<String> berufSet = Arrays.stream(personen)
									 .collect(Collectors.mapping(
												 Person::getBeruf , 
												 Collectors.toSet()	  // einzigartig
											 ));

		System.out.println("\nA3. Beruf : ");
		berufSet.forEach(System.out::println);
		/*
		 *  Metzger(in)
		 *  Bauarbeiter(in)
		 *  Lehrer(in)
		 */
		
		
		// A4.  groupingBy
		Map<String, List<Person>> mapGrouping = 
								Arrays.stream(personen)
								      .collect( Collectors.groupingBy(Person::getBeruf) );
		 
		System.out.println("\nA4. "  );
		mapGrouping.forEach((name, person) -> System.out.println(name + " = " + person));
		/*
		 * Metzger(in) = [Peter]
		 * Lehrer(in) = [Jerry, Mary]
		 * Bauarbeiter(in) = [Tom, Paul]
		 */
		 
		
		//  A5. Optional. partitioningBy
		String keyword = "Bauarbeiter(innen)";
		Map<Boolean, List<Person>> partitioningMap = 
					  Arrays.stream(personen)
							.collect( Collectors.partitioningBy( p -> p.getBeruf().equals(keyword))  );
		
		System.out.println("\nA5.");		
		partitioningMap.forEach((key , value) -> System.out.println(key + " : " + value ));
		/*
		 * false : [Tom, Jerry, Peter, Paul, Mary]
		 * true : []
		 */
	
	}

}
