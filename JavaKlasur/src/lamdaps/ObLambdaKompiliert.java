package lamdaps;

import java.util.function.Predicate;

interface MyFuntion{
	byte exec(String p1);
}

interface MyFuntionB{
	byte exec(int p1 , int p2);
}

interface MyFuntionC{
	boolean exec(int p1 , int p2);
}

public class ObLambdaKompiliert {

	public static void main(String[] args) {
		
		
		/*
		 * 1. Lambdas funktionieren nut im Kontext einer Zuweisung.
		 * 
		 * 		Also : Zuweisung suchen
		 * 
		 * 2. Lambdas funktionieren nur für funktionale Interfaces
		 * 
		 * 		Also : den Typ links (bei der Zuweisung) ermitteln.
		 * 
		 * 3. Lambda ist die Realisiereung der abstrakten Methode 
		 * 
		 * 		Also : überprüfen ob Parameterliste und Rückgabetyp  passen
		 */
		
		/*
		 * Explizite Zuweisung
		 */
		MyFuntion a ;
		a = x -> 2+3 ; 
		System.out.println( a.exec("5") );
		/*
		 * Implizite Zuweisung beim Übergeben des Argumentes
		 */
		
		m1(x-> 2);
		/*
		 * Implizite Zuweisung bei der return-Anweisung
		 */

		// test 2 params
		MyFuntionB b;
		b = (x , y) -> (byte)(x+y);
		System.out.println(b.exec(5, 8));
		
		// test 2 params
		MyFuntionC c;
		c = (x , y) -> ( x > y );
		System.out.println(c.exec(5, 8));
		
		// test 2 params
		Predicate<Integer> p1 = x -> (x > 8);
	    System.out.println(p1.test(10));
	 // test 2 params
	 	Predicate p2 = x -> ((int)x > 8);
	    System.out.println(p2.test(5));

	}
	static void m1(MyFuntion param) {
		
	}
	
	static MyFuntion m2() {
		return x -> 2 ; // MyFuntion annonymous
	}

}
