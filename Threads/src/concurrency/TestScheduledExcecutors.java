package concurrency;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledExcecutors {
 
	/*
	 * ScheduledExecutorService คืออินเตอร์เฟซในแพ็กเกจ java.util.concurrent ที่ขยายจาก ExecutorService
	 * ซึ่งช่วยในการจัดการงานที่ต้องทำตามกำหนดเวลา (Scheduled Tasks) เช่น การรันงานเพียงครั้งเดียวหลังจากเวลาที่กำหนด
	 * หรือการทำงานซ้ำในช่วงเวลาที่กำหนด (Periodic Tasks)
	 * 
	 * การใช้งาน:
	 * - แทนที่ Timer และ TimerTask ด้วยความยืดหยุ่นที่สูงกว่าและรองรับการทำงานแบบขนาน (multithreading)
	 * - ใช้สำหรับงานที่ต้องการการทำงานซ้ำเช่น การตรวจสอบสถานะเซิร์ฟเวอร์ หรือการส่งข้อมูลเป็นระยะ
	 * 
	 * เมธอดหลัก:
	 * 1. schedule(Runnable command, long delay, TimeUnit unit)
	 *    - ใช้สำหรับรันงานเพียงครั้งเดียวหลังจากเวลาที่กำหนด 
	 *    - ตัวอย่าง:
	 *      scheduler.schedule(() -> System.out.println("Hello!"), 5, TimeUnit.SECONDS);
	 *      ( งานจะถูกรันหลังจาก 5 วินาที )
	 *      
	 * 2. scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)
	 *    - รันงานซ้ำทุกช่วงเวลาหลังจาก delay ครั้งแรก
	 *    - ตัวอย่าง:
	 *      scheduler.scheduleAtFixedRate(() -> System.out.println("Running Task"), 2, 3, TimeUnit.SECONDS);
	 *      (  เริ่มงานครั้งแรกหลังจาก 2 วินาที และจะรันทุกๆ 3 วินาที )
	 *      
	 * 3. scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)
	 *    - รันงานซ้ำโดยรอ delay หลังจากงานก่อนหน้าสิ้นสุด
	 *    - ตัวอย่าง:
	 *      scheduler.scheduleWithFixedDelay(() -> System.out.println("Task with Delay"), 1, 4, TimeUnit.SECONDS);
	 * 		( เริ่มงานครั้งแรกหลังจาก 1 วินาที และรันใหม่หลังจาก 4 วินาที หลังจากงานก่อนหน้าเสร็จ)
	 * 
	 * ข้อแตกต่างระหว่าง scheduleAtFixedRate กับ scheduleWithFixedDelay:
	 * - scheduleAtFixedRate: เริ่มงานถัดไปในช่วงเวลาที่กำหนด (Fixed Rate)
	 * - scheduleWithFixedDelay: เริ่มงานถัดไปหลังจากงานก่อนหน้าสิ้นสุด (Fixed Delay)
	 * 
	 * ข้อควรระวัง:
	 * - ควรเรียก shutdown() เพื่อหยุด ScheduledExecutorService เมื่อไม่ใช้งาน
	 * - ควรจัดการข้อยกเว้นในงาน (Task) เพื่อไม่ให้ Scheduler หยุดทำงาน
	 * 
	 * ความสำคัญใน OCP:
	 * - การเข้าใจการตั้งเวลา (Scheduling) และการทำงานแบบ Concurrent 
	 * 	 ในการใช้งาน ScheduledExecutorService เป็นสิ่งสำคัญใน OCP Java SE 8
	 */

	public static void main(String[] args) throws InterruptedException {
		
//		test_scheduleAtFixedRate();
		test_scheduleAtFixedDelay();
	}
	
	/*
	 * Ergebnis : 
	 * command im Thread pool-1-thread-1 - 12:03:33   
	 * command im Thread pool-1-thread-1 - 12:03:41  <- aktivieren in 8 Sek ,nach dem beenden Thread um 12:03:33 , 
	 * command im Thread pool-1-thread-1 - 12:03:49
	 * main. service herunterfahren
	 */
	public static void test_scheduleAtFixedDelay() throws InterruptedException {
		
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		
		Runnable command = ()-> {
			Thread th = Thread.currentThread();
			System.out.println("command im Thread " + th.getName()
							+ " - " + LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		
		int initalDelay = 2;				// 2 Sekunden vor der ersten Aktivier.
		int delay = 3;						// Nach dem beenden eines vorherigen Commandos
											// das nächste Commando in 3 Sek. aktivieren
		
		TimeUnit unit = TimeUnit.SECONDS;
		
		System.out.println("main. command registieren");
		service.scheduleWithFixedDelay(command, initalDelay, delay, unit);
		
		Thread.sleep(20_000);
		System.out.println("main. service herunterfahren");
		service.shutdown();
	}
	
	
	
	/*
	 * Ergebnis :
	 * >>> command sleep 5 Sekunde  period 3 Sek.
	 * main. command registieren
	 * command im Thread pool-1-thread-1 - 12:06:23
	 * command im Thread pool-1-thread-1 - 12:06:28  <- aktivieren jede 5 Sek 
	 * command im Thread pool-1-thread-1 - 12:06:33
	 * command im Thread pool-1-thread-1 - 12:06:38
	 * main. service herunterfahren
	 * 
	 * >>> command sleep 1 Sekunde period 3 Sek.
	 * main. command registieren
	 * command im Thread pool-1-thread-1 - 12:07:21
	 * command im Thread pool-1-thread-1 - 12:07:24  <- aktivieren jede 3 Sek 
	 * command im Thread pool-1-thread-1 - 12:07:27
	 * command im Thread pool-1-thread-1 - 12:07:30
	 * command im Thread pool-1-thread-1 - 12:07:33
	 * command im Thread pool-1-thread-1 - 12:07:36
	 * main. service herunterfahren
	 * command im Thread pool-1-thread-1 - 12:07:39
	 */
	public static void test_scheduleAtFixedRate() throws InterruptedException {
//		ScheduledExecutorService service =  Executors.newScheduledThreadPool(2);
		ScheduledExecutorService service =  Executors.newSingleThreadScheduledExecutor();
		
		Runnable command = () -> {
			Thread th = Thread.currentThread();
			System.out.println("command im Thread " + th.getName()
							+ " - " + LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		
		int initailDelay = 2;  				 // 2 Sekunden vor der ersten Aktivier.
		int period = 3;						 // Jede 3 Sekunden wieder aktivieren
		
		TimeUnit unit = TimeUnit.SECONDS;
		
		System.out.println("main. command registieren");
		service.scheduleAtFixedRate(command, initailDelay, period, unit);
		
		Thread.sleep(20_000);
		System.out.println("main. service herunterfahren");
		service.shutdown();
	}
}
