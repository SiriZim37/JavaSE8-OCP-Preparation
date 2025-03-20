package variablen;

public class ElementareTypen {
	/*
	 *    x = 2
	 *    y = x + 3
	 *    Jede neue Variable muss die Typangaben bekommen.
	 */
	
	public static void main(String[] args) {

		int x = 2 ;
		int y = x + 3;
		System.out.println("y = " + y);
		// x is Literal  2 is variable  int is type
		
		/*
		 *  Alle primitive ( elementare) Typen
		 */
		byte      v1;    // 8 bit    [ -128 ... +127]
		short     v2;	 // 16 bit
		int       v3;	 // 32 bit
		long      v4;	 // 64 bit
		float     v5;	 // 32 bit
		double    v6;	 // 64 bit
		
		boolean   v7;    // ? bit (nicht spezifiziert)
		char 	  v8;    // 16 bit ( Nicht negativ)
		
		
		/*
		 *  Alle Typen sind NICHT primitiv.
		 *  Es sind Refereztypen und alle sind 32 bit breit.
		 *  z.B. : 
		 */
		
		String   v9;
		Object   v10;
		Integer  v11;
		//...
		
		/*
		 * So kann man Max-,Min-Werte nachslagen
		 * Long is enge als Float zu speichern obwohl Long hat 64 bit merh als Float
		 */
		System.out.println("Long.MIN_VALUE = " + Long.MIN_VALUE);
		System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
		System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
		System.out.println("Integer.MIN_VALUE = " + Integer.MAX_VALUE);
		System.out.println("Float.MAX_VALUE = " + Float.MAX_VALUE); 
		System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE); 
	

		
	}
	
}
