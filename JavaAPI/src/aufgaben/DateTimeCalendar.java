package aufgaben;

import java.io.Console;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class DateTimeCalendar {

	public static void main(String[] args) {

		printCalendar(4,2020);
		
		printCalendarByUsingYearMonth(4,2020);
		
		printCalendarByUsingCalendar(4,2020);
	
		printCalendarByUsingLocalDate(4,2020);
		
		inputYearMonthConsole();
		
	}
	
	
	
	static void inputYearMonthConsole() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int year = -1;
	        int month = -1;
			while (year == -1) {
	            System.out.print("Geben Sie das Jahr ein: ");
	            String yearInput = scanner.nextLine();
	            try {
	                year = Integer.parseInt(yearInput);
	            } catch (NumberFormatException e) {
	                 System.out.println("Ungültige Eingabe. Bitte geben Sie eine gültige Jahreszahl ein.");
	            }
	        }
			
			while (month == -1) {
				System.out.print("Geben Sie den Monat ein (1-12): ");
                String monthInput = scanner.nextLine();

                try {
                    month = Integer.parseInt(monthInput);

                    if (month < 1 || month > 12) {
                        System.out.println("Ungültiger Monat. Bitte geben Sie eine Zahl zwischen 1 und 12 ein.");
                        month = -1; // Reset month to prompt again
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ungültige Eingabe. Bitte geben Sie eine gültige Monatzahl ein.");
                }
	        }
			
			printCalendarByUsingYearMonth(month, year);
			
			System.out.print("Möchten Sie beenden (J/N)? ");
			String response = scanner.nextLine();
			if (response.equalsIgnoreCase("J")) {
	              System.out.println("Programm wird beendet...");
	             break;
	        }
		}
		scanner.close();

	}
	
	
	static void printCalendar(int month , int year) {
		 validateInputs(month, year);
		   
		 LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
		 int daysInMonth = firstDayOfMonth.lengthOfMonth();
		   
	     DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMMM yyyy", Locale.GERMANY);


	      System.out.println("---------------------");
	      System.out.println(firstDayOfMonth.format(monthYearFormatter));
	      System.out.println("---------------------");

	 	 YearMonth yearMonth = YearMonth.of(year, month);
	 	 DateTimeFormatter fmtWochentag = DateTimeFormatter.ofPattern("EEEE", Locale.GERMANY);
	 	 for (int day = 1; day <= yearMonth.lengthOfMonth(); day++) {
	          LocalDate date = LocalDate.of(year, month, day);
	        		  String dayOfWeek = date.format(fmtWochentag);
	            System.out.printf("%02d | %-10s |%n", day, dayOfWeek);
	     }
	 	 
	 	
	     System.out.println("---------------------");
	     
	}
	
	// Alternativ 3
		static void printCalendarByUsingLocalDate(int month , int year){
			 validateInputs(month, year);
			   
			 LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
			 int daysInMonth = firstDayOfMonth.lengthOfMonth();

		     DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMMM yyyy", Locale.GERMANY);


		      System.out.println("---------------------");
		      System.out.println(firstDayOfMonth.format(monthYearFormatter));
		      System.out.println("---------------------");

		 	 
		 	 for (int day = 1; day <= daysInMonth; day++) {
		            LocalDate date = LocalDate.of(year, month, day);
		            String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.GERMANY);
		            System.out.printf("%02d | %12s |\n", day, dayOfWeek);
		     }
		 	 
		 	
		     System.out.println("---------------------");
		}
		
	// Alternativ 2 
	static void printCalendarByUsingCalendar(int month , int year){
		 validateInputs(month, year);
		 Calendar cal = new GregorianCalendar();
	     cal.set(Calendar.YEAR, year);
	     cal.set(Calendar.MONTH, month - 1);  // Month is zero-based
	     cal.set(Calendar.DAY_OF_MONTH, 1);  // Set to the first day of the month

	     String monthName = new DateFormatSymbols(Locale.GERMANY).getMonths()[month - 1];
	     
	     System.out.println("---------------------");
	     System.out.println(monthName + " " + year);
	     System.out.println("---------------------");

	     // Get the number of days in the month
	     int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

	     // Iterate over the days of the month
	     for (int day = 1; day < daysInMonth; day++) {
	         cal.set(Calendar.DAY_OF_MONTH, day);
	         String dayOfWeek = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.GERMANY);
	         System.out.printf("%02d | %12s |\n", day, dayOfWeek);
	     }

	     System.out.println("---------------------");
	}
	
	// Alternativ 1
	static void printCalendarByUsingYearMonth(int month , int year){
		 validateInputs(month, year);
		   
		 YearMonth ym = YearMonth.of(year, month);
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMMM yyyy", Locale.GERMANY);
//		  DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH); //ok :  E 	day-of-week 	text 	Tue; Tuesday; T

		 System.out.println("---------------------");
	     System.out.println(ym.format(dtf));
	 	 System.out.println("---------------------");

	     // Iterate over the days of the month
	     for (int day = 1; day <= ym.lengthOfMonth() ; day++) {
	    	 LocalDate date = ym.atDay(day); // LocalDate.of(year, month, day); 
	         String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.GERMANY);
	         System.out.printf("%02d | %12s |\n", day, dayOfWeek);
	     }
	     

	     System.out.println("---------------------");
	}

	
    private static void validateInputs(int month, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Monat muss zwischen 1 und 12 liegen.");
        }
        if (year < 1) {
            throw new IllegalArgumentException("Jahr muss positiv sein.");
        }
    }

}
