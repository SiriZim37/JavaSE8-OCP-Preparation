package aufgaben.sort;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Aufgabe :  
 *   Erzeugen Sie ein Arrays mit Strings. 
 *   Sortieren Sie die Strings nach Länge (Anzahl der Zeichen). 
 *   Strings der gleichen Länge sollen lexikografisch sortiert werden.
 */

//Custom Comparator for sorting
class CustomSortComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		int result;
//		if (s1.length() < s2.length()) {
//		    result = -1;
//		} else if (s1.length() > s2.length()) {
//		    result = 1;
//		} else {
//		    result = 0;
//		}
		
		 //Zuerst nach Länge sortieren (aufsteigend)
        result = Integer.compare(s1.length(), s2.length());
		if(result != 0 ) {
			return result ; 
			
		}
		// Bei gleicher Länge lexikografisch sortieren
		return s1.compareTo(s2);
	}
	
}

// Optional Reverse
class CustomSortReverseComparator implements Comparator<String> {	
	@Override
	public int compare(String s1, String s2) {
	    int result = Integer.compare(s2.length(), s1.length());
	    if (result != 0) {
	        return result; 
	    }
	    return s2.compareTo(s1); 
	}
	

    
}


public class StringsSortTest {
	
	public static void main(String[] args) {
		
	    String[] arr = { 
	            "Apfel", "Banane", "Kirsche", "Drachenfrucht", 
	            "Ananas", "Pfirsich", "Birne", "Melone"
	        };
		
	    // Print original array
        System.out.println("** Array ausgeben:");
		print(arr);
		
		
	     // Array sortieren
        System.out.println("\n*** Array sortiert nach Länge und lexikografisch:");
        Arrays.sort(arr, new CustomSortComparator());
        print(arr);
        
        // Array absteigend sortieren
        System.out.println("\n*** Array sortiert nach Länge und lexikografisch (absteigend):");
        Arrays.sort(arr, new CustomSortReverseComparator());
        print(arr);
        
        // Mit Lambda
        System.out.println("\n*** Array sortiert mit lambdas:");
        Comparator<String> cmp = (s1,s2) -> {
        	int res = s1.length() - s2.length();
        	if(res!=0) {
        		res = s1.compareTo(s2);
        	}
        	return res;
        };
        
        Arrays.sort(arr, cmp);
		
		
	}
	
	static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + ". " + arr[i]);
        }
    }

}
