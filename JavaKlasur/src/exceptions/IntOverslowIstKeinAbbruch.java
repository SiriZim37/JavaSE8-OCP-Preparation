package exceptions;

public class IntOverslowIstKeinAbbruch {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder("abc");
		sb.reverse().append("d");
		System.out.println(sb);
		
		int x =  Integer.MAX_VALUE;
		
		// 2,147,483,647
		System.out.println("x = " + x);
		
		// 01111111111111111111111111111111
		System.out.println("x = 0"  + Integer.toBinaryString(x));
		
		// 01111111111111111111111111111111
		// +
		// 0000.........................001
		// =
		// 11111111111111111111111111111111	// int-Overflow
		
		
        System.out.println("x = " + x);
        System.out.println("x = " + Integer.toBinaryString(x));

	}

}
