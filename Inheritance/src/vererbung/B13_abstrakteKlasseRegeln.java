package vererbung;

/*	PRÜFUNG!! 
 *   - abstrakte Klassen müssen keine abstrakte Methode haben.
 */
abstract class AC1{
	
}
/*
 * 	- abstrakte Klassen dürfen abstrakte Methoden haben.
 */

abstract class AC2{
	/*
	 *  - abstrkte Methoden dürfen keinen Ruumpf haben (ไม่มีเนื้อความ)
	 * 
	 */
	// abstract void m1(){}  	// cf : Rumpf darf nicht sein
	// abstract void m2(){}  	// cf : Semicolon felht
	
	abstract void m3();
	
	/*
	 * 	abstract + final Methode geht nicht!!
	 */
//	 abstract final void m4();
}

/*
 * 	abstract + final Klasse geht nicht !!!
 */
// abstract final class AC3{}


/*
 * 	- eine konkrete Klasse darf keine abstrakten Methoden haben
 */
class CC20 extends AC2{
	/*
	 *  - beim Realisieren einer abstrackten Methode gelten
	 *    dieselben Regeln wie beim Überschreiben.
	 */
	void m3() {}
}

//class CC21 extends AC2 {	// cf : abstrakte Methode nicht realisiert.
//	
//}

/*
 * 	- nochmal - eine abstrakte Klasse darf abstrakte Methoden haben
 */
abstract class CC22 extends AC2{

}

//class DD22 extends CC22 {		// cf : abstrakte Methode m3 nicht realisiert
//
//}
/*
 * 	- eine abstrakte Klasse darf alle Elemente
 * 	  haben , die jede konkrete Klasse haben darf.
 *  - eine abstrakte Klasse darf beliebig viele
 *    abstrakte Methoden haben.
 * 
 */

abstract class AC3{
	static int staticAtt;
	int x ; 
	AC3() {};
	AC3(int x){};
	
	static void m1() {}
	void m2() {}
	
	abstract void m3();
	abstract void m3(int x );
	
	abstract void m4();
	abstract void m5();
	abstract void m5(int x);
	abstract void m5(String x);
	abstract void m5(int x , int y);
	
}

class CC3 extends AC3{

	void m3() {}
	void m3(int x) {}
	void m4(){}
	void m5(){}
	void m5(int x){}
	void m5(String x){}
	 void m5(int x , int y){}
	
}

public class B13_abstrakteKlasseRegeln {

	public static void main(String[] args) {
		/*
		 * 	- keine neuen Objekte von abstrakten Klassen 
		 * 	  dürfen erstellt werden
		 */
		// new AC1();
		
		
		

	}

}
