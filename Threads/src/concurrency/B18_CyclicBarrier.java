package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class B18_CyclicBarrier {
 
	/*
	 * CyclicBarrier เป็นคลาสใน Java (java.util.concurrent) ที่ใช้สำหรับ 
	 * การประสานงาน (synchronization) ระหว่างเธรดหลายตัว โดยทำหน้าที่เป็น "จุดกั้น" (Barrier)
	 * ที่เธรดทุกตัวต้องมาถึงก่อนดำเนินการต่อพร้อมกัน
	 * 
	 * คุณสมบัติสำคัญของ CyclicBarrier:
	 * 1. กำหนดจำนวนเธรดที่ต้องรอ: เมื่อสร้าง CyclicBarrier ต้องระบุจำนวนเธรด เช่น 3 เธรด
	 * 2. เธรดเรียกเมธอด await(): ทุกเธรดต้องเรียก await() เพื่อรอให้ทุกเธรดมาถึง Barrier
	 * 3. Barrier ใช้ซ้ำได้: เมื่อเธรดทั้งหมดมาถึง Barrier แล้ว จะรีเซ็ตตัวเองโดยอัตโนมัติ
	 * 
	 * ตัวอย่างการใช้งาน:
	 * ใช้ในงานที่ต้องให้เธรดหลายตัวทำงานพร้อมกัน เช่น การคำนวณแบบขนาน
	 */

	public static void main(String[] args) throws InterruptedException {
		
		int parties = 3; // 3 Threads sinf nötig um die Barriere zu durchbrechen
		
		// Die Barrier-Action wird in dem Thread ausgeführt.
		// der die Barriere durchbricht
		//กำหนด barrierAction ซึ่งจะถูกรันเมื่อ Threads ทั้งหมดผ่าน Barrier แล้ว
		//ข้อความ "Die Barriere ist durchbrochen!" จะถูกพิมพ์ออกเมื่อ Barrier ถูกปลดล็อก
		Runnable barrierAction = () -> {
			Thread th = Thread.currentThread();
			System.out.println("Die Barriere ist vom Thread "
					+ th.getName() + " durchbrochen!");
		};
		
		//สร้าง Barrier ที่ต้องรอ Threads 3 ตัว (parties) และรัน barrierAction เมื่อ Barrier ถูกผ่าน
		CyclicBarrier barrier = new CyclicBarrier(parties , barrierAction);
		
		/*
		 * public int await() throws InterruptedException, BrokenBarrierException
		 */
		/*
		 * task เป็น Runnable ที่จะถูกส่งไปยังแต่ละ Thread:
		 * พิมพ์ข้อความก่อน Threads จะถึง Barrier ("VOR der Barriere")
		 * เรียก barrier.await() เพื่อรอให้ Threads ทั้งหมดมาถึง Barrier
		 * เมื่อ Threads ทั้งหมดมาถึง Barrier ข้อความ "NACH der Barriere" จะถูกพิมพ์ออก
		 */
		Runnable task = () ->{
			Thread th = Thread.currentThread();
			
			try {
				System.out.println(th.getName() + " VOR der Barriere");
				
				// der Thread meldet sich bei Barriere und wird angehaltenbis ingesamt 3 Threads es tun 
				barrier.await();	   
					
				System.out.println(th.getName() + " NACH der Barriere");
				
			} catch (BrokenBarrierException | InterruptedException e) {
				e.printStackTrace();
			} 	
		};
		
		
		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();
		System.out.println("\nnoch mal\n");
//		Thread.sleep(2000);
//		System.out.println("\nnoch mal\n");
//		
//		new Thread(task).start();
//		new Thread(task).start();
//		new Thread(task).start();
		
		/*
		 ***** สรุป
		 * 		CyclicBarrier ช่วยในการซิงโครไนซ์ Threads หลายตัว โดยทุกตัวต้องมาถึง Barrier ก่อนดำเนินการต่อ
		 * 		barrierAction จะถูกรันโดย Thread ที่ทำให้ Barrier ถูกปลดล็อก
		 * 		สามารถใช้งาน Barrier ซ้ำได้ในกรณีที่ต้องการทำงานแบบเดิมซ้ำ
		 * 
		 ***** ตัวอย่างการใช้งานจริง
		 *		ใช้ในการแบ่งงานขนาดใหญ่ให้กับ Threads หลายตัว เช่น การคำนวณข้อมูลในหลายส่วนของไฟล์
		 *		เมื่อ Threads ทั้งหมดคำนวณเสร็จที่ Barrier เดียวกันแล้วจึงเริ่มขั้นตอนต่อไป
		 */
	}
}
