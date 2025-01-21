package aufgaben.streams.collects.personen;

public class Person implements Comparable<Person> {
	private String name;
	private String beruf;
	
	public Person(String name, String beruf) {
		this.name = name;
		this.beruf = beruf;
	}
	
	public String getName() {
		return name;
	}

	public String getBeruf() {
		return beruf;
	}

	public String toString() {
		return name ;
	}
	
	public int compareTo(Person person2) {
		int result = this.beruf.compareTo(person2.beruf) == 0 ?  
						this.name.compareTo(person2.name) :  this.beruf.compareTo(person2.beruf) ;
		return result ;
	}

}
