package aufgaben.geometrie.v3.polymophie;

abstract class Figur {

	protected int x ;
	protected int y ;
	
	public Figur() {}
	
	
	public Figur(int x , int y ) {
		this.x = x;
		this.y = y;
	}
	
	void bewegen(int newX , int newY ) {
		this.x += x ;
		this.y += y ;
	}
	
    public abstract double getFlaeche();
    
	
	public String getDisplayPosition() {
		return "Figur: X:" + x + ",Y:" + x + "";
	}
	
    
    @Override
    public String toString() {
		return  "Figur: X:" + x + ",Y:" + x + "";
	}
	
}
