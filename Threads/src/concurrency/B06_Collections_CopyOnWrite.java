package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;


/*
 * CopyOnWriteArrayList เป็นคลาสที่อยู่ในแพ็กเกจ java.util.concurrent ใน Java ซึ่งถูกออกแบบมาเพื่อให้รองรับการเข้าถึงจากหลายเธรด (thread-safe) 
 * ในสภาพแวดล้อมที่มีการใช้งานหลายเธรดพร้อมกัน โดยเฉพาะเมื่อมีการอ่านข้อมูลจากคอลเล็กชันบ่อยๆ และมีการแก้ไขข้อมูลในคอลเล็กชันในบางครั้ง (Write Operation)
 * 
 * หลักการทำงานของ CopyOnWriteArrayList:
 * เมื่อทำการเพิ่มหรือเอาข้อมูลออกจาก CopyOnWriteArrayList ระบบจะทำการคัดลอกข้อมูลในคอลเล็กชัน (write operation) และทำการอัพเดตสำเนาใหม่แทนที่ข้อมูลเดิม 
 * ซึ่งจะช่วยให้การอ่านข้อมูล (read operation) ในคอลเล็กชันไม่ถูกกระทบจากการเปลี่ยนแปลงที่เกิดขึ้นในระหว่างการทำงานของเธรดอื่นๆ
 * 
 * คุณสมบัติหลัก:
 * - Thread-safe: คอลเล็กชันนี้รองรับการทำงานพร้อมกันจากหลายเธรดโดยไม่เกิดข้อผิดพลาด เช่น ConcurrentModificationException
 * - Copy-on-write: เมื่อมีการเพิ่มหรือเอาข้อมูลออกจากคอลเล็กชัน ทุกๆ การเปลี่ยนแปลงจะทำการคัดลอกคอลเล็กชันและอัพเดตสำเนาใหม่ ทำให้การอ่านข้อมูลจากหลายๆ เธรดไม่ถูกกระทบ
 * - เหมาะสำหรับกรณีที่การอ่านข้อมูลบ่อยๆ แต่การเขียนข้อมูลเกิดขึ้นน้อย: เนื่องจากการเขียนข้อมูล (write) จะทำให้ต้องคัดลอกคอลเล็กชันใหม่ทุกครั้ง จึงเหมาะสำหรับกรณีที่การอ่านข้อมูลมากกว่าการเขียน
 * 
 * ข้อดี:
 * - เหมาะสำหรับการใช้งานที่มีการอ่านข้อมูลบ่อยครั้งและการแก้ไขข้อมูลไม่บ่อย
 * - ไม่มีปัญหา ConcurrentModificationException เนื่องจากใช้การคัดลอกข้อมูลใหม่ทุกครั้งที่มีการเปลี่ยนแปลง
 * 
 * ข้อเสีย:
 * - การเขียนข้อมูล (การเพิ่ม/ลบ) จะมีต้นทุนสูงกว่าคอลเล็กชันปกติ เพราะต้องคัดลอกคอลเล็กชันใหม่ทุกครั้งที่มีการเปลี่ยนแปลง
 * - ไม่เหมาะสมหากการเขียนข้อมูลต้องการประสิทธิภาพที่สูง
 */

public class B06_Collections_CopyOnWrite {

	/*
	 * CopyOnWrite-Collections :
	 * 
	 * 	- threadsicher : คอลเล็กชันนี้ปลอดภัยจากการเข้าถึงพร้อมกันจากหลายเธรด
	 * 	- keine ConcurrecntModificationException  : ไม่มีการโยนข้อผิดพลาด ConcurrentModificationException
	 * 	- Machen Sinn , wenn in der Anwendung mehrere Threads
	 * 	  auf die Collection zugreifen und dabei sehr selten
	 * 	  die Collection änderen (geht langsam) und sehr häufig 
	 * 	  lesen (geht schnell). เหมาะสมในกรณีที่มีหลายเธรดที่เข้าถึงคอลเล็กชันพร้อมกัน 
	 * 	  และการเปลี่ยนแปลงข้อมูลในคอลเล็กชันเกิดขึ้นไม่บ่อยนักแต่การอ่านข้อมูล (read) เกิดขึ้นบ่อย
	 */
	
	public static void main(String[] args) {
		

        Set<Integer> set = new CopyOnWriteArraySet<>();		// unwahrscheinlich in der Prüfung
        
        /*
         * Achtung! Bei jede Änderung wird intern ein neues Array erzeugt! 
         * 
         * เนื่องจาก CopyOnWriteArrayList สร้างสำเนาใหม่ทุกครั้งที่มีการเปลี่ยนแปลง neues Array 
         * ทำให้การอ่านจากคอลเล็กชันไม่ถูกกระทบ
         */
        List<Integer> list = new CopyOnWriteArrayList<>();
        
        list.add(12);	// intern neues Array : [12]
        list.add(13);	// intern neues Array : [12 , 13]
        list.add(14);	// intern neues Array : [12 , 13 , 14]
        
        list.remove(1);	// intern neues Array: [12 ,14]
        
        /*
         * Achtung! 
         * CopyOnWriteArrayList hat den Snapshot-Iterator.
         */
        
        // Wenn die foreach startet , hat die CopyOnWriteArrayList
        // das Array : [12,14] Die foreach wird nur die Element finden
        
        /*
         * Ergebnis A : 12 14
         */
        for (Integer x : list) {
//        	list.remove(0);
        	list.add(42);
			System.out.println(x);  // Ergebnis : A ?
		}
        
        System.out.println("Nach der forEach-Schleife");
        System.out.println("list: " + list); // [12, 14, 42, 42]
	}
}
