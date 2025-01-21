package ocp;

import java.time.ZonedDateTime;

public class DateTimeLocal1 {

	public static void main(String[] args) {
		
		ZonedDateTime zd = ZonedDateTime.parse("2020-05-04T08:05:05");
		System.out.println(zd.getMonth() + " " +zd.getDayOfMonth());
	
	// compiler OK aber Exception because no time zone 
		/*
		 * ZonedDateTime:

		เป็นคลาสที่ใช้สำหรับจัดการวันเวลาแบบ "มีโซนเวลา" เช่น Asia/Bangkok หรือ UTC+7
		เมธอด parse จะใช้ในการแปลงข้อความ (ISO-8601 format) เป็น ZonedDateTime
		ข้อความที่ใช้ใน parse:
		
		"2020-05-04T08:05:05" เป็นข้อความในรูปแบบวันที่และเวลา แต่ ไม่มีโซนเวลา (เช่น +07:00 หรือ Asia/Bangkok) ดังนั้นจะเกิด Exception ขึ้นใน runtime
		ผลลัพธ์ของโค้ดนี้:
		
		ในตอนคอมไพล์โค้ดไม่มีปัญหา (เพราะโครงสร้างโค้ดถูกต้อง)
		แต่ในตอนรันโปรแกรม (runtime) จะเกิด DateTimeParseException เนื่องจากข้อความ "2020-05-04T08:05:05" ไม่มีข้อมูลโซนเวลา
		 */
		
		//-------------------------------------------------------------
		
		//solve 
		ZonedDateTime zd2 = ZonedDateTime.parse("2020-05-04T08:05:05+07:00[Asia/Bangkok]");
		System.out.println(zd2.getMonth() + " " + zd2.getDayOfMonth());

	}
}
