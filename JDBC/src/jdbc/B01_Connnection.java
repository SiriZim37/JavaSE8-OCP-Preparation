package jdbc;

import java.sql.Connection;		// java.sql.Connection: ใช้สำหรับสร้างและจัดการการเชื่อมต่อกับฐานข้อมูล
import java.sql.DriverManager;	// java.sql.DriverManager: ใช้สำหรับจัดการไดร์เวอร์ JDBC และสร้างการเชื่อมต่อ
import java.sql.SQLException;	// java.sql.SQLException: ใช้สำหรับจัดการข้อผิดพลาดที่อาจเกิดขึ้นขณะทำงานกับฐานข้อมูล

public class B01_Connnection {

	/*
	 * **jdbc:derby:mydb คืออะไร?**
	 * 
	 * URL นี้ใช้ใน Java เพื่อเชื่อมต่อกับฐานข้อมูล Derby ผ่านเมธอด DriverManager.getConnection()
	 * 
	 * **การแยกส่วน URL jdbc:derby:mydb**
	 * - **jdbc:** 
	 *   โปรโตคอลมาตรฐานของ Java สำหรับการเชื่อมต่อฐานข้อมูล (Java Database Connectivity - JDBC)
	 * - **derby:** 
	 *   ระบุว่าฐานข้อมูลที่ใช้คือ Apache Derby 
	 *   ซึ่งเป็นฐานข้อมูล SQL แบบฝังตัว (Embedded Database) ไม่ต้องติดตั้งแยก
	 * - **mydb:** 
	 *   ชื่อของฐานข้อมูลที่ต้องการเชื่อมต่อ 
	 *   ในกรณีนี้คือฐานข้อมูลชื่อ `mydb` ซึ่งต้องมีอยู่ในระบบ หรือจะสร้างขึ้นใหม่โดยอัตโนมัติ
	 * 
	 * **โหมดการใช้งาน Apache Derby**
	 * Apache Derby สามารถทำงานได้ 2 โหมดหลัก:
	 * 
	 * 1. **Embedded Mode (โหมดฝังตัว)** 
	 *    - ฐานข้อมูลทำงานในแอปพลิเคชัน Java โดยตรง
	 *    - ไม่ต้องมีเซิร์ฟเวอร์ฐานข้อมูลแยก
	 *    - ตัวอย่าง: `jdbc:derby:mydb` 
	 *      หากฐานข้อมูล `mydb` ยังไม่มีอยู่ ระบบจะสร้างใหม่โดยอัตโนมัติ
	 * 
	 * 2. **Client-Server Mode (โหมดไคลเอนต์-เซิร์ฟเวอร์)**
	 *    - ฐานข้อมูล Derby ทำงานเป็นเซิร์ฟเวอร์ 
	 *    - ไคลเอนต์เชื่อมต่อผ่านเครือข่าย
	 *    - ตัวอย่าง: `jdbc:derby://localhost:1527/mydb`
	 *      - `localhost` คือที่อยู่ของเซิร์ฟเวอร์
	 *      - `1527` คือพอร์ตเริ่มต้นของ Derby
	 * 
	 * **ตัวอย่างการใช้งาน Embedded Mode**
	 * - **สร้างฐานข้อมูลใหม่** 
	 *   เมื่อรันโปรแกรมครั้งแรก หากฐานข้อมูล `mydb` ยังไม่มี ระบบจะสร้างขึ้นมาใหม่ในโฟลเดอร์โปรเจกต์
	 * - **เชื่อมต่อฐานข้อมูลที่มีอยู่แล้ว** 
	 *   หากฐานข้อมูล `mydb` มีอยู่ในระบบ โปรแกรมจะเชื่อมต่อเพื่ออ่านหรือเขียนข้อมูล
	 * 
	 * **การตั้งค่าฐานข้อมูล Derby**
	 * - **สร้างฐานข้อมูลใหม่ (ถ้ายังไม่มี):**
	 *   ไม่ต้องตั้งค่าพิเศษ เพียงระบุ URL ดังนี้:
	 *   ```java
	 *   String url = "jdbc:derby:mydb;create=true";
	 *   ```
	 * - **การปิดฐานข้อมูล:**
	 *   เพื่อหลีกเลี่ยงปัญหาการล็อกไฟล์ฐานข้อมูล ต้องปิดการเชื่อมต่อด้วย:
	 *   ```java
	 *   c.close();
	 *   ```
	 * 
	 * **ข้อควรรู้**
	 * - **โฟลเดอร์เก็บฐานข้อมูล:**
	 *   ฐานข้อมูล Derby จะถูกสร้างและเก็บไว้ในโฟลเดอร์ปัจจุบันของโปรเจกต์ Java โดยอัตโนมัติ
	 * - **ฐานข้อมูลฝังตัวเหมาะกับ:**
	 *   - แอปพลิเคชันขนาดเล็กหรือการพัฒนาทดลอง
	 *   - ไม่เหมาะกับระบบที่ต้องรองรับการเข้าถึงพร้อมกันจำนวนมาก
	 */


	public static void main(String[] args) {
		
		/*
		 * Derby ist nicht in der Prüfung.
		 * Hinweise zu Derby gibt es in der 'readme-derby.md' im Projektverzeichnis
		 */
		/*
			 กำหนด URL สำหรับการเชื่อมต่อกับฐานข้อมูล Derby
			 หากต้องการให้ระบบสร้างฐานข้อมูลใหม่เมื่อยังไม่มีฐานข้อมูล 'mydb' 
			 สามารถใช้ URL ต่อไปนี้ได้: 
			 "jdbc:derby:mydb;create=true"
			 URL นี้จะเชื่อมต่อกับฐานข้อมูล 'mydb' และหากฐานข้อมูลไม่พบ ระบบจะสร้างใหม่
	
			 ใช้ URL ที่ระบุเส้นทางของฐานข้อมูล 'mydb' ที่ต้องการสร้างหรือเชื่อมต่อ
			 ในกรณีนี้ URL ระบุเส้นทางเต็มไปยังฐานข้อมูลที่อยู่ที่ C:\path\to\mydb
			 และยังใช้พารามิเตอร์ 'create=true' เพื่อให้ระบบสร้างฐานข้อมูลใหม่
		 */
		
//		String url = "jdbc:derby:mydb;create=true";					
		String url = "jdbc:derby:/Users/sirivimonmeuntup/Documents/Dev_Project/Java-Workspace/javaocpse8/JDBC/mydb;create=true";
				// window "jdbc:derby:C:\\path\\to\\mydb;create=true"; 	// mydb existiert dann muss mit diese Zeile verwenden
		
		try (Connection c = DriverManager.getConnection(url)){

			System.out.println("Die Verbindung steht");
			//...
			System.out.println("Die Verbindung wird geschlossen.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
