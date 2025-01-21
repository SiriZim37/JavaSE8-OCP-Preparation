package aufgaben.nested.a3;

//#A1
public class Person implements Comparable<Person> {

	private String vorname;
	private String nachname;
	private int geburtsjahr;
	
	public Person(String vorname , String nachname , int geburtsjahr) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsjahr = geburtsjahr;
	}
	
	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public int getGeburtsjahr() {
		return geburtsjahr;
	}

	public String toString() {
		return vorname + " " + nachname + " (" + geburtsjahr + ")";
	}

	public int compareTo(Person p2) {
		Person p1 = this;
		int res = p1.getVorname().compareTo(p2.vorname);
		return res!=0 ? res :  p1.geburtsjahr - p2.geburtsjahr;
	}
}
