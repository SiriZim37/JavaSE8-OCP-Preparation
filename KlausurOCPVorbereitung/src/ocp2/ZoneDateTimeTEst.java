package ocp2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/*
 Given the code fragment:
 ZonedDateTime depart = ZonedDateTime.of(2015, 1, 15, 3, 0, 0, 0, ZoneID.of("UTC-7"));
 ZonedDateTime arrive = ZonedDateTime.of(2015, 1, 15, 9, 0, 0, 0, ZoneID.of("UTC-5"));
 long hrs = ChronoUnit.HOURS.between(depart, arrive); //line n1
 System.out.println("Travel time is" + hrs + "hours");
 What is the result?
 A. Travel time is 4 hours
 B. Travel time is 6 hours
 C. Travel time is 8 hours
 D. An exception is thrown at line n1.
 
 */
public class ZoneDateTimeTEst {

	public static void main(String[] args) {
		
		 Path path1 = Paths.get("/app/./sys/");
		 Path res1 = path1.resolve("log");
		 Path path2 = Paths.get("/server/exe/");
		 Path res2 = path1.resolve("/readme/");
		 System.out.println(res1);
		 System.out.println(res2);
		 
//		 ZonedDateTime depart = ZonedDateTime.of(2015, 1, 15, 3, 0, 0, 0, ZoneId.of("UTC-7"));
//		 ZonedDateTime arrive = ZonedDateTime.of(2015, 1, 15, 9, 0, 0, 0, ZoneId.of("UTC-5"));
//		 long hrs = ChronoUnit.HOURS.between(depart, arrive); 	//line n1
//		 System.out.println("Travel time is" + hrs + "hours");
		 
	}
	/*
	 	การคำนวณ
		เวลาออกเดินทาง: 03:00 UTC-7
		หากแปลงเป็น UTC:
		
		03:00 + 7 ชั่วโมง = 10:00 UTC
		เวลาไปถึง: 09:00 UTC-5
		หากแปลงเป็น UTC:
		

		09:00 + 5 ชั่วโมง = 14:00 UTC
		ระยะห่างระหว่าง 10:00 UTC ถึง 14:00 UTC คือ 4 ชั่วโมง.
	 */
}
