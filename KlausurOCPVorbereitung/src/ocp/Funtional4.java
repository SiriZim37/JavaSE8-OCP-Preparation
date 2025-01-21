package ocp;

interface SuperrDuperr {
	   default String superr() { return "super"; }
	   static String duperr() { return "duper"; }
	   public String superrduperr(); 
	 }
	 interface Duperr extends SuperrDuperr {
	   default String duperr() { return "really duper!"; }
	 }
	 class Test { 
	   public String testDuperr(SuperrDuperr supdup) {
	     return supdup.superrduperr();
	   }
	 }
	 
public class Funtional4 {

	public static void main(String[] args) {
		Test t = new Test();
		
		SuperrDuperr sd = new SuperrDuperr() {
			 public String superrduperr() { return "really super duper!"; }
		};
			 
		System.out.println(t.testDuperr(sd));
	}
	/*
	 * Given the following interfaces and class:
	 * 
	 * interface SuperrDuperr {
	 *   default String superr() { return "super"; }
	 *   static String duperr() { return "duper"; }
	 *   public String superrduperr(); 
	 * }
	 * interface Duperr extends SuperrDuperr {
	 *   default String duperr() { return "really duper!"; }
	 * }
	 * class Test { 
	 *   public String testDuperr(SuperrDuperr supdup) {
	 *     return supdup.superrduperr();
	 *   }
	 * }
	 * 
	 * And:
	 * 
	 * Test t = new Test();
	 * System.out.println(t.testDuperr(sd));
	 * 
	 * Which definition(s) of `sd` will cause the code to compile, run, and print "really super duper!"?
	 * 
	 * A.	SuperrDuperr sd = new SuperrDuperr() {
	 *      public String superrduperr() { return "really super duper!"; }
	 *    };
	 * 
	 * B.	SuperrDuperr sd = new SuperrDuperr() {
	 *      public String duperr() { return "really super duper!"; }
	 *    };
	 * 
	 * C.	Duperr sd = () -> "really super duper!";
	 * 
	 * D.	SuperrDuperr sd = (v) -> v.apply("really super duper!");
	 * 
	 * E.	SuperrDuperr sd = () -> "really super duper!";
	 * 
	 * 
	 * Correct Answers: A, C, and E
	 * 
	 * Explanation:
	 * - A: Correct. This creates an anonymous implementation of `SuperrDuperr` and provides the required 
	 *      implementation for the abstract method `superrduperr()`. This satisfies the contract of the interface.
	 * 
	 * - C: Correct. This creates a lambda expression that implements `Duperr`. Since `Duperr` extends 
	 *      `SuperrDuperr`, it inherits the abstract method `superrduperr()`. The lambda satisfies this requirement.
	 * 
	 * - E: Correct. This creates a lambda expression that directly implements `SuperrDuperr` and provides the 
	 *      required implementation of `superrduperr()`. This works as expected.
	 * 
	 * - B: Incorrect. The abstract method `superrduperr()` is not implemented. Overriding the `duperr()` method 
	 *      does not satisfy the contract of `SuperrDuperr`.
	 * 
	 * - D: Incorrect. The syntax `(v) -> v.apply(...)` is invalid for this context because `SuperrDuperr` 
	 *      does not define a functional method with this signature.
	 * 
	 * คำอธิบาย (ภาษาไทย):
	 * - A: ถูกต้อง เพราะในตัวเลือกนี้สร้าง class แบบนิรนามที่ implement `SuperrDuperr` และมีการ override 
	 *      เมธอด `superrduperr()` ที่เป็น abstract method ตามข้อกำหนดของ interface
	 * 
	 * - C: ถูกต้อง เพราะ lambda expression นี้ implement `Duperr` ซึ่งสืบทอด `SuperrDuperr` และด้วยเหตุนี้จึง
	 *      ได้รับ abstract method `superrduperr()` มาด้วย การให้ค่าใน lambda expression จึงถือว่าถูกต้อง
	 * 
	 * - E: ถูกต้อง เพราะ lambda expression นี้ implement `SuperrDuperr` โดยตรงและให้ค่าเมธอด `superrduperr()` 
	 *      ที่เป็น abstract method ได้อย่างถูกต้อง
	 * 
	 * - B: ไม่ถูกต้อง เพราะในตัวเลือกนี้ไม่ได้ implement เมธอด `superrduperr()` ที่เป็น abstract method 
	 *      แม้ว่าจะ override เมธอด `duperr()` ก็ตาม แต่ยังไม่พอที่จะทำให้ class นี้สมบูรณ์
	 * 
	 * - D: ไม่ถูกต้อง เพราะไวยากรณ์ `(v) -> v.apply(...)` ไม่ตรงกับลักษณะการทำงานของ `SuperrDuperr` 
	 *      เนื่องจาก interface นี้ไม่ได้มี functional method ที่รองรับ signature นี้
	 */

	
}
