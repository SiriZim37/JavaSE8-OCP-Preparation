package wrapper;

import java.util.ArrayList;

public class B01_AlleWrapperKlassen {

	/*
	 *	Jede Wrapper-Klasse : 
	 *	
	 *		- hat intern das primitive Attribut value ensprechendem Typ
	 *		- ist immutable
	 *		- haben Autoboxing und Autoboxing
	 *		- haben parsende Methoden (außer Character)
	 *
	 * Byte , Short , Integer , Long , Float und Double
	 * 	
	 * 		- haben gemeinsame abstrakte Basisklasse Number
	 * 
	 * Byte , Short , Integer , Long (und auch Character)
	 * 
	 * 		- haben eigene Konstanten-Pools 
	 */
	
	public static void main(String[] args) {

		/*
		 * 	Vorteil der Wrapper-Klassen : 
		 * ArrayList ( und andere generische Typen können)
		 * mit diesen Txpen verwendet werden
		 * (abernicht mit primitiven Typen)
		 * 
		 *  Es gibt kein ArrayList für primitiven Typen
		 */
		
//		ArrayList<int> listA  
		ArrayList<Integer> lisB;  
		ArrayList<Double> listC; 
		
		
		/*
		 *  Alle Wrapper-Klassen  : 
		 */
		Byte v1 ;
		Short v2 ;
		Integer v3 =  Integer.valueOf("+22");	// parsen
		Long v4;
		Float v5;
		Double v6 = 12.3; // Autoboxing  >> same like: Double v6 = Double.valueOf(12.3);
						// Double v6 = 12.3;, Java automatically converts (or boxes) 
						// the primitive double value 12.3 into an instance of the Double class.
		Boolean v7 =  Boolean.valueOf("true");
		
		Character v8 = 'a'; // Autoboxing  >> same like: Character v8 = Character.valueOf('a');
		
		

	}

}
