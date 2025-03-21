package wdh.inheritance;


interface MyInterface{
	int K1 = 1;
	String name ="Tom";
	static void mF() {}    	// Only call with Interfacename
	
	default void defaultMethode() { System.out.println("default can call through ref object");}
}

class MyBase{
	static final int KB = 2;
	String name ="Jerry";
	static void mB() {}
	
}

public class AccessStaicInInterfaceVSClass  extends MyBase implements MyInterface {

	public static void main(String[] args) {
				
		System.out.println(K1); 
		System.out.println(MyInterface.K1); 
		MyInterface.mF();
		
		System.out.println(KB); 
		System.out.println(MyBase.KB); 
		mB();
		
		
		// Test name
//		System.out.println(name);		// The field name is ambiguous
		System.out.println(MyInterface.name);
//		System.out.println(MyBase.name);	// cf
		System.out.println(new MyBase().name);
		
		MyInterface.mF();
		MyBase.mB();
		
		MyInterface inface = new AccessStaicInInterfaceVSClass();
		System.out.println(inface.K1);		
//		inface.mF();		// cf : Cant call static methode through object 
		
		inface.defaultMethode();		// !Only default can call through ref Object

		MyBase base = new AccessStaicInInterfaceVSClass();
		System.out.println(base.KB);		 
		base.mB();			// ok : Can call static methode through object
		
		
		new AccessStaicInInterfaceVSClass().go();
//		MyInterface.super.defaultMethode();		// cf : Cannot use super in a static context
//		super.mB();								// cf : Cannot use super in a static context
		
		
	}
	
	void go() {
//		super.defaultMethode();				// cf : The method defaultMethode() is undefined for the type MyBase
		MyInterface.super.defaultMethode();
//		MyInterface.defaultMethode();		// cf : Cannot make a static reference to the non-static 
		super.mB();
		System.out.println(super.KB);
//		System.out.println(name);					// // The field name is ambiguous
		System.out.println(super.name);				// aus MyBase : Jerry
//		System.out.println(MyInterface.super.name);	// Cannot use 'super' to access 'name' from the interface		
//		System.out.println(MyInterface.super.K1);		// cf
	}
	
	
	
	
}
