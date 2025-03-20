package classes;

import classes.sub.Super;

// Wenn classes.sub.Super ist nicht Public (Sichbarkeit Public) , wird Compiler-Fehler

public class B06_Zugriff_Protected {

}

// test with package classes.sub;  Super

class Sub extends Super{
	
	public void print() {
		
		// System.out.println(privateInt);  : cf 
		// System.out.println(defaultInt);  : cf 
		System.out.println(protecedInt); // Es geht nur Vererbung
		 // funktioniert , weil Zugriff auf protected-Member aus einem anderen Pakage über Vererbung
		System.out.println(publicInt);
		
		this.testProtected();
	}
}

class Test{
	
	public void print() {
		Super sup = new Super();
//		System.out.println(sup.privateInt);     : cf 
//		System.out.println(sup.defaultInt);	    : cf 
//		System.out.println(sup.protecedInt);	: cf  // protected sichtbarkeit geht nur Vererbung !!! 
	 // Zugriff auf protected-Member aus einem anderen Pakage nur über Vererbung, nicht über einen Referenz.
		
		System.out.println(sup.publicInt);
	}
}
