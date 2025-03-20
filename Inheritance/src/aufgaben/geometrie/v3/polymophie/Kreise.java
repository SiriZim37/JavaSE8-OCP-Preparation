package aufgaben.geometrie.v3.polymophie;

public class Kreise extends Figur {

	int radius;

	public Kreise(int radius){
//		super(0,0);  			// <-- wenn in Bassisklass Expliziten Konstruktor aber kein default Konstruktor
								// 		kann komische aufruf machen super(0,0);
		this.radius = radius;
	}
	
	public Kreise(int radius , int x , int y ) {
		super(x,y);
		this.radius = radius;
		
	}
	
	
	@Override
	public double getFlaeche() {
		return Math.PI * Math.pow(radius, 2) ;
	}
	
	@Override
	public String toString() {
		return "[R." + radius + ". " + getDisplayPosition() + "]" ; 
	}
	
}
