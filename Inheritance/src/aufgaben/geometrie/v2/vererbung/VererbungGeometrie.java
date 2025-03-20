package aufgaben.geometrie.v2.vererbung;

//  Rechteck & Kreis hat die x und y Koordinaten.
class Figur{
	protected  int x ; 
	protected  int y ;
	
	public  Figur(){
//		super( );	 // <- generiet vom Compiler 
//		this.x = 0;  // <- generiet vom Compiler 
//		this.y = 0;  // <- generiet vom Compiler 
	}

	public  Figur(int x , int y ){
		this.x = x ; 
		this.y = y ;
	}

	public  void bewegen(int newX , int newY) {
		this.x = newX ;
		this.y = newY;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
    // test
    public void printKoordinaten() {
        System.out.println("\nAktuellen Koordinaten: (" + x + ", " + y + ")");
    }
    
}

class Rechteck extends Figur{
	private int width;
	private int height;
	    
	
	public Rechteck(int breite, int hoehe) {
		// super();  //<-  generiet vom Compiler 
		this.width = breite;
		this.height = hoehe;
	}
	
	public Rechteck(int width , int height, int x, int y) {
		super(x, y); 
		this.width = width;
		this.height = height;
	}
	
	public String toString() {
		return  "Rechteck (" + width + " X " + height + ") at (" + getX() + ", " + getY() + ")" ;
	}
}

class Kreis extends Figur {
	
	private int radius;
	
	public Kreis(int radius) {
		// super(); //<-  generiet vom Compiler 
		this.radius = radius;
	}
	
	public Kreis(int radius, int x, int y) {
		super(x, y);
		this.radius = radius;
	}
	public String toString() {
		return "Kreis. R = " + radius + " at (" + x + ", " + y + ")";
	}
	
}


public class VererbungGeometrie {

	public static void main(String[] args) {

		Rechteck r1 = new Rechteck(3, 4 );
		r1.printKoordinaten();
		System.out.println(r1); // Rechteck (3 X 4) at (0, 0)
		
		
		r1.bewegen(12,-7);  	//  Move Rechteck to new Koordinaten (12, -7).
		r1.printKoordinaten();
		System.out.println(r1); // Rechteck (3 X 4) at (12, -7)
		
		
		Kreis c1 =  new Kreis(4);
		c1.printKoordinaten();
		System.out.println(c1); // Kreis. R = 4 at (0, 0)
		
		c1.bewegen(33, 1); 		//  Move Kreis to new Koordinaten (33, 1).
		c1.printKoordinaten();
		System.out.println(c1); // Kreis. R = 4 at (33, 1)
		
		
		// Test 
		System.out.println("\n\n#test no parameter"); 
		Figur k1 = new Figur();
		k1.printKoordinaten();
		
		
		System.out.println("*** Rechteck: ");
		 r1 = new Rechteck(3, 4);
		System.out.println("1. r1: " + r1);
		r1.bewegen(12, -7);
		System.out.println("2. r1: " + r1);
		
		System.out.println("\n*** Kreis: ");
		 k1 = new Kreis(5);
		System.out.println("1. k1: " + k1);
		k1.bewegen(33, -22);
		System.out.println("2. k1: " + k1);
		
	} 

}
