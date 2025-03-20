package functonal;

import java.util.Comparator;

interface I1 {	 // kein funkt. Interface
	
}

interface I2{	//	kein funkt. Interface
	void m1();
	void m2();
}

interface I3 {	 //  funkt. Interface
	void m();  // funktioniert mit abstrakt Methode
}

interface I4 {	 //  funkt. Interface
	void m1();  // funktioniert mit abstrakt Methode
//	void m();
	default void m2() {}
	static void m3() {}
	int K1 = 1 ;
}


interface I5 {	 //  funkt. Interface
	void m1();   // funktioniert mit abstrakt Methode
	
	/* Achtung!! Die Methoden mit der Signaturen aus der Klasse 
	 * 			    Object zählen dabei nicht.
	*/
	
	String toString();			// Signaturen aus Object 
	boolean equals(Object o);	// Signaturen aus Object
	int hashCode();				// Signaturen aus Object
	
}

/*
 * 	mit der Annotation @FunctionalInterface
 *  wird ein zusätlicher Compiler-Check aktiviert
 */
@FunctionalInterface
interface I6{
	void m();
}

//@FunctionalInterface
//interface I7{			// cf : @FunctionalInterface überprüft : I7 ist kein funkt. Interface
//	void m1();
//	void m2();
//}

public class B03_FunctionalInterface {

	/*
	 * 	- Lambdas funktionieren NUR mit funktionalen Interfaces
	 * 
	 * 	- Funktionalers Interface ist ein Interface 
	 * 	  mit ganaueiner abstrakten Mthode!!!
	 * 
	 * 	- Achtung!! Die Methoden mit der Signaturen aus der Klasse 
	 * 			    Object zählen dabei nicht.
	 */
	
	public static void main(String[] args) {
	
//		I1 v1 = () -> {}; // cf
//		I2 v2 = () -> {}; // cf
		I3 v3 = () -> {}; // OK	
		I4 v4 = () -> {}; // OK	: mit ganaueiner abstrakten Mthode!!! : 
						  //	  void m1 is abstrakt Methode und ignoriert default void m2() {}
		I5 v5 = () -> {}; // OK	
		
		Comparator<String> c1 = (s1,s2) -> 0;
		
	}

}
