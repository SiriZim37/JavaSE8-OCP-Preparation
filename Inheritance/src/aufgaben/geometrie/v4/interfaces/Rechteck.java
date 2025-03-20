package aufgaben.geometrie.v4.interfaces;

public class Rechteck implements Figur{

	private double breite;
	private double hoehe;
	
	public Rechteck(double breite , double hoehe) {
		this.hoehe = hoehe;
		this.breite = breite;
	}

	
	@Override
	public double getFlaeche() {
		return breite*hoehe;
	}
	
	@Override
	public String toString() {	
		return String.format("[Höhe : %.3f , Breite :  %.3f ]", this.hoehe , this.breite );
	}
}
