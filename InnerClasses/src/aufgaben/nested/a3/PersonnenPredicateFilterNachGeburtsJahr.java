package aufgaben.nested.a3;

import java.util.function.Predicate;

//#A3
public class PersonnenPredicateFilterNachGeburtsJahr implements Predicate<Person>{
	int minGeburtsjahr ;
	
	public PersonnenPredicateFilterNachGeburtsJahr(int minGeburtsjahr) {
		  if (minGeburtsjahr < 0) { 
	            throw new IllegalArgumentException("\"Das Jahr darf nicht negativ sein.");
	        }
		this.minGeburtsjahr = minGeburtsjahr;
	}
	

	public boolean test(Person p) {
		return p.getGeburtsjahr() > this.minGeburtsjahr; 
	}


}
