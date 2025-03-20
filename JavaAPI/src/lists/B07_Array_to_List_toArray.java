package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.Predicate;


/*
 * 	Warum sollte die Klasse , von der die Elemente in einer List gespeichert werden , die equals-Methode sinnvoll überschreiben
 * 
 * - Arrays.asList Hat die Liste fixierte Grüße ? (Bitte testen)
 * 
 */
public class B07_Array_to_List_toArray {

	public static void main(String[] args) {

		test_Arrays_asList();
		test_List_toArray();
	}
	
	static void test_Arrays_asList() {
		
		
		
		List<Integer> listA = new ArrayList<Integer>();
		listA.add(12);
		listA.add(13);
		listA.add(14);
		listA.add(15);
		
		System.out.println("1. listA : " + listA);	// [12, 13, 14, 15]
		/*
		 * static <T> List<T> asList(T... a) 
		 */
		System.out.println("*** Arrays.asList");

		List<Integer> listB =	Arrays.asList(12,13,14,15);
		System.out.println("2. listB : " + listB);	// [12, 13, 14, 15]

		/*
		 * 	Actung!!!!!!!!!  
		 * 	 Die asList-Methide erzeugt eine besondere Liste!
		 * 
		 *   Diese Liste kann ihre 'Größe' nicht ändern!!!
		 */
		listB.set(1, -123);		//ok [12, -123, 14, 15] (Ersetzen)
		
		System.out.println("2. listB : " + listB);
		System.out.println("2.1 " + listB.contains(-123));
		
		try {
			listB.remove(0);
			System.out.println("2.2 " + listB);
			listB.add(16);	// Exception! Liste hat fixierte Größe
		} catch (Exception e) {
			System.out.println("Fehler! Die liste hat konstante Größe!");
			System.out.println(e.getMessage());
		}
		/*
		 * 	Entkoppeln :  Arrays.asList muss in einer neue normale ArrayList koppiert.
		 */
		
		List<Integer> listInt = new ArrayList<Integer>(Arrays.asList(5 , 6 , 7 )) ;
		listInt.add(8);		// ok
		
		
		/*
		 * 	Unwarhscheinlich in der Prüfung: 
		 *  Diese Liste ist an das übergebene Array gekoppelt.!!!!!!!!!!!!! 
		 */
		String[] arrStr = { "mo" , "di" , "mi" , "do"};
		
		List<String> listStr = Arrays.asList(arrStr);	// [mo, di, mi, do]
		
		System.out.println("1. arrStr : " + Arrays.toString(arrStr));	// [mo, di, mi, do]
		System.out.println("1. listStr : " + listStr);
		
		arrStr[1] = "Dienstag";
		
		System.out.println("2. arrStr : " + Arrays.toString(arrStr));// [mo, Dienstag, mi, do]
		System.out.println("2. listStr : " + listStr);				 // [mo, Dienstag, mi, do]
		
		listStr.set(3, "DO");

		System.out.println("3. arrStr : " + Arrays.toString(arrStr)); //  [mo, Dienstag, mi, DO]
		System.out.println("3. listStr : " + listStr);				  // [mo, Dienstag, mi, DO]

	}
	
	static void test_List_toArray() {
		System.out.println("\n*** Methode toArray aus List");
		
		
		List<Integer> listInt = new ArrayList<Integer>(Arrays.asList( 12 , 13 , 14 , 15 ));
		System.out.println("listStr : " + listInt);		// [12, 13, 14, 15]
		
		/*
		 * Object[] toArray()
		 */
		Object[] arr1 = listInt.toArray();
		
		System.out.println("Klasse von arr1 : " + arr1.getClass().getSimpleName()); //  Object[]
		
		System.out.println("1. arr1 = " + Arrays.toString(arr1));	//  [12, 13, 14, 15]
		arr1[1] = "Montag";
		arr1[3] = "0.3";
		System.out.println("2. arr1 = " + Arrays.toString(arr1));	// [12, Montag, 14, Montag]
		
		/*
		 * <T> T[] toArray(T[] a);
		 * 
		 * Example: If listInt has 4 elements, toArray will allocate a new array of size 4 (Integer[4])
		 *  and return it.
		 */
		
		 // Convert List<Integer> to Integer[]
		Integer[] arr2 = listInt.toArray(new Integer[0]);
		
		System.out.println("Klasse von arr2 : " + arr2.getClass().getSimpleName());	// Integer[]
		
		System.out.println("3. arr2 = " + Arrays.toString(arr2));	// [12, 13, 14, 15]
		
		Integer[] arr3 = listInt.toArray(new Integer[10]);
		System.out.println("4. arr3 = " + Arrays.toString(arr3));	// [12, 13, 14, 15, null, null, null, null, null, null]
		
		/*
		 * 
		 */
		IntFunction<Integer[]> generator = size -> new Integer[size];
		
//		Integer[] arr4 = listInt.toArray(generator); // es geht in Java 8 nicht aber in Java21 ( pakage lists -> TestNeueToArray)
		
	}

}
