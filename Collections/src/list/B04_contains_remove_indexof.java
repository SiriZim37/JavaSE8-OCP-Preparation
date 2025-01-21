package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Blume{
	
	int preis ;
	
	public Blume(int preis ) {
		this.preis = preis;
	}
	
	public String toString() {
		return "Blume (" + preis + ")";
	}
	
	public boolean equals(Object obj) {
		if( !(obj instanceof Blume)) {
			return false;
		}
		
		Blume b2 = (Blume)obj;
		return preis == b2.preis;
	}
	
}

public class B04_contains_remove_indexof {


	/*
	 * interface Collection
	 * 
	 * 	- boolean add(E e)
	 * 	- boolean remove (Object e)
	 * 	- boolean contains (Object e)
	 * 
	 * -  int size()
	 * -  boolean isEmpty()
	 * 
	 * - void clear()
	 * 
	 */
	
	/*
	 *  Achtung ! 
	 *  
	 *  die contains , remove , indexof und lastindexof
	 *  benutzen fürs Vergleichen die equals-Methode
	 *  der gespeicherten Elemente
	 */
	
	public static void main(String[] args) {
		
		test_mit_String();
		test_mit_Blumen();
		
		
	}

	
	static void test_mit_Blumen() {
		System.out.println("\n***Test mit Blumen");
		List<Blume> listBlumen = new ArrayList<Blume>();
		listBlumen.add(new Blume(120));
		listBlumen.add(new Blume(90));
		listBlumen.add(new Blume(200));
		
		Blume key = new Blume(90);
		
		boolean result = listBlumen.contains(key);
		System.out.println("1. contains result : " + result);   // false  
																// nachdem equals(Object obj) implementiert dann true
		
		result = listBlumen.remove(key);
		System.out.println("2. remove result : " + result); // false
															// nachdem equals(Object obj) implementiert dann true
			
		/*
		 * ohne methode public boolean equals(Object obj) 
		 * 	vorher		[Blume (120), Blume (90), Blume (200)]
		 * 
		 * nacher : 	[Blume (120), Blume (200)]
		 */
		System.out.println("b. listBlumen : " + listBlumen);  
		
		key = new Blume(200);
	
		int index = listBlumen.indexOf(key);
		System.out.println("indexOf(key) : " + index); 	// -1
														// nachdem equals(Object obj) implementiert dann 1

		/*
		 * 	vorher		[Blume (120), Blume (200)]
		 * 
		 *  nacher : 	[Blume (120)]
		 */
		result = listBlumen.remove(key);
		System.out.println("2. remove result : " + result); // true
		System.out.println("c. listBlumen : " + listBlumen);  
		
		
	}
	
	static void test_mit_String() {
		System.out.println("*** Test mit Strings");
		
		List<String> listStr = Arrays.asList("mo" , "di" , "mi"); // Liste mit fixierten Größe
		
		listStr = new LinkedList<String>(listStr);	 // normale Liste 
													 // สร้าง LinkedList ใหม่ที่มีค่าเริ่มต้นจากรายการ `listStr` 
													 // เพื่อให้สามารถปรับเปลี่ยนได้ (เพิ่มหรือลบได้)
		
		String key = "Freitag";
		
		// Bsp. 1
		boolean result = listStr.contains(key);
		System.out.println("1. result : " + result); 		// false
		
		// Bsp. 2
		result = listStr.remove(key);
		System.out.println("2. result : " + result); 		// false
		
		// Bsp. 2.2
		key = "mo";
		try {
			result = listStr.remove(key); 					// cant change size
		} catch (UnsupportedOperationException e) {
			System.out.println("UnsupportedOperationException");
		}
//		System.out.println("2.2. listStr : " + listStr); 
		// Bsp. 3
		key = "di";
		result = listStr.remove(key);
		System.out.println("3. result : " + result); 		// true
		
		System.out.println("listStr : " + listStr); 		// [mo, mi]
		
		// Bsp. 3.2
		key = new String("mi") ;  //  new String Object  
		result = listStr.remove(key);
		System.out.println("3.2. result : " + result); 		// true  ( Vergleich inhalt vom Object )
				
		
		System.out.println("4. listStr : " + listStr); 		// [mo]
		
		listStr.add("mi");
		// Bsp. 4
		key = "MI".toLowerCase(); //  new String Object
		int index = listStr.indexOf(key);
		System.out.println("4. index : " + index); 		// -1    ( Vergleich inhalt vom Object )
		
		key = new  String("mi");  //  new String Object
		index = listStr.indexOf(key);
		System.out.println("4. index : " + index); 		// -1     ( Vergleich inhalt vom Object )
		
	}

}
