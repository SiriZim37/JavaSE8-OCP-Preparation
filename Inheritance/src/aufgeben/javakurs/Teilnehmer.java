package aufgeben.javakurs;

//Klasse Teilnehmer, erbt von Person
public class Teilnehmer extends Person {
	
	 
	public Teilnehmer(String name , String id) {
		super(name,id);
	}
	
	@Override
	public String toString() {
		return "Teilnehmer(in): " + super.toString();
	}
	
}