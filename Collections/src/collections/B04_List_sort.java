package collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class B04_List_sort {

	public static void main(String[] args) {

	/*
	 * 
	 */
		List<String> list = Arrays.asList("hh","u","aaaa","mmm");
		System.out.println("1. list : " + list );    					// [hh, u, aaaa, mmm]
		
		/*
		 * default void sort(Comparator<? super E ) c
		 */
		// wenn der Comparator null ist , müssen
		// die Element der List comparable sein	
	
		Comparator<String> cmp = null;
		list.sort(cmp);
		
		System.out.println("2. list (sort): " + list );					// [aaaa, hh, mmm, u]
		
		// -------------------------------------------------------------------

		
		Comparator<String> cmp2 = Comparator.reverseOrder();
		
		Collections.sort(list,cmp2);

		System.out.println("3. list (reverseOder) : " + list);			//[u, mmm, hh, aaaa]
		
		// -------------------------------------------------------------------
		
		Comparator<String> cmp3 = Comparator.comparing(String::length);
		list.sort(cmp3);
		
		System.out.println("4. list  : " + list);						//[u, hh, mmm, aaaa]
		
		// -------------------------------------------------------------------
		
		Function<String, Integer> func1 = new Function<String, Integer>() {
			public Integer apply(String t) {
				return t.length();
			};
		};
		
		Comparator<String> cmp4 = Comparator.comparing(func1);
		Collections.sort(list, cmp4);

		System.out.println("5. list (reverseOder) : " + list);			//[u, hh, mmm, aaaa]
		
		

	}

}
