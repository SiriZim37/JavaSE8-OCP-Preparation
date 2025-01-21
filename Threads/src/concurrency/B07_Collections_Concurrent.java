package concurrency;

import java.util.concurrent.ConcurrentSkipListSet;

public class B07_Collections_Concurrent {

	/*
	 * Concurrent  :
	 * 
	 * 	- threadsicher : คอลเล็กชันนี้ปลอดภัยจากการเข้าถึงพร้อมกันจากหลายเธรด
	 * 	- keine ConcurrecntModificationException  : ไม่มีการโยนข้อผิดพลาด ConcurrentModificationException
	 */
	
	/*
	 * คุณสมบัติของ ConcurrentSkipListSet:
	 *
	 * 1. **Thread-safe (ปลอดภัยจากการใช้งานหลายเธรด)**:
	 *    - ConcurrentSkipListSet รองรับการใช้งานจากหลายเธรดพร้อมกันอย่างปลอดภัย
	 *    - ไม่มีปัญหาจากการเข้าถึงหรือการแก้ไขข้อมูลจากหลายเธรดในเวลาเดียวกัน
	 *    - สามารถป้องกันข้อผิดพลาดที่อาจเกิดขึ้น เช่น `ConcurrentModificationException` ที่เกิดจากการแก้ไขคอลเล็กชันระหว่างการวนลูป
	 *
	 * 2. **ไม่มี ConcurrentModificationException**:
	 *    - การใช้งานในลักษณะ concurrent หมายความว่า การอ่านและเขียนข้อมูลสามารถทำได้พร้อมกันโดยไม่เกิดข้อผิดพลาดในระหว่างการทำงาน
	 *    - มั่นใจได้ว่าแม้จะมีการเปลี่ยนแปลงข้อมูลในคอลเล็กชันขณะใช้งานจากเธรดหลายตัว ก็จะไม่ทำให้เกิดข้อผิดพลาดในโปรแกรม
	 *
	 * 3. **Set ที่จัดเรียงข้อมูล (Sorted Set)**:
	 *    - ConcurrentSkipListSet เก็บข้อมูลในลำดับที่จัดเรียง (Sorted) อัตโนมัติ
	 *    - เมื่อมีการเพิ่มข้อมูลใหม่ ค่าของข้อมูลจะถูกจัดเรียงตามลำดับค่าทางธรรมชาติ หรือจะใช้ `Comparator` ที่กำหนดเองเพื่อการจัดเรียงที่ต้องการ
	 *
	 * โดยสรุปแล้ว, `ConcurrentSkipListSet` เหมาะสำหรับการใช้งานที่ต้องการการทำงานพร้อมกันจากหลายเธรดและต้องการให้ข้อมูลในคอลเล็กชันมีการจัดเรียงอย่างเป็นระเบียบ
	 */

	public static void main(String[] args) {
		
		/*
		 * ConcurrentSkipListSet
		 * 		
		 * 		- es istein Set
		 * 		- ist threadsicher
		 * 		- sortiert set
		 */
		new ConcurrentSkipListSet<>();
		
		 // สร้าง ConcurrentSkipListSet ซึ่งเป็น Set ที่รองรับการทำงานพร้อมกันจากหลายเธรด
        ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<>();

        // เพิ่มข้อมูลลงใน Set
        set.add(50);
        set.add(10);
        set.add(20);
        set.add(30);

        // แสดงข้อมูลใน Set (ข้อมูลจะถูกจัดเรียงตามลำดับ)
        System.out.println(set);  // ผลลัพธ์: [10, 20, 30 , 50 ]
        
        // ในกรณีที่มีการใช้หลายเธรดในการเข้าถึง set นี้ ข้อมูลจะปลอดภัยจากปัญหาการทำงานพร้อมกัน
	}
}
