package generics;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B02_Typsicherheit {

	public static void main(String[] args) {
		/*
		 * Generics garantieren nur die Typsicherheit
		 */
		
		// nach dem Erzeugen des neuen Objektes nach der
		// Zuweisung in die Referenz wird garantiert , 
		// dass in der ArrayList nur Integer-Elemente gespeichert werden.
		
		List<Integer> listInt = new ArrayList<Integer>();

		
		// Der Compiler kontrolloert die Arbeit.
		listInt.add(12); 	// Integer param = 12 - ok : Integer <- IS-> <- Integer
//		listInt.add(false); //  Integer <- IS-> <- boolean
		
		
		Integer value = listInt.get(0);
		
		/*
		 * Der Compilier kontrolliert die Zuweisung 
		 * mit der parameterisierten Referenz : 
		 */
		List<Boolean> listBool =  new ArrayList<>();
//		listBool = listInt;		// cf : Parameterisierung sind nicht gleich .
								// Dadurch kann falses Element
								// in dem von listInt refrenzierten Objekt gespeichert werden
		
		listBool.add(false); 	// Autoboxing boolean referenz ( Boolean.valueOf(false) )
		
		
		/*
		 * Achtung! Wenn man nicht  parameteretrisiert
		 *  , gibt es keine Typischerheit mehr!!
		 *  
		 *  Bitte immer parametreisieren
		 * 
		 */
		
		List list = listInt;		// Schlect !
		list.add(false);
		list.add(5.5);
		list.add(2.0f);
		list.add(LocalDate.now());
		
		System.out.println(listInt);   	// [12, false, 5.5, 2.0, 2024-10-11]
 		
		Arrays.sort(args);

	}

}
