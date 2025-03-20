package aufgabe;

import java.util.Scanner;


public class AufgabenKlassenPersonen {

	public static void main(String[] args) {
		
//		 - Wenn die Klasse keinen expliziten Konstruktor hat ,
//		 * 	   generiert der Compiler für die Klassse den 
//		 * 	   paramaterlosen Konstruktor ( den default-Konstruktor)
//		Person person1 = new Person();
		
		// A5 und A6 		
		Person person1 = new Person("Hans", "Meyer", 1950, 12345);
		Person person2 = new Person("Sanh", "Yerem");
		// toString überschieben
		System.out.println(person1); // Hans Meyer, Geburtsjahr: 1950, Plz: 12345
		System.out.println(person2);  // Sanh Yerem, Geburtsjahr: -1, Plz: 0
		
		
		 String testGetName = person1.getVorname(); // Zugriffsmethhode
		
		//A7
		 // equal überschieben
		boolean result = person1.equal(person2); // person1.equal(person2) : false
		System.out.println("person1.equal(person2) : " + result); 

		Person person6 = new Person("Hans", "Meyer", 1950, 12345);
		result  = person1.equal(person6); // person1.equal(person5) : true
		System.out.println("person1.equal(person5) : " + result); 
		
        // A8: statischen Methode getMustermann
        Person mustermann = Person.getMustermann();
        System.out.println("Mustermann: " + mustermann); 
        
        
        /************************** PersonBuilder ******************************/
        
		//Using builder to get the object in a single line of code and 
        //without any inconsistent state or arguments management issues		
		
        /* diese Builder Concept muss man nicht viele Konstruktor schreiben. wie Oben  */
              
    
        // New Operatoren wird methode vorname , nachname ... vom Personbuilder zurück liefern
       
         //			Refeneze	new	Objekt
        Person p = new PersonBuilder()
				.vorname("John")  // << diese Metthode von Bilder
				.nachname("Doe")
				.geburtsjahr(1987) 
				.build(); // Personbuilder wird build rufen und dann wird data zurück liefern.
        System.out.println(p);
      
        
       	/*
    	 * 	Die Refenze personX wird Personbilder aufrufen
    	 *  new Operator wird data zurück liefern 
    	 */
        //			Refeneze		new Objekt
           PersonBuilder builder = new PersonBuilder();  // New Operator
           builder.vorname("John");  // << diese Metthode von Bilder
           builder.nachname("Doe");
           builder.geburtsjahr(1987);
//          builder.postleitzahl(132456);
           Person p22 = builder.build();
           System.out.println(p22);
    		
            
    
		
		System.out.println("\n\n*** Test console input data ****");
		/*
		 *  console input data
		 */
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Vorname: ");	
		String txtVorname = sc.nextLine(); 
		System.out.print("Nachname: ");	
		String txtNachname = sc.nextLine(); 
		System.out.print("Geburtsjahr: ");	
		String txtGeburtsjahr= sc.nextLine(); 
		System.out.print("Postleitzahl: ");	
		String txtPostleitzahl= sc.nextLine(); 
		
		String vorname = txtVorname.toString();
		String nachname = txtNachname.toString();

		if(isNumeric(txtGeburtsjahr.toString()) 
				&& isNumeric(txtPostleitzahl.toString()) ) {
			int geburtsjahr  = Integer.parseInt(txtGeburtsjahr); 
			int postleitzahl  = Integer.parseInt(txtPostleitzahl); 
			boolean checkData =  isAllFilledOut(vorname, nachname, geburtsjahr);
			if(checkData) {
				Person person4 = new Person(vorname, nachname, geburtsjahr, postleitzahl);
				System.out.println(person4);
				
				// test
				Person person5 = new PersonBuilder()
						.vorname(vorname)
						.nachname(nachname)
						.geburtsjahr(geburtsjahr)
						.postleitzahl(postleitzahl)
						.build();
				System.out.println(person5);
			}else {
				System.out.println("The data cannot be empty! Please fill out the information.");
			}
		}else {
			System.out.println("Please enter correct type!");
		}

		
	}

	
	static boolean isAllFilledOut(String vorname, String nachname, int geburtsjahr) {
		if( ( vorname == null || vorname.trim().isEmpty() )
				|| (nachname == null || nachname.trim().isEmpty())) {
			return false;
		}else {
			return true;
		}
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
