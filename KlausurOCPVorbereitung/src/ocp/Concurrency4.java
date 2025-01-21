package ocp;

public class Concurrency4 {
	/*
	 * public class Alphabet extends Thread {
	 *   public synchronized void run() {
	 *     try {
	 *       System.out.println("A");
	 *       wait();
	 *       System.out.println("B");
	 *       notify();
	 *       System.out.println("C");
	 *       wait(1);
	 *       System.out.println("D");
	 *       notifyAll();
	 *       System.out.println("E");
	 *     } catch (Exception e) {
	 *       System.out.println("F");
	 *     } finally {
	 *       System.out.println("G");
	 *   }
	 *  }
	 *   public static void main(String[] args) {
	 *     new Alphabet().start();
	 *   }
	 * }
	 * 
	 * Which letters will appear in the output?
	 * 
	 * A.  A
	 * 
	 * B.  B
	 * 
	 * C.  C
	 * 
	 * D.  D
	 * 
	 * E.  E
	 * 
	 * F.  F
	 * 
	 * G.  G
	 * 
	 * H.  The code does not compile
	 * 
	 * A is correct. Since run() is synchronized, a lock has been acquired on the 
	 * this instance, so none of the method calls would throw an IllegalMonitorStateException. 
	 * However, the first call to wait() blocks forever. It's waiting for a notify(), 
	 * but the notify() is never called because it's blocked on the wait(). In order for 
	 * a notify() to be useful, it must be sent from a separate thread so that it can be 
	 * called while the first thread is still waiting at the wait() statement.
	 * 
	 * B, C, D, E, F, G, and H are incorrect based on the above.
	 * 
	 * คำอธิบาย:
	 * - A: ถูกต้อง เพราะการเรียก run() ในเมธอด synchronized ทำให้ล็อคถูกจับที่ออบเจ็กต์ this
	 *   ดังนั้นจะไม่มี IllegalMonitorStateException เกิดขึ้น และ "A" จะถูกพิมพ์ออกมา
	 * - B, C, D, E: ไม่ถูกต้อง เนื่องจากการเรียก wait() ครั้งแรกทำให้เธรดหยุดการทำงานอย่างไม่มีกำหนด 
	 *   โดยเธรดกำลังรอ notify() แต่ notify() จะไม่มีวันถูกเรียกเพราะเธรดเดียวกันยังคงอยู่ในสถานะรอที่ wait()
	 * - F: ไม่ถูกต้อง เพราะไม่มี Exception เกิดขึ้นในโค้ด
	 * - G: ไม่ถูกต้อง เพราะโค้ดไม่ถึงส่วน finally เนื่องจากเธรดหยุดที่ wait()
	 * - H: ไม่ถูกต้อง เพราะโค้ดนี้คอมไพล์ได้
	 * 
	 * หมายเหตุ: ในการทำให้ notify() มีผล ต้องมีการเรียกจากเธรดอื่น 
	 * เพื่อให้ notify() ถูกเรียกระหว่างที่เธรดแรกยังคงรอที่ wait()
	 */

}
