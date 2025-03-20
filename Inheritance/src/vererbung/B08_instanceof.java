package vererbung;

import java.net.InterfaceAddress;

class A {
	
}

class B extends A{
	
}

class C extends B{
	
}



public class B08_instanceof {

	public static void main(String[] args) {

		/*
		 * - Der instanceof-Operator sucht das Objekt ,
		 * 	 das von der Referenz links referenziert wird.
		 * 
		 * - Wenn die Referenz null ist , liefert der Operator false zurück.
		 * 
		 * - wenn die Referenz ein Objekt referenziert , ermittelt der 
		 * 	 instanceof die Klasse des Onjektes
		 * 
		 * - instanceof überprüft, ob die klasse des Objektes mit
		 *   dem Typ rechts eine IS-A-Beziehung hat
		 *   
		 *   -----------------------------------
		 *   
		 *   instanceof kompiliert bei klassen nur wenn sie keine Geschwisterklassen sind 
		 *   (zeil:  result = ref instanceof String; // cf  )
		 * 
		 */
		Object obj1 = "moin";
		
		if(obj1 instanceof String) {
			System.out.println("obj referenziert ein String");	// obj referenziert ein String
		}else {
			System.out.println("obj referenziert kein String");
		}
		
		String str = "s";
		System.out.println("str instanceof Object : " + (str instanceof Object));	// true
		String str2 = null;
		System.out.println("str instanceof Object : " + (str2 instanceof Object));	// false
		
		
		Object obj2 = null;
		System.out.println(obj2 instanceof String);	// false
		if(obj2 instanceof String) {
			System.out.println("obj referenziert ein String");
		}else {
			System.out.println("obj referenziert kein String");	// obj referenziert kein String
		}

		Object obj = null;
		boolean result = obj instanceof Object;
		System.out.println("null instance of :"+ result);	// false
		
		A ref = new C();
//		result = ref instanceof String; // cf : A und String sind Geschwisterklassen
		
		result = ref instanceof Object;
		System.out.println("0. ref A instance of Object :"+ result); // true
		result = ref instanceof A;
		System.out.println("1. ref A instance of A :"+ result); // true
		result = ref instanceof B;
		System.out.println("2. ref A instance of B :"+ result); // true
		result = ref instanceof C;
		System.out.println("3. ref A instance of C :"+ result); // true
		// jeden Objekt IS-A-Object
		
	}

}
