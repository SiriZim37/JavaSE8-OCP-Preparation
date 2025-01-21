package threads;

class MyThread extends Thread{

	String s;
	@Override
	public void run() {
		System.out.println("run");
		
	}
	
}

/*
 * วิธีการสร้าง **Thread** ใน Java:
 * 1. การสืบทอดคลาส `Thread`: 
 *    - คุณสามารถสร้างคลาสใหม่ที่สืบทอดจาก `Thread` และ override เมธอด `run()` เพื่อกำหนดการทำงานที่ต้องการให้เธรดนั้นทำ
 */

public class B02_MyThread {
	
	
	public static void main(String[] args) {

		// 1. Reservieren (NEW)
		Thread th = new MyThread();
		
		// 2. Als RUNNABLE registieren
		th.start();		// ab hier existierten zwei Threads (main und der extra-Thread)
		
		
		System.out.println("main");

	
	}
}
