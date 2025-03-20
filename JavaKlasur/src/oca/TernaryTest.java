package oca;

abstract class E {
	abstract void draw();
}

abstract class D extends E {
	
}




public class TernaryTest {

	public static void main(String[] args) {
	
		int n1 = 5 ; 
		int n2 = 3;
		double n3 = 3.5;
		float f1 = (n1 * n2) > 10 ? 5 : 10; // ok 
		float f2 = (n1 * n2) > 10 ? 5.5f : 10L ; // ok 
		float f6 = (n1 * n2) > 10 ? 5L : 10L; // ok 

//		float f3 = (n1 * n2) > 10 ? 5.5 : 10.0 ; // cf 
//		float f4 = (n1 * n2) > 10 ? 5.5 : 10.0f ; // cf 
		
		float fS1 = n1 + f2; //  ok : float <- int 
		
//		float fS2 = n3 + f2; //  cf : double <- float 
		
		float fS3 = n1 + f2; //  ok : float <- int 
		
//		int n4 = f1 + n2 ; //  cf  : int <- float
		
//		Boolean b1 = (n1 * n2) > 10 ? "true" : false ; // cf : Mismatch 
		
//		String  s1 = (n1 * n2) > 10 ? "true" : false ; // cf : Mismatch 
	}

}
