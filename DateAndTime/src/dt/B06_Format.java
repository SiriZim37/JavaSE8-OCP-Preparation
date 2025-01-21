package dt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class B06_Format {

	public static void main(String[] args) {
		LocalDate v1 = LocalDate.now();
		System.out.println("LocalDate: " + v1);	// 2024-11-29
		
		LocalTime v2 = LocalTime.now();
		System.out.println("LocalTime: " + v2);	//11:15:34.011998500
		
		System.out.println("LocalTime: " 
							+ v2.truncatedTo(ChronoUnit.SECONDS));	// 11:15:34
	
		System.out.println("LocalTime: " 
							+ v2.plus(1 , ChronoUnit.HOURS));	    // 12:15:34.011998500
	
		LocalDateTime v3 = LocalDateTime.now();
		// 'T' trennt Datum-Teil vom Zeit-Teil: 
		System.out.println("LocalDateTime: " + v3); // 2024-11-29T11:19:12.447312500
	
		/*
		 * DateTimeFormatter
		 */
		
		try {
			DateTimeFormatter fmt = DateTimeFormatter.ISO_TIME;
			String s1 = LocalDate.now().format(fmt);	// << Exception Only Date No Time  	
			System.out.println("");
		} catch (Exception e) {
			System.out.println("Exception! UnsupportedTemporalTypeException: Unsupported field: HourOfDay");
		}
		
		DateTimeFormatter fmt = DateTimeFormatter.BASIC_ISO_DATE;
		String s1 = fmt.format(LocalDate.now())	;
		System.out.println("BASIC_ISO_DATE: " + s1);			//20241129
	
		fmt = DateTimeFormatter.ISO_DATE;
		s1 = fmt.format(LocalDate.now());						// ok > LocalDate
		System.out.println("ISO_DATE: " + s1);					// 2024-11-29
	
		
		fmt = DateTimeFormatter.ISO_TIME;
		s1 =fmt.format(LocalTime.now());						// ok > LocalTime		
		System.out.println("ISO_LOCAL_TIME: " + s1);			// 11:40:30.0789436
		
		fmt = DateTimeFormatter.ISO_LOCAL_TIME;
		s1 =fmt.format(LocalTime.now());						// ok > LocalTime		
		System.out.println("ISO_LOCAL_TIME: " + s1);			// 11:40:30.0789436
	
	
		System.out.println("--------------------------------------------------------------------");
		/*
		 * ofPatterns
		 * 
		 * d - day					> only d , dd 
		 * M - Month				> only M(1-12) , MM(1-12) , MMM (Jan-Dec)  , MMMM (January-December) , MMMMM (J-D)
		 * y - year					> only y(2024) , yy(24) , yyy(2024) , yyyy (2024)
		 * 
		 * H - Hour (0-23)
		 * h - Hour (AM-PM 1-12)	(Unwahrscheinlich)
		 * m - minute
		 * s - second
		 */
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("d.M.y , H:m:s");
		System.out.println(fmt1.format(LocalDateTime.now()));					//29.11.2024 , 11:44:0
		
		fmt1 = DateTimeFormatter.ofPattern("d.MM.yyy , H:m:s");
		System.out.println(fmt1.format(LocalDateTime.now()));					//29.11.2024 , 11:44:0
	}
}
