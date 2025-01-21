package ocp2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class JDBC3Frage {

	public static void main(String[] args) {

		/*
 
		 Which action can be used to load a database driver by using JDBC3.0?
		 A. Add the driver class to the META-INF/services folder of the JAR file.
		 B. Include the JDBC driver class in a jdbc.properties file.
		 C. Use the java.lang.Class.forName method to load the driver class.
		 D. Use the DriverManager.getDriver method to load the driver class
		 */
		
		/*
		 * Correct:
		 * C. Use the java.lang.Class.forName method to load the driver class.
		 * 
		 * วิธีที่ถูกต้องในการโหลดไดรเวอร์ใน JDBC 3.0 คือการใช้เมธอด Class.forName() เพื่อโหลดคลาสของไดรเวอร์ โดยจะทำให้ไดรเวอร์ที่มีชื่อระบุในพารามิเตอร์ถูกโหลดเข้าสู่ระบบ เช่น การใช้ Class.forName("com.mysql.cj.jdbc.Driver") สำหรับไดรเวอร์ของ MySQL เป็นต้น
		 * 
		 * Wrong:
		 * A. Add the driver class to the META-INF/services folder of the JAR file.
		 * 
		 * ตัวเลือกนี้ไม่ถูกต้องสำหรับ JDBC 3.0 เพราะการเพิ่มคลาสไดรเวอร์ในโฟลเดอร์ META-INF/services ของไฟล์ JAR จะใช้งานในกรณีของ JDBC 4.0 ขึ้นไป ซึ่งสามารถโหลดไดรเวอร์อัตโนมัติผ่าน Service Provider Mechanism โดยไม่ต้องใช้ Class.forName()
		 * 
		 * B. Include the JDBC driver class in a jdbc.properties file.
		 * 
		 * ตัวเลือกนี้ไม่ถูกต้อง เนื่องจากไฟล์ jdbc.properties ใช้สำหรับการตั้งค่าการเชื่อมต่อกับฐานข้อมูล เช่น URL, ชื่อผู้ใช้ และรหัสผ่าน แต่ไม่ใช่สำหรับการโหลดไดรเวอร์ใน JDBC 3.0
		 * 
		 * D. Use the DriverManager.getDriver method to load the driver class.
		 * 
		 * ตัวเลือกนี้ไม่ถูกต้องในการโหลดไดรเวอร์ใน JDBC 3.0 เมธอด DriverManager.getDriver() ใช้สำหรับดึงไดรเวอร์ที่ลงทะเบียนแล้ว ไม่ใช่เพื่อโหลดคลาสไดรเวอร์ใหม่
		 */

	}
}
