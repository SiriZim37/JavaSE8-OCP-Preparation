package func;


import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;


class Person {
	private String vorname;
	private String nachname;
	private int geburtsjahr;
	
	public Person(String vorname, String nachname, int geburtsjahr) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsjahr = geburtsjahr;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public int getGeburtsjahr() {
		return geburtsjahr;
	}
	
	public String toString() {
		return vorname + " " + nachname + " (" + geburtsjahr + ")";
	}
}


public class B18_ComparatorAPI {
	public static void main(String[] args) {
		test_compare();
		test_naturalOrder_reverseOrder();
		test_comparing();
		test_reversed();
		test_thenComparing();
	}
	
	/*
	 * default Instanzmethode
	 * 
	 * 		Comparator thenComparing(Comparator next)
	 */
	static void test_thenComparing() {
		System.out.println("\n*** thenComparing");
		
		Person p1 = new Person("Max", "Auerbach", 1990);
		Person p2 = new Person("Max", "Mustermann", 1995);
		
		Function<Person, String> func = (Person p) -> p.getNachname();
		// comparing(Function)
		
		Comparator<Person> cmpNachname = Comparator.comparing(Person::getNachname);		// ClassName::instanceMethodName
		
		Comparator<Person> cmpVorname = Comparator.comparing(Person::getVorname);		// ClassName::instanceMethodName
		
		Comparator<Person> cmpGeburtsjahr = (x, y) -> x.getGeburtsjahr() - y.getGeburtsjahr();
		
//		Comparator<Person> cmpCombined = (x, y) -> {
//			int result = cmpNachname.compare(x, y);
//			if (result != 0) {
//				return result;
//			}
//			
//			result = cmpVorname.compare(x, y);
//			if (result != 0) {
//				return result;
//			}
//			
//			return cmpGeburtsjahr.compare(x, y);
//		};
		
		// Zuerst die Logik von cmpNachname,
		// dann (wenn die Personen damit gleich sind)
		// die Logik von cmpVorname:
		Comparator<Person> cmpCombined = cmpNachname.thenComparing(cmpVorname);
		
		// Zuerst die Logik vom alten cmpCombined,
		// dann (wenn die Personen damit gleich sind)
		// die Logik vom cmpGeburtsjahr:
		cmpCombined = cmpCombined.thenComparing(cmpGeburtsjahr);
		
		int res = cmpCombined.compare(p1, p2);
		System.out.println("cmpCombined.compare(p1, p2): " + res);
		
		/*
		 * Praxis:
		 */
		cmpCombined = cmpNachname.thenComparing(cmpVorname)
				.thenComparing(cmpGeburtsjahr);
	}
	
	/*
	 * default Instanzmethode
	 * 
	 * 		Comparator reversed()
	 */
	static void test_reversed() {
		System.out.println("\n*** reversed");
		
		String a = "aaaaa";
		String b = "bb";
		
		// vergleicht Strings nach Länge
		Comparator<String> c1 = Comparator.comparing(String::length);	//  ClassName::instanceMethodName :
																		// Instance Method Reference of an Arbitrary Object of a Particular Type.
		
		int result = c1.compare(a, b);
		System.out.println("c1.compare(a, b): " + result); // positiv (a ist größer)
		
		// umgekehrte Logik
		Comparator<String> c2 = c1.reversed();
		
		result = c2.compare(a, b);
		System.out.println("c1.compare(a, b): " + result); // negativ (a ist kleiner)
		
	}

	/*
	 * static Comparator comparing(Function keyExtractor)
	 * 
	 * Der Comparator vergleicht zwei Elemente so:
	 * 	- mit keyExtraktor wird für das 1. Element ein Comparable-Key berechnet
	 * 	- mit keyExtraktor wird für das 2. Element ein Comparable-Key berechnet
	 *  - Das Ergebnis aus compare ist der key1.compareTo(key2)
	 * 
	 */
	static void test_comparing() {
		System.out.println("\n*** comparing");
		
//		Comparator<Person> c1 = (personA, personB) -> {
//			Comparable keyA = personA.getNachname();
//			Comparable keyB = personB.getNachname();
//			return keyA.compareTo(keyB);
//		};
		
		Function<Person, String> keyExtractor = p -> p.getNachname();
		
//		Comparator<Person> c2 = (personA, personB) -> {
//			Comparable keyA = keyExtractor.apply(personA);
//			Comparable keyB = keyExtractor.apply(personB);
//			return keyA.compareTo(keyB);
//		};
		
		Comparator<Person> c3 = Comparator.comparing(keyExtractor);
		
		Person p1 = new Person("Max", "Mustermann", 1990);
		Person p2 = new Person("Ute", "Auerbach", 1995);
		
		int result = c3.compare(p1, p2);
		System.out.println("compare(p1, p2): " + result); // positiv
		
		result = c3.compare(p2, p1);
		System.out.println("compare(p2, p1): " + result); // negativ
		
		/*
		 * Test
		 * 
		 * Function<Person, String> extr = (Person p) -> {
		 * 		return p.getNachname();
		 * }
		 */
		Comparator<Person> test = Comparator.comparing(Person::getNachname); // ClassName::instanceMethodName
																			// Instance Method Reference of an Arbitrary Object of a Particular Type
		result = test.compare(p2, p1);
		System.out.println("test.compare(p2, p1) : " + result); // negativ
		
	}
	
	/*
	 * static Comparator naturalOrder() 
	 * static Comparator reverseOrder()
	 */
	static void test_naturalOrder_reverseOrder() {
		System.out.println("\n*** naturalOrder, reverseOrder");
		
		Comparator<Integer> cmpNatural = Comparator.naturalOrder();
		Comparator<Integer> cmpReverse = Comparator.reverseOrder();
		
//		Comparator<Person> cmp = Comparator.naturalOrder(); // cf: Person ist nicht Comparable

		Integer x = 12;
		Integer y = 1200;
		
		BiFunction<Integer, Integer, Integer> bi = Integer::compare; //  Static Method Reference
		
		System.out.println("natural: " + cmpNatural.compare(x, y)); // negativ
		System.out.println("reverse: " + cmpReverse.compare(x, y)); // positiv
	}
	
	/*
	 * die einzige abstrakte Methode 
	 * 
	 * 		'int compare(T x, T y)'
	 */
	static void test_compare() {
		System.out.println("*** compare");
		
		Comparator<String> cmp = new Comparator<String> () {
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
//				return s1.length() - s2.length();
			}
		};
		
		BiFunction<String,String,Integer> bi = String::compareTo;	// Instance Method Reference of a Particular Object.
		
		String x = "bbbb";
		String y = "mm";
		
		int result = cmp.compare(x, y);
		if (result < 0) {
			System.out.println("'" + x + "' ist kleiner als '" + y + "'");
		} else if (result > 0) {
			System.out.println("'" + x + "' ist größer als '" + y + "'");
		} else {
			System.out.println("'" + x + "' ist gleich '" + y + "'");
		}
	}

}
