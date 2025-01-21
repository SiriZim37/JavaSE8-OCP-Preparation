package collections;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class B08_Map_computerifPresent {

	public static void main(String[] args) {

		/*
	   		ifPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction):
			
			ใช้เมื่อคีย์มีอยู่ในแผนที่:
					เมธอดนี้จะทำงานถ้าคีย์ที่กำหนดมีอยู่ในแผนที่แล้ว
					ฟังก์ชัน remappingFunction จะคำนวณค่าที่จะใช้แทนค่าปัจจุบันในแผนที่
					ถ้าฟังก์ชันคืนค่าเป็น null, คีย์นั้นจะถูกลบออกจากแผนที่
		 */
		
			Map<Integer , String> map = MyMapUtils.mapWoche();
			
			//{1=mo, 2=di, 3=mi, 4=do, 5=fr}

			System.out.println("1. map: " + map);
			
			/*
			 * default V computeIfPresent(K key)
			 * 		 BiFunction<? super K, ? super V, ? extends V> remappingFunction)
			 * 
			 * vereinfacht :
			 * 
			 * default V computeIfPresent(K key, 
			 * 			BiFuntion<K,V,V> remappingFuntion)
			 */
			/*
			 *  computeIfPresent  ฟังก์ชันจะเช็คว่ามีคีย์ในแผนที่อยู่แล้วหรือไม่ ถ้ามี:
				มันจะใช้ remappingFunction ในการคำนวณค่าใหม่ โดยใช้คีย์และค่าปัจจุบันเป็นอาร์กิวเมนต์
				ค่าใหม่ที่ได้จากฟังก์ชันจะถูกนำมาอัปเดตในแผนที่
				ถ้าไม่มีคีย์อยู่ในแผนที่ มันจะไม่ทำอะไรเลย (แผนที่จะไม่ถูกเปลี่ยนแปลง)
				**** computeIfPresent จะไม่เพิ่มคีย์ใหม่ลงในแผนที่ มันทำงานเฉพาะกับคีย์ที่มีอยู่แล้วเท่านั้น
			 */
			BiFunction<Integer, String , String> reMappingFunction = new BiFunction<Integer, String , String>() {
				
				@Override
				public String apply(Integer key, String oldValue) {
					switch (key) {
					case 6:  return "sa";
					case 7:  return "so";
					}
					return oldValue + "(" + key + ")";
				}
			};
			
			/*
			 * Test 1. Den Schlüßel gibt es nicht
			 */
			Integer key = 333;
			map.computeIfPresent(key, reMappingFunction);
			/*
			 * ทดสอบด้วยคีย์ 333 ซึ่งไม่มีอยู่ในแผนที่ เมื่อใช้ computeIfPresent แผนที่จะไม่ถูกแก้ไข เนื่องจากคีย์นี้ไม่อยู่ในแผนที่
			 */
			
			// {1=mo, 2=di, 3=mi, 4=do, 5=fr}
			System.out.println("2. map: " + map);
		
			
			
			/*
			 * Test 2. Den Schlüßel gibt es bereits
			 */
		
			BiFunction<Integer, String , String> reMappingFuntion2 =  (Integer k , String oldValue)-> {
				switch (k) {
				case 1:  return "ungültig";
				case 6:  return "sa";
				case 7:  return "so";
				}
				
				return oldValue + "(" + k + ")";
			};
			
			key = 1;
			map.computeIfPresent(key, reMappingFuntion2);
			// {1=ungültig, 2=di, 3=mi, 4=do, 5=fr}
			System.out.println("3. map: " + map);
			
			
			BiFunction<Integer, String , String> reMappingFuntion3 =  (Integer k , String oldValue)-> {
				switch (k) {
				case 2 : return oldValue.toUpperCase();
				case 6:  return "sa";
				case 7:  return "so";
				}
				
				return oldValue + "(" + k + ")";
			};
			
			key = 2;
			map.computeIfPresent(key, reMappingFuntion3);
			//{1=ungültig, 2=DI, 3=mi, 4=do, 5=fr}
			System.out.println("3. map: " + map);

			
	}

}
