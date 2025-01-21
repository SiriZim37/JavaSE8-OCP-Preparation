package ocp;

public class DateTime1 {

	/*
	 * Which will produce the following output in the console?
	 * 2018-12-01T10:10
	 * Choose all that apply.
	 * 
	 * A.
	 * LocalDateTime ldt1 = 
	 *     LocalDateTime.of(LocalDate.of(2018, 12, 1), LocalTime.of(10, 10, 0));
	 * System.out.println(ldt1);
	 * 
	 * B.
	 * LocalDateTime ldt2 = LocalDateTime.of(2018, 12, 1, 10, 10, 0);
	 * System.out.println(ldt2);
	 * 
	 * C.
	 * LocalDateTime ldt3 = LocalDateTime.parse("2018-12-1T10:10");
	 * System.out.println(ldt3);
	 * 
	 * D.
	 * LocalDateTime ldt4 = LocalDateTime.of(2018, 11, 1, 10, 10, 0).plusMonths(1);
	 * System.out.println(ldt4);
	 * 
	 * E.
	 * LocalDateTime ldt5 = 
	 *      LocalDateTime.of(2018, Month.DECEMBER, 1, LocalTime.of(10, 10, 0));
	 * System.out.println(ldt5);
	 * 
	 * A, B, and D are correct.
	 * C and E are incorrect. C is missing a "0" in front of the day of the month, 
	 * and this will cause a DateTimeParseException. E is mixing two ways to initialize 
	 * a LocalDateTime; you must either use a LocalDate and LocalTime, as in A, 
	 * or specify numbers for all values, as in B.
	 * 
	 * คำอธิบาย:
	 * - A: ถูกต้อง เนื่องจากการใช้ `LocalDate.of()` และ `LocalTime.of()` 
	 *   มารวมกันด้วย `LocalDateTime.of()` จะสร้าง LocalDateTime ที่ต้องการ
	 * - B: ถูกต้อง การใช้ `LocalDateTime.of()` โดยตรงด้วยการระบุปี เดือน วัน ชั่วโมง นาที
	 * - C: ไม่ถูกต้อง ขาดการใส่ "0" หน้าในวันที่เป็น "2018-12-01T10:10" 
	 *   ซึ่งจะทำให้เกิด `DateTimeParseException`
	 * - D: ถูกต้อง ใช้การเพิ่มเดือนด้วย `plusMonths(1)` จากวันที่ 1 พฤศจิกายน 
	 *   จึงได้วันที่ 1 ธันวาคม
	 * - E: ไม่ถูกต้อง เพราะการใช้ทั้ง `Month.DECEMBER` และ `LocalTime.of()` 
	 *   ไม่ถูกต้องในการสร้าง LocalDateTime คุณต้องเลือกวิธีใดวิธีหนึ่ง
	 */

	
}
