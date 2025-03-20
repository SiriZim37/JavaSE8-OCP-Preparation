package inheritance;

/*
 * 
 */

interface MyTestInterface{
	/*
	 * Java 8 : all Element are public!
	 */
	
	// 1. Abstact Instant-method
	void m1();										// implcit : public abstract
	public abstract void m11();						
	abstract void m111();							// implcit : public 
	public void m1111();							// implcit : abstract
//	final void m11111();							// cf : only public, abstract, default, static 
	
	
	// 2. default Instant-methode
	default void m2() {								// implcit : public 	
		System.out.println(this);
	}
	
	// 3. Static method
	static void m3() {								// implcit : public 
	}
	
	//-------------------------------------------//
	
	// 4. Statiic Constant
	
	int K1 = 1;										// implcit : public static final							
	public static final int K2 = 2;
	static int K3 = 3;								// implcit : public 	
	final int K4 = 4;								// implcit : public static	
	public int K5 = 5;								// implcit : static	
	
	// 5. Inner Typ
	class Innerclass{};
	interface InnerInterface{}
	enum EnumInterface{}
	

}

class MyTestClass implements MyTestInterface{
	public void m1() {}
	public void m11() {}
	public void m111() {}
	public void m1111() {}	
}


public class InterfaceElement {


	public static void main(String[] args) {
		
//		MyTestInterface my = new MyTestInterface(); // cf : cannot create new Object of Interface
		
		MyTestInterface myObj0;
//		myObj0.m1();  				// cf : The local variable myObj0 may not have been initialized
		
		MyTestInterface myObj1 = null;
		myObj1.m1();  
		myObj1.m2();    
		
		MyTestInterface myObj2 = new MyTestClass();	
		myObj2.m1(); 


		
//		MyTestInterface.m1();		// cf : m1() is Object and cannot make a "static reference " to the "non-static" 
		MyTestInterface.m3();		// ok :  Static reference can call static methode
		
		
		int i1  = MyTestInterface.K1;    // K1 - K5 are public static final 
		int i11 = myObj2.K2; 			 // K1 - K5 are public static final  	
		
	}
}
