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

public class DateTimeCalendarMitArgs {

	public static void main(String[] args) {
		
		if (args.length == 2) {
            try {
                int month = Integer.parseInt(args[0]);
                int year = Integer.parseInt(args[1]);

                printCalendar(month, year);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please provide valid integers for month and year.");
            }
        } else {
            // Default to July 2024 if arguments are not provided
            printCalendar(7, 2024);
        }
		
	}
	/*  TEST Args 
	 * C:\Users\CC-Student\eclipse-workspace\JavaAPI\bin>cd C:\Users\CC-Student\eclipse-workspace\JavaAPI\src
	
	>> comnplier
	C:\Users\CC-Student\eclipse-workspace\JavaAPI\src>javac aufgaben\DateTimeCalendarMitArgs.java 
	
	C:\Users\CC-Student\eclipse-workspace\JavaAPI\src>cd C:\Users\CC-Student\eclipse-workspace\JavaAPI\bin
	
	>> Run mit args
	C:\Users\CC-Student\eclipse-workspace\JavaAPI\bin>java aufgaben.DateTimeCalendarMitArgs 7 2024
	
	C:\Users\CC-Student\eclipse-workspace\JavaAPI\bin>java aufgaben.DateTimeCalendarMitArgs 7 2024
	---------------------
	J 2024
	---------------------
	01 | Montag     |
	02 | Dienstag   |
	03 | Mittwoch   |
	04 | Donnerstag |
	05 | Freitag    |
	06 | Samstag    |
	07 | Sonntag    |
	08 | Montag     |
	09 | Dienstag   |
	10 | Mittwoch   |
	11 | Donnerstag |
	12 | Freitag    |
	13 | Samstag    |
	14 | Sonntag    |
	15 | Montag     |
	16 | Dienstag   |
	17 | Mittwoch   |
	18 | Donnerstag |
	19 | Freitag    |
	20 | Samstag    |
	21 | Sonntag    |
	22 | Montag     |
	23 | Dienstag   |
	24 | Mittwoch   |
	25 | Donnerstag |
	26 | Freitag    |
	27 | Samstag    |
	28 | Sonntag    |
	29 | Montag     |
	30 | Dienstag   |
	31 | Mittwoch   |
	---------------------

	 */
	
	
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
