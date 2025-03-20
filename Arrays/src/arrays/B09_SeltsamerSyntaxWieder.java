package arrays;

import java.util.Arrays;

public class B09_SeltsamerSyntaxWieder {

	public static void main(String[] args) {

		/*
		 *  a1, a2 , a3 , a4 haben denselben Typ float[][][]
		 */
		
		float[][][] a1;
		float[][] a2[];
		float[] a3[][];
		float a4[][][];
		
		a1 = new float[2][][];
		a2 = new float[2][][];
		a3 = new float[2][][];
		a4 = new float[2][][];

//		a1 = new float[2][];
//		a2 = new float[2][];
//		a3 = new float[2][];
//		a4 = new float[2][];
		
//		a1[][] = 2.3F;  // cf : Index - Operator braucht den Index
//		a1[0][33] = 2.3F;  // cf : float[][] <- float
		
		 // Initialisierung der inneren Arrays
        a1[0] = new float[3][]; // Beispielhafte Größe für a1[0]
	 
     // Beispielhafte Wertzuweisungen
        a1[0][0] = new float[4]; // Beispielhafte Größe für a1[0][0]
        
		a1[0][0][0] = 2.3F;
		
		System.out.print(a1[0][0][0]);
		
	}

}
