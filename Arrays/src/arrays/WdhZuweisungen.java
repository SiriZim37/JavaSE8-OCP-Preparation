package arrays;

public class WdhZuweisungen {

	public static void main(String[] args) {
	
		
//		int[] a1 = m1(); // cf : int[] <- int[][]
		
//		int[][][] a2 = m1();  // cf : int[][][] <-  int[][]
		
		int[][] a1 = m1();
				
		int[][][] a3 = m2(); 
		int[][][] a4 = m3(); 
		int[][][] a5 = m4(); 
		int[][][] a6 = m5(); 
		
	}
	
	static int[][] m1() { return null; }
	
	/*
	 *  Liefert int[][][] zurück.
	 *  Bitte bei Nethoden NIEMALS so programmieren : 
	 * 
	 */
	
	
	static int[][] m2()[] { return null; }
	static int[] m3()[][] { return null; }
	static int m4()[][][] { return null; }
	
	
	static int [][]m5()[] {   // <<<< Methode static int[][][] m5() { return new int[][][]{}; }
	
		
		return new int[2][][]; 
		
	}
}
