package wdh.compare;

import java.sql.Array;
import java.util.Arrays;

public class InterfaceComparable {

	public static void main(String[] args) {
		
		/*
		 * 
		 * Wenn eine Klasse Comparable realisiert , 
		 * wird die compareTo-methode den für 
		 * die Klasse 'natürlichen Vergleich implementieren
		 */
		Comparable<String> c1 = "mo";
		
		int result =  c1.compareTo("di");
		
		if(result < 0) {
			System.out.println("mo ist kleiner als di");
		}else if(result > 0 ) {
			System.out.println("mo ist größer als di"); // Ausgabe : mo ist größer als di
		}else {
			System.out.println("mo und di sind gleich");
		}
		
		/*
		 * Die Standard-Sortierung verwendet den 'natürlichen Vergleich
		 */
		
		String[] arr = {
				"mo","di","mi","do","fr"
		};
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));	// [di, do, fr, mi, mo]
		

	}

}
