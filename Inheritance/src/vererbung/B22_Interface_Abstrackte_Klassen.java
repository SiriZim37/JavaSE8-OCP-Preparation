package vererbung;

interface InterOne{
	int X = 77 ;
	int C = 11 ;
	void doItOne();
	
//	int count(); // Compiler-Fehler: Methode mit der selben Signatur darf nicht anderen Rückgabetypen haben
}

interface InterTwo{
	 int X = 88 ;
	 int B = 12 ;
	 void doItTwo();
	 
//	 void count(); // Compiler-Fehler: Methode mit der selben Signatur darf nicht anderen Rückgabetypen haben
	 /* in der Klasse InterClassAbstract  : cf 
	  * The return types are incompatible for the inherited methods InterOne.count(), InterTwo.count()
	  */

}

/* eine abstrakte Klasse , die ein oder mehrere Interfaces implementiert , 
* MUSS abstrakten Methoden nicht implimentieren
* 
* Die erste nicht-abstrkte Klasse , die die abstrkte Klasse erweitert ,
* MUSS dann die Methoden  implimentieren
*/


abstract class InterClassAbstract implements InterOne , InterTwo {
	
	int Z = 77 ;
	
	public void doItOne() {
		System.out.println("do it 1");
	}
	
	public abstract void doItTwo();	 // <--- A
	
	public abstract void doItThree();	  // <--- B
	
	public abstract void printX();
	
	void getPower() {
		System.out.println("TTT"); // ok 
	}
	
}


class InterClassTest extends InterClassAbstract implements InterOne , InterTwo {

	public void printX() {
//		System.out.println("X = " + X); // cf :  The field X is ambiguous , wenn InterOne & InterTwo haben X geht nicht 
		System.out.println("C = " + C); // ok 
		System.out.println("B = " + B); // ok 
		
		System.out.println("X = " + InterOne.X); 
		System.out.println("X = " + InterTwo.X);
		
	}

	// Die erste nicht-abstrkte Klasse , die die abstrkte Klasse erweitert ,
	// MUSS dann die Methoden  implimentieren
	
	public void doItOne() {
		System.out.println("do it 11");
	}
	// --- A
	@Override
	public void doItTwo() {	
		System.out.println("do it 2");
	} 
	//--- B
	@Override
	public void doItThree() {
		System.out.println("do it 3");
	}

	

	
}

public class B22_Interface_Abstrackte_Klassen  {

	
	public static void main(String[] args) {
	
		InterClassAbstract ica = new InterClassTest();
		ica.printX(); 
		ica.getPower(); 
		
	
	}


}
