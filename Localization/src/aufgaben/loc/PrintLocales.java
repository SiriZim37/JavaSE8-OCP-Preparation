package aufgaben.loc;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.stream.Stream;


public class PrintLocales {

	
	public static void main(String[] args) {
		
		TestAvailableContry();

	}

	static void printTable(Locale[] localList) {
	    int noWidth = 4;
	    int countryFullWidth = "Land".length();   
	    int languageFullWidth = "Sprache".length(); 
	    int countryWidth = "Land (kurz)".length();
	    int languageWidth = "Sprache (kurz)".length();

	    for (Locale locale : localList) {

	        countryFullWidth = Math.max(countryFullWidth, locale.getDisplayCountry().length());
	        languageFullWidth = Math.max(languageFullWidth, locale.getDisplayLanguage().length());

	        countryWidth = Math.max(countryWidth, locale.getCountry().length());
	        languageWidth = Math.max(languageWidth, locale.getLanguage().length());
	    }

	    String fmt = "| %-"+noWidth+"s | %-"+countryWidth+"s | %-"+countryFullWidth+"s | %-"+languageWidth+"s | %-"+languageFullWidth+"s |%n";


	    System.out.printf(fmt, "Nr.", "Land (kurz)", "Land", "Sprache (kurz)", "Sprache");

	   
	    for (int i = 0; i < localList.length; i++) {
	        Locale loc = localList[i];
	        String country = loc.getCountry();  
	        String language = loc.getLanguage(); 
	        String countryDisplay = loc.getDisplayCountry(); 
	        String languageDisplay = loc.getDisplayLanguage();  

	        System.out.printf(fmt, i + 1, country, countryDisplay, language, languageDisplay);
	    }
	}

	static void TestAvailableContry() {
	
		// #A2
		Locale[] allLocals = Locale.getAvailableLocales();
//		for (Locale locale : allLocals) {
//			System.out.println(locale);
//		}
	
		// #A3 aufsteigend
		System.out.println("\n*** Aufsteigend  sortieren");
		
		Comparator<Locale> cmp = (loc1, loc2) -> {
	            int result = loc1.getDisplayCountry().compareTo(loc2.getDisplayCountry());
	            return result != 0 ? result : loc1.getDisplayLanguage().compareTo(loc2.getDisplayLanguage());
	    };
		
        
		Locale[] availableLocales =  Stream.of(allLocals)
											.sorted(cmp)
//											.limit(100)
										    .toArray(Locale[]::new);
		printTable(availableLocales);
			
		System.out.println("\n---------------------------------------------------------------------------");
		
		// #A4 absteigend
		System.out.println("\n*** Absteigend   sortieren");
		
		 Comparator<Locale> cmpReverse = (loc1, loc2) -> {
	            int result = loc2.getDisplayCountry().compareTo(loc1.getDisplayCountry());
	            return result != 0 ? result : loc2.getDisplayLanguage().compareTo(loc1.getDisplayLanguage());
	     };
		
		availableLocales =  Stream.of(allLocals)
									.sorted(cmpReverse)
								    .toArray(Locale[]::new);
		printTable(availableLocales);
				
	}
	
}
