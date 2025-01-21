package collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMapMethoden {

	public static void main(String[] args) {


		Integer[] zahlen = {
				1, 33, 1, 50, 7 , 1 , 33 , 4 , 33 , 1 
		};
		
		/*
		 * Map mit Anzahl der geraden und ungeraden Werten in dem Array
		 * 
		 * "gerade"		: 		2   Zahlen
		 * "ungerade"	:		8   Zahlen
		 */
		
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		
		for(Integer x : zahlen) {
			 String key =  x % 2 == 0 ? "gerade" : "ungerade";
			 Integer value = map1.get(key);
			 if(value == null) {
				 map1.put(key, 1) ;
			 }else {
				 map1.put(key, value + 1 );
			 }
		}
			
		System.out.println("1. map1 : " + map1 ); // {ungerade=8, gerade=2}
		
		/*
		 * Version 2
		 */
		// map.merge(key, value (newValue) , (oldValue, newValue) -> oldValue + newValue);
		
		Map<String, Integer> map2 = new HashMap<>();
		
		
		for(Integer x : zahlen) {
			 String key =  x % 2 == 0 ? "gerade" : "ungerade";
			 map2.merge(key, 1, (value , passValued) -> value + passValued );
		}

		System.out.println("2. map2 : " + map2 ); //  {gerade=2, ungerade=8}
	}

}
