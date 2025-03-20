package aufgaben.apis;



public class StringAPI {

	public static void main(String[] args) {
		
		// 1. Konstruktoren :  String(), String(String s)
		System.out.println("### A 1.String(), 2.String(String s) \n");
		String s1 = new String("s1");
		System.out.println("1.1 String() : " + s1);	//s1
		
		String original  = "s2";
		String s2 = new String(original);
		System.out.println("1.2.String(String s) : " + s2);	// s2
				
		byte a = 'a' , b = 'B' ,  c = 'C' , d = 'D' , e = 'e' ;
		//System.out.println(a + "," + b + "," + c + "," + d + "," + e );
		
		char[] charArr = {'a' , 'B' ,'c' , 'D', 'e'};
		String str = new String(charArr);
		System.out.println("1.3 String(char[] value) : " +  str); // aBcDe

		byte[] byteArr = {97,66,67,68,101};
		str = new String(byteArr);
		System.out.println("1.5 String(byte[] bytes) : " +  str); // aBCDe
		
		str = new String(charArr , 1,3);
		System.out.println("1.4 String(char[] value, int offset, int count) : " +  str); // BcD
		

			
		
		//2. Testen Sie folgende Methoden. Sehen Sie sich dabei die Methodendeklarationen an.
		// * concat(String)
		System.out.println("\n### B");
		
		String strB = "Hello";
		
		System.out.println("\nstrB = \"Hello\" ");
		
		System.out.println("\n1* concat(String)\n");
		String s3 = strB.concat(" Java!");
		System.out.println("\ta. strB.concat(\" Java!\") : " + s3); //  Hello Java!
		String s4 = "Hello" + " Java!";
		System.out.println("\tb. \"Hello\" + \" Java!\"  : " + s4);  //  Hello Java!
		
		
		// * charAt(int)
		System.out.println("\n2* charAt(int)\n");
		String sc = "Hello";
		char c1 = sc.charAt(4);
		System.out.println("\ta sc.charAt(4) : " +  c1); 	// o
		
		// * isEmpty()  
		System.out.println("\n3* isEmpty() ");
		boolean empty = "".isEmpty();
		System.out.println("\ta. \"\".isEmpty() : " + empty); //  true
		System.out.println("\tb. strB.isEmpty() : " + strB.isEmpty()); //  true
		
		// * toUpperCase()
		System.out.println("\n3* toUpperCase() ");
		System.out.println("\ta. strB.toUpperCase() : " + strB.toUpperCase()); // HELLO
		
		// * toLowerCase()
		System.out.println("\n5* toLowerCase() ");
		System.out.println("\tb. strB.toLowerCase() : " + strB.toLowerCase()); // hello
		
		// * endsWith(String)
		System.out.println("\n6* endsWith(String) ");
		System.out.println("\ta. strB.endsWith(\"ll\") : " + strB.endsWith("ll"));
		System.out.println("\tb. strB.endsWith(\"eo\") : " + strB.endsWith("eo"));
		System.out.println("\tc. strB.endsWith(\"o\") : " + strB.endsWith("o"));
		
		// * startsWith(String prefix) 
		System.out.println("\n7* startsWith(String prefix) ");
		System.out.println("\tc. strB.startsWith(\"Hl\") : " + strB.startsWith("Hl"));
	
		
		// * startsWith(String prefix, int toffset) 
		System.out.println("\n8* startsWith(String prefix, int toffset) ");
		System.out.println("\ta. strB.startsWith(\"el\" , 1) : " + strB.startsWith("el" , 1));
		

		// * equals(Object)
		
		
		char[] charArray = {'H', 'e', 'l', 'l', 'o'};
	        
	    // Convert char array to String
	   String str2 = String.valueOf(true);
	   System.out.println(str2);
	   
	}

}
