package aufgabe;

	// A9

public class PersonBuilder {
	

			
	/* oder Wir können Attribute formulieren*/
	private String vorname;
	private String nachname;
	private int geburtsjahr;
	private int postleitzahl;
			
	public PersonBuilder vorname(String vorname) {
           this.vorname = vorname;
           return this;
       }

	public PersonBuilder nachname(String nachname) {
           this.nachname = nachname;
           return this;
       }

	public PersonBuilder geburtsjahr(int geburtsjahr) {
           this.geburtsjahr = geburtsjahr;
           return this;
       }

	public PersonBuilder postleitzahl(int postleitzahl) {
           this.postleitzahl = postleitzahl;
           return this;
       }

	
	
	public Person build() {
		// hier kann man überprüfen , 
		// ob es genug Daten für neue Person gibt
           return new Person(vorname, nachname, geburtsjahr, postleitzahl);
       }			
	
	
//	
//	
//	/* Man kann übrig midesten 1 Konstruktor programmieren. */
//	
//	 private Person person = new Person("","",-1,-1) ;  
//			
//	/* oder Wir können Attribute formulieren*/
//	private String vorname;
//	private String nachname;
//	private int geburtsjahr;
//	private int postleitzahl;
//			
//	public void vorname(String vorname) {
////			person.setName(vorname);
//            this.vorname = vorname;
//        }
//
//	public void nachname(String nachname) {
////			person.setNachname(nachname);
//            this.nachname = nachname;
//        }
//
//	public void geburtsjahr(int geburtsjahr) {
////		person.setGeburtsjahr(geburtsjahr);
//            this.geburtsjahr = geburtsjahr;
//
//        }
//
//	public void postleitzahl(int postleitzahl) {
////		person.setPostleitzahl(postleitzahl);
//            this.postleitzahl = postleitzahl;
//
//        }
//
//	
//	public void build() {
//		// hier kann man überprüfen , 
//		// ob es genug Daten für neue Person gibt
//            return new Person(vorname, nachname, geburtsjahr, postleitzahl);
//        }			

}
