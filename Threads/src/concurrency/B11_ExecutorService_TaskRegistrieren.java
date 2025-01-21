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

import org.junit.platform.commons.util.ExceptionUtils;

/**
 * 	 Callable เป็นอินเตอร์เฟซใน Java ที่คล้ายกับ Runnable แต่แตกต่างกันตรงที่ Callable 
 *   สามารถคืนค่า (ผลลัพธ์จาก Task) และโยน Exceptions ได้โดยไม่จำเป็นต้องจับหรือประกาศในเมธอด
 *
 * - เมธอด call() ของ Callable ใช้สำหรับกำหนดงานที่ต้องการทำและจะคืนค่าผลลัพธ์เมื่อเสร็จสิ้น (ต่างจาก Runnable ที่ไม่คืนค่า)
 * - เมธอด call() สามารถโยน Exceptions ได้โดยไม่ต้องจับหรือประกาศในเมธอด
 *
 ****ความแตกต่างระหว่าง ExecutorService และ Callable***
 * 
 * - ExecutorService ใช้สำหรับจัดการ Thread Pool  เช่น newFixedThreadPool() หรือ newCachedThreadPool() เพื่อส่งงาน (task)
 * 
 * - Callable ใช้สำหรับกำหนดงานที่สามารถคืนค่าและสามารถโยน Exceptions ได้
 * 
 * โดยทั่วไป, ExecutorService ใช้เพื่อส่งงานให้กับ Callable หรือ Runnable และรับผลลัพธ์จาก Callable ผ่าน Future
 */
/*
 * Future ใช้สำหรับการสื่อสารทางอ้อมกับ Thread ของ ExecutorService:
 * - Future คือออบเจกต์ที่เกี่ยวข้องกับ Task ที่กำลังทำงานใน Thread ของ ExecutorService
 * - เมื่อส่งงาน (Task) ไปยัง ExecutorService ผ่านเมธอด เช่น `submit()` หรือ `invokeAll()`,
 *   จะได้ Future กลับมาซึ่งสามารถใช้เพื่อติดตามสถานะของงานนั้น
 * 
 * ฟังก์ชันหลักของ Future:
 * - `get()`: ใช้เพื่อดึงผลลัพธ์ของงานหลังจากที่มันเสร็จสิ้น ถ้า Task ยังไม่เสร็จ จะบล็อก (รอ) จนกว่าจะได้ผลลัพธ์
 * - `cancel()`: ใช้ยกเลิกงานที่กำลังทำอยู่
 * - `isDone()`: ใช้ตรวจสอบว่างานเสร็จสิ้นหรือยัง
 * - `isCancelled()`: ใช้ตรวจสอบว่างานถูกยกเลิกหรือไม่
 * 
 * โดยทั่วไป, Future เป็นเครื่องมือที่ช่วยให้เราสามารถจัดการกับการรันงานใน background และติดตามสถานะของงานนั้นได้
 */
 

public class B11_ExecutorService_TaskRegistrieren {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		/*
		 * void execute(Runnable command)
		 */
		
		Runnable task1 = ()-> {
			System.out.println("task 1 im Thread " + Thread.currentThread().getName());
		};
		service.execute(task1);	 // asynchronous
		
		
		//-----------------------------------------------------------------------------------------------//
		
		/*
		 * Future ใช้สำหรับการสื่อสารทางอ้อมกับ Thread ของ ExecutorService:
		 * - Future คือออบเจกต์ที่เกี่ยวข้องกับ Task ที่กำลังทำงานใน Thread ของ ExecutorService
		 * - เมื่อส่งงาน (Task) ไปยัง ExecutorService ผ่านเมธอด เช่น `submit()` หรือ `invokeAll()`,
		 *   จะได้ Future กลับมาซึ่งสามารถใช้เพื่อติดตามสถานะของงานนั้น
		 * 
		 * ฟังก์ชันหลักของ Future:
		 * - `get()`: ใช้เพื่อดึงผลลัพธ์ของงานหลังจากที่มันเสร็จสิ้น ถ้า Task ยังไม่เสร็จ จะบล็อก (รอ) จนกว่าจะได้ผลลัพธ์
		 * - `cancel()`: ใช้ยกเลิกงานที่กำลังทำอยู่
		 * - `isDone()`: ใช้ตรวจสอบว่างานเสร็จสิ้นหรือยัง
		 * - `isCancelled()`: ใช้ตรวจสอบว่างานถูกยกเลิกหรือไม่
		 * 
		 * โดยทั่วไป, Future เป็นเครื่องมือที่ช่วยให้เราสามารถจัดการกับการรันงานใน background และติดตามสถานะของงานนั้นได้
		 */
		
