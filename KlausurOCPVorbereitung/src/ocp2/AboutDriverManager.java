package ocp2;

public class AboutDriverManager {

	/*
	 * Which statement is true about the DriverManager class?
		 A. It returns an instance of Connection.
		 B. it executes SQL statements against the database.
		 C. It only queries metadata of the database.
		 D. it is written by different vendors for their specific database.
	 */
	
	/*
	 	A. มันคืนค่าอินสแตนซ์ของ Connection.
		คำอธิบาย:
		DriverManager เป็นคลาสใน Java ที่ใช้จัดการกับรายการของไดรเวอร์ฐานข้อมูลและสร้างการเชื่อมต่อกับฐานข้อมูล มันไม่ได้ใช้เพื่อการรันคำสั่ง 
		SQL หรือค้นหาข้อมูลเมทาดาต้าโดยตรง ฟังก์ชันหลักของมันคือการสร้างการเชื่อมต่อกับฐานข้อมูลโดยเลือกไดรเวอร์ที่เหมาะสม
		
		
		มาดูการวิเคราะห์ของแต่ละตัวเลือก:
		
		A. มันคืนค่าอินสแตนซ์ของ Connection.
		ถูกต้อง. เมธอด DriverManager.getConnection() คืนค่าอ็อบเจ็กต์ Connection ซึ่งเป็นตัวแทนของการเชื่อมต่อกับฐานข้อมูล 
		ฟังก์ชันหลักของ DriverManager คือการสร้างการเชื่อมต่อกับฐานข้อมูลและคืนค่าการเชื่อมต่อนี้
		
		B. มันรันคำสั่ง SQL กับฐานข้อมูล.
		ไม่ถูกต้อง. คลาส DriverManager เองไม่ได้รันคำสั่ง SQL มันมีหน้าที่หลักในการสร้างการเชื่อมต่อกับฐานข้อมูล การรันคำสั่ง SQL ทำได้โดยใช้ Statement, 
		PreparedStatement หรือ CallableStatement ที่ได้รับจากอ็อบเจ็กต์ Connection.
		
		C. มันแค่ค้นหาข้อมูลเมทาดาต้าของฐานข้อมูล.
		ไม่ถูกต้อง. แม้ว่าคลาส DriverManager จะใช้ในการเชื่อมต่อฐานข้อมูล แต่การค้นหาข้อมูลเมทาดาต้าจะทำได้ผ่าน DatabaseMetaData 
		ซึ่งสามารถเข้าถึงได้จากอ็อบเจ็กต์ Connection ไม่ใช่จาก DriverManager.
		
		D. มันเขียนโดยผู้จำหน่ายที่แตกต่างกันสำหรับฐานข้อมูลแต่ละตัว.
		ไม่ถูกต้อง. คลาส DriverManager เป็นคลาสมาตรฐานใน Java API แต่จะใช้ไดรเวอร์ JDBC ที่เขียนโดยผู้จำหน่ายฐานข้อมูลต่าง ๆ 
		สำหรับฐานข้อมูลแต่ละตัว คลาส DriverManager เป็นคลาสทั่วไปที่ทำงานร่วมกับไดรเวอร์ JDBC ใดก็ได้ที่ลงทะเบียนกับมัน
	 */
}
