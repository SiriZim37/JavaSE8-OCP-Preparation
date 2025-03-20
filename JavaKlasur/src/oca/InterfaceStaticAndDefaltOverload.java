package oca;

import java.io.StreamCorruptedException;

interface Ribbin{
	static int getSound(int s) {
		return s;
	}
	
	default int score() { return 10;}
	default int happiness() { return 55;}
}


interface Ribbon{
	static int getSound(int s) {
		return s;
	}
	
	public default int score() { return 20;}
	
}


public class InterfaceStaticAndDefaltOverload implements Ribbin , Ribbon{
	public int score(int n) { return 10;}
	public int score() {return  30;}

	public static void main(String[] args) {

		
		new InterfaceStaticAndDefaltOverload().go();

		Ribbin r1 = new InterfaceStaticAndDefaltOverload();
		System.out.println("test. " + r1.score());
		System.out.println("test2. " +  ((Ribbon)r1).score());

		System.out.println("test. " + r1.happiness());
//		System.out.println("test2. " +  ((Ribbon)r1).happiness()); // cf 

		System.out.println(((Ribbon)null).score()); // null poinexception
	}
	void go() {
		System.out.println(score() );
//		System.out.println(super.score() );				// cf : The method score() is undefined for the type Object
//		System.out.println(Ribbin.score() );			// cf : score is not static 
		System.out.println(Ribbin.super.score() );		// 10
		InterfaceStaticAndDefaltOverload obj = new InterfaceStaticAndDefaltOverload();
		System.out.println(obj.score());
	}
	
	public int hop() { return 10;}


}
