package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class B12_ExecutorService_shutdown {
 
	/*
	 * Hier ist prüfung Relavant! 
	 * Exam!
	 * 
	 * newSingleThreadExecutor und newFixedThreadPool beenden 
	 * ihre Threads nicht, wenn es keine shutdown/shutdownNow gibt.
	 * Die Anwendung wird nicht beendet, auch wenn alle registrierten 
	 * Tasks fertig sind.
	 */
	
	/*
	 * Prüfung Relevant! 
	 * 
	 * Aufgabe:
	 * - Überprüfen des Verhaltens von `newSingleThreadExecutor` und `newFixedThreadPool` 
	 * 	 in Bezug auf das Beenden von Threads.
	 * - Ohne Aufruf von `shutdown()` oder `shutdownNow()` bleiben die Threads im ExecutorService aktiv.
	 * - Die Anwendung wird nicht automatisch beendet, wenn der ExecutorService nicht heruntergefahren wird.
	 */
	

	public static void main(String[] args) {
		
		test_shutdown();
//		test_shutdownNow();
		
	}
	
	/*
	 * การสร้าง ExecutorService:
	 * ใช้ Executors.newFixedThreadPool(4) เพื่อสร้าง Thread Pool ขนาด 4 ซึ่งหมายความว่า 
	 * จะมีการทำงานพร้อมกันได้สูงสุด 4 Thread ในเวลาเดียวกัน
	 * 
	 * การสร้าง Callable Task:
	 * งานนี้จะทำการหน่วงเวลา 2 วินาทีโดยใช้ Thread.sleep(2000) และแสดงข้อความก่อนและหลังการหน่วงเวลา
	 * 
	 * การส่งงานไปยัง ExecutorService:
	 * ใช้ service.submit(task) เพื่อลงทะเบียนงานให้ทำงานใน Thread Pool โดยเมธอด submit() 
	 * จะส่งคืน Future ที่สามารถใช้เพื่อตรวจสอบผลลัพธ์ของงานที่เสร็จสมบูรณ์หรือเกิดข้อผิดพลาด
	 * 
	 * การเรียก shutdownNow():
	 * หลังจากเรียกใช้ service.shutdownNow() จะพยายามหยุดการทำงานของ Task ที่กำลังทำอยู่
	 * และจะไม่สามารถลงทะเบียนงานใหม่ได้
	 * 
	 * การทดสอบ execute() หลังจาก shutdownNow():
	 * เมื่อลองเรียกใช้ service.execute() เพื่อส่งงานใหม่หลังจาก shutdownNow() แล้วจะเกิดข้อผิดพลาด
	 * เพราะไม่สามารถลงทะเบียนงานใหม่หลังจากเรียก shutdownNow()
	 * 
	 * การจับข้อผิดพลาด:
	 * ใช้ try-catch เพื่อจับข้อผิดพลาดที่เกิดขึ้นเมื่อพยายามส่งงานใหม่หลังจาก shutdownNow()
	 * โดยจะแสดงข้อความแสดงข้อผิดพลาดในกรณีนี้
	 * 
	 * โค้ดนี้แสดงตัวอย่างการใช้ shutdownNow() เพื่อหยุดการรับงานใหม่ 
	 * และการจัดการข้อผิดพลาดที่เกิดขึ้นเมื่อพยายามส่งงานใหม่หลังจากนั้น
	 */
	
	static void test_shutdownNow() {
		System.out.println("\n***shutdownNow");
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		
		Callable<Void> task = ()->{
			System.out.println("task VOR sleep");
			Thread.sleep(2000);	 // programmier auf InterruptedException
			System.out.println("task NACH sleep");
			return null;
		};
		
		System.out.println("main registriert die Task");
		service.submit(task);
		service.submit(task);
		
		System.out.println("main ruft shutdown auf");
		
		service.shutdownNow();		// - alle bereits laufenden(aktiviereten) Tasks versucht 
									//    das Service abzubrechen (mit InterruptedException-Technik)
									// - die registrierten aber noch nicht aktivierten Tasks werden verworfen
									// - keine weitere Tasks können danach registriert werden
		/*
		 * 1.พยายามยกเลิกงานที่กำลังทำอยู่: ถ้ามีงานที่กำลังทำอยู่ (active tasks) ในขณะนั้น shutdownNow() 
		 *   จะพยายามยกเลิกงานเหล่านั้น โดยใช้เทคนิค InterruptedException เพื่อหยุดการทำงานของ threads ที่กำลังทำงานอยู่
		 * 
		 * 2.ทิ้งงานที่ยังไม่ได้เริ่ม: ถ้ามีงานที่ถูกส่งไปยัง ExecutorService แต่ยังไม่ได้ถูกเริ่มทำ (tasks ที่ยังไม่ได้ทำงาน) งานเหล่านั้นจะถูกลบออกจากคิว และจะไม่ถูกทำงาน
		 * 
		 * 3. ไม่สามารถลงทะเบียนงานใหม่ได้: หลังจากที่เรียกใช้ shutdownNow() แล้ว จะไม่สามารถลงทะเบียนงานใหม่ได้กับ ExecutorService นั้นๆ
		 *    ดังนั้นหากพยายามใช้ submit() หรือ execute() เพื่อส่งงานใหม่ จะเกิดข้อผิดพลาด
		 */
		try {
			//พยายามเรียกใช้งาน execute() เพื่อส่งงานใหม่
			service.execute(()->{});
		} catch (Exception e) {
			System.err.println("Exception in main. " 
								+ "Keine weitere Tasks können registieret werden" );	
		}
		System.out.println("main ist vorbei");
		
	}


	/*
	 * การสร้าง ExecutorService:
	 * ใช้ Executors.newFixedThreadPool(4) เพื่อสร้าง Thread Pool ขนาด 4 ซึ่งหมายความว่า 
	 * จะมีการทำงานพร้อมกันได้สูงสุด 4 Thread ในเวลาเดียวกัน
	 * 
	 * การสร้าง Callable Task:
	 * งานนี้จะทำการหน่วงเวลา 2 วินาทีโดยใช้ Thread.sleep(2000) และแสดงข้อความก่อนและหลังการหน่วงเวลา
	 * 
	 * การส่งงานไปยัง ExecutorService:
	 * ใช้ service.submit(task) เพื่อลงทะเบียนงานให้ทำงานใน Thread Pool โดยเมธอด submit() 
	 * จะส่งคืน Future ที่สามารถใช้เพื่อตรวจสอบผลลัพธ์ของงานที่เสร็จสมบูรณ์หรือเกิดข้อผิดพลาด
	 * 
	 * การเรียก shutdown():
	 * หลังจากที่เรียกใช้ service.shutdown() จะไม่สามารถส่งงานใหม่ไปยัง ExecutorService ได้ 
	 * แต่จะทำงานที่ลงทะเบียนไว้จนเสร็จสิ้น
	 * 
	 * การทดสอบ execute() หลังจาก shutdown():
	 * เมื่อพยายามใช้ service.execute() เพื่อส่งงานใหม่หลังจาก shutdown() แล้วจะเกิดข้อผิดพลาด 
	 * เพราะเมธอด execute() ไม่สามารถรับงานใหม่หลังจาก shutdown() ถูกเรียกแล้ว
	 * 
	 * การจับข้อผิดพลาด:
	 * ใช้ try-catch เพื่อจับข้อผิดพลาดที่เกิดขึ้นเมื่อพยายามส่งงานใหม่หลังจาก shutdown() 
	 * โดยจะแสดงข้อความแจ้งข้อผิดพลาดในกรณีนี้
	 * 
	 * โค้ดนี้แสดงตัวอย่างการใช้ ExecutorService พร้อมทั้งการหยุดการรับงานใหม่ 
	 * หลังจากที่เรียกใช้ shutdown() และการจัดการข้อผิดพลาดที่เกิดจากการส่งงานใหม่หลังจากนั้น
	 */
	static void test_shutdown() {
		
		System.out.println("***shutdown");

		ExecutorService service = Executors.newFixedThreadPool(4);
		
		Callable<Void> task = ()->{
			System.out.println("task VOR sleep");
			Thread.sleep(2000);
			System.out.println("task NACH sleep");
			return null;
		};
		
		System.out.println("main registriert die Task");
		service.submit(task);
		service.submit(task);
		
		System.out.println("main ruft shutdown auf");
		
		service.shutdown();		// - alle bereits registrierten Tasks werden garantiert aktiviert
								//   (erden gestatet , auch wenn es noch nicht gescheinen ist)
								// - keine weitere Tasks können danach registriert werden
		/*
		 * 1. ทำงานที่ลงทะเบียนไว้แล้วทั้งหมดจะได้รับการทำงาน: ทุกๆ งาน (task) ที่ได้ลงทะเบียนกับ ExecutorService 
		 *   ไว้ก่อนหน้านี้จะได้รับการทำงานต่อไปจนเสร็จสมบูรณ์ ไม่ว่าจะเป็นงานที่ยังไม่เริ่มทำหรือกำลังทำงานอยู่
		 *   
		 * 2.ไม่สามารถลงทะเบียนงานใหม่ได้อีก: หลังจากที่เรียกใช้ shutdown(), จะไม่สามารถส่งงานใหม่เข้าไปใน 
		 *   ExecutorService ได้อีก โดยถ้าพยายามใช้ submit() หรือ execute() เพื่อส่งงานใหม่ 
		 *   จะไม่ได้รับการยอมรับ และจะเกิดข้อผิดพลาด
		 */
		
		try {
			//พยายามเรียกใช้งาน execute() เพื่อส่งงานใหม่
			service.execute(()->{});
		} catch (Exception e) {
			System.err.println("Exception in main. " 
								+ "Keine weitere Tasks können registieret werden" );	
		}
		System.out.println("main ist vorbei");
	}
}
