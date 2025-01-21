package set;

import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class B0302_WasIstSortedSet {

	/*
	 * 1. SortedSet
	 * 		SortedSet เป็นอินเทอร์เฟซใน Java ที่สืบทอดจากอินเทอร์เฟซ Set 
	 * 		โดยมีการจัดเก็บข้อมูลในลำดับที่เรียงตามลำดับที่กำหนด (ตามค่าที่เปรียบเทียบ) นี่คือคุณสมบัติหลักของ SortedSet:
	 * 
	 * 		-	การเรียงลำดับอัตโนมัติ: ออบเจ็กต์ที่ถูกเพิ่มจะถูกจัดเรียงตามลำดับที่กำหนด (เช่น เลขจำนวน หรืออักษร)
	 * 		-	ไม่มีข้อมูลซ้ำ: เช่นเดียวกับ Set, SortedSet ไม่อนุญาตให้เก็บข้อมูลซ้ำ
	 * 
	 * 2. NavigableSet
	 * 		NavigableSet เป็นอินเทอร์เฟซที่สืบทอดจาก SortedSet และเพิ่มฟังก์ชันการทำงานในการนำทาง 
	 * 		เช่น การค้นหาค่าที่อยู่ใกล้เคียง, การรับค่าต่ำสุดและค่าสูงสุด, และการค้นหาค่าในช่วงที่กำหนด
	 * 
	 * 		-	ฟังก์ชันการนำทาง: มีเมธอดเพิ่มเติมที่ช่วยในการค้นหาและเข้าถึงออบเจ็กต์ในลักษณะที่สะดวกกว่า
	 * 		-	การค้นหาค่าที่ใกล้เคียง: เช่น lower(), higher(), floor(), และ ceiling()
	 * 
	 * สรุป
	 * 		SortedSet: ใช้สำหรับเก็บออบเจ็กต์ในลำดับที่เรียงตามค่า
	 * 		NavigableSet: เป็น SortedSet ที่มีฟังก์ชันการทำงานในการนำทางและค้นหาค่าที่อยู่ใกล้เคียง ทำให้การเข้าถึงข้อมูลสะดวกและรวดเร็วขึ้น
	 */
	public static void main(String[] args) {

		    SortedSet<Integer> sortedSet = new TreeSet<>();

	        sortedSet.add(5);
	        sortedSet.add(1);
	        sortedSet.add(3);
	        sortedSet.add(2);
	        
	        System.out.println(sortedSet); // Output: [1, 2, 3, 5]
	        
	        
	        
	        NavigableSet<Integer> navigableSet = new TreeSet<>();

	        navigableSet.add(5);
	        navigableSet.add(1);
	        navigableSet.add(3);
	        navigableSet.add(2);

	        System.out.println("Navigable Set: " + navigableSet); // Output: [1, 2, 3, 5]
	        System.out.println("Lower than 3: " + navigableSet.lower(3)); // Output: 2
	        System.out.println("Higher than 3: " + navigableSet.higher(3)); // Output: 5
	    
	}

}
