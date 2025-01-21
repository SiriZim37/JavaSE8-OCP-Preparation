package concurrency;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class B13_ExecutorService_ErgebnisseAbwarten {
 
	
	public static void main(String[] args) throws Exception{
		
		bsp1();
		bsp2();
		bsp3();
	}
	
	/*
	 * Anhalten bis mehrere Tasks fertig sind
	 */
	  /*
     * ตัวอย่างนี้แสดงการรอจนกว่าทุกงานใน ExecutorService จะเสร็จสิ้น
     * ใช้ invokeAll() เพื่อให้ main thread รอจนกว่าทุก task ใน Collection จะเสร็จ
     */
	static void bsp3() throws InterruptedException, ExecutionException {  // or Exception
		System.out.println("\n**bsp3");
		ExecutorService service = Executors.newCachedThreadPool();
		
//		Callable<Void> task1 = ()-> { System.out.println("task1"); return null;
//		Callable<Void> task2 = ()-> { System.out.println("task2"); return null;
//		Collection<Callable<Void>> tasks = Arrays.asList(task1 , task2);
		
		// oder 	
		Collection<Callable<Integer>> tasks = Arrays.asList( 
												()-> { System.out.println("task1"); return 111; } , 
												()-> { System.out.println("task2"); return 222; } 
										   );
		// เรียกใช้ invokeAll() ซึ่งจะบล็อค main thread จนกว่าทุก task ใน collection จะเสร็จ
		List<Future<Integer>> future =  service.invokeAll(tasks);		// main anhalten bis die Tasks aus der Collection fertig sind
		
		/*
		 * erst danach geht es weiter Folgende Ausgaben sind garantiert: 
		 * 
		 * true 111
		 * true 222
		 */
		 /*
         * หลังจากนั้น main thread จะทำงานต่อ:
         * เราจะใช้ Future.isDone() เพื่อดูว่างานนั้นเสร็จสมบูรณ์แล้วหรือไม่
         * และใช้ get() เพื่อดึงผลลัพธ์จาก task
         */
		for (Future<Integer> f : future) {
			System.out.println( f.isDone() + " "	// garantiert true  
								+ f.get());		
		}
		
		
		System.out.println("End Task");
		service.shutdown();
		
		
	}
	
	/*
	 * Anhalten , bis eine Task fertig ist
	 */
	  /*
     * ตัวอย่างนี้แสดงการรอจนกว่างานหนึ่งจะเสร็จ
     * ใช้ submit() เพื่อส่ง task ไปที่ ExecutorService และรอผลลัพธ์จาก Future
     */
	static void bsp2() throws InterruptedException, ExecutionException {  // or Exception
		System.out.println("\n**bsp2");
		ExecutorService service = Executors.newCachedThreadPool();
		
		Callable<String> task = () ->{
			System.out.println("task");
			return "mo";
		};
		
		// ส่งงานไปยัง ExecutorService และรับ Future เพื่อรอผลลัพธ์
		Future<String> future = service.submit(task);
		
	    // รอจนกว่างานจะเสร็จ และดึงค่าผลลัพธ์ที่ส่งกลับจาก task
		String result = future.get();
		System.out.println(result);		// mo
		
		// es wird task innerhalb 60 Sek bleiben
		service.shutdown();
	}
	
	/*
	 * Anhalten , bis die Threads vom ExecutorService beendet sind
	 */
	 /*
     * ตัวอย่างนี้แสดงการรอให้ทุก thread ที่ถูกสร้างขึ้นใน ExecutorService เสร็จ
     * โดยใช้ awaitTermination() เพื่อบล็อค main thread จนกว่าทุก thread จะสิ้นสุดการทำงาน
     */
	static void bsp1() {
		System.out.println("***bsp1");
		ExecutorService service = Executors.newCachedThreadPool();
		
		 // ส่งงานไปยัง ExecutorService ซึ่งจะทำงานใน thread pool
		service.execute(()-> System.out.println("task 1"));
		service.execute(()-> System.out.println("task 2"));
		//...
		
		service.shutdown();   	// muss sein vor awaitTermination , sonst werden
								// die Thread nicht beendet
								// ต้องเรียก shutdown ก่อน awaitTermination, ถ้าไม่เรียก service จะไม่หยุดรับงานใหม่
		try {
			
			/*
			 * Den main-Thread maximal 1 Tag anhalten.
			 * Wenn die Threads vom Service beendet wurden, geht die main weiter. 
			 */
			  /*
             * ทำให้ main thread หยุดรอสูงสุด 1 วัน จนกว่างานทั้งหมดใน ExecutorService จะเสร็จ
             * ถ้าทุก thread เสร็จภายในเวลาที่กำหนด, main thread จะทำงานต่อ
             */
			service.awaitTermination(1, TimeUnit.DAYS);
			System.out.println("main nach awaitTermination"); //ถ้าทุกงานเสร็จ, ข้อความนี้จะถูกแสดง
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
