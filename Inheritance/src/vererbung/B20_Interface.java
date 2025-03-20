package vererbung;


//Ein Interface ist ein abstrakter Typ. Der Modifizierer abstract ist implizit. Sichtbarkeit public oder default.
abstract interface InterTest{
	
//	int test;  // Fehler in einem Interface sind immer implizit public , static und final
	
//	int TEST = 42 ; // ok
	public static final int TEST = 42 ; // OK !!!! Immmer In der Prüfung public static final  !!!!!!***
//	private TEST = 42; // cf : only public, static & final are permitted
	
	// Interface-Methoden sind immer public und abstract!!
	 void doIt();					// default : ok 
//	 public abstract void doIt();	// public : ok


	/// --- TEST ---  ///
//	 public static m1() {;} // cf
	 default void m2() {} // ok 
	 abstract int m3(); // ok 
//	 final short m4() {return 5;} // cf
	 static void m6() {;} // ok
//	 final void m8();  // cf		:  only public, abstract, default, static and strictfp are permitted

 

}


// Eine Klasse kann beliebig viele Interface Implementieren (Scglusselwort implements).
// Wenn eine Klasse ein Imterface implementiert , geht es einen Vertrag mit disem Interface ein,
// nämlich den,dass allle abstrakten Methoden Implementiert werden müssen.

class InterClass implements InterTest {
	
	/* ACHTUNG !!
	 *  	Eine implementierte Methode aus einem Interface muss immer public sein.!!!! 
	 */
	@Override
	public void doIt() {    
		System.out.println("do It!");
	}
	
	// Zugriff auf die Konstranten eines Interfaces in den 
	// implimentierenden Klassen kann ohne Angabe des Interfaces geschehen.
	public void printTest() {
		System.out.println("TEST = " + InterTest.TEST);  // ok
		System.out.println("TEST = " + TEST);	// ok
	}

	@Override
	public int m3() {
		// TODO Auto-generated method stub
		return 0;
	}
}
	

public class B20_Interface {

	public static void main(String[] args) {


		InterClass ic = new InterClass();
		ic.doIt();
		
		
		/*---- Polymorphie ----*/
//		InterTest it = new InterTest(); // cf : Interface kann nicht instanziert werden ( wie auch abstract Klassen)
		
		InterTest it = new InterClass(); // OK ! 
		it.doIt();
		
		test(ic); // ok  Polymorphie
		test(it); // ok  vom Typ Intertest

	}
	
	public static void test(InterTest it) {
		System.out.println("test"); 
		it.doIt();			// Alles das InterTest Implementiert .Es funktioneiert Aufruf.
	}

}
