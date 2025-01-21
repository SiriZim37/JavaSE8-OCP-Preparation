package concurrency;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class MyRecursiveAction extends RecursiveAction{

	//THRESHOLD: เกณฑ์ที่ใช้กำหนดว่างานย่อยควรทำเองหรือควรแบ่งงานออกไป (THRESHOLD = 3 หมายความว่าถ้างานมีขนาด ≤ 3 จะทำงานใน Thread ปัจจุบันทันที)
	private static final int THRESHOLD = 3; // Threshold for splitting tasks
	private  int[] array;
	private int indexFrom, indexTo;
	
	public MyRecursiveAction(int[] array, int indexFrom, int indexTo) {
           this.array = array;
           this.indexFrom = indexFrom;
           this.indexTo = indexTo;
    }

	@Override 
	protected void compute() {
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
		 */
		
		long threadID = Thread.currentThread().getId();
		System.out.printf("thread: %d, [%d..%d] %n",threadID , indexFrom , indexTo);
		
		if( (indexTo - indexFrom)  <= THRESHOLD) { 	// FALLS die Aufgabe ist einfach genug
			for (int i = indexFrom; i < indexTo; i++) {  
				array[i] = array[i] *2 ;
				
			}
		}else { // Aufgabe ist zu kompliziert
			System.out.println("Aufgabe zu kompliziert!");
			
			//die Aufgabe is zwei (oder mehr) einfachere Aufgaben teilen
			
//			int indexMitte = (indexFrom + indexTo);		// Error StackOverflowError
			
			int indexMitte = (indexFrom + indexTo) / 2;
			
			System.out.println(indexFrom +" bis "+ indexMitte);
			System.out.println(indexMitte +" bis " + indexTo);

			RecursiveAction leftAction = new MyRecursiveAction(array , indexFrom , indexMitte);
			RecursiveAction rightAction = new MyRecursiveAction(array , indexMitte , indexTo);

			// 	die einfache Teileaufgaben an die Threads des ForkJoin-Pools 
			// zum aus füren übergenem 
			invokeAll(leftAction,rightAction);
		}
		
		
	}
}

public class B16_ForkJoin_RecursiveAction {

	/*
	 * Aufgabe:
	 * 
	 * 		in einem Array die Werte verdoppeln
	 */
	public static void main(String[] args) {

		int[] array = { 12, 6, -2, 0, 11, 5 , 1,2,3,4,5,6,7};
		
		System.out.println("1. array: " + Arrays.toString(array));
		
		ForkJoinPool pool = new ForkJoinPool();
		
		pool.invoke(new MyRecursiveAction(array , 0 , array.length));
		
		System.out.println("2. array: " + Arrays.toString(array));

	}
	// 1. เริ่มต้นอาร์เรย์ที่มีค่า [12, 6, -2, 0, 11, 5, 1, 2, 3, 4, 5, 6, 7]
	// อาร์เรย์นี้จะถูกคูณด้วย 2 ในแต่ละตำแหน่ง

	// 2. thread: 1, [0..13] Aufgabe zu kompliziert! 0 bis 6 6 bis 13:
	// thread 1 จะรับผิดชอบการทำงานในช่วง [0..13]
	// เมื่อพบว่าเป็นงานใหญ่เกินไป (ขนาดช่วง > 3) จึงแบ่งงานออกเป็นสองช่วงย่อย คือ [0..6] และ [6..13]
	// จะแสดงข้อความว่า "Aufgabe zu kompliziert!" (งานซับซ้อนเกินไป)

	// 3. thread: 2, [0..6] Aufgabe zu kompliziert! 0 bis 3 3 bis 6:
	// thread 2 รับผิดชอบการทำงานในช่วง [0..6] และแบ่งงานออกเป็นสองช่วง [0..3] และ [3..6]
	// งานนี้ยังถือว่า "ซับซ้อนเกินไป" จึงแบ่งงานไปเรื่อย ๆ

	// 4. thread: 3, [6..13] Aufgabe zu kompliziert! 6 bis 9 9 bis 13:
	// thread 3 รับผิดชอบการทำงานในช่วง [6..13] และแบ่งงานออกเป็นสองช่วง [6..9] และ [9..13]

	// 5. thread: 4, [0..3] และ thread: 5, [3..6]:
	// เมื่อขนาดของช่วงงานเล็กลง (≤ 3) การประมวลผลจะทำใน thread ที่ 4 และ 5
	// โดยการคูณค่าของอาร์เรย์ในช่วง [0..3] และ [3..6] ด้วย 2

	// 6. thread: 6, [6..9] และ thread: 7, [9..13]:
	// thread ที่ 6 และ 7 จะทำงานในช่วง [6..9] และ [9..13] ตามลำดับ
	// เมื่อช่วงมีขนาดเล็กพอ (≤ 3) การประมวลผลจะทำในแต่ละ thread โดยการคูณค่าของอาร์เรย์ในช่วงนั้น

	// 7. ผลลัพธ์สุดท้ายของอาร์เรย์:
	// อาร์เรย์ที่ได้รับการคูณค่าแล้วคือ [24, 12, -4, 0, 22, 10, 2, 4, 6, 8, 10, 12, 14]
	// ทุกค่าถูกคูณด้วย 2 จากอาร์เรย์เริ่มต้น

}
