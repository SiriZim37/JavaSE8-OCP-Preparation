package aufgaben.map.a2;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestMapTextStatistics {
/*
	-	V put(K key, V value)
	-	V get(Object key)
	-	V remove(Object key)
	- 	boolean isEmpty()
	-	Set<K> keySet()   		 			
	-	Collection<V>  values()  				
	-	Set<Map.Entry<K, V>> entrySet()  
	-   V getOrDefault(Object key, V defaultValue)  
	-	boolean containsKey(Object key)
	-   boolean containsValue(Object value)
*/
	public static void main(String[] args) {
		
		TextStatistics stat = TextStatistics.of("Heute ist Montag!");

		Collection<Character> chars = stat.getUniqueChars();
		
		System.out.println(chars);
		
		Map<Character, Integer> map = stat.getCharCounts();
		System.out.println("map: " + map);
		 
		Set<Character> set = map.keySet();
		for (Character key : set) {
			Integer value = map.get(key);
			System.out.println(key + " = " + value);
		}
		

	}

}
