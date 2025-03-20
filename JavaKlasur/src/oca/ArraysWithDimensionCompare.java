package oca;

import java.util.Arrays;
import java.util.Iterator;

interface FFF{
	
}
class AC implements FFF{}
class BC implements FFF{}
public class ArraysWithDimensionCompare {

	public static void main(String[] args) {
	
		
		FFF[] n = new FFF[5];
		n[0] = new AC();
		n[1] = new BC();
		System.out.println(Arrays.toString(n)); // [oca.AC@59f95c5d, oca.BC@5ccd43c2, null, null, null]
		
		AC[] g = new AC[5];
		n[0] = new AC();
		n[1] = new BC();
		System.out.println(Arrays.toString(n)); // [oca.AC@59f95c5d, oca.BC@5ccd43c2, null, null, null]
		
		int[] vv = new int[4];
		char[] cc = new char[3];
		
//		vv = cc;  // cf
		
		
		
	     int a[][][][][] = new int[2][2][2][2][2];
	     int b[][][] = new int[2][1][2];
	     int c[]  = new int[2];
	     
	      // a 2 Dimension = b 2 Dimension
	      a[0][0][0] = b[0];
	      // a 3 Dimension = b 3 Dimension
	      a[0][0] = b;
	      // a 0 Dimension = c 0 Dimension
	      a[0][0][0][0][0] = c[0];
	      // a 1 Dimension = c 1 Dimension
	      a[0][0][0][0] = c;   
		

	}

}
