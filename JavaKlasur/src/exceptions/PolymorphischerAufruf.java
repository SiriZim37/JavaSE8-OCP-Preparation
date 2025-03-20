package exceptions;

import java.util.Random;

class Alpha {
	void foo() throws Exception { System.out.println( "A");}
}

class Beta extends Alpha{
	void foo() { System.out.println( "B"); }
}

public class PolymorphischerAufruf {

	public static void main(String[] args)  {
		/*
		 * Achtung ! Der Compiler kennt den Wert einer Variable NICHT! 
		 * Achtung ! Der Compiler kennt den Wert einer Variable NICHT! 
		 * Achtung ! Der Compiler kennt den Wert einer Variable NICHT! 
		 * Achtung ! Der Compiler kennt den Wert einer Variable NICHT! 
		 * Achtung ! Der Compiler kennt den Wert einer Variable NICHT!   
		 */

		Alpha a ;		
//		System.out.println(a); // cf : compiler kennt den Wert nicht!
		
		Alpha a1 = new Alpha() ;
		System.out.println(a1);  // ok : suchen nach den Referenz exceptions.Alpha@65ae6ba4
//		a1.foo();	//  cf : kein Exception 
		
		
		if(new Random().nextBoolean()) {
			a1 = new Beta();	
		}		
//		a1.foo();   //  cf : kein Exception
			    	// Compiler weiß nicht welcher Typ anrufen sollte
				    // a1 kann auch vom Typ Alpha oder Beta
		
		/*** Compiler kennt nur den Typ 'Alph'a aber kennt den Wert von ' new Beta()' Nicht! *****/
		
		//a1 = new Beta() ; // Kopie referenz vom Beta zum  Alpha 
		try {
			a1.foo();	// B 
		} catch (Exception e) {
			e.printStackTrace();
		}   
		
	}

}
