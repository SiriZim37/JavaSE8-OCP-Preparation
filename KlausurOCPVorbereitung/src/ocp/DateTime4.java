package ocp;

public class DateTime4 {

	/*
	 * In 2018 in the United States, Daylight Saving Time began on March 11 at 2:00 a.m., 
	 * and we moved the clocks forward from 2:00 to 3:00 a.m. Given the code fragment:
	 * 
	 * ZonedDateTime zdt = ZonedDateTime.of(
	 *      LocalDateTime.of(2018, 3, 11, 2, 30), ZoneId.of("US/Pacific"));
	 * System.out.println(zdt.getHour() + ":" + zdt.getMinute());
	 * 
	 * What is the result?
	 * 
	 * A. 1:30
	 * B. 2:30
	 * C. 3:30
	 * D. Runtime exception
	 * E. Result depends on JVM Time Zone settings
	 * 
	 * C is correct. We put the clocks forward at 2:00 a.m. to 3:00 a.m., so the time 2:30 a.m. 
	 * doesn't exist on March 11, 2018. So, we see 3:30 a.m. If you change the time to 3:30 a.m. 
	 * you will see 3:30 a.m. as well.
	 * 
	 * A, B, D, and E are incorrect.
	 * 
	 * คำอธิบาย:
	 * - การเริ่มต้นเวลาบันทึกฤดูร้อน (Daylight Saving Time) ในปี 2018 ที่สหรัฐอเมริกาเริ่มในวันที่ 11 มีนาคม เวลา 2:00 น.
	 *   และเราจะเลื่อนเวลาไปข้างหน้า 1 ชั่วโมงจากเวลา 2:00 น. เป็น 3:00 น.
	 * - ดังนั้น เวลาที่ระบุในโค้ด 2:30 น. ในวันที่ 11 มีนาคม 2018 จะไม่สามารถแสดงผลได้ เพราะเวลา 2:30 น. นั้นไม่เคยมี
	 *   เมื่อเลื่อนเวลาขึ้นไปเป็น 3:00 น. จึงเห็นผลลัพธ์เป็น 3:30 น.
	 * - หากเปลี่ยนเวลาในโค้ดเป็น 3:30 น. ก็จะเห็นผลลัพธ์เป็น 3:30 น. เช่นกัน
	 * 
	 * ข้อ A, B, D และ E เป็นคำตอบที่ไม่ถูกต้อง
	 */

	
}
