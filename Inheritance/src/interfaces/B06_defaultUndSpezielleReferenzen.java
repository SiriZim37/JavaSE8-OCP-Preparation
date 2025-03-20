package interfaces;

interface Lebewesen{
	default void laufen() { System.out.println("laufen aus Lebewesen.");}
}
interface Laufaehig{
	default void laufen() { System.out.println( "laufen aus Laufaehig.");}
	
	static void laufen2() { System.out.println( "laufen aus Laufaehig.");}
}


class Tier implements Lebewesen , Laufaehig{
	// Tier erbt die Methode laufen() aus dem Interface Lebewesen 
	
	// wenn 2 Interfaces Lebewesen , Laufaehig gibt ( wie B05)  muss selbst laufen() realisieren im Tier
	// คลาส Tier นำอินเทอร์เฟซ Lebewesen และ Laufaehig ไปใช้งาน
	// และต้องทำการ override เมท็อด laufen() เนื่องจากมี default method ซ้ำกันในทั้งสองอินเทอร์เฟซ
	public void laufen() { // überschreiben
		System.out.println("laufen aus Tier");
	}
	
	
	void testSpezielleReferenzen() {
		/*
		 * Mit speziellen Schlüßelwörten 'this' und 'super'
		 * kann man zwischen der überschreibenden Methode dieser Klasse 
		 * und der überschreiben Methoden der Baisisklasse unterscheiden : 
		 */
		/*
         * ด้วยการใช้คำสำคัญ this และ super
         * เราสามารถแยกแยะระหว่างเมท็อดที่ถูกเขียนทับในคลาสนี้
         * กับเมท็อดที่ถูกเขียนทับในคลาสฐาน (หรือในอินเทอร์เฟซ)
         */
		String s1 = super.toString(); 	// toString gerebt  aus dem Klasse Object 
										// เรียก toString() ที่ถูกสืบทอดจากคลาส Object 
		System.out.println(s1);			// interfaces.Tier@59f95c5d
		System.out.println("2*********");
		
		String s2 = this.toString(); 	 // toString aus Tier  เรียก toString() ที่เขียนทับใน Tier
		System.out.println(s2);			 // toString aus Tier
		System.out.println("3*********");
		
		String s3 = Tier.super.toString(); // เรียก toString() จาก Tier 
		System.out.println(s1);			 //interfaces.Tier@59f95c5d
	
		/*
		 * Mit speziellen Schlüßelwörten this und Basisinterfacename.super
		 * kann man zwischen der überschreibenden Methode dieser Klasse 
		 * und der überschreiben 'default-Methoden' der Baisisinterfaces unterscheiden : 
		 */
		/*
         * ด้วยคำสำคัญนี้ (super และ Basisinterfacename.super)
         * เราสามารถเรียกใช้เมท็อดจากอินเทอร์เฟซที่ถูกเขียนทับในคลาสฐาน
         */
		System.out.println("4*********");
		
//		super.laufen(); 	//cf : super soll die Methoden der Basisklasse  aktivieren
							// Es kann nicht mit super die Methode zugreifen.
		this.laufen();		// ok : laufen aus Tier ( Wenn kein laufen() Methode überschreiben , wird aus Lebewesen oder Laufaehig stattfinden. )		
	
		System.out.println("5*********");
		// man muss schreiben , aus welchem Interface will man aufrufen! 
		Lebewesen.super.laufen(); // laufen aus Lebewesen.
		Laufaehig.super.laufen(); // laufen aus Laufaehig.
	}
	

	public String toString() {
		return "toString aus Tier";
	}
	
}

public class B06_defaultUndSpezielleReferenzen implements Laufaehig{

	public static void main(String[] args) {

		new Tier().testSpezielleReferenzen();
		
		System.out.println("1*********");
		
		Lebewesen v1 = new Tier(); 
		v1.laufen(); // laufen aus Tier
		
		System.out.println("6*********");
		
		Laufaehig v2 = new Tier();
		v2.laufen(); // laufen aus Tier
		
		System.out.println("7*********");
		
		new B06_defaultUndSpezielleReferenzen().testRufinterface();
	}
	
	void testRufinterface() {
		Laufaehig.super.laufen();		 // เรียกเมท็อด default laufen() จากอินเทอร์เฟซ Laufaehig  > call not static 
		Laufaehig.laufen2();		    // เรียกเมท็อด laufen() จากอินเทอร์เฟซ Laufaehig  > call  static 
		this.laufen();					 // เรียกเมท็อด laufen() จากคลาสนี้
		laufen();						 // เรียกเมท็อด laufen() โดยตรง
	}
	
	public void laufen() {
		System.out.println("main laufen");
	}

}
