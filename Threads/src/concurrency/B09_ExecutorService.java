package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

	/**
	 * ExecutorService เป็นอินเทอร์เฟซในแพ็กเกจ java.util.concurrent และเป็นส่วนสำคัญของ 
	 * Executor Framework ที่ช่วยจัดการ Threads ได้อย่างมีประสิทธิภาพและสะดวกยิ่งขึ้น
	 * โดยช่วยให้สามารถควบคุมและจัดการงานที่ทำงานพร้อมกัน (Concurrent Tasks) ได้ง่าย
	 *
	 * คุณสมบัติสำคัญของ ExecutorService:
	 * 
	 * 1. การจัดการ Thread Pool
	 *    - ช่วยสร้างและจัดการ Thread Pool ที่สามารถนำมาใช้ซ้ำได้ ลดภาระการสร้าง Threads ใหม่ 
	 *      ซึ่งสิ้นเปลืองทรัพยากร
	 * 
	 * 2. การส่งงานให้ Threads
	 *    - execute(Runnable): ส่งงานแบบไม่มีผลลัพธ์ (Fire-and-Forget)
	 *    - submit(Runnable/Callable): ส่งงานและคืนค่า Future สำหรับดึงผลลัพธ์หรือจัดการข้อผิดพลาด
	 * 
	 * 3. การหยุดการทำงาน (Shutdown)
	 *    - shutdown(): หยุดรับงานใหม่ แต่ยังรันงานในคิวให้เสร็จ
	 *    - shutdownNow(): พยายามหยุดงานทั้งหมดทันทีและล้างคิวงานที่รอ
	 * 
	 * 4. รองรับงานแบบ Parallel
	 *    - invokeAll(Collection<Callable>): รันงานทั้งหมดและคืนค่ารายการของ Future
	 *    - invokeAny(Collection<Callable>): รันงานและคืนค่าผลลัพธ์ของงานแรกที่เสร็จสมบูรณ์
	 * 

						Method						Description
		execute(Runnable)					Submits a Runnable task for execution.
											ส่งงานแบบไม่มีผลลัพธ์ (Runnable) ให้ Thread Pool
		-----------------------------------------------------------------------------------------------------------------
		submit(Runnable/Callable)			Submits a task and returns a Future object for result retrieval.
											ส่งงานแบบมีผลลัพธ์ (Runnable หรือ Callable) และคืนค่า Future
		-----------------------------------------------------------------------------------------------------------------
		shutdown()							Stops accepting new tasks but completes already submitted tasks.
											หยุดรับงานใหม่ แต่รันงานในคิวให้เสร็จ
		-----------------------------------------------------------------------------------------------------------------
		shutdownNow()						Attempts to stop all running tasks immediately.
											หยุดงานทั้งหมดทันทีและล้างคิวงานที่รอ
		-----------------------------------------------------------------------------------------------------------------
		invokeAll(Collection<Callable>)		Executes all tasks and returns a list of Future objects.
											รันงานทั้งหมดและคืนค่ารายการของ Future
		-----------------------------------------------------------------------------------------------------------------
		invokeAny(Collection<Callable>)		Executes tasks and returns the result of one that completes successfully.
											รันงานและคืนค่าผลลัพธ์ของงานแรกที่เสร็จสมบูรณ์
		-----------------------------------------------------------------------------------------------------------------
	
	 * สิ่งสำคัญสำหรับ OCP Exam:
	 * 
	 * 1. การจัดการ Threads:
	 *    เข้าใจว่า ExecutorService ช่วยลดความซับซ้อนเมื่อเทียบกับการสร้าง Threads โดยตรง (Thread Class)
	 * 
	 * 2. วิธีส่งงาน:
	 *    เข้าใจความแตกต่างระหว่าง execute() (ไม่มีผลลัพธ์) และ submit() (มีผลลัพธ์)
	 * 
	 * 3. รูปแบบ Thread Pool:
	 *    รู้จัก newFixedThreadPool, newCachedThreadPool และ newSingleThreadExecutor
	 * 
	 * 4. การหยุด Thread Pool:
	 *    เข้าใจผลกระทบของ shutdown() และ shutdownNow() ต่อการทำงานของ Threads
	 * 
	 * 5. Callable และ Future:
	 *    ใช้สำหรับงานที่ต้องการผลลัพธ์หรือจัดการข้อผิดพลาด
	 */
 
public class B09_ExecutorService {

	/*
	 * ExecutorService: Thread Manager. Verwaltet die Threads , die unsere Tasks ausführen.
	 */
	public static void main(String[] args) {
		
		/*
		 * 1. Strategie der Threadverwaltung auswählen
		 */
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		/*
		 * 2. Mit dem ExecutorService arbeiten : die Tasks zum Ausführen 
		 * in den Threads des ExecutorServices übergeben (registieren)
		 */
		
		Runnable task = () -> System.out.println("my task");
		service.execute(task);
		// weitere Tasks registieren...
		
		/*
		 * 3. ExecutorService herunterfahren
		 */
		service.shutdown();
		
		
		sample1();
		
		
		System.out.println("end of main");
		
		
		
	}


	private static void sample1() {
		/*
		 * สร้าง Thread Pool ขนาด 3 Threads โดยใช้ Executors.newFixedThreadPool(3)
		 * ส่งงาน 5 งานไปยัง Thread Pool โดยใช้ execute()
		 * ปิด ExecutorService ด้วย shutdown() เพื่อไม่รับงานใหม่
		 */
		ExecutorService executor = Executors.newFixedThreadPool(3); // สร้าง Thread Pool ขนาด 3 Threads

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());
            });
        }

        executor.shutdown(); // ปิด ExecutorService
		
	}
}
