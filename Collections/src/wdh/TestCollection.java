package wdh;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

class Blume implements Comparable<Blume>{
	private int id;

	public Blume(int id) {
//		System.out.println(hashCode());
		this.id = id;
	}
		
	public int getId() {
		return id;
	}

	public String toString() {
		return String.valueOf(id);
	}
	
	/*
	 * in der equal! wird aufrufen wenn HashCode sind gleich
	 * 
	 * zB : 	public int hashCode() {
	 *				return 7;
	 * 			}
	 * ausgabe : 	in der HashCode!
					7
					in der HashCode!
					in der HashCode!
					7
	 */
	public boolean equals(Object obj) {
//		System.out.println("in der equal!");
		return this.id == ((Blume) obj).id;
	}
	
	public int hashCode() {
//		System.out.println("in der HashCode!");
//		return 7;
		return id;		
	}

	@Override
	public int compareTo(Blume b2) {
		System.out.println("CompareTo");
		return this.id - b2.id;
	}
	
}
public class TestCollection {

	public static void main(String[] args) {

//		Collection<Blume> coll = new ArrayList<Blume>();  : ok

		/*
		 * FIFO
		 */
		
//		run(new ArrayList<>());		//	[9, 3, 9, 1]
//		run(new LinkedList<>());	//	[9, 3, 9, 1]
//		run(new Vector<>());		//	[9, 3, 9, 1]
//		run(new ArrayDeque<>());	//	[9, 3, 9, 1]
//		run(new HashSet<>());		//	[1, 3, 9] in einer unbestimmten Reihenfolge
//		run(new LinkedHashSet<>()); //  [9, 3, 1]
		
		
		// Bevor equal ereugen 
//		boolean x = new Blume(2).equals(new Blume(2));  // return this == obj 
//		System.out.println( x ) ;	// false


		/* 
		 * Ohne implements Comparable<Blume>
		 * 
		 * run(new TreeSet<>());
		 * run(new PriorityQueue<>()); 
		 * 
		 * TreeSet  : Exc : ClassCastException 
		 * 			 (Blume cannot be cast to class java.lang.Comparable)
		 * 
		 *			(TreeSet : Sortiert Elemente automatisch)
		 *
		 * PriorityQueue  : Exc : ClassCastException 
		 */
		
		run(new TreeSet<>());			//	[1, 3, 9]
		run(new PriorityQueue<>()); 	//  [1, 3, 9, 9]
		
		
		System.out.println();
		
//		Comparator<Blume> cmp = (b1 , b2) -> b1.getId() - b2.getId();
		Comparator<Blume> cmp =	Comparator.comparing(Blume::getId);
		run(new TreeSet<>(cmp));			// [1, 3, 9]
		run(new PriorityQueue<>(cmp));		// [1, 3, 9, 9]
		
		

	}

	static void run(Collection<Blume> coll) {
		try {
			coll.add(new Blume(9));
			coll.add(new Blume(3));
			coll.add(new Blume(9));
			coll.add(new Blume(1));
			
			System.out.println(coll);
		} catch (Exception e) {
			System.out.println("Exc" + e );
		}
		
	}
}
