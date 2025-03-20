package vererbung;


class Person{
	static int g ;
	
	/*
	 *  Gemeinsamer Code für alle Klassen , die von Person erben
	 */
							// Die Attribute sollte versteckt werden.	
	String name;			// sollte private sein. Hier nur zum Testen 'pakage private'
	int geburtsjahr;		// sollte private sein. Hier nur zum Testen 'pakage private'
	
	public String getName() { return name; }
	public int getGebutsjahr() { return geburtsjahr; }

}

class Dozent extends Person{   // Dozent IS-A Person (Dozent ist eine Person)
	
	// name & geburtsjahr wurde vererbt. ชื่อและปีเกิดได้รับการสืบทอดมา
	Dozent(String name , int geburtsjahr){
		this.name = name ;
		this.geburtsjahr = geburtsjahr;
	}
	
	/*
	 *  Besondere Realisierung , die die Klasse Person nicht hat , 
	 *  aber Dozent :
	 *   
	 */
	
	int gehalt;
	
	public int getGehalt() { return gehalt; }
	public void setGehalt(int gehalt) {this.gehalt = gehalt;}
	public String toString() {
		return name + " ( " + geburtsjahr +" )." + "Gehalt : "+ gehalt ;
	}
	
}


class Student extends Person {	 // Student IS-A Person (Student ist eine Person)
	
	Student(String name , int geburtsjahr){
		this.name = name ;
		this.geburtsjahr = geburtsjahr;
	}

	/*
	 *  Besondere Realisierung , die die Klasse Person nicht hat , 
	 *  aber Student : 
	 */
	public String toString() {
		return name + " ( " + geburtsjahr +" ) " ;
	}
}


public class B01_GemeinsamerCodeInDerBasisklasse {

	public static void main(String[] args) {
		System.out.println(Person.g);
		
		Dozent d1 = new Dozent("Max", 1950);
		System.out.println(d1.getName());
		System.out.println(d1.geburtsjahr);
		System.out.println(d1);
		
		
		Student s1 = new Student("Ute", 1990);
		
		System.out.println(s1.getName());
		System.out.println(s1.geburtsjahr);
		System.out.println(s1);

	}

}
