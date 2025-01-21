package errors;



class Blume{
	static {
		System.out.println(5/0);	 // ArithmeticException
	}
	
	static int maxPreis = 33;
}

public class B003_ExceptionInInitailizerErrorErkennen {

	public static void main(String[] args) {

	
		/*
		 * ExceptionInInitalizerError wirft die JVM , 
		 * wenn sie beim Ladender Klasse im ClassLoader 
		 * eine Exception abfängt
		 * ExceptionInInitializerError จะถูกโยนโดย JVM เมื่อเกิดข้อยกเว้น (Exception) ขึ้นระหว่างการโหลดคลาสใน ClassLoader
		 * 
		 * Achtung! 
		 * ExceptionInInitializerError ist Error (keine Exception) !!!!!!! 
		 */
		
		try {
			new Blume();
		} catch (Error e) {
			System.out.println("Error abgefangen " + e + " " + e.getMessage() ); 										
		}catch (Exception  e) {
			System.out.println("diese Ausgaben gibt es nicht ");
		}
		
		/*  ( Es ist Assertion Error)
		 *  Ausgabe  Error abgefangen java.lang.ExceptionInInitializerError null
		 */
	       /*
         * การแสดงผล: Error ถูกจับ java.lang.ExceptionInInitializerError null
         * 
         * หมายเหตุ:
         * ExceptionInInitializerError เกิดจากการใช้ static block ของ Blume ที่ทำให้เกิด ArithmeticException
         * JVM จึงจับข้อยกเว้นนั้นและสร้าง ExceptionInInitializerError ซึ่งเป็น Error แทนการเป็น Exception
         */

	}

}
