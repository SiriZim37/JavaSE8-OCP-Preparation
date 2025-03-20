package ocpexam;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest2 {

	
	public static void main(String[] args) {
		Locale currentLocale;  
		
		currentLocale = new Locale ("de", "DE"); 									// Wie geht?
//		currentLocale = new Locale.Builder ()
//						.setLanguage ("de")
//						.setRegion ("DE")
//						.build();  													// Wie geht?
//		currentLocale = Locale.GERMAN;   											// How are you?   
//		currentlocale = new Locale();currentLocale
//							.setLanguage ("de");
//		currentLocale.setRegion ("DE"); 											// cf
//		currentLocale = Locale.getInstance(Locale.GERMAN,Locale.GERMANY);			// cf
		
		ResourceBundle message = ResourceBundle.getBundle("loc.MessageBundle", currentLocale);
		System.out.print(message.getString("inquery"));
	}
	
	/*
	 * 
	 * 
	 * MessageBundle.properties.file  inquery = How are you?  
	 * MessageBundle_de_DE.properties.file inquery = Wie geht?  
	 * 
	 * 
	
	Which two code fragments, when inserted at line 1 independently, enable the code to print ''Wie geht's?''

	Options
	A	currentLocale = new Locale (''de'', ''DE'');
	B	currentLocale = new Locale.Builder ().setLanguage (''de'').setRegion (''DE'').build();
	C	currentLocale = Locale.GERMAN;
	D	currentlocale = new Locale();currentLocale.setLanguage (''de'');currentLocale.setRegion (''DE'');
	E	currentLocale = Locale.getInstance(Locale.GERMAN,Locale.GERMANY);
	?*/
}
