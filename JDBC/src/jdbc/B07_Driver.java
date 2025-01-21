package jdbc;


public class B07_Driver {

	public static void main(String[] args) {
		
		/*
		 * Vor JDBC 4: Driver musste 'manuell' geladen werden.
		 * 
		 * Dafür sollte man in der Treiber-Dokumentation den Namen
		 * der Klasse suchen, die das Interface 'Driver' realisiert,
		 * und diese Klasse laden:
		 */
		try {
			Class.forName("org.apache.derby.iapi.jdbc.AutoloadedDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * Ab JDBC 4: Driver wird automatisch geladen, wenn Connection
		 * zum ersten Mal erstellt wird.
		 * 
		 * Dafür wird die Treiber-Jar-Datei so aufgebaut:
		 * 
		 * 	/META-INF/
		 * 	    |-services/
		 *           |-java.sql.Driver           <- Textdatei mit dem Namen der Driver-Klasse	
		 */

		/*
		 * Eine zusätzliche Möglichkeit:
		 * 
		 * DriverManager lädt auch die Driver, die beim Start der Anwendung
		 * in System-Properties mit der Property 'jdbc.drivers' festgelegt 
		 * werden können:
		 * 
		 * 	java -Djdbc.drivers=foo.bah.Driver MyApp
		 * 
		 */
		
		//----------------------------------------------------//
		 /*
		 * 1. การโหลด Driver ก่อน JDBC 4:
         * สำหรับ JDBC ก่อนเวอร์ชัน 4: จำเป็นต้องทำด้วยมือ (manual loading) 
         * โดยการใช้ Class.forName() เพื่อโหลด Driver ของฐานข้อมูลที่ต้องการใช้
         * ตัวอย่างเช่นการโหลด Driver ของ Apache Derby:
         * 
         * การทำแบบนี้หมายถึงการบอกให้ JVM โหลดคลาสที่เป็น Driver ของฐานข้อมูลที่ต้องการใช้งานก่อนที่การเชื่อมต่อ (Connection) จะเริ่มต้น
         * ถ้ามีข้อผิดพลาดในขั้นตอนนี้จะมีการจับข้อผิดพลาด (Exception) และแสดงผลออกมาในคอนโซล
         */
        try {
            Class.forName("org.apache.derby.iapi.jdbc.AutoloadedDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        /*2. การโหลด Driver ตั้งแต่ JDBC 4:
         * สำหรับ JDBC เวอร์ชัน 4 เป็นต้นไป: Driver จะถูกโหลดโดยอัตโนมัติเมื่อมีการสร้าง Connection ครั้งแรก
         * ระบบจะค้นหา Driver ที่อยู่ในไฟล์ META-INF/services/java.sql.Driver
         * ซึ่งไฟล์นี้จะบอกชื่อของคลาสที่เป็น Driver ที่ต้องการใช้
         * ตัวอย่างเช่น Apache Derby หรือ MySQL Driver
         */
        
        /*
         * 3. การกำหนด Driver ผ่าน System Properties:
         * อีกวิธีหนึ่งในการโหลด Driver คือการกำหนดผ่าน System Properties
         * ในกรณีนี้ Driver จะถูกโหลดเมื่อเริ่มโปรแกรม โดยการตั้งค่าคุณสมบัติ 'jdbc.drivers'
         * ซึ่งสามารถกำหนดผ่านคำสั่งใน Command Line ก่อนที่จะรันโปรแกรม
         * ตัวอย่างเช่น:
         * 
         * java -Djdbc.drivers=foo.bah.Driver MyApp
         * 
         * วิธีนี้จะทำให้ JVM โหลด Driver ที่กำหนดใน System Properties เมื่อโปรแกรมเริ่มทำงาน
         */
        
        /*
         สรุป:
			JDBC 4: การโหลด Driver จะทำโดยอัตโนมัติเมื่อมีการสร้าง Connection ครั้งแรก
			ก่อน JDBC 4: ต้องโหลด Driver ด้วยมือ (manual loading) โดยใช้ Class.forName()
			การกำหนดผ่าน System Properties: สามารถตั้งค่า jdbc.drivers ใน JVM เพื่อให้ Driver ถูกโหลดเมื่อเริ่มโปรแกรม
         */
        
	}
}
