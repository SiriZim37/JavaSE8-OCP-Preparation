package aufgaben;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class AufgabenThreadsSimpleAPI {

	public static void main(String[] args) {

//		A1();
//		A2();
//		A3();
		A4();
		A4alternativ();
//		A5();
		
	}

	/*
	 * A1() - สร้างเธรดแบบ Infinite Thread
	 * เมธอดนี้จะสร้างคลาสที่ขยายจาก `Thread` และทำการพิมพ์ข้อมูลของเธรดนั้นๆ ทุกๆ วินาที
	 * เมื่อเริ่มต้น เธรดจะทำงานและแสดงข้อความว่า "Thread: id : [หมายเลขเธรด] | Name: [ชื่อเธรด] กำลังทำงาน..."
	 * ในขณะเดียวกัน เธรดหลักก็จะพิมพ์ข้อมูลเกี่ยวกับตัวมันเองด้วย
	 */
	/**
	 * Ergebnis : 
	 * 		 Current Thread: id : 1 | Name: id : main gestartet  
	 * 	 	 1  | Thread: id : 21 | Name: id : Thread-0 läuft... 
	 * 	 	 2  | Thread: id : 21 | Name: id : Thread-0 läuft...
	 *  ...
	 */
	static void A1() {
 
		class MyEndlosThread extends Thread{
			@Override
			public void run() {
				int i = 0 ; 
				while (true) {
					System.out.printf("%d  | Thread: id : %s | Name: %s %n" ,++i ,getId() ,getName() + " läuft...");
					MyThreadUtils.pause(1000);
				
				}
			}
		}
		
		Thread th = new MyEndlosThread();
		th.start();
		
		Thread currentThread = Thread.currentThread();
		System.out.printf("Current Thread: id : %s | Name: %s %n" , currentThread.getId() , currentThread.getName() + " gestartet");
		
	}
	 
	
	/*
	 * A2() - การสร้างและใช้งาน Runnable ในเธรดแยก
	 * ในเมธอดนี้จะสร้าง `Runnable` ที่ทำงานเหมือนกับ A1 แต่ใช้ `Runnable` แทนการขยายคลาส `Thread`
	 * เมื่อเรียกใช้งาน `start()` เธรดจะเริ่มทำงานและพิมพ์ข้อมูลตามระยะเวลา
	 * เธรดหลักจะพิมพ์ข้อความว่า "main-Thread ได้เริ่มเธรดแยกแล้ว"
	 */
	/**
	 * Ergebnis : 
	 * 	 	main-Thread get dewn extra-Thread gestartet. 
	 * 		1  | Runnable: id : 21 | Name: id : Thread-0 läuft... 
	 * 		2  | Runnable: id : 21 | Name: id : Thread-0 läuft...
	 *  ...
	 */
	 static void A2() {
		Runnable task = () -> {
			int i = 0 ; 
			while (true) {
		       System.out.printf("%d  | Runnable: id : %s | Name: %s %n" ,
		    		   ++i ,
		    		   Thread.currentThread().getId() ,
		    		   Thread.currentThread().getName() + " läuft...");
		       MyThreadUtils.pause(1000);
			}
		};
	

		Thread th = new Thread(task);
		th.start();
		
		System.out.println("main-Thread get dewn extra-Thread gestartet.");
	}
	 
	 
	 /*
	  * A3() - การสร้างหลายๆ เธรดด้วย `Runnable` และจัดเก็บไว้ใน List
	  * เมธอดนี้จะสร้าง `Runnable` และเริ่มต้น 37 เธรด โดยใช้ลูปเพื่อเพิ่มเธรดลงใน List
	  * แต่ละเธรดจะแสดงข้อมูลของตัวเองเมื่อมันเริ่มทำงาน
	  */
	static void A3() {
		Runnable task = () -> {
			Thread th = Thread.currentThread();
		    System.out.printf("Runnable: id : %s | Name: : %s %n" ,th.getId() ,th.getName());
		};
		
		List<Thread> threads = new ArrayList<>();
		 
		for (int i = 0; i < 37 ; i++) {
			final int num = i + 1 ;
			threads.add(new Thread(task));
		}
		
		for (Thread thread : threads) {
	            thread.start();
	    }
		
	 }
		 
	 
	/*
	 * A4() - การพิมพ์อักษรจาก A-Z โดยใช้หลายเธรด
	 * เมธอดนี้จะสร้าง `Runnable` ซึ่งรับอักษรจาก A ถึง Z มาแสดงผลในแต่ละเธรด
	 * ทุกๆ เธรดจะพิมพ์ข้อมูลของตัวเอง เช่น "A | Thread-ID: id : 21 | Name: Thread-0"
	 */
	static void A4() {
		
		class CharPrinter implements Runnable {
			char ch;
			public CharPrinter(char ch) {
				this.ch = ch;
			}
			public void run() {
				Thread th = Thread.currentThread();
				System.out.printf("%s | Thread-ID: id : %s | Name: %s %n" , this.ch ,th.getId() ,th.getName());
			}
		};
		
		for (char ch = 'A'; ch < 'Z' ; ch++) {
			Runnable task = new CharPrinter(ch);
			Thread threads = new Thread(task);
			threads.start();
		}
	 }
	
	static void A4alternativ() {
	
		
		for (char ch = 'A'; ch < 'Z' ; ch++) {
			final char chCopy = ch ; 
			Runnable task = ()->{
				Thread th = Thread.currentThread();
				System.out.printf("%s | Thread-ID: id : %s | Name: %s %n" , chCopy ,th.getId() ,th.getName());  // chCopy must final sein für innere Class
			};
			Thread threads = new Thread(task);
			threads.start();
		}
	 }
	
	static void A5() {
		
		Runnable task = new Runnable() {			
			@Override
			public void run() {
				bigJob();				
			}
		};
		
		
		Thread tom = new Thread(task , "Tom");
		tom.setPriority(Thread.MIN_PRIORITY);
		
		Thread jerry = new Thread(task ,"Jerry");
		jerry.setPriority(Thread.MAX_PRIORITY);
		
		tom.start();	
		jerry.start();
		
		
	}
	
	 
	
	public static void bigJob() {
		Thread th = Thread.currentThread();
		System.out.println("Starte " + th.getName() + ". Priorität: " + th.getPriority());
		
		long start = System.currentTimeMillis();

		int exists = 0;
		for (int i = 0; i < 100_000; i++) {
			Path path = Paths.get("./"+i);
			if(Files.exists(path)) {
				exists++;
			}
		}
		
		long ende = System.currentTimeMillis();
		
		System.out.println("Thread: " + th.getName() 
				+ ", Zeit: " + (ende-start)/1000. + " Sek. / " + exists);
	}
}
