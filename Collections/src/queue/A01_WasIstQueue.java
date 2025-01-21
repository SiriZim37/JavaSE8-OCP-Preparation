package queue;

import java.util.LinkedList;
import java.util.Queue;

public class A01_WasIstQueue {

/*
	 Queue is a data structure that follows the First-In-First-Out (FIFO) principle, 
	 meaning that the first element added to the queue will be the first one to be removed. 
	 It is part of the Java Collections Framework and provides methods for adding, removing, 
	 and inspecting elements in the collection.
	 
	 Queue เป็นโครงสร้างข้อมูลที่ทำงานตามหลักการ First-In-First-Out (FIFO) 
	 ซึ่งหมายความว่าองค์ประกอบแรกที่ถูกเพิ่มเข้ามาจะเป็นองค์ประกอบแรกที่ถูกนำออก 
	 คิวเป็นส่วนหนึ่งของ Java Collections Framework และมีเมธอดสำหรับการเพิ่ม, ลบ, 
	 และตรวจสอบองค์ประกอบในคอลเลคชัน
	 
	 ลักษณะสำคัญของ Queue:
		1.	ลำดับ FIFO: องค์ประกอบจะถูกประมวลผลตามลำดับที่ถูกเพิ่มเข้ามา
		2.	Dynamic Size:ไดนามิก: คิวสามารถขยายและย่อขนาดได้ตามการเพิ่มหรือลบองค์ประกอบ
		3.	Null Elements:: บางการใช้งานอาจไม่อนุญาตให้องค์ประกอบ Null
	การใช้งานที่พบบ่อยของ Queue:
		1.	LinkedList: ใช้ในการใช้งาน Queue และอนุญาตให้มีขนาดที่เปลี่ยนแปลงได้
		2.	PriorityQueue: องค์ประกอบจะถูกจัดลำดับตามลำดับตามธรรมชาติหรือโดยการเปรียบเทียบที่ระบุ
		3.	ArrayDeque: การใช้งานอาร์เรย์ที่ปรับขนาดได้ของอินเทอร์เฟซ Deque ซึ่งสามารถทำงานเป็นทั้งคิวและสแต็ก
	เมธอดหลักของ Queue Interface:
		1.  boolean add(E e): เพิ่มองค์ประกอบที่ระบุเข้าไปในคิว จะเกิดข้อยกเว้นหากไม่สามารถเพิ่มองค์ประกอบได้
		2.	boolean  offer(E e): เพิ่มองค์ประกอบที่ระบุเข้าไปในคิว คืนค่า true หากสำเร็จและ false หากไม่สำเร็จ
		3.	E remove(): ลบและคืนค่าหัวของคิว จะเกิดข้อยกเว้นหากคิวว่าง
		4.	E poll(): ลบและคืนค่าหัวของคิว คืนค่า null หากคิวว่าง
		5.	E peek(): ดึงแต่ไม่ลบหัวของคิว คืนค่า null หากคิวว่าง
		6.	int size(): คืนค่าจำนวนองค์ประกอบในคิว
		7.	boolean isEmpty()ตรวจสอบว่าคิวว่างหรือไม่	
		8.	int size()	คืนค่าจำนวนองค์ประกอบในคิว	
*/
	
