package ocp;

import java.util.Iterator;

class Dude {
	static long flag = 0 ;
	
	// I 
//	synchronized void chat(long id) {
//		if(flag == 0) flag = id;
//		
//		for (int x = 1; x < 3; x++) {
//			if(flag == id ) System.out.print("yo ");
//			else System.out.print("dude ");
//		}
//	}		// Ergebnis : yo yo dude dude 
	
	// II 
	void chat(long id) {
		if(flag == 0) flag = id;
		
		for (int x = 1; x < 3; x++) {
			if(flag == id ) System.out.print("yo ");
			else System.out.print("dude ");
		}
	}		// Ergebnis : yo dude dude dude 
}
public class ThreadSynchronise3 implements Runnable {
	static Dude d;
	void go(){
		d = new Dude();
		 new Thread(new ThreadSynchronise3()).start();
		 new Thread(new ThreadSynchronise3()).start();
	}
	
	public static synchronized void main(String[] args) throws InterruptedException {
		new ThreadSynchronise3().go();
	}
	
	@Override
	public void run() {
		d.chat(Thread.currentThread().getId());
		
	}

	/*
	 * กรณี I: เมื่อ method `chat()` เป็น synchronized**
	 * - Method `chat()` จะถูกล็อกโดย thread หนึ่งในแต่ละครั้ง.
	 * - Thread ตัวแรกที่เข้า `chat()` จะกำหนดค่า `flag` เป็น ID ของตัวเอง 
	 *   และพิมพ์ "yo yo".
	 * - Thread ตัวที่สองจะต้องรอให้ thread ตัวแรกเสร็จ 
	 *   และพิมพ์ "dude dude
	 * **ผลลัพธ์ (Ergebnis): `yo yo dude dude`**
	 * - Thread ตัวแรก: `yo yo` (ล็อก method).
	 * - Thread ตัวที่สอง: `dude dude` (รอ).
	 * 
	 * **กรณี II: เมื่อ method `chat()` ไม่เป็น synchronized**
	 * - ไม่มีการล็อก thread. ทั้งสอง threads สามารถเข้ามาใน method `chat()` ได้พร้อมกัน.
	 * - Thread แรกจะกำหนด `flag` เป็น ID ของตัวเอง และเริ่มพิมพ์ "yo".
	 * - Thread ที่สองอาจเริ่มพิมพ์ "dude" ก่อนที่ thread แรกจะพิมพ์เสร็จ.
	 *
	 * **ผลลัพธ์ (Ergebnis): `yo dude dude dude`**
	 * - Thread ตัวแรก: พิมพ์ "yo".
	 * - Thread ตัวที่สอง: เริ่มพิมพ์ "dude" พร้อมกันใน loop.
	 *
	 * ---
	 * **สรุปข้อแตกต่าง:**
	 * - กรณี I: synchronized -> Thread ทำงานทีละตัว ผลลัพธ์จึงเป็น `yo yo dude dude`.
	 * - กรณี II: ไม่ synchronized -> Threads ทำงานพร้อมกัน ผลลัพธ์เป็น `yo dude dude dude`.
	 */
}
