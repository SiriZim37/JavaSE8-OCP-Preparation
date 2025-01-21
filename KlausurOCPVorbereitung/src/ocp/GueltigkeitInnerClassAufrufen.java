package ocp;

class A { void methodeA() { System.out.println("Hello A");}}
public class GueltigkeitInnerClassAufrufen {

	public static void main(String[] args) {
		
		GueltigkeitInnerClassAufrufen g = new GueltigkeitInnerClassAufrufen();
		g.go();
	}
	
	void go() {
		A a = new A();
		a.methodeA();    // Hello B 
		class A { void methodeA() { System.out.println("Hello C");}}
	}
	
	class A { void methodeA() { System.out.println("Hello B");}}
}
