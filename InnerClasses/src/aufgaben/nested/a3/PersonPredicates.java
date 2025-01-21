package aufgaben.nested.a3;

import java.util.function.Predicate;

public class PersonPredicates {
	// #A4
	private static class PredicateSubstringnachName implements Predicate<Person>{
		
		private String subStr ;

		public PredicateSubstringnachName(String subStr) {
			if (subStr.length() < 1) { 
		         throw new IllegalArgumentException("Substring darf nicht leer sein.");
		    }
			this.subStr = subStr ;
		}		
		public boolean test(Person p) {
			return p.getNachname().toUpperCase().contains(subStr.toUpperCase());
		}
		
	}
	
	// #A4
	public static Predicate<Person> filterNachNachnameSubstring (String substring){
		return new PredicateSubstringnachName(substring);
	}
	
	 // #A5.2 
	public static Predicate<Person> filterMindestlaengeNachname (int minLength){

			class MyPredicate implements Predicate<Person>{
				public boolean test(Person p) {
					return p.getNachname().length() >= minLength;
				}
			}
			
		return new MyPredicate();
	}
	
	 // #A6.2 
	
	public static Predicate<Person> getCombined(Predicate<Person> predicateA , Predicate<Person> predicateB) {
		
		return new  Predicate<Person>() {
			public boolean test(Person p) {
				return predicateA.test(p) && predicateB.test(p);
			}
		};
	}
	
	
}
