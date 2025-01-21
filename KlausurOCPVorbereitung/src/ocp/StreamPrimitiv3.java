package ocp;

public class StreamPrimitiv3 {
	/*
	 * What is the result of the following code?
	 * 
	 * IntStream is = IntStream.rangeClosed(0, 20);
	 * System.out.println(is.count());
	 * 
	 * A. 0
	 * B. 20
	 * C. 21
	 * D. 22
	 * E. The code does not compile
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Answer: C is correct.
	 * 
	 * Explanation:
	 * - The `rangeClosed()` method in `IntStream` generates a stream of integers that includes both 
	 *   the start value (0) and the end value (20). This means it produces a stream with integers 
	 *   from 0 to 20, inclusive.
	 * - Therefore, the stream contains 21 integers in total: {0, 1, 2, ..., 20}.
	 * - The `count()` method counts the total number of elements in the stream, so the result is `21`.
	 * 
	 * Why others are incorrect:
	 * - A (0): Incorrect because the stream is not empty; it contains 21 integers.
	 * - B (20): Incorrect because `rangeClosed()` includes the endpoint, making it 21 elements, not 20.
	 * - D (22): Incorrect because the stream only spans from 0 to 20, totaling 21 elements, not 22.
	 * - E (Does not compile): Incorrect because the code is syntactically correct and compiles without error.
	 * 
	 * คำอธิบายภาษาไทย:
	 * - เมธอด `rangeClosed(0, 20)` ใน `IntStream` สร้างสตรีมที่มีตัวเลขตั้งแต่ 0 ถึง 20 รวมถึงตัวเลขต้นและปลาย
	 *   ดังนั้น สตรีมจะมีตัวเลขทั้งหมด 21 ตัว คือ {0, 1, 2, ..., 20}
	 * - เมธอด `count()` ใช้นับจำนวนตัวเลขในสตรีม ซึ่งในที่นี้มีทั้งหมด 21 ตัว
	 * 
	 * เหตุผลที่ตัวเลือกอื่นไม่ถูกต้อง:
	 * - A (0): ไม่ถูกต้อง เพราะสตรีมไม่ว่าง แต่มีตัวเลข 21 ตัว
	 * - B (20): ไม่ถูกต้อง เพราะ `rangeClosed()` รวมจุดสิ้นสุดไว้ด้วย ทำให้มีทั้งหมด 21 ตัว ไม่ใช่ 20
	 * - D (22): ไม่ถูกต้อง เพราะสตรีมมีตัวเลขตั้งแต่ 0 ถึง 20 เท่านั้น รวมกันได้ 21 ตัว ไม่ใช่ 22
	 * - E (Does not compile): ไม่ถูกต้อง เพราะโค้ดนี้ถูกต้องและคอมไพล์ได้โดยไม่มีข้อผิดพลาด
	 */

}
