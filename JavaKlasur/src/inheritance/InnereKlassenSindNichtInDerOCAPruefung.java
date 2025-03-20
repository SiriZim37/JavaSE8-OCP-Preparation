package inheritance;

import java.util.function.Predicate;

interface Foo {}


class TopLevelKlasse{
	
}

public class InnereKlassenSindNichtInDerOCAPruefung {

	static class InnereKlasse{
		
	}
	
	public static void main(String[] args) {
		
		new InnereKlasse();
		new InnereKlasse();
		new InnereKlasse();
		
		/*
		 * Eine Toplevel-KLasse instanzieren
		 */
		Object ref1 =  new TopLevelKlasse();
		

		/*
		 *  Einer Innere Klasse instanzieren
		 */
		Object ref2 = new InnereKlasse();
		
		/*
		 *  Einer Innere lokale Klasse instanzieren
		 */
		class InnereLokaleKlasse{
			
		};
		Object ref3 = new InnereLokaleKlasse(); 
		
		
		/*
		 * hier wird eine anonym KLasse definiert und instanziert
		 */
		
		Object ref4 =  new Object() {

		};
		
//		Foo ref5  = new Foo();	// cf instantiating an interface
		
		Foo ref5  = new Foo() { // ok : instantiating an anonymous class.
		
			public String toString() {
				// TODO Auto-generated method stub
				return "test";
			}
		};
		
		/*
		 * Lambda vs anonyme Klasse 
		 */
		
		Predicate<String> p1 = s-> s!= null;
		Predicate<String> p2 = (String s ) ->{
			return s!=null;
		};
		Predicate<String> p3 = new Predicate<String>() {	// ok : instantiating an anonymous class.
			public boolean test(String t) {
				return t != null;
			}
		};
		System.out.println(p1.test("5"));
		
		
	}

}
