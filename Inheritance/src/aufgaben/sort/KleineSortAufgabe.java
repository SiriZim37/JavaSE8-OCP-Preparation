package aufgaben.sort;

import java.util.Arrays;
import java.util.Comparator;

// DescendingComparator
class StringReverseComparator implements Comparator<String> {	
	@Override
	public int compare(String s1, String s2) {
		return s2.compareTo(s1); // Sort in descending order
	}
}

public class KleineSortAufgabe {

	public static void main(String[] args) {
		
		String[] arr = {
				"gg" , "dd" , "bb", "rr","ii"
		};

		/*
		1. Array ausgeben
		2. Array aufsteigenden sortieren
		3. Array ausgeben
		4. Array absteigend sortieren
		5. Array ausgeben
		*/
		
		 // 1. Original
        System.out.println("Array ausgeben:");
        print(arr);

        // 2.  Array aufsteigenden sortieren
        Arrays.sort(arr);
        System.out.println("\nArray aufsteigend:");
        print(arr);

        // 4. Array absteigend sortieren
        System.out.println("\nArray absteigend:");
		Comparator<String> cmp = new StringReverseComparator();
		Arrays.sort(arr, cmp);
		print(arr);
		
        System.out.println("\nArray absteigend: Lambda Expression (Optional):");
		Arrays.sort(arr, (s1, s2) -> s2.compareTo(s1));
		print(arr);

	}
	
    static void print(String[] arr) {
    	for(int i = 0 ; i < arr.length ; i++) {
			System.out.println( i + ". "+  arr[i]);
		}
    }
	
	

}
