package arrays;

import java.util.Arrays;

class Kreis{
	int radius;
	
	public String toString() {
		return  "Kreis : R." + radius ; 
	}
}

class Container{
	
	Kreis k0 ;
	Kreis k1 ;
}


public class B07_ArraysMitReferenzen {

	public static void main(String[] args) {

		/*
		 *  Das neue Objekt hat 2 Attribute.
		 *  Beide Attribute bekomment null als Anfanswert.
		 */
		
		Container c1 = new Container();
		System.out.println("c1.k0 : " + c1.k0) ;  // null
		System.out.println("c1.k1 : " + c1.k1) ;  // null
		c1.k1 = new Kreis();
		
		
		/*
		 *  Das neue Kreis[]-Objekt hat 2 Elemente ( und Attribut lenght = 2)
		 *  Beide Elemente bekommen null als Anfangswert.
		 * 
		 */
		Kreis[] a1 = new Kreis[2];
		System.out.println("a1[0] : " + a1[0]); // null 
		System.out.println("a1[1] : " + a1[1]); // null 
		a1[1] = new Kreis();
		
		
		/*
		 * Das neue String[]-Objekt hat 2 Elemente ( und Attribut lenght=2)
		 * Beide Elemente bekomm null als Anfangswert.
		 * 
		 */
		
		String[] a2 = new String[2];
		System.out.println("a1[0] : " + a2[0]); // null 
		System.out.println("a2[1] : " + a2[1]); // null 
		a2[1] = "Moin" ; 
		
		
		/*
		 * Das neue String[]-Objekt hat 2 Elemente ( und Attribut lenght=2).
		 * Beide werden mit Referenzen zu neuen Kreis Objekten initialisiert.
		 * 
		 */
		Kreis[] a3 = {
				new Kreis() , 
				new Kreis(),
		};
		
		/*
		 *  Das neue String[]-Objekt hat 4 Elemente ( und Attribut lenght=4).
		 *  Einige Positionen werden mit Referenzen zu neuen Kreis-Objekten
		 *  initialisiert. Die anderen mit null.
		 */
		
		Kreis[] a4 = {
			null , 			// Nr. 0 
			new Kreis(),	// Nr. 1 
			null ,			// Nr. 2 
			new Kreis()		// Nr. 3 
		};
		System.out.println("a4 " + Arrays.toString(a4));
		
		/*
		 * TEST
		 */
		
		Kreis k1 = new Kreis();
		
		Kreis[] arr = { 
			k1 , k1 , null , k1 , null , k1 	
		};
		System.out.println("1. " + arr[0]); // 1. Kreis : R.0
		
		k1.radius = 12 ;
		System.out.println("2. " + arr[0]); // 2. Kreis : R.12
		System.out.println("3. " + arr[5]); // 3. Kreis : R.12
		
		arr[3].radius = 42; 	// addrese von Objekt Kopieren, dann wird Attribut in Objekt geändert wird.
		System.out.println("4. " + k1);		// 4. Kreis : R.42
		System.out.println("5. " + arr[1]); // 5. Kreis : R.42
	}

}
