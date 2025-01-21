package aufgaben.map.a1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMapSimple {
/*
	 -	V put(K key, V value)
	-	V get(Object key)
	-	V remove(Object key)
	- 	boolean isEmpty()
	-	Set<K> keySet()   		 			
	-	Collection<V>  values()  				
	-	Set<Map.Entry<K, V>> entrySet()  
 */
	public static void main(String[] args) {
	
		LocalDate heute = LocalDate.now();
		  
		Map<String, LocalDate> map = new HashMap<String, LocalDate>();
		map.put("heute", heute);
		map.put("gestern", heute.minusDays(1));
		map.put("morgen", heute.plusDays(1));		
	
		System.out.println("map : " + map);
		
		// Set<K> keySet()
		System.out.println("\n*** Set<K> keySet()");
		Set<String> allKeys = map.keySet();
		for (String key : allKeys) {
			LocalDate date = map.get(key);
			System.out.println(key + " = " + date);
		}
		
		//  Set<Map.Entry<K, V>> entrySet();
		System.out.println("\n*** Set<Map.Entry<K, V>> entrySet()");
		Set<Map.Entry<String, LocalDate>> allEntries = map.entrySet();
		for (Map.Entry<String, LocalDate> entry : allEntries) {
			String key = entry.getKey();
			LocalDate value = entry.getValue();
			System.out.println(key + "=" + value);
		}
	}

}
