package ocp;

public class Concurrency17 {
	/*
	 * import java.util.*;
	 * import java.util.concurrent.*;
	 * public class Bovines {
	 *   public static void main(String[] args) throws InterruptedException {
	 *     List<StringBuilder> c = new CopyOnWriteArrayList<>(
	 *       Arrays.asList(new StringBuilder("1"), new StringBuilder("2"),
	 *                       new StringBuilder("3"), new StringBuilder("4")));
	 *     new Thread(new Runnable() {
	 *       public void run() {
	 *         try {
	 *           Thread.sleep(150);
	 *         } catch (InterruptedException e) {
	 *             System.out.println("got exc");
	 *         }
	 *         c.get(3).replace(0,1,"four");
	 *         System.out.print(c + " ");
	 *       }  
	 *      }).start();
	 *      for(StringBuilder s: c) {
	 *        System.out.print(s + " ");
	 *        Thread.sleep(100);
	 *     } 
	 *   }
	 * }
	 * 
	 * What is the most likely result?
	 * 
	 * A. 1 2 [1, 2, 3, 4] 3 4
	 * 
	 * B. 1 2 [1, 2, 3, four] 3 4
	 * 
	 * C. 1 2 [1, 2, 3, 4] 3 four
	 * 
	 * D. 1 2 [1, 2, 3, four] 3 four
	 * 
	 * E. Compilation fails
	 * 
	 * F. An exception is thrown at runtime
	 * 
	 * D is correct. CopyOnWriteArrayList is a thread-safe collection that makes a copy of the collection 
	 * whenever the collection of objects (but not state within the objects) gets modified. In this case, 
	 * the fourth StringBuilder's state gets modified, but no objects are added or deleted, so no new copy 
	 * of the collection is made.
	 * 
	 * A, B, C, E, and F are incorrect based on the above.
	 * 
	 * คำอธิบาย:
	 * - ในกรณีนี้ ใช้ `CopyOnWriteArrayList` ซึ่งเป็นคอลเลกชันที่รองรับการทำงานหลายเธรด โดยจะทำการคัดลอกคอลเลกชันใหม่ทุกครั้งที่มีการเปลี่ยนแปลงที่ตัวคอลเลกชัน แต่จะไม่คัดลอกสถานะภายในของอ็อบเจ็กต์
	 * - เมื่อมีการแก้ไขค่าภายใน `StringBuilder` ในตำแหน่งที่ 4 (จาก "4" เป็น "four") มันจะไม่ทำการคัดลอกคอลเลกชันใหม่ เพราะไม่มีการเพิ่มหรือลบอ็อบเจ็กต์ออกจากคอลเลกชัน
	 * - ดังนั้นผลลัพธ์ที่คาดว่าจะได้คือ ข้อ D: "1 2 [1, 2, 3, four] 3 four"
	 */

}
