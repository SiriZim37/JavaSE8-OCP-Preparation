package aufgaben.strings;


public class StringEinfach {
	

	 public static void  main(String[] args) {


		String str = "Java ist toll";
		
		System.out.println(str);
		
		// #1 Using a Loop
		String reversStr = "";
		for (int i = str.length() -1 ; i >= 0 ; i--) {
			reversStr += str.charAt(i);
		}
		System.out.println("1. " + reversStr);
		
		// #2 Using a StringBuilder 
	    StringBuilder reversedStr = new StringBuilder(str);
	    reversedStr.reverse();
	    System.out.println("2. " + reversedStr.toString()); 
	    
	    

	    
	}
	



}
