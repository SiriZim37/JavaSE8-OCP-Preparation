package aufgaben.loc;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.ResourceBundle;

public class AufgabenLocalizationSimple {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.FRANCE);
		
		Locale locale = Locale.getDefault();
		
		LocalDate today = LocalDate.now();
		
		String baseName = "loc.res.simple";
		ResourceBundle bundle = ResourceBundle.getBundle(baseName);
		
		String main_greeting = bundle.getString("v_greeting"); 
		String main_today = bundle.getString("v_datetoday"); 
		String main_dayofweek = bundle.getString("v_dayofweek"); 
		String main_birthday = bundle.getString("v_birthday"); 
		String main_nextbirthday = bundle.getString("v_nextbirthday"); 
		
		// #A1
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy" , locale);
		String dateText = today.format(dateFormatter);
		String dayOfWeek = today.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
	
		// #A2
		String userName = System.getProperty("user.name" , "User"); 	// default : User
	
		// #A3

		//-Duser.birthday=2000-01-01
		String strBirthday = System.getProperty("user.birthday");  // default : 1990-01-01
		
		if(strBirthday == null) {
			// #A4 config
			configBirthdate();
			strBirthday = System.getProperty("user.birthday");
		}
		
        DateTimeFormatter parseFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthday = LocalDate.parse(strBirthday, parseFormatter);

        LocalDate nextBD = birthday.withYear(today.getYear());
        
        if (nextBD.isBefore(today) || nextBD.equals(today)) {
        	nextBD = nextBD.plusYears(1);
        }
        long countDays = ChronoUnit.DAYS.between(today, nextBD);
		
        System.out.println(MessageFormat.format(main_greeting, userName));
        System.out.println(MessageFormat.format(main_today, dateText));
        System.out.println(MessageFormat.format(main_dayofweek, dayOfWeek));
        System.out.println(MessageFormat.format(main_birthday, birthday));
        System.out.println(MessageFormat.format(main_nextbirthday, countDays));
       
		
	}
	
	static void configBirthdate() {
		String key = "user.birthday";
		String value = "2010-01-01";
		System.setProperty(key , value);
		String myBirthdate = System.getProperty("user.birthday");  
		System.out.println("myBirthdate : " + myBirthdate);
	}
}
