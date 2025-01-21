package func;

public class B03_Lambdas {
	/*
	 *  - Lambdas sind NUR im Kontext einer Zuweisung möglich! 
	 * 
	 * 	- Lambdas gibt es nur für funktionale Interfaces (s. Bsp 01).
	 */
	public static void main(String[] args) {

		/*
		 * Explizite Zuweisung/Intaialisierung
		 */
		
		Runnable v1 = ()->{};
		
		// ()->{};  // cf : ohne Zuweisung
		
		// Object v2 = () ->{};   // cf : Objekt ist kein funkt. Interface
		
		/*
		 * Implizite Zuweisung in eine 'anonyme'
		 * Zuweisungvariable beim Cast
		 */
		
		Object v3 = (Runnable)() ->{};  // ok :  kann so interpretiert werden : 
										// Runnable tmp = () -> {};
										// Object v3 = tmp;
		
		/*
		 * Implizite Zuweisung beim Übergeben eines Argumentes
		 */
		useRunnable( ()->{} ); // Runnable param = ()-> {} 
		
		/*
		 * Implizite Zuweisung beim Hochladen eines return-Argumentes (s. die Methode getRunnable)
		 */
		getRunnable();
		
		
	} // end of main

	static void useRunnable(Runnable param) {}
	
	static Runnable getRunnable() {
		return ()->{};    // ok : Runnable cpu = ()->{}
	}
}
