package interfaces;

import java.io.Serializable;

public class WdhExtendsImplements {

	/*
	 * 	Innere Interfaces und Klassen gibt es nicht in der Prüfung!
	 *  In diesem Beispiel betrachten Sie bitte die Interfaces und 
	 *  Klassen als normal
	 */
	
	/* 1.
	 *  Klasse implements Interface
	 */
	interface I1{}
	
//	class C11 extends I1{ }   	  // Compiler Fehler : interface kann nur mit implements zugrifen.
	class C12 implements I1{ } 	  //  OK : Korrekt
	
	/* 2.
	 * 	Eine Klasse darf nur eine andere Klasse erweitern
	 */
	
	class B1{
		void m1() {}
	}
	
	class B2{
		void m2() {}
	}

//	class C21 extends B1 , B2 {} // Compiler Fehler : 
	class C22 extends B1 {}      //  OK : Korrekt

	
	/* 3.
	 * 	InterfaceA extends InterfaceB
	 * ( Wenn ein Interface von einem anderen Interface erbt, verwenden wir den Begriff "erben" oder "erweitern" (extends).)
	 */
	
	interface I2 {}
//	interface I3 implements I2 {} 	// Compiler Fehler 
	interface I3 extends I2 {} 		// OK : Korrekt

	
	/* 4.
	 * Elemente eines Interfaces sind implizit public!!! 
	 */
	
	interface I4{
		void m();
	}

	class C4 implements I4{
//		void m() { }	       // Compiler Fehler : Sichtbarkeit verschärft! 
		public void m() {}     // OK : Korrekt
	}
	
	/* 5.
	 * 	Eine konkrete Klasse muss alle abstrkten Methoden
	 * 	aus dem Basisinterface realisieren.
	 */
	interface I5{
		void m1();
	}
	interface I6 extends I5 {	 // I6 Is-A I5
		void m2();
	}
//	class C51 implements I6 {	// Compiler Fehler : Methode m1 ist nicht implementiert! 
//		public void m2() {}
//	}
	
	class C52 implements I6 { 	 // OK : Korrekt
		public void m1() {}
		public void m2() {}
	}
	
	/* 6. 
	 * 	Wenn der Compiler sieht , dass eine Klasse ein Interface
	 * 	mit implements implementiert , überprüft der Compiler , 
	 * ob die Klasse die notwendigen ( zu realisierenden) Methoden hat.
	 * Dabei ist es egal , wie die Klasse die Methoden bekommt.
	 * Die Klasse kann z.B. die Methoden aus der Basisklase erben.
	 */
	
	interface Laffaehig{
		void laufen();
	}
	class Laeufer {
//		final void laufen() {} 	// wenn es final ist , wird Mensch Class conpiler fehler geben.
	
		// Methode muss als 'public' deklariert werden
		public void laufen() {}
	}
	
	class Mensch extends Laeufer implements Laffaehig{ 	
	}
}
