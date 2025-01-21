package dt;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class B04_Reisedauer {

	public static void main(String[] args) {
		
		/*
		 * public static ZonedDateTime of(
            int year, int month, int dayOfMonth,
            int hour, int minute, int second, int nanoOfSecond, ZoneId zone)
		 */
	
		
		final int year = 2024;
		final int month = 1;
		final int dayOfMonth = 1;
		
		/*
		 * Abreisen. Lokale Zeitangaben
		 */
		// เวลาออกเดินทางคือ 5:00 น. (UTC-7) เขตเวลาเป็น UTC-7 ซึ่งหมายถึงเวลานี้จะช้ากว่าเวลาใน UTC (เวลาโลก) 7 ชั่วโมง
		final int hour1 = 5;
		final int minute1 = 0;
		final int second1 = 0;
		final int nanoOfSecond1 = 0;
		ZoneId zone1 = ZoneId.of("UTC-7");		// 'America/New_York'.
		ZonedDateTime time1 = ZonedDateTime.of(year, month, dayOfMonth, hour1, minute1, second1, nanoOfSecond1, zone1);
		System.out.println(time1);
		
		/*
		 * Ankunkft. Lokale Zeitangaben
		 */
		// เวลาเดินทางถึงคือ 11:00 น. (UTC-5) เขตเวลาเป็น UTC-5 ซึ่งหมายถึงเวลานี้จะช้ากว่าเวลาใน UTC 5 ชั่วโมง
		final int hour2 = 11;
		final int minute2 = 0;
		final int second2 = 0;
		final int nanoOfSecond2 = 0;
		ZoneId zone2 = ZoneId.of("UTC-5");		
		ZonedDateTime time2 = ZonedDateTime.of(year, month, dayOfMonth, hour2, minute2, second2, nanoOfSecond2, zone2);
		System.out.println(time2);
		/*
		 * Lokale Zeiten auf englische Zeit umgerechtnet:
		 * 
		 * 5 Uhr + 7 Stunden (da UTC-7) = 12 Uhr in England   // เวลา 5:00 น. (UTC-7) จะถูกเพิ่ม 7 ชั่วโมงเพื่อแปลงเป็นเวลาในอังกฤษ (UTC)
		 * 11 uhr + 5 Stunden ( da UTC-5) = 16 Uhr in England // เวลา 11:00 น. (UTC-5) จะถูกเพิ่ม 5 ชั่วโมงเพื่อแปลงเป็นเวลาในอังกฤษ (UTC)
		 * 
		 * Reisendauer = 16-12 = 4 
		 * ดังนั้น ระยะเวลาการเดินทาง คือ 16:00 - 12:00 = 4 ชั่วโมง
		 */
		
		long dauer = ChronoUnit.HOURS.between(time1, time2);
		System.out.println("Dauer: " + dauer + " Stunden");
		
		
		
	}
	
}
