package methoden;

public class TestParameter {

	public static void main(String[] args) {
		int x = 42;
		modify(x);
		System.out.println(x); // 42
	}

	static void modify(int x) {
		x = -17;
	}
	
}
