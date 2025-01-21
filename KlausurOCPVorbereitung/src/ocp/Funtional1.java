package ocp;

public class Funtional1 {

	/*
	 * Which of the following will compile correctly? (Choose all that apply.)
	 * 
	 * A. Function f = (p) -> { p = p + 3; return p; };
	 * 
	 * B. Function f = (p) -> p = p + 3;
	 * 
	 * C. IntFunction f = (p) -> p = p + 3;
	 * 
	 * D. Function f = (Integer p) -> p = p + 3;
	 * 
	 * E. Function<Integer> f = (Integer p) -> p = p + 3;
	 * 
	 * F. Function<Integer, Integer> f = (Integer p) -> p = p + 3;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * C and F are correct:
	 * - C: f เป็น IntFunction ซึ่งรองรับค่า int และคืนค่ากลับเป็น int ได้ถูกต้องตามข้อกำหนด
	 * - F: f เป็น Function ที่กำหนดประเภทพารามิเตอร์เป็น Integer และผลลัพธ์ที่คืนค่ากลับก็เป็น Integer ซึ่งถูกต้อง
	 * 
	 * A, B, D, และ E เป็นข้อที่ผิด:
	 * - A: Function f คาดว่าจะใช้ Object เป็นพารามิเตอร์ แต่ p ในที่นี้คือ int ซึ่งขัดกับความคาดหวัง
	 * - B: เช่นเดียวกับ A, Function f คาดว่าจะใช้ Object แต่ p เป็น int ซึ่งไม่สามารถนำมาใช้ได้
	 * - D: Function f คาดว่าจะใช้ Object แต่ p กำหนดเป็น Integer ทำให้เกิดการขัดแย้งในประเภทข้อมูล
	 * - E: การกำหนด Function ในกรณีนี้ต้องระบุทั้งประเภทพารามิเตอร์และผลลัพธ์ที่คืนค่า แต่ในตัวเลือกนี้กำหนดเฉพาะประเภทเดียวเท่านั้น
	 * 
	 * คำอธิบายเพิ่มเติม:
	 * - A, B: ปัญหาอยู่ที่ไม่ได้กำหนดประเภทของตัวแปร p อย่างชัดเจน ดังนั้น Java จะถือว่าเป็น Object แต่โค้ดกำลังใช้ int ซึ่งทำให้เกิดปัญหา
	 * - C: IntFunction ออกแบบมาให้รองรับ int โดยตรง ทำให้ไม่มีปัญหากับตัวแปร p ที่เป็น int
	 * - D: แม้ว่า Integer p จะดูเหมือนถูกต้อง แต่ Function f คาดว่าจะใช้ Object เป็นพารามิเตอร์ ไม่ใช่ Integer โดยเฉพาะ
	 * - E: Function ต้องการกำหนดทั้งประเภทพารามิเตอร์ (Input Type) และประเภทของค่าที่คืนค่า (Return Type) การระบุเฉพาะพารามิเตอร์นั้นไม่เพียงพอ
	 * - F: การกำหนดประเภททั้งพารามิเตอร์และค่าที่คืนค่าชัดเจนทำให้ Function ทำงานได้ถูกต้อง
	 */

	
}
