package arrays;

public class ForEachInExam {

	public static void main(String[] args) {

		/*
		 *  Hier wird die foreach-Schleife falsch
		 *  programmiert
		 *  
		 *  In die Schleifenvariable der foreach-Schleife
		 *  werden die Werte aus dem Array kopiert.
		 *  
		 *  Diese Werte als Index-Werte beim Zugriff 
		 *  auf das Array zu benutzen ist falsh.
		 * 
		 */		
		
//
//		int[] arr = {11,12,13} ; 
//		
//		for(int i : arr) {
//			System.out.println(arr[i]); // java.lang.ArrayIndexOutOfBoundsException
//		}
//		System.out.println();
		
		
//		Richtig wäre : 
		int[] arr = {11,12,13} ; 
		
		for(int i : arr) {
			System.out.print(i);   
		}
		System.out.println();

	}

}
