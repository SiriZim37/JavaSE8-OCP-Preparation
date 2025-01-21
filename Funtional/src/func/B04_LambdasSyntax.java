package func;

public class B04_LambdasSyntax {

	static interface I1{
		void m1();
	}
	
	static interface I2{
		void m1(int x);
	}
	static interface I3{
		void m1(int x , String s);
	}
	public static void main(String[] args) {

		/*
		 * 
		 * 	Liste der Parameter : 
		 * 
		 * 		Vollständige (ausführlich) Notation 
		 * 		(wie in einer normalen java-Methode)
		 * 
		 */
		I1 v1 = () -> {};
		
		I2 v2 = (int n) ->{};		
		
		I3 v3 = (int n , String str) ->{};	
		
		/*
		 * 
		 * 	Liste der Parameter : 
		 * 
		 * 		Kompakte Notation
		 * 		- ohne Parameter-Typen
		 * 		- ohne der runden Klasmmer 
		 * 				- nur bei genau einem Parameter
		 * 				- Typ-Angabe muss auch weg
		 * 
		 */
		
		I2 v20 = n -> {};
		I2 v21 = (n) -> {};
		I2 v22 = (int n) -> {};
//		I2 v22 = int n -> {};				// cf
		
		I3 v30 = (n , str) -> {};
//		I3 v31 = (int n ,  str) -> {};		// cf 
//		I3 v32 = (n ,  String str) -> {};	// cf
		
		/*
		 * Methode Runpf (Körper)
		 * 
		 * 	Vollständige (ausführliche) Notation
		 * 	(wie in einer nrmalen Java-Methode)
		 */
		
//		I1 v100 = () -> {
//			return 5 ;   	//cf : ohne rückgabe
//		};
		
		I1 v101 = () -> {
			System.out.println("line1");		// rückgabe void()
			System.out.println("line2");		// rückgabe void()
		};
		
		I4 v4 = ()->{			
			return 42 ;   	// ok 			 	// rückgabe int()
		};

		/* Methode Rumpf (Körper)
		 * 
		 * 		Kompakte Notation
		 * 			- Ohne der geschwiften Klammer (wenn es nur eine Anweisung gibt)
		 * 			- Semikolon nach der Anweisung sollte auch weg
		 * 			- return muss auch weg (bei nicht-void-Anweisung)
		 * 
		 */
		I1  v50 = () -> {} ;	//  ausführliche , keine Anweisungen
//		I1  v51 = () ->  ;		//  cf: kompakte , keine Anweisungen
		
		I1  v52 = () -> System.out.println("mo"); ;		//  ok
		
		I4 v6 = () -> 42;
//		I4 v61 = () -> return 42; 		// cf
		
		doStuffI_1( ()->{ } );
		doStuff_I4( ()->{ return 42;} );
		doStuff_I4( ()->  42 );				
		
//		doStuff_I4( ()->{} );				// cf
//		doStuff_I4( ()-> return 42; );		// cf 
//		doStuff_I4( ()-> {return 42 });		// cf : ausführliche , Semikolon gehlt
//		doStuff_I4( ()->  42; );			// cf: kompakte , Semikolon nicht entfernt 

		
	} // end of main
	
	interface I4{
		int m();
	}
	
	static void doStuffI_1(I1 param) {	}
	static void doStuff_I4(I4 param) {	}
	

}
