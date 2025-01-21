package concurrency;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class B10_ExecutorService_Strategie {


	/**
	 * **newFixedThreadPool, newCachedThreadPool และ newSingleThreadExecutor**
	 * เป็นส่วนหนึ่งของ Java Executor Framework สำหรับสร้าง Thread Pool ที่ช่วยจัดการ Threads อย่างมีประสิทธิภาพ 
	 * โดย Thread Pools แต่ละประเภทมีพฤติกรรมและสถานการณ์ที่เหมาะสมแตกต่างกัน:
	 * 
	 * 1. **newFixedThreadPool(int nThreads):**
	 *    - สร้าง Thread Pool ที่มีจำนวน Threads คงที่ตามที่กำหนดใน `nThreads`
	 *    - เหมาะสำหรับงานที่มีจำนวน Tasks คงที่หรือโหลดงานคาดการณ์ได้
	 *    - ถ้า Tasks มากกว่า Threads ที่กำหนดไว้ Tasks ที่เหลือจะถูกจัดคิว (Queue) และรอ
	 *    - **การจัดการ:**
	 *      - ใช้ `shutdown()` เพื่อหยุดรับงานใหม่แต่ให้ทำงานที่เหลือเสร็จ
	 *      - ใช้ `shutdownNow()` เพื่อพยายามหยุดงานทั้งหมดทันที
	 *    - **ตัวอย่าง:**
	 *      ```java
	 *      ExecutorService executor = Executors.newFixedThreadPool(3);
	 *      executor.shutdown(); // ปิด Thread Pool หลังใช้งาน
	 *      ```
	 * 
	 * 2. **newCachedThreadPool():**
	 *    - สร้าง Thread Pool ที่ปรับขนาดได้ โดยเพิ่ม Threads ใหม่ตามความต้องการ
	 *    - Threads ที่ไม่ได้ใช้งานนานกว่า 60 วินาทีจะถูกลบออกอัตโนมัติ
	 *    - เหมาะสำหรับงานที่โหลดผันผวนหรือ Tasks จำนวนมากขนาดเล็ก
	 *    - **ข้อควรระวัง:** ถ้ามี Tasks ไม่จำกัด อาจทำให้เกิดปัญหาการใช้ทรัพยากรเกินความจำเป็น
	 *    - **การจัดการ:**
	 *      - ใช้ `shutdown()` หรือ `shutdownNow()` เพื่อปิด Thread Pool อย่างชัดเจน
	 *    - **ตัวอย่าง:**
	 *      ```java
	 *      ExecutorService executor = Executors.newCachedThreadPool();
	 *      executor.shutdown(); // ปิด Thread Pool หลังใช้งาน
	 *      ```
	 * 
	 * 3. **newSingleThreadExecutor():**
	 *    - สร้าง Thread Pool ที่มีเพียง 1 Thread สำหรับดำเนินการทั้งหมดแบบ Sequential
	 *    - Tasks จะถูกดำเนินการตามลำดับการส่งเข้า (FIFO)
	 *    - เหมาะสำหรับงานที่ต้องการความปลอดภัยจากการทำงานพร้อมกัน (Thread Safety)
	 *    - **การจัดการ:**
	 *      - ใช้ `shutdown()` หรือ `shutdownNow()` เพื่อหยุด Thread Pool
	 *    - **ตัวอย่าง:**
	 *      ```java
	 *      ExecutorService executor = Executors.newSingleThreadExecutor();
	 *      executor.shutdown(); // ปิด Thread Pool หลังใช้งาน
	 *      ```
	 * 
	 * **ข้อควรรู้สำคัญสำหรับ OCP Exam:**
	 * - **newFixedThreadPool:** จำนวน Threads คงที่ เหมาะกับงานที่โหลดงานแน่นอน
	 * - **newCachedThreadPool:** ปรับขนาดได้ เหมาะกับงานโหลดผันผวนหรืองานขนาดเล็กจำนวนมาก
	 * - **newSingleThreadExecutor:** ใช้สำหรับงาน Sequential ที่ต้องการ Thread เดียว
	 * - Thread Pools ทั้งหมดต้องปิดด้วย `shutdown()` หรือ `shutdownNow()` หลังใช้งาน เพื่อป้องกันการใช้ทรัพยากรเกิน
	 * 
 	 * **สิ่งสำคัญสำหรับ OCP Exam:**
	 * - เข้าใจพฤติกรรมและสถานการณ์ที่เหมาะสมสำหรับ Thread Pool แต่ละประเภท
	 * - รู้จักข้อดี-ข้อเสียและผลกระทบของการใช้ Thread Pools
	 * - การเลือก Thread Pool ที่เหมาะสมช่วยให้แอปพลิเคชันมีประสิทธิภาพและประหยัดทรัพยากร
	 */
	
	/**
	 * **newCachedThreadPool**, **newFixedThreadPool**, และ **newSingleThreadExecutor** 
	 * จะทำงานต่อไปจนกว่าจะปิดด้วย `shutdown()` หรือ `shutdownNow()`
	 * ผู้พัฒนาต้องปิด Thread Pool หลังใช้งานเสร็จเพื่อหลีกเลี่ยงการใช้ทรัพยากรเกินจำเป็น
	 * 
	 * 1. **ไม่มีการปิดอัตโนมัติ**: ต้องเรียก `shutdown()` หรือ `shutdownNow()` เพื่อปิด
	 * 2. **รีไซเคิล Threads**: Threads ที่ไม่ได้ใช้งานจะถูกลบหลังจาก 60 วินาที (newCachedThreadPool)
	 * 3. **การปิด Thread Pool**: เรียก `shutdown()` เพื่อหยุดรับงานใหม่และรอให้เสร็จ
	 * 4. **หลีกเลี่ยง Memory Leak**: การไม่ปิดอาจทำให้เกิดการรั่วไหลของทรัพยากร
	 * 
	 * สรุป: ต้องปิด Thread Pool หลังใช้งานเสร็จเพื่อหลีกเลี่ยงปัญหาทรัพยากรเกินจำเป็น
	 */

	
	
	public static void main(String[] args) {
		

		/*
		 * newSingleThreadExecutor:
		 * 
		 * 		- hat einen extra-Thread
		 * 		- wenn der Thread gerade beschäftigt ist, wird die
		 *        weitere registrierte Task in einer Warteschlange 
		 *        gespeichert.
		 */ 
		ExecutorService service = Executors.newSingleThreadExecutor();
//		taskRegistrieren(service);
		
		
		
		/*
		 * newFixedThreadPool:
		 * 
		 * 		- hat n extra-Threads
		 * 		- wenn alle Threads gerade beschäftigt sind, wird die
		 *        weitere registrierte Task in einer Warteschlange 
		 *        gespeichert.
		 * 
		 */
		int nThreads = Runtime.getRuntime().availableProcessors();	// Bsp: Anzahl der CPUs
		service = Executors.newFixedThreadPool(nThreads);
//		taskRegistrieren(service);
		
		/*
		 *  newCachedThreadPool
		 *  
		 *  สร้าง Thread ใหม่ตามความต้องการ:
		 *  	- erzeugt bei Bedarf einen neuen Thread,
		 *       wenn eine neue Task registriert wird und es 
		 *       keinen freien Thread im Thread-Pool gibt,
		 *       ansonsten wird für die neue registrierte Task
		 *       ein freier Thread aus dem Thread-Ool wiederverwendet.      
		 *      ( - เมื่อมีการลงทะเบียน task ใหม่ (งานใหม่) และหากไม่พบ Thread ที่ว่างใน Thread Pool, 
		 *          ระบบจะสร้าง Thread ใหม่ขึ้นมาเพื่อทำงานนั้น
		 *        - หากมี Thread ว่างใน Thread Pool อยู่แล้ว งานใหม่จะถูกมอบหมายให้กับ 
		 *        Thread ที่ว่างนั้น (ไม่ต้องสร้าง Thread ใหม่ )
		 *        
		 *  การจัดการ Thread หลังจากทำงานเสร็จ:
		 *  	- wenn ein Thread mit seiner Task fertig ist,
		 *        wird der Thread für eine bestimmte Zeil (60 Sek)
		 *        in dem Thread-Pool noch erhalten.
		 *        (เมื่อ Thread ทำงานเสร็จแล้วและไม่ได้ถูกใช้งานในช่วงเวลาหนึ่ง (60 วินาที) 
		 *         ระบบจะเก็บ Thread นั้นไว้ใน Thread Pool ต่อไป แต่ถ้าไม่มีการใช้งานในระยะเวลา 60 วินาที
		 *         Thread นั้นจะถูกลบออกจาก Thread Pool)
		 *        
		 *    aus Doku: "Threads that have not been used for sixty seconds 
		 *               are terminated and removed from the cache"
		 */
		
		service = Executors.newCachedThreadPool();
		taskRegistrieren(service);
		
		
	} // end of main 
	
	static void taskRegistrieren(ExecutorService service) {
		
		Set<String> setThreadNamed = new ConcurrentSkipListSet<>();
		/*
		 * 100 Tasks dem ExecutorService übergeben
		 * damit sie in den Thread des ExecutorServices ausgeführt werden
		 */
		for(int i = 0 ; i < 100 ; i++) {
			int taskNr = i;
			Runnable task = ()  -> {
				String threadName = Thread.currentThread().getName();
				System.out.println("Task " + taskNr + " in Thread " + threadName );
				
				setThreadNamed.add(threadName);	// später will ich wissen, welche Threads es gab
			};
			service.execute(task);
		}
		/*
		 * Das Serviceherunterfahren  !!!!!!!!!! Vergiss nicht
		 * Stops accepting new tasks but completes already submitted tasks.
		 * หยุดรับงานใหม่ แต่รันงานในคิวให้เสร็จ
		 */
		service.shutdown();
		
		try {
			// abwarten, dass die registreirten Tasks erledigt sind
			service.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("aktive Threads: " + setThreadNamed.size());
	}
}
