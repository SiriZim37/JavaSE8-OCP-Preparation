package arrays;




public class Wdh_Arr4 {

	public static void main(String[] args) {
	

		// TEST 1
		
		int[][] a1 ;
		a1  = new int[2][3];
		
		 // Werte zuweisen
        a1[0][0] = 1;
        a1[0][1] = 2;
        a1[0][2] = 3;

        a1[1][0] = 4;
        a1[1][1] = 5;
        a1[1][2] = 6;

        // Werte ausgeben
        System.out.println("a1[0][0]: " + a1[0][0]);
        System.out.println("a1[0][1]: " + a1[0][1]);
        System.out.println("a1[0][2]: " + a1[0][2]);

        System.out.println("a1[1][0]: " + a1[1][0]);
        System.out.println("a1[1][1]: " + a1[1][1]);
        System.out.println("a1[1][2]: " + a1[1][2]);
        
    	
        // TEST 2 
//         a1  = new int[2][];   // kann auch erzeugen
         int[][] a2  = {
				 new int[3], // Erstes Unterarray mit 3 Spalten
				 new int[2]   // Zweites Unterarray mit 2 Spalten
		 };


	        // Werte zuweisen
        a2[0][0] = 1;
        a2[0][1] = 2;
        a2[0][2] = 3;

        a2[1][0] = 4;
        a2[1][1] = 5;

	     // Werte ausgeben
	     System.out.println("a2[0][0]: " + a2[0][0]);
	     System.out.println("a2[0][1]: " + a2[0][1]);
	     System.out.println("a2[0][2]: " + a2[0][2]);

	     System.out.println("a2[1][0]: " + a2[1][0]);
	     System.out.println("a2[1][1]: " + a2[1][1]);
	        
	/*
	 *  Stack
			- a1 → Referenz auf das 2D-Array im Heap
		Heap
			- Ein 2D-Array, das zwei Referenzen auf 1D-Arrays enthält
				a1[0] → Referenz auf ein Array der Länge 3 [1, 2, 3]
				a1[1] → Referenz auf ein Array der Länge 2 [4, 5]

	 */
	     
	     
	     // TEST 3
	     System.out.println("\nTEST 3");
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
