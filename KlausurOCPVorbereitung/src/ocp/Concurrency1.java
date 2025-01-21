package ocp;

public class Concurrency1 {
	/*
	 * Given that the class MyRecursiveInitClass is a valid implementation of java.util.concurrent.RecursiveAction
	 * that initializes a large int array with random numbers using a fork-join, work-stealing approach,
	 * and given this code fragment in which a valid instance of MyRecursiveInitClass is created:
	 *
	 * public static void main(String[] args) {
	 *   int[] myData = new int[10_000_000];
	 *   java.util.concurrent.ForkJoin fj =
	 *      new java.util.concurrent.ForkJoin();
	 *   MyRecursiveInitClass action = 
	 *     new MyRecursiveInitClass(myData, 0, myData.length);
	 *   fj.submit(action);
	 *   doStuff(myData);
	 * }
	 * 
	 * and assuming doStuff() expects myData to be fully initialized, 
	 * which are necessary for the code to compile and execute as specified? (Choose all that apply.)
	 * 
	 * A.  Nothing needs to change
	 * B.  fj must be an instance of ForkJoinPool
	 * C.  fj must be an instance of ForkJoinWorkerThread
	 * D.  fj must invoke invoke(action) instead of submit(action)
	 * E.  fj must invoke execute(action) instead of submit(action)
	 * F.  fj must invoke forkJoin(action) instead of submit(action)
	 * 
	 * B and D are correct. These changes use the API correctly.
	 * 
	 * A is incorrect, because the code will not compile as is. 
	 * C is incorrect based on the above. 
	 * E is incorrect because execute() does not guarantee synchronous completion. 
	 * F is incorrect because ForkJoinPool doesn't have a forkJoin() method.
	 * 
	 * คำอธิบาย:
	 * - B: fj ต้องเป็นอินสแตนซ์ของ ForkJoinPool เนื่องจาก ForkJoinPool เป็นคลาสที่เหมาะสมสำหรับการทำงานแบบ fork-join
	 * - D: ควรใช้ invoke(action) แทน submit(action) เพราะ invoke() จะรัน action และรอจนกระทั่งเสร็จสมบูรณ์ 
	 * - A: ข้อนี้ไม่ถูกต้อง เพราะโค้ดในรูปแบบปัจจุบันจะไม่สามารถคอมไพล์ได้
	 * - C: ข้อนี้ไม่ถูกต้อง เพราะ fj ไม่จำเป็นต้องเป็น ForkJoinWorkerThread
	 * - E: ข้อนี้ไม่ถูกต้อง เนื่องจาก execute() ไม่รับประกันว่าการทำงานจะเสร็จสิ้นอย่างสมบูรณ์แบบ (synchronous completion)
	 * - F: ข้อนี้ไม่ถูกต้อง เพราะ ForkJoinPool ไม่มีเมธอดชื่อ forkJoin()
	 */

}
