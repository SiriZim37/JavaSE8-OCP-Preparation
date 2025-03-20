package variablen;

public class Literale {

	/*
	 *  Literale (Constant value) : Zeichnenkombination, die der Compiler als ein wort erkennt
	 */
	public static void main(String[] args) {

		/*
		 *  int-Literale
		 *  cf = compile failer
		 */
		//Here 123 is a constant/literal.  32 bit von 123 wurde bit zu bit zu x1 vorgeladert.	
		int x1 = 123;  // dezimal ( Es gibt 10 zeichen )
		int x2 = 071;   // octal  (Octal : Es gibt 8 Zeichen   > Prefix 0 )
//	 	int x3 = 081; //The literal 08 of type int is out of range 
		System.out.println("x2 = " + x2); // wird in dezimal verwandelt und ausgegeben.
		
		int x3 = 0xAbc123; // hexadezimal (Octal : Es gibt 16 Zeichen > Prefix können klein oder groß schreiben 0x oder 0X)
		System.out.println("x3 = " + x3); // wird in dezimal verwandelt und ausgegeben.

		int x4 = 0b01010101;  // binär ( Präfix 0b oder 08)
		System.out.println("x4 = " + x4); // wird in dezimal verwandelt und ausgegeben.
		/*
		 *  	+ und  -  
		 */
		int x5 = 12;
		int x6 = +12;
		int x7 = -12;
		
		/*
		 *	_als Hilfe beim Lesen 
		 */
		
		int x8 = 1000000;
		int x9 = 1_000_000;
		
		/*
		 *  Exam :
		 */
//		int x10 = _10;	// cf : Unterstrich vorne
//		int x11 = 10_;	// cf : Unterstrich vorne
		int x12 = 1_0;
		int x13 = 1___0;
		
		System.out.println("x1 = " + x1);
		System.out.println("x2 = " + x2);
		System.out.println("x3 = " + x3);
		System.out.println("x4 = " + x4);
		System.out.println("x5 = " + x5);
		System.out.println("x6 = " + x6);
		System.out.println("x7 = " + x7);
		System.out.println("x8 = " + x8);
		System.out.println("x9 = " + x9);
//		System.out.println("x10 = " + x10);
//		System.out.println("x11 = " + x11);
		System.out.println("x12 = " + x12);
		System.out.println("x13 = " + x13);
		
		
		/*
		 * 
		 * 	long - Literale
		 * 
		 */
		long x14 = 3_000_000_000L;	// Suffix L oder l am Ende > es wird failer compiler
									// when es ohne L am Ende // 3_000_000_000 ist int.
		long x15 = 3L;
		System.out.println("x14 = " + x14);  	// x14 = 3000000000
		System.out.println("x15 = " + x15);		// x15 = 3
		
		/*
		 * 
		 * 	float - Literale
		 * 
		 */
		float f1 = 12f; //Suffix F oder f
		float f2 = 12.3f; 
		System.out.println("f1 = " + f1);  	// f1 = 12.0
		System.out.println("f2 = " + f2);  	// f2 = 12.3

		/*
		 * 
		 * 	double - Literale
		 * 
		 */
		double d1 = 12.0;   // Wenn es onhe d oder D , muss .0 schreiben
		double d2 = 12d;    // Suffix d oder D	
		double d3 = 2e3;    // Wissenschafliche Notation : 2.0 * ( 10 hoch 3)
		System.out.println("d3 = " + d3); //2000.0
		
		double d4 = -3E-2;	//-0.03   ( -3.0 * (10 hoch -2)) -3E0 = -3.0 , -3E1 = -30.0 , -3E2 = -300.0 , -3E-2 -0.03
		System.out.println("d4 = "+ d4);

		double d0 = 12	;	// int-Literal wird vom Compiler in 2.0 verwandelt ( implizites Casting)
		double d7 = 7. ; 	// 7.0
		double d8 = .7 ; 	// 0.7
//		double d8 = . ; 	//  cf
		System.out.println("d7 = " + d7);
		System.out.println("d8 = " + d8);
		/*
		 *  char-Literale
		 */
		char ch1 = 'a';		// oder char ch1 = 97;	// Zahl 97 is a  --- UNICODE !!! ch1 = a 
		System.out.println("ch1 = "+ ch1); 
		char ch2 = '\uA1B2'; 	// Das ist kein String !! Kann man in Unicode sehen!
		System.out.println("ch2 = "+ ch2); // 	ch2 = ꆲ
		char ch3 = 'Ƣ';
		System.out.println("ch3 = " + ch3);
//		 char ch4 = 'moin'; // cf: sollte mit Backslash u starten und danach einen hexadezimalen Wert haben  
		
		/*
		 *  boolean-Literale
		 * 
		 */
		boolean b1 = true;
		boolean b2 = false; 
		boolean b3 = b1; 
		
	}

}
