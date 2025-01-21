package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * คลาส `Lock` ใน Java ใช้สำหรับการควบคุมการเข้าถึงทรัพยากรที่ใช้ร่วมกันในหลายเธรด (Thread) 
 * เพื่อป้องกันไม่ให้เกิดปัญหาการเข้าถึงข้อมูลที่ไม่ปลอดภัยหรือเกิดข้อผิดพลาดจากการที่หลายเธรด 
 * ใช้งานทรัพยากรเดียวกันพร้อมกัน (เช่น การเปลี่ยนแปลงค่าของตัวแปรโดยไม่ได้รับอนุญาต)
 *
 * โดยทั่วไปแล้ว การใช้ `Lock` จะช่วยให้เราสามารถควบคุมการล็อกทรัพยากรได้ดีขึ้น 
 * เมื่อเทียบกับการใช้ `synchronized` ซึ่งมีข้อจำกัดบางประการ เช่น ไม่สามารถควบคุมลำดับการล็อก
 * หรือไม่สามารถตรวจสอบว่าเธรดใดล็อกอยู่ได้
 * 
 * ในโค้ดนี้มีการใช้งาน `ReentrantLock` ซึ่งเป็นคลาสหนึ่งของ `Lock` ที่ใช้สำหรับการล็อก
 * โดยสามารถล็อกและปลดล็อกทรัพยากรที่ใช้ร่วมกันในหลายเธรดได้อย่างมีประสิทธิภาพ
 * และสามารถใช้คำสั่ง `tryLock()` เพื่อป้องกันไม่ให้เธรดถูกบล็อกโดยไม่จำเป็น
 *
 * โดยมีการใช้งาน 3 ตัวอย่างหลัก:
 *
 * 1. **MitDeadlock (มีปัญหา Deadlock)**:
 *    ในตัวอย่างนี้ ใช้ `synchronized` สำหรับการล็อกทรัพยากรสองตัว (`m1` และ `m2`)
 *    แต่ในลำดับที่อาจทำให้เกิดการ deadlock ได้ เช่น เธรดหนึ่งล็อก `m1` แล้วรอที่จะล็อก `m2`
 *    และเธรดอื่นล็อก `m2` และรอที่จะล็อก `m1` ซึ่งทำให้ทั้งสองเธรดรอซึ่งกันและกันไม่มีใครสามารถปลดล็อกได้
 *
 * 2. **ImmerNochMitDeadlock (ยังคงมี Deadlock)**:
 *    ใช้ `ReentrantLock` แทน `synchronized` แต่ปัญหายังคงอยู่เนื่องจากการล็อกทรัพยากรในลำดับที่ผิด
 *    เธรดที่หนึ่งล็อก `lock1` แล้วรอที่จะล็อก `lock2` และเธรดที่สองล็อก `lock2` แล้วรอที่จะล็อก `lock1`
 *    ซึ่งอาจทำให้เกิด deadlock เนื่องจากทั้งสองเธรดจะรอการปลดล็อกจากกัน
 *
 * 3. **OhnedeadLock (ไม่มี Deadlock)**:
 *    ในตัวอย่างนี้ มีการใช้ `ReentrantLock` และใช้ `tryLock()` ซึ่งช่วยป้องกันการเกิด deadlock
 *    โดย `tryLock()` จะพยายามล็อกทรัพยากร แต่หากไม่สามารถล็อกได้ในทันที มันจะไม่บล็อกเธรด
 *    และโปรแกรมจะสามารถทำงานต่อไปได้โดยไม่ต้องรอ
 *
 * การทำงานของ `Lock`:
 * - `lock1.lock()` และ `lock2.lock()` ใช้สำหรับการล็อกทรัพยากร
 * - `lock1.unlock()` และ `lock2.unlock()` ใช้สำหรับการปลดล็อกทรัพยากรหลังจากใช้งานเสร็จ
 * - `tryLock()` ใช้สำหรับการพยายามล็อกทรัพยากร หากไม่สามารถล็อกได้ในทันทีจะไม่ทำให้เธรดถูกบล็อก
 * 
 * ข้อดีของการใช้ `Lock`:
 * 1. ช่วยให้การควบคุมการเข้าถึงทรัพยากรที่ใช้ร่วมกันเป็นไปอย่างมีประสิทธิภาพ
 * 2. สามารถใช้ `tryLock()` เพื่อป้องกันการรอคอยที่อาจทำให้เกิด deadlock
 * 3. ช่วยให้สามารถจัดการกับการเข้าถึงทรัพยากรในหลายเธรดได้ดีกว่า `synchronized`
 * 4. สามารถปลดล็อกได้จากเธรดใดก็ได้ที่ล็อกทรัพยากร ซึ่งช่วยให้โปรแกรมยืดหยุ่นมากขึ้น
 */



class MitDeadlock implements Runnable{
	
	static Object m1 = new Object();
	static Object m2 = new Object();
	
	@Override
	public void run() {
		// if anderer Thread den Lock auf m2 NICHT hat
		synchronized (m1) {
			System.out.println("m1");
			synchronized (m2) {
				System.out.println("m1.m2");
			}
		}
		// if anderer Thread den Lock auf m1 NICHT hat
		synchronized (m2) {
			System.out.println("m2");
			synchronized (m1) {
				System.out.println("m2.m1");
			}
		}
		
	}
}


class ImmerNochMitDeadlock implements Runnable{
	
	static Lock lock1 = new ReentrantLock();
	static Lock lock2 = new ReentrantLock();
	
	@Override
	public void run() {
		
		lock1.lock();
		System.out.println("m1");
		
		lock2.lock();
		System.out.println("m1.m2");
		lock2.unlock();
		lock1.unlock();
		
		//---------------//
		
		lock2.lock();
		System.out.println("m2");
		
		lock1.lock();
		System.out.println("m2.m1");
		lock1.unlock();
		lock2.unlock();

		
	}
}

class OhnedeadLock implements Runnable{
	
	static Lock lock1 = new ReentrantLock();
	static Lock lock2 = new ReentrantLock();
	
	@Override
	public void run() {
		lock1.lock();
		System.out.println("m1");
		
		if(lock2.tryLock()) {
			System.out.println("m1.m2");
			lock2.unlock();
		} else {
			System.out.println("m1.m2 übersprungen");
		}
		
		lock1.unlock();
		
		lock2.lock();
		System.out.println("m2");
		
		if(lock1.tryLock()) {
			System.out.println("m2.m1");
			lock1.unlock();
		} else {
			System.out.println("m2.m1 übersprungen");
		}
		
		lock2.unlock();

		
	}
}

public class B02_Lock {

	public static void main(String[] args) {
		
//		MitDeadlock task = new MitDeadlock();
//		ImmerNochMitDeadlock task = new ImmerNochMitDeadlock(); 
		OhnedeadLock task = new OhnedeadLock();
		
		new Thread(task).start();
		new Thread(task).start();
		

		
	}
}
