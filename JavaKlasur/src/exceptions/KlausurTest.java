package exceptions;


import java.io.IOException;
import java.lang.*;

/*
 * Test 1
 */
class OtherClass1 {
	static void doStuff() {
		throw new ArithmeticException();
	}
	static void doMoreStuff() {}
}

class MyClass1 {
	static { OtherClass1.doStuff(); }
	
	MyClass1() {
		OtherClass1.doMoreStuff();
	}
}

/*
 * Test 2
 */
class OtherClass2 {
	static void doStuff() {}
	static void doMoreStuff() {
		throw new ArithmeticException();
	}
}

class MyClass2 {
	static { OtherClass2.doStuff(); }
	
	MyClass2() {
		OtherClass2.doMoreStuff();
	}
}


/*
 * Test 3
 */
class OtherClass3 {
	static void doStuff() {}
	static void doMoreStuff() {
//		throw new IOException(); // cf
	}
}

class MyClass3 {
	static { OtherClass3.doStuff(); }
	
	MyClass3() {
		OtherClass3.doMoreStuff();
	}
}


public class KlausurTest {

//	static {
//		int x = 7/0;   // ExceptionInInitializerError
//	}
	public static void main(String[] args) {

		
		try {
			new MyClass1(); // Zeile A
		} catch (ExceptionInInitializerError e) {
			System.out.println("Test 1: " + e);
		}
		
		try {
			new MyClass2(); // Zeile A
		} catch (ArithmeticException e) {
			System.out.println("Test 2: " + e);
		}

		new MyClass3();
	}

}
