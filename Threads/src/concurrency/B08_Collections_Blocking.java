package concurrency;

import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class B08_Collections_Blocking {

	/*
	 * Blocking
	 * 
	 * 	- threadsicher : คอลเล็กชันนี้ปลอดภัยจากการเข้าถึงพร้อมกันจากหลายเธรด
	 * 	- keine ConcurrecntModificationException  : ไม่มีการโยนข้อผิดพลาด ConcurrentModificationException
	 */
	/*
	 *  BlockingQueue เป็นอินเตอร์เฟซใน Java ที่ใช้สำหรับการประมวลผลแบบหลายเธรด (multi-threading) 
	 *  ซึ่งช่วยในการจัดการคิว (queue) ที่จะบล็อก (block) เมื่อคิวเต็มหรือว่างเปล่า
	 *  ขึ้นอยู่กับว่าเธรดกำลังดำเนินการอะไรอยู่ การใช้งาน BlockingQueue 
	 *  จะช่วยให้การทำงานกับคิวในสภาพแวดล้อมที่มีหลายเธรดสามารถทำได้อย่างปลอดภัย 
	 *  โดยไม่มีปัญหาการเกิด race condition
	 */
	
	
	/*
	 *  สรุปวิธีการของ BlockingQueue
		 							Summary of BlockingQueue methods
		---------------------------------------------------------------------------------------------------------							
		|				|Throws exception	|  Special value	|	Blocks	   	    |		Times out         	|
		---------------------------------------------------------------------------------------------------------
		|	Insert	    |  add(e)			|	  offer(e)		|	put(e)			|	offer(e, time, unit)	|
		|	Remove	    |  remove()			|	  poll()		|	take()			|	poll(time, unit)		|
		|	Examine	    |  element()		|	  peek()		|	not applicable	|	not applicable			|
	 	---------------------------------------------------------------------------------------------------------
	 
	 * 
	 * คำอธิบาย:
	 * 
	 * การแทรก (Insert):
	 * - add(e): พยายามเพิ่มค่าไปที่คิว ถ้าคิวเต็มจะโยน IllegalStateException ขึ้นมา
	 * - offer(e): พยายามเพิ่มค่า ถ้าคิวเต็มจะคืน false โดยไม่บล็อก
	 * - put(e): เพิ่มค่าในคิว ถ้าคิวเต็มจะบล็อกจนกว่าจะมีที่ว่าง
	 * - offer(e, time, unit): พยายามเพิ่มค่า ถ้าคิวเต็มจะบล็อกจนกว่าจะมีที่ว่างหรือจนหมดเวลาที่กำหนด
	 * 
	 * การลบ (Remove):
	 * - remove(): ลบข้อมูลจากคิว ถ้าคิวว่างจะโยน NoSuchElementException
	 * - poll(): ลบข้อมูลจากคิว ถ้าคิวว่างจะคืน null
	 * - take(): ลบข้อมูลจากคิว ถ้าคิวว่างจะบล็อกจนกว่าจะมีข้อมูล
	 * - poll(time, unit): ลบข้อมูลจากคิว ถ้าคิวว่างจะบล็อกจนกว่าจะมีข้อมูลหรือตามเวลาที่กำหนด
	 * 
	 * การตรวจสอบ (Examine):
	 * - element(): ตรวจสอบค่าส่วนหัวของคิว ถ้าคิวว่างจะโยน NoSuchElementException
	 * - peek(): ตรวจสอบค่าส่วนหัวของคิว ถ้าคิวว่างจะคืน null
	 * 
	 * หมายเหตุ:
	 * - โยนข้อผิดพลาด (Throws Exception) จะเกิดขึ้นเมื่อทำการเพิ่มหรือเอาข้อมูลจากคิวในกรณีที่คิวเต็มหรือว่างโดยไม่ใช้ตัวเลือกที่บล็อก
	 * - ค่าพิเศษ (Special Value) เช่น offer(e) หรือ poll() จะคืนค่าพิเศษ (false หรือ null) ถ้าคิวเต็มหรือว่าง
	 * - บล็อก (Blocks) เช่น put(e) และ take() จะบล็อกการทำงานของเธรดจนกว่าจะทำการเพิ่มหรือเอาข้อมูลได้
	 * - หมดเวลา (Times out) การใช้ offer(e, time, unit) และ poll(time, unit) จะบล็อกเป็นระยะเวลาที่กำหนด และคืนค่าหรือโยนข้อผิดพลาดหากไม่ได้รับการตอบสนองภายในเวลาที่กำหนด
	 */

	public static void main(String[] args) {
		
		int fixedSize = 3;
		
		/*
		 * Konstruktoren
		 */
		new LinkedBlockingQueue<>();				// max size : unbegrenzt
		new LinkedBlockingQueue<>(fixedSize);		// max size : 3
		
		//  ArrayBlockingQueue(int capacity)
//		new ArrayBlockingQueue<>();					// cf
		new ArrayBlockingQueue<>(fixedSize);		// max size : 3
		
		
		/*
		 * Methoden
		 */
		
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(fixedSize);
		
		/*
		 * การแทรก (Insert):
		 * 
		 * add , offer , put 
		 * 	 
		 * - add(e): พยายามเพิ่มค่าไปที่คิว ถ้าคิวเต็มจะโยน IllegalStateException ขึ้นมา
		 * - offer(e): พยายามเพิ่มค่า ถ้าคิวเต็มจะคืน false โดยไม่บล็อก
		 * - put(e): เพิ่มค่าในคิว ถ้าคิวเต็มจะบล็อกจนกว่าจะมีที่ว่าง
		 * - offer(e, time, unit): พยายามเพิ่มค่า ถ้าคิวเต็มจะบล็อกจนกว่าจะมีที่ว่างหรือจนหมดเวลาที่กำหนด
		 */
		queue.add(12);
		queue.add(13);		
		try {
			queue.put(14);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1. queue: " + queue); 						// 12 , 13 , 14
		
		try {
			queue.add(15);
		} catch (IllegalStateException e) {
			System.out.println("2. Exception! Schlange ist voll");		// Exception! Schlange ist voll
		}
		
		boolean result = queue.offer(16);
		System.out.println("3. result: " + result); 						// false
		
		System.out.println("4. queue: " + queue);  		// [12, 13, 14]
		
		
		/*
		 * void  put(E e) throwns InterruptedException
		 */
	
		new Thread(() -> {
			kurzPause(3000);
			System.out.println("6. extra-Thread entfernt ein Element: " 
						+ queue.poll());  // 12
		}).start();
		
		try {
			System.out.println("5. main-Thread ruft  queue.put(17) auf...");
			queue.put(17);		// main wird angehalten , bis es Platz gibt
			System.out.println("7. quue : "+ queue );   // [ 13 , 14, 17 ]
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		 * การลบ (Remove): 
		 * 
		 * remove , poll , take
		 * 	 
		 * - remove(): ลบข้อมูลจากคิว ถ้าคิวว่างจะโยน NoSuchElementException
		 * - poll(): ลบข้อมูลจากคิว ถ้าคิวว่างจะคืน null
		 * - take(): ลบข้อมูลจากคิว ถ้าคิวว่างจะบล็อกจนกว่าจะมีข้อมูล
		 * - poll(time, unit): ลบข้อมูลจากคิว ถ้าคิวว่างจะบล็อกจนกว่าจะมีข้อมูลหรือตามเวลาที่กำหนด
		 */
		
		Integer x = queue.remove();
		System.out.println("remove(): " + x);		   // 13
		
		x = queue.poll();
		System.out.println("poll(): " + x );		    // 14
		
		
		try {
			x =  queue.take();
			System.out.println("take(): " + x );		// 17
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		System.out.println("8. queue: " + queue);		// []
		
		try {
			queue.remove();
		} catch (NoSuchElementException e) {
			System.out.println("9. Exception! Die Schlange ist leer.");
		}
		
		System.out.println("10. peek(): " + queue.peek());		// null
		
		/*
		 * E take() throws InterruptedException
		 */
		new Thread(()-> {
			kurzPause(3000);
			System.out.println("12. extra-Thread speichert 18 in der Schlange");
			queue.offer(18);
		}).start();
		
		try {
			System.out.println("11. main-Thread ruft queue.take() auf");
			x = queue.take();
			System.out.println("13. main bekommt das Element aus take(): " + x);	// 18
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("14. queue: " + queue);		// []
		
		/*
		 * boolean offer(E e,
		 *               long timeout,
		 *               TimeUnit unit)
		 * throws InterruptedException
		 * 
		   - wenn es in der Queue Platz gibt, funktioniert die Methode 
       		  wie die 'normale' offer
       		  
       		- wenn die Queue voll ist, wird die Methode (wie put)
       		  den Thread anhalten, bis es den Platz gibt, 
       		  aber nicht länger als timeout.
       		  
		 * - ถ้าคิวมีที่ว่าง เมธอดนี้จะทำงานเหมือนกับ `offer` ปกติ
		 * - ถ้าคิวเต็ม เมธอดนี้จะบล็อกเธรดจนกว่าจะมีที่ว่าง (เหมือนกับ `put`) 
		 *   แต่จะไม่บล็อกนานเกินกว่าระยะเวลาที่กำหนด (`timeout`).
		 */

		/*
		 * E poll(long timeout,
		 *        TimeUnit unit)
		 * throws InterruptedException
		 * 
		 * - wenn die Queue nicht leer ist, funktioniert die Methode
              wie die 'normale' poll.
              
            - wenn die Queue leer ist, wird die Methode (wie take)
              den Thread anhalten, bis in der Queue ein Element erscheint,
              aber nicht länger als timeout.
              
		 * - ถ้าคิวไม่ว่าง เมธอดนี้จะทำงานเหมือนกับ `poll` ปกติ
		 * - ถ้าคิวว่าง เมธอดนี้จะบล็อกเธรดจนกว่าจะมีข้อมูลในคิว (เหมือนกับ `take`) 
		 *   แต่จะไม่บล็อกนานเกินกว่าระยะเวลาที่กำหนด (`timeout`).
		 */
		
		
	}	// end if main

	static void kurzPause(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
