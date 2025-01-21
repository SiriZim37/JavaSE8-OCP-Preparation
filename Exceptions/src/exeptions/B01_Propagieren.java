package exeptions;

public class B01_Propagieren {

	public static void main(String[] args) {
		
		System.out.println("a");
		m1();
		System.out.println("b");
		
	}
	
	static void m1() {
		
		System.out.println("c ");
		m2();
		System.out.println("d ");
		
	}
	
	static void m2() {
		
		System.out.print("e ");
		System.out.print(5/0);
		System.out.print("f ");
		
	}
}
