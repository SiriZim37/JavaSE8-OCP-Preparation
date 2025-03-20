package oca;



public class StringLiteralObjectTest {
	
	
	public static void main(String[] args) {
		
		 
		 System.out.println("**** 1. ");
		 
		 String stringOne = new String("Hello");
		 String stringTwo = new String("Hello");
		 String stringThree = stringOne;
		
		 System.out.println(stringOne == stringTwo);		// false
		 System.out.println(stringOne.equals(stringTwo));	// true
		 System.out.println(stringOne == stringThree);		// true
		 System.out.println(stringOne.equals(stringThree)); // true
		 
		 
		 System.out.println("**** 2. ");
		 
		 String stringOneI = "Hello";
		 String stringTwoI = "Hello";
		 String stringThreeI = new String("Hello");
		 
		 System.out.println(stringOneI == stringTwoI);
		 System.out.println(stringOneI == stringThreeI);
		 
		
	}

}
