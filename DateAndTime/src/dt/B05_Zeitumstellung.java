package dt;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class B05_Zeitumstellung {
	
	/*
	 *  ใน การสอบ OCP (Oracle Certified Professional) Java SE 8 อาจจะมีคำถามที่เกี่ยวข้องกับ 
	 *  การจัดการเวลา (Date and Time) โดยเฉพาะเกี่ยวกับ การเปลี่ยนเวลา หรือ Daylight Saving Time (DST) 
	 *  ซึ่งเป็นส่วนหนึ่งของการทำงานกับ Java Time API ที่เกี่ยวข้องกับ ZoneId และ ZonedDateTime 
	 *  ในการจัดการกับเวลาในโซนต่างๆ และการคำนวณช่วงเวลาต่างๆ

		ในตัวอย่างที่คุณให้มา การสอบอาจจะถามเกี่ยวกับ:
		
		1. การจัดการเขตเวลา (Time Zones):
		
		ในกรณีนี้คือเขตเวลา US/Central ซึ่งมีการปรับเวลา จาก 2:00 น. ไปเป็น 3:00 น. 
		ตามกฎการปรับเวลาในช่วง Daylight Saving Time (DST)
		สอบอาจจะถามเกี่ยวกับการคำนวณช่วงเวลาหรือการแปลงเวลาจากเขตเวลาหนึ่งไปยังเขตเวลาอื่น
		
		2. การใช้ ZonedDateTime:
		
		ตัวอย่างที่คุณให้มาใช้ ZonedDateTime.of() ในการกำหนดเวลาพร้อมกับเขตเวลา ซึ่งต้องเข้าใจวิธีการใช้ ZoneId ในการจัดการเขตเวลา
		คุณต้องสามารถใช้ ZonedDateTime เพื่อคำนวณเวลาหรือหาค่าช่วงเวลาระหว่างวันที่หรือเวลาที่มีการปรับเวลาได้
	 */
	public static void main(String[] args) {

		/*
		 * Bekannt ist , dass am 8.März 2015 in der Zeitzone US/Central
		 * um 2.00 Uhr die Uhr umgestellet war (auf 3:Uhr)
		 * 
		 * 01:00:00		1. Zeitpunkt 
		 * ...
		 * 01:59:57
		 * 01:59:58
		 * 01:59:59
		 * 03:00:00
		 * 03:00:01
		 * 03:00:02
		 *... 
		 *04:00:00		2. Zeitpunkt 
		 */

		/*
		 * คำอธิบายในโค้ดนี้เกี่ยวข้องกับการ เปลี่ยนเวลาของนาฬิกา ในบางประเทศเมื่อมีการ ปรับเวลา (Daylight Saving Time หรือ DST)
		 * โดยที่เวลา 2:00 น. ในวันที่ 8 มีนาคม 2015 ในเขตเวลาของ US/Central จะมีการ เลื่อนเวลาเป็น 3:00 น. 
		 * ซึ่งหมายความว่าเวลาในช่วงนั้นจะหายไปจาก 2:00 ถึง 3:00
		 * 
		 * 1. การเปลี่ยนเวลา:
		 * ในวันที่ 8 มีนาคม 2015 เวลาที่ 2:00 น. ในเขตเวลา US/Central จะถูกเลื่อนเป็น 3:00 น. 
		 * โดยจะข้ามช่วงเวลา 2:00 ถึง 3:00 โดยตรง ซึ่งเกิดจากการปรับเวลาในช่วง Daylight Saving Time (DST) 
		 * หรือที่เรียกว่า การเปลี่ยนเวลาฤดูร้อน (Summer Time).
		 * 2.การแสดงช่วงเวลา:
		 * ตอนที่ 01:00:00 น. คือเวลาเริ่มต้นของวัน
		 * แล้วเวลาจะเดินไปทีละวินาที จนถึงเวลา 01:59:59
		 * จากนั้นจะข้ามเวลา 02:00:00 ถึง 02:59:59 โดยจะ ข้ามเวลาไปที่ 03:00:00 น. ทันที
		 * เวลาจะเริ่มจาก 03:00:00 แล้วเดินไปจนถึง 04:00:00
		 * ซึ่งทำให้ช่วงเวลาระหว่าง 02:00 ถึง 03:00 น. หายไปทั้งหมด
		 */
		

		ZoneId zoneId = ZoneId.of("US/Central");
		ZonedDateTime timeAt2AM = ZonedDateTime.of(2015, 3, 8, 2, 0, 0, 0, zoneId);
        ZonedDateTime timeAt3AM = ZonedDateTime.of(2015, 3, 8, 3, 0, 0, 0, zoneId);
		
        Duration duration = Duration.between(timeAt2AM, timeAt3AM);

        long diff = duration.toHours();
        System.out.println("Duration between 2:00 AM and 3:00 AM: " 
        						+ diff + " Stunden");  	// 0   Stunden

        
		ZonedDateTime timeAt1AM = ZonedDateTime.of(2015, 3, 8, 1, 0, 0, 0, zoneId);
        ZonedDateTime timeAt4AM = ZonedDateTime.of(2015, 3, 8, 4, 0, 0, 0, zoneId);
        
        duration = Duration.between(timeAt1AM, timeAt4AM);
        
        diff = duration.toHours();
        System.out.println("Duration between 1:00 AM and 4:00 AM: " 
        						+ diff + " Stunden");  // 2  Stunden
        
		
	}
}
