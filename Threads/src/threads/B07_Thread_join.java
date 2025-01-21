package threads;

public class B07_Thread_join {
	
	/*
	 * volatile ist nicht in der Prüfung.
	 * 
	 * volatile erklärt: https://jenkov.com/tutorials/java-concurrency/volatile.html
	 */
	
	
	/*
	 * volatile เป็นคำสำคัญที่ใช้เพื่อประกาศตัวแปร เพื่อบ่งชี้ว่า ตัวแปรนั้นอาจจะถูกเข้าถึงและแก้ไขโดยหลายๆ Thread ในเวลาเดียวกัน 
	 * การใช้ volatile ช่วยให้การอัปเดตค่าของตัวแปรนั้นถูกแชร์และเห็นผลในทุกๆ Thread ที่ใช้งานตัวแปรนั้นๆ อย่างถูกต้อง
	 * 
	 * การทำงานของ volatile
	 * เมื่อประกาศตัวแปรด้วยคำว่า volatile JVM จะทำให้ตัวแปรนั้นไม่ถูกเก็บไว้ใน cache ของแต่ละ Thread 
	 * แต่จะทำให้ทุกๆ Thread เข้าถึงค่าของตัวแปรนั้นจากหน่วยความจำหลัก (main memory) ทุกครั้งที่มีการใช้งาน 
	 * ค่าของตัวแปรจะถูกอัปเดตทันทีในทุก Thread ที่ใช้ตัวแปรนี้
	 * 
	 * ข้อจำกัดของ volatile
	 *  - volatile ใช้เพื่อให้ตัวแปรเห็นค่าที่อัปเดตในหลายๆ Thread แต่มัน ไม่สามารถใช้แทนการซิงโครไนซ์ (synchronization) 
	 *    ในกรณีที่ต้องจัดการการเข้าถึงตัวแปรหลายๆ ตัวพร้อมกัน
	 *  - volatile ใช้ได้แค่กับตัวแปรตัวเดียว ไม่สามารถใช้เพื่อควบคุมหลายๆ ตัวแปรที่มีการอัปเดตพร้อมกัน
	 */
	volatile static int count;
	
	public static void main(String[] args) {
		
		
		test_countA();
		test_countB();
		
		/*
		 * 2. test_countA() Method
		 * 
		 * ใน method นี้:
		 * 
		 * - มีการสร้างเธรดใหม่เพื่อเพิ่มค่า count จาก 0 ถึง 9 ในลูป
		 * - เมื่อพิมพ์ค่า count หลังจากสร้างเธรดใหม่ มันอาจแสดงค่าใดค่าหนึ่งในช่วงระหว่าง 0 ถึง 9 ขึ้นอยู่กับว่าเธรดหลัก (main thread)
		 *   เสร็จสิ้นการทำงานก่อนหรือหลังจากเธรดที่สร้างขึ้นใหม่
		 * - นี่คือเหตุผลที่ผลลัพธ์ของ count อาจเป็นตัวเลขจาก 0 ถึง 9 เพราะเธรดหลักอาจพิมพ์ค่า count ก่อนที่เธรดใหม่จะทำงานเสร็จ
		 * 
		 * 3. test_countB() Method
		 * 
		 * ใน method นี้:
		 * 
		 * - เธรดใหม่จะเพิ่มค่า count จำนวน 1 ล้านครั้ง (1_000_000 ครั้ง)
		 * - เมื่อใช้ join() กับเธรดนั้น, เธรดหลักจะหยุดทำงานและรอจนกว่าเธรด th จะทำงานเสร็จ
		 * - เมื่อเธรด th ทำงานเสร็จแล้ว, ค่า count จะเป็น 1_000_000 ซึ่งถูกเพิ่มขึ้นโดยเธรดนั้น
		 * - ดังนั้น ผลลัพธ์ที่แสดงจะเป็น count : 1000010 เนื่องจากเธรดหลักเริ่มต้น count จาก 0 และเพิ่ม 1 ล้านครั้งจากการทำงานของเธรดใหม่
		 *   และ count เพิ่มขึ้นอีก 10 ครั้งจากการทำงานใน test_countA() method ที่รันก่อนหน้านี้
		 */

		

	}

