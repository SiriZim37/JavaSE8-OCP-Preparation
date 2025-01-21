package collections;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class B09_Map_compute {

	public static void main(String[] args) {

		/*
		 *  compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction):
			ใช้คำนวณค่าใหม่หรือเพิ่มคีย์ใหม่:
				เมธอดนี้จะคำนวณค่าใหม่สำหรับคีย์ที่กำหนด, ทั้งคีย์ที่มีอยู่แล้วในแผนที่หรือไม่
				ถ้าคีย์ไม่มีอยู่ในแผนที่, ฟังก์ชันจะคำนวณและเพิ่มคีย์ใหม่เข้าไป
				ถ้าฟังก์ชันคืนค่าเป็น null, คีย์นั้นจะถูกลบออกจากแผนที่
		 */
			Map<Integer , String> map = MyMapUtils.mapWoche();
			
			//{1=mo, 2=di, 3=mi, 4=do, 5=fr}

			System.out.println("1. map: " + map);
			
			/*
			 * default V compute(K key)
			 * 		BiFuntion<? super K ,? super V  ? extends V> remappingFunction)
			 * 
			 * vereinfacht :
			 * 
			 * default V computet(K key, 
			 * 			BiFuntion<K, V, V> remappingFuntion)
			 */
			/*
			 * สรุป:
				compute() ใช้ในการคำนวณและอัพเดตค่าของคีย์ในแผนที่
				ถ้าคีย์ไม่อยู่ในแผนที่, ค่าจะถูกเพิ่มเข้าไป
				ถ้าคีย์อยู่แล้ว, ค่าจะถูกแทนที่ด้วยค่าที่คำนวณใหม่จากฟังก์ชัน
				ถ้าฟังก์ชันคืนค่าเป็น null, คีย์จะถูกลบออกจากแผนที่.
			 */
	
			BiFunction<Integer, String , String> reMappingFunction = new BiFunction<Integer, String , String>() {
				
				@Override
				public String apply(Integer k, String oldValue) {

					if(oldValue==null) {
						return "new Value for ( "+ k + ")";    			// หากไม่มีค่าปัจจุบันให้ตั้งเป็น "new"
					}
					return oldValue.toUpperCase() +  "!!!";				// หากมีค่าแล้วให้เปลี่ยนเป็นตัวพิมพ์ใหญ่
				}
			};
			
			BiFunction<Integer, String , String> reMappingFunction2 = (Integer k, String oldV)-> {
			
				if(oldV==null) {
					return "new Value for ( "+ k + ")";    			// หากไม่มีค่าปัจจุบันให้ตั้งเป็น "new"
				}
				return oldV.toUpperCase() +  "!!!";				// หากมีค่าแล้วให้เปลี่ยนเป็นตัวพิมพ์ใหญ่
				
			};
			
			/*
			 * Test 1. Den Schlüßel gibt es nicht
			 */

			/*
			 * ทดสอบด้วยคีย์ 333 ซึ่งไม่มีอยู่ในแผนที่ เมื่อใช้ computeIfPresent แผนที่จะไม่ถูกแก้ไข เนื่องจากคีย์นี้ไม่อยู่ในแผนที่
			 */

			Integer key = 1;
			map.compute(key, reMappingFunction); 			 // คีย์ 1 มีอยู่แล้ว ค่าเปลี่ยนเป็น "MO"
			
			
			// {1=MO!!!, 2=di, 3=mi, 4=do, 5=fr}
			System.out.println("2. map: " + map); 
			
			key = 333;
			map.compute(key, reMappingFunction);  			// คีย์ 3 ไม่มีอยู่ ให้เพิ่มค่าใหม่เป็น "new"


			/*
			 * Test 2. Den Schlüßel gibt es bereits
			 */
			key = 2;
			// {1=MO!!!, 2=DI!!!, 3=mi, 4=do, 5=fr, 333=new Value for ( 333)}
			map.compute(key, reMappingFunction);  	
			System.out.println("2. map: " + map);     	// คีย์ 1 มีอยู่แล้ว ค่าเปลี่ยนเป็น "DI"
		
		

			
			
			
	}

}
