package oca;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatToString {

	public static void main(String[] args) {

//		String date = LocalDate.parse("2014-05-04").format(DateTimeFormatter.ISO_DATE_TIME);
//		
//		System.out.println(date);
		
		DateTimeFormatter fmt = DateTimeFormatter.ISO_DATE;
		LocalDate dateV = LocalDate.parse("2014-05-04",fmt);
		System.out.println(dateV);
		
		/*
		 * LocalDate แทนค่าที่มีเฉพาะวันที่ (ไม่มีเวลา) ดังนั้นจึงเกิดข้อผิดพลาดเมื่อคุณพยายามใช้มันกับ LocalDate โดยตรง
		 */
		try {
			DateTimeFormatter fmtX = DateTimeFormatter.ISO_TIME;
			LocalDate dateX = LocalDate.parse("2014-05-04",fmtX);
			System.out.println(dateX);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * วิธีที่ 1: ใช้ LocalDateTime
			หากคุณต้องการให้รวมเวลาในผลลัพธ์ คุณสามารถแปลง LocalDate เป็น LocalDateTime ได้:
		 */
		
		LocalDate date = LocalDate.parse("2014-05-04");
	     LocalDateTime dateTime = date.atStartOfDay(); // ตั้งเวลาเป็น 00:00
	    String formattedDateTime = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
	        
	    System.out.println(formattedDateTime);
	        
	        
		System.out.println();
		
		/*
		 * วิธีที่ 2: ใช้ ISO_DATE
			หากคุณต้องการเพียงแค่พิมพ์วันที่โดยไม่มีเวลา คุณสามารถใช้ ISO_DATE formatter ได้:
		 */
		LocalDate date2 = LocalDate.parse("2014-05-04");
	    String formattedDate = date2.format(DateTimeFormatter.ISO_DATE);
	        
	    System.out.println(formattedDate);

	}

}
