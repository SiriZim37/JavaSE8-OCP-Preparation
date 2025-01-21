 package dt;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class A00_WhatIstDateTime {

	/*
	 แพ็กเกจ java.time
		ใน Java SE 8, แพ็กเกจ java.time ถูกนำมาใช้เพื่อช่วยในการจัดการวันที่และเวลา
		ซึ่งให้ API ที่ทันสมัยและสมบูรณ์มากกว่า java.util.Date และ java.util.Calendar ที่เคยใช้ก่อนหน้า ชนิดหลักๆ ที่ใช้คือ:
		
		Instant v0; – เป็นตัวแทนของเวลาในหน่วยมิลลิวินาทีที่ผ่านมาตั้งแต่วันที่ 1 มกราคม 1970 (epoch time)
		LocalDate: แสดงถึงวันที่โดยไม่มีเวลา (เช่น 2024-11-29).
		LocalTime: แสดงถึงเวลาโดยไม่มีวันที่ (เช่น 14:30:00).
		LocalDateTime: รวมวันที่และเวลาเข้าด้วยกัน (เช่น 2024-11-29T14:30:00). (ไม่มีเขตเวลา)
		ZoneId v33; – ใช้แทนเขตเวลา (timezone)
		ZonedDateTime: แสดงถึงวันที่และเวลาพร้อมกับข้อมูลโซนเวลา (เช่น 2024-11-29T14:30:00+01:00[Europe/Paris]).
		Period v5; – แสดงระยะเวลาแบบวันที่ (เช่น "2 ปี 4 วัน") ในระบบปฏิทิน ISO-8601 (เช่น การคำนวณความแตกต่างระหว่าง LocalDate สองค่า).
		Duration v6; –  แสดงถึงระยะเวลาที่เกี่ยวข้องกับเวลา (เช่น การคำนวณความแตกต่างระหว่าง LocalTime สองค่า) (เช่น 34.5 วินาที)
		ChronoUnit v7 = ChronoUnit.DAYS; – หน่วยเวลา เช่น วัน, ชั่วโมง, นาที ฯลฯ
		ChronoField v8 = ChronoField.DAY_OF_MONTH; – คุณสมบัติที่สามารถเข้าถึงได้จากวันที่/เวลา เช่น วันในเดือน
		DateTimeFormatter v9; – ใช้ในการจัดรูปแบบและแปลงวันที่และเวลาเป็นสตริง
				
	 */
	
	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();

		System.out.println("วันนี้: " + today);
		System.out.println("เวลา: " + time);
		System.out.println("วันที่และเวลา: " + dateTime);
		
		/*
			วิธีที่ใช้บ่อย:
	
			now(): ได้รับวันที่/เวลาในปัจจุบัน
			of(): สร้างอ็อบเจ็กต์จากค่าที่ระบุ (เช่น LocalDate.of(2024, 11, 29))
			plusDays(), minusDays(): เพิ่มหรือลดวัน
			isBefore(), isAfter(): เปรียบเทียบระหว่าง LocalDate หรือ LocalDateTime สองค่า
		*/
		//---------------------------------------------------------------------------------//
		
		/*
		 * ZonedDateTime ใช้สำหรับจัดการวันที่และเวลาพร้อมกับข้อมูลเกี่ยวกับโซนเวลา
		 */

		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println("วันที่และเวลาพร้อมโซนเวลา: " + zonedDateTime);
		/*
			วิธีที่ใช้บ่อย:
	
			now(): ได้รับวันที่และเวลาพร้อมกับโซนเวลา
			of(): สร้าง ZonedDateTime จากโซนเวลาที่ระบุ
			getOffset(): ได้รับค่า offset (เช่น UTC+01:00)
		*/
		
		//---------------------------------------------------------------------------------//
		
		/*
		 * Instant ใช้สำหรับแสดงถึงจุดเวลาหนึ่งๆ ในรูปแบบของจำนวนวินาทีตั้งแต่ 1970-01-01T00:00:00Z.
		 */

		Instant now = Instant.now();
		System.out.println("Instant: " + now);
		
		//---------------------------------------------------------------------------------//
		 
		/*
		  DateTimeFormatter 
			 การจัดรูปแบบและการแปลงข้อมูล
			 สามารถใช้ DateTimeFormatter ในการจัดรูปแบบและแปลงวันที่และเวลา
		 */


		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime2 = LocalDateTime.now();
		String formatted = dateTime2.format(formatter);
		System.out.println("วันที่และเวลาในรูปแบบที่จัดรูป: " + formatted);

		// การแปลงสตริงเป็น LocalDateTime
		String dateString = "2024-11-29 14:30";
		LocalDateTime parsedDate = LocalDateTime.parse(dateString, formatter);
		System.out.println("วันที่และเวลา: " + parsedDate);

		
		 //---------------------------------------------------------------------------------//
		 
		/*
			7. วิธีที่ใช้บ่อยสำหรับการจัดการวันที่และเวลา
				isBefore(), isAfter(), isEqual(): ใช้เปรียบเทียบระหว่างวันที่และเวลา
				plus(), minus(): เพิ่มหรือลดเวลา
				getYear(), getMonth(), getDayOfMonth(): เข้าถึงส่วนต่างๆ ของวันที่
		 */
		 
		
		 //---------------------------------------------------------------------------------//
		
		/*
		 	8. การทำงานกับโซนเวลา
				ZoneId และ ZoneOffset ใช้ในการจัดการโซนเวลา
				ZonedDateTime แสดงถึงวันที่และเวลาพร้อมกับโซนเวลา
		 */
		ZonedDateTime parisTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		ZonedDateTime tokyoTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
		System.out.println("เวลาในปารีส: " + parisTime);
		System.out.println("เวลาในโตเกียว: " + tokyoTime);


		 //---------------------------------------------------------------------------------//
		
		/*
		 	10. ChronoUnit
			ChronoUnit เป็นการกำหนดหน่วยเวลา (time units) ที่ใช้ในการคำนวณระยะเวลา 
			เช่น ปี, เดือน, วัน, ชั่วโมง, นาที, วินาที, และมิลลิวินาที มันเป็น enum ที่ให้คุณสามารถใช้ในการคำนวณเวลาหรือเพิ่ม/ลดจากวันที่หรือเวลาได้
		 */
		LocalDate start = LocalDate.of(2024, 1, 1);
		LocalDate end = LocalDate.of(2024, 11, 29);

		long daysBetween = ChronoUnit.DAYS.between(start, end);
		System.out.println("ระยะเวลา (จำนวนวัน): " + daysBetween);

		// เพิ่มวัน
		LocalDate newDate = start.plus(10, ChronoUnit.DAYS);
		System.out.println("เพิ่ม 10 วัน: " + newDate);

		// ลบเดือน
		LocalDate previousMonth = start.minus(2, ChronoUnit.MONTHS);
		System.out.println("ลด 2 เดือน: " + previousMonth);

			/*
			 หน่วยที่สามารถใช้กับ ChronoUnit:
				
				ChronoUnit.SECONDS: วินาที
				ChronoUnit.MINUTES: นาที
				ChronoUnit.HOURS: ชั่วโมง
				ChronoUnit.DAYS: วัน
				ChronoUnit.WEEKS: สัปดาห์
				ChronoUnit.MONTHS: เดือน
				ChronoUnit.YEARS: ปี
				ChronoUnit.DECADES: ทศวรรษ
				ChronoUnit.CENTURIES: ศตวรรษ
				ChronoUnit.MILLENNIA: มิลเลเนียม
			 */
		
		 //---------------------------------------------------------------------------------//
		
		/*
		 	11. ChronoField
		 	
		 	ChronoField เป็นการกำหนดฟิลด์ต่างๆ ที่เกี่ยวข้องกับวันที่และเวลา เช่น ปี, เดือน, วัน, ชั่วโมง, นาที, วินาที เป็นต้น 
		 	ฟิลด์เหล่านี้สามารถใช้เพื่อดึงค่าจาก Temporal เช่น LocalDate, LocalDateTime, ZonedDateTime
		 	
		 */
		
		LocalDateTime dateTime3 = LocalDateTime.now();

		int year = dateTime3.get(ChronoField.YEAR);
		int month = dateTime3.get(ChronoField.MONTH_OF_YEAR);
		int dayOfMonth = dateTime3.get(ChronoField.DAY_OF_MONTH);

		System.out.println("ปี: " + year);
		System.out.println("เดือน: " + month);
		System.out.println("วันที่: " + dayOfMonth);

		/*
		 
		 ฟิลด์ที่สามารถใช้กับ ChronoField:
			
			ChronoField.YEAR: ปี
			ChronoField.MONTH_OF_YEAR: เดือน
			ChronoField.DAY_OF_MONTH: วัน
			ChronoField.HOUR_OF_DAY: ชั่วโมงในวัน (0-23)
			ChronoField.MINUTE_OF_HOUR: นาทีในชั่วโมง (0-59)
			ChronoField.SECOND_OF_MINUTE: วินาทีในนาที (0-59)
			ChronoField.MILLI_OF_SECOND: มิลลิวินาทีในวินาที (0-999)
		 */
		 //---------------------------------------------------------------------------------//
		
		/*
		 * การทำงานกับ Period
			Period ใช้สำหรับการคำนวณระยะห่างในระดับวัน, เดือน, ปี
		 */
		
		LocalDate startDate = LocalDate.of(2020, 1, 1);
		LocalDate endDate = LocalDate.of(2024, 11, 29);

		Period period = Period.between(startDate, endDate);
		System.out.println(period);
		System.out.println("ระยะเวลา: " + period.getYears() + " ปี " + period.getMonths() + " เดือน " + period.getDays() + " วัน");

		 //---------------------------------------------------------------------------------//
		
		/*
		 	การทำงานกับ DateTimeFormatter
			DateTimeFormatter ใช้ในการจัดรูปแบบและแปลงวันที่และเวลาให้เป็นสตริงตามรูปแบบที่กำหนด
		 */
		
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// การแปลง LocalDateTime เป็นสตริง
		LocalDateTime dateTime4 = LocalDateTime.now();
		String formattedDate = dateTime4.format(formatter2);
		System.out.println("วันที่และเวลา: " + formattedDate);

		// การแปลงสตริงเป็น LocalDateTime
		String dateString2 = "2024-11-29 14:30:00";
		LocalDateTime parsedDate2 = LocalDateTime.parse(dateString2, formatter2);
		System.out.println("วันที่และเวลา: " + parsedDate2);


		
	}
}
