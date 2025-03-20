package wrapper;

public class WrapperTest {

	public static void main(String[] args) {
		// primitivie Variante
		int gewicht = 80 ; 
		// Objektvariante mit Wrapperklassen
		Integer gewichtAlsObjekt = new Integer(80);
		// Vor java 5 
		// Vermindern des Gewichts um 5
		int temp = gewichtAlsObjekt.intValue(); // int-Value extrahieren (unboxing), auspacken.
		temp = temp-5; // int um 5 vermindern
		gewichtAlsObjekt = new Integer(temp);	// int-Value in Objekt einpacken (boxing)
		System.out.println("gewichtAlsObjekt = " + gewichtAlsObjekt);
		// Seit Java 5 gibt es auto-boxing
		// Vermindern des Gewichts um 5
		gewichtAlsObjekt -=5 ;
		System.out.println("gewichtAlsObjekt = " + gewichtAlsObjekt);
		
		Integer intObj = new Integer("42,9");
//		System.out.println("intObj = "+ intObj) ; // ok but java.lang.NumberFormatException
		
		Integer intObj1 = 42 ; 
		Integer intObj2 = 42;
		//Integer-Pool als Speicherbereich für Integer-Objekte beimboxing (ähnlich dem String-Pool)
		System.out.println("intObj1 == intObj2) = "+ ( intObj1 == intObj2) ); // ture : 
																 
		Integer intObj3 = new Integer(42) ; 
		Integer intObj4 = new Integer(42);
		System.out.println("intObj3 == intObj4 = "+ ( intObj3 == intObj4) ); // false
		
		Integer intObj5 = 128 ; 
		Integer intObj6 = 128;
		//Integer-Pool gilt nur für Literale im Bereich 1 Byte , also von -18 bis 127  )
		System.out.println("intObj5 == intObj6 = "+ ( intObj5 == intObj6) ); // false
		
//		Double abObj = new Double("123.45"); // ok 
		Double abObj = new Double(123.45); // ok 
		System.out.println("abObj = "+ abObj  );
		
		Long longObj = new Long(8_123_456_789L);
		System.out.println("longObj = "+ longObj  );
		
		String gewichtAlsString = "75";
		gewicht = Integer.parseInt(gewichtAlsString);
		System.out.println("gewicht = "+ gewicht);
		
		gewichtAlsString = "75x5";
		gewicht = Integer.parseInt(gewichtAlsString);
		System.out.println("gewicht = "+ gewicht);  // ok but  java.lang.NumberFormatException
	}

}
