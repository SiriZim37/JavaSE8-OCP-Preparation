package ocp;

public class Concurrency15 {
	/*
	 * public class Babble {
	 *   private static synchronized void say(String s) {
	 *     System.out.print(s);
	 *   }
	 *   public static void main(String[] args) {
	 *     Thread letters = new Thread() {
	 *       public void run() { say("a"); say("b"); say("c"); }
	 *     };
	 *     Thread numbers = new Thread() {
	 *       public void run() { say("1"); say("2"); say("3"); }
	 *     };
	 *     letters.start();
	 *     numbers.start();
	 *   }
	 * }
	 * 
	 * Which results are NOT possible? (Choose all that apply.)
	 * 
	 * A. a1bc23
	 * 
	 * B. abc123
	 * 
	 * C. 12c3ab
	 * 
	 * D. 1ab3c2
	 * 
	 * E. 123abc
	 * 
	 * F. The code does not compile
	 * 
	 * G. An error occurs at runtime
	 * 
	 * C, D, F, and G are correct. The code compiles and runs fine. C is impossible because c can't come before a. D is impossible because 3 can't come before 2.
	 * A, B, and E are incorrect because those answers are possible.
	 * 
	 * คำอธิบาย:
	 * - การใช้ `synchronized` ในฟังก์ชัน `say` จะทำให้การพิมพ์จากหลายเธรดเกิดขึ้นอย่างเป็นลำดับ (มีการล็อคการทำงานแบบเดียวกันในแต่ละครั้ง)
	 * - C (12c3ab) ไม่เป็นไปได้ เพราะ "c" ไม่สามารถพิมพ์ก่อน "a" ได้
	 * - D (1ab3c2) ไม่เป็นไปได้ เพราะ "3" ไม่สามารถพิมพ์ก่อน "2" ได้
	 * - F (โค้ดไม่สามารถคอมไพล์ได้) และ G (เกิดข้อผิดพลาดใน runtime) เป็นคำตอบที่ถูกต้อง
	 * - A, B, และ E เป็นผลลัพธ์ที่เป็นไปได้ เพราะฟังก์ชัน `say` จะถูกทำงานตามลำดับการเริ่มต้นของเธรด
	 */

}
