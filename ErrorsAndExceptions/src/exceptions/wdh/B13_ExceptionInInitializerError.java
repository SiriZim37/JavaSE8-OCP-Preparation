package exceptions.wdh;

import java.util.Random;


/*
 * ExceptionInInitializerError เป็นข้อผิดพลาดที่เกิดขึ้นในระหว่างการ initialize 
 * ตัวแปร static หรือ static block ของคลาสใน Java 
 * ซึ่งหมายความว่า Java พบปัญหาเมื่อพยายามโหลดคลาสและกำหนดค่าให้กับตัวแปร static ก่อนที่คลาสนั้นจะถูกใช้งาน
 * 
 * สาเหตุที่ทำให้เกิด ExceptionInInitializerError
 * 1. มีข้อยกเว้น (Exception) เกิดขึ้นใน static initializer block
 * 		-static initializer block คือโค้ดที่อยู่ใน { } ซึ่งทำงานครั้งแรกเมื่อคลาสถูกโหลด
 * 2. มีข้อยกเว้น (Exception) เกิดขึ้นในระหว่างการกำหนดค่าให้ตัวแปร static
 * 		- เช่น มีการคำนวณหรือเรียกเมธอดที่โยน Checked Exception หรือ Runtime Exception
 * 
 * 
 * สรุป
 * 	- ExceptionInInitializerError เกิดจากข้อผิดพลาดใน static block หรือ static variable ในช่วงการ initialize
 * 	- ตรวจสอบและแก้ไขข้อยกเว้นในโค้ด static เพื่อหลีกเลี่ยงข้อผิดพลาดนี้
 * - ใช้ try-catch เพื่อจัดการข้อยกเว้นใน static block หากจำเป็น
 */

class MyValue{
	
	private static int maxValue ;
	
	static {
		Random rnd = null ;
		maxValue = rnd.nextInt(100)+100;		// NullPointerException
	}

	int getValue() {
		return 42;
	}
	
}

public class B13_ExceptionInInitializerError {

	  static {
	       try {
	           int result = 10 / 0; // อาจเกิดข้อยกเว้น
	       } catch (ArithmeticException e) {
	    	   e.printStackTrace();
	            System.out.println("Error in static block: " + e.getMessage());
	       }
	   }

	public static void main(String[] args) {
		/*
		 * Bevor das neue MyValue-Objekt im Speicher
		 * erstellt werden kann und der Konstruktor
		 * der Klasse MyValue gestartet werden kann ,
		 * muss die JVM die Klasse MyValue laden. 
		 * 
		 * Beim Laden der KLasse wird der statische 
		 * Init-Block ausgeführt. 
		 * Beim Ausfühtrn vom statischen Init-Block 
		 * entsteht die NullPointerException , die von 
		 * JVM abgefangen wird. Stattdessen wirft die 
		 * JVM den ExceptionInInitializerError an der Stelle , 
		 * wo die Klasse MyValue zum ersten Mal benutzt werden sollte.
		 * 
		 * Die klasse kann nicht geladen werden..
		 * 
		 * Achtung!
		 * ExceptionInInitializerError ist keine Exception!
		 * 
		 */
		
		 System.out.println("Program continues...");
		 
		try {
			MyValue v = new MyValue();
			System.out.println(v.getValue());
		}catch (Exception e) {
			System.out.println("wird nicht laufen");
		}catch (ExceptionInInitializerError e) { 	// extends Error
			System.out.println("abgefangen : " + e);
		}
		
	}
	



}
