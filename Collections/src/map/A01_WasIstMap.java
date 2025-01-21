package map;

import java.util.HashMap;
import java.util.Map;

public class A01_WasIstMap {
	
	/*
	 * 
	  Map เป็นส่วนหนึ่งของ Java Collections Framework ซึ่งแสดงถึงการเก็บข้อมูลในรูปแบบคู่คีย์-ค่า (key-value pairs) 
	  Map ไม่ใช่ซับไทป์ของ Collection 
	  
	คุณสมบัติหลักของ Map
		การเชื่อมโยงคีย์และค่า: แต่ละองค์ประกอบ (หรือ "เอนทรี") ใน Map ประกอบด้วยคีย์และค่าที่เกี่ยวข้อง คีย์แต่ละตัวใน Map
		จะต้องไม่ซ้ำกัน แต่หลายคีย์สามารถมีค่าที่เหมือนกันได้
	
	การนำไปใช้: การนำไปใช้ที่พบบ่อย ได้แก่ HashMap, LinkedHashMap, และ TreeMap ซึ่งแต่ละการนำไปใช้มีลักษณะการทำงานที่แตกต่างกัน:
		-	HashMap ให้ประสิทธิภาพการทำงานที่คงที่สำหรับการดำเนินการพื้นฐานเช่น get และ put
		-	LinkedHashMap รักษาลำดับการแทรกของเอนทรี
		-	TreeMap จะจัดเรียงคีย์ตามลำดับตามธรรมชาติของมันหรือจากตัวเปรียบเทียบที่กำหนด
		
	               Map<K, V> (Interface)
	                  |
	    -----------------------------------
	   |                                   |
	SortedMap<K, V> (Interface)        HashMap<K, V> (Klasse)
	   |                                   | 
	NavigableMap<K, V> (Interface)    LinkedHashMap<K, V> (Klasse)
	   |
	TreeMap<K, V> (Klasse)


	Methode Map:
		-	V put(K key, V value): เพิ่มคู่คีย์และค่าเข้าไปใน Map
		-	V get(Object key): คืนค่าที่จับคู่กับคีย์ที่กำหนด
		-	V remove(Object key): ลบคู่คีย์-ค่าที่จับคู่กับคีย์นั้นออก
		-	boolean containsKey(Object key): boolean ตรวจสอบว่ามีคีย์อยู่ใน Map หรือไม่
		-	boolean containsValue(Object value): boolean ตรวจสอบว่ามีค่าอยู่ใน Map หรือไม่
		-	keySet(): คืนค่าเป็น Set ของคีย์ทั้งหมด
		-	values(): คืนค่าเป็น Collection ของค่าทั้งหมด
		-	entrySet(): คืนค่าเป็น Set ของคู่คีย์-ค่า
		-   default V putIfAbsent(K key, V value) 

	 */
	public static void main(String[] args) {
		  	Map<String, Integer> map = new HashMap<>();

	        // Adding entries
	        map.put("A", 1);
	        map.put("B", 2);
	        
	        // Accessing values
	        System.out.println("Value for key 'A': " + map.get("A"));

	        // Check if key exists
	        System.out.println("Contains key 'B': " + map.containsKey("B"));

	        // Modify an entry
	        map.putIfAbsent("B", 3); // Won't change since "B" already exists

	        // Print all entries
	        map.forEach((key, value) -> System.out.println(key + ": " + value));

	        // Remove an entry
	        map.remove("A");
	        
	        // Print all entries after removal
	        System.out.println("After removal:");
	        map.forEach((key, value) -> System.out.println(key + ": " + value));

	}

}
