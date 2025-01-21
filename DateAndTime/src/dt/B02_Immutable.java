package dt;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class B02_Immutable {

	public static void main(String[] args) {
		
		LocalDate d1 = LocalDate.of(2024, Month.JANUARY	, 1) ;
		
		d1.plusDays(5);
		
		System.out.println(d1);						// 2024-01-01
		System.out.println(d1.getDayOfMonth());		// 1 
		System.out.println(d1.getDayOfWeek());		//MONDAY	
		System.out.println(d1.getDayOfYear());		//1
		
		
		
		d1 = d1.plusDays(3);
		
		System.out.println(d1);						// 2024-01-04
		System.out.println(d1.getDayOfMonth());		// 4 
		System.out.println(d1.getDayOfWeek());		// THURSDAY	
		System.out.println(d1.getDayOfYear());		// 4
	}
}
