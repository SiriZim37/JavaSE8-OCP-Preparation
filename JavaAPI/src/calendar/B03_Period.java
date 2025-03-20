package calendar;


import java.time.*;



public class B03_Period {

	/*
	 * The Period class in Java is part of the java.time package, 
	 * which is included in Java 8 and later versions. 
	 * It provides a way to represent and manipulate periods of time, 
	 * specifically in terms of years, months, and days.
	 * 
	 * Key Features of Period
	 * 1. Representation: Period represents a period of time in terms of years, months, and days. Unlike Duration, which measures time in hours, minutes, and seconds, Period is more suited to representing calendar-based durations.
	 * 2. Creation: You can create Period instances using various methods, such as Period.of(), Period.between(), and the constructor.
	 * 3. Manipulation: Period can be used to add or subtract time from LocalDate and LocalDateTime objects.
	 * 4. Comparison: You can compare periods to determine their relative lengths.
	 */
	public static void main(String[] args) {

		Period period1 = Period.ofYears(1);          // Represents 1 year
	    Period period2 = Period.ofMonths(2);         // Represents 2 months
	    Period period3 = Period.ofDays(3);           // Represents 3 days
	    Period period4 = Period.of(1, 2, 3);         // Represents 1 year, 2 months, and 3 days
	    
	    System.out.println("Period1: " + period1);
	    System.out.println("Period2: " + period2);
	    System.out.println("Period3: " + period3);
	    System.out.println("Period4: " + period4);
		
		LocalDate ersterTagIm21Jh = LocalDate.of(2000, 1, 1);
		LocalDate heute = LocalDate.now();
		Period p =   Period.between(ersterTagIm21Jh, heute);
		System.out.println("1. p = " + p ); // 1. p = P24Y6M28D
	
		System.out.println("1. p = " + p.getYears() + " " + p.getMonths() + " " + p.getDays() );
		
		heute.plus(p); // LocalDate-Objekte sind Immutable , das neu erzeugte Objekt ist nicht referenziert und wird sofort gelöscht.
		System.out.println("heute = " + heute); //  heute = 2024-07-29
		
		LocalDate future = heute.plus(p);
		System.out.println("future = " + future); // future = 2049-02-26
		
		LocalDate rechnungsDatum = LocalDate.parse("2024-12-31"); 
		System.out.println("rechnungsDatum = " + rechnungsDatum);
		
		LocalDate ersteMahnstufe = rechnungsDatum.plus(Period.ofDays(30));
	    System.out.println("erste Mahnstufe nach 30 Tagen = " + ersteMahnstufe); // 2025-01-30
	   
	    LocalDate zweiteMahnstufe = rechnungsDatum.plusDays(60);
        System.out.println("zweite Mahnstufe nach 60 Tagen = " + zweiteMahnstufe); // 2025-03-01
		
		
		LocalDate startDate = LocalDate.of(2023, 1, 1);
	    LocalDate endDate = LocalDate.of(2024, 7, 28);

	    Period period = Period.between(startDate, endDate);
	    System.out.println("Period between dates: " + period); // P1Y6M27D

	}

}
