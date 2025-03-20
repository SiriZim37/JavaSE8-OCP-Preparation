package garbagecollector;


class A{
	static A x ; 
	static B y ;
	
	void s( B b ) {
		x = this;
		y = b ;
	}
	@Override
	public String toString() {
	    return "This is an object of class A";
	}
	private String name;
}

class B {
	private String name;
	
	public B(String name) {
		super();
		this.name = name;
	}
	
}

public class WannIstDasObjectUnerreichbar {
	// Answer  :  There is no way to be absolute certain 
	static void start() {
		A a = new A();
		B b = new B("test");
		a.s(b);
		b = null;
		a = null;
	}
	
	public static void main(String[] args) {

		start();
		 
		System.out.println(A.x);  // มีออบเจ็กต์ของคลาส A ที่สร้างขึ้นและยังคงอยู่ในหน่วยความจำ
//		System.out.println(B.y);
		
	
	}

}
