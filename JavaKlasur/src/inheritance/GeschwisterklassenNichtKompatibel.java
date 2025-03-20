package inheritance;

class Cat{}
class Dog{}

interface Tankbar{}
interface Steuerbar{}

class Fox implements Tankbar{ }

public class GeschwisterklassenNichtKompatibel {

	public static void main(String[] args) {

		Cat c = null;
		Dog d = null;
		
//		c = d // cf : Cat <- IST-KEIN <- Dog
//		d = c ;
		
		/*
		 * Casting kompiliert nicht 
		 */
		
//		c = (Cat)d ; 
//		d = (Dog)c ; 
		
		Object o = new String("Hello");
		System.out.println(o instanceof Object);	// true
		System.out.println("f1:" + ( o instanceof Tankbar)); // false
		Dog ff = new Dog();
		System.out.println("f2:" + ( ff instanceof Tankbar)); // false
		/*
		 * Aber interface geht
		 */
		Tankbar t = null ; 
		Steuerbar s = null;
		
//		t = s ;  Tankbar <- IST-KEIN <- Steuerbar
//		s = t ;  Steuerbar <- IST-KEIN <- Tankbar


		System.out.println(t instanceof Steuerbar);	 // false
		System.out.println(s instanceof Tankbar);     // false
		
		/*
		 * Casting funktioniert
		 */
		t = (Tankbar)s ;
		s = (Steuerbar)t ;

		Fox f = new Fox();
		System.out.println(f instanceof Tankbar);      // true
		System.out.println(f instanceof Steuerbar);   //  false
	}

}