	/*
	สรุปเรื่อง Queue และ Deque ใน Java SE 8 (สำหรับเตรียมสอบ OCP)

	1. **Queue คืออะไร?**
	   - Queue (คิว) เป็นโครงสร้างข้อมูลที่ใช้หลักการ FIFO (First In, First Out)
	   - ใช้ในสถานการณ์ที่ต้องการจัดการข้อมูลตามลำดับ เช่น การประมวลผลคำขอหรือการรอคิว
	   - ตัวอย่างคลาส: `PriorityQueue`, `LinkedList`

	2. **Deque คืออะไร?**
	   - Deque (Double-Ended Queue) เป็น Queue แบบที่สามารถเพิ่มและลบข้อมูลได้ทั้งสองด้าน (หัวและท้าย)
	   - ใช้ในสถานการณ์ที่ต้องการความยืดหยุ่นมากขึ้น เช่น Stack หรือ Queue
	   - ตัวอย่างคลาส: `ArrayDeque`, `LinkedList`

	3. **ArrayDeque**
	   - เป็นหนึ่งในคลาสที่ใช้สำหรับ Deque
	   - มีประสิทธิภาพสูงกว่าการใช้ `LinkedList` เมื่อใช้เป็น Queue หรือ Stack
	   - ไม่มีข้อจำกัดเรื่องขนาด เพราะขนาดจะขยายได้อัตโนมัติ
	   - ไม่รองรับ `null` (ค่าที่เป็น `null` จะไม่สามารถเก็บได้)
	   - เมธอดที่ใช้บ่อย:
	     - `addFirst(E e)`, `addLast(E e)`: เพิ่มข้อมูลที่หัวหรือท้าย
	     - `removeFirst()`, `removeLast()`: ลบข้อมูลจากหัวหรือท้าย
	     - `peekFirst()`, `peekLast()`: ดูข้อมูลที่หัวหรือท้ายโดยไม่ลบออก

	4. **ตัวอย่างการใช้งาน Queue**
	   ```java
	   Queue<String> queue = new LinkedList<>();
	   queue.add("A");
	   queue.add("B");
	   queue.add("C");
	   
	   System.out.println(queue.poll()); // แสดงผล A และลบออกจากคิว
	   System.out.println(queue.peek()); // แสดงผล B แต่ไม่ลบออก
	   ```

	5. **ตัวอย่างการใช้งาน Deque**
	   ```java
	   Deque<String> deque = new ArrayDeque<>();
	   deque.addFirst("A"); // เพิ่ม A ที่หัว
	   deque.addLast("B");  // เพิ่ม B ที่ท้าย
	   deque.addFirst("C"); // เพิ่ม C ที่หัว
	   
	   System.out.println(deque.removeFirst()); // แสดงผล C และลบออกจากหัว
	   System.out.println(deque.removeLast());  // แสดงผล B และลบออกจากท้าย
	   ```

	6. **Queue และ Deque ต่างกันอย่างไร?**
	   | คุณสมบัติ            | Queue               | Deque                    |
	   |----------------------|---------------------|--------------------------|
	   | การเพิ่มข้อมูล       | ท้ายเท่านั้น         | หัวและท้ายได้             |
	   | การลบข้อมูล          | หัวเท่านั้น          | หัวและท้ายได้             |
	   | ตัวอย่างคลาส        | `PriorityQueue`     | `ArrayDeque`, `LinkedList` |

	7. **ข้อดีของ ArrayDeque**
	   - ประสิทธิภาพสูงกว่า `LinkedList` ในหลายกรณี
	   - ใช้งานได้ทั้งเป็น Queue และ Stack
	   - ขนาดยืดหยุ่น ไม่ต้องกำหนดล่วงหน้า
	   - เหมาะสำหรับงานที่ต้องการเพิ่ม/ลบข้อมูลบ่อย ๆ ที่หัวหรือท้าย

	8. **ข้อสอบที่ควรระวัง**
	   - ความแตกต่างระหว่าง `Queue` กับ `Deque`
	   - การใช้เมธอดต่าง ๆ เช่น `peek()`, `poll()`, `addFirst()`, `removeLast()`
	   - การจัดลำดับใน `PriorityQueue` (ต้องมี Comparator หากไม่เรียงลำดับตามธรรมชาติ)
	   - การใช้ `ArrayDeque` แทน `Stack` (Stack ถูกแนะนำให้ใช้ Deque แทนใน Java SE 8)

	9. **สรุป**
	   - Queue: ใช้เมื่อจัดการข้อมูลตามลำดับ FIFO
	   - Deque: ใช้เมื่อจัดการข้อมูลที่ต้องเพิ่ม/ลบได้ทั้งสองด้าน
	   - ArrayDeque: ตัวเลือกที่เหมาะสมสำหรับ Deque ในแง่ของประสิทธิภาพและความยืดหยุ่น
	   - ควรรู้เมธอดพื้นฐานของทั้ง Queue และ Deque เพื่อพร้อมใช้ในข้อสอบ OCP
*/

	
	public static void main(String[] args) {
		 Queue<String> queue = new LinkedList<>();

	     // Adding elements to the queue
	     queue.add("Alice");
	     queue.add("Bob");
	     queue.add("Charlie");
         
	     System.out.println("queue: " + queue); // Output: [Alice, Bob, Charlie]
	     
	     // Peeking at the head of the queue
	     System.out.println("Head of the queue: " + queue.peek()); // Output: Alice
         
	     // Removing elements from the queue
	     while (!queue.isEmpty()) {
	         System.out.println("Removing: " + queue.poll());
	     }
         
	     System.out.println("Queue after removals: " + queue); // Output: []

	}

}
