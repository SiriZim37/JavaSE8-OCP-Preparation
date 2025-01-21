package aufgaben.blocking;

import java.math.BigInteger;
import java.util.Arrays;

public class ThreadsBlockingPermutaionA1 {

	public static void permutate(char[] arr, int pointer) {
	    if(pointer==1) {
	        System.out.printf("%s %n", Arrays.toString(arr));
	        return;
	    } 
	    
		for (int i = 0; i < pointer-1; i++) {
		   permutate(arr, pointer-1);
		    
			if(pointer%2==0) {
			    char tmp = arr[pointer-1];
			    arr[pointer-1] = arr[i];
			    arr[i] = tmp;
			} else {
			    char tmp = arr[pointer-1];
			    arr[pointer-1] = arr[0];
			    arr[0] = tmp;
			}
		}
		
		permutate(arr, pointer-1);
	}
	
	public static BigInteger factorial(BigInteger bi) {
		if(bi.intValue()==1) {
			return bi;
		}
		return bi.multiply( factorial(bi.subtract(BigInteger.ONE)) );
	}
	

	public static void main(String[] args) {
		char[] array = { 'a', 'b', 'c' };
		
		BigInteger bi = BigInteger.valueOf( array.length );
		BigInteger numberPermutations = factorial( bi );
		System.out.println("bi : " + bi );
		System.out.println("numberPermutations : " + numberPermutations );
		
		permutate(array, array.length);
			
		
		// A1 
		System.out.println("\n*** A1");
		char[] array2 = { 'd', 'e', 'f' , 'g' , 'h' , 'i' };   // (6!) 
		
		bi = BigInteger.valueOf( array2.length );
		numberPermutations = factorial( bi );
		System.out.println("bi : " + bi );
		System.out.println("numberPermutations : " + numberPermutations );
		
		Runnable permuteTask = () -> {		
			permutate( array2 , array2.length);
		};	
		new Thread(permuteTask).start();
		
	}


	
}

