package strings;

import java.util.function.Predicate;

public class B08_StringBuilderAPI {

	public static void main(String[] args) {
		/*
		 * 	Exam : Viele alle Methoden der Klasse StringBuilder
		 * 		   liefern StringBuilder zurück
		 */

		String s = new StringBuilder("C++")	// C++
			.append("toll") 		// C++toll
			.insert(3, " war ")  	// C++ war toll
			.replace(4, 7, "ist") 	// C++ ist toll
			.toString();
		
		System.out.println("s : " + s );
	
		
		/*
		 * 	Exam : nicht alle Methoden der Klasse StringBuilder
		 * 		   liefern StringBuilder zurück
		 */

//		String s = new StringBuilder("C++")	// C++
//			.append("toll") 		// C++toll
//			.insert(3, " war ")  	// C++ war toll
//			.substring(0 , 7)		<- liefert String zurück
//			.append("!");			<- cf : String hat keine append-methode
	}

}
