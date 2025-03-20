package calendar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class B02_DateTimeFormatter {

	public static void main(String[] args) {

		String s =  "2024-07-30";
		LocalDate ld = LocalDate.parse(s);
		ld = LocalDate.parse(s , DateTimeFormatter.ISO_DATE);
		System.out.println("1. ld = " + ld);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MMM.yyyy");
//		ld = LocalDate.parse(s , dtf); // //  java.time.format.DateTimeParseException: Text '2024-07-30' could not be parsed at index 2 
//		System.out.println("2. ld = " + ld ); 
		System.out.println("2. ld = " + ld.format(dtf) ); // ok

		s = "07/28/24" ; 
		dtf = DateTimeFormatter.ofPattern("MM/dd/yy");
		ld = LocalDate.parse(s , dtf);  // ok
		System.out.println("3.1. ld = " + ld );
		System.out.println("3.2  ld = " + ld.format(dtf) );  // ok
		
		DateTimeFormatter myDtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		String ldStr = ld.format(myDtf);
		System.out.println("4. ldStr short = " + ldStr);
		
		myDtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		ldStr = ld.format(myDtf);
		System.out.println("5. ldStr medium = " + ldStr);
		
		myDtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		ldStr = ld.format(myDtf);
		System.out.println("6. ldStr long = " + ldStr);
		
		myDtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		ldStr = ld.format(myDtf);
		System.out.println("7. ldStr full = " + ldStr);
	}

}
