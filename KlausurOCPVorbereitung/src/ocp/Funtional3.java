package ocp;

public class Funtional3 {

	/*
	 * Which statements are true about the Function functional interface? (Choose all that apply.)
	 * 
	 * A.  It has one abstract method.
	 * 
	 * B.  Its abstract method takes one argument (an object) and produces a result (an object).
	 * 
	 * C.  It has at least one nonabstract method.
	 * 
	 * D.  Its abstract method is named apply().
	 * 
	 * E.  It must be defined with the @FunctionalInterface annotation.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * A, B, C, and D are correct statements.
	 * E is incorrect. Functional interfaces are functional even without the optional @FunctionalInterface annotation.
	 * 
	 * 
	 * 
	 * คำอธิบายเพิ่มเติม:
	 * - A: ถูกต้อง เพราะอินเทอร์เฟซ Function มีเมธอดนามธรรมเพียงตัวเดียว คือ apply() ซึ่งเป็นไปตามคุณสมบัติของ Functional Interface
	 * - B: ถูกต้อง เพราะเมธอด apply() รับอาร์กิวเมนต์ 1 ตัว และคืนค่าผลลัพธ์ 1 ตัว โดยทั้งอาร์กิวเมนต์และผลลัพธ์เป็นอ็อบเจ็กต์
	 * - C: ถูกต้อง เพราะอินเทอร์เฟซ Function ยังมีเมธอดอื่นที่ไม่เป็นนามธรรม เช่น default methods หรือเมธอดจาก Object
	 * - D: ถูกต้อง เพราะชื่อของเมธอดนามธรรมใน Function คือ apply()
	 * - E: ไม่ถูกต้อง เพราะแม้จะไม่มี @FunctionalInterface ก็ตาม อินเทอร์เฟซนี้ยังคงเป็น Functional Interface ได้หากมีเมธอดนามธรรมเพียงตัวเดียว
	 * 
	 * ทำไม A ถึงถูก: อินเทอร์เฟซ Function มีเมธอดนามธรรมเพียงตัวเดียวตามหลักการของ Functional Interface
	 * 
	 * ทำไม B ถึงถูก: ลักษณะการทำงานของ apply() คือการรับค่า 1 ค่า (input) และส่งค่าผลลัพธ์ 1 ค่า (output) ซึ่งตรงกับคำอธิบาย
	 * 
	 * ทำไม C ถึงถูก: ใน Java 8 อินเทอร์เฟซสามารถมี default methods หรือ static methods ซึ่งเป็นเมธอดที่ไม่เป็นนามธรรม
	 * 
	 * ทำไม D ถึงถูก: apply() เป็นชื่อของเมธอดหลักใน Function ซึ่งต้องมีเพื่อให้ใช้งานได้
	 * 
	 * ทำไม E ถึงไม่ถูก: คำอธิบายของ Functional Interface ไม่ได้บังคับให้ต้องมี @FunctionalInterface annotation 
	 * การใส่ annotation เป็นเพียงตัวช่วยเพิ่มความชัดเจนและป้องกันข้อผิดพลาด
	 */

	
}
