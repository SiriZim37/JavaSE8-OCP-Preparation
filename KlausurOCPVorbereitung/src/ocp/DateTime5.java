package ocp;

public class DateTime5 {

	/*
	 * If today is January 19, 2018, and the time is 1:08 and 59 seconds and 618 milliseconds in the afternoon, 
	 * and given:
	 * System.out.println(LocalDateTime.now());
	 * What is the result?
	 *
	 * A.  2018-01-19 01:08:59.618 PM
	 * 
	 * B.  2018-01-19 13:08:59.618
	 * 
	 * C.  2018-01-19T01:08:59.618PM
	 * 
	 * D.  2018-1-19T13:8:59:618
	 * 
	 * E.  2018-01-19T13:08:59.618
	 * 
	 * E is correct.
	 * 
	 * A, B, C, and D are incorrect. In A, B, and C, there are no spaces in the output and no "PM". In D there should be 0s in front of the month and the minutes numbers.
	 * 
	 * คำอธิบาย:
	 * - A, B, C, และ D ไม่ถูกต้อง เพราะรูปแบบการแสดงผลไม่ตรงกับรูปแบบที่ `LocalDateTime.now()` จะให้
	 * - E ถูกต้อง เพราะ `LocalDateTime` จะให้ผลลัพธ์ในรูปแบบ `yyyy-MM-ddTHH:mm:ss.SSS`
	 * - ใน A, B, และ C ไม่มีช่องว่างหลังวันที่ และใน C ไม่มี "PM" แม้ว่าจะเป็นเวลาในช่วงบ่าย
	 * - ใน D เดือนและนาทีควรจะมี 0 ข้างหน้าเมื่อเป็นเลขหลักเดียว
	 */

	
}
