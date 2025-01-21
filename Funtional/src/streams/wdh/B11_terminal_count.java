package streams.wdh;

import java.util.stream.Stream;

public class B11_terminal_count {

	/*
	 * long count();
	 */
	public static void main(String[] args) {


		/*
		 * Exam :
		 */
//		int c1 = Stream.of(1,2,3,4,5).count();  	// cf : 
		long c2 =  Stream.of(1,2,3,4,5).count(); 	// richtig ---> long count()
		
		/*
		 * 	In java 8 : count aktiviert die Piepline immer ? 
		 * In java 21 : count aktiviert die Piepline nut , wenn es wirklich nötig ist 
		 */

		/*
		 * Bsp. 2
		 */
		Stream.of(1,2,3,4,5 ,6)
				.map( x -> {
					System.out.println(x); 	// keine Ausgaben in Java 21
					return x +10 ;
				})
				.count();  // liefert count = 6 zurück ohne die Piepline zu aktivieren. 

		
		/*
		 * Bsp. 3
		 */
		Stream.of(1,2,3,4,5 ,6)
				.map( x -> {
					System.out.println(x); 	// Ausgaben
					return x +10 ;
				})
				.filter( x -> true) 		//  könnte die Anzahl der Elemente ändern
				.count();  
		/*
		 * .filter( x -> true)  kann die Piepline aktivieren mit diesem Code
		 */
		
		System.out.println("end of main");
			
	}

}
