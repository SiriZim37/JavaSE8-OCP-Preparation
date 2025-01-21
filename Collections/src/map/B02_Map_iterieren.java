package map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class B02_Map_iterieren {
	/*
	  	Methode Map:
	  	-	* keySet() : Set<K> 		 			คืนค่าเป็น Set ของคีย์ทั้งหมด
		-	* values() : Collection<V> 				คืนค่าเป็น Collection ของค่าทั้งหมด
		-	* entrySet() :  Set<Map.Entry<K, V>>	คืนค่าเป็น Set ของคู่คีย์-ค่า
		-	put(K key, V value): V   เพิ่มคู่คีย์และค่าเข้าไปใน Map
		-	get(Object key):  V  คืนค่าที่จับคู่กับคีย์ที่กำหนด
		-	remove(Object key): V  ลบคู่คีย์-ค่าที่จับคู่กับคีย์นั้นออก
		- 	isEmpty(); boolean
		-	clear() : void
		-	containsKey(Object key): ตรวจสอบว่ามีคีย์อยู่ใน Map หรือไม่
		-	containsValue(Object value): ตรวจสอบว่ามีค่าอยู่ใน Map หรือไม่

	 */
	public static void main(String[] args) {

		Map<String,Integer> map = new TreeMap<String , Integer>();
		map.put("jan", 31);
		map.put("feb", 28);
		map.put("mär", 31);
		
		/*
		 * Map ist NICHT Iterable
		 */
		
//		for(Object obj : map) {} // cf 
		
		/*
		 * Set<K> keySet()
		 */
		System.out.println("*** keySet()");
		Set<String> allKeys = map.keySet();
		
		/*
		     feb=28
			 jan=31
			 mär=31
		 */
		for(String key : allKeys) {
			Integer value = map.get(key);
			System.out.println(key + "=" + value);
		}
		
		/*
		 * forEach wird später im Projekt 'Funtional' im Pakage
		 * 'collections' bespreochen
		 */
		
		/* 
		 * คืนค่าเป็น Collection ของค่าทั้งหมด
		 * Collection<V> values 
		 */
		System.out.println("\n*** values()");
		Collection<Integer> allValues = map.values();
		System.out.println("allValues : " + allValues);   // [28, 31, 31]
		
		
		/*
		 * entrySet(): คืนค่าเป็น Set ของคู่คีย์-ค่า
		 * 
		 * map : 
		 * 
		 * 	Map<String , Integer> map
		 * 
		 * Eintrag dieser Map besteht aus Key und Value
		 * und wird in einem Objekt vom typ Map. Entry gespeichert 
		 * 
		 */
		
		System.out.println("\n***entrySet");
		
		Map.Entry<String, Integer> entry;
		
		Set<Map.Entry<String, Integer>> allEntries = map.entrySet();
		System.out.println("entrySet() : " + allEntries); // [feb=28, jan=31, mär=31]
		
		for (Map.Entry<String, Integer> entrys : allEntries) {
			String key = entrys.getKey();
			Integer value = entrys.getValue();
			System.out.println(key + "=" + value);
		}
	}

}
