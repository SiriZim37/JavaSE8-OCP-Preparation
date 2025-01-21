package innere;

class Aloha { void methodeA() { System.out.println("Hello A");}}

public class GueltigkeitInnerClassAufrufen {

	
	static int x = 11;
	
	public static void main(String[] args) {
		
		System.out.println(x);
		System.out.println(GueltigkeitInnerClassAufrufen.x);
		

        // Accessing inner class Aloha from GueltigkeitInnerClassAufrufen
        GueltigkeitInnerClassAufrufen g = new GueltigkeitInnerClassAufrufen();
        g.go();
        
        // Accessing the inner A class (inside GueltigkeitInnerClassAufrufen)
        GueltigkeitInnerClassAufrufen outerInstance = new GueltigkeitInnerClassAufrufen();
        A innerA = outerInstance.new A(); 
        innerA.methodeA();  // Output: Hello B

        
        // Accessing the A class from the "innere" package
        // ปัญหาที่ไม่สามารถเรียกใช้ A จากภายนอก package ได้ ซึ่งเหตุผลที่ไม่สามารถทำได้เกิดจากการที่มีการประกาศคลาส A ซ้ำกัน (overloading)
        // ทั้งใน inner class ของ GueltigkeitInnerClassAufrufen และใน package "innere" ของคุณ
//        A a = new A();  	// cf
//        a.methodeA();  
        
	}
	
	void go() {
		Aloha a = new Aloha();
		a.methodeA();    // Hello B 
		
		class Aloha { void methodeA() { System.out.println("Hello C");}}

		Aloha localA = new Aloha();  // ใช้ local class A ภายใน go()
        localA.methodeA();  // Output: Hello C
	}
	
	class A { void methodeA() { System.out.println("Hello B");}}
}
