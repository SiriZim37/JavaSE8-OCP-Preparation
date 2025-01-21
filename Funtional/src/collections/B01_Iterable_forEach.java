package collections;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.function.Consumer;


public class B01_Iterable_forEach {

	public static void main(String[] args) {
		
		/*
		 * interface Collection<E> extends Iterable<E>
		 */
		Collection<String> coll = new ArrayDeque<>();

		coll.add("a");
		coll.add("b");
		coll.add("c");
		
		/*
		 * Collection extends Iterable.
		 * 
		 * Iterable hat die Methode
		 * 
		 *   default void forEach(Consumer<? super T> action)
		 */
		
		Consumer<String> c1 = (String s) -> {
			System.out.println(s);
		};
		
		coll.forEach(c1);
		
		System.out.println("\n*** nochmal");
		
		coll.forEach(System.out::println);
	}

}
