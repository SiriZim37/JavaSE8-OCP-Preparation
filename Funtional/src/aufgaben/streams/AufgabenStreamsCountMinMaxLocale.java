package aufgaben.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Predicate;

public class AufgabenStreamsCountMinMaxLocale {

	public static void main(String[] args) {
		
		a1();		
		a2();		
		a3();
	    
	}
	
	static void a1() {
		System.out.println("***A1.");
		// A1
		Locale[] locales = Locale.getAvailableLocales();       
		
		Comparator<Locale> comp = (loc1 , loc2) -> loc1.getDisplayCountry().compareTo(loc2.getDisplayCountry());
		
		// Variante 1
		Optional<Locale> maxLocale = Arrays.stream(locales)
											.filter(locale -> !locale.getDisplayCountry().isEmpty())
											.max(comp);
		
		// Variante 2 
	    maxLocale = Arrays.stream(locales)
	    				  .filter(locale -> !locale.getDisplayCountry().isEmpty())
	    				  .max(Comparator.comparing(loc -> loc.getDisplayCountry()));
	    
		// Variante 3
	    maxLocale = Arrays.stream(locales)
		    			  .filter(locale -> !locale.getDisplayCountry().isEmpty())
		    		      .max(Comparator.comparing(Locale::getDisplayCountry));

		if (maxLocale.isPresent()) {
	         System.out.println("Locale mit dem größten Wert: " +   maxLocale.get().getDisplayCountry());
	    } else {
	       System.out.println("Kein Land gefunden.");
	    }
	
		
		split();
	}
	
	static void a2() {
		Locale[] locales = Locale.getAvailableLocales();
		
		System.out.println("***A2.");
		// A2
		Predicate<Locale> pred = lang -> "de".equals(lang.getLanguage());
		
		Arrays.stream(locales)
	            .filter(locale -> !locale.getDisplayCountry().isEmpty()) 
	            .filter( pred )
	            .forEach( s -> System.out.println(s.getDisplayCountry()));
		
		
		long anzahl =  Arrays.stream(locales)
				             .filter(locale -> !locale.getDisplayCountry().isEmpty()) 
				             .filter( pred )
				             .count();
		
	    System.out.println("Anzahl der Locale mit der Sprache 'de': " + anzahl);
	    
		split();
	}
	
	static void a3() {
		
		Locale[] locales = Locale.getAvailableLocales();
	    // A3
	    System.out.println("***A3.");
	    
	    locales = Locale.getAvailableLocales();
	    
	    // A    
	    List<Locale> filtered = new ArrayList<>();
	    for (Locale locale : locales) {
	        if(locale.getDisplayCountry().contains("t")) {
	            filtered.add(locale);
	        }
	    }
	    
	    Comparator<Locale> cmp = (loc1, loc2) -> 
	            loc1.getDisplayLanguage().compareTo(loc2.getDisplayLanguage());
	    
	    filtered.sort( cmp );
	    
	    Locale min = null;
	    if(filtered.size() > 0) {
	        min = filtered.get( 0 );
	    }
	    System.out.println(filtered);
		System.out.println("min : " + min);
	    System.out.println("Country : " + min.getDisplayCountry());
	    System.out.println("Language : " + min.getDisplayLanguage());
	    
	    // B
	   System.out.println("\n---Stream---");
	    
	   Arrays.stream(locales)
	            .filter(locale -> !locale.getDisplayCountry().isEmpty()) 
	            .filter(locale -> locale.getDisplayCountry().contains("t"))
	            .sorted(Comparator.comparing(Locale::getDisplayLanguage))
	            .forEach( s -> System.out.print( s + ", " ));
	   
	  
	   Optional<Locale> minimum =  Arrays.stream(locales)
								            .filter(locale -> !locale.getDisplayCountry().isEmpty()) 
								            .filter(locale -> locale.getDisplayCountry().contains("t"))
								            .min(Comparator.comparing(Locale::getDisplayLanguage));
	   System.out.println();
	   
	   if(minimum.isPresent()) {
			min = minimum.get();
			System.out.println("min : " + min);
			System.out.println("Country : " + min.getDisplayCountry());  	
			System.out.println("Language : " + min.getDisplayLanguage());  
	   }else {
			System.out.println("Keine min vorhanden");
	   }

		split();
	}
	
	static void split() {
		System.out.println("-----------------------------------------------" );
	}

}
