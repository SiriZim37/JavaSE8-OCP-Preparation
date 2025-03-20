package aufgeben.javakurs;



public class Dozent extends Person{ 

	public Dozent(String name , String id) { 
		super(name,id);
	}

	@Override
	public String toString() {

		return  "Dozent(in) " + super.toString();
	}
}