package vererbung;

class Base{
	 
//	Base() {}   // DriveA,B werden nicht kompliert 
			    // wenn in BaseBlass kein Default constructor hat
	 
	Base(int x) {}
}

/*
class DriveA extends Base {
	
	 // dfault-Constructor :
	 //
	 // 	DriveA(){
	 // 		super(); // cf : kein noargs-Konstruktor in der Basisklasse
	 // 	}
	 //
}

class DriveB extends Base {
	
	public DriveB() { // expliziten Konstruktor
		// super(); <- generiert vom Compiler (kompilert nicht )
	}
	
}

class DriveC extends Base {
	
	public DriveC() {   
		 super();  // cf : kein noargs-Konstruktor in der Basisklasse
	}
	
}
*/

/*
 *  DriveA , DriveB , Drive C können nicht compiliert ,
 *  weil Base Klass Expliziten Konstruktor hat , aber kein default Konstruktor
 * 
 *  Solve : 
 *  Alternative 1 : Base add Base() {} 
 *  Alternative 2 :  super(integer);  
 */

public class B06_KonstruktorenBeiVererbungExam {

	public static void main(String[] args) {
		

	}

}
