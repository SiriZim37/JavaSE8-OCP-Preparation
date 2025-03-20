package exceptions;

public class B03_Exceptions_declare {

	public static void main(String[] args) {
		
		try {
			printDeclare(7,1) ; 
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		printHandle(7,0) ; 
		System.out.println("Servus");
		
	
	}
	
	// throws : werfbar
	private static void printDeclare(int a , int b) throws IllegalArgumentException{
		// handle or declare
		// Exception behandeln mit try-catch oder einfach weiterreichen an den Aufruf von Print
		System.out.println("a / b = " + divide(a, b));
		
	}
	
	private static void printHandle(int a , int b) {
		// handle or declare
		// Exception behandeln mit try-catch oder einfach weiterreichen an den Aufruf von Print
		try {
			System.out.println("a / b = " + divide(a, b));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		
	}
	
	/* IllegalArgumentException : 
	 * Die IllegalArgumentException ist eine spezielle Art von Laufzeitfehler (Runtime Exception) in Java. 
	 * Sie tritt auf, wenn einer Methode ein ungültiges oder unangemessenes Argument übergeben wird
     */
	public static  int divide(int a , int b ) throws IllegalArgumentException {
		// Falls b == 0 ist , soll eine Excepttion an den Aufrufer der Mthode geworfen werden  (declare)
		if( b == 0) {
			throw new IllegalArgumentException("Der Divisor darf nicht 0 sein"); 
		}
		return a / b ;
	}

}
