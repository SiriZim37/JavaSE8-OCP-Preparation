package generics;

import java.util.Comparator;

public class B07_PlatzhalterExam {

	public static void main(String[] args) {

		/*
		 * Number ist Basisklass für 
		 * 		Byte , 
		 * 		Short , 
		 * 		Integer , 
		 * 		Long , 
		 * 		Float  
		 * 		Double
		 */

		Comparator<? extends Number> cmpExtendsNum =null ; 
		Comparator<Number> cmpNum = null ; 
		Comparator<Integer> cmpInt = null; 
		
//		cmpNum = cmpExtendsNum; // cf ; aber bereits unwarscheinlich in der Prüfung 
		
		cmpExtendsNum = cmpNum; // ok : Number เป็น superclass ของ Number
	
//		cmpNum = cmpInt; // cf : Parameterisierung sind nicht gleich
		
		/*
		 * Unwahrscheinlich in der Prüfung ist 
		 * auch der folgende Compilerfehler :
		 */
		
//		cmpExtendsNum.compare(12, 13); // Referenz ist mit ' ? extends parameter
	}

}
