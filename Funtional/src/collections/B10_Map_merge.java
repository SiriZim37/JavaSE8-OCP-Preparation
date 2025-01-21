package collections;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class B10_Map_merge {

	public static void main(String[] args) {

		/*
		 *  merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction):
			ใช้ในการรวมค่า:
				เมธอดนี้จะใช้เมื่อต้องการรวมค่าที่มีอยู่แล้วกับค่าที่จะเพิ่ม
				ถ้าคีย์มีอยู่แล้วในแผนที่, ฟังก์ชัน remappingFunction จะถูกใช้ในการคำนวณค่าที่ใหม่
				ถ้าคีย์ไม่มีอยู่, ค่าที่จะเพิ่มจะถูกใช้เป็นค่าของคีย์นั้น
				ถ้าฟังก์ชันคืนค่าเป็น null, คีย์นั้นจะถูกลบออกจากแผนที่
		 */
		
			Map<Integer , String> map = MyMapUtils.mapWoche();
			
			//{1=mo, 2=di, 3=mi, 4=do, 5=fr}

			System.out.println("1. map: " + map);
		

			/*
			 * default V merge(K key, V value,
	            BiFunction<? super V, ? super V, ? extends V> remappingFunction)
	            
	            vereinfacht:
	            
	           default V merge(K key, V value,
	            BiFunction<V, V, V> remappingFunction)
	            
			 */

			/*
			 หลักการทำงาน:
				หากคีย์ไม่มีอยู่ในแผนที่ ค่าที่ระบุ (value) จะถูกเพิ่มเข้าไปในแผนที่โดยตรง
				หากคีย์มีอยู่แล้วในแผนที่ ฟังก์ชัน remappingFunction จะถูกเรียกใช้ โดยฟังก์ชันนี้จะรวมค่าเดิมและค่าใหม่เข้าด้วยกัน และผลลัพธ์จะถูกเก็บไว้ในแผนที่
				หาก remappingFunction คืนค่า null, คีย์จะถูกลบออกจากแผนที่
				
				merge() ใช้เพื่อรวมค่าหรืออัปเดตค่าที่สัมพันธ์กับคีย์ในแผนที่ โดยให้คุณสามารถควบคุมการรวมค่าด้วยฟังก์ชัน remappingFunction.
			 */
			
			// Test
			// หากคีย์ "a" มีอยู่แล้ว ให้นำค่ามารวมกัน
//			map.merge(2, "enstag", (oldValue, newValue) -> oldValue + newValue);

			// หากคีย์ "c" ไม่มีอยู่ ให้เพิ่มค่าใหม่เข้าไป
//			map.merge(333, "tag", (oldValue, newValue) -> oldValue + newValue);

			// {1=mo, 2=dienstag, 3=mi, 4=do, 5=fr, 333=tag}
//			System.out.println(map);  
			
			
			BiFunction<String, String , String> reMappingFunction2 = (String oldValue, String passedValue)-> {
		
				return oldValue.toUpperCase() +  passedValue;			
				
			};
			Integer key = 6 ; 
			map.merge(key, "sa", reMappingFunction2);
			
			//{1=mo, 2=di, 3=mi, 4=do, 5=fr, 6=sa}
			System.out.println("2. map: " + map);
			
			
			/*
			 * Test 2. Den Schlüßel gibt es bereits.
			 *
			 * merge aktiviert die remappingFunction und übergibt
			 * an die apply den alten Wert und den übergebenen Wert.
			 * 
			 * merge ersetzt den alten Wert durch den Wert, 
			 * den die remappingFunction berechnet.
			 */
			
			key = 2;
			map.merge(key, "!!!", reMappingFunction2);
			
			// {1=mo, 2=DI!!!, 3=mi, 4=do, 5=fr, 6=sa}
			System.out.println("3. map: " + map);
			
			
	}

}
