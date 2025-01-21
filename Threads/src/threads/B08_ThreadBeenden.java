package threads;

import aufgaben.MyThreadUtils;

class ThreadDerBeendetWerdenKann extends Thread{
	@Override
	public void run() {
		while (true) { // solange true ist wird nicht beendet
			System.out.println("läuft...");
			MyThreadUtils.pause(5000);  
		}
	}
}

class ThreadDerBeendetWerdenKann_2 extends Thread{

	private volatile boolean laufen = true;
	
	@Override
	public void run() {
		while (laufen) { 					 // ถ้าค่าของ laufen เป็น true จะทำงานต่อไป
			System.out.println("läuft...");
			MyThreadUtils.pause(2000);  
		}
		System.out.println(getName() + " wurde beendet");
	}
	public void setLaufen(boolean laufen) {
		this.laufen = laufen;
	}
}

public class B08_ThreadBeenden {

	public static void main(String[] args) {
		
	//	test_ThreadDerBeendetWerdenKann1();
		
		test_ThreadDerBeendetWerdenKann2();
	
	}

	private static void test_ThreadDerBeendetWerdenKann2() {
	     /*
         * test_ThreadDerBeendetWerdenKann2:
         * - สร้างเธรดใหม่จากคลาส ThreadDerBeendetWerdenKann_2
         * - พิมพ์ข้อความว่า main-Thread เริ่มเธรดใหม่
         * - เรียกใช้เมธอด start() เพื่อเริ่มทำงานของเธรด
         * - main-Thread หยุดทำงานเป็นเวลา 6 วินาที
         * - เมื่อ main-Thread หยุดทำงานแล้ว จะพิมพ์ข้อความว่า main-Thread หยุดเธรด
         * - การหยุดเธรดทำได้โดยการเปลี่ยนค่าของตัวแปร laufen เป็น false
         */
		Thread th = new ThreadDerBeendetWerdenKann_2();
		System.out.println("main-Thread startet den Extra-Thread " + th.getName());
		th.start();
		
		System.out.println("main-Thread wartet..");
		MyThreadUtils.pause(6000);
		
		System.out.println("main-Thread beendet den Extra-Thread " + th.getName());
		
		((ThreadDerBeendetWerdenKann_2) th).setLaufen(false); 
	}

	private static void test_ThreadDerBeendetWerdenKann1() {
		
		 /*
         * test_ThreadDerBeendetWerdenKann1:
         * - สร้างเธรดใหม่จากคลาส ThreadDerBeendetWerdenKann
         * - พิมพ์ข้อความว่า main-Thread เริ่มเธรดใหม่
         * - เรียกใช้เมธอด start() เพื่อเริ่มทำงานของเธรด
         * - main-Thread หยุดทำงานเป็นเวลา 6 วินาที
         * - เมื่อ main-Thread หยุดทำงานแล้ว จะพิมพ์ข้อความว่า main-Thread หยุดเธรด
         * - ใช้ interrupt() เพื่อหยุดเธรด
         * - เธรดในคลาส ThreadDerBeendetWerdenKann จะทำงานไปเรื่อยๆ เนื่องจากไม่มีการตรวจสอบคำสั่งหยุด
         */
		Thread th = new ThreadDerBeendetWerdenKann();
		System.out.println("main-Thread startet den Extra-Thread " + th.getName());
		th.start();
		
		System.out.println("main-Thread wartet..");
		MyThreadUtils.pause(6000);
		
		System.out.println("main-Thread beendet den Extra-Thread " + th.getName());
		th.interrupt();
		
	}
}
