package ocp;

public class DateTime7 {

	/*
	 * LocalDateTime ldt1 = LocalDateTime.parse(
	 *     "_F1_-11-_F2_ 08:_F3_:00", 
	 *     DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:_F4_"));
	 * LocalDateTime ldt2 = LocalDateTime.of(2018, _F5_, 3, 8, 3, 0);
	 * System.out.println(ldt1.equals(ldt2));
	 * 
	 * Which sets of code fragments can you use for F1, F2, F3, F4, and F5 so that the result of the code displays: true? (Choose all that apply.)
	 * 
	 * A.
	 * F1: 2018, F2: 03, F3: 03, F4: ss, F5: 11
	 * 
	 * B.
	 * F1: 2018, F2: 3, F3: 3, F4: ss, F5: 11
	 * 
	 * C.
	 * F1: 2018, F2: 03, F3: 03, F4: ss, F5: Month.NOVEMBER
	 * 
	 * D.
	 * F1: 2018, F2: 3, F3: 3, F4: SS, F5: Month.NOVEMBER
	 * 
	 * A and C are correct. The first string argument to parse() must match the format in the call to DateTimeFormatter.ofPattern(), 
	 * so we need a year (2018) and a day (03, note you must use 03, not 3!), and then minutes (03). We're providing "00" as the seconds 
	 * so we must use "ss" in the format string. For F5 we can use either 11 (the number of November) or the Month.NOVEMBER constant in the java.time.* package.
	 * 
	 * B and D are incorrect.
	 * 
	 * คำอธิบาย:
	 * - A: ใช้ F1 = 2018, F2 = 03, F3 = 03, F4 = ss, F5 = 11 จะทำให้ทั้งสอง LocalDateTime มีค่าเหมือนกัน เนื่องจากปี, วัน, นาที และวินาทีตรงกับกัน
	 * - B: ข้อนี้ไม่ถูกต้อง เนื่องจากใน F2 และ F3 ค่าของวันที่และนาทีต้องใช้รูปแบบ "03" ไม่ใช่ "3"
	 * - C: ใช้ F1 = 2018, F2 = 03, F3 = 03, F4 = ss, F5 = Month.NOVEMBER ก็ถูกต้อง เนื่องจากเราสามารถใช้ Month.NOVEMBER ใน F5 แทนค่า "11"
	 * - D: ข้อนี้ไม่ถูกต้อง เนื่องจาก F4 ต้องใช้ "ss" (วินาที) ไม่ใช่ "SS" (ขนาดของวินาที)
	 */

	
}
