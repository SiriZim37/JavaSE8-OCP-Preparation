package collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;

public class B02_Collection_removeif_stream {

	/*
	 * Die Methoden 'stream' und 'parallelStream'
	 * werden beim Thema 'funktionale Streams' besprochen.
	 */
	public static void main(String[] args) {
		Collection<Integer> coll = new ArrayDeque<>();

		coll.add(1);
		coll.add(22);
		coll.add(7);
		coll.add(4);
		coll.add(19);
		/*
		 * default boolean removeIf(Predicate<? super E> filter)
		 * 
		 * Jedes Element der Collection wird mit dem Predicate gestetet.
		 * Die Elemente, für die die Methode test zurück liefert , werden entfernt.
		 */
		
		Predicate<Integer> p1 = (Integer x)->{
			return x % 2 == 0 ; 
		};
		
		System.out.println("2. coll : " + p1.test(5));
		
//		 kleineFrage(); // Exception
		 kleineFrage2(); 
		 
	}
	
	
	static void kleineFrage() {
		/*
		 * Achtung ! asList liefert eine Liste mit der fixierten Größe
		 */
		Collection<String> coll = Arrays.asList("mo" , null , "di","null");
		try {
			coll.removeIf(s->s==null); // Exception : Arrays.asList Größe kann nicht reduzieren! 
		} catch (Exception e) {
			System.out.println("UnsupportedOperationException" + e );
		}
		System.out.println("3. size : " + coll.size()); 
	}
	
	static void kleineFrage2() {
		Collection<String> coll = Arrays.asList("mo" , null , "di","null");
		coll = new ArrayList<String>(coll);
		coll.removeIf(s->s==null); 
		System.out.println("3. size : " + coll.size()); 
		
	}

}
