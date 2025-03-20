package oca;

class AAA{
	public void say() {
		System.out.println("Hey!");
	}
	public static void say(String s , String ss) {
		System.out.println("Hey!" + s + ss);
	}
}

class BBB extends AAA{
	public void say(String s) {
		System.out.println("Hallo!" + s);
	}
	public void walk() {
		System.out.println("Walk!" );
	}
}

class CCC extends AAA{
	 
}

public class InheritanceClassABC {

	public static void main(String[] args) {
		AAA b = new BBB();
		b.say();
		b.say("f", "g");
//		b.walk();
		
		BBB bb = new BBB();
		bb.say();
		bb.say("r","t");
		
	}
}
