package concurrency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class B05_ConcurrentModificationException {

	/*
	 * ConcurrentModificationModicationException ist NICHT in der Prüfung
	 */
	/* 
	 * ในโปรแกรมนี้เรามีการสร้าง ArrayList ที่เก็บค่า Integer และใส่ค่าต่างๆ เข้าไปในลิสต์
	 * ข้อความในโปรแกรมบอกว่า ConcurrentModificationException 
	 * เป็นข้อผิดพลาดที่เกิดขึ้นเมื่อเราแก้ไขคอลเล็กชันในขณะที่มันกำลังถูกเข้าถึง (เช่น ในลูป for-each ที่กำลังวนรอบคอลเล็กชัน) 
	 * เช่น การลบค่าจากคอลเล็กชันที่กำลังถูกอ่านอยู่
	 * 
	 * ในกรณีนี้ เมื่อโปรแกรมทำการลบค่าจากลิสต์ในขณะที่วนรอบอยู่ มันจะทำให้เกิดข้อผิดพลาด ConcurrentModificationException ขึ้น
	 */

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		list.add(12);
		list.add(14);
		list.add(14);
		
		/*
		 * ConcurrentModificationModicationException kann geworfen werden
		 * wenn man mit einem Iterator die Collection
		 * interiert , die währen dessen modifiziert wird.
		 * 
		 * ConcurrentModificationException จะถูกโยนออกมา
         * เมื่อมีการวนรอบคอลเล็กชันด้วย Iterator หรือในกรณีนี้คือการใช้ for-each loop 
         * และในระหว่างการวนรอบมีการแก้ไขคอลเล็กชันนั้น เช่น การลบหรือเพิ่มค่า
		 */
		try {
			for (Integer x : list) {
				list.remove(0);
				System.out.println(x);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		

		//---------------------------------------------------//
		System.out.println("***Sichere Iteraration");
		/*
		 * SafeIterationExample 
		 */
	    
        List<Integer> list2 = new ArrayList<>();
        list2.add(12);
        list2.add(13);
        list2.add(14);
        
        // Using Iterator to avoid ConcurrentModificationException
        Iterator<Integer> iterator = list2.iterator();
        while (iterator.hasNext()) {
            Integer x = iterator.next();
            if (x == 14) {
                iterator.remove(); // Safe way to remove elements during iteration
            }
            System.out.println(x);
        }

        System.out.println("List after removal: " + list2);
        
        // Using a for-loop with an index
        for (int i = 0; i < list2.size(); i++) {
            Integer x = list2.get(i);
            System.out.println("Element at index " + i + ": " + x);
            list2.remove(i);     
            list2.add(50);  		// not delete becase add after
        }
        System.out.println("List after removal: " + list2);
	}
}
