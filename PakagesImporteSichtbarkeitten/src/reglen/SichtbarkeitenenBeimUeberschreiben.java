package reglen;



class Tier {
	public 		void m1(){};
	protected 	void m2(){};
				void m3(){};
	private  	void m4(){};	// wird nicht verebt und kann nicht überschreiben
}
	
/* Cannot reduce the visibility of the inherited method from Tier
 * cf : Sichtbarkeit verschärft
 */
class Hund extends Tier{
	public  	void m1(){};
	public 		void m2(){};
	public 		void m3(){};
	
	int m4() throws Exception {return 1 ; }	 // kein Überschreiben ( weil Andere RückgabeTyp ist.)
//	void m4() {}; // CF : Überschreiben Duplicate method m4() in type Hund
}

class Katze extends Tier{
//	protected 	void m1(){};  //  cf : Sichtbarkeit verschärft
	protected 	void m2(){};
	protected 	void m3(){};
}

class Elefant extends Tier{
//			void m1(){}; 	 //  cf : Sichtbarkeit verschärft
//	  		void m2(){};	 //  cf : Sichtbarkeit verschärft
	  		void m3(){};
}

class Affe extends Tier{
//	private  	void m1(){};	//  cf : Sichtbarkeit verschärft
//	private  	void m2(){};	//  cf : Sichtbarkeit verschärft
//	private  	void m3(){};	//  cf : Sichtbarkeit verschärft
}

public class SichtbarkeitenenBeimUeberschreiben {


	public static void main(String[] args) {
		/*
		 * Regeln beim Überschreinben : 
		 * 
		 * 	1. Sichtbarkeiten nicht verschärfen
		 *  2. Rückgabetyp nicht ändern
		 *  3. Keine zusätzlichen checked Exceptions deklarieren.
		 */
		
		
		

	}

}
