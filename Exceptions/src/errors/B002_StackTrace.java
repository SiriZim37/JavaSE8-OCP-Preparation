package errors;

public class B002_StackTrace {

	public static void main(String[] args) {

		m1();

	}
	
	static void m1() {
		m2();
	}

	static void m2() {
		m3();
	}
	
	static void m3() {
		throw new StackOverflowError();
	}
}
