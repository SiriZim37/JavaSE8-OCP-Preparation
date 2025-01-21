package exeptions;

public class B08_Rethrow {

	/*
	 * Rethorw : eine Exception abfangen und aus dem catch-Block weiter werfen
	 */
	public static void main(String[] args) {

		myMethod(); // ArithmeticException: / by zero
	}
	
	static void myMethod() {
		try {
			System.out.println(5/0);
		} catch (ArithmeticException e) {
			// hier protokollieren...
			
			throw  e; // rethrow
		}
	}

}
