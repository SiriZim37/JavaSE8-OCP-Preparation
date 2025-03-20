package interfaces;

import java.util.ArrayList;

interface I1{
	// abstrakte Instanz-Methode 
	void m1();	 
	
	// konkrete Instanz-Methode
	default void m2() { System.out.println("m2 aus I2");} 	
	
//	default void m3() ;  // cf : default-Methode braucht den Rümpf(body) !!! !
	
}

//**** default void m2() {}  kann erben oder überschreiben wie in den Klassen CA und CB
class CA implements I1{
	public void m1() {}	 // muss abstrakte Methode realisieren.
	
	// CA erbt die Methode m2() aus dem Interface I1 
}

class CB implements I1{
	public void m1() {}	 // CB muss abstrakte Methode realisieren.
	public void m2() { System.out.println("m2 aus CB");}	 // CB darf geerbte Methode überschreiben.
}

public class B04_default {

	public static void main(String[] args) {
		
		Iterable<Integer> it = new ArrayList<>();
		
		// Bsp. aus Praxis
		// forEach ist im Interface Iterable bereits
		// als default-Methode realisiert 
		// ( wird aber oft von implemenierenden Klassen überschreiben)
		
		it.forEach( x -> System.out.println(x));
		I1 v1 = new CA();
		v1.m1();
		v1.m2();
	}
}
