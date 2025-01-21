package exeptions;

public class B05_Multicatch_Reglen {

	public static void main(String[] args) {

	/*
	 * 	Achtung! Nur Geschwisterklassen-Exceptions in einem Multicatch!
	 */
		
//		try {
//			
//		} catch (RuntimeException | Exception e) {		// cf 
//			
//		}
		
		try {		
		} catch (ArithmeticException | NullPointerException  | IllegalArgumentException e) {
		}
		
		
		/*
		 * Achtung! NUr eine Variable in einem Multicatch! 
		 */
		
		try {		
		} catch (NullPointerException  | ArithmeticException e) {
		}
		
//		try {		
//		} catch (NullPointerException  e1 | ArithmeticException e2) { 	  // cf 
//		}	
	
//		try {			
//		} catch (NullPointerException  e1 | ArithmeticException e2) {	  // cf 		
//		}
		
		/*
		 *  Achtung! Die Multicathc-Variable muss 'effectively final' bleiben
		 */
	
		/*
		 * กรณีที่มี Exception เพียงตัวเดียวในบล็อก catch
		 * ในกรณีนี้ ตัวแปร e (เช่น Exception e) จะเป็นตัวแปรบล็อกปกติ ซึ่งหมายความว่าคุณสามารถกำหนดค่าใหม่ให้ e ได้ โดยสามารถทำให้ e = null; ได้โดยไม่มีปัญหาใด ๆ
		 */
		try {
			
		} catch (Exception e) {
			e = null;  // ok , normale Blockvariable
		}
		
		
		/*
		 * กรณีที่มี Multi-Catch (ใช้ | เพื่อตรวจจับข้อยกเว้นหลายประเภท)
		 * เมื่อใช้ Multi-Catch เช่น catch (ArithmeticException | NullPointerException e) 
		 * ตัวแปร e จะต้องคงสถานะ 'effectively final' ซึ่งหมายความว่าคุณไม่สามารถกำหนดค่าใหม่ให้กับ e ได้
		 * หลังจากที่ประกาศในบล็อก catch ดังนั้น การเขียน e = null; 
		 * จะทำให้เกิดข้อผิดพลาดในการคอมไพล์ เนื่องจากตัวแปร Multi-Catch ถูกบังคับให้เป็นตัวแปรที่ไม่สามารถกำหนดค่าใหม่ได้ 
		 * (เพราะต้องรองรับข้อยกเว้นหลายประเภทที่รวมอยู่ในบล็อกเดียว)
		 */
		try {
			
		} catch (ArithmeticException | NullPointerException e) {
//			e = null; // cf : muss 'effectively final' bleiben
		}
		


	}

}
