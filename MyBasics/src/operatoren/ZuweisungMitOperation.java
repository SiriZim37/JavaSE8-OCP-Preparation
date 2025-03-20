package operatoren;

public class ZuweisungMitOperation {

	/*
	 * 	*=
	 * 	+=
	 * 	/= 
	 * 	...
	 * 
	 */
	public static void main(String[] args) {
		
		int x = 12;
		
		x += 7; // x = x + 7 
		System.out.println("x = " + x); // 19
		
		byte y = 3;
		
//		y = y + 7; // cf: byte <- int
		y = (byte)(y + 7); 
		System.out.println("a. y = " + y); // 10
		
		y += 5; // y = (byte)(y + 5)
		System.out.println("b. y = " + y); // 15
	
		double z = 3.1;
		z *= 3; // z = z * 3
		System.out.println("z = " + z); // 9.3
		
		double z2 = 0.0;
		y = 15;
		x = 19; 
		z2 = x /= 8 + (y -= 4); // nicht empfohlen für die Praxis
		System.out.println("z2 = "+ z2);    // z2 = 1.0 
		/*
		 * y -= 11
		 * 8 + 11  > 19
		 * x = x / 4   (x = 19/19) = 1.0  
		 */

	}

}
