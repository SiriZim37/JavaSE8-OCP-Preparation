package ocp;

public class DateTime2 {

	/*
	 * In 2018 in the United States, Daylight Saving Time ends on November 4 at 2:00 a.m., 
	 * when the clocks are moved back from 2:00 a.m. to 1:00 a.m.
	 * 
	 * Given:
	 * 
	 * ZonedDateTime zdt1 = ZonedDateTime.of(
	 *     LocalDateTime.of(2018, 11, 3, 22, 0), ZoneId.of("US/Pacific"));
	 * ZonedDateTime zdt2 = ZonedDateTime.of(
	 *     LocalDateTime.of(2018, 11, 4, 6, 0), ZoneId.of("US/Pacific"));
	 * Instant i1 = Instant.from(zdt1);
	 * Instant i2 = Instant.from(zdt2);
	 * System.out.println(ChronoUnit.HOURS.between(i1, i2));
	 * 
	 * What is the result?
	 * 
	 * A. 7
	 * 
	 * B. 8
	 * 
	 * C. 9
	 * 
	 * D. Runtime exception
	 * 
	 * E. Result depends on JVM Time Zone settings
	 * 
	 * C is correct. We put the clocks backward, so we gain an hour between November 3 10:00 p.m. 
	 * and November 4 6:00 a.m. So rather than eight hours, the number of hours between 10:00 p.m. 
	 * and 6:00 a.m. is nine hours.
	 * 
	 * A, B, D, and E are incorrect.
	 * 
	 * คำอธิบาย:
	 * - ข้อ A: ไม่ถูกต้อง เพราะเมื่อปรับเวลาให้ย้อนกลับไปหนึ่งชั่วโมงระหว่างวันที่ 3 พฤศจิกายน 22:00 น. และวันที่ 4 พฤศจิกายน 6:00 น. จะได้ระยะเวลา 9 ชั่วโมง ไม่ใช่ 7 ชั่วโมง
	 * - ข้อ B: ไม่ถูกต้องเช่นกัน เนื่องจากเวลาไม่ตรงกับผลลัพธ์ที่เกิดขึ้นหลังจากปรับเวลา
	 * - ข้อ C: ถูกต้อง เพราะระหว่าง 22:00 น. วันที่ 3 พฤศจิกายน และ 6:00 น. วันที่ 4 พฤศจิกายนจะมีระยะเวลา 9 ชั่วโมง หลังจากการปรับเวลาลดลงหนึ่งชั่วโมง
	 * - ข้อ D: ไม่มีข้อผิดพลาดในการทำงาน ดังนั้นจะไม่เกิด runtime exception
	 * - ข้อ E: ผลลัพธ์ไม่ขึ้นอยู่กับการตั้งเวลาใน JVM เนื่องจากเป็นการคำนวณตามเขตเวลา
	 */

	
}
