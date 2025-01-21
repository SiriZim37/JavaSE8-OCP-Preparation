package concurrency;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

class MyRecursiveTask extends RecursiveTask<Integer>{

	//THRESHOLD: เกณฑ์ที่ใช้กำหนดว่างานย่อยควรทำเองหรือควรแบ่งงานออกไป (THRESHOLD = 3 หมายความว่าถ้างานมีขนาด ≤ 3 จะทำงานใน Thread ปัจจุบันทันที)
	private static final int THRESHOLD = 3; // Threshold for splitting tasks
	private int[] array;
	private int indexFrom, indexTo;

	public MyRecursiveTask(int[] array, int indexFrom, int indexTo) {
	        this.array = array;
	        this.indexFrom = indexFrom; 
	        this.indexTo = indexTo;
}

	@Override
	protected Integer compute() {
		/*
		 * 	Hier der speizielle Algorithmus,
		 *  um die Aufgabe rekursiv zu lösen..
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
		 
		
		long threadID = Thread.currentThread().getId();
		
//		System.out.printf("thread: %d, [%d..%d] %n",threadID , indexFrom , indexTo);
		
		if( (indexTo - indexFrom)  <= THRESHOLD) { 	// FALLS die Aufgabe ist einfach genug
			// die Aufgabe lösen
			int summe = 0;
			for (int i = indexFrom; i < indexTo; i++) {  
				summe += array[i] ;
				
			}
			return summe;
		}else { // Aufgabe ist zu kompliziert
			System.out.println("Aufgabe zu kompliziert!");
			
			//die Aufgabe is zwei (oder mehr) einfachere Aufgaben teilen
			int indexMitte = (indexFrom + indexTo) / 2;
			System.out.println(indexFrom +" bis "+ indexMitte);
			System.out.println(indexMitte +" bis " + indexTo);

			MyRecursiveTask taskLeft = new MyRecursiveTask(array , indexFrom , indexMitte);
			MyRecursiveTask taskRight= new MyRecursiveTask(array , indexMitte , indexTo);

			//die Unteraufgabe B in einem anderen Thread aktivieren (fork)
			// เริ่มต้นการทำงานของงานย่อย (rightTask) แบบขนาน โดยส่งงานไปให้กับ Thread ที่ว่างใน Fork/Join Pool
			taskRight.fork(); 	// Fork งานขวา
			
			//die Unteraufgabe A in dem aktuellen Thread aktivieren
			//คำนวณผลลัพธ์ของงาน leftTask ในเธรดปัจจุบัน
			//การ Fork ไม่ได้ทำให้งานเสร็จสมบูรณ์ทันที แต่มันแค่ "เริ่ม" งานใน Pool
			Integer resultA = taskLeft.compute();  // ประมวลผลงานซ้าย
			
			//das Ergebnis der Unteraufgabe B im aktuellen Thread abwarten(join)
			//Thread ที่กำลังทำงานอยู่ (Worker Thread) จะเรียก compute() ของ rightTask
			//ระบบจะประมวลผลงานนี้ใน Thread ปัจจุบันจนเสร็จ และคืนค่าผลลัพธ์ (strA)
			Integer resultB = taskRight.join();  // รอผลลัพธ์จากงานขวา
			
			//die Ergebnisse A und B kombinieren zurück liefern
			//คำสั่งนี้จะ รอผลลัพธ์จากงานที่ถูก Fork ไปก่อนหน้านี้ (ในที่นี้คือ leftTask)
			//ระบบจะตรวจสอบว่า leftTask ทำงานเสร็จหรือยัง
			//ถ้ายังไม่เสร็จ ระบบจะหยุดการทำงานชั่วคราวจนกว่างาน leftTask จะเสร็จ
			//ถ้าเสร็จแล้ว ระบบจะคืนค่าผลลัพธ์จาก leftTask (strB)
			 return resultA + resultB; // รวมผลลัพธ์
		}
		
	}
}

public class B17_ForkJoin_RecursiveTask {

	/*
	 * Aufgabe:
	 * 
	 * 		in einem Array die Werte verdoppeln
	 */
	public static void main(String[] args) {

		int[] array = {10 , 20 };//, 30 , 40 , 50 , 60};
		
		System.out.println("1. array: " + Arrays.toString(array));
		
		ForkJoinPool pool = new ForkJoinPool();
		
		Integer sum = pool.invoke(new MyRecursiveTask(array, 0, array.length));
		
		System.out.println("2.summe: " + sum);
	}
}
