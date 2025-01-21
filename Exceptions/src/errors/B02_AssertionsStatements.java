package errors;

import java.util.Arrays;

public class B02_AssertionsStatements {

	/*
	 *  nicht vergessen die Assertions zu aktivieren : 
	 *  
	 *  	java -ea NameDerKlassMitDerMain
	 */
	public static void main(String[] args) {
		/*
		 * Statement I : 
		 * 		assert <boolean> ;
		 * 
		 * Statement II : 
		 * 		assert <boolean> : <value> ;
		 * 
		 */
		
//		assert 22; // cf
		
		assert true;
		
		int x = 100;
		assert x>100 : "x must more than 100";

		assert x == 0 : "x sollte 0 sein";
		
		x = 1;
		assert x == 0 : "Nochmals. x sollte 0 sein";
		
		assert true : 12;
		assert true : new Object();
		assert true : Arrays.asList(1,2,3,4);
//		assert true : System.out.println("hello");  //  Es kann nicht void zurück liefert!! 
		

		System.out.println( );
		
		System.out.println("end of main");
	}

}
