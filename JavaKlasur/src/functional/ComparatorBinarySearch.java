package functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorBinarySearch {

	public static void main(String[] args) {

		List list = new ArrayList();
		
		list.add("aa");
		list.add("zz");
		list.add("ii");
		list.add("gg");
		list.add("mm");
	
	
		System.out.println("1. Nicht sortiert : " + list); 	// [aa, zz, ii, gg, mm]
		
		/*
		 * natürlich aufsteigend sortieren
		 * 	0	1	2	3	4
		 * [aa, zz, ii, gg, mm]
		 * 
		 */
		Collections.sort(list);
		System.out.println("2. natürlich aufsteigend sortieren  : " + list); 
		
		/*
		 * suchen
		 */	
		String key = "ii";
		int index = Collections.binarySearch(list, key); 
		System.out.printf("3.1. Gesucht : %s , index : %d\n" , key , index);   // 2 
		
		key = "xx";
		index = Collections.binarySearch(list, key); 
		System.out.printf("3.2. Falsch Gesucht : %s , index : %d\n" , key , index); 	// -5
		
		
		
		/*
		 *  absteigend sortieren
		 *  
		 *  0	1	2	3	4
		 *  [zz, mm, ii, gg, aa]
		 */ 
		Comparator cmp = Collections.reverseOrder();
		Collections.sort(list , cmp);
		System.out.println("4. absteigend sortieren " + list);
		
		/*
		 * suchen
		 */
		key = "mm";
		index = Collections.binarySearch(list, key ,cmp ); 
		System.out.printf("4.1. Gesucht : %s , index : %d\n" , key , index); // 1 
		
		/*
		 * false suchen
		 */
		key = "mm";
		index = Collections.binarySearch(list, key); 
		System.out.printf("4.2. Falsch Gesucht : %s , index : %d\n" , key , index); // -6
		
		

	}

}
