package arrays;

public class WdhArrayErzeugen {

	public static void main(String[] args) {
		
		
		/*
		 * 1.
		 */
		int[] a10 = new int[3];
		
		a10 = new int[5];
		
		m1(new int[5]);
		/*
		 * 2.
		 */
		int[] a20 = { 0 , 0 ,0 };
		
		//a20 = { 1,2,3,4,5};
		
		// m1({ 1,2,3,4,5});
		
		
		/*
		 * 3.
		 */
		int[] a3 = new int[] {0,0,0};
		
		a3 = new int[] {1,2,3,4,5};
		
		m1( new int[]{ 1,2,3,4,5});
	}
	
	static void m1(int[] a) {}
	
	static int[] m2() {
		return  new int[5];
	}
//	static int[] m22() {
//		return  { 1,2,3,4,5};
//	}
	
	static int[] m23() {
		return  new int[]{ 1,2,3,4,5};
	}
	
	
}
