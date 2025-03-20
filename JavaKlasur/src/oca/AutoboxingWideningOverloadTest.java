package oca;

public class AutoboxingWideningOverloadTest {

	public static void main(String[] args) {
		float n2 = calSomething(); // ok when 
		int n1 = 5;
//		float f1 = n2 + 10.0;					 	// cf 
//		float f2 = n1 + 10.0;  						// cf 
		float f3 = n1 + n2;   						// OK, int is promoted to float
		float f4 = (float) (n2 + 10.0);				// Now it's fine
		float f5 = (float) (n1 + 10.0);  			// OK after casting
		float f6 = n1 + 10L;  						// ok
		float f7 = n2 + (float)5.5;  				// ok
		
		float fA = (float)10.0;  					// ok   
	}
	

	 static int calSomething(Integer someInteger) { return 5 ; }
	 
	 static double calSomething(double someDouble) { return 5 ;  }
	 
	 static float calSomething() { return 5.5f ;  }

}
