package arrays;

public class WdhDArrayDurchlaufen {

	public static void main(String[] args) {
	
		double[][] arr = {
				{ .1 , .2 , .3},
				{ -33 , -22 ,111 , -7},
				{ 5.6 , 3.14 }
		};
		
		System.out.println("*** A1");
		for (int i = 0; i < arr.length; i++) {
		    for (int j = 0; j < arr[i].length; j++) {
		        System.out.print(arr[i][j] + " ");
		    }
		    System.out.println();
		}
		
		
		System.out.println("\n*** A2");
		for( double[] subArr : arr) {
			for( double value : subArr) {
				 System.out.print(value + " ");
			}
			 System.out.println();
		}
		
		
	}

}
