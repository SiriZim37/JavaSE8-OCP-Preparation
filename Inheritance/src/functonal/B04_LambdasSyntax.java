package functonal;

interface MyInterfaceA{
	void m();
}

interface MyInterfaceB{
	void m( int x );	// interface mit genau parameter
}


interface MyInterfaceC{
	void m( int x , String y );
}
interface MyInterfaceD{
	int m();
}

public class B04_LambdasSyntax {


	public static void main(String[] args) {


	
		/*
		 * Lambda :
		 * 		Liste der parameter - > Rumpf
		 * 
		 */
			
		/*
		 * 	List der Parameter
		 *  Ausführliche Notation
		 * 
		 */
			
			
			MyInterfaceB v2 = (int param) -> {}; 
			MyInterfaceC v3 = (int a , String b) -> {}; 
			
		/*
		 * 	Liste der Parameter
		 *  Kompakte Notation
		 *  	
		 *  	- ohne Parameter-Typ (aber dann dei allen Parameter)
		 *  	- ohne runde Klammer 
		 *  			- aber nur für Methode genau einem Parameter
		 *  		    - und nur ohne Typ
		 *  
		 */
//		MyInterfaceA v1 =  -> {} ; 				    // cf : ohne runde Klammer geht nicht 

		MyInterfaceB v22 = (param) -> {}; 	// OK : Ohne parameter typ (Es hat genau ein parameter!)
		MyInterfaceB v221 = param -> {};
//		MyInterfaceB v222 = int param -> {};	    // cf : ohne runde Klammer geht nicht 
		
		MyInterfaceC v33 = (a,b) -> {};
//		MyInterfaceC v331 = (int a , b) -> {};	    // cf 
//		MyInterfaceC v332 = ( a , String b) -> {};	// cf 
//		MyInterfaceC v333 =  a ,  b -> {};			// cf : ohne runde Klammer geht nicht 
//		MyInterfaceC v334 =  a , String b -> {};	// cf : ohne runde Klammer geht nicht 
		
		
		/*
		 * Rumpf.
		 * 
		 * Ausfrühliche Notatin.
		 * 
		 */
		
		MyInterfaceA v4 = () -> {};
		MyInterfaceA v41 = () -> {  
			System.out.print("z1");
			System.out.print("z2");
			System.out.println("z3");
		};
//		Die Methode m (v41) wird nirgendwo aufgerufen.
		v41.m();  // Aufruf der Methode m()
		
		MyInterfaceD v5 = () -> {  
			return 42;
		};
		
		/*
		 *  Rumpf. 
		 *  
		 *  Kompakte Notation ( Ohne der gecshweiften Klammer) : 
		 *  
		 *   	- nur wenn der Rumpf aus einer einzigen Anweisung bestehen soll
		 *   	     - Dabei sollte (muss) der Semikolon auch weg!
		 *   	 	 - Wenn die einzige Anweisung im Rumpf die 
		 *   		   return-Anweisung ist, dann soll auch return weg.
		 */
		
//		MyInterfaceA v441 = ()  -> ;	cf 
		MyInterfaceA v442 = ()	-> {
			System.out.println("z1");
		};
		
		MyInterfaceA v443 = ()	-> System.out.println("z1");
		v443.m();
		
		MyInterfaceD v551 = () -> 42; 	// OK : return weg.
//		MyInterfaceD v551 = () -> return 42 ; 	// cf 
		
		
		/*
		 * 
		 *  Exam 1 :  
		 *  
		 */
		doStuff( ()-> { System.out.println("moin");} );	// ok 
//		doStuff(  ()->  System.out.println("moin"); ); 	// cf : semicolon muss auch weg
		doStuff(  ()->  System.out.println("moin") ); 	// ok
		/*
		 * 	Exam 2 : 
		 * 	Gegeben : 
		 * 
		 * 		interface MyInterfaceA{
		 * 			void m();
		 * 		}
		 * 
		 * und der Code aus der main : 
		 */
		MyInterfaceA ma = () -> 	
			System.out.print("mo "); 	// <- Anweisung aus der Methode m
			System.out.print("di ");	// <- Befehl aus main 
			System.out.print("mi ");	// <- Befehl aus main
		ma.m();
		/*
		 * was ist das Ergebnis ? 
		 * 
		 * A. di mi mo		// A is Richtig!
		 * b. mo di mi 			
		 * c. mo
		 * d. Compilerfehler
		 */
		
		/* Erklaren :
		 * 		
		 * 		MyInterfaceA ma = () ->  System.out.print("mo ");	#3 // Klammar fehlt	
		 * 		System.out.print("di ");	#1
		 * 		System.out.print("mi ");	#2
		 * 		ma.m();	 #3
		 * 
		 *	Result : di mi mo
		 */

		
		System.out.println("end of main");
	}

	
	// Prüfung! 
	static void doStuff (MyInterfaceA param) {
		//...
	}

}
