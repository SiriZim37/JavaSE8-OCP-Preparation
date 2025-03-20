package functonal;

class Person {
	private String name;
	private int alter;
	private boolean gesund;
	
	public Person(String name, int alter, boolean gesund) {
		this.name = name;
		this.alter = alter;
		this.gesund = gesund;
	}

	@Override
	public String toString() {
		return name + " (" + alter + ") ist " + (gesund ? "gesund" : "krank");
	}

	public String getName() {
		return name;
	}

	public int getAlter() {
		return alter;
	}

	public boolean isGesund() {
		return gesund;
	}
	
}

interface PersonTester {
	boolean test(Person p) ;
}

public class B02_MitLambdas {

	/*
	 * Aufgabe: eine universelle Methode entwickeln,
	 * die Personen aus einem Array auswählt und ausgibt 
	 */
	public static void main(String[] args) {
		
		Person[] arr = {
			new Person("Peter", 40, true),	
			new Person("Paul", 34, false),	
			new Person("Anna", 22, true),	
			new Person("Mary", 55, false),	
			new Person("Ute", 67, true),	
		};

		
		System.out.println("*** Alle Personen");
		printSelected(arr, p -> true);
		
		System.out.println("\n*** keine Personen");
		printSelected(arr, p -> false);
		
		System.out.println("\n*** Gesunde Personen");
		printSelected(arr, p -> p.isGesund() );
		
		System.out.println("\n*** Kranke Personen");
		printSelected(arr, p -> !p.isGesund());
		
		System.out.println("\n*** Personen, die älter als 35 sind");
		printSelected(arr, p -> p.getAlter() > 35);
		
		System.out.println("\n*** Personen, die älter als 35 sind und gesund sind");
		printSelected(arr, p -> p.getAlter() > 35 && p.isGesund());
	}

	static void printSelected(Person[] arr, PersonTester tester) {
		for (int i = 0; i < arr.length; i++) {
			Person p = arr[i];
			if( tester.test(p) ) {
				System.out.println(i+1 + ". " + p);
			}
		}
	}
}
