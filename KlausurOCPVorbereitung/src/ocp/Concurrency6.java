package ocp;

public class Concurrency6 {
	/*
	 * Given:
	 * public class Letters extends Thread {
	 *   private String name;
	 *   public Letters(String name) { this.name = name; }
	 *   public void write() {
	 *     System.out.print(name);
	 *     System.out.print(name);
	 *   }
	 *   public static void main(String[] args) {
	 *     new Letters("X").start();
	 *     new Letters("Y").start();
	 *   }
	 * }
	 * 
	 * We want to guarantee that the output can be either XXYY or YYXX, but never XYXY or any other combination.
	 * Which method definitions could be added to the Letters class to make this guarantee? (Choose all that apply.)
	 * 
	 * A. public void run() { write(); }
	 * 
	 * B. public synchronized void run() { write(); }
	 * 
	 * C. public static synchronized void run() { write(); }
	 * 
	 * D. public void run() { synchronized(this) { write(); } }
	 * 
	 * E. public void run() { synchronized(Letters.class) { write(); } }
	 * 
	 * F. public void run() { synchronized(System.out) { write(); } }
	 * 
	 * G. public void run() { synchronized(System.out.class) { write(); } }
	 * 
	 * Correct Answers:
	 * E and F are correct.
	 * - E and F both cause both threads to lock on the same object, which will prevent the threads 
	 *   from running simultaneously and guarantee XXYY or YYXX. 
	 * - It's a bit unusual to lock on an object like System.out, but it's perfectly legal, and 
	 *   both threads are locking on the same object.
	 * 
	 * Incorrect Answers:
	 * - A: Can't guarantee anything since it has no synchronization.
	 * - B, D: Both synchronize on an instance of the Letters class, but there are two different 
	 *   instances in the main() method. This means the threads don't block each other, potentially 
	 *   leading to output like XYXY.
	 * - C: Won't compile because run() cannot be static in this context and calls a non-static 
	 *   method from a static method.
	 * - G: Won't compile because System.out.class is nonsense. A class literal must start with a 
	 *   class name. System.out is a field, not a class, so System.out.class is not a valid class literal.
	 * 
	 * คำอธิบาย (ภาษาไทย):
	 * - E และ F ถูกต้อง:
	 *   - E: ใช้ synchronized(Letters.class) เพื่อให้ทั้งสอง threads ล็อกบนอ็อบเจกต์เดียวกัน 
	 *     ซึ่งป้องกันไม่ให้ทำงานพร้อมกันและรับประกันผลลัพธ์ XXYY หรือ YYXX
	 *   - F: ใช้ synchronized(System.out) แม้จะไม่ธรรมดาที่จะล็อกบน System.out แต่ก็ถูกต้องตามกฎหมาย 
	 *     และทั้งสอง threads ล็อกบนอ็อบเจกต์เดียวกัน
	 * 
	 * - A ไม่ถูกต้อง: ไม่มีการใช้ synchronization เลย ดังนั้นไม่สามารถรับประกันผลลัพธ์ได้
	 * - B และ D ไม่ถูกต้อง: แม้จะใช้ synchronized แต่ล็อกบนอ็อบเจกต์ของคลาส Letters ซึ่งใน main() 
	 *   มีสองอ็อบเจกต์ที่ต่างกัน ทำให้ threads ไม่บล็อกกันและอาจส่งผลให้ได้ผลลัพธ์เช่น XYXY
	 * - C ไม่ถูกต้อง: ไม่สามารถใช้ static กับ run() ได้ในบริบทนี้ และเรียกใช้เมธอดไม่-static 
	 *   จากเมธอด static ซึ่งทำให้เกิดข้อผิดพลาดในการคอมไพล์
	 * - G ไม่ถูกต้อง: System.out.class ไม่ถูกต้อง เนื่องจาก System.out เป็นฟิลด์ ไม่ใช่คลาส 
	 *   ดังนั้น System.out.class จึงไม่ใช่ class literal ที่ถูกต้อง
	 */

}
