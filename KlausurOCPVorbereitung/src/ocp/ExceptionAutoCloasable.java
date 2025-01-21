package ocp;


public class ExceptionAutoCloasable {


	  static class A implements AutoCloseable {
	    public void close() throws Exception {
	      throw new Exception("catch");
	    } 
	  }

	  private static void method() throws Exception {
	    try (A a = new A()) {
	      throw new Exception("try");
	    } finally {
	      throw new Exception("finally");
	    } 
	  }

	  public static void main(String[] args) {
	    try {
	      method();
	    } catch(Exception e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getSuppressed()[0]);
	    } 
	 } 
}


/*
 * What is the result? (Choose all that apply.)

	A.	try
	B.	catch
	C.	finally
	D.	An ArrayIndexOutOfBoundsException is thrown
	E.	A NullPointerException is thrown
	F.	Compilation fails
	
	
	C and D are correct. Exception "try" is, in fact, thrown. Then Automatic Resource Management calls close() on a triggering exception "catch". The finally block throws exception "finally", causing Java to forget about the other two exceptions. If the finally block were commented out, the code would print "try" and "java.lang.Exception: catch". For the try block, suppressed exceptions are, in fact, stored.

	A, B, E, and F are incorrect because of the above.

 */
 
 /*
  	***ขั้นตอนการทำงาน:

	1.เมื่อเรียก method() ใน main() จะเกิด try ใน try-with-resources และจะโยน Exception ที่มีข้อความ "try"
	2.จากนั้นการปิดอ็อบเจ็กต์ A ใน try-with-resources จะเรียกเมธอด close() ของ A ซึ่งโยน Exception ที่มีข้อความ "catch"
	3.หลังจากนั้นจะเข้าสู่บล็อก finally ซึ่งโยน Exception ที่มีข้อความ "finally"
	4.เนื่องจากบล็อก finally โยน Exception ใหม่ในที่สุด Java จะลืมเกี่ยวกับ Exception อื่น ๆ ที่เกิดขึ้นใน try และ close() 
	  และจะไม่ถือว่า Exception ที่เกิดใน try และ close() เป็นเหตุการณ์หลักที่ถูกจับ
	5.ข้อความของ Exception ที่ถูกจับใน catch จะถูกพิมพ์ออกมา โดยแสดงข้อความ "finally" เนื่องจาก finally เป็นข้อผิดพลาดที่สำคัญที่สุด
	
	**ผลลัพธ์ที่คาดว่าจะเกิดขึ้น:
	
	finally จะถูกโยนก่อน และจะทำให้ Java ลืม Exception อื่น ๆ ที่เกิดขึ้นใน try และ close()
	ข้อความที่พิมพ์ออกมาจะเป็นข้อความจาก finally ซึ่งคือ "finally"
	เนื่องจาก finally มีการโยน Exception ใหม่ จะทำให้เกิด ArrayIndexOutOfBoundsException เมื่อพยายามเข้าถึง e.getSuppressed()[0] ซึ่งจะโยนข้อผิดพลาดนี้
	
	**คำตอบที่ถูกต้องคือ:
	
	C. finally: เนื่องจาก finally เป็นข้อผิดพลาดที่สำคัญที่สุดในการจัดการ
	D. An ArrayIndexOutOfBoundsException is thrown: เมื่อเข้าถึง e.getSuppressed()[0] ใน catch จะเกิดข้อผิดพลาด ArrayIndexOutOfBoundsException เพราะไม่มีข้อผิดพลาดใด ๆ ใน suppressed
	
	**คำตอบที่ผิด:
	
	A. try: จะไม่พิมพ์ "try" เพราะ finally จะโยน Exception ใหม่ทำให้ข้อผิดพลาดใน try ถูกละเลย
	B. catch: ข้อความจาก catch จะถูกพิมพ์ แต่จะไม่เป็น "catch" เพราะจะมี finally ถูกโยนก่อน
	E. A NullPointerException is thrown: จะไม่เกิด NullPointerException
	F. Compilation fails: โค้ดนี้จะไม่ล้มเหลวในการคอมไพล์
  */

