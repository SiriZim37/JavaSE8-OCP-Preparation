package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class B15_ForkJoin {

	/*  
	 * ForkJoinPool: เป็นส่วนหนึ่งของ Concurrency Framework 
	 * สำหรับการแก้ปัญหาแบบ Recursive ด้วยการประมวลผลแบบขนาน
	 */

	/*
	 * ForkJoinPool คืออะไร?
	 * - คลาสในแพ็คเกจ java.util.concurrent
	 * - ใช้แนวคิด Divide and Conquer: แบ่งงานออกเป็นชิ้นเล็ก ๆ แล้วรวมผลลัพธ์กลับมา
	 * - เหมาะสำหรับงานที่สามารถแบ่งย่อยได้ เช่น การคำนวณข้อมูลขนาดใหญ่
	 */

	/* 
	 * ทำไมต้องใช้ ForkJoinPool?
	 * 1. ประมวลผลงานที่แบ่งย่อยได้ เช่น งานที่มีการคำนวณซ้ำ
	 * 2. จัดการ Thread อย่างมีประสิทธิภาพด้วย Work Stealing 
	 *    (ช่วยให้ Thread แต่ละตัวไม่ว่างงาน)
	 * 3. เหมาะกับงาน Recursive Task (งานที่เรียกตัวเองซ้ำ)
	 */

	/* 
	 * คลาสหลักใน ForkJoinPool:
	 * 1. ForkJoinPool: 
	 *    - ตัวจัดการ Thread Pool
	 *    - ใช้สำหรับงานแบบขนาน
	 * 
	 * 2. RecursiveTask<V>: 
	 *    - ใช้สำหรับงานที่ "ส่งค่ากลับ" (return value)
	 *    - เช่น การคำนวณผลลัพธ์
	 * 
	 * 3. RecursiveAction: 
	 *    - ใช้สำหรับงานที่ "ไม่ส่งค่ากลับ" (void)
	 */

	static class MyRecursiveAction extends RecursiveAction{
		
		@Override
		protected void compute() {				// liefert void zurück
			/*
			 * 	Hier der speizielle Algorithmus,
			 *  um die Aufgabe rekursiv zu lösen..
			 *  
			 *  FALLS 
			 *  	die Aufgabe ist einfach genug
			 *  DANN 
			 *  	die Aufgabe lösen
			 *  SONST
			 *  	- die Aufgabe is zwei (oder mehr) einfachere Aufgaben teilen
			 *  	- die einfache Teileaufgaben an die Threads des ForkJoin-Pools 
			 *  	  zum aus füren übergenem 
			 *   
			 **** คำอธิบายแบบง่าย ***
			 *  - ถ้าทำเองได้เลย → แก้ปัญหาเลย
			 *  - ถ้างานใหญ่ → แบ่งงานเป็นชิ้นเล็ก ๆ → ส่งไปให้ Threads ต่าง ๆ ช่วยกันทำ → รวมผลกลับมาที่เดียวกัน
			 *  
			 ****ตัวอย่างใน ForkJoin Algorithm
			 *  ถ้าเรามีปัญหาที่ต้องการคำนวณผลรวมของตัวเลข 1 ถึง 1,000:
			 *	 - ถ้างานเล็กพอ (เช่น คำนวณผลรวมของตัวเลข 1 ถึง 10) → ทำเลย
			 * 	 - ถ้างานใหญ่ (เช่น คำนวณ 1 ถึง 1,000) → แบ่งเป็น 1 ถึง 500 และ 501 ถึง 1,000 → ให้ Threads ทำงานทั้งสองส่วน → รวมผลรวมของสองส่วนกลับมา
			 */
			 
			
			System.out.println("MyRecursiveAction. in compute in Thread " + Thread.currentThread().getName());
			
		}
	}
	
	static class MyRecursiveTask extends RecursiveTask<Integer>{
		
		@Override
		protected Integer compute() {			// liefert Referenz zurück
			/*
			 * Hier der speizielle Algorithmus,
			 *  um die Aufgabe rekursiv zu lösen...
			 *  	
			 *  
			 *  FALLS 
			 *  	die Aufgabe ist einfach genug
			 *  DANN 
			 *  	die Aufgabe lösen und dann das Ergebnis zurück liefen
			 *  SONST
			 *  	- die Aufgabe is zwei (oder mehr) einfachere Aufgaben teilen
			 *  	- die Unteraufgabe B in einem anderen Thread aktivieren (fork)
			 *  	- die Unteraufgabe A in dem aktuellen Thread aktivieren
			 *  	- das Ergebnis der Unteraufgabe B im aktuellen Thread abwarten(join)
			 *  	- die Ergebnisse A und B kombinieren zurück liefern
			 *   
			 **** คำอธิบายแบบง่าย ***
			 *  
			 * FALLS
			 *   ถ้างานง่ายทำเลย
			 * DANN
			 *   แก้ปัญหานั้นทันทีและส่งผลลัพธ์กลับ
			 * SONST
			 *   - แบ่งงานเป็นงานย่อย
			 *   - ส่งงานย่อยไปทำใน Thread อื่น
			 *   - ทำงานย่อยใน Thread ปัจจุบัน
			 *   - รอผลจากงานย่อย
			 *   - รวมผลทั้งสองแล้วส่งกลับ
			 */
			 
			System.out.println("MyRecursiveAction. in compute in Thread " + Thread.currentThread().getName());
			return 42;
		}
	}
	
	/*
	 * ForkJoin-Framework: Teil des Concurrency-Framework, um die 
	 * rekursiven Lösungen zu parallelisieren.
	 */
	public static void main(String[] args) {
		
		ForkJoinPool pool = new ForkJoinPool();
		
		/*
		 * Variante 1 
		 */
		RecursiveAction topLevelRecursiveAction = new MyRecursiveAction();
		pool.invoke(topLevelRecursiveAction);	// synchron
		System.out.println("main. RecursiveAction ist fertig");
		/*
		 * Variante 2
		 */
		RecursiveTask<Integer> topLevelRecursiveTask = new MyRecursiveTask();
		Integer result = pool.invoke(topLevelRecursiveTask);	// synchron
		System.out.println("main. Ergenis aus der RecursiveTask: " + result);
		
		
	}
}
