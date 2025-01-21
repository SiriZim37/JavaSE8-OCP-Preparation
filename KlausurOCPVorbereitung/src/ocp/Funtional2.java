package ocp;

public class Funtional2 {

	/*
	 * class TestCompare {
	 *     public static void main(String[] args) {
	 *         boolean r = false;
	 *         // Line A
	 *         System.out.println("Result: " + r);
	 *     }
	 * }
	 * Which can be inserted at Line A independently to print "Result: true"?
	 * 
	 * A.  int x = 20, y = 10;
	 *     r = (x, y) -> x > y ? true : false;
	 * 
	 * B.  BiPredicate<Integer, Integer> c = (x, y) -> x > y ? true : false;
	 *     r = c.test(20,  10);
	 * 
	 * C.  BiPredicate c = (x, y) -> x > y ? true : false;
	 *     r = c.test(20,  10);
	 * 
	 * D.  BiPredicate<Integer, Integer> c = (x, y) -> x > y ? true : false;
	 *     r = c.compare(20,  10);
	 * 
	 * E.  Predicate<Integer> c = (x, y) -> x > y ? true : false;
	 *     r = c.test(20,  10);
	 * 
	 * 
	 * 
	 * 
	 * Correct Answer: B
	 * 
	 * Explanation:
	 * - B: Correct because BiPredicate is the correct functional interface for a lambda expression with two arguments, 
	 *      and the test() method is used correctly with arguments 20 and 10. 
	 * 
	 * Why others are incorrect:
	 * - A: Incorrect because we cannot assign a lambda expression directly to a boolean variable. Lambda expressions 
	 *      must be assigned to a functional interface reference.
	 * - C: Incorrect because the raw type BiPredicate is used without specifying type parameters. In this case, 
	 *      x and y default to Object type, and the > operator cannot be used with Object.
	 * - D: Incorrect because the method name compare() is not part of the BiPredicate interface. The correct method is test().
	 * - E: Incorrect because Predicate is designed for single-parameter lambdas, but this case requires two parameters. 
	 *      Additionally, type parameters are missing.
	 * 
	 * คำอธิบาย (ภาษาไทย):
	 * - B: ถูกต้อง เพราะ BiPredicate เป็น functional interface ที่เหมาะสมสำหรับ lambda expression ที่มี 2 พารามิเตอร์ 
	 *      และการเรียกใช้ test() นั้นถูกต้องด้วยอาร์กิวเมนต์ 20 และ 10
	 * 
	 * ทำไมข้ออื่นถึงผิด:
	 * - A: ผิด เนื่องจากไม่สามารถกำหนดค่า lambda expression ตรง ๆ ให้กับตัวแปร boolean ได้ ต้องกำหนดค่าให้กับ reference ของ functional interface ก่อน
	 * - C: ผิด เพราะ BiPredicate ถูกใช้เป็น raw type โดยไม่มีการระบุ type parameters ซึ่งทำให้ x และ y มี type เป็น Object 
	 *      และไม่สามารถใช้ตัวดำเนินการ > กับ Object ได้
	 * - D: ผิด เพราะไม่มี method ชื่อ compare() ใน BiPredicate interface วิธีที่ถูกต้องคือการใช้ test()
	 * - E: ผิด เพราะ Predicate ถูกออกแบบมาสำหรับ lambda expression ที่มีพารามิเตอร์เดียว แต่ในกรณีนี้ต้องใช้ 2 พารามิเตอร์ 
	 *      นอกจากนี้ ยังไม่มีการกำหนด type parameters อย่างถูกต้อง
	 */


	
}
