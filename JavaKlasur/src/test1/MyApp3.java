package test1;


class Z1 {
	int x = 6 ; 
	public Z1() {
		System.out.println("5 " +x);
	}
	
	{
		x++;
		System.out.println("4 " + x++);
	}
}

class Z2 extends Z1{
	static int x = 7 ; 
	public Z2() {
		System.out.println("7 " +x);
	}
	
	static {
		x++;
		System.out.println("1 " + ++x);
	}
	{
		x--;
		System.out.println("6 " + x);
	}
	
}

public class MyApp3 extends Z2{
	static int x = 5 ;
	public MyApp3() {
		System.out.println("8 " +x);
	}
	
	public static void main(String[] args) {
		
		System.out.println("3 " + x);
		test();
		
	}
	
	static {
		++x;
		System.out.println("2 " + x);
	}
	
	{
		++x;
		System.out.println("6 " +x);
	}
	
	static void test() {
		new MyApp3();
	}

}
