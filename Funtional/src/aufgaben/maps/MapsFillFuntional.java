package aufgaben.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapsFillFuntional {

	public static void main(String[] args) {
		/*
		 * Wie oft kommt jeder String im Array vor?
		 */
		String[] arr = {
			"dd", "aa", "dd", "aa", "aa", "mm"	
		};
		
		Map<String, Integer> mapCounts = new HashMap<>();
		
		for(String s : arr) {
			Integer count = mapCounts.get(s);
			
			if(count==null) {
				mapCounts.put(s, 1);
			} else {
				mapCounts.put(s, count+1);
			}
		}
		
		System.out.println("mapCounts : " +  mapCounts);

		
		/*
		 * A1 `Map.computeIfAbsent` und `Map.computeIfPresent`
		 */
		
		Map<String, Integer> mapCountsA1 = new HashMap<>();
		
		Function<String, Integer> mappingFuntion = (String k) -> {
		     return 0; 
		};
		
		BiFunction<String, Integer , Integer> reMappingFuntion =  (String k , Integer oldValue)-> {
			return oldValue + 1 ;
		};
		
		for (String s : arr) {
			mapCountsA1.computeIfAbsent(s, mappingFuntion);
			mapCountsA1.computeIfPresent(s, reMappingFuntion);
		}
		System.out.println("1.  mapCountsA1  : " +  mapCountsA1);
		


		
		/*
		 * A2 `Map.compute`
		 */
		
		Map<String, Integer> mapCountsA2 = new HashMap<>();
		
		BiFunction<String, Integer , Integer> reMappingFuntion2 =  (String k , Integer oldValue)-> {
			return oldValue == null ? 1 : oldValue + 1 ;
		};
		
		for (String s : arr) {
			mapCountsA2.compute(s, reMappingFuntion2);
		}
		System.out.println("\n2.  mapCountsA2  : " +  mapCountsA2);
		
		

		/*
		 * A3 `Map.merge`
		 */
		
		Map<String, Integer> mapCountsA3 = new HashMap<>();
		
		BiFunction<Integer, Integer , Integer> reMappingFuntion3 =  (Integer newValue , Integer oldValue)-> {
			return newValue + oldValue ;
		};
		
		for (String s : arr) {
			mapCountsA3.merge(s, 1, reMappingFuntion3);	
		}
		System.out.println("\n3.  mapCountsA3  : " +  mapCountsA3);
		
		mapCountsA3 = new HashMap<>();
		
			
	}
	
	

}
