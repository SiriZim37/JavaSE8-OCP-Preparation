package aufgaben.enums;

public class TestMyOS {

	public static void main(String[] args) {
		

		System.out.println("Test MyOS Klass ");
		System.out.println("*** statische Methode values:");
		MyOS[] myValues = MyOS.values();
		
		for (MyOS myos : myValues) {
			System.out.println(myos);
		}
		
		System.out.println("** toString:");
		MyOS var2 =  MyOS.WINDOWS;
		System.out.println(var2); // MAC
		
		
		switch (var2.toString()) {
			case "WINDOWS" : 
				System.out.println("BLue-Screen-Alarm");
				break;
			default :
				System.out.println("Alles in Ordnung! ");

		}
		
		// Test ValueOf
		
//		String[] arrMyOS =  {"ANDROID","iOS","UNIX" };
//		for(String s : arrMyOS) {
//			try {	      
//		        System.out.println(  OS.valueOf(s));
//		     } catch (IllegalArgumentException e) {
//		        System.out.println("Exception: " + e.getMessage()); 
//		     }
//		}
		
	
	
	
		
		System.out.println();
		/* --------------- MyOS------------------*/
		
		
		System.out.println("Test Enum OS ");
		System.out.println("*** statische Methode values:");
		OS[] allValues = OS.values();
		
		for (OS os : allValues) {
			System.out.println(os);
		}
		
		System.out.println("** toString:");
		OS var1 =  OS.UNIX;
		System.out.println(var1); // MAC
		
		// on top enum in einem swith-Konstrukt
		switch (var1) {
			case WINDOWS : 
				System.out.println("BLue-Screen-Alarm");
				break;
			case UNIX :
			case MAC :
				System.out.println("Alles in Ordnung! ");
				break;
			default : 
				System.out.println("unbekannt");

		}
	
//		String[] arrOS =  {"ANDROID","iOS","UNIX" };
//		for(String s : arrOS) {
//			try {	      
//		        System.out.println(  OS.valueOf(s));
//		     } catch (IllegalArgumentException e) {
//		        System.out.println("Exception: " + e.getMessage()); 
//		     }
//		}
	
		

	}
	

}

