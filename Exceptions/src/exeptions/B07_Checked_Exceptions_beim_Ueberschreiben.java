package exeptions;

import java.io.IOException;
import java.util.function.Predicate;

//interface Predicate<T>{
//boolean test(T t);
//}

class MyPredicate implements Predicate<String>{
	
// predicate ไม่สามารถโยนข้อยกเว้น (checked exceptions) เช่น IOException ได้ เพราะมันไม่ได้ประกาศไว้ในอินเตอร์เฟซ Predicate
//	public boolean test(String s) throws IOException { 	// compiler fehler
//		return true;
//	}
	
	public boolean test(String s) throws ArithmeticException , NullPointerException { // Uncheked ok :  test method muss public
		return true;
	}
}
/*
 * Example 1 
 */

class FahrenException extends Exception{}			// FahrenException เป็น checked exception เพราะมันสืบทอดมาจาก Exception.
class BremsenException extends FahrenException{}	// BremsenException เป็น checked exception เช่นกัน เพราะมันสืบทอดมาจาก FahrenException.

class Auto {
	void fahren() throws FahrenException{}			// Methode fahren ในคลาส Auto ประกาศว่าอาจจะโยน FahrenException ซึ่งเป็น checked exception.
													// ดังนั้นเมื่อเราสร้างคลาสลูกที่สืบทอดจาก Auto จะต้องจัดการกับข้อยกเว้นนี้ตามกฎของ Inheritance.
}

class VW extends Auto {
//	void fahren() throws IOException{}				// cf  : andere checked : Geschwisterklasse - checked
//	void fahren() throws Exception{}				// cf  : andere checked : Basisklasse
	
//	void fahren() throws ArithmeticException{}		// ok :   keine zusätzlichen checked Exeptions deklarieren
//	void fahren() throws NumberFormatException{}	// ok :   keine zusätzlichen checked Exeptions deklarieren
//	void fahren() throws IllegalArgumentException{}	// ok :   keine zusätzlichen checked Exeptions deklariere
//	void fahren() throws RuntimeException{}			// ok :   keine zusätzlichen checked Exeptions deklariere
	
	/*
	 * กฎการ override เมธอด:
	 * เมื่อคุณ override เมธอดจากคลาสแม่ (เช่น Auto), คุณต้องรักษากฎเกี่ยวกับข้อยกเว้น:
	 * หากคลาสแม่โยน checked exceptions (เช่น FahrenException), คุณสามารถโยน checked exception เดียวกัน หรือ ลูกของมัน ในคลาสลูกได้.
	 * แต่ถ้าเมธอดในคลาสลูกโยน unchecked exception (เช่น RuntimeException), คุณไม่จำเป็นต้องประกาศ throws หรือจัดการใน try-catch เพราะมันเป็น unchecked exception.
	 */
	
	
	void fahren() throws FahrenException{} 			// ok :   keine zusätzlichen checked Exeptions deklariere
	
	/*
	 * เมธอด fahren ใน VW สามารถประกาศโยน FahrenException ได้เหมือนในคลาส Auto 
	 * เพราะมันสืบทอดจาก Auto และข้อยกเว้นที่โยนในเมธอดต้องไม่รุนแรงกว่าที่ประกาศในคลาสแม่.
	 * 
	 * ไม่สามารถโยน IOException หรือ Exception ได้ เนื่องจาก
	 * เป็น checked exceptions ที่รุนแรงกว่าที่ประกาศใน Auto.
	 */
}

class Mercedes extends Auto {
	void fahren() throws BremsenException{} 		// ok :   keine zusätzlichen checked Exeptions deklariere
}

class Mazda extends Auto {
	void fahren() throws RuntimeException{}			// ok, unchecked 
}






public class B07_Checked_Exceptions_beim_Ueberschreiben {

	/*
	 * Reglen beim Überschreiben/Implementieren : 
	 * 
	 * 1. Sichtbarkeit nicht verschärfen
	 * 2. Rückgabetyp nicht ändern
	 * 3. keine zusätzlichen checked Exceptions deklarieren:
	 * 		- keine Geschwisterklassen-checked-Exceptions
	 * 		- keine Basisklassen-checked-Exceptions
	 */
	public static void main(String[] args) {
	
		

	}

}
