package exeptions;

import java.io.IOException;

public class B09_Rethrow_Regeln {

	/*
	 * 	try-Block-Analyse : Der Compiler analysiert 
	 *  den try-Block und sammelt die Liste aller möglichen
	 *  cheked Exceptions.
	 *  
	 *  Diese Info (solange sie noch gültig ist) verwendet
	 *  der Compiler für die weiteren Entscheidungen
	 */
	public static void main(String[] args) {
		

	}
	
	static void m1() {
		RuntimeException e = new ArithmeticException();
		throw e; // ok : compiler : e hat den unchecked Typ
	}
	
	static void m2() {
		Exception e = new ArithmeticException();
//		throw e; // cf :  e hat den CHECKED Typ (Der  Referenz-Typ ist eine check Exception  )
		
		/*
		 * ตัวแปร e มีประเภทเป็น Exception (ซึ่งเป็น Checked Exception) 
		 * แม้ e จะชี้ไปที่ ArithmeticException แต่ตัวแปรมีชนิดเป็น Exception 
		 * ซึ่งทำให้ตัวโปรแกรมแจ้งเตือนเนื่องจาก Checked Exceptions 
		 * จำเป็นต้องใช้ throws หรือจัดการกับข้อยกเว้นในบล็อก try-catch
		 */
	}

	static void m3() throws Exception {
		try {
			
		} catch (Exception e) {
			throw e;	// rethrow! Es kompilert
						// Nach der try-Analyse ist bekannt , 
						// dass e keine checked-Exception referenziert
		}
	}
	
	static void m4() throws IOException {
		Exception e = new IOException();
//		throw e;	// cf : e hat den Typ Exeption - Basistyp für ALLE checked Exception
					// Unhandled exception type Exception
		/*
		 * ประเภทของ e: ตัวแปร e ถูกประกาศเป็น Exception ซึ่งครอบคลุม Checked Exception ทุกประเภท 
		 * แม้ว่าจะถูกสร้างด้วย new IOException() ก็ตาม เนื่องจาก m4() ประกาศแค่ throws IOException 
		 * คอมไพเลอร์ไม่ถือว่า Exception ได้รับการจัดการทั้งหมด ทำให้เกิดข้อผิดพลาด "Unhandled exception type Exception"
		 */
	}
	
	static void m5() {
		try {
			throw new IOException();
		} catch (Exception e) {
//			throw e ;   // cf : bei rethrow : e kann IOException sein (try-Analyse)
						// Unhandled exception type IOException
		}
		/*
		 * IOException สืบทอดมาจาก Exception ดังนั้นจึงสามารถจับข้อยกเว้นได้ตามปกติ
		 * แต่ในบล็อก catch เมื่อทำ throw e; อีกครั้ง คอมไพเลอร์จะเตือนว่า e อาจเป็น IOException
		 * ซึ่งเป็น Checked Exception และไม่สามารถ rethrow ได้โดยตรง
		 */
	}
	
	static void m6() throws IOException {
		try {
			throw new IOException();
		} catch (Exception e) {
			throw e ;    // rethrow! Es kompilert
						 // e kann IOException sein (try-Analyse)
		}
		/*
		 * ในเมธอดนี้มีการประกาศ throws IOException ไว้ในหัวเมธอดล่วงหน้า
		 * ใน try มีการ throw ข้อยกเว้น IOException โดยตรง ซึ่งจะถูกจับในบล็อก catch ด้วย Exception e
		 * เมื่อ throw e; ในบล็อก catch ไม่มีปัญหา เนื่องจากเมธอดนี้ได้ประกาศ throws IOException ไว้แล้ว คอมไพเลอร์จึงยอมรับได้
		 */

	}
	/*
	 * Achtung! Die Zuweisung der der catch-Variable löscht die
	 * try-Block-Analyse-Ergebnisse! 
	 */
	static void m7()  {
		try {
			
		} catch (Exception e) {
			e = new ArithmeticException();	// löscht die Info der try-Analyse
			
//			throw e;  // cf :  e hat den CHECKED Typ (Der  Referenz-Typ ist eine check Exception  )
		}
		/*
		 * try-catch โดยจับข้อยกเว้น Exception ไว้ในตัวแปร e
		 * หากทำ throw e; หลังการเปลี่ยนแปลงค่า e คอมไพเลอร์จะแจ้งเตือน เพราะมองว่า e เป็น Checked Exception ที่ไม่ได้จัดการอีกแล้ว
		 * การเปลี่ยนค่า e ทำให้คอมไพเลอร์มองว่า e เป็น Checked Exception และการโยนใหม่จึงทำให้เกิดข้อผิดพลาด
		 */
	}
	


	
	static void m8()  {
		try {
			someMethod();
		} catch (IOException e) {
//			throw e ;     // cf : bei rethrow : e kann IOException sein (try-Analyse)
						  // Unhandled exception type IOException 
		}
		/*
		 * someMethod() ประกาศ throws IOException ซึ่งหมายความว่าอาจโยนข้อยกเว้น IOException
		 * ในบล็อก catch จับ IOException ใน catch (IOException e) แต่เมื่อทำ throw e; 
		 * คอมไพเลอร์จะเตือนว่า IOException ไม่ได้ถูกจัดการที่หัวเมธอด
		 * 
		 * สรุป: การจัดการ Checked Exception ของ IOException จำเป็นต้องประกาศ throws IOException เพิ่มในหัวเมธอด
		 */
	}
	

	static void someMethod() throws IOException{} // ok 
	

}
