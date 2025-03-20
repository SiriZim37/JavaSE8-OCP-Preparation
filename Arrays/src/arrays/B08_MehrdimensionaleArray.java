package arrays;

import java.util.Arrays;

public class B08_MehrdimensionaleArray {

	public static void main(String[] args) {
		
		
		int[][] a1  = new int[2][];
		
		System.out.println("*** a1 : ");
		for( int i = 0 ; i < a1.length ; i++) {
			System.out.println("a1[" + i + "]: " + a1[i]);
		}
		
		
		// ------------------------------------------
		int[][] a2  = new int[2][3];
		
		System.out.println("\n*** a2 : ");
		for( int i = 0 ; i < a2.length ; i++) {
			int[] subarr = a2[i];			
//			System.out.print("Subarray " + subarr);
			
			for( int j = 0 ; j < subarr.length ; j++) {
		
				System.out.print("a2[" + i + "][" + j + "]: " + subarr[j] + " ");
			}
			System.out.println();	
		}
		
		// ------------------------------------------ 
		
		int[][] a3 = new int[2][3];
		
		System.out.println("\n*** a3 : ");
		for(int i = 0 ; i<a3.length ; i++) {
			for( int j = 0 ; j < a3[i].length ; j ++ ) {
				System.out.print(a3[i][j] + " ");
			}
			System.out.println();
		}
		
		
		// ------------------------------------------ 
		int[] intArr = { 7 , 8 ,9 };
		
		int[][] a4 = {
				intArr , 
				null ,
				intArr ,
				new int[5],
				null
		};
		System.out.println("\n*** a4 : ");
		System.out.println("\na4.1");
		// Test mit Array execpt NULL!
		 for (int i = 0; i < a4.length; i++) {
			 int[] subArr = a4[i];
			 System.out.println(Arrays.toString(subArr));
		 }
		 System.out.println("\na4.2");
		 for (int i = 0; i < a4.length; i++) {
			 int[] subArr = a4[i];
			 if (subArr== null) {
				 System.out.println("a4[" + i + "]: null");
			 }else {
				  for (int j = 0; j < subArr.length; j++) {
	                    System.out.print(subArr[j] + " ");
	                }
				  System.out.println();
			 }
		 }
			System.out.println("");
		 System.out.println("\na4.3");
		  // Werte ausgeben
        for (int i = 0; i < a4.length; i++) {
            if (a4[i] != null) {
                System.out.print("a4[" + i + "]: ");
                for (int j = 0; j < a4[i].length; j++) {
                    System.out.print(a4[i][j] + " ");
                }
                System.out.println();
            } else {
                System.out.println("a4[" + i + "]: null");
            }
        }
        
    	System.out.println("\n*** a5 : ");
    
 	     int[][] arr  = new int[3][5];
 	     
 	     arr[1][1] = 42;
 	     // Werte ausgeben
 	        for (int i = 0; i < arr.length; i++) {
 	            for (int j = 0; j < arr[i].length; j++) {
 	                System.out.print(arr[i][j] + " ");
 	            }
 	            System.out.println();
 	       }
    	
		
		
		
	}

}
