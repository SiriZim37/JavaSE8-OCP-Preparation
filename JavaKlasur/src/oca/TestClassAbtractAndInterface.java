package oca;


interface interA{
	
	void doit();
	
	boolean isDoit();
	
	default void defDoIt() {
		System.out.println("deafult");
	}
}

abstract class AbstractClassA implements interA{
	
//	public void doit(); cf : 
//	private void doit() {}  // cf 

	public void doit() {
		System.out.println("abstract doit");
	}
	
	public abstract int checkIt();
} 

class ClassA extends AbstractClassA implements interA{
	
	public void doit() {					// this methode can overridden zero or one 
		System.out.println("class doit");
	}

	public boolean isDoit() {				// isDoit methode must overridden one (because not in AbstractClassA)
		return false;
	}
	
	public int checkIt() {					// checkIt methode must overridden one 
		return 14;
	}
}

public class TestClassAbtractAndInterface extends ClassA{
	
//	void doit() {							 //  cf	 : overriden must not change modifier
//		System.out.println("main class doit");
//	}
	
	void doit(int n) {						// ok	 : Not overriden
		System.out.println("main class doit : " + n);
	}
	

	public static void main(String[] args) {
	
		System.out.println("classA <- IS A AbstractClassA");
		AbstractClassA a1 = new ClassA();
		a1.doit();		// ok 
		
		System.out.println("classA <- IS A interA");
		interA a2 = new ClassA();
		a1.doit();		// ok 
		
		ClassA a3 = new TestClassAbtractAndInterface();
		int n = a3.checkIt();
		System.out.println(n); // 14 
//		a3.doit(5);			// cf not in classA
		
		TestClassAbtractAndInterface t2 = new TestClassAbtractAndInterface();
		t2.doit();		// class doit
		t2.doit(20);	// main class doit : 20
		
		
//		AbstractClassA a3 = new interA();  			 // cf 
//		AbstractClassA a3 = new AbstractClassA();    // cf 		
//		interA a4 = new AbstractClassA(); 			 // cf 
//		interA a5 = new interA();  					 // cf 		
//		TestClassAbtractAndInterface t1 = new interA(); // cf 

		
	}

}
