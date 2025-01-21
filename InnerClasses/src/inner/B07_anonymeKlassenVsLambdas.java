package inner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

interface Moveable{
	
	void move();
	
}


public class B07_anonymeKlassenVsLambdas {

	public static void main(String[] args) {
		/*
		 * Lambdas kann NUR ein funktionales Interface implementieren.
		 * Eine anonyme
		 */

		Moveable v1 = () -> {};
		/*
		 * anonyme Klasse kann auch 
		 */
		Moveable v2 = new Moveable() {			
			@Override
			public void move() {
			}
		};
		
		/*
		 * Eine anonyme Klasse kann beliebige Interfaces implementieren
		 */
		
//		Iterator<String> v3 = keine Lambda möglich;
		
		Iterator<String> v4 = new Iterator<String>() {
	
			public String next() {
				return null;
			}
			
			public boolean hasNext() {
				return false;
			}
		}; 
		/*
		 * Eine anonyme Klasse kann ein Klasse erweitern
		 */
		List<Integer> v5 = new ArrayList<Integer>() {  // super();
			
		};
		
		/*
		 * Wenn eine anonyme Klasse eine Klasse erweitert , 
		 * kann der alternativen Knstruktoren einen auswählen
		 */
		Collection<String> tmp = Arrays.asList("mo","di","mi");
		
		List<String> v6 = new ArrayList<String>(tmp) { // super(tmp);
		
		};
		
		System.out.println("v6 : " + tmp);
		
		/*
		 * Eine anonyme Klasse kann nicht nur überschreiben.
		 * Sie kann auch eigene Elemete haben , die aber nur innerhalb
		 * der Klasse gültig sind.
		 */
		
		List<Integer> v7 = new ArrayList<Integer>() {
			// init-Block
			{
				add(12);
				add(13);
				add(14);
				myMethod();
			}
		
			void myMethod() { System.out.println("myMethod called");}
		};
		
//		v7.myMethod();  // cf : myMethod() gibt es nicht im Interface List
		
		/*
		 * Anonyme Klasse hat eigene this-Referenz.
		 * Eine Lambda hat keine eigenen this-Referenz.
		 */
		Runnable v8 =()->{  // viel kompakte als anonyme Klasse
			System.out.println("*** run() der Lambda");
//			getClass();
//			toString();
//			System.out.println("das Objekt hat den Typ :" + this.getClass()); // cf : keine this this in Lamda
		};
		
		Runnable v9 = new Runnable() {
			public void run() {
				System.out.println("*** run() der anonyme Klasse");
				
				getClass(); 
				System.out.println("das Objekt hat den Typ :" + getClass());
				
				toString();
				System.out.println("das Objekt hat den Typ :" + toString());
			}
		};
		v8.run();
		v9.run();
		
		System.out.println("--- nach run-Aufrufen");
		System.out.println("Typ von Lamda-Objekt :" + v8.getClass());
		System.out.println("Typ von Objekt der anonymen Klasse :" + v9.getClass());
		
	}

}
