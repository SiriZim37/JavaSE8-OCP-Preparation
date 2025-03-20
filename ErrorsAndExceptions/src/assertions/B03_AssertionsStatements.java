package assertions;

public class B03_AssertionsStatements {

	public static void main(String[] args) {
	
	/*	Achtung! 
	 * 	
	 * 		Nur bei aktiviereten Assertions sind assert-Statements aktiv.
	 * 
	 * 		assert false generiert dann ein Assertions
	 */
		
		
		
		/*
		 * Statement I : 
		 * 
		 * 		assert <hier boolean>
		 */
		
		int x = 0 ; 
		
		assert true;
		assert x == 0 ;
		assert !"moin".isEmpty();

		/*
		 * 	Statement I : 
		 * 
		 * 		assert <hier boolean> : <hier ein Value>
		 */

		 x = -22 ; 
		 
		 assert x > 0 : " x sollte eigentlich positive sein ist aber = " + x ;
		 assert x < 0 ;
		 assert x > 0 : new Object(); 
		 assert x > 0 : Math.random();   
//		 assert x > 0 : System.out.println();
		 
		 
		 
		 
		 System.out.println("end of main ");
		 
	}

}
