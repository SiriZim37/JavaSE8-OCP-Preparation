package ocp;

public class Funtional8 {

	/*
	 * >_____________ tt = (a, b) -> {          // line 1
	 *   return a*a + b*b;
	 * };
	 * int ss = tt._____________(2, 3);         // line 4
	 * System.out.println("Sum of squares: " + ss);
	 * 
	 * Which one of the following would you insert in line 1 (the type) and line 4 (the method name) so that 
	 * the code fragment compiles, runs, and produces the output 13?
	 * 
	 * A. IntBinaryOperator, apply
	 * B. BiFunction<Integer, Integer>, apply
	 * C. IntBinaryOperator, accept
	 * D. IntBinaryOperator, applyAsInt
	 * E. BinaryOperator<Integer>, apply
	 * 
	 * D and E are correct. The lambda expression takes two ints and returns an int (on line 4), so an 
	 * IntBinaryOperator is appropriate (D). The abstract method in the IntBinaryOperator functional interface 
	 * is applyAsInt. E also works because the primitive ints are autoboxed and unboxed. If you want to avoid 
	 * autoboxing, D is the better solution.
	 * 
	 * A, B, and C are incorrect. A is incorrect; apply is not the correct function name for a primitive 
	 * functional interface. B is incorrect because a BiFunction of this type would return an Integer, 
	 * not an int. C is incorrect because accept is not the correct function name for an operator 
	 * (it is the function name for a Consumer).
	 * 
	 * คำอธิบาย:
	 * - D และ E ถูกต้อง:
	 *   - D: ใช้ `IntBinaryOperator` ซึ่งเป็น functional interface ที่ออกแบบมาสำหรับการรับค่าจำนวนเต็มสองตัวและส่งคืนค่าจำนวนเต็มหนึ่งตัว
	 *     โดยใช้เมธอด `applyAsInt` ซึ่งเป็นเมธอดที่เหมาะสมสำหรับ primitive type int
	 *   - E: ใช้ `BinaryOperator<Integer>` ได้เช่นกัน แต่ในกรณีนี้ตัวเลขจะต้องผ่านกระบวนการ autoboxing และ unboxing 
	 *     ซึ่งทำให้ประสิทธิภาพลดลงเล็กน้อยเมื่อเทียบกับ D
	 * 
	 * - A, B, และ C ไม่ถูกต้อง:
	 *   - A: ไม่ถูกต้องเพราะ `apply` ไม่ใช่ชื่อฟังก์ชันที่ถูกต้องสำหรับ functional interface แบบ primitive (ควรใช้ `applyAsInt`)
	 *   - B: ไม่ถูกต้องเพราะ `BiFunction` มีการส่งคืนค่าประเภท `Integer` ซึ่งไม่ตรงกับคำตอบที่ต้องการเป็น `int`
	 *   - C: ไม่ถูกต้องเพราะ `accept` เป็นชื่อเมธอดสำหรับ `Consumer` และไม่ได้เกี่ยวข้องกับ `IntBinaryOperator`
	 */

	
}
