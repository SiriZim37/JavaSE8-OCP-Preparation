package ocp;

public class Funtional9 {

	/*
	 * Which statements are true? (Choose all that apply.)
	 * 
	 * A.  BiConsumer is an operation that takes two arguments and returns one result.
	 * 
	 * B.  BiFunction is a function that takes two arguments and returns a result.
	 * 
	 * C.  BiSupplier is an operation that takes no arguments and returns an object with two results.
	 * 
	 * D.  BiPredicate is a test operation that takes two arguments and returns true or false.
	 * 
	 * E.  BiOperator is an operation that takes two arguments of the same type and returns a result of 
	 *     the same type as the arguments.
	 * 
	 * F.  DoubleBinaryOperator is an operation that takes two arguments of type double and returns 
	 *     a result of type double.
	 * 
	 * B, D, and F are correct.
	 * 
	 * A, C, and E are incorrect. 
	 * - In A, BiConsumer returns no result. 
	 * - In C, there is no such thing as a BiSupplier! 
	 * - In E, it’s BinaryOperator, not BiOperator. This is tricky, because all the others are "Bi."
	 * 
	 * คำอธิบาย:
	 * - A: ไม่ถูกต้อง เพราะ BiConsumer เป็น operation ที่รับค่า 2 arguments แต่ **ไม่มีการคืนค่า** 
	 * - B: ถูกต้อง เพราะ BiFunction เป็นฟังก์ชันที่รับค่า 2 arguments และ **คืนค่าผลลัพธ์หนึ่งค่า**
	 * - C: ไม่ถูกต้อง เพราะไม่มีสิ่งที่เรียกว่า BiSupplier ใน Java 
	 * - D: ถูกต้อง เพราะ BiPredicate ใช้ในการทดสอบ รับค่า 2 arguments และคืนค่าผลลัพธ์เป็น `true` หรือ `false`
	 * - E: ไม่ถูกต้อง เพราะไม่มีสิ่งที่เรียกว่า BiOperator; ชื่อที่ถูกต้องคือ BinaryOperator ซึ่งรับค่า 2 arguments 
	 *      ชนิดเดียวกันและคืนค่าผลลัพธ์ชนิดเดียวกับ arguments
	 * - F: ถูกต้อง เพราะ DoubleBinaryOperator เป็น operation ที่รับ arguments 2 ค่าเป็น `double` 
	 *      และคืนค่าผลลัพธ์ชนิด `double`
	 */

	
}
