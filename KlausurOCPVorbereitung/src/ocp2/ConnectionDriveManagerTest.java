package ocp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDriveManagerTest {
	/*
		static Connection newConnection =null;
		public static Connection getDBConnection() throws SQLException {
		    try (Connection con = DriverManager.getConnection(URL, username, password)) {
		        newConnection = con;
		    }
		    return newConnection;
		}
	
		public static void main(String[] args) throws SQLException {
		    try (Connection con = DriverManager.getConnection(URL, username, password)) {
		        Statement st = con.createStatement();
		        st.executeUpdate("INSERT INTO student VALUES (102, 'Kelvin')");
		    }
		}
	*/
	
	/*
	     The required database driver is configured in the classpath.
	     The appropriate database is accessible with the URL, userName, and passWord exists.
	     The SQL query is valid.
	     
	 What is the result?
	 A. The program executes successfully and the STUDENT table is updated with one record.
	 B. The program executes successfully and the STUDENT table is NOT updated with any record.
	 C. A SQLException is thrown as runtime.
	 D. A NullPointerException is thrown as runtime
	 */
	
	/*
	 
		ในกรณีนี้ โค้ดมีข้อผิดพลาดที่สำคัญ ซึ่งจะทำให้เกิด NullPointerException ขณะทำงาน เนื่องจากการใช้งาน Connection ภายนอก try-with-resources บล็อก ดังนี้:
		
		อธิบายโค้ด:
		การสร้างการเชื่อมต่อ (getDBConnection):
		
		ในฟังก์ชัน getDBConnection มีการใช้ try-with-resources สำหรับสร้างการเชื่อมต่อกับฐานข้อมูล โดยที่การเชื่อมต่อนั้นจะถูกปิดอัตโนมัติเมื่อออกจากบล็อก try.
		อย่างไรก็ตาม, ตัวแปร newConnection จะได้รับค่าเป็น con ที่อยู่ในบล็อก try-with-resources ซึ่งเมื่อการเชื่อมต่อถูกปิดไปแล้วภายใน try บล็อก newConnection จะเป็น null หลังจากนั้น.
		**การใช้ newConnection ใน main:
		
		ในเมธอด main, มีการเรียกใช้ getDBConnection() ซึ่งจะพยายามเก็บ Connection ไว้ในตัวแปร newConnection.
		เมื่อ newConnection ถูกเข้าถึงในบรรทัด newConnection.createStatement(), ค่าใน newConnection จะเป็น null เนื่องจากการเชื่อมต่อนั้นถูกปิดไปแล้วภายใน try-with-resources.
		การพยายามใช้ null จะทำให้เกิด NullPointerException.
	
	 	C correct > ในกรณีนี้, SQLException จะถูกโยนออกมาเป็นผลจากการพยายามใช้งาน null 
	 	ใน newConnection ที่จะทำให้เกิด NullPointerException แทนที่.
	 */
}
