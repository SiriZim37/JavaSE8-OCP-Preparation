package ocp;

public class Concurrency13 {
	/*
	 * 1. public class Account {
	 * 2.   private Lock lock = new ReentrantLock();
	 * 3.   private int value = 0;
	 * 4.   public void increment() {
	 * 5.     lock.lock();
	 * 6.     value++;
	 * 7.     lock.unlock();
	 * 8.   }
	 * 9.   public void decrement() {
	 * 10.     lock.lock();
	 * 11.     value--;
	 * 12.     lock.unlock();
	 * 13.   }
	 * 14.   public int getValue() {
	 * 15.     return value;
	 * 16.   }
	 * 17. }
	 * 
	 * Which are true? (Choose all that apply.)
	 * 
	 * A. Class Account is not thread-safe.
	 * 
	 * B. A similar approach would be to use an AtomicInteger in place of the value variable; remove lines 2, 5, 7, 10, and 12; and call methods getAndIncrement and getAndDecrement on the AtomicInteger object on lines 6 and 11, respectively.
	 * 
	 * C. A ReentrantReadWriteLock cannot be used in place of the ReentrantLock on line 2.
	 * 
	 * D. If methods increment() and decrement() were synchronized, lines 2, 5, 7, 10, and 12 would not be necessary.
	 * 
	 * E. Class Account would be thread-safe if and only if methods increment() and decrement() were synchronized.
	 * 
	 * B and D are correct.
	 * A, C, and E are incorrect. A and E are incorrect because class Account is thread-safe. C is incorrect because a ReentrantReadWriteLock could be used in place of the ReentrantLock object on line 2. In this case, methods increment() and decrement() would have to lock and unlock on the write lock object of the ReentrantReadWriteLock object.
	 * 
	 * คำอธิบาย:
	 * - A: ข้อนี้ไม่ถูกต้อง เนื่องจาก class Account เป็น thread-safe เพราะมีการใช้ lock ในการควบคุมการเข้าถึงตัวแปร value
	 * - B: ข้อนี้ถูกต้อง เพราะสามารถใช้ AtomicInteger แทนตัวแปร value ได้ โดยไม่ต้องใช้ ReentrantLock และสามารถเรียกใช้ getAndIncrement และ getAndDecrement
	 * - C: ข้อนี้ไม่ถูกต้อง เพราะสามารถใช้ ReentrantReadWriteLock แทน ReentrantLock ได้ ซึ่งจะต้องใช้ write lock ในการ lock/unlock
	 * - D: ข้อนี้ถูกต้อง เพราะถ้าใช้ synchronized ใน method increment() และ decrement() จะไม่จำเป็นต้องใช้ lock ในตัวอย่างนี้
	 * - E: ข้อนี้ไม่ถูกต้อง เพราะ class Account จะเป็น thread-safe ก็ต่อเมื่อมีการใช้ synchronized หรือ lock ใน method increment() และ decrement()
	 */

}
