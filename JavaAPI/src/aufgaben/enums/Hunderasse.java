package aufgaben.enums;

public enum Hunderasse {

	DACKEL(0.5), COLLIE(1.0) , DOGGE(1.5);
	
	private final double maxGroesse;
//	private String rassen;
	private Hunderasse(double maxGroesse) {
	
		this.maxGroesse = maxGroesse;
	}

	public double getmaxGroesse() {
		return this.maxGroesse;
	}
	

	@Override
	public String toString() {
		return this.name().substring(0, 1) + this.name().substring(1).toLowerCase() + ", max. Größe: " + maxGroesse;
	}
}
