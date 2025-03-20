package aufgaben.strings;

import java.util.Random;

public class StringSilben {

	private static final  String[] silbens = {"pro", "gi", "idre" , "sol", "tä", 
	 	     "ven", "zom" , "ke", "no", "tu", 
	 	     "zi", "re", "pa", "me", "de"};
	
	private static final Random RANDOM = new Random(); 
	 
	public static void main(String[] args) {


		 for (String silbe : silbens) {
	            System.out.println(silbe);
	     }
		 
		 if( silbens!= null && silbens.length != 0 ) {
			 for (int i = 0; i < 50; i++) {
		            String neuerName = generiere(silbens , 4 );
		            System.out.println(i + ". " +neuerName);
		    }
		 }
		
	}
	
	static String generiere(String[] silbensArr , int anzahl) {
		String fullname ; 
		if (anzahl <= 0 ) {
	            return ""; 
	     }
		 
		 StringBuilder name = new StringBuilder();
		  
		 for (int i = 0; i < anzahl; i++) {
	            String silbe = silbensArr[RANDOM.nextInt(silbensArr.length)];
	            name.append(silbe);
	     }
		 
		 // 1 # 
//		 fullname = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		
		 // 2 #
		 char firstLetter = name.charAt(0);
		 firstLetter = Character.toUpperCase(firstLetter);
		 fullname = firstLetter + name.substring(1);
		 
		 return fullname;
	}

}
