package vererbung;



interface InterA {
	void doIt();
}

// Ein Interface kann beliebig vielen Interface erweitern. 
// Ein Interface kann keine Klasse erweitern oder implementieren
interface InterB extends InterA , InterC {
//	void test() {} ; // cf : Methode kann nicht in Interface  erzuegen
	
	void test();  // ok 
	

//	public void test1();  // ok 
//	static void test2() {;}// ok : default static
//	default void test22() {}// ok : default 
	static void test2() {;}// ok : default static

}

interface InterC{
	void checkIi();
}

class TestClass implements InterB{

	@Override
	public void doIt() {
		System.out.println("do it");
	}

	@Override
	public void test() {
		System.out.println("test");	
	}

	@Override
	public void checkIi() {
		System.out.println("check it");	
	}

}


public class B21_Interface_Vererbung {

	public static void main(String[] args) {
	
		TestClass tc = new TestClass();
		tc.doIt();
		tc.test();
		
		InterA ia = new TestClass(); // ok Polymorphie
		InterB ib = new TestClass(); // ok Polymorphie
		Object o = new TestClass();
		
		
		ia.doIt();
		ib.doIt(); // ok : 
//		o.doIt();	// cf :in der Klasse Object gibt es keine doIt() Methode 
		
		ib.test(); // ok : 
//		ia.test(); // cf : in dem Interface Inter A gibt es keine test() Methode (erst im sub-Interface InterB)
//		o.test();  // cf : in der Klasse Object gibt es keine test() Methode 
	
		
	}

}
