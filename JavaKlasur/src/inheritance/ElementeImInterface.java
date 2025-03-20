package inheritance;

interface MyInterface{
	
	void m1();	// public abstract
//	void m11() {}	// cf 
	
	default void m2() {}	// default muss Rumpf haben
//	default void m22();	// cf 
//	final void m8() {} 	// cf 
	static void m3() {}
//	void m33() {}	// cf : Instancemothode ohne default
	
	int K0 = 0; 	// public static final
	public int K1 = 0;
	public static final int K2 = 0;
}



public class ElementeImInterface {

	public static void main(String[] args) {



	}

}
