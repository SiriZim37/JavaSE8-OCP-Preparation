package strings;

public class B03_StringLiterale {

	public static void main(String[] args) {

		String s1 = "Mo";	// aus einem Literal wird eine Referenz zu dem
							// String-Objekt aus dem String-Pool (s. Bsp StringPoo)

		/*
		 * Escape-Sequences
		 */
		
		String s2 = "\n" ;
		System.out.println("s2.lenght() :" +  s2.length() ); // 1
		
		String s3 = "\""; 
		System.out.println("s3.lenght() :" +  s3.length() ); // 1
		System.out.println("s3 =  :" +  s3 ); // Res : "
		
//		String sTmp2 = "\";  // cf 
		String s4 = "\\"; 
		System.out.println("s4.lenght() :" +  s4.length() ); // 1
		System.out.println("s4 =  :" +  s4 ); //  Res : \
		
		System.out.println("Die Zeichen \" oder \\ sind nicht so einface in String-Literal zu packen.");


	}
}