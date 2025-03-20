package basic;

public class BitwiseXOR {

	public static void main(String[] args) {
		
		 System.out.println(2000L > 1999L);		 // true  ( 1999L + (unboxing) 1 )
		 System.out.println((1000L*2) == 2000L); // true  ( 1000L *  (unboxing) 2)
		 
		 if(2000L > 1999L  ^ ( (1000L*2) == 2000L) ){  // true ^ true ergibt false
			 System.out.println("1");
		 }
		 
		 System.out.println(1999L+1 != 2000L);		// false  ( 1999L + (unboxing) 1)
		 System.out.println(((1000L*2) == 1999L));  // false  ( 1000L *  (unboxing) 2)

		 if( (1999L+1 != 2000L)   ^ ( (1000L*2) == 1999L)){ // false ^ false ergibt false
			 System.out.println("2");
		 }
		 
		 System.out.println("end of main");

	}

}
