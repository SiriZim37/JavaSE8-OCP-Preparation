package interfaces;


interface MyInterface{
	
	void m1();				// public abstract
	
	default void m2() {		// public
		m4();
	} 	
	
	int K1 = 1 ; 			//public static final
	
	static void m3() {}		// public
	
	private void m4() {}	// eplizit kann statische Methode private sein
	
	private static void m5() {}
}


public class SichtbarkeitDerElemente {

	public static void main(String[] args) {
	

	}

}
