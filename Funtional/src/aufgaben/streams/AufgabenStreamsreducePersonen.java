package aufgaben.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

class Person {
    private String vorname;
    private String nachname;


    public Person(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String toString() {
        return vorname + " " + nachname;
    }

}

public class AufgabenStreamsreducePersonen {

	public static void main(String[] args) {

		/*
		 * Verwenden Sie bitte alle überladenen Varianten der Stream-Methode `reduce` 
		 * um jedes Mal eine Person zu erhalten, die die (lexikographisch) 
		 * größten Vornamen und Nachnamen aus allen Personen erhält (hier: Tom Poe).
		 */
		 List<Person> list =  Arrays.asList(  new Person("Tom", "Katze"),
								              new Person("Jerry", "Maus"),
								              new Person("Alexander", "Poe") 
								          );
		 
		
		 // Variante 1: reduce(BinaryOperator)
		 
		 // Akkumulator mit Tom Katze und Jerry Maus    liefert 'Tom Maus'
		 // Akkumulator mit Tom Maus  und Alexander Poe liefert 'Tom Poe'
		
		 BinaryOperator<Person> accumulator = (Person p1, Person p2) -> {	 	
			String maxVorname =   p1.getVorname().compareTo(p2.getVorname()) < 0 ? p2.getVorname() : p1.getVorname();
			String maxNachname =  p1.getNachname().compareTo(p2.getNachname()) < 0 ? p2.getNachname() : p1.getNachname();
			Person person = new Person(maxVorname , maxNachname );
			System.out.println("acc = " + p1 + " : " + p2  + " liefert " + person);
			return person;
		 };
		 

		Optional<Person> optPerson1 = list.stream().reduce(accumulator);
		
		if(optPerson1.isPresent()) {
			Person name = optPerson1.get();
			System.out.println("Person : " + name);   // Tom Poe
			
		}else {
			System.out.println("Keine name vorhanden");
		}
			
		 System.out.println();
		 
		// Variante 2: reduce(Identity, BinaryOperator) 
		 
		 // Person identity = new Person("", "")
		 // Akkumulator mit ""  ""     und Tom Katze     liefert 'Tom Katze'
		 // Akkumulator mit Tom Katze  und Jerry Maus    liefert 'Tom Maus'
		 // Akkumulator mit Tom Maus   und Alexander Poe liefert 'Tom Poe'
		
		Person identity = new Person("", "");
		
		Person optPerson2 = list.stream().reduce(new Person("", ""),  accumulator);
		
		System.out.println("Person : " + optPerson2);   // Tom Poe
		
		 // Person identity = new Person("Winnie", "Poo")
		 // Akkumulator mit Winnie Poo  und Tom Katze      liefert 'Winnie Poo'
		 // Akkumulator mit Winnie Poo  und Jerry Maus     liefert 'Winnie Poo'
		 // Akkumulator mit Winnie Poo  und Alexander Poe  liefert 'Winnie Poo'
		
		identity = new Person("", "");
		
		optPerson2 = list.stream().reduce(new Person("Winnie", "Poo"),  accumulator);
		
		System.out.println("Person : " + optPerson2);   // Winnie Poo
		
		
		
		System.out.println();
		// Variante 3: reduce(Identity, BiFunction Accumulator, BinaryOperator  Combiner)

		 // Akkumulator mit ""  ""     und Tom Katze     	liefert 'Tom Katze'
		 // Akkumulator mit Tom Katze  und Jerry Maus    	liefert 'Tom Maus'
		 // Akkumulator mit Tom Maus   und Alexander Poe 	liefert 'Tom Poe'
		 // Combiner	mit Jerry Maus  und Alexander Poe   liefert 'Jerry Maus'
		 // Combiner 	mit Tom Katze   und Jerry Poe	    liefert 'Tom Poe'
		
		 BinaryOperator<Person> combiner = (Person p1, Person p2) -> {	 	
			String maxVorname =   p1.getVorname().compareTo(p2.getVorname()) < 0 ? p2.getVorname() : p1.getVorname();
			String maxNachname =  p1.getNachname().compareTo(p2.getNachname()) < 0 ? p2.getNachname() : p1.getNachname();
			Person person = new Person(maxVorname , maxNachname );
			System.out.println("acc = " + p1 + " : " + p2  + " liefert " + person);
			return person;
		 };

		Person optPerson3 = list.stream()
								.sequential()
								.parallel()
								.reduce(identity,  accumulator ,  combiner );
		
		System.out.println("Person : " + optPerson3);   // Tom Poe
		
		
		System.out.println();
		
		
		 // Akkumulator mit Tom Katze       und Max Mustermann  liefert 'Max Mustermann'
		 // Akkumulator mit Max Mustermann  und Jerry Maus     	liefert 'Max Mustermann'
		 // Akkumulator mit Max Mustermann  und Alexander Poe 	liefert 'Max Mustermann'
		 // Combiner 	mit Jerry Maus 		und Alexander Poe 	liefert  Max Mustermann
		 // Combiner 	mit Tom Katze 		und Max Mustermann 	liefert  Max Mustermann
		combiner = (Person p1, Person p2) -> {	 	
			String maxVorname =   p1.getVorname().compareTo(p2.getVorname()) < 0 ? p2.getVorname() : p1.getVorname();
			String maxNachname =  p1.getNachname().compareTo(p2.getNachname()) < 0 ? p2.getNachname() : p1.getNachname();
			Person person = new Person("Max" , "Mustermann" );
			System.out.println("comb : " + p1 + " : " + p2  + " liefert " + person);
			return person;
		 };
	
		 
		
		 optPerson3 = list.stream()
						.sequential()
						.parallel()
						.reduce(identity,  accumulator ,  combiner );
		
		 System.out.println("Person : " + optPerson3);   // Tom Poe
		
	}




}