	private static void test_countB() {
		Runnable task = () ->{
			for (int i = 0; i < 1_000_000; i++) {
				count++;
				
			}
		};
		
		Thread th = new Thread(task);
		th.start();

		/*
		 * void join() throws InterruptedException
		 * 
		 * Der Thread , in dem die join() aufgerufen wird , wird angehalten ,
		 * bis der Thread , zu dem die join() aufgerufen wurde , beendet wurde.
		 * 	- Wenn der Thread 2 NEW ist , wird Thread 1 nicht angehalten
		 * 	- Wenn der Thread 2 beretis DEAD ist, wird Thread 1 nicht angehalten
		 * 
		 * Hier : Der main-Thread  wurde angehalten bin der Thread th fertig ist.
		 */
		/*
		 * เมธอด join() จะทำให้เธรดที่เรียกใช้ (เช่น เธรดหลัก) หยุดทำงานชั่วคราว
		 * จนกว่าเธรดที่ถูกเรียกใช้ join() จะทำงานเสร็จ
		 * 	- หากเธรดที่สอง (Thread 2) ยังไม่เริ่มทำงาน (สถานะ 'NEW') เธรดหลัก (Thread 1) จะไม่หยุดทันที แต่จะรอจนกว่าเธรดที่สองจะเริ่มทำงาน
		 * 	- หากเธรดที่สอง (Thread 2) ทำงานเสร็จแล้ว (สถานะ 'DEAD') เธรดหลัก (Thread 1) ก็จะไม่หยุด เพราะเธรดที่สองทำงานเสร็จแล้ว
		 * 
		 * ในกรณีนี้:
		 * เธรดหลักจะหยุดรอจนกว่าเธรด `th` จะทำงานเสร็จ แล้วจึงทำงานต่อ
		 * 
		 * ***********************************************************
		 * Weitere überladene Varianten von join():
		 * 
		 * 		th.join(millis)
		 * 		th.join(millis, nanos)
		 * 
		 * โดยการใช้ `join(millis)` เธรดหลักจะรอจนกว่าเธรด `th` จะเสร็จสิ้นหรือจนกว่าจะหมดเวลา `millis`
		 * millis คือระยะเวลาในมิลลิวินาทีที่เธรดหลักจะรอ ถ้าเธรด `th` เสร็จภายในเวลานี้ เธรดหลักจะทำงานต่อทันที
		 * หากไม่เสร็จภายใน `millis` เธรดหลักจะหยุดรอจนหมดเวลา
		 *
		 * ใช้ `join(millis, nanos)` สำหรับการระบุระยะเวลาในการรอที่ละเอียดขึ้น
		 * 		- `millis` คือระยะเวลาในมิลลิวินาที
		 * 		- `nanos` คือส่วนย่อยของมิลลิวินาทีในหน่วยนาโนวินาที (1 นาโนวินาที = 1/1,000,000,000 วินาที)
		 * การใช้ `nanos` ช่วยให้ระบุเวลาได้ละเอียดขึ้นในระดับนาโนวินาที
		 */


		try {
            th.join();  // ให้เธรดหลักรอจนกว่าเธรดที่สร้างขึ้นใหม่จะเสร็จ
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		System.out.println("count : " + count);  		// 1000010
		
	}

	private static void test_countA() {
		Runnable task = () ->{
			for (int i = 0; i < 10; i++) {
				count++;
				
			}
		};
		
		Thread th = new Thread(task);
		th.start();

		/*
		 * Nach der Zeile 21 : 
		 * 
		 * 		System.out.println("count : " + count);  	for (int i = 0; i < 10; i++) {
		 * 														count++;
		 * 													}	
		 */
		
		System.out.println("count : " + count);  		// Zahl con 0 bis 10 
		/*
		 * ตัวอย่างการทำงาน:
				main thread อาจจะพิมพ์ค่า count ออกมาทันทีที่มันเริ่มทำงานก่อนที่เธรดที่สร้างขึ้นใหม่จะเสร็จการทำงาน
				ผลลัพธ์ที่ได้ อาจจะเป็น 0 bis 9 เนื่องจากการที่เธรดใหม่ยังไม่เสร็จสิ้นงานเมื่อพิมพ์ค่า count
		 */
		
	}
}
