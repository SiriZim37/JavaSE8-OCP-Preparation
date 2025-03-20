package oca;

public class SwithCaseConstantAndFinal {

	static int x = 7;
	public static void main(String[] args) {
		
		
		x++;
		switch(x) {
		
		}
		
		//-------------------------------------------------------------------//
		int y;
		y = 5;
		switch(y) {
		
		}
		//-------------------------------------------------------------------//
//		final int z;
//		y = 5;
//		switch(z) {		// cf The local variable z may not have been initialized
//		
//		}
		//-------------------------------------------------------------------//
		int zz;
		zz = 5;
		switch(zz) { // ok 
		
		}
		//-------------------------------------------------------------------//
		String v = "bob";
		final String a = "bob";
		switch(v) {		
		case a : ;
		}

		//-------------------------------------------------------------------//
		String b = "bob";
		switch(v) {		
//		case b : ;	// cf : must be enum or constant or final 
		}
		

		//-------------------------------------------------------------------//
		int h = 5;
		h++;
		int j = 0;
		j++;
		switch(h) {		
//			case j : ;	// cf : must be enum or constant or final 
//			case x: ;	// cf : must be enum or constant or final 
//			case y : ; // cf : must be enum or constant or final 
		}


		//-------------------------------------------------------------------//
		final int k = 0;
		switch(h) {		
			case k : ;	// cf : must be enum or constant or final 
		}

		//-------------------------------------------------------------------//
		byte bv1 = 2;
		final int vv1 = 1;
		final int vvv1 = 128; // 
		final short vv2 = 2;
		final short vv3 = 3;
		final char vv4 = 5;
		switch(bv1) {
			case vv1 :;
	//		case vvv1 :;	// cf . Type mismatch: cannot convert from int to byte
			case vv2:;
			case vv3:;
			case vv4:;
		}
		

		//-------------------------------------------------------------------//
		
		/*
		 * ค่าที่ใช้ใน case ต้องเป็น compile-time constant
		 * final Integer ไม่ถือเป็น compile-time constant เพราะเป็น wrapper class
		 */
		Integer n1 = 5;
		final Integer sn1 = 2;
		final int n2 = 1;
		switch(n1) {		
//			case sn1 : ;	
			case n2 : ;	
		}
		

		
	}
}
