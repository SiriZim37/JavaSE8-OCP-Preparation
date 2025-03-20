package vererbung;


class C1{
	/*
	 *  C1 hat den default-Konstruktor ( generiert vom Compiler ) :
	 *  
	 * 	C1() {
	 * 		super();
	 * 	}
	 */
	
}
class C2{
	/*
	 * C2 hat keinen default-Konstruktor , sondern 
	 * den expliziten Konstruktor : 
	 */
	C2(){
//		super();  // <--- generiert vom Compiler. 
	}
}

class C3{
	C3(){
		super();
	}
}


class C4{
	int x ; 
	/*
	 *  C4 hat den default-Konstruktor (geneiert vom Compiler) :
	 *   
	 *  C4(){
	 *		super();
	 *		this.x = 0 ; // Attribute werden initialsiert
	 *	}
	 */
	
}

class C5{
	int x = 42 ; 
	int y; 
	/*
	 *  C4 hat den default-Konstruktor (geneiert vom Compiler) :
	 *   
	 *  C5(){
	 *		super();
	 *		this.x = 42 
	 *		this.y = 0 ; // Attribute werden initialsiert
	 *	}
	 */
	
}

class C6{
	int x  ; 

	   C6(){
//	 		super(); <- generiet vom Compiler
//	 		this.x = 0 ; // Attribute werden initialsiert
	 	}
	
}

class C7{
	int x;
	
	   C7(){
//	 		super(); <- generiet vom Compiler
	 		this.x = 0 ; // Attribute werden initialsiert
	 	}
}

class C8{
	int x;
	
	   C8(){
//	 		super(); <- generiet vom Compiler
//	 		this.x = 0 ; // Attribute werden initialsiert
		   System.out.println(x);  // 42
	 	}
}


class B1{
	
	B1(int x) {}
	
}


//class D1 extends B1{  //Es kann nicht weil B1 hat kein default Konstruktur
//	int x ;
//	D1() {
//		
//		super(x) ; //cf : x ist noch nicht initialisiert.
//	}	
//}


class D2 extends B1 {	// ok
    int x = 42;

    D2(int x) {
        super(x); // Pass the initialized value of x to the base class constructor
    }
}


class C9 { 
	int x ;
	C9() {
		// 	super(); <- generiet vom Compiler
		// 	this.x = 0 ; // Attribute werden initialsiert
	}	
	C9(int x) {
		// 	super(); <- generiet vom Compiler
		// 	this.x = 0 ; // Attribute werden initialsiert
	}
	C9(String x) {
		// 	super(); <- generiet vom Compiler
		 	this.x = 42 ; 
	}
	C9(short x) {
		 	super(); 
//		 	this.x = 0 ;  <- generiet vom Compiler
	}
}

class C10 {  
	int x ;
	
	C10(){        // - Alle Attribute werden nach dem super-Konstruktor-Aufruf  initialisiert
		this(42);  // Es ist ein Aufruf vom C10(int x){this.x = x  }
	}
	
	C10(int x){
//	 	super(); <- generiet vom Compiler
		this.x = x ;
	}
	C10(String x){  // Der erste Aufruf in jedem Konstruktor ist  der Aufruf eines anderen Konstruktors.
		this();   // Es ist ein Aufruf vom C10(){ this(42); }
	}
	
}


public class B05_KonstruktorenBeiVererbung {

	/*
	 * - Konstruktoren werden nicht vererbt !! 
	 * 
	 * - Wenn die Klasse keine expliziten Konstruktor hat ,
	 *	 generiert der Compiler den default-Konstruktor
	 * 
	 * - Der Compiler sorgt dafür , dass jeder Konstruktor
	 * 	 vollständigt ist :
	 * 
	 * 		- Der erste Aufruf in jedem Konstruktor ist 
	 * 		  der Aufruf eines anderen Konstruktors. (mit 'this' oder 'super')
	 * 
	 * 		- Alle Attribute werden nach dem super-Konstruktor-Aufruf
	 *     initialisiert
	 */

	public static void main(String[] args) {


	}

}
