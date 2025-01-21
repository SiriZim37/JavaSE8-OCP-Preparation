package set;

import java.util.*;

public class B01_HashSetMitStrings {

	/*
	 * Ein Set ist eine Menge einzigartiger Elemente
	 * 
	 * HashSet ist nicht geordnet
	 */
	/*
	 * HashSet ใน Java ซึ่งเป็นหนึ่งในคลาสของ Set ที่มีคุณสมบัติสำคัญ คือ:
	 * ไม่อนุญาตให้มีค่าซ้ำในเซต
	 * ไม่มีการจัดเรียงลำดับของสมาชิกในเซต
	 */
	/*
	 * HashSet เหมาะสำหรับการเก็บข้อมูลที่ไม่ซ้ำกันและไม่ต้องการลำดับที่แน่นอน
	 * หากต้องการเซตที่เรียงลำดับ สามารถใช้ TreeSet แทน
	 */
	
	
	public static void main(String[] args) {

		Set<String> set =  new HashSet<String>();
		
		System.out.println("1. size: " + set.size());		// 0 
		
		set.add("mo");
		set.add("mo");
		set.add("MO".toLowerCase());
		set.add("MO".toUpperCase());
		set.add(new String("mo"));
		
		System.out.println("2. size: " + set.size());		// 2
		
		System.out.println("3. set: " + set);				// [mo, MO]
		//เพิ่มค่าที่ไม่ซ้ำใหม่
		set.add("di");
		set.add("mi");
		set.add("do");
	
		//4. เพิ่มค่าใหม่ที่ไม่ส่งผลต่อการจัดเรียง
		//HashSet ไม่จัดเรียงลำดับ ดังนั้นสมาชิกในเซตอาจปรากฏในลำดับใดก็ได้
			
		System.out.println("4. set: " + set);				// [mo, MO, di, do, mi]
		
		set.add("aa");
		set.add("ma");
		
		System.out.println("5. set: " + set);				// [mo, MO, di, do, mi]
	}

}
