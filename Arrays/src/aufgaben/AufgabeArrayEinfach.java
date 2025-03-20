package aufgaben;

import java.util.Arrays;
import java.util.Random;

public class AufgabeArrayEinfach {

	public static void main(String[] args) {
		

		//A1 // A2
		System.out.println("## A1 A2 ##");
		int[] arr = createArray(2, 15, 30);
				
		printArray(arr);
	
		//A3
		System.out.println("## A3 ##");
		char[] umlaute = deutscheUmlaute();
		String unlauteStr = Arrays.toString(umlaute);
		System.out.println(unlauteStr);
		
		//A4
		System.out.println("## A4 ##");
		char[] buchstaben =   deutschBuchstaben();
		printArray(buchstaben);
		char[] buchstaben2 =   deutschBuchstaben2();
		printArray(buchstaben2);
		
		//A5
		System.out.println("## A5 ##");
		double[] konstante = {Math.PI, Math.E};
		String mathArr = Arrays.toString(konstante);
		System.out.println(mathArr);
		
		
		// A6: add
		System.out.println("## A6 ##");
		 int[] a1 = {1, 2, 3};
		 int[] a2 = {12, 13, 14};
		 int[] addResult = add(a1, a2);  // a3 bekommt folgende Werte: 13, 15, 17 
		 printArray(a1);
		 System.out.println(" + ");
		 printArray(a2);
		 System.out.println(" = ");
		 printArray(addResult);
		
		 // Test diff length
		 System.out.println("## A6 Test diff lenght ##");
		 a1 = new int[] {1, 2, 3 , 4, 5 };
		 a2 = new int[] {12, 13, 14 };
		 addResult = add(a1, a2);  // a3 bekommt folgende Werte: 13, 15, 17 
		 printArray(a1);
		 System.out.println(" + ");
		 printArray(a2);
		 System.out.println(" = ");
		 printArray(addResult);
		 
		 
		 
		 //A7 join 
		 System.out.println("## A7 ##");
		 int[] a3 = join(a1, a2); // a3 bekommt folgende Werte: 1, 2, 3, 12, 13, 14
		 printArray(a3);
	}
	
	
	// A1 
	static int[] createArray(int min ,int max ,int length) {
		
		int[] a = new int[length];
		for(int i = 0 ; i< length ; i++ ) {
			Random rnd = new Random();
			a[i] = rnd.nextInt((max - min) + 1) + min;		
		}
		return a;
	}
	
	// A2
	static void printArray(int[] arr) {
		System.out.print("[");
		for( int i = 0 ; i< arr.length ; i++) {
			System.out.print( arr[i]);
			if(i < arr.length-1)
				System.out.print( ", ");	
		}
		System.out.println("]");
	}
	
	static void printArray(char[] arr) {
		System.out.print("[");
		for( int i = 0 ; i< arr.length ; i++) {
			System.out.print( arr[i]);
			if(i < arr.length-1)
				System.out.print( ", ");	
		}
		System.out.println("]");
	}
   
	static void printArray(double[] arr) {
		System.out.print("[");
		for( int i = 0 ; i< arr.length ; i++) {
			System.out.print( arr[i]);
			if(i < arr.length-1)
				System.out.print( ", ");	
		}
		System.out.println("]");
	}

	
	// A3
	static char[] deutscheUmlaute() {
		return new char[] {'ä' ,'ö','ü'};
	}
	
	// A4
	static char[] deutschBuchstaben2() {
		int len = 'z' + 'a' + 1 ; // Anzahl der englische Buchstabe // 26
		len +=4 ; // 'ä' ,'ö','ü ,ß
		
		char[] arr  = new char[len]; 
		
		char[] result  = new char[30];
		
		int i  = 0 ; 
		for (char ch = 'a' ; ch <= 'z' ; ch++ ) {
			arr[i++] = ch; 
		}
		arr[i++] = 'ä';
		arr[i++] = 'ö';
		arr[i++] = 'ü';
		arr[i++] = 'ß';

		return arr;
	}
	static char[] deutschBuchstaben() {
	
		char[] umlaute = deutscheUmlaute();
		char[] buchstaben  = new char[26]; 
		char[] special  = new char[] {'ß'}; 
		char[] result  = new char[30]; // All buchstabe 
		
		for (int i = 0; i < 26; i++) {
		      buchstaben[i] = (char) ('a' + i); 
		}
			
		// Test join char 		
		result  = join(buchstaben,umlaute);
		result  = join(result,special);
		
		return result;
		
	}
	
	
	//A6 
	/**
	 * Addiert die entsprechende Elemente der beiden Übergebenen Arrays und liefert 
	 * in einemr neuen Array zurück
	 * 
	 * Falls die übergebenen Arrays unterschiedlich lang sind , wird das Ergebnis-Array
	 * die Länge des größeren Arrays bekommen und übernimmt einfach die Elemente des größeren
	 * Arrays für die Positionen , wo keine Addition möglich ist.
	 * 
	 * 
	 * @param a1
	 * @param a2
	 * @return
	 */
	static int[] add(int[] a1, int[] a2) {
		int l1 = a1.length;
		int l2 = a2.length;
		int maxLength = Math.max(l1, l2);  // 1 Alternative 

	    int[] result = new int[maxLength];

	    for (int i = 0; i < maxLength; i++) {
	        if(i < l1 && i < l2)
	        	result[i] = a1[i] + a2[i];
	        else if ( i < l1)
	        	result[i] = a1[i];
	        else 
	        	result[i] = a2[i];
	    }

	    return result;
	}
	
	static int[] add2(int[] a1, int[] a2) { // von Dozent
		int len1 = a1.length;
		int len2 = a2.length;
		int maxLength = len1 > len2 ? len1 : len2 ; // 2 Alternative 
		int minLength = len1 < len2 ? len1 : len2 ; // 2 Alternative 

	    int[] result = new int[maxLength];

	    
	    for(int i = 0 ; i <  minLength ; i++) {
	    	result[i] = a1[i] + a2[i];
	    }
	    
	 // die restlichen Elemente aus dem längeren Array übernehmen
	    int[] maxArr = len1>len2 ? a1 : a2 ;
	    for(int i = minLength ; i < maxLength ; i++) {
	    	result[i] = maxArr[i];
	    }
	    
	  

	    return result;
	}

	
	// A7 
	static int[] join(int[] a1, int[] a2) {
		
		int sumLength = (a1.length+a2.length) ;
		int[] result = new int[sumLength];
		
		for(int i = 0 ; i < a1.length ; i++) {
			result[i] = a1[i];
		}
		for(int i = 0 ; i < a2.length ; i++) {
			result[a1.length+i] = a2[i];
		}
		
		 return result;
	}
	
	static char[] join(char[] a1, char[] a2) {
		
		int sumLength = (a1.length+a2.length) ;
		char[] result = new char[sumLength];
		
		for(int i = 0 ; i < a1.length ; i++) {
			result[i] = a1[i];
		}
		for(int i = 0 ; i < a2.length ; i++) {
			result[a1.length+i] = a2[i];
		}
		
		 return result;
	}

}
