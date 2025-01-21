package ocp;

public class Concurrency11 {
	/*
	 * Which are true about concurrent collections? (Choose all that apply.)
	 * 
	 * A. A CyclicBarrier is typically used to serialize the execution of the threads under its control.
	 * 
	 * B. A CyclicBarrier can be used to control some or all of an application's threads.
	 * 
	 * C. An application that makes heavy use of synchronized code might be improved by using (if possible) 
	 *    ConcurrentSkipListMap or ConcurrentSkipListSet instead.
	 * 
	 * D. Blocking queues are thread-safe because they make a copy of the queue whenever a mutating operation is performed.
	 * 
	 * E. If a concurrent collection has N elements and each element has state, both the number of elements and 
	 *    the state in element will be thread-safe.
	 * 
	 * B and C are correct statements.
	 * A is incorrect because serialized execution is NOT a design intention of CyclicBarriers. 
	 * D is incorrect; it describes an aspect of CopyOnWrite collections, not blocking queues.
	 * E is incorrect because the state of elements in a concurrent collection is not thread-safe.
	 * 
	 * คำอธิบาย:
	 * - A: ข้อนี้ไม่ถูกต้อง เพราะ CyclicBarrier ถูกออกแบบมาเพื่อให้เธรดสามารถ "รอ" กันโดยไม่ต้องควบคุมการทำงานของเธรด
	 * - B: ถูกต้อง เพราะ CyclicBarrier สามารถใช้ควบคุมการทำงานของเธรดหลายๆ ตัวในแอปพลิเคชันได้
	 * - C: ถูกต้อง เพราะการใช้ ConcurrentSkipListMap หรือ ConcurrentSkipListSet แทนการใช้ synchronized อาจช่วยปรับปรุงประสิทธิภาพ
	 * - D: ข้อนี้ไม่ถูกต้อง เนื่องจาก BlockingQueue ไม่มีการคัดลอกคิว แต่จะควบคุมการเข้าถึงแบบปลอดภัยจากหลายๆ เธรด
	 * - E: ข้อนี้ไม่ถูกต้อง เพราะถึงแม้คอลเลกชันจะเป็น concurrent แต่การที่ข้อมูลในแต่ละตัวจะปลอดภัยจากการเข้าถึงพร้อมกันไม่ได้หมายความว่า "สถานะ" ของแต่ละตัวจะปลอดภัยด้วย
	 */

}
