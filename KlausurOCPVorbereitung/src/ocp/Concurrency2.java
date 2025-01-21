package ocp;

public class Concurrency2 {

	/*
	 * int result = IntStream.iterate(0, i -> i + 1)
	 *                       .limit(10)
	 *                       .parallel() // line L1
	 *                       .peek(System.out::println)
	 *                       .sum();
	 * 
	 * Which are true? (Choose all that apply.)
	 * 
	 * A. The output will be ordered from 0 to 9
	 * 
	 * B. The output will be unpredictable
	 * 
	 * C. The result is 10
	 * 
	 * D. If line L1 is removed, the output will be ordered from 0 to 9
	 * 
	 * E. If line L1 is removed, the output will be unpredictable
	 * 
	 * F. Compilation fails
	 * 
	 * B and D are correct. 
	 * We're generating numbers 0 – 9; we call parallel() so peek() will produce unpredictable output. 
	 * Removing parallel() means peek() will produce predictable output (the numbers 0 – 9 in order).
	 * 
	 * A, C, E, and F are incorrect.
	 * 
	 * คำอธิบาย:
	 * - B: ถูกต้อง เพราะเมื่อใช้ parallel() (บรรทัด L1) จะทำให้คำสั่ง peek() แสดงผลลัพธ์ที่ไม่เป็นระเบียบ (unpredictable) 
	 *      เนื่องจากการประมวลผลแบบขนาน (parallel processing)
	 * - D: ถูกต้อง ถ้าลบบรรทัด L1 ออก (ไม่ใช้ parallel()) คำสั่ง peek() จะแสดงผลลัพธ์เป็นตัวเลขเรียงลำดับจาก 0 ถึง 9 อย่างถูกต้อง
	 * - A: ไม่ถูกต้อง เพราะผลลัพธ์จะไม่เรียงลำดับหากใช้ parallel()
	 * - C: ไม่ถูกต้อง เนื่องจาก sum() จะคืนผลรวมของตัวเลข ไม่ใช่ 10 (ผลรวมจริงคือ 45)
	 * - E: ไม่ถูกต้อง เพราะเมื่อไม่มี parallel() ผลลัพธ์จะเรียงลำดับ (ordered) 
	 * - F: ไม่ถูกต้อง โค้ดนี้สามารถคอมไพล์ได้อย่างถูกต้อง
	 */

	
}
