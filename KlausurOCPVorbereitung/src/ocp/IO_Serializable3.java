package ocp;

import java.io.*;



public class IO_Serializable3 extends Dog {
	
	/*
	 * 3. import java.io.*;
	 * 4. public class Interact {
	 * 5.   public static void main(String[] args) {
	 * 6.     Console c = System.getConsole();
	 * 7.     char[] u = c.readLine("%s", "username: ");
	 * 8.     System.out.println("hello " + u);
	 * 9.     char[] pw;
	 * 10.     if(c != null && (pw = c.readPassword("%s", "password: ")) != null)
	 * 11.         // check for valid password
	 * 12.   }
	 * 13. }
	 * Which are true? (Choose all that apply.)
	 *
	 * A. Compilation succeeds.
	 * 
	 * B. Compilation fails due to a single error in the code.
	 * 
	 * C. Compilation fails due to multiple errors in the code.
	 * 
	 * D. By default, the readLine() method echoes the user's keystrokes.
	 * 
	 * E. By default, the readPassword() method echoes the user's keystrokes.
	 * 
	 * F. All of the Console class's methods that write to the console's output stream allow you to specify the format of the output stream.
	 *
	 *
	 *
	 * C, D, and F are correct. The System class method is console(), not getConsole(), and the readLine() method returns a String, not a char[].
	 *
	 * A, B, and E are incorrect based on the above.
	 *

	 	A (Compilation succeeds) 
	 		- การคอมไพล์จะไม่สำเร็จเพราะ System.getConsole() เป็นวิธีที่ไม่ถูกต้อง ควรใช้ System.console() แทน 
	 		 ซึ่งทำให้เกิดข้อผิดพลาดในการคอมไพล์
	 		 
		B (Compilation fails due to a single error) 
			- ข้อความนี้ไม่ถูกต้อง เนื่องจากมีหลายข้อผิดพลาดในโค้ด เช่นการใช้ getConsole() และการคืนค่าจาก readLine() ที่ไม่ตรงกับประเภทที่ต้องการ
			
		C (Compilation fails due to multiple errors)  > Yes
			- ข้อความนี้ถูกต้อง เพราะมีหลายข้อผิดพลาดในโค้ด เช่นการใช้ getConsole() แทน console() และการคืนค่าจาก readLine() ที่เป็น String
			 ไม่ใช่ char[]
			bsp : String userAnswer = c.readLine("Ist der Name %s rictig? (j/n) : " , userName);
			
		D (readLine echoes keystrokes) > Yes
			- ข้อความนี้ผิด เนื่องจากโดยปกติ readLine() ไม่แสดงการกดปุ่มของผู้ใช้ มันจะไม่สะท้อนการพิมพ์
			
		E (readPassword echoes keystrokes) 
			- ข้อนี้ไม่ถูกต้องเพราะ readPassword() จะไม่แสดงการพิมพ์ตัวอักษรหรือรหัสผ่านของผู้ใช้
			
		F (Methods in Console allow format specification) > Yes
			- ข้อนี้ถูกต้อง เพราะเมธอดของ Console ที่เขียนข้อมูลสามารถกำหนดรูปแบบได้ เช่นการใช้ %s ใน readLine() และ readPassword()
	 */


}

