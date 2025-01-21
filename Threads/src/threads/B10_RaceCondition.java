package threads;

public class B10_RaceCondition {
	/*
	 *  ตัวแปร count ใช้ volatile เพื่อให้ค่าของตัวแปรถูกแชร์ระหว่างเธรด
	 */
	static volatile int count;
	
	/*
	 * Race Condition : Zwei (oder mehr) Threads zugreifen parallel 
	 * 					auf dieselbe Speicherstelle lesend und schreibend. 
	 * 					เมื่อมีสองเธรดหรือมากกว่านั้นที่เข้าถึงข้อมูลเดียวกัน
     * 					ทั้งการอ่านและการเขียนข้อมูลนั้นในเวลาเดียวกัน
     * 					ซึ่งทำให้เกิดปัญหาค่าของตัวแปรไม่เป็นไปตามที่คาดหวัง
	 * 
	 * Das ist ein Problem. Das Problem muss gelöst werden! 
	 * ในกรณีนี้, ตัวแปร count ถูกเพิ่มจากหลายๆ เธรดพร้อมกัน ซึ่งทำให้เกิด
	 * การแทรกแซงระหว่างเธรด ส่งผลให้ผลลัพธ์สุดท้ายไม่เป็นไปตามที่คาดหวัง
     * ต้องแก้ไขปัญหานี้เพื่อให้โปรแกรมทำงานได้ถูกต้อง
     * 
     * Was hier passiert.
     * 
     * Inkrementierung : 
     * 		1. Lesen vom aktuellen Wert (kopieren in CPU)
     * 		2. Kopierten Wert um 1 in der CPU erhöhen
     * 		3. Den berechneten Wert aus CPI in count kopieren
     * 
     * 
     * 
     * *** Eine Möglichkeit aus vielen:
	 * 
	 * Thread A						    Thread B
	 * 
	 *               count(Heap) = 0
	 *               
	 *  cpuA = 0
	 *  cpuA + 1 = 1
	 *  count = cpuA
	 *   
	 *               count(Heap) = 1
	 * 
	 *                                  cpuB = 1
	 *                                  cpuB + 1 = 2
	 *                                  count = cpuB
	 *                                  
	 *               count(Heap) = 2
	 *               
	 *               
	 * *** Eine andere Möglichkeit aus vielen:
	 * 
	 * Thread A						    Thread B
	 * 
	 *               count(Heap) = 0
	 *               
	 *  cpuA = 0                       cpuB = 0
	 *  cpuA + 1 = 1                   cpuB + 1 = 1
	 *  count = cpuA
	 *                                 count = cpuB
	 *   
	 *               count(Heap) = 1
	 * 
	 * *** Eine andere Möglichkeit aus vielen:
	 * 
	 * Thread A						    Thread B
	 * 
	 *               count(Heap) = 0
	 *               
	 *                                 cpuB = 0
	 *  cpuA = 0                       
	 *  							   cpuB + 1 = 1
	 *  cpuA + 1 = 1                   
	 *  count = cpuA
	 *                                 count = cpuB
	 *   
	 *               count(Heap) = 1
	 * 
     * 
     * 
     * 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		
		Runnable taskInc = () -> {
			for (int i = 0; i < 10_000; i++) {
				// more code here...
				count++;	
			}
			System.out.println(Thread.currentThread().getName() + " ist fertig");
		};

		// สร้างเธรดสองตัว tA และ tB ซึ่งจะทำงานพร้อมกัน
        Thread tA = new Thread(taskInc);
        Thread tB = new Thread(taskInc);

        // เริ่มทำงานเธรดทั้งสอง
        tA.start();
        tB.start();

        // รอให้เธรดทั้งสองทำงานเสร็จ
        tA.join();
        tB.join();
		
		
		/*
		 *  แสดงผลลัพธ์ของ count ที่คาดว่าจะเป็น 20,000 แต่ไม่รับประกันว่า 
		 *  จะได้ผลลัพธ์ที่ถูกต้อง เพราะมีปัญหา race condition
		 */
		System.out.println("count: "+ count);	// Ausgabe 10000 bis 20000 nicht garantie! 
    	
		/*
		 * เหตุผลที่ผลลัพธ์ไม่แน่นอน:
		 * 
		 * ทั้งสองเธรด (tA และ tB) เข้าถึงตัวแปร count เพื่อเพิ่มค่าในแต่ละลูป เมื่อ count++ ถูกเรียก มันจะทำการ:
		 * 	-	อ่านค่า count
		 * 	-	เพิ่มค่า 1
		 * 	-	เขียนค่ากลับไป
		 * เนื่องจากการเพิ่มค่า count ไม่ใช่ atomic จึงอาจจะเกิดการข้ามขั้นตอนบางอย่างระหว่างการเขียนข้อมูลที่แตกต่างกันระหว่างเธรด
		 */
	}
	

}
