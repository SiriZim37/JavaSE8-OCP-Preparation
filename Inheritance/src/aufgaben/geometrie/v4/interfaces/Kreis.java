package aufgaben.geometrie.v4.interfaces;

public class Kreis implements Figur {
	private  double radius;

	public Kreis(double r ) {
		this.radius = r;
	}
	
	
	@Override
	public double getFlaeche() {
		return Math.PI * Math.pow(radius, 2);

	}
	
	@Override
	public String toString() {			
		return String.format("[Radius : %.3f ]", this.radius );
	}
	

}
