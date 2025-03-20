package basic;

public class Zuweisung {

	public static void main(String[] args) {

//		System.out.println(int x = 3);	// cf  : Initialisierung liefert nicht zurück
		
		int y ; 
//		if(y==3) {  // y must initail	
//		}
		System.out.println( y = 3 );	// Zuweisung liefert den neuen Wert von y zurück
		
		System.out.println( y = 77 );
		
//		if(y=3) {	// cf : y = 3 liefert int zurück
//			
//		}
	
		boolean z = true ; 
		if( z = false ) { // unentdecker Bug : z = false liefert boolean zurück
			
		}
		
		System.out.println("z " + z );

	}

}
