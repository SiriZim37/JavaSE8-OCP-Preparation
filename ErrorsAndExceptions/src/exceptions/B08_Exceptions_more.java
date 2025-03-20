package exceptions;

import java.util.Scanner;

public class B08_Exceptions_more {

	public static void main(String[] args) {
		double d = Math.log(0);
		System.out.println("d = " + d ) ;	 // d = -Infinity
		double root = 7 / 0; 
		System.out.println("root = " + root ) ; // ArithmeticException: / by zero
		
		
		
		String s = null;
		System.out.println(s.length());
		if(s!=null) {
			System.out.println(s); // NullPointerException
		}
		
		
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		System.out.println("i = " + i); 
		sc.close();
		long l = sc.nextLong();
		System.out.println("l = " + l);  //  java.lang.IllegalStateException: Scanner closed
		
//		int i = Integer.parseInt("X") ;	// NumberFormatException ist Subklasse con IllegelArgumenteExeption 
//		long l = Long.parseLong("3.14");
		
	}
}
