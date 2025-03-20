package exceptions.wdh;

import java.io.FileNotFoundException;
import java.io.IOException;


/*
 * 2. Unchecked Exceptions (ไม่ต้องตรวจสอบ):
	  Unchecked Exceptions (เช่น RuntimeException หรือ NullPointerException) ไม่มีกฎบังคับสำหรับการ override
		- เมธอดที่ override สามารถโยน หรือไม่โยน Unchecked Exceptions ก็ได้
		
		- Exception ใหม่หรือที่กว้างกว่าก็ไม่ผิด
 */
class Parent2 {
//    void method() throws RuntimeException { } 	// ok variante 1  
    void method() {}							// ok variante2 
}

class Child4 extends Parent2 {
    @Override
    void method() throws RuntimeException { } // ได้
}
class Child5 extends Parent2 {
    @Override
    void method() throws NumberFormatException { } // ได้
}
class Child6 extends Parent2 {
    @Override
    void method() throws ArithmeticException { } // ได้
}


/*
 * 
	กฎเกี่ยวกับการ override เมธอดและ Exception ใน Java OCA (ภาษาไทย)
	ในการ override เมธอดใน Java (ซึ่งเป็นส่วนหนึ่งของ Java OCA Exam) มีกฎที่เกี่ยวข้องกับการจัดการ Exception ดังนี้:
	
	1. Checked Exceptions (ตรวจสอบได้):
	
		หากเมธอดในคลาสพาเรนต์โยน Checked Exception (เช่น IOException หรือ SQLException):
		
		-  เมธอดที่ override ในคลาสลูก ต้องไม่โยน Checked Exception ใหม่ ที่กว้างกว่าหรือไม่เกี่ยวข้องกับ Exception ที่ประกาศไว้ในคลาสพาเรนต์
	
		- สามารถโยน Checked Exception ที่แคบกว่าหรือย่อยกว่าได้ (subclass ของ Exception ที่ประกาศไว้)
	
		- ถ้าเมธอดในพาเรนต์ไม่มี Checked Exception เมธอดลูกก็ต้องไม่มี Checked Exception เช่นกัน
 */

abstract class Parent {
    void method() throws IOException { }
}
class Child1 extends Parent {
    // โยน IOException (หรือ subclass เช่น FileNotFoundException) ได้
    @Override
    void method() throws FileNotFoundException { }  
}
class Child2 extends Parent {
    // ไม่โยน Exception ก็ได้
    @Override
    void method() { } 
}
class Child3 extends Parent {    
    // ไม่ได้! เพราะ Exception กว้างกว่า (Compile-Time Error)
//    @Override
//    void method() throws Exception { }		: cf
}

//--------------------------------------------------------------------------------------------//

class FahrrenException extends Exception{}
class BremsenException extends FahrrenException{}

abstract class Auto {
	abstract void fahren() throws FahrrenException; 
}

class VW extends Auto{
	void fahren() { }
}

// Kovariante 
class Opel extends Auto{
	void fahren() throws RuntimeException {} 
}

class Audi extends Auto{
	void fahren() throws FahrrenException {} 
}

class Mazda extends Auto{
	void fahren() throws BremsenException {} // die Vererbung-Linie 
}

//class Mercedes extends Auto{ 
//	void fahren() throws Exception {}	// cf : Basistype-checked-Exception 
										// (Es ist nicht erlaubt, eine breitere (superclass) Ausnahme zu werfen,
										// wie z.B. Exception.)
//}

//class Fiat extends Auto{
//	void fahren() throws IOException {} //  cf : Geschwisterklasse-checked-Exception 
										// ( FahrrenException , IOException Gescwister-checked-Klasse )
										// Ungültig, weil IOException keine Unterklasse von FahrrenException ist.
//}


public class B10_UeberschreibenUndCheckedExceptions {

	public static void main(String[] args) {

	/*	Drei Regeln beim Überschreiben :
	 * 
	 * 1. Sichtbarkei nicht verschärfen 
	 * 2. Üuckgabetyp nicht ändern
	 * 3. Keine zusätlichen checked Exceptions deklarieren : 
	 * 		- keine checked Exceptions vom Basistyp 
	 * 		- keine Geschwisterklasse-checked-Exceptions
	 */

	}

}
