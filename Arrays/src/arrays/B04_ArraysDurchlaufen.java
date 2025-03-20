package arrays;

public class B04_ArraysDurchlaufen {

	public static void main(String[] args) {
		
		double[] a1 = {
				12,
				3.0,
				-7.2,
				5
		};
		
		
		/*
		 * Mit for-schleife
		 * 
		 */
		for(int i = 0 ; i<= a1.length; i++) {
			double value = a1[i];
			System.out.println(value + " ");   // java.lang.ArrayIndexOutOfBoundsException 
											   // Index 4 out of bounds for length 4	
		}
		System.out.println();

		/*
		 *  Erweiterte for-Schleife ( auch foreach-Schleife genannt)
		 * 
		 * - wenn wir keine Inforamtion , wie viele Werte gibt es ( wissen NICHT ! )
		 */
	
		for( double value : a1) {
			System.out.println(value + " ");
		}
		System.out.println();
		
	}

}
