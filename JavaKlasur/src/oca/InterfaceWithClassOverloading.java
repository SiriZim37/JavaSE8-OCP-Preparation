package oca;

interface Volga{
	static String m1() {return "m1";}
}
public class InterfaceWithClassOverloading {
	static String m1() {return "m2";}
	
	public static void main(String[] args) {
		

		InterfaceWithClassOverloading m = new InterfaceWithClassOverloading();
		System.out.println(m.m1());		// m2
		System.out.println(Volga.m1());	// m1
	}
	
}
