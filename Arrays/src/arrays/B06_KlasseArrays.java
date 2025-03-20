package arrays;

import java.util.Arrays;

public class B06_KlasseArrays {

	public static void main(java.lang.String[] args) {  // java.lang. ist immer initialisieren!!
		/*
		 *  Die Klasse java.util.Arrays hat viele statische 
		 *  Hilfsmethoden , um mit Arrays zu arbeiten.
		 */
		int[] arr = { 12,13,14,15};
		
		// oder java.util.Arrays
		String arrAsText = Arrays.toString(arr); // statische Hilsfmethode toString
		
		System.out.println(arrAsText); // [12, 13, 14, 15]

	}

}
