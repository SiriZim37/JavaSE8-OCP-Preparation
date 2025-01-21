package streams.wdh;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B24_Collectors_paritioningBy {

	/*
	 * Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate) 
	 * 
	 * 
	 * Collector<T, ?, Map<Boolean, D>> partitioningBy(Predicate<? super T> predicate,
	 *   												 Collector<? super T, A, D> downstream) 
	 */
	
	public static void main(String[] args) {


		List<Integer> datenQuelle = Arrays.asList(1,2,3,4,5,6,7);
		Predicate<Integer> predicate = (Integer n) -> n % 2 == 0;
		
		
		/*
		 * Collector<T, ?, Map<Boolean, List<T>>> partitioningBy(Predicate<? super T> predicate) 
		 */

		Collector<Integer, ?, Map<Boolean, List<Integer>>> c1 = Collectors.partitioningBy(predicate);
		
		Map<Boolean, List<Integer>> partsMap1 = datenQuelle.stream().collect(c1);
		List<Integer>  listGerade  =partsMap1.get(true);
		List<Integer>  listUngerade  =partsMap1.get(false);
		
		System.out.println("partsMap1 : " + partsMap1);
		System.out.println("gerade : " + listGerade);
		System.out.println("ungerade : " + listUngerade);
		
		
		System.out.println("\n---------------------------------------------------------------");

		/*
		 *   Collector<T, ?, Map<Boolean, D>> partitioningBy(Predicate<? super T> predicate,
		 *   												 Collector<? super T, A, D> downstream) 
		 */
		
		Collector<Integer, ?, Set<Integer>> downstream = Collectors.toSet();
		
		Collector<Integer, ?, Map<Boolean, Set<Integer>>> c2 = Collectors.partitioningBy(predicate , downstream);
		
		Map<Boolean, Set<Integer>> partsMap2 = datenQuelle.stream().collect(c2);
		
		Set<Integer> setGerade  =  partsMap2.get(true);
		Set<Integer> setUngerade  = partsMap2.get(false);
		
		System.out.println("partsMap2 : " + partsMap2);
		System.out.println("gerade : " + setGerade);
		System.out.println("ungerade : " + setUngerade);

	}

}
