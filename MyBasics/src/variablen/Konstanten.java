package variablen;

public class Konstanten {

	/*
	 *  Konstanten > Man kann Sie nicht andern  
	 *  In Java, a constant is a variable whose value cannot be changed once it's assigned. 
	 */
	public static void main(String[] args) {

		int x1 = 12;
		System.out.println("1. x1 = " + x1); // 12
		x1 = 77; 
		System.out.println("2. x1 = " + x1); // 77
		
		final int x2 = 12;
		System.out.println("3. x2 = " + x2); // 77
//		x2 = 77; 	// cf : x2 ist eine Konstante
		
		/*
		 * 	Variablen ( und Konstanten) müssen nicht sofort initialisiert werden
		 */
		final int x3; 
		x3 = 12;
		System.out.println("4. x3 =" + x3);
		
	}

}
