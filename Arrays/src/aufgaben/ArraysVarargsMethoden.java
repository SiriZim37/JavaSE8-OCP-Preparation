package aufgaben;

public class ArraysVarargsMethoden {

	public static void main(String... args) {
		
		//###A1
		int total = produkt(3,5,7,11,13,17,19);
		int total2 = produkt(new int[] {2,4,6,8,10});
		int total3 = produkt(1,2,0,4); 		// test 0 
		int total4 = produkt(new int[] {}); // test empty
		int total5 = produkt(null); 		// test null
		System.out.format("Produkt 1. : %d \n", total );
		System.out.format("Produkt 2. : %d \n", total2 );
		System.out.format("Produkt 3. : %d \n", total3 );
		System.out.format("Produkt 4. : %d \n", total4 );
		System.out.format("Produkt 5. : %d \n", total5 );
		
		//###A2 
		String str1 = concat("Hello!"," " , "I am Robot"," " ,"I was born in USA.");
		String str2 = concat(new String[] {"Java" , " " , null, "ist" ," " , "eine" ," " , "Insel." , null});
		String str3 = concat("A123", "B456", "C789");
		System.out.format("Concat 1. : %s \n" , str1);
		System.out.format("Concat 2. : %s \n" , str2); // test null
		System.out.format("Concat 3. : %s \n" , str3);
		
		
	   

	    String str4 = concatWithDeimeter(", ","mo","di" , "mi");
	    String str5 = concatWithDeimeter(", ",new String[] {"mo"  , null, "di"  , "mi" , null}); // test null
		String str6 = concatWithDeimeter("," , new String[] {} ); // test empty
		String str7 = concatWithDeimeter("," , null); // test null
		String str8 = concatWithDeimeter(null , "mo","di" , "mi"); // test null
	    System.out.format("Concat with delimeter 4. : %s \n" , str4);
	    System.out.format("Concat with delimeter 5. : %s \n" , str5);
	    System.out.format("Concat with delimeter 6. : %s \n" , str6);
	    System.out.format("Concat with delimeter 7. : %s \n" , str7);
	    System.out.format("Concat with delimeter 8. : %s \n" , str8);
	    
	    
	    String str9 = concat(", ", new String[]{"mo","di" , "mi"});
	    String str10 = concat(", ",new String[] {"mo"  , null, "di"  , "mi" , null}); // test null
		String str11= concat("," , new String[] {} ); // test empty
		String str12 = concat(null , new String[]{"mo","di" , "mi"}); // test null
	    System.out.format("Concat 9. : %s \n" , str9);
	    System.out.format("Concat 10. : %s \n" , str10);
	    System.out.format("Concat 11. : %s \n" , str11);
	    System.out.format("Concat 12. : %s \n" , str12);
	}
	// A3 
	/* Die Varargs-Methode würde kompilieren , aber damit werden die 'bequemen' 
	 * Aufrufen der Methode aus A2 nicht mehr möglich sein.
	 * static String concat(String delimiter, String... str) {
	 */
	
	static String concat(String delimiter, String[] str) {
		 if(delimiter == null)
			 delimiter = "";
		 
		 if (str == null || str.length == 0) {  return "";}
		 
		StringBuilder sb = new StringBuilder();
	
		/* 1. Check mit for-each */ 
		
		boolean first = true; //  to do not set the delimiter at first .
		
		for( String s : str) {
			if(s != null) {
				if(!first)
					sb.append(delimiter);	
				sb.append(s);
				first = false;
			}
			
		}
		
		return sb.toString();
		
	}
	
	// A3
	
	 static String concatWithDeimeter(String delimiter, String... str) {
		 if(delimiter == null)
			 delimiter = "";
		 
		 if (str == null || str.length == 0) {  return "";}
		 
		StringBuilder sb = new StringBuilder();
	
		/* 1. Check mit for-each */ 
		
		boolean first = true; //  to do not set the delimiter at first .
		
		for( String s : str) {
			if(s != null) {
				if(!first)
					sb.append(delimiter);	
				sb.append(s);
				first = false;
			}
			
		}
		
		/* 2 .  Check mit for-Schleife  */ 
		
//		for(int i = 0 ; i < str.length ; i++){
//			if(str[i] != null) {
//				if(i!=0)
//					sb.append(delimiter);
//				sb.append(str[i]);		
//			}	
//		}
		
		return sb.toString();
	}
	 
	 
	
	// A2
	static String concat(String...str) {
		
		if (str == null || str.length == 0) { return ""; }
		
		StringBuilder sb = new StringBuilder();
		for(String s : str) {
			if(s!=null)
				sb.append(s);
		}		
		return sb.toString();
	}
	
	// A1
	static int produkt(int... val) {
		if(val == null)
			return 0 ;
		
		if(val.length == 0)
			return 0 ;
		
		int total = 1 ;
		for(int x : val) {
			total*=x;
		}
		
		return total ; 		
	}

}
