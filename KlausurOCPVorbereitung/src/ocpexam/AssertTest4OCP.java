package ocpexam;

public class AssertTest4OCP {

	/*
	Given:

public class Counter {
	public static void main (String[ ] args) {
		int a = 10;
		int b = -1;
		assert(b >=1) : "Invalid Denominator";
		int c = a / b;
		System.out.println (c);
	}
}

What is the result of running the code with the –ea option?
A. -10
B. 0
C. An AssertionError is thrown.
D. A compilation error occurs.
Answer: C

- If you are using eclipse editor, you should add -ea in vm argument.

- Exception in thread "main" java.lang.AssertionError: Invalid Denominator
	at com.wealth.certificate.dumps_1z0_809.question120.Counter.main(Counter.java:7)
	

*** Chapter 20 Assertions
- An assertion is a statement used to check if something is true and helps you to detect errors in a program.
- If booleanExpression evaluates to FALSE, an exception of type java.lang.AssertionError (a subclass of Error) is thrown. and terminate.
	 */
	public static void main(String[] args) {
		int a = 10;
		int b = -1;
		assert(b >=1) : "Invalid Denominator";
		int c = a / b;
		System.out.println (c);
	}
}
