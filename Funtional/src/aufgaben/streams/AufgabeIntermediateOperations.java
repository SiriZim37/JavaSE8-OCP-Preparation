package aufgaben.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

class Tier {
	private String name;

	public Tier(String name) {
		this.name = name;
	}
	public String toString() {
		return "Tier " + name;
	}
	
	
    public String getName() {
		return name;
	}
	public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tier tier = (Tier) obj;
        return name.equals(tier.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
	
}

public class AufgabeIntermediateOperations {

	public static void main(String[] args) {
		a1();
		a2();
		a3();
		a4();
		a5();
		a6();

	}

	static void a1() {
		System.out.println("*** A1. Stream");
		List<Integer> list = Arrays.asList(13, 15, 17, 19, 21);
		
		// A
		for(Integer x : list) {
			if(x==15 || x==19) {
				System.out.println("Treffer: " + x);
			}
		}
		
		// B
		System.out.println("\nB1. Stream filter");
		
		// Variante 1 
		Predicate<Integer> pred = x -> ( x==15 || x==19 ) ;
		list.stream().filter(pred).forEach(e -> System.out.println("Treffer: " + e));
		
		
		split();
	}
	
	static void a2() {
		System.out.println("\n*** A2.");
		Integer[] array = { 1, 4, 7, 3, -8 };
		
		//A
		for (Integer x : array) {
			System.out.println( x%2==0 ? "gerade" : "ungerade" );
		}
		
		//B
		System.out.println("\nB2.1 Stream mit map");
		// Variante 1 
		Function<Integer, String> func =  x -> {
			return  x%2==0 ? "gerade" : "ungerade" ;
		};
		Stream.of(array).map(func).forEach(System.out::println); 
		
		// Variante 2 
		System.out.println("B2.2");
		Arrays.stream(array).forEach( i -> System.out.println( i%2 == 0 ? "gerade" : "ungerade"));
		
		// Variante 3
		System.out.println("B2.3");
		Arrays.stream(array).map(func).forEach(System.out::println); 
		
		split();
	}
	
	static void a3() {
		System.out.println("\n*** A3.");
		List<String> list = Arrays.asList("Tom", "Jerry", "Rex");
		
		//A
		for(String name : list) {
			Tier t = new Tier(name);
			System.out.println(t);
		}
		
		//B
		System.out.println("\nB3.1 Stream mit map");
		// Variante 1 
		list.stream().map(Tier::new).forEach(System.out::println); 
		
		System.out.println("B3.2");
		// Variante 2
		list.stream().map( name -> new Tier(name)).forEach(System.out::println);
		
		split();
	}
	
	static void a4() {

		System.out.println("\nA4.  Stream mit Zufallszahlen");
			
		Random rnd = new Random();
		// IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound(exklusive)) 
			
		System.out.println("B4.1");
		// Variante 1
		// generate supplier
		Stream.generate(()-> rnd.nextInt(41)-20)
				.filter(n -> n < -15 || n > -10)
				.limit(30)
				//.map(i -> Double.valueOf(i))
				.map(Double::valueOf)
				.forEach(System.out::println); 
		
		System.out.println("B4.2");
		// Variante 2
		new Random().ints(30, -20, 21)  		 
				   .filter(n -> n < -15 || n > -10) 		
				   .mapToDouble(n -> (double) n)  			 
				   .forEach(System.out::println); 
		
		split();
	}
	
	static void a5() {
		System.out.println("\n*** A5.");
		Tier[] array = {
				new Tier("Rex"),
				new Tier("Tom"),
				new Tier("Jerry"),
				new Tier("Tom"),
				new Tier("Jerry"),
			};
	
		for (Tier tier : array) {
			System.out.println(tier);
		}
		
		System.out.println("\nB5. Stream aus Array");
		
		Arrays.stream(array)
			  .distinct()
			  .sorted(Comparator.comparing(Tier::getName)) // Sortiert nach Namen
			  .forEach(System.out::println);
		
		split();
	}
	
	static void a6() {
		System.out.println("\n*** A6.");
		
		List<String> mailsErsthelfer = Arrays.asList("tom@mycompany.com", "jerry@mycompany.com");
		List<String> mailsIT = Arrays.asList("tom@mycompany.com", "mary@mycompany.com");
		List<String> mailsQM = Arrays.asList("peter@mycompany.com", "jerry@mycompany.com");
		
		System.out.println("\nB6. Stream aus dem List");
		
		
		Function<String, String> func = email -> email.split("@")[0];
		
	    Stream.of(mailsErsthelfer, mailsIT, mailsQM)
	            .flatMap(List::stream) 
	            .distinct()
	            .map(func) 
	            .forEach(System.out::println); 
		split();
	}

	
	static void split() {
		System.out.println("-----------------------------------------------------------");
	}
}


