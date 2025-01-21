package wdh.basics;

public class Inkrement {

	public static void main(String[] args) {
		
		int x = 0 ; 
		
		/*
		 * 	Inkrement ist delbst das Statement :
		 * 
		 * 	x wird um 1 erhöht
		 */
		x++ ; 
		
		/*
		 * Inkrement ist delbst das Statement/Expression , 
		 * wo die Variable an weiteren Operationen beteiligt wird. 
		 * 
		 *  Postinkrement : 
		 *  
		 *  	x für die näcste Operation lesen
		 *  	x inkrementieren 
		 *  	den davor gelesen Wert weiter verwenden
		 */
		int y = x++;
		
		System.out.println( x++ );	// 2
		System.out.println( x++ );	// 3

	}

}
