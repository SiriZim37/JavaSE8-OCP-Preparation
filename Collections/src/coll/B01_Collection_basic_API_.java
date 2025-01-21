 package coll;

import java.util.ArrayList;
import java.util.Collection;

public class B01_Collection_basic_API_ {

	/*
	 * interface Collection
	 * 
	 * 	- boolean add(E e)
	 * 	- boolean remove (Object o)
	 * 	- boolean contains (Object o)
	 * 
	 * -  int size()
	 * -  boolean isEmpty()
	 * 
	 * - void clear()
	 */
	public static void main(String[] args) {
		
//		Collection<Integer> coll = null; // NullPointerException
	
		
		Collection<Integer> coll =  new ArrayList<Integer>();
		
		
		System.out.println("1. size() : " + coll.size());
		System.out.println("1. isEmpty() : " + coll.isEmpty());
		
		
		/*
		 * boolean add(E e)
		 */
		coll.add(12);		// Integer <- IS-A <- Integer
//		coll.add(12.0);		// Integer  <- IS-KEIN <- Double
//		coll.add(12.5f);	// Integer   <- IS-Kein <- float
//		coll.add(12L);      // Integer   <- IS-Kein <- long
		coll.add(14);
		coll.add(13);
		
		System.out.println("2. size() : " + coll.size());
		System.out.println("2. isEmpty() : " + coll.isEmpty());
		
		
		/*
		 * boolean remove(Object e)
		 */
		coll.remove(12);	
		coll.remove(12.0);			// sinnlos , kompiliert aber
		coll.remove(12.5f);		// sinnlos , kompiliert aber
		coll.remove(12L);		// sinnlos , kompiliert aber
		
		System.out.println("3. size() : " + coll.size());
		System.out.println("3. isEmpty() : " + coll.isEmpty());
		
		/*
		 * boolean contains(Object e)
		 */
		boolean result = coll.contains(12);	
		System.out.println("4. coll.contains(12) : " + result);		// false
		coll.contains(12.0);		
		coll.contains(12.5f);		
		result = coll.contains(12L);
		System.out.println("4. coll.contains(12L) : " + result);	// definitive false
		result = coll.contains(13);	
		System.out.println("4. coll.contains(13) : " + result);		// true
		
		
		/*
		 * toString()
		 */
		System.out.println("5. coll : " + coll);		//  [14, 13]
		
		/*
		 * void clear()
		 */
		coll.clear();
		System.out.println("6. size() : " + coll.size());			// 0
		System.out.println("6. isEmpty() : " + coll.isEmpty());		// true
		System.out.println("6. coll: : " + coll);		// []
		
		
		
		/*
		 * weitere Methoden
		 * 
		 * toArray (überladen) (Bsp. im Package 'list', B03)
		 * addAll(Collection)
		 * ...
		 * 
		 * 
		 * Methoden, die das funktionale Programmieren unterstützen,
		 * werden im Projekt 'Functional' im Package 'collections'
		 * vorgestellt.
		 * 
		 */

	}

}
