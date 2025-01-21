package io;

import java.io.Console;
import java.util.Arrays;

public class B06_Console {

	/*
	 * Achtung! Eclipse stated die JVM ohne System-Konsole!
	 * Beim Starten dieses Beispiels aus Eclipse liefert die methode
	 * System.console() nutt zurück
	 * 
	 * Um das Beispiel auszuprobieren , muss man manuell die main-methode starten
	 * 
	 * Die Datei test-console.bat ausführen
	 * 
	 * Das kann auch unter Eclipse im Terminal gemacht werden.
	 * 'Terminal' unter Eclipse finden : Windowss-Show->View-> Terminal
	 * 
	 * Aber einfacher ist es im Pakage-Exploror auf test-console.bat Rechtcleick machen
	 * und im Kontest-Menu ' Show-In -> Terminal auswählen.
	 * 
	 */
	
	/*
	 * ข้อควรระวัง! Eclipse เรียกใช้งาน JVM โดยไม่มีระบบคอนโซล!
	 * เมื่อเริ่มต้นตัวอย่างนี้จาก Eclipse ฟังก์ชัน
	 * System.console() จะคืนค่า null
	 * 
	 * เพื่อทดลองใช้งานตัวอย่างนี้ จำเป็นต้องเรียกใช้เมธอด main
	 * ด้วยตนเอง
	 * 
	 * ให้รันไฟล์ test-console.bat
	 * 
	 * คุณสามารถทำเช่นนี้ได้ใน Eclipse ผ่าน Terminal
	 * วิธีการหาฟังก์ชัน 'Terminal' ใน Eclipse: ไปที่ Windows -> Show -> View -> Terminal
	 * 
	 * แต่จะสะดวกกว่าถ้าไปที่ Package Explorer คลิกขวาที่ test-console.bat
	 * และในเมนูบริบทให้เลือก 'Show In -> Terminal'
	 */
	
