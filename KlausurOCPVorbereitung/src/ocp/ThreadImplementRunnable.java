package ocp;





public class ThreadImplementRunnable implements Runnable {

	void go(long id) {
		System.out.println(id);
	}
	@Override
	public void run() {
		go(Thread.currentThread().getId());
		
	}
	public static synchronized void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getId() + " ");
		
		/*
		 * Welcher Code is richtig funktioniert?
		 * 
		 * 	I new ThreadImplementRunnable().run();	
		 * 
		 * 	II new ThreadImplementRunnable().start();   
		 * 
		 * 	III new Thread(new ThreadImplementRunnable());
		 * 
		 * 	IV new Thread(new ThreadImplementRunnable()).run();
		 * 
		 *  V new Thread(new ThreadImplementRunnable()).start();	
		 */

	}
	
	 /*
     * คำถาม: โค้ดไหนทำงานได้ถูกต้อง?
     * 
     * I.  new ThreadImplementRunnable().run();
     * II. new ThreadImplementRunnable().start();   
     * III. new Thread(new ThreadImplementRunnable());
     * IV. new Thread(new ThreadImplementRunnable()).run();
     * V.  new Thread(new ThreadImplementRunnable()).start(); 
     * 
     * คำตอบและผลลัพธ์ (ergebnis):
     */

    // I. new ThreadImplementRunnable().run();   				  // ok 
    /*
     * คำอธิบาย:
     * - run() ถูกเรียกโดยตรงใน main thread
     * - ไม่มีการสร้างเธรดใหม่ ผลลัพธ์จะเป็น ID ของ main thread
     * ผลลัพธ์:
     * (ID ของ main thread) เช่น 1
     */

    // II. new ThreadImplementRunnable().start();					// cf
    /*
     * คำอธิบาย:
     * - ใช้ start() แต่ผิดพลาด เพราะ ThreadImplementRunnable 
     *   ไม่ใช่ Thread และไม่มี start() method
     * - เกิดข้อผิดพลาดในการคอมไพล์ (Compilation Error)
     */

    // III. new Thread(new ThreadImplementRunnable());				// ok but not run
    /*
     * คำอธิบาย:
     * - โค้ดนี้แค่สร้าง Thread ใหม่ แต่ไม่ได้รันมัน (ไม่มี start() หรือ run())
     * - ไม่มีอะไรเกิดขึ้น
     * ผลลัพธ์:
     * ไม่มีผลลัพธ์
     */

    // IV. new Thread(new ThreadImplementRunnable()).run();			// ok
    /*
     * คำอธิบาย:
     * - run() ถูกเรียกโดยตรงใน main thread
     * - ไม่มีการสร้างเธรดใหม่ ผลลัพธ์จะเป็น ID ของ main thread
     * ผลลัพธ์:
     * (ID ของ main thread) เช่น 1
     */

    // V. new Thread(new ThreadImplementRunnable()).start();		// ok and start new Thread
    /* 
     * คำอธิบาย:
     * - start() เรียกเพื่อเริ่มเธรดใหม่!! 
     * - เธรดใหม่รัน run() และพิมพ์ ID ของตัวเอง
     * ผลลัพธ์:
     * (ID ของ main thread) เช่น 1
     * (ID ของเธรดใหม่) เช่น 12
     */
	

	/*
	 * คำอธิบายสำหรับคำถาม: 
	 * "Only one might produce the output 4, 2"   (-----> V )
	 * "Exactly two might produce the output 4, 4"
	 *
	 * 1. "Only one might produce the output 4, 2"
	 *    กรณีนี้จะเกิดขึ้นเมื่อมีการสร้างเธรดใหม่ และเธรดใหม่ทำงานแยกกันจาก main thread:
	 *    - main thread พิมพ์ค่า "4"
	 *    - เธรดใหม่ พิมพ์ค่า "2"
	 *    - เฉพาะตัวเลือก **V** เท่านั้นที่ทำให้เกิดผลลัพธ์นี้
	 *      ```java
	 *      new Thread(new ThreadImplementRunnable()).start();
	 *      ```
	 *    คำอธิบาย: 
	 *    - main thread รัน `main()` และพิมพ์ ID ของ main thread (สมมุติว่าเป็น 4)
	 *    - เมื่อ `start()` ถูกเรียก จะสร้างเธรดใหม่ และเธรดใหม่นี้รัน `run()` 
	 *      จากนั้นพิมพ์ ID ของตัวเอง (เช่น 2)
	 * 
	 * 2. "Exactly two might produce the output 4, 4"   (-----> I & IV )
	 *    กรณีนี้จะเกิดขึ้นเมื่อ method `run()` ถูกเรียกโดยตรงใน main thread:
	 *    - ไม่มีการสร้างเธรดใหม่
	 *    - ดังนั้นทั้งสองบรรทัดพิมพ์ค่า ID ของ main thread ซึ่งก็คือ "4"
	 *    - ตัวเลือกที่ทำให้เกิดกรณีนี้คือ **I และ IV**
	 *      ```java
	 *      new ThreadImplementRunnable().run();  
	 *      new Thread(new ThreadImplementRunnable()).run();  
	 *      ```
	 *    คำอธิบาย:
	 *    - `run()` ถูกเรียกโดยตรง ไม่ได้ใช้ `start()` จึงไม่มีเธรดใหม่ถูกสร้าง
	 *    - ผลลัพธ์มาจาก main thread ทั้งหมด
	 *
	 * 3. ทำไมตัวเลือกอื่นถึงไม่ถูกต้อง?
	 *    - **II**: Error ระหว่างคอมไพล์ เพราะ `ThreadImplementRunnable` ไม่มี method `start()`
	 *    - **III**: ไม่มีอะไรเกิดขึ้น เพราะ thread ถูกสร้างขึ้นแต่ไม่ได้เริ่มทำงาน
	 *
	 * คำตอบสุดท้าย:
	 * - Output `4, 2`: **V**
	 * - Output `4, 4`: **I และ IV**
	 */


	
}
