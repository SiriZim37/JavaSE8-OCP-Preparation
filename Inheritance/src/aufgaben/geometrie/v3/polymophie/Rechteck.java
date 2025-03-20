package aufgaben.geometrie.v3.polymophie;

public class Rechteck extends Figur {

	private int breite ;
	private int hoehe;
	
	public Rechteck(int breite , int hoehe){
		this.breite = breite;
		this.hoehe = hoehe;
	}
	
	public Rechteck(int breite , int hoehe , int x , int y ) {
		super(x,y);
		this.breite = breite;
		this.hoehe = hoehe;
	}
	
	@Override
	public double getFlaeche() {
		return breite*hoehe ;
	}

	@Override
	public String toString() {
		return "["+ breite + " X "+ hoehe + " " + getDisplayPosition() + "]"; 
	}
}
