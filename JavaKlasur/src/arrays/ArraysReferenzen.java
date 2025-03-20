package arrays;

public class ArraysReferenzen {

	public static void main(String[] args) {
		
		  float[][][] f1 = { {  {1, 2 ,3}  } , { {4 , 5 , 6} } };
		  float []f3 , f4[] , f5[] , f6[][];
		  
//		  f3 เป็นอาร์เรย์ 1 มิติ (float[])
//		  f4 เป็นอาร์เรย์ 2 มิติ (float[][])
//		  f5 เป็นอาร์เรย์ 2 มิติ (float[][])
//		  f6 เป็นอาร์เรย์ 3 มิติ (float[][][])
		  
//		  f3 = f1[0];	// float[] < IST-KEIN <- float[][]
		  f4 = f1[0];	// float[][] < IST-A <- float[][]
		  f5 = f1[0];	// float[][] < IST-A <- float[][]
//		  f6 = f1[0];	// float[][][] < IST-KEIN <- float[][]
	}

}
