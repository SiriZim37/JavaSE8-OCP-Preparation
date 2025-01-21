package ocp;

public class JDBC2 {
	/*
	 * Assuming you will not be using a DataSource when obtaining a JDBC connection, which are true? (Choose all that apply.)
	 * 
	 * A. To load a JDBC 3.0 driver, you must use Class.forName().
	 * 
	 * B. To load a JDBC 4.0 driver, you must use Class.forName().
	 * 
	 * C. To establish a connection, you must have a JDBC driver.
	 * 
	 * D. To acquire a JDBC driver, you must have a JDBC connection.
	 * 
	 * E. If you're not going to use a DataSource to load a JDBC 3.0 or JDBC 4.0 driver, you must use the java.sql.DriverManager class when connecting.
	 * 
	 * A, C, and E are correct statements.
	 * B is incorrect; with a JDBC 4.0 driver, forName() is optional. D is just backward; C is the correct sequence.
	 * 
	 * คำอธิบาย:
	 * - A: หากคุณใช้ JDBC 3.0 คุณต้องใช้ Class.forName() เพื่อโหลดไดร์เวอร์
	 * - B: ข้อนี้ไม่ถูกต้อง เพราะใน JDBC 4.0 การใช้ Class.forName() เป็นสิ่งที่ไม่จำเป็นแล้ว
	 * - C: คุณต้องมี JDBC driver เพื่อสร้างการเชื่อมต่อกับฐานข้อมูล
	 * - D: ข้อนี้ไม่ถูกต้อง เพราะการได้มาซึ่ง JDBC driver ต้องทำก่อน ไม่ใช่หลังจากการเชื่อมต่อ
	 * - E: หากคุณไม่ใช้ DataSource ในการโหลดไดร์เวอร์สำหรับ JDBC 3.0 หรือ 4.0 คุณต้องใช้ java.sql.DriverManager ในการเชื่อมต่อ
	 */

}
