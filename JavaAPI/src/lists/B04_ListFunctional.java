package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class B04_ListFunctional {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(7);
		list.add(-2);
		list.add(13);
		list.add(-11);
		list.add(22);

		/*
		 * vereinfachte Beschreibung der Methode aus Iterable:
		 * 
		 * 		void forEach(Consumer<E> action)
		 * 
		 */
		
		/*
		 * interface Consumer <E> {
		 * 		void accept(E param);
		 * }
		 */
		System.out.println("*** test forEach");
		Consumer<Integer> c = x -> System.out.println(x);
		list.forEach(c);
		
		
		/*
		 * vereinfachte Beschreibung der Methode aus Collection:
		 * 
		 * boolean removeIf(Predicate<E> filter) 
		 */
		
		System.out.println("\n*** test removeIf");
		
		Predicate<Integer> filter = x -> false;
		list.removeIf(filter);
		
		System.out.println("1. list: " + list); // [7, -2, 13, -11, 22]
		
		filter = x -> x < 0;
		list.removeIf(filter);
		
		System.out.println("2. list: " + list); // [7, 13, 22]
		
		
		
		//-----------------------
		List<String> strList = new ArrayList<>();
        strList.add("Apfel");
        strList.add("Banane");
        strList.add("Kirsche");
    	System.out.println("1. strList: " + strList); // [Apfel, Banane, Kirsche]
		Predicate<String> filter2 = s -> s.startsWith("K");
		strList.removeIf(s -> s.startsWith("K"));
		
		System.out.println("2. strList: " + strList); // [Apfel, Banane]

	}

}
