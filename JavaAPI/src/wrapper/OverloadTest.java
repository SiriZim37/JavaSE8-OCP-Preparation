package wrapper;

public class OverloadTest {

	public static void main(String[] args) {
		int i = 42;
		
		// Bei überladenen Methoden gilt : widening schlägt boxing schlägt var-args
		print(i);
	
//		int i = 42;
//		test(i); // kein widening plus boxing! 
		
		Long l = 42L ;
		test(l); 

	}
	
	public static  void print(float i) {   // long gewinn : This method is a potential match.
		System.out.println("print float");
	}
	
	public static  void print(long i) {   // long gewinn : This method is a potential match.
		System.out.println("print long");
	}
	
	public static  void print(Integer intObj) {
		System.out.println("print Integer");
	}

	public static  void print(int... i) {
		System.out.println("print int var-args");
	}
	
	public static void test(Long l) {
		System.out.println("test long");
	}

}
