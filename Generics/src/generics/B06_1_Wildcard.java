package generics;

import java.util.*;

public class B06_1_Wildcard {

	public static void main(String[] args) {

		/*
		 * Aufgabe :
				Was bedeutet folgender Platzhalter im folgenden Code?
    			List<?> list;
		 */

		/*
		 * ในโค้ดนี้ `List<?> list;` เครื่องหมาย `<?>` คือ Wildcard ใน Java
		 * หมายถึงว่า List นี้สามารถเก็บข้อมูลได้ทุกประเภท โดยไม่ระบุชนิดที่แน่นอน
		 *
		 * รายละเอียด:
		 * - List<?> หมายถึง "List ที่สามารถเก็บข้อมูลชนิดใดก็ได้" เช่น List<String>, List<Integer> เป็นต้น
		 * - ไวลด์การ์ดแบบนี้เรียกว่า Unbounded Wildcard (ไวลด์การ์ดที่ไม่จำกัดชนิด)
		 * - ถึงแม้ว่าเราจะไม่รู้ชนิดของข้อมูลใน List เรายังสามารถใช้เมธอดทั่วไปได้ เช่น size(), isEmpty()
		 *   แต่เราไม่สามารถเพิ่มข้อมูลลงใน List ได้เพราะไม่รู้ชนิดที่แน่นอน
		 *
		 * ตัวอย่าง:
		 */
		
		 List<?> list = new ArrayList<String>();
		 System.out.println(list.size()); 
		 

		 list.add(null);
//		 list.add(10);
//		 list.add("Test");
		 
		/*
		 * ข้อจำกัด:
		 * - ไม่สามารถเพิ่มข้อมูลลงใน List ได้ (ยกเว้น null) เนื่องจากไม่รู้ชนิดข้อมูลที่แน่นอน
		 * - เช่น ถ้าลองใช้ list.add("Test"); จะเกิดข้อผิดพลาดจากคอมไพเลอร์ เพราะไม่รู้ชนิดที่แน่นอน
		 *
		 * การใช้งาน:
		 * - List<?> มีประโยชน์เมื่อเราต้องการสร้างเมธอดที่ทำงานกับ List ทุกชนิด โดยไม่จำเป็นต้องสนใจชนิดของข้อมูลใน List นั้น ๆ
		 */
		 
		 
		 // สร้าง List ของชนิดต่าง ๆ
	      List<String> stringList = Arrays.asList("Apple", "Banana", "Cherry");
	      List<Integer> intList = Arrays.asList(10, 20, 30);
	        
	      // เรียกใช้เมธอดที่รับ List<?> ซึ่งทำงานกับ List ทุกชนิด
	      printList(stringList);  // List<String>
	      printList(intList);     // List<Integer>

	}
	
    // เมธอดนี้ใช้ List<?> เพื่อทำงานกับ List ทุกชนิด
    public static void printList(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }

}
