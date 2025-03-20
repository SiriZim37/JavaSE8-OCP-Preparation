package calendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class B04_LocalDateTime {

	public static void main(String[] args) {

		LocalDateTime jetzt = LocalDateTime.now();
		System.out.println("jetzt = " + jetzt); // jetzt = 2024-07-29T12:38:38.394056400
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL , FormatStyle.MEDIUM);
		String s = jetzt.format(dtf);
		System.out.println("s = " + s );
		LocalDateTime morgenEineStundeSparter = jetzt.plusDays(1).plusHours(1);
		System.out.println("morgenEineStundeSparter1 = " + morgenEineStundeSparter);
		// oder 
		morgenEineStundeSparter = jetzt.plusHours(25);
		System.out.println("morgenEineStundeSparter2 = " + morgenEineStundeSparter);
		
		LocalDateTime schaltTagMittags = LocalDateTime.of(2024, 2, 29 , 12, 0 );
		schaltTagMittags = LocalDateTime.of(LocalDate.of(2024,2,29), LocalTime.NOON);
	
		System.out.println("schaltTagMittags = " + schaltTagMittags);
		System.out.println("schaltTagMittags in einem jarh = " + schaltTagMittags.plusYears(1));
	}

}
