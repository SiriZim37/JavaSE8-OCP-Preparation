package threads;

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("run");
	}
}
	
/*
 * 2. การใช้ `Runnable` interface:
 *    - คุณสามารถสร้างคลาสที่ implement `Runnable` interface และกำหนดการทำงานในเมธอด `run()`
 */
public class B03_MyRunnable {
	
	public static void main(String[] args) {
		
		Runnable task = new MyRunnable();
		
		// 1. Reservieren (NEW)    กำหนดการทำงานในเมธอด run() ของ MyRunnable คลาส	
		Thread th = new Thread(task);  
		
		// 2. Als RUNNABLE registieren  เธรดถูกเริ่มทำงานในสถานะ RUNNABLE
		th.start();
		/*
		 * Wenn der Schedular den extra-Thread in den Zustand RUNNABLE 
		 * versetzt , wird die Methode run() in diesem Thread ausgeführt : 
		 * 
		 * public void run(){
		 * 		 Runnable task = hier die Task suchen...
		 * 		 if (task != null) {
		 * 		  	hier die Task aktivieren
		 *       }
		 * }
		 */

		System.out.println("main");

		/*
		 * ทำไมข้อความ "main" ถึงปรากฏก่อน "run" ที่ถูกกำหนดในเมธอด run() ของ MyRunnable
		 * main
		 * run
		 * 
		 * - เมื่อโปรแกรมเรียก start() บนเธรด (ตัวแปร th), เธรดนี้จะเริ่มทำงานในสถานะ **RUNNABLE** 
		 *   แต่การทำงานของมันจะไม่เกิดขึ้นทันทีที่ start() ถูกเรียก
		 *   เนื่องจากการจัดการเธรดใน Java จะถูกควบคุมโดย **Thread Scheduler**
		 * - **Thread Scheduler** จะกำหนดว่าเธรดใดจะทำงานก่อน ระหว่างเธรดหลัก (main) และเธรดใหม่ที่เริ่มต้นด้วย `th.start()`
		 * - ดังนั้น, แม้ว่า `start()` จะถูกเรียกก่อน แต่คำสั่งใน `main` (เช่นการพิมพ์ "main") จะถูกประมวลผลก่อน
		 *   เนื่องจาก `main` เป็นเธรดหลักที่เริ่มต้นการทำงานของโปรแกรม
		 * - เธรดใหม่ที่เริ่มต้นด้วย `th.start()` จะรอให้เธรดหลักเสร็จสิ้นการทำงานหรือขึ้นอยู่กับการจัดการของ **Thread Scheduler**
		 *   ซึ่งอาจทำงานขนานกันหรือรอให้เธรดหลักทำงานเสร็จแล้วจึงจะเริ่มทำงานในเมธอด `run()`
		 */

		
	
	}
}
