package ocp;

public class Concurrency10 {
	/*
	 * Which are true? (Choose all that apply.)
	 * 
	 * A. The condition of "waiting for a resource" can be used to describe either deadlocking or starvation.
	 * 
	 * B. Deadlocking is aptly named since it usually involves a misapplication of object locks.
	 * 
	 * C. Livelocking can only occur when a class has a combination of synchronized and nonsynchronized methods.
	 * 
	 * D. Race conditions occur when an object is running code in a synchronized method and that synchronized 
	 *    method attempts to invoke another of that object's synchronized methods.
	 * 
	 * E. Deadlocking occurs when two objects of the same class, running simultaneously from different synchronized 
	 *    methods, attempt to invoke the method that the other is currently executing.
	 * 
	 * A and B are correct statements.
	 * 
	 * C is incorrect. The legal combination of synchronized and nonsynchronized methods is orthogonal to livelocking. 
	 * D is incorrect; it's fine for one synchronized method to invoke another synchronized method. 
	 * E is incorrect because once one object of a class is executing ANY of the class's synchronized methods, 
	 * no other objects can invoke ANY of that class's other synchronized methods.
	 * 
	 * คำอธิบาย:
	 * - A: เงื่อนไขของ "การรอทรัพยากร" สามารถอธิบายได้ทั้ง deadlocking และ starvation เนื่องจากทั้งสองเกิดจากการที่ทรัพยากรไม่พร้อมใช้งาน
	 * - B: Deadlocking เกิดจากการใช้งาน object locks ที่ผิดพลาด ซึ่งชื่อของมันก็สื่อถึงสถานการณ์นี้ได้ดี
	 * - C: ไม่ถูกต้อง เนื่องจาก livelocking ไม่ได้ขึ้นอยู่กับการมีวิธีการที่เป็น synchronized และ nonsynchronized รวมกัน
	 * - D: ไม่ถูกต้อง เพราะ synchronized method สามารถเรียก synchronized method อื่นใน object เดียวกันได้โดยไม่มีปัญหา
	 * - E: ไม่ถูกต้อง เนื่องจากเมื่อ object ใด object หนึ่งกำลังเรียก synchronized method อยู่ จะไม่มี object อื่นใดสามารถเรียก synchronized method ใด ๆ ของ class นั้นได้จนกว่าจะเสร็จสิ้น
	 */

}
