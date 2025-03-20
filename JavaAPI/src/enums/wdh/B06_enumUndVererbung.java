package enums.wdh;

import java.util.function.Predicate;

enum MyEnumA {}
//enum MyEnumB extends Enum{}	// cf
//enum MyEnumC extends Object{} 	// cf

//class MyClassA extends MyEnumA{}	// cf : The type MyEnumA cannot be the superclass of MyClassA; a superclass must be a class

enum MyEnumD implements Predicate<Integer> , Runnable{
	
	A, B , C;

	public void run() {}
	public boolean test(Integer t) {return false;} 
}


public class B06_enumUndVererbung {
	/*
	 * 	- enum-Klasse erbt immer von der KLasse java.lang.Enum,
	 *    aber  man darf es nicht explizit angeben
	 *   
	 *  - enum-Klasse erbt implizit von der KLasse java.lang.Enum ,
	 *    aber man darf es nicht explizit angeben
	 *  
	 *  - enum-KLasse darf nicht erweitert werden. 
	 *    Ausnahme : eine spezielle Art einer annonymen Klasse 
	 *    innerhalb der enum KLasse (s. Bsp. 07)
	 *  
	 *  - enum Klasse darf beliebig viele Interfaces implementieren
	 */
	public static void main(String[] args) {
		
		/*********** Code */
	}

}
