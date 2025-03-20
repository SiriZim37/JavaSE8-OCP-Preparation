package lamdaps;

import java.util.function.Predicate;


interface MyIntA{
	boolean m(int a , int b);

}

class MyClass{

}

interface Lauffaehig{ 	
	void laufen();
}

public class LambdaKap16 {

	public static void main(String[] args) {
		
		Lauffaehig ref = () -> {
			System.out.println("laufe...");
		};
		

//		Predicate<EgalWas> pA1 = (x,y) -> 7 < 5  ; // cf 
//		MyIntA pA2 = x , y -> 7 < 5 ; // cf 
		MyIntA pA3 = (x , y) ->  x+y < 5 ; 
		System.out.println("1." +  pA3.m(5,5));
		
		MyIntA pA4 = (int x , int y) -> x+y < 5 ;
		System.out.println("1." +  pA3.m(1,2));
		
		Predicate<MyClass> pB = x -> {
			return adder(2, 1) > 5 ;
		};
		System.out.println("3. " + pB.test(new MyClass()));

//		Predicate<EgalWas> pB = x -> return adder(2, 1) > 5;	// cf 

		Predicate<MyClass> pC1 = x -> {
			return adder(2, 1) > 5 ;
		};
		Predicate<MyClass> pC2 = x ->  adder(2, 1) > 5;
		
		Predicate<MyClass> pD1 = x -> {
			int z = 5 ; 
			int y = 7; 
			return adder(y, z) > 8 ; 
		};

		Predicate<MyClass> choichE = x -> {
			int z = 5 ; 
			int y = 7; 
			return adder(y, z) > 8 ; 
		};
		
		Predicate<MyClass> choichF = (MyClass x ) ->  adder(2, 1) > 5;
		
//		Predicate<MyClass> choichG = (MyClass x ) ->  5+3 ;	// cf 
		

		
	}

	static int adder(int a , int b ) {
		return a + b ; 
	}
}
