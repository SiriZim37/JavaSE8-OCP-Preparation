package interfaces;

import java.util.Arrays;

public class B08_StringsVergleichenUndSortieren {

	public static void main(String[] args) {
	
		String s1 = "aa";
		String s2 = "aa";
		
		int result = s1.compareTo(s2);
		System.out.println("aa und aa. result =" + result);    // 0 

		/*
		 * 	compareTo der Klasse vergleicht
		 * einzelne Zeichen an den ensprechenden Positionen.
		 * 
		 * Falls die Zeichen sich unterscheiden,liefert
		 * die compareTo die Differenz ( Zeichen aus einem String
		 * minus Zeichen aus dem anderen)
		 * 
		 * Falls keine Unterscheiden gefunden wurden , 
		 * lefert compareTo die Längendifferenz zurück
		 * 
		 */
		
		 s1 = "aa";
		 s2 = "ab";
		
		 result = s1.compareTo(s2);
		 System.out.println("aa und aa. result =" + result);    // -1
		 
		 s1 = "aa";
		 s2 = "ad";
		
		 result = s1.compareTo(s2);
		 System.out.println("aa und ad. result =" + result);	// -3
		 		
		 result = s2.compareTo(s1);
		 System.out.println("ad und aa. result =" + result);	// 3
		 
		 s1 = "aaa";
		 s2 = "aaabb";
		 
		 result = s1.compareTo(s2);
		 System.out.println("aaa und aaabb. result =" + result); // -2
		 
		 result = s2.compareTo(s1);
		 System.out.println("aaabb und aaa. result =" + result); // 2
		 
		 /*
		  * Achtung ! 
		  * 
		  * Englishe Großbuchstaben stehen in der Unicode-Tabelle
		  * vor den englischen Kleibuchstaben !! 
		  * 
		  * A B C ..... a b c 
		  * 
		  */
		 s1 = "ABC";
		 s2 = "abc";
		 
		 result = s1.compareTo(s2);	 // A steht vor a 
		 System.out.println("ABC und abc. result =" + result);	// -negativ
		 
		 
		 
		 String[] arr = {	
				 "aa" , "BB" , " AA" , "bb"
		 };
		 // Es gibt kein ClassCastException:
		 // String compare to andere Striing , können einface String elelmente taschen. 
		 System.out.println("Vorher : " + Arrays.toString(arr));  //[aa, BB,  AA, bb]
		 Arrays.sort(arr);
		 System.out.println("Nacher : " + Arrays.toString(arr)); // [ AA, BB, aa, bb]
		 
		 
	}

}
