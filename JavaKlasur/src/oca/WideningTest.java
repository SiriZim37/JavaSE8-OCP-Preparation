package oca;

public class WideningTest {

	public static void main(String[] args) {

		// 1**** 
		System.out.println("***1.");
		doSomething(10); 		// float 
		doSomething(10.0f); 	// float
		doSomething(10.0); 		// double
		
		// 2**** 
		System.out.println("***2.");
		long xII = 10;
        method(xII);		// varargs
		
    	// 3**** 
        System.out.println("***3.");
        Integer xIII = 100;
        methodIII(xIII);	// Object
        
        // 4**** 
        System.out.println("**4.");
        methodIV(10);			// float
        
        // 5**** 
        System.out.println("**5.");
        methodV(10);		// Object
        
        // 6**** 
        System.out.println("**6.");
//        methodIII(null);		// Object
        methodIV(null);			// Integer
        doSomething(null);		// Integer
        methodV(null);	
	 }
	
	// 1**** 
	 static void doSomething(Integer someInteger) { System.out.println("integer"); }
	 
	 static void doSomething(double someDouble) { System.out.println("double"); }
	 
	 static void doSomething(float someFloat) { System.out.println("float");  }
	 
	  
	// 2**** 
	 public static void method(int... i) {  System.out.println("varargs"); }
	 
	 public static void method(Long l) { System.out.println("Long"); }
	 
	 
	// 3**** 
	 public static void methodIII(int i) {	 System.out.println("int");}
	 public static void methodIII(Number i) {	 System.out.println("Number");}
	 
	 public static void methodIII(Object o) { System.out.println("Object"); }

	 
	 
     // 4**** 
	 public static void methodIV(Integer i) {  System.out.println("Integer"); }
	 public static void methodIV(long f) {System.out.println("long");}
	 public static void methodIV(float f) {System.out.println("float");}
	 
	 
     // 5**** 
	 public static void methodV(Object o) {  System.out.println("Object");  }
	 
	 public static void methodV(String s) { System.out.println("String");}
}
