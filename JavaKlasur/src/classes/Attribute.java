package classes;


class Boxer{
	int a ; 
	int a1 = 42;
	int a2;
	{
		a2 = 34;
	}
	int a3;
	
	char b ; 
	
	boolean c ;
	
	
	String d ;
	Object e ; 
	Integer f ;
	Double g;
	
	public Boxer() {
		a3 = 44;
	}
	

	
	@Override
	public String toString() {
		return " Boxer \n a = " + a 
				+ "\n a1 = " + a1 
				+ "\n a2 = " + a2 
				+ "\n a3 = " + a3 
				+ "\n b = '" + b  + "'"
				+ "\n c = " + c 
				+ "\n d = " + d 
				+ "\n e = " + e 
				+ "\n f = " + f 
				+ "\n g = " + g ;
	}
}

public class Attribute {


	public static void main(String[] args) {
		System.out.println(new Boxer().a2);
		System.out.println(new Boxer().a2);
		 Boxer b = new Boxer();
		 System.out.println(b);
	}

}
