package calendar;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class B05_ChronoUnit {

	public static void main(String[] args) {
		
		LocalDate ersterTagIm21Jh = LocalDate.of(2000, 1, 1);
		LocalDate heute = LocalDate.now();
		long tage = ChronoUnit.DAYS.between(ersterTagIm21Jh, heute);
		System.out.println("tage = "+ tage); // tage = 8976
		long l = ersterTagIm21Jh.until(heute, ChronoUnit.DAYS);
		System.out.println("l = "+l); // l =8976

//		long hr = ersterTagIm21Jh.until(heute, ChronoUnit.HOURS);
//		System.out.println("l = "+hr);// cf :  ava.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Hours


        
	   LocalDateTime ersterTagIm21JhTime = LocalDateTime.of(2000, 1, 1, 0, 0);
	   LocalDateTime heuteWithTime = LocalDateTime.now(); // Current date and time
	   long hr = ersterTagIm21JhTime.until(heuteWithTime, ChronoUnit.HOURS);
	   System.out.println("Hours between the two dates: " + hr);
		
	}

}
