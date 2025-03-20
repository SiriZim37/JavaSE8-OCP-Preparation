package aufgabe;

import java.time.Year;

// A1
public class Person {
	
	
	/*
	 *  private : Mar darf nur in diese Klass benutzen
	 *  public Konstruktor : Man darf diese KOnstruktur bunutzen mit mein Elemente
	 * 
	 */
	
	// Attribute
	private String vorname;   // Es kann nur in der Klass person programmiert.
	private String nachname;
	private int geburtsjahr =-1;
	private int postleitzahl ; // oder private String postleitzahl; sind auch korrekt
	
	// A2
	// Konstruktoren
	public Person(String vorname , 
		   String nachname,
		   int geburtsjahr,
		   int postleitzahl){
		this(vorname , nachname);   // vorname , nachnaamw wurde inisalisiert. (initail)
		this.geburtsjahr = geburtsjahr;
		this.postleitzahl = postleitzahl;
	}
	
	public Person(String vorname , 
			   String nachname){
			this.vorname = vorname;
			this.nachname = nachname;
//			this.geburtsjahr = -1; // wenn Attribute gesetzt wurde , 
//			this.postleitzahl =  0; // wenn nicht dann nimmt value von default  
		}
	
	// A4
	// Getter und Setter (JavaBeans Standard)
	public String getVorname() {	   
		return vorname;
	}
	
	public void setName(String vorname) {
		if(vorname == null || vorname.trim().isEmpty()) 
			throw new IllegalArgumentException("falscher vorname");
		this.vorname = vorname;		
		
	}
	
	public String getNachname() {	   	
		return nachname;
	}
	
	public void setNachname(String nachname) {
		if(nachname == null || nachname.trim().isEmpty()) 
			throw new IllegalArgumentException("falscher nachname");
		this.nachname = nachname;		
	}
		
	public int getGeburtsjahr() {	   
		return geburtsjahr;
	}
	
	public void setGeburtsjahr(int geburtsjahr) {
		if(geburtsjahr <= Year.now().getValue()) 
		   this.geburtsjahr = geburtsjahr;
	}
	
	
	public int getPostleitzahl() {	   
		return postleitzahl;
	}
	
	public void setPostleitzahl(int postleitzahl) {
			this.postleitzahl = postleitzahl;		
	}
		

	// A3
	public String toString() {
		return vorname + " " + nachname + ", Geburtsjahr: " + geburtsjahr + ", Plz: " + postleitzahl;
	}
	
	
	//A7
	
	public boolean equal(Object obj){

		if(!(obj instanceof Person)) {
			return false;
		}
		/*
		 *  Die vorname, nachname und postleitzahl sind Referenzen.
		 *  Dafür hat die Klasse String auch ihre equals Methode überschrieben.
		 */

		Person p = (Person) obj;  
	    return  vorname.equals(p.vorname) &&
	             nachname.equals(p.nachname) &&
	             geburtsjahr == p.geburtsjahr &&
	             postleitzahl ==p.postleitzahl;
	}
	
	// A8
	//  __statische__ Methode `getMustermann`	
	static Person getMustermann() {
		return new Person("Max", "Mustermann", 1960 ,12345 );
	}	
	
	

	
}
