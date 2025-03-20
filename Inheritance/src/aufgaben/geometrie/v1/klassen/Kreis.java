package aufgaben.geometrie.v1.klassen;


public class Kreis {
	int radius;
	
	String getDisplayRadius() {
		return "R = " + radius;
	}
	
	//... bequeme Ausgaben
	public String toString() {
		return "Kreis. R = " + radius ;
	}
}
