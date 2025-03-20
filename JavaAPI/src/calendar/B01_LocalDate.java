package calendar;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class B01_LocalDate {

	/*
	 * LocalDate			Represents a date (year, month, day (yyyy-MM-dd))
	 * LocalTime			Represents a time (hour, minute, second and nanoseconds (HH-mm-ss-ns))
	 * LocalDateTime		Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)
	 * DateTimeFormatter	Formatter for displaying and parsing date-time objects
	 */
	
	public static void main(String[] args) {
		// Seit Java 1.0
		Date d = new Date();
		System.out.println("1. d = " + d);
		
		// Seit Java 1.1
		Calendar cal = Calendar.getInstance();
		cal = new GregorianCalendar();
		
		System.out.println("2. cal = " + cal);
		System.out.println("3. year = " + cal.get(Calendar.YEAR));
		System.out.println("4. month = " + cal.get(Calendar.MONTH));
		System.out.println("5. day of month= " + cal.get(Calendar.DAY_OF_MONTH));
		
		// Seit Java 8 
		// LocalDate heute = new LocalDate(); // Compiler-Fehler, keine Konstruktoren im java.time-Package sichtbar
		LocalDate heute = LocalDate.now(); // Fabrik-Methode (factory method) zum Erzeugen eines LocalDate-Objekts
		System.out.println("6. heute = " + heute);
		
		LocalDate ld = LocalDate.of(2022, 2, 2);
		
		System.out.println("7. ld = " + ld);
		
		ld = LocalDate.of(2023, Month.MAY, 5);
		System.out.println("8. ld = " + ld);
	
		String s = "2024-07-30";
		ld = LocalDate.parse(s);
		System.out.println("9. ld = " + ld);
		
		
	

	}

}
