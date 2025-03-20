package oca;

class MyString{
	String s;
	
	public boolean equal(String myString) {
		System.out.println(s);
		System.out.println(myString);
		return this.s.equalsIgnoreCase(myString);
		
	}

}

public class TestClassEqaul extends MyString{

	public static void main(String[] args) {

		String s1 = "Moon";
		String s2 = new String("Moon");
		
		if(s1 == "Moon" && equalignorecase(s1,s2))	// 0 true
			System.out.println("0 true" );
		
		if(s1 == s2)	
			System.out.println("1 true" );
		System.out.println("1 false");	 		// 1 false
		
		MyString my = new MyString();
		my.s = "Moon";
		
		if(my.equal(s2)) {
			System.out.println("2 true" );		// 2 true
		}else {
			System.out.println("2 false" );
		}
		
		if(s1 == (my.s) ) {
			System.out.println("3 true" ); 		// 3 true
		}else {
			System.out.println("3 false" );
		}
	}
	
	public static boolean equalignorecase(String s1 , String s2) {
		return s1.equalsIgnoreCase(s2);
	}

}
