package threads;

import aufgaben.MyThreadUtils;

//คลาสนี้สร้างเธรดที่ไม่สามารถหยุดได้โดยตรง
class UnstoppableThread extends Thread{
	@Override
	public void run() {
		while (true) { 	// Solange true ist, wird nicht beendet. // ถ้า while loop นี้ยังไม่ถูกหยุด มันจะทำงานต่อไปเรื่อยๆ
			System.out.println("läuft... isInterrupted(): " + this.isInterrupted());
		} 
	}
}

//คลาสนี้สร้างเธรดที่สามารถหยุดได้เมื่อถูก interrupt
class InterruptibleThread extends Thread{
	@Override
	public void run() {
		while (!this.isInterrupted()) { // If not interrupted, continue running.
			System.out.println("läuft... isInterrupted(): " + this.isInterrupted());
		}// end of while  // เมื่อเธรดถูก interrupt จะหยุดทำงาน
	}
}

/*
 * คลาสนี้สร้างเธรดที่สามารถหยุดได้และมีการใช้ sleep แต่เมื่อเกิด exception ระหว่าง sleep 
 * ค่าของ isInterrupted จะไม่กลายเป็น true โดยอัตโนมัติ
 */
/*
 * เมื่อเธรดกำลังหลับ (sleep)
 * ถ้ามีเธรดอื่นทำการ interrupt, จะเกิด InterruptedException
 * หากเกิด InterruptedException, 
 * เธรดจะไม่ได้รับการตั้งค่าสถานะ interrupted เป็น true โดยอัตโนมัติ
 * เพราะสถานะการ interrupt จะถูกรีเซ็ตเป็น false เมื่อเกิด InterruptedException.
 * ดังนั้น แม้ว่าจะมีการ interrupt เธรด แต่หลังจากจับ InterruptedException, 
 * ค่าของ isInterrupted() จะเป็น false.
 * 
 * ข้อสอบ: ในการสอบจะไม่มีการใช้ InterruptedException ในโค้ด!
 */
class InterruptibleSleepingThread extends Thread{
	@Override
	public void run() {
		while (!this.isInterrupted()) {  	// ถ้าเธรดยังไม่ได้ถูก interrupt จะทำงานต่อ
			System.out.println("läuft... isInterrupted(): " + this.isInterrupted());
			try {
	             Thread.sleep(2_000); 				
	        } catch (InterruptedException e) {		
	        	 System.out.println(this.getName() + " wurde interrupted");
	        	 // ข้อสังเกต: สถานะ interrupt จะถูกรีเซ็ตกลับเป็น false เมื่อเกิด InterruptedException
	        }   

		} // end of while  
	}
}

class InterruptibleSleepingThreadWithReset extends Thread{
	@Override
	public void run() {
	    Thread th = Thread.currentThread();
	    while (!th.isInterrupted()) { 
	        try { 
	        	Thread.sleep(1000);  // 1 sec
	        } catch (InterruptedException e) {
	      	    System.out.println(th.getName() + " wurde interrupted");
	      	    th.interrupt();  // รีเซ็ตสถานะการ interrupt
	      	 }
	    }
	}
}

//คลาสนี้สร้างเธรดที่สามารถหยุดได้เมื่อถูก interrupt และใช้คำสั่ง break เพื่อหยุดการทำงาน
/*
* เมื่อเธรดกำลังหลับ (sleep)
* ถ้ามีเธรดอื่นทำการ interrupt, จะเกิด InterruptedException
* หากเกิด InterruptedException, 
* เธรดจะไม่ได้รับการตั้งค่าสถานะ interrupted เป็น true โดยอัตโนมัติ
* เพราะสถานะการ interrupt จะถูกรีเซ็ตเป็น false เมื่อเกิด InterruptedException.
* ดังนั้น แม้ว่าจะมีการ interrupt เธรด แต่หลังจากจับ InterruptedException, 
* ค่าของ isInterrupted() จะเป็น false.
*/
class InterruptibleThreadWithBreak extends Thread{
	@Override
	public void run() {
		while (!this.isInterrupted()) {  // ถ้าเธรดยังไม่ได้ถูก interrupt จะทำงานต่อ
			System.out.println("läuft... isInterrupted(): " + this.isInterrupted());
			try {
	             Thread.sleep(2_000); 				
	        } catch (InterruptedException e) {		
	        	 System.out.println(getName() + " wurde interrupted");
	             // ใช้คำสั่ง break เพื่อออกจากลูป while และหยุดการทำงานของเธรด
	             break; // schleife beenden (หยุดลูป)
	        }
			
			System.out.println(getName() + "wurde beendet " );
	    } // end of while  // เมื่อเธรดถูก interrupt จะหยุดทำงาน
	}
}

public class B09_ThreadInterrupt {

	public static void main(String[] args) {
		
		/* 
		 *  1. This thread cannot be stopped by interruption
		 */
//         testThread(new UnstoppableThread());     					// Will NOT stop

        /*
         *  2. This thread stops when interrupted
         */
//         testThread(new InterruptibleThread());  						 // Will NOT stop

        /*
         *  3. This thread stops when interrupted, uses sleep 
         *  but does not reset isInterrupted to true
         */
//         testThread(new InterruptibleSleepingThread());  				 // Will NOT stop

		
        /*
         *  4. This thread stops when interrupted, uses sleep 
         *  and resets isInterrupted after InterruptedException
         */
//         testThread(new InterruptibleSleepingThreadWithReset());   	// OK, will stop

		
        /*
         *  5. This thread stops when interrupted 
         *  and uses break to exit the loop
         */
//         testThread(new InterruptibleThreadWithBreak());   				// OK, will stop
	}


	private static void testThread(Thread threadObject) {

	    /*
         * test_ThreadDerInterruptWerdenKann_3:
         * - สร้างเธรดใหม่จากคลาส ThreadDerInterruptWerdenKann_3
         * - พิมพ์ข้อความว่า main-Thread เริ่มเธรดใหม่
         * - เรียกใช้ start() เพื่อเริ่มทำงานของเธรด
         * - main-Thread หยุดทำงาน 6 วินาที
         * - หลังจากนั้น main-Thread ส่งคำสั่ง interrupt ไปยังเธรด
         */	
		Thread th = threadObject;
		System.out.println("main-Thread startet den Thread " + th.getName());
		th.start();
		
		System.out.println("main-Thread macht pause..");
		MyThreadUtils.pause(6000);
		
		System.out.println("main-Thread beendet den Thread " + th.getName());
		th.interrupt();
		
	}
}
