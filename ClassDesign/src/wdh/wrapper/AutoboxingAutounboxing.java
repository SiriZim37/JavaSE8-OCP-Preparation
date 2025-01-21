package wdh.wrapper;

public class AutoboxingAutounboxing {

	public static void main(String[] args) {
		/*
		 * Autoboxing : der vom Compiler generierter Aufruf der 
		 * statischen Methode ValueOf dort , wo eine Referenz
		 * benötogt wird , aber ein primitiver Wert steht.
		 */
		
		Boolean v0 = Boolean.valueOf(true);	// manuelles Boxing, nicht empfohlen
		Boolean v1 = true ; 				// Autoboxing ,kompakt und schön
		
		System.out.println("v0 == v1 :" + (v0==v1));   // true
		
		/*
		 * Autounboxing : der vom Compiler genereiter Aufruf 
		 * der Instanzmethode xxxValue(), wo ein primitiver
		 * Wert benötigt wird, aber eine Wrapper-Klassen-Referenz steht
		 */
		
		boolean v3 = v1.booleanValue(); // manuelles Unboxen, nicht empfohlen
		boolean v4 = v1;	// Autounboxing
		
		System.out.println("v3 == v4 :" + (v3==v4));   // true
		
		/*
		 * Exam. Wenn die Opearatoren verwendet werden,
		 * überlegen Sie , ob es diese Operatoren für referenzen gibt
		 */
		
		Integer x = 12;
		Double y = 12.0 ;
		float z = 12f;
		
		System.out.println( x > z ); 		// x.intValue() > z
		System.out.println( x < y );  		// x.intValue() < y.doubleValue()
		System.out.println( x == z );       // x.intValue() == z 
											// (Vergleich der primitiven Werte int und float)
		
		System.out.println( x == x ); 		// Referenzenvergleich
		System.out.println( x != x ); 		// Referenzenvergleich
//		System.out.println( x == y ); 		// cf : Integer und Double sind Geschwister  , Sie können nicht vergleich 
		

		/*
		 * Exam
		 */
		
		Integer n = null ;	
		int value = n;		// Autoboxing > // NullPointerException
		System.out.println(n); 
		
	}
	static Integer ref;

}
