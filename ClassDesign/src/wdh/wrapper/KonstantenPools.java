package wdh.wrapper;

public class KonstantenPools {

	/*
	 * Autoboxing : der vom Compiler generierter Aufruf der 
	 * statischen Methode ValueOf dort , wo eine Referenz
	 * benötogt wird , aber ein primitiver Wert steht.
	 * 
	 * Für Byte , Short , Integer , Long haben eigene Konstanten Pools.
	 * 
	 * 	Z.B für die Klaase Integer
	 * 
	 * Wenn die Integer.valueOf(int) aufgerugen wird , 
	 * liefert sie die Integer-Referenz aus dem Integer-Pool , dem Bereich[-128...127] ist.
	 * Ansonsten erzeugt die Methode ein neues Integer Objekt.
	 * 
	 * Integer-Pool ist ein Array mit Integer für die Werte [-128...127]
	 */
	
	public static void main(String[] args) {

		Integer x1 = 12 ;
		Integer x2 = 12 ;
		System.out.println("x1 == x2 : " + (x1 == x2)); // true ( Integer -128 to 127 )
		
		Integer x3 = Integer.valueOf(12);	// manuelles Boxing
		System.out.println("x1 == x3 : " + (x1 == x3));	// true (Autiunboxing int -128 to 127  )

		
		Integer y1 = 1200 ; // Integer.valueOf(1200); >>> 1 Integer Pool im Heap and 1 Integer Objekt
		Integer y2 = 1200 ; // Integer.valueOf(1200); >>> 1 Integer Pool im Heap and 1 Integer Objekt
		
		System.out.println("y1 == y2 : " + (y1 == y2));	// false
		
		Integer x4 = new Integer(1200) ; // Integer.valueOf(1200);	>>>  1 Integer Objekt
		Integer x5 = 1200 ; 
		
		System.out.println("x4 == x5 : " + (x4 == x5));	// false


		
		
	}

}
