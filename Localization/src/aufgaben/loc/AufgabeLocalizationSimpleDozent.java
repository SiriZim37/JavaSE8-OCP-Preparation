package aufgaben.loc;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.ResourceBundle;

public class AufgabeLocalizationSimpleDozent {

	/*
	 * bei System-Sprache 'de':
	 * 
	 * Heute ist 9. Oktober 2018.
	 * Es ist Dienstag.
	 * 
	 * bei anderen System-Sprachen:
	 * 
	 * Today is October 9, 2018.
	 * It's Tuesday.
	 * 
	 */
	public static void main(String[] args) {
//		Locale.setDefault(Locale.UK);
//		Locale.setDefault(Locale.GERMANY);
		Locale.setDefault(Locale.FRANCE);
		
//		LocalDate date = LocalDate.now();
		LocalDate date = LocalDate.of(2018, Month.OCTOBER, 9);

		ResourceBundle bundle = ResourceBundle.getBundle("aufgaben.loc.simpleapp");
		
		
		
		Locale dateFmtLocale = new Locale.Builder()
								.setLanguage(bundle.getString("date.fmt.lang"))
								.build();
		
	    System.out.format("%s %s !%n", 
	            bundle.getString("prefix.greeting"), 
	            System.getProperty("user.name", "user"));
	    
		String prefixDate = bundle.getString("prefix.date");
		String patternDate = bundle.getString("pattern.date");
		
		DateTimeFormatter fmtDate = DateTimeFormatter.ofPattern(patternDate , dateFmtLocale);
		System.out.format("%s %s.%n", prefixDate, fmtDate.format(date));
		
		String prefixWeekday = bundle.getString("prefix.weekday");
		String patternWeekday = bundle.getString("pattern.weekday");
		
		DateTimeFormatter fmtWeekday = DateTimeFormatter.ofPattern(patternWeekday , dateFmtLocale);
		System.out.format("%s %s.%n", prefixWeekday, fmtWeekday.format(date));
		
		String userBirthday = "15.11.2000";
		
		if(userBirthday !=null) {
			DateTimeFormatter fmtBirthday = DateTimeFormatter.ofPattern("d.M.y");
			LocalDate birthday = LocalDate.parse(userBirthday , fmtBirthday);
			System.out.println(birthday);
			
			LocalDate today = LocalDate.now();


			LocalDate nextBirthDay = birthday.withYear(today.getYear());
	        
	        if (nextBirthDay.compareTo(today) < 0){
	        	nextBirthDay = nextBirthDay.plusYears(1);
	        }
	        long countDays = ChronoUnit.DAYS.between(today, nextBirthDay);
	        System.out.printf("Zeit bis zum Geburtstag : %s Tage%n" ,countDays);
	    	
	        Period p_days = Period.between(today, nextBirthDay);
	        System.out.printf("Zeit bis zum Geburtstag : %s Tage" , p_days.getDays());
	        
	        
	        
		}
		
		/*
		 * https://www.baeldung.com/java-localization-messages-formatting
		 */
//		System.out.printf("Zeit bis zum Geburtstag: 3 Monate und 2 Tage");
//		System.out.printf("Zeit bis zum Geburtstag: 1 Monat");
//		System.out.printf("Zeit bis zum Geburtstag: 3 Monate");
//		System.out.printf("Zeit bis zum Geburtstag: 1 Monat und 2 Tage");
//		System.out.printf("Zeit bis zum Geburtstag: 2 Tage");
//		System.out.printf("Zeit bis zum Geburtstag: 1 Tag");
	}

}
