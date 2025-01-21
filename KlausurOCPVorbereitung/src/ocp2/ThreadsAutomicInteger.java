package ocp2;

import java.util.Arrays;
import java.util.concurrent.atomic.*;

class MyThread implements Runnable {
    private static AtomicInteger count = new AtomicInteger(0);
	public void run ()   {
	    int x = count.incrementAndGet();
	    System.out.print (x+" ");
	}
}

public class ThreadsAutomicInteger {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new MyThread());
		Thread thread2 = new Thread(new MyThread());
		Thread thread3 = new Thread(new MyThread());
		Thread [] ta = {thread1, thread2, thread3};
		for (int x= 0; x < 3; x++)   {
		ta[x].start();
		}

	}
	
	/*
	 *  Which statement is true?
		 A. The program prints 1 2 3 and the order is unpredictable.
		 B. The program prints 1 2 3.
		 C. The program prints 1 1 1.
		 D. A compilation error occurs
	 */
	
	/*
	 	A. The program prints 1 2 3 and the order is unpredictable.

			คำอธิบาย:
			เนื่องจาก Thread ทำงานพร้อมกัน ลำดับการพิมพ์ผลลัพธ์ของ count จึงไม่สามารถคาดเดาได้ว่ามันจะพิมพ์ในลำดับใด (แต่ละ Thread อาจจะทำงานเสร็จในลำดับที่ต่างกัน).
			ตัวอย่างเช่น อาจจะพิมพ์ 1 2 3 หรือ 2 1 3 หรือในลำดับที่แตกต่างกัน ขึ้นอยู่กับว่า Thread ใดทำงานเสร็จก่อน.
			
			
		คำอธิบายการทำงานของโค้ด:
		 AtomicInteger count = new AtomicInteger(0); สร้างตัวแปร count ซึ่งจะถูกใช้เพื่อเพิ่มค่าอย่างปลอดภัยในหลาย ๆ 
		 thread โดยไม่เกิดปัญหาจากการเข้าถึงข้อมูลพร้อมกัน (race condition).
		
		 ในแต่ละ Thread เมื่อเรียกใช้ run(), จะมีการเพิ่มค่า count ด้วย count.incrementAndGet()
		 และแสดงผลค่าใหม่ของ count ซึ่งจะเพิ่มขึ้นทีละ 1 ในแต่ละครั้ง.
		
		 เมื่อเริ่ม Thread แต่ละตัว (thread1, thread2, thread3), ฟังก์ชัน run() จะถูกเรียกใช้งาน
		 ซึ่งจะเพิ่มค่า count ทีละ 1 และพิมพ์ค่าของ count ซึ่งมีค่าเริ่มต้นเป็น 0.
	 */
}
