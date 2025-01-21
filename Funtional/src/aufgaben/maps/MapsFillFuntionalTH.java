package aufgaben.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapsFillFuntionalTH {

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
				mapCounts.put(s, 1);			 // ถ้ายังไม่เคยมีค่าใน Map ให้เพิ่มเข้าไปใหม่	
			} else {
				mapCounts.put(s, count+1);		 // ถ้ามีค่าอยู่แล้ว ให้เพิ่มค่าปัจจุบัน
			}
		}
		
		System.out.println("1.  mapCounts : " +  mapCounts);

		
		/*
		 * A1
		 * 
		 * A1. เปลี่ยนโค้ดให้ใช้ computeIfAbsent และ computeIfPresent
		 * ในส่วนนี้ คุณต้องใช้สองเมธอด computeIfAbsent และ computeIfPresent เพื่อให้ได้ผลลัพธ์เดียวกันกับโค้ดที่ใช้ get และ put:
		 * 
		 * 	-	computeIfAbsent: ถ้าค่าคีย์ยังไม่อยู่ใน Map จะใส่ค่าเริ่มต้น (ในที่นี้คือ 0) ไป
		 * 	-	computeIfPresent: ถ้าคีย์มีอยู่แล้วใน Map จะใช้ฟังก์ชันเพิ่มค่าของมัน
		 */
		
		Map<String, Integer> mapCountsA1 = new HashMap<>();
		
		Function<String, Integer> mappingFuntion = (String k) -> {
		     return 0; 
		};
		
		BiFunction<String, Integer , Integer> reMappingFuntion =  (String k , Integer oldValue)-> {
			return oldValue + 1 ;
		};
		
		for (String s : arr) {
//			System.out.println(s);
			mapCountsA1.computeIfAbsent(s, mappingFuntion);		 //  ถ้าไม่มีค่าใน Map ให้ใส่ค่าเริ่มต้นเป็น 0
			System.out.println("map : " +  mapCountsA1);
			mapCountsA1.computeIfPresent(s, reMappingFuntion);	 // ถ้ามีค่าแล้ว เพิ่มค่าใน Map
			System.out.println("remap : " +  mapCountsA1);
		}
		System.out.println("2.  mapCountsA1 : " +  mapCountsA1);
		
		/*
		 * A2
		 * A2. เปลี่ยนโค้ดให้ใช้ compute
		 * เมธอด compute ช่วยให้คุณสามารถทั้งเพิ่มค่าใหม่และอัพเดตค่าที่มีอยู่ได้ในเมธอดเดียว โดยจะใช้การประมวลผลค่าปัจจุบันและค่าใหม่ที่ต้องการเก็บ
		 */
		
		Map<String, Integer> mapCountsA2 = new HashMap<>();
		
		BiFunction<String, Integer , Integer> reMappingFuntion2 =  (String k , Integer oldValue)-> {
			return oldValue == null ? 1 : oldValue + 1 ;
		};
		
		for (String s : arr) {
			mapCountsA2.compute(s, reMappingFuntion2); 	// ถ้า oldValue เป็น null ให้ใส่ 1, ถ้าไม่ใช่เพิ่มค่า
		}
		System.out.println("3.  mapCountsA2 : " +  mapCountsA2);
		
		
		/*
		 * A3
		 * A3. เปลี่ยนโค้ดให้ใช้ merge
		 * เมธอด merge ใช้เพื่อรวมค่าของคีย์ใน Map โดยจะเพิ่มค่าที่มีอยู่แล้ว หรือถ้าไม่มีค่าอยู่ จะเพิ่มค่าใหม่ไป
		 */
		
		Map<String, Integer> mapCountsA3 = new HashMap<>();
		
		BiFunction<Integer, Integer , Integer> reMappingFuntion3 =  (Integer oldValue, Integer newValue) -> {
		    return oldValue + newValue;
		};
		
		for (String s : arr) {
			mapCountsA3.merge(s, 1, reMappingFuntion3);	// เพิ่มค่า 1 ทุกครั้งที่เจอคีย์
		}
		System.out.println("3.  mapCounts : " +  mapCountsA3);
		
		
	}
	
	

}
