package collections;

import java.util.Map;
import java.util.function.Function;

public class B07_Map_computerifAbsent {

	public static void main(String[] args) {

		/*
		    computeIfAbsent(K key, V defaultValue):
			
			ใช้เมื่อคีย์ไม่อยู่ในแผนที่ (Map):
				เมธอดนี้จะใช้ในการตรวจสอบว่าคีย์ที่กำหนดมีอยู่ในแผนที่หรือไม่ หากไม่มีคีย์นั้นในแผนที่, ค่าที่กำหนดใน defaultValue จะถูกเพิ่มเข้าไปในแผนที่
				ถ้าคีย์มีอยู่แล้ว, ค่าจะไม่เปลี่ยนแปลง
		 */
		
			Map<Integer , String> map = MyMapUtils.mapWoche();
			
			//{1=mo, 2=di, 3=mi, 4=do, 5=fr}

			System.out.println("1. map: " + map);
			
			/*
			 * default V computeIfAbsent(K key)
			 * 		Funtion<? super K , ? extends V> mappingFuntion)
			 * 
			 * vereinfacht :
			 * 
			 * default V computeIfAbsent(K key, 
			 * 			Funtion<K,V> mappingFuntion)
			 */

			/*
				เมธอด computeIfAbsent จะคำนวณและเพิ่มค่าใหม่ในแผนที่เฉพาะในกรณีที่คีย์
				ไม่มีอยู่ เท่านั้น หากคีย์มีอยู่แล้ว ค่าเดิมจะยังคงอยู่เหมือนเดิม
				ถ้าคุณเปลี่ยน key เป็น 6 หรือ 7, แผนที่จะถูกอัปเดตให้เพิ่ม "sa" หรือ "so" ตามลำดับ
			 */
			
			Function<Integer, String> mappingFuntion = new Function<Integer, String>() {
				
				@Override
				public String apply(Integer key) {
					switch (key) {
					case 6:  return "sa";
					case 7:  return "so";
					}
					
					return "ungültig";
				}
			};
			
			/*
			 * Test 1. Den Schlüßel gibt es nicht
			 */
			Integer key = 333;
			map.computeIfAbsent(key, mappingFuntion);
			
			// {1=mo, 2=di, 3=mi, 4=do, 5=fr, 333=ungültig}
			System.out.println("1. map: " + map);
			
			/*
			 * Test 2. Den Schlüßel gibt es bereits
			 */
			
			Function<Integer, String> mappingFuntion2 = (Integer k)-> {
				switch (k) {
				case 6:  return "sa";
				case 7:  return "so";
				}
				
				return "ungültig";
			};
			
			key = 1;
			map.computeIfAbsent(key, mappingFuntion2);
			// {1=mo, 2=di, 3=mi, 4=do, 5=fr, 333=ungültig}
			System.out.println("2. map: " + map);
		
			
			
			Function<Integer, String> mappingFuntion3 = (Integer k)-> {
				switch (k) {
				case 1:  return "GG"; 
				case 6:  return "sa";
				case 7:  return "so";
				}
				
				return "ungültig";
			};
			key = 1;
			map.computeIfAbsent(key, mappingFuntion3);
			// {1=mo, 2=di, 3=mi, 4=do, 5=fr, 333=ungültig}
			System.out.println("3. map: " + map);

			
	}

}
