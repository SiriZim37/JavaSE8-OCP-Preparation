package reglen;

import static java.lang.Math.PI;
import static java.lang.Math.E;

import static java.lang.Math.random;
import static java.util.Arrays.sort;

public class ImportStaticAnweisung {

	/*
	 * 	- min 'import static' importiert man
	 * 	  Name der statischen Elemente aus einer anderen Klasse 
	 * 	  aus einer anderen Klasse ( oder aus einem Interface)
	 * 
	 * 
	 * 	import static java.util.Arrays.sort;		- importiert sort  
	 * 	import static java.util.Arrays.*;			- importiert alle statische Element  
	 * 	import static java.lang.Math.PI;			
	 * 	import static java.lang.Math.random;		

	 */
	public static void main(String[] args) {

		System.out.println( Math.PI); // normaler Zugriff
		System.out.println( PI );	 // importiert mit import static 
		
		System.out.println(  Math.E );	
		System.out.println( E );	 // importiert mit import static 
		System.out.println(Math.random()); // normaler Aufruf einer statischen Methode
		random(); // importiert mit import static 
		
		int[] arr = { 3 ,1 ,2 ,0 };
		java.util.Arrays.sort(arr); 
		sort(arr);	// ok :  importiert mit import static 
//		Arrays.sort(arr);  // cf   :  Klasse Arras nicht gefunden.
	}

}
