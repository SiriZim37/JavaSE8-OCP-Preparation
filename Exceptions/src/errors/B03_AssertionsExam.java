package errors;

public class B03_AssertionsExam {

	/*
	 * 1. Zuerst überprüfen , ob der Code kompiliert (s.20)
	 * 
	 * 2. Wenn der Code kompilert, überprüfen , ob  die 
	 *	  Asssertions beim Start aktiviert werden
	 */
	public static void main(String[] args) {

		/*
		 * Gegeben ist folgende
		 */
		int x = 0 ;
		
		assert x == 0 : "moin";
		
		System.out.println( "1. x = " + x )  ;
		
		x = 1 ; 
		
		assert x == 0 ;
		
		System.out.println( "2. x = " + x )  ;

		/*
		 *  java B03_AssertionsExam
		 *  
		 *  Ausgabe : 
		 * 			x = 0 
		 * 			x = 1
		 *  
		 * java -ea B03_AssertionsExam
		 * 
		 * Ausgabe : 
		 * 			x = 0 
		 * 			gefolgt von einer Error (AssertionError)
		 */
	}

}