		/*
		 *  <T> Future<T> submit(Callable<T> task);
		 */
		Callable<Void> task2 = () -> {
			System.out.println("task 2 im Thread " + Thread.currentThread().getName());
			return null;
		};
		Future<Void> future2 =	service.submit(task2);	// asynchron
		
			
		/*
		 * Future fürs indirekte KOmmunizieren mit dem Thread
		 * des ExecutorService verwenden: 
		 * Future-Objekt bezieht sich auf seine Task! 
		 */	
		
		//  โค้ดตัวอย่างนี้ใช้ `Callable` และ `Future` เพื่อทำงานแบบ asynchronous และ synchronous:		
		Callable<Integer> task3 = ()-> {
			System.out.println("task 3 erzeugt ein Integer...");
			return 42;
		};
		
		Callable<String> task4 = ()-> {
			System.out.println("task 3 erzeugt ein Integer...");
			return "Hello";
		};
		
		Future<Integer> future3 = service.submit(task3);    // asynchron
		Future<String> future4 = service.submit(task4);     // asynchron
		try {
			Integer resultOfCall = future3.get(); 			// synchron: main-Thread anhalten, bis task3 fertig ist

			System.out.println("resultOfCall in dem main-Thread erhalten: " 
								+ resultOfCall);		// 42
			
			String resultStringOfCall = future4.get(); 		// synchron: main-Thread anhalten, bis task4 fertig ist
				
			System.out.println("resultStringOfCall in dem main-Thread erhalten: " 
								+ resultStringOfCall);	// Hello
			
		} catch (InterruptedException | ExecutionException e) {
			/*
			 * มื่อใช้ future.get(), คุณไม่สามารถคาดเดาได้ว่าการทำงานใน Callable จะสำเร็จหรือไม่ 
			 * ดังนั้นการใช้ try-catch block เพื่อจัดการกับ InterruptedException และ ExecutionException จึงเป็นสิ่งสำคัญ
			 * - ExecutionException มักเกิดขึ้นจากข้อผิดพลาดในตัวงานเอง เช่น การโยนข้อผิดพลาดจากภายใน call() ของ Callable, 
			 * - InterruptedException มักจะเกิดจากการหยุดการทำงานของ Thread ระหว่างการทำงานใน ExecutorService
			 */
			e.printStackTrace();
		}
		 
		//-----------------------------------------------------------------------------------------------//
		
		/*
		 *  <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
		 *  			throws InterruptedException;
		 *  
		 *  เมธอด invokeAll() จะรับค่าเป็น Collection ของ Callable objects (ที่เป็นงานหรือ tasks ที่ต้องการให้ทำงาน) 
		 *  และจะส่งคืน List ของ Future objects ที่ใช้สำหรับเก็บผลลัพธ์จากงานที่ทำงานเสร็จแล้ว
		 *  
		 *  invokeAll() ใช้สำหรับจัดการหลายๆ task พร้อมกัน โดยรอให้ทุกๆ task เสร็จสิ้นก่อนที่จะดำเนินการต่อ 
		 *  เมธอดนี้จะบล็อกจนกว่าทุกๆ task ใน Collection จะเสร็จและสามารถดึงผลลัพธ์ออกมาได้จาก Future ที่ได้รับจาก invokeAll().
		 */
		
		Callable<Character> taskA = ()-> {
			System.out.println("task A erzeugt ein Integer...");
			return 'A';
		};
		
		Callable<Character> taskB = ()-> {
			System.out.println("task B erzeugt ein Integer...");
			return 'B';
		};
		
		Collection<Callable<Character>> tasks = Arrays.asList(taskA ,taskB);
		
		
		try {
			
			List<Future<Character>> future = service.invokeAll(tasks);	
												// synchron! main Thread wird angahalten , bis 
												// alle Tasks aus der Collection fertig sind
			
			System.out.println("main: taskA und taskB sind bereits fertig");
			
			/*
			 * คำอธิบายเกี่ยวกับ Future.get()
			 * - เมธอด f.get() จะ บล็อก main thread จนกว่าจะได้ผลลัพธ์จาก task นั้นๆ
			 * - หากเกิดข้อผิดพลาดในระหว่างการทำงานของ Callable จะมีการโยน ExecutionException
			 * - หากการรอคอยถูกขัดจังหวะ (เช่น Thread ถูก interrupt) จะโยน InterruptedException
			 * */
			for (Future<Character> f : future) {
			
				System.out.println(f.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		

		service.shutdown();
		
	}
}
