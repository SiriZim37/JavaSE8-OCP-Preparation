package strings;

public class WdhString {

	public static void main(String[] args) {

		String s1 = "m";
		String s2 = "mo";
		
		s1 += "o";
		
		System.out.println( s1 == s2 ); // false
		
		
		String s3 = "MO".toLowerCase();
		
		System.out.println( s1 == s3 );	// false
		
		String s4 = "momomo";
		
		/*
		 * 	s1.concat(s2)  -> String mit "momo"
		 *  
		 *  "momo" + s3 -> String mit "momomo"
		 *  
		 *  s4.equals( String mit "momomo");
		 */	
		System.out.println( s4.equals(s1.concat(s2)+s3) );	// true
		
		

	}

}
