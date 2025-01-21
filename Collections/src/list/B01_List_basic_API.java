package list;

import java.util.ArrayList;
import java.util.List;

public class B01_List_basic_API {

	public static void main(String[] args) {
		/*
		 * Alle methoden , die Collection deklariert
		 * 
		 * add(E e) : boolean
		 * size() : int
		 * clear() : void
		 * ...
		 */
		
		List<String> list = new ArrayList<>();
		list.add("mo");
		list.add("mi");
		list.add("fr");
		
		System.out.println("1. list : " + list);  // [mo, mi, fr]
		
		/*
		 * Spezielle index-Methoden
		 /
		 
		 /*
		 * add(int index , E e )
		 * 				0   1   2
		 * 		vorher [mo, mi, fr]
		 * 
		 * 				0   1   2   3
		 * 		nacher [mo, di ,mi, fr]
		 * 
		 * 				0   1   2   3	 4
		 * 		nacher [mo, di ,mi, fr , so]
		 */
		
		int index = 1 ; 
		list.add(index , "di");
		System.out.println("2. list : " + list); 		 		// [mo, di, mi, fr]
		
		index = 4 ; 
		list.add(index , "so");  
		System.out.println("3. list : " + list); 		 		// [mo, di, mi, fr, so]
		
//		index = 6 ; 
//		list.add(index , "so");  // IndexOutOfBoundsException (RuntimeException)
//		System.out.println("4. list : " + list);  		
		
		
		/*
		 * set(int index , E e ) : E   (return oldvalue)
		 * 
		 * 				0   1   2   3	 4
		 * 		vorher [mo, di ,mi, fr , so]
		 * 
		 * 				0   1   2  		  	3	    4
		 * 		nacher [mo, di ,MITTWOCH, FREITAG , so]
		 */
		
		index = 2 ;
		String oldValue = list.set(index, "MITTWOCH");			// = mi
		System.out.println("oldValue = " + oldValue);
		System.out.println("5. list : " + list); 				//[mo, di, MITTWOCH, fr, so]
		
		index = 3 ;
		oldValue = list.set(index, "FREITAG");
		System.out.println("oldValue = " + oldValue);			//fr
		System.out.println("6. list : " + list); 				//[mo, di, MITTWOCH, FREITAG, so]
		
		/*
		 * get(int index ) : E     (return value Element)
		 * 
		 * 				0   1   2  		 	 3	    4
		 * 		vorher [mo, di ,MITTWOCH, FREITAG , so]
		 * 
		 */
		
		index = 2 ;
		String value = list.get(index);	
		System.out.println("list.get(index) = " + value);		// MITTWOCH
		System.out.println("7. list : " + list); 				//[mo, di, MITTWOCH, FREITAG, so]
		
		
		/*
		 * remove(int index ) : E     (return value Element)
		 * 
		 * 				0   1   2  		  3	    	 4
		 * 		vorher [mo, di ,MITTWOCH, FREITAG , so]
		 * 
		 * 				0   1   2  		   3	    	 
		 * 		nacher [mo, di ,MITTWOCH , so]
		 */
		
		index = 3 ;
		value = list.remove(index);	
		System.out.println("list.remove(index) = " + value);	// FREITAG
		System.out.println("8. list : " + list); 				//[mo, di, MITTWOCH, so]
		
		
		/*
		 * indexOf(Object o) : int
		 * lastIndexOf(Object o) : int
		 * 
		 * liefern -1 , wenn das Element nicht gefunden
		 */
		index = list.indexOf("MITTWOCH");	
		System.out.println("list.indexOf(\"MITTWOCH\") = " + index);	// 2
		
		index = list.indexOf("fr");	
		System.out.println("list.indexOf(\"fr\") = " + index);			// -1
		

		index = list.lastIndexOf("di");	
		System.out.println("list.lastIndexOf(\"di\") = " + index);	// 1
	

		/*
		 * subList wird im nächsten Bsp. gezeigt
		 */
		
		/*
		 * weitere Methoden werden im Projekt 'Functional' 
		 * im Package 'collections' gezeigt
		 */
	}

}
