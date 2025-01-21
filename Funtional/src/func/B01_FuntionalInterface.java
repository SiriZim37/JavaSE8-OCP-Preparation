package func;

import java.util.function.Predicate;

interface I11{} 			// kein funkt.Interface

interface I22 {  		// funkt.Interface
	void m1();
}

public class B01_FuntionalInterface {


	interface I1{
	} 			// kein funkt.Interface
	
	interface I2 {  		// funkt.Interface
		void m1();
	}
	
	interface I3 {  		// kein funkt.Interface
		void m1();
		void m2();
	}
	
	interface I4 {  		// funkt.Interface
		void m1();
//		void m();
		default void m2() {}
		static void m3() {}
		int K1 = 1 ;
	}
	
	interface I5 {  		// funkt.Interface
		String toString();
		int hashCode();
		boolean equals(Object obj);
		
		void m();
	}

	
	/*
	 * 	- Ein funktionales ist das Interface mit genau
	 * 	  einer abstrakten Methode
	 * 
	 *  - Achtung! Die Methoden mit den Signaturen aus der 
	 *    Klasse Object zählen nicht als abstract
	 */
	interface I6 {  		// funkt.Interface
		String toString();
		int hashCode();
		boolean equals(Object obj);
		
		boolean m(int n);
		default void testI6Default() {
			System.out.println("TestDefaultI6"); 
		}
	}
	class VVVV implements I6{
		public boolean m(int n) {
			return false;
		}
		
	}
	public static void main(String[] args) {
		
		
//		I1 v1 = ()-> {}; 		// cf 
		
//		I11 v11 = ()-> {}; 		// cf 
		
//		I3 v3 = ()-> {};  		 // cf 
		
		I2 v2 = ()-> {};      // ok 
	
		I22 v22 = ()-> {};    // ok 
		
		I4 v4 = ()-> {};      // ok 
		
		I5 v5 = ()-> {};      // ok 
		
		
		I6 v6 = new B01_FuntionalInterface().new VVVV();
		v6.testI6Default();
		VVVV v7 = new B01_FuntionalInterface().new VVVV();
		v7.testI6Default();
		v6 = ((n)-> true);

	}

}

