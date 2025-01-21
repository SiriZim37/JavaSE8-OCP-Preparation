package threads;



/*
 * ความสำคัญในบริบท OCP Java
 * แนวคิดนี้เกี่ยวข้องกับ Oracle Certified Professional (OCP) Java SE โดยเฉพาะหัวข้อ:
 *
 * Concurrency (การทำงานแบบหลาย Thread พร้อมกัน):
 * - การ Synchronize และความปลอดภัยของ Thread (Thread Safety)
 * - การใช้ Locks และ Monitors
 * - การใช้คำสั่ง synchronized และคลาสใน java.util.concurrent
 *
 * Threads:
 * - วงจรชีวิตของ Thread (Runnable, Thread)
 * - การทำให้ Threads ทำงานร่วมกันอย่างปลอดภัย (ป้องกัน Race Conditions)
 *
 * แนวคิดขั้นสูง:
 * - การใช้ ReentrantLock เพื่อการล็อกที่ยืดหยุ่นและกำหนด timeout ได้
 * - การป้องกัน Deadlock
 * - การใช้ Thread-Safe Collections เช่น ConcurrentHashMap
 */

/*
 * *** การซิงโครไนซ์ (Synchronization):
 * 
 * การใช้ synchronized ในที่นี้จะช่วยให้เธรดหนึ่งตัว (Thread) สามารถเข้าถึงโค้ดที่ 
 * ถูกซิงโครไนซ์ (synchronized) ได้โดยไม่ให้เธรดอื่นๆ เข้าถึงในเวลาเดียวกัน
 * 
 * โดยในตัวอย่างนี้, เมื่อเธรด A และ B ทำงานพร้อมกัน, ทั้งสองจะพยายามเพิ่มค่า
 * ตัวแปร `count` ซึ่งเป็นตัวแปรที่ถูกใช้งานร่วมกัน. หากไม่มีการใช้ `synchronized`,
 * อาจเกิดการเข้าถึงตัวแปร `count` พร้อมกันจากเธรดทั้งสอง ซึ่งอาจทำให้ค่าของ `count` ผิดเพี้ยน.
 * 
 * การใช้ `synchronized` จะช่วยให้:
 * 1. เมื่อเธรดใดตัวหนึ่งเข้ามาทำงานในบล็อกที่ถูกซิงโครไนซ์, เธรดอื่นๆ จะต้องรอ
 *    จนกว่าเธรดแรกจะทำงานเสร็จและปล่อยล็อก.
 * 2. การใช้ `synchronized` ป้องกันไม่ให้เกิดปัญหา **race condition** ซึ่งสามารถ 
 *    ทำให้ตัวแปร `count` มีค่าผิดพลาด.
 */


public class B11_Synchronisiren {
	
	static int count;

	/*
	 * ในโปรแกรมนี้, เธรดสองตัว (Thread A และ Thread B) จะเพิ่มค่าตัวแปร count ทีละ 1,000,000 ครั้ง
	 * แต่เนื่องจากทั้งสองเธรดเข้าถึงตัวแปร count พร้อมกันได้, การซิงโครไนซ์จำเป็นเพื่อหลีกเลี่ยงปัญหา 
	 * การเข้าถึงตัวแปรพร้อมกัน (race condition).
	 *
	 * เมื่อเราใช้คำสั่ง `synchronized`:
	 * 1. เธรด A และ B จะต้องเข้าคิวเพื่อเข้าถึงโค้ดที่มีการซิงโครไนซ์ 
	 *    (บล็อกที่มีคำสั่ง `synchronized`).
	 * 2. เธรดใดก็ตามที่ได้ล็อกจะสามารถเข้าถึงและแก้ไขตัวแปร `count` ได้ 
	 *    จนกว่าจะปล่อยล็อก (release the lock).
	 * 3. ในกรณีนี้, เมื่อเธรด A ได้ล็อกแล้ว มันจะเพิ่มค่า `count` และปล่อยล็อก.
	 * 4. เธรด B จะต้องรอจนกว่าเธรด A ปล่อยล็อกแล้วจึงจะสามารถทำงานได้.
	 * 
	 * ด้วยการใช้ `synchronized`, เราจะมั่นใจได้ว่า `count` จะมีค่าเท่ากับ 2,000,000 
	 * หลังจากการทำงานเสร็จสิ้น, ซึ่งช่วยป้องกันไม่ให้เกิดการเขียนทับข้อมูลจากเธรดที่ 
	 * ทำงานพร้อมกัน (race condition).
	 *
	 * **การใช้ synchronized ป้องกันไม่ให้การทำงานของหลายเธรดมารบกวนกันและกัน** 
	 * โดยจะทำให้แต่ละเธรดต้องรอคิวก่อนที่จะเข้าถึงตัวแปรร่วมกัน.
	 * 
	 * 
     * *** Eine Möglichkeit aus wenigen:
	 * 
	 * Thread A						    Thread B
	 * 
	 *               count(Heap) = 0
	 *               
	 *  erhält den Lock
	 *  
	 *  cpuA = 0
	 *  cpuA + 1 = 1
	 *  count = cpuA
	 *   
	 *  gibt den Lock frei
	 *  
	 *               count(Heap) = 1
	 * 
	 *                                  erhält den Lock
	 *                                  
	 *                                  cpuB = 1
	 *                                  cpuB + 1 = 2
	 *                                  count = cpuB
	 *                                  
	 *                                  gibt den Lock frei
	 *                                  
	 *               count(Heap) = 2
	 *               
	 *                
	 */
	public static void main(String[] args) throws InterruptedException {
		
		Object monitor = new Object();

		Runnable taskInc = () -> {
			for (int i = 0; i < 1_000_000; i++) {
				
				// Kritischer Block:
				synchronized (monitor) { 
					count++; 
				}				
			}
		};

		Thread tA = new Thread(taskInc);
		Thread tB = new Thread(taskInc);
		
		tA.start();
		tB.start();
		
		tA.join();
		tB.join();
		
		System.out.println("count: " + count); // 2000000
	}
}
