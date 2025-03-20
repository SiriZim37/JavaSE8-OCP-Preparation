package wrapper;

public class WdhWrapper {

	public static void main(String[] args) {

		Integer i1 = null ; 
		int i2 = 3 - i1 ;	// NPE : NullPointerException von i1
							// int i2 = 3 - i1 
		System.out.println(i2);

	}

}
