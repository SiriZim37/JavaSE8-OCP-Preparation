package map;

import java.util.HashMap;
import java.util.Map;

public class B01_MapBasicAPI {

	/*
	  	Methode Map:
		-	* put(K key, V value): V   เพิ่มคู่คีย์และค่าเข้าไปใน Map
		-	* get(Object key):  V  คืนค่าที่จับคู่กับคีย์ที่กำหนด
		-	* remove(Object key): V  ลบคู่คีย์-ค่าที่จับคู่กับคีย์นั้นออก
		- 	* isEmpty(); boolean
		-	* clear() : void
		-	containsKey(Object key): ตรวจสอบว่ามีคีย์อยู่ใน Map หรือไม่
		-	containsValue(Object value): ตรวจสอบว่ามีค่าอยู่ใน Map หรือไม่
		-	keySet(): คืนค่าเป็น Set ของคีย์ทั้งหมด
		-	values(): คืนค่าเป็น Collection ของค่าทั้งหมด
		-	entrySet(): คืนค่าเป็น Set ของคู่คีย์-ค่า
		
	 */
	
	public static void main(String[] args) {

//		var map = new  HashMap<Integer, String>();
//		Map<Integer, String> map = new HashMap<Integer, String>();
		Map<Integer, String> map = new HashMap<>();

		System.out.println("1. size() " + map.size());
		
		/*
		 * V put(K key, V value);
		 */
		map.put(1, "mo");
		map.put(2, "di");
		map.put(3, "mi");
		
		System.out.println("2. size() " + map.size());
		
		/*
		 * String toString()
		 * 
		 * { key1 = value1 , key2 = value2 , key3=value3}
		 */
		System.out.println("map " + map);		//{1=mo, 2=di, 3=mi}
		
	
		Integer key = 77; // key is of type Integer : autoboxing
		int primitiveValue = key.intValue(); // primitiveValue is of type int : unboxing
		Integer newInteger = Integer.valueOf(primitiveValue); // newInteger is of type Integer : autoboxing
		
		
		/*
		 *  V get(Object key);
		 */	
		String value = map.get(key);
		System.out.println("3. get(key) : key = 77  , value = " + value);	// null
		
		key = 2;
		value = map.get(key);
		System.out.println("4. get(key) : key = 2  , value = " + value);		// di
		
		/*
		 *   V put(K key, V value);
		 *   	
		 *   	put kann fürs Aktualisieren der Werte verwendet werden.
		 *   	Der alter Wert wird ersetzt und uirück geliefert.
		 */	
		key = 77;
		value = map.put(key , "Dienstag");
		System.out.println("5. put(key , value) : key = 77  , value = " + value);	// null
		
		key = 2;
		value = map.put(key , "Dienstag");
		System.out.println("6. put(key , value) : key = 2  , value = " + value);	// di ( return old value)
		System.out.println("map " + map);		// {1=mo, 2=null, 3=mi, 4=Dienstag}
	
		/*
		 *   V remove(Object key);
		 */	
		key = 333;
		value = map.remove(key);
		System.out.println("7. remove(key) : key = 333  , value = " + value);	// null
		
		key = 2;
		value = map.remove(key);
		System.out.println("9. remove(key) : key = 2  , value = " + value);	 // Dienstag
		System.out.println("map " + map);	 // {1=mo, 3=mi, 77=Dienstag}
		

		/*
		 *     boolean isEmpty();
		 */		
		boolean empty = map.isEmpty();
		System.out.println("10. isEmpty() : " + empty);	// false
		
		/*
		 *     void clear();
		 */		
		map.clear();
		System.out.println("map " + map);	 // {}
		
	}

}
