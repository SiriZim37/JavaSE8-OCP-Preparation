package ocp;

public class DateTime6 {


	/*
	 * Given:
	 * 
	 * 3. import java.io.*;
	 * 4. public class TestThis implements Runnable {
	 * 5.   public static void main(String[] args) {
	 * 6.     Thread t = new Thread(new TestThis());
	 * 7.     t.start();
	 * 8.     Thread t2 = new Thread(new TestThis());
	 * 9.     t2.start();
	 * 10.    Console c = System.console();
	 * 11.    String u = c.readLine("%s", "m ");
	 * 12.    System.out.print(u + " ");
	 * 13.  }
	 * 14.  public void run() {
	 * 15.    Console c = System.console();
	 * 16.    String u = c.readLine("%s", "t ");
	 * 17.    System.out.print(u + " ");
	 * 18.  }
	 * 19. }
	 * 
	 * What is the result?
	 * 
	 * A. Compilation fails
	 * 
	 * B. A NullPointerException is never thrown
	 * 
	 * C. A NullPointerException is always thrown
	 * 
	 * D. A NullPointerException is sometimes thrown
	 * 
	 * D is correct. The JVM is not guaranteed to have a console. If it does not, the System.console() method returns a null.
	 * 
	 * A, B, and C are incorrect based on the above.
	 * 
	 * คำอธิบาย:
	 * - ข้อ D ถูกต้อง เนื่องจาก JVM ไม่ได้การันตีว่าจะมีคอนโซล ถ้าไม่มีคอนโซล `System.console()` จะคืนค่าเป็น null ซึ่งจะทำให้เกิด `NullPointerException` หากพยายามเข้าถึง
	 * - ข้อ A ไม่ถูกต้อง เพราะโค้ดนี้สามารถคอมไพล์ได้ถ้าไม่มีปัญหาด้านอื่น
	 * - ข้อ B ไม่ถูกต้อง เพราะบางครั้งอาจเกิด `NullPointerException` ขึ้นได้
	 * - ข้อ C ไม่ถูกต้อง เพราะ `NullPointerException` ไม่เกิดเสมอไป
	 */

}
