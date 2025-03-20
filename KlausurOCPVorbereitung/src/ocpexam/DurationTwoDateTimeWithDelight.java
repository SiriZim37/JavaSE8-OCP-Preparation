package ocpexam;

import java.time.Duration;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DurationTwoDateTimeWithDelight {

	public static void main(String[] args) {
		

		/*
		You are given two ZonedDateTime instances representing two times in different time zones. The first time is in GMT-3 and the second is in GMT-6. The first time is in Daylight Saving Time (DST), which affects the time zone.

		Calculate the duration between these two times in hours and minutes, considering that the second time might also be affected by DST.
		
		The following two times are given:
		
		First Time: 2018-11-03 22:00 GMT-3
		Second Time: 2018-11-04 06:00 GMT-6
		What will be the duration between these two times?
		Options:
		
		a) 8 hours
		b) 9 hours
		c) 7 hours
		d) 10 hours
		 */
		
		 ZonedDateTime date1 = ZonedDateTime.of(2018, 11, 3, 22, 0, 0, 0, ZoneOffset.ofHours(-3));
	     ZonedDateTime date2 = ZonedDateTime.of(2018, 11, 4, 6, 0, 0, 0, ZoneOffset.ofHours(-6));

	     Duration duration = Duration.between(date1, date2);

	     System.out.println("Duration between the two times: " + duration.toHours() + " hours and " + duration.toMinutes() % 60 + " minutes.");
	
	     
		/*
		 * 
		 ข้อมูลที่ให้มา:
			เวลาแรก: 2018-11-03 22:00 GMT-3 (ช่วง Daylight Saving Time - DST)
			เวลาที่สอง: 2018-11-04 06:00 GMT-6 (ไม่มีผล DST)
			
			1. เวลาแรก (2018-11-03 22:00 GMT-3)
				เวลานี้คือเวลา 22:00 ในโซนเวลา GMT-3
				หากเราแปลงเป็นเวลา UTC จะได้ 2018-11-04 01:00 UTC เพราะ GMT-3 หมายถึงต้องบวกเวลาไป 3 ชั่วโมง (เนื่องจาก UTC เป็นการอ้างอิงจากเวลามาตรฐานโลก)
			2. เวลา 2 (2018-11-04 06:00 GMT-6)
				เวลานี้คือเวลา 06:00 ในโซนเวลา GMT-6
				หากเรานำเวลานี้มาแปลงเป็น UTC จะได้ 2018-11-04 12:00 UTC เพราะ GMT-6 หมายถึงต้องบวกเวลาไป 6 ชั่วโมง
			3. คำนวณระยะเวลา
				เรามีสองเวลาใน UTC:
				2018-11-04 01:00 UTC (เวลาที่ 1)
				2018-11-04 12:00 UTC (เวลาที่ 2)
				ตอนนี้ ระยะเวลา ระหว่างสองเวลานี้คือ:
			
			จาก 01:00 UTC ไปถึง 12:00 UTC ก็ใช้เวลา 11 ชั่วโมง ครับ
		 */
	
	}
}