	/*
	 * java.io.Console เป็นคลาสที่ใช้สำหรับการโต้ตอบกับผู้ใช้ผ่านทางคอนโซล
	 * โดยมีฟังก์ชันที่ช่วยให้สามารถอ่านและเขียนข้อมูลจากคอนโซลได้
	 *
	 * การใช้ Console จะเป็นประโยชน์ในกรณีที่ต้องการรับค่าจากผู้ใช้
	 * เช่น การรับข้อมูลการเข้าสู่ระบบ (username และ password) โดยไม่แสดง password ในคอนโซล
	 *
	 * หมายเหตุ: 
	 * - Console จะคืนค่า null หากถูกเรียกในสภาพแวดล้อมที่ไม่มีคอนโซล
	 *   เช่น ใน IDE บางตัว (เช่น Eclipse) ที่ไม่สนับสนุนการเข้าถึงคอนโซล
	 * - หากต้องการทดสอบฟังก์ชัน Console ควรทำการรันโปรแกรมจาก Command Line หรือ Terminal
	 *
	 * วิธีการใช้งาน Console:
	 * 1. สร้างตัวแปร Console โดยเรียกใช้ System.console()
	 * 2. ใช้เมธอดที่มีอยู่ใน Console เช่น readLine(), format(), readPassword() เพื่อโต้ตอบกับผู้ใช้
	 *
	 * ตัวอย่างการใช้งาน:
	 * Console console = System.console();
	 * if (console != null) {
	 *     String name = console.readLine("Enter your name: ");
	 *     console.format("Hello, %s!%n", name);
	 * } else {
	 *     System.out.println("No console available.");
	 * }
	 */

	
	public static void main(String[] args) {

//		Console c0 = new Console(); // cf 
//		Console c0 = Console.getInstance; // cf 
		
		Console c = System.console(); // สร้างอินสแตนซ์ของ Console: บรรทัดนี้สร้างอ็อบเจ็กต์ c ที่เป็นอินสแตนซ์ของ Console ซึ่งช่วยให้เราโต้ตอบกับผู้ใช้ผ่านคอนโซล
		
		String day = "Dienstag";
		c.format("Heute ist %s%n", day);	
		c.printf("Gestern war Montag%n");
		
		/*
		 * String readLine()
		 */
		c.format("Bitte den Name eingeben : ");
		String userName = c.readLine();
		c.format("gelesen : %s%n" , userName);
		
		/*
		 * String readLine(String fmt, Object... args)
		 */
		String userAnswer = c.readLine("Ist der Name %s rictig? (j/n) : " , userName);
		c.format("gelesen : %s%n", userAnswer);
		
		/*
		 * char[] readPassword()
		 * char readPassword(String fmt , Object...args)
		 */
		
		char[] pwd = c.readPassword();
//		char[] pwd = c.readPassword("Passwort eingeben=%" , 0123456);	OK
		
		c.format("pwd-Array : %s%n", Arrays.toString(pwd));
		
		// test >>> test-console.bat >>  javac -d bin src/serialisieren.TestSerialisierenDienste.java 
		
		
		
		/*
		 * Exam : 
		 */
		
//		String s = c.readPassword();  Compiliert nicht , Es liefert 'char' zurück! 
									 // cf : String <- IST-KEIN <- char[]
		
		
		
		/*
		 *  System.console()		 สร้างอินสแตนซ์ของ Console: บรรทัดนี้ใช้ System.console() 
		 *  				 		 เพื่อสร้างอ็อบเจ็กต์ c ที่ใช้ในการโต้ตอบกับผู้ใช้ผ่านคอนโซล เช่น การพิมพ์ข้อความและรับข้อมูลจากผู้ใช้
			c.format และ c.printf   	 แสดงข้อความ: ใช้ c.format และ c.printf 
									 เพื่อพิมพ์ข้อความลงในคอนโซล ทำให้ผู้ใช้เห็นข้อความที่คุณต้องการ
			c.readLine()			 รับข้อมูลจากผู้ใช้: ใช้ c.readLine() เพื่อรับข้อมูลที่ผู้ใช้ป้อน เช่น ชื่อ และเก็บไว้ในตัวแปรที่คุณกำหนด
			c.readLine()			 ถามและแสดงผล: ใช้ c.readLine() เพื่อสอบถามผู้ใช้เกี่ยวกับข้อมูลที่เขาได้ป้อน 
									 และใช้ c.format เพื่อแสดงผลข้อมูลที่ได้รับ
			c.readPassword() 		 รับรหัสผ่าน: ใช้ c.readPassword() 
									 เพื่อให้ผู้ใช้ป้อนรหัสผ่านอย่างปลอดภัย ซึ่งจะไม่แสดงในคอนโซล เพื่อปกป้องความเป็นส่วนตัวของผู้ใช้
		 */

	}
	
	// Explain about test-console.bat
	/*
	 * :: C:\Local\java\jdk-21.0.3+9\bin\java -version
	 * คำสั่งนี้ใช้เพื่อตรวจสอบเวอร์ชันของ Java ที่ติดตั้งอยู่ในระบบของคุณ โดยการเรียกใช้งาน java -version จะทำให้คุณเห็นว่า JVM ที่คุณใช้งานอยู่คือเวอร์ชันอะไร
	 * 
	 * javac -d bin src/io/B06_Console.java
	 * javac: คำสั่งนี้เรียกใช้คอมไพเลอร์ Java
	 * -d bin: หมายความว่าคุณต้องการให้ไฟล์ที่คอมไพล์แล้วถูกเก็บไว้ในโฟลเดอร์ bin
	 * src/io/B06_Console.java: นี่คือเส้นทางไปยังไฟล์ Java ที่คุณต้องการคอมไพล์
	 * 
	 * java -cp bin io.B06_Console
	 * java: คำสั่งนี้ใช้ในการรันโปรแกรม Java
	 * -cp bin: หมายความว่าให้ใช้โฟลเดอร์ bin เป็นคลาสพาธสำหรับการค้นหาคลาสที่คอมไพล์แล้ว
	 */

}
