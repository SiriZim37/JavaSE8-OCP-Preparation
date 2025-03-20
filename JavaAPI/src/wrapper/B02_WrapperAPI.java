package wrapper;

public class B02_WrapperAPI {

	
	public static void main(String[] args) {
	
		/*
		 * In Java 8 ist es noch ok die Konstruktoren der 
		 * Wrapper-Klasen zu verwenden. 
		 */
		Integer i1 = new Integer(12); // in OCA-Exam ok in Praxis liebe Autboxing
									// new Integer(12) call explicitly invokes the Integer class constructor,
									//creating a new object on the heap with the value 12.
		Integer i2 = new Integer("12"); // in OCA-Exam ok in Praxis liebe valueOf
		
		// Test 
		 i1 = new Integer(12);  // Creates a new Integer object
	     i2 = Integer.valueOf(12); // Might reuse an object from the cache
	     System.out.println(i1 == i2); // Prints: false
	     System.out.println(i1.equals(i2)); // Prints: true
		
		/*
		 * Wichtig ! 
		 * 
		 * statische Methode valueOf mit dem 
		 * ensprechendem primitiven Parameter
		 * Die Methode 
		 */
	     
	     Byte v1 = Byte.valueOf((byte)12); // manuelles Boxing  
	     Byte v111 = 12 ;  // AutoBoxing 
	     Double v2 = Double.valueOf(12.3);
	     Boolean v3 = Boolean.valueOf(false);
	     //...
	     

			/*
			 * Wichtig!
			 * 
			 * Instanzmethode xxxValue(), die den primitiven 
			 * Wert liefert
			 */
			byte v11 = v1.byteValue();		// manuelles UnBoxing  () nicht nötig 
			byte v1111 = v1;		//  // AutounBoxing 
			double v22 = v2.doubleValue();
			boolean v33 = v3.booleanValue();

			
			/*
			 * statische parsende Methoden
			 * 
			 * parseXxx(String)		<- liefert primitiven Wert zurück
			 * valueOf(String)		<- liefert Wrapper-Klassen-Referenz zurück
			 */
			
			int 	x = Integer.parseInt("34");
			Integer y = Integer.valueOf("34"); 
			
			/*
			 * Es gibt viele andere Methoden in der Wrapper-Klassen
			 * (aber zu viele um sie für die Prüfung zu lernen)
			 */
			int max = Integer.max(12, -333);
			System.out.println("max = " + max);
			//...
			
			char c = 'v';
			Character ch = c; 
			
			/*
			 * 	Hinweis : 
			 * 
			 * Da die Klassen Byte , Short , Long , Integer , Float und Double 
			 * von der Klasse Number erben , haben sie alle die Methoden 
			 * 
			 *  6 ---Value
			 * byteValue
			 * shortValue
			 * intValue
			 * longValue
			 * floatValue
			 * doubleValue
			 * 
			 */
			Double n ; 
		
//			n = Integer.valueOf(12);   // muss nicht Casting ( double breite als int)  : Implizit
//			n = Integer.valueOf("12"); 
			
			n = Double.valueOf(12);
			n = Double.valueOf("12.5");
			
			Short s = Short.valueOf((short) 12); // muss  Casting ( short enge als int)  : explizit		
			Integer i = Integer.valueOf((int) 12.5); // muss down-Casting ( int enge als double)  : explizit		
			
			s.byteValue();
			s.shortValue();
			s.intValue();
	}

}
