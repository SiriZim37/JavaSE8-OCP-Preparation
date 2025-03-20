package exam.p2;

import exam.p1.*; // ok 

/*	Die Klasse hat einen Compilerfehler : 


class Rose extends Blume{ // ok : class Rose extends exam.p1.Blume{
	
	// der generierte default-KOnstruktor
	//
	//	Rose() {
	//		super(); // cf : Konstruktor der Basisklasse ist hier nicht sichtbar
	//	} 

}
*/

public class TestBlume {

	/*
	 * Actung ! 
	 * 
	 * Immer an Konstruktoren denken! 
	 * Immer super-Aufrufe (auch im default-Konstruktor) überprüfen.
	 */
	
	public static void main(String[] args) {
		Blume b1 ; 
	}

}
