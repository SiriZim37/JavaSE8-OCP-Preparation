package aufgaben.nested.a3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class TestPerson {

	public static void main(String[] args) {
		
		// #A1
		Person[] arrPerson = { 	new Person("Hermione", "Grenger" , 1988) , 
								new Person("Harry", "Potter" , 2000) , 
								new Person("Ron", "Wisly" , 1885) , 
								new Person("Dobby", "Non" , 1994) , 
								new Person("Molfoy", "Drago" , 2010) , 
							 };
		Arrays.sort(arrPerson);
		for (Person p : arrPerson) {
			System.out.println(p);
		}

		int jahr = 1995;
		
		// #A2
		System.out.println("\nA2. Personen geboren vor 1995: ");
		
		List<Person> filterP1 = filtern(arrPerson, p -> p.getGeburtsjahr() < jahr);
		
		filterP1.forEach(System.out::println);

		// #A3
		System.out.println("\nA3.Personen geboren nach " + jahr + ":");
		
		Predicate<Person> nachJahrFilter = new PersonnenPredicateFilterNachGeburtsJahr(jahr);	
		
		List<Person> filterP2 = filtern(arrPerson, nachJahrFilter);
		
		filterP2.forEach(System.out::println);
		
		
		//#A4
		String nachName = "a";
		
		System.out.println("\nA4.Personen mit 'a' im Nachnamen: " + nachName + ":");
		
		Predicate<Person> gefilterteNachnamen  = PersonPredicates.filterNachNachnameSubstring(nachName);
		
		List<Person> filterP4 = filtern(arrPerson, gefilterteNachnamen );
		
		filterP4.forEach(System.out::println);
		
		
		// #A5.1 : lokalen Klasse
		 System.out.println("\nA5.2 Personen mit mindestens 6 Zeichen im Nachnamen: ");
		
		 Predicate<Person>  gefilterteNachnamen3 =  PersonPredicates.filterMindestlaengeNachname(6); 
		
		 List<Person> filterP5_2 = filtern(arrPerson, gefilterteNachnamen3 );
		
		 filterP5_2.forEach(System.out::println);

		 
		 // #A5.2 : lokalen Klasse
		 System.out.println("\nA5.1 Personen mit mindestens 4 Zeichen im Nachnamen: ");
		 
		 class NachnameMitMindestens4ZeichenFilter {
		        public Predicate<Person> filter() {
		             return person -> person.getNachname().length() >= 4;
		        }
		  }
		 
		 Predicate<Person> gefilterteNachnamen2  = new NachnameMitMindestens4ZeichenFilter().filter();
		
		 List<Person> filterP5 = filtern(arrPerson, gefilterteNachnamen2 );
		
		 filterP5.forEach(System.out::println);
		 

		 // #A6 ( Test in PersonPredicates)
		System.out.println("\nA6.2 Personen Filter API (nach " + jahr + " und 'a' im Nachnamen): ");
			
	    Predicate<Person> filterA =  new PersonnenPredicateFilterNachGeburtsJahr(jahr) ; //  jahr = 1995
	  
	    Predicate<Person> filterB =  PersonPredicates.filterMindestlaengeNachname(6);	
	    
		Predicate<Person> filterCombined = PersonPredicates.getCombined(filterA , filterB); 
		
		List<Person> filterP6_2 = filtern(arrPerson, filterCombined );
		
		filterP6_2.forEach(System.out::println);
			
		
		// #A6.2 Anonymen Klasse ( Zwei Filter A und B und test mit der Methode  filtern )	
		System.out.println("\nA6.1 Personen Filter (nach " + jahr + " und mit mindestens 4 Zeichen im Nachnamen): ");
		
		List<Person> filterP6_1 = filtern(arrPerson, new Predicate<Person>() {
	            @Override
	            public boolean test(Person p) {
	                return filterA.test(p) && filterB.test(p);
	         }
	    });
			
		filterP6_1.forEach(System.out::println);
		 

		// #A6.3 ( Alternative Test mit API)
		System.out.println("\nA6.2 Personen Filter API (nach " + jahr + " und 'a' im Nachnamen): ");
		
		Predicate<Person> filterC  =  PersonPredicates.filterNachNachnameSubstring(nachName); 
		
		Predicate<Person> apiTestFilter =  filterA.and(filterC);
	
		List<Person> filterP6_3 = filtern(arrPerson, apiTestFilter );
		
		filterP6_3.forEach(System.out::println);
		

		// #A7 ( Such nach einem Schaltjahr ( Es eibt den 29. Februar im Jahr ))
		System.out.println("\nA7.Geboren in einem Schaltjahr: ");
		
		Predicate<Person> schaltjahrFilter  = p -> LocalDate.of(p.getGeburtsjahr(),1,1).isLeapYear();	

		List<Person> filterP7 = filtern(arrPerson, schaltjahrFilter );
		
		filterP7.forEach(System.out::println);
	}
	
	// #A2
	public static List<Person> filtern ( Person[] personen , Predicate<Person> t){
		List<Person> result = new ArrayList<>();
		for (Person p : personen) {
			if(t.test(p)) {
				result.add(p);
			}
		}
		return result;
	}

}
