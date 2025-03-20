package vererbung;

interface InterThree{
	// Pre Java 8
	// Konstanten, implizit public , static final
	int X = 77 ; 
	// abstrkte Mehtode , implizit public abstract 
	void doIt();
	
	// set Java 8 
	// Methoden mit Standard-Implementierung (default-Methoden)
	// Schlüsselwort 'default' , implizit public!! 
	
	 default void printDefault() { 
		System.out.println("print default");
	}
	
//	protected default void printDefault() { } // cf : es kann nicht protected , implizit public!! 
	
//	default void test(); // cf : default-Methoden müssen einen Methodenrumpf haben
	default void test() {	} //  OK 
	
	// seit Java8
	// statische Methoden sind in einem Interface erlaubt , implizit public ! 
	static void print() {
		System.out.println("X =" + X);
	}
}


class InerTestThree implements InterThree {

	@Override
	public void doIt() {
		System.out.println("do it");
	}	
	
	@Override
	public void printDefault() {
		System.out.println(X + "" );
		System.out.println("print in InterTestThreeII");
		
		// Aufruf der default-Methode des Interface,
//		super.printDefault(); // cf : 
		
		// Interfacename.super.Methodename > funktioniert es ! 
		InterThree.super.printDefault(); // ok 
		// Beim Aufruf einer statischen Methoden aus dem Interface muss der Name des Interfaces vorangestellt werden.
		InterThree.print();  // ok 
	}
}

/* 'default' :  Wird in Interfaces verwendet und ermöglicht eine Standardimplementierung 
 * 				von Methoden in einem Interface. Die Sichtbarkeit dieser Methode ist public, 
 * 				weil alle Methoden in einem Interface automatisch public sind, auch wenn du default verwendest.
 * 
 * 'package-private': Ist die Standardzugriffsmodifikator-Sichtbarkeit für Klassen und ihre Mitglieder, 
 * 					  wenn kein anderer Zugriffsmodifikator angegeben ist. Es beschränkt den Zugriff auf das gleiche Paket.


 * Zusammenfassend lässt sich sagen, dass 'default' in Java für Interface-Methoden verwendet wird, 
 * um eine Implementierung zu geben, während 'package-private' den Standardzugriff 
 * für Klassen und ihre Mitglieder definiert, wenn keine Zugriffsmodifikatoren angegeben sind. 
 * Sie haben also unterschiedliche Zwecke und sind in unterschiedlichen Kontexten relevant.
 */


public class B23_Interface_Default_Static {

	public static void main(String[] args) {
		
		
		InterThree it = new InerTestThree();
		it.printDefault();  //   void vererbung.InterThree.printDefault ()

		it.doIt();
		
		

	}

}
