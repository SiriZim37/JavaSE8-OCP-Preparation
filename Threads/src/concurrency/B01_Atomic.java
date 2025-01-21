package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

class ValueHolder implements Runnable{
//	private int value;
	
	private AtomicInteger value = new AtomicInteger();
	
	@Override
	public void run() {	
		for (int i = 0; i < 1_000_000; i++) {
//			value++;	// Race Condition
			value.incrementAndGet(); 	// threadsicher
			
		}
	}
	
	public int getValue() {
		return value.get();
	}
}


public class B01_Atomic {
	
	/*
	 * คลาส Atomic เป็นชุดของคลาสใน Java ที่อยู่ในแพ็คเกจ java.util.concurrent.atomic
	 * ซึ่งออกแบบมาเพื่อให้สามารถเข้าถึงและปรับปรุงตัวแปรได้อย่างปลอดภัยในหลายเธรด
	 * โดยไม่จำเป็นต้องใช้การล็อก (synchronization) ปกติ
	 * 
	 * หลักการทำงาน:
	 * คลาส Atomic ใช้เพื่อทำงานกับข้อมูลที่มีการแชร์ระหว่างหลายเธรด (threads)
	 * เช่น การเพิ่มค่าหรือลดค่าแบบอะตอมิก (atomic) ซึ่งหมายความว่า
	 * การเปลี่ยนแปลงค่าของตัวแปรจะเกิดขึ้นทั้งหมดในครั้งเดียว ไม่มีการถูกแทรกแซงระหว่างการทำงาน
	 * 
	 * ตัวอย่างคลาส Atomic ที่นิยมใช้:
	 * 
	 * 1. **AtomicInteger**: ใช้สำหรับการจัดการค่าของจำนวนเต็ม (int) แบบอะตอมิก  
	 * 2. **AtomicLong**: ใช้สำหรับการจัดการค่าของจำนวนยาว (long) แบบอะตอมิก
	 * 3. **AtomicBoolean**: ใช้สำหรับการจัดการค่าของ boolean แบบอะตอมิก
	 * 4. **AtomicReference**: ใช้สำหรับการจัดการค่าของอ็อบเจ็กต์ (Object) แบบอะตอมิก
	 * 
	 * การทำงานของ Atomic:
	 * การใช้คลาส Atomic ช่วยให้สามารถอ่านหรือปรับค่าตัวแปรในหลายเธรดได้อย่างปลอดภัย
	 * โดยไม่ต้องใช้การล็อก ซึ่งจะช่วยเพิ่มประสิทธิภาพของโปรแกรมในกรณีที่มีการทำงานร่วมกันหลายเธรด
	 * 
	 * ตัวอย่างการใช้งาน AtomicInteger:
	 * 
	 * AtomicInteger counter = new AtomicInteger(0);
	 * counter.incrementAndGet();  // เพิ่มค่าตัวแปร counter ขึ้น 1
	 * int currentValue = counter.get();  // อ่านค่าปัจจุบันของ counter
	 * 
	 * ทำไมถึงใช้ Atomic?
	 * - ช่วยให้โปรแกรมมีประสิทธิภาพสูงขึ้น เนื่องจากไม่ต้องใช้การล็อก
	 * - ลดความเสี่ยงในการเกิดปัญหาการแข่งกันของเธรด (race condition)
	 * - มักใช้ในกรณีที่ต้องการเพิ่มความเร็วในการประมวลผลในระบบที่มีการใช้งานหลายเธรด
	 * 
	 * อย่างไรก็ตาม การใช้ Atomic ควรระมัดระวังในบางสถานการณ์ที่อาจจะต้องการการจัดการซับซ้อนมากกว่านี้
	 * ซึ่งในกรณีเหล่านั้นอาจจะต้องพิจารณาใช้เครื่องมืออื่น ๆ เช่น `ReentrantLock` หรือ `synchronized`
	 */

	public static void main(String[] args) throws InterruptedException {
		
		ValueHolder vh = new ValueHolder();
		
		Thread t1 = new Thread(vh);
		Thread t2 = new Thread(vh);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("vh.getValue(): " + vh.getValue());	// 2 Mio
		
		/*
		 * Exam :  AtomicInteger oder AtomicLong 
		 * ( public class AtomicInteger extends Number ) 
		 * 
		 * AtomicInteger hat kei Autoboxing/AutoUnboxing
		 */
		
//		AtomicInteger i1 = 12;		// cf
		
		AtomicInteger i2 = new AtomicInteger();			// value 0 
		AtomicInteger i3 = new AtomicInteger(42);		// value 42
//		AtomicInteger i4 = new AtomicInteger(10.5);		// cf
		
		/*
		 * int get()
		 */
		AtomicInteger i5 = new AtomicInteger(10);		
		System.out.println("1. i5.get(): " + i5.get());   	 // i5 liefert int 10 
		
		/*
		 * int incrementAndGet()	-> increment and return new value  
		 * int getAndIncrement()	-> return old value and increment 
		 * 
		 * int decrementAndGet()	-> decrement and return new value  
		 * int getAndDecrement()	-> return old value and decrement 
		 */
		int x = i5.incrementAndGet();
		System.out.println("2. i5.incrementAndGet(): " + i5);	 // i5 liefert int 11 
		System.out.println("x= " + x);							 // x = 11 
		
		 x = i5.getAndIncrement();
		 System.out.println("3. i5.getAndIncrement(): " + i5); 	 // i5 liefert int 12
		 System.out.println("x= " + x);							  // x = 11 
		 
		 
		 /*
		  * int addAndGet(int)
		  * int getAndAdd(int)
		  */
		 x = i5.addAndGet(5);
		 System.out.println("4. i5.addAndGet(5): " + i5);	 // i5 liefert int 17 
		 System.out.println("x= " + x);						  // x = 17 
		 
		 x = i5.getAndAdd(-3);
		 System.out.println("5. i5.getAndAdd(5): " + i5);	 // i5 liefert int 14 
		 System.out.println("x= " + x);						  // x = 17 
		 
		 boolean bx = i5.compareAndSet(-3, x);
		 System.out.println("6.i5.compareAndSet(-3, x): " + bx);	 // false
		 System.out.println("bx= " + bx);						  // false
	}
}
