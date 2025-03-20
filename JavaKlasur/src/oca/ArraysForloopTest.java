package oca;

import java.util.Arrays;
import java.util.Iterator;

public class ArraysForloopTest {

	public static void main(String[] args) {
	
		/* 1 */ System.out.println("*** 1.");
		int[][] arr = new int[5][2];
		arr[0] = new int[2];
		arr[1] = new int[5];
		
		int count;
		int count2 = 5;
		System.out.println(arr.length);   // 5
		System.out.println(arr[0].length); 
		System.out.println(arr[1].length); 
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr.length; j++) {
//				System.out.println(count++);	// cf : must initial
//				System.out.println(arr[i][j] + " "+ count2++ + " "); // ok but Exception : 
																	 //	0 5 
																	 //	0 6 
																	 // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
			}
			System.out.println();
		}
		
		/* 2 */  System.out.println("\n*** 2.");
		int[] arr1 = new int[2];
		int[] arr2 = new int[5];
		int[] arr3;
		System.out.println(Arrays.toString(arr1));		// [0, 0]
		System.out.println(Arrays.toString(arr2));		// [0, 0, 0, 0, 0]
		arr3 = arr2; System.out.println(arr3.length);	// 5
		arr3 = arr1;  System.out.println(arr3.length);	// 2
		
		
		/* 3 */  System.out.println("\n*** 3.");
		int[] arr4= new int[3];
//		arr4 = { 5 ,6 , 7}; // cf
		
		
		/* 4 */  System.out.println("\n*** 4.");
		
		
		/* 5 */ System.out.println("\n*** 5.");
		int[][] intA = { {13 ,14 } , {15 ,16 } };
		for (int i = 0; i < intA.length; i++) {
			for (int j = 0; j < intA.length; j++) {
				System.out.print(intA[i][j] + " ");			// 13 14 15 16 
			}
		}
		
		/* 6 */ System.out.println("\n*** 6.");
		int[][] intB = { {13 ,14 } , {15 ,16 } };
		for (int i = intB.length - 1 ; i > 0 ; i--) {
			for (int j = intB.length - 1 ; j > 0  ; j--) {
				System.out.print(intB[i][j] + " ");				// 16
			}
		}
		
		/* 6.1 */ System.out.println("\n*** 6.1");
		int[][] intBII = { {13 ,14 } , {15 ,16 } };
		for (int i = intBII.length - 1 ; i >= 0 ; i--) {
			for (int j = intBII.length - 1 ; j >= 0  ; j--) {
				System.out.print(intBII[i][j] + " ");		// 16 15 14 13
			}
		}
		
		/* 7 */ System.out.println("\n*** 7.");
		 int[] intC = new int[5];
		 System.out.println(Arrays.toString(intC));	// [0, 0, 0, 0, 0]
	     for (int i : intC) {
	            System.out.print(i + " ");
	     }
	     
	     /* 8 */ System.out.println("\n*** 8.");
		 String[] strList = new String[5];
	     for (String i : strList) {
	            System.out.print(i + " ");	 // null null null null null
	     }
		



	}

}
