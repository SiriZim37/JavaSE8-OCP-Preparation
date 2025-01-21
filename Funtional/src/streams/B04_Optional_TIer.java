package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;




public class B04_Optional_TIer {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("Wilma", "Fred", "Pebbles", "Barney", "Betty", "Bambam");
		
        Optional<String> minimum = list.stream()
        							.filter(name -> name.equals("Luke"))
        							.min(Comparator.naturalOrder());
        System.out.println("minimum = " + minimum) ; 	// Optional[Bambam]
        
        System.out.println("minimum = " + minimum.orElseGet(()-> "Nicht vorhanden")) ; 
        
        if(minimum.isPresent()) {
        	String name = minimum.get();
        	System.out.println("minimum = " + name) ; 
        }
        
        
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
		
		Optional<Tier> tier = Arrays.stream(array).min(Comparator.naturalOrder()); // CF, falls Tier nicht vergleichbar (Comparable)
		System.out.println("tier = " + tier);
	}

}


class Tier implements Comparable<Tier>{
	private String name;

	public Tier(String name) {
		this.name = name;
	}
	public String toString() {
		return "Tier " + name;
	}
	public boolean equals(Object o) {
		Tier t = (Tier) o;
		return this.name.equals(t.name);
	}
	public int hashCode() {
		return name.hashCode();
	}
	@Override
	public int compareTo(Tier t) {
		return this.name.compareTo(t.name);
	}
}
