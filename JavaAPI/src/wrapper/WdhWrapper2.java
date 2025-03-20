package wrapper;

class Calc{
	Integer x ; 
    int y ; 
	String s;
	
	public Calc() {
		System.out.println( "s " + s + " x " + x + " y " + y );
	}
	
	public Calc(int value) {
//		 super() ;
//		 this.x =  ; 
		y = x + value;	// NullPointerException beim Autounboxing : x.intValue
	}
	
	@Override
	public String toString() {
	
		return "" + x + " " +  String.valueOf(y);
	}
}


public class WdhWrapper2 {
	
	public static void main(String[] args) {
		
		System.out.println(new Calc());
		
		System.out.println(new Calc(42));	// NullPointerException
	}

}
