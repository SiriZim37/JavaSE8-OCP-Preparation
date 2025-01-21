package ocp;

public class ThreadSynchronise2 {

	synchronized void a() { actBusy(); }  
	/*
	 *  เป็น instance method ที่กำหนดเป็น synchronized หมายความว่า ถ้าหากเธรดหนึ่งกำลังเรียกใช้งาน method นี้ใน instance หนึ่ง
	 *  เธรดอื่นๆ ที่พยายามจะเรียก method a() บน instance เดียวกันจะต้อง รอ จนกว่าเธรดแรกจะเสร็จ
	 */

	static synchronized void b() { actBusy(); }
	/*
	 * เป็น static method ที่กำหนดเป็น synchronized หมายความว่า มันล็อกระดับ class ไม่ใช่ระดับ instance 
	 * ดังนั้น หากเธรดหนึ่งกำลังใช้งาน method นี้ เธรดอื่นๆ ไม่สามารถเรียก method b() บน class เดียวกัน 
	 * (ทุก instance ของ ThreadSynchronise2) จนกว่าเธรดแรกจะเสร็จ
	 */
	static void actBusy() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
	}
	public static synchronized void main(String[] args) throws InterruptedException {
	
		final ThreadSynchronise2 x = new ThreadSynchronise2();
		final ThreadSynchronise2 y = new ThreadSynchronise2();
		
		Runnable run = ()-> {
			int optinal = (int) (Math.random() * 4);
		    /*
             * ขึ้นอยู่กับค่าของ `optinal` จะเรียกใช้งาน method ตามนี้:
             * - x.a(): (instance method ของ x) ล็อกบน instance `x`
             * - x.b(): (static method ของ class ผ่าน instance x) ล็อกบน class object `ThreadSynchronise2.class`
             * - y.a(): (instance method ของ y) ล็อกบน instance `y`
             * - y.b(): (static method ของ class ผ่าน instance y) ล็อกบน class object `ThreadSynchronise2.class`
             */
			
			switch (optinal) {
			case 0: x.a(); break;
			case 1: x.b(); break;
			case 2: y.a(); break;
			case 3: y.b(); break;
			}
		};
		
		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		
		 /*
         * โค้ดนี้สร้างเธรดสองตัว (`t1` และ `t2`) ซึ่งทั้งคู่จะรัน logic ใน `run`
         * เนื่องจาก method `a()` และ `b()` เป็น synchronized 
         * จะมีการล็อกดังนี้:
         * 
         * - `a()`: การล็อกเป็นแบบ instance-specific 
         *   ถ้า `t1` เรียก `x.a()` เธรด `t2` ยังสามารถเรียก `y.a()` ได้ 
         *   เพราะล็อกของ `x` และ `y` แยกจากกัน
         * 
         * - `b()`: การล็อกเป็นระดับ class-wide 
         *   ถ้า `t1` เรียก `x.b()` เธรด `t2` จะไม่สามารถเรียก `y.b()` 
         *   หรือ `x.b()` ได้ เพราะล็อกอยู่บน `ThreadSynchronise2.class`
         * 
         * ผลลัพธ์จะขึ้นอยู่กับว่าเธรดใดล็อก method ไหนก่อน 
         * และอาจทำให้บางเธรดต้องรอจนกว่าอีกเธรดจะปลดล็อก
         */
		
		t1.start();
		t2.start();
	
	}
	

}
