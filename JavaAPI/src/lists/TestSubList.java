package lists;

import java.util.ArrayList;
import java.util.List;

public class TestSubList {

	public static void main(String[] args) {
		/*
		 * subList-Methode ist kompliziert, 
		 * aber in der Prüfung gibt es damit keine 
		 * komplizierten Fragen.  
		 */


		List<Integer> list = new ArrayList<Integer>();
		for (int i = 100; i < 110; i++) {
			list.add(i);
		}
		
		/*
		 * list = [100, 101, 102, 103, 104, 105, 106, 107, 108, 109]
		 */
		System.out.println("1. list: " + list);
	
		List<Integer> subList = list.subList(2, 7);
		
		/*
		 * subList = [102, 103, 104, 105, 106]
		 */
		System.out.println("1. subList: " + subList);
		
		/*
		 * Nicht in der Prüfung:
		 * 
		 * Die erzeugte Sub-Liste ist 'backed' mit der Basisliste:
		 * Die Sub-List speichert keine Elemente, 
		 * sie bleiben in der Basisliste.
		 */
		Integer x = subList.get(0);
		System.out.println("x = " + x); // 102
		
		subList.set(0, 222); // ändert auch die Basisliste!
		
		System.out.println("2. list: " + list); // [100, 101, 222, 103, ...
		System.out.println("2. subList: " + subList); // [222, 103, 104, 105, 106]
		
		list.set(3, 333); // ändert auch die Subliste
		
		System.out.println("3. list: " + list); //  [100, 101, 222, 333, 104, 105, 106, 107, 108, 109]
		System.out.println("3. subList: " + subList); // [222, 333, 104, 105, 106]

		
		subList.add(5, -555); 	 // ok 	// Größe der SubList ändern
		System.out.println(subList); 
		System.out.println("4. list: " + list);
		System.out.println("4. subList: " + subList);  
		subList.remove(5); 	 // ok 
		System.out.println("5. list: " + list);
		System.out.println("5. subList: " + subList);  	
		/*
		 * Die Listen sind gekoppelt. Aufpassen!
		 */
		list.add(11, -17); // Größe der Basisliste ändern
		System.out.println(subList); // Exception: die Subliste ist jetzt unbrauchbar
		
	}

}
