package ocpexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest4 {

	public static void main(String[] args) {
		
		
		
	}
	/*
	 
	 ID 		NAME
	 102		Edwin
	 103		Edward
	 103		Edwin
	
	
		 Connection conn = DriveManager.getConnection(dbURL, username, password);
		
		 String query = "DELETE  FROM Student WHERE ID = 103";
		
		System.out.println("Status:" + st.excute(query));
			
		
		Assume that:

	What is the result?
	
	Options
	A	The program prints Status: true and two records are deleted from the Student table.
	B	The program prints Status: false and two records are deleted from the Student table.
	C	A SQLException is thrown at runtime.
	D	The program prints Status: false but the records from the Student table are not deleted.
	
	
	ขั้นตอนการทำงาน:
	- คำสั่ง DELETE จะทำการลบแถวที่มี ID = 103 ซึ่งมี 2 แถว (หนึ่งชื่อ "Edward" และหนึ่งชื่อ "Edwin") ออกจากตาราง Student จึงมีการลบข้อมูลทั้งสองแถว
	- ฟังก์ชัน st.execute(query) จะรันคำสั่ง SQL ที่ส่งไป
		สำหรับคำสั่งประเภท DELETE, UPDATE หรือ INSERT ฟังก์ชัน execute() จะ คืนค่าเป็น false เสมอ เพราะมันไม่ต้องการคืนข้อมูล (ResultSet) เช่นเดียวกับการดึงข้อมูลจากฐานข้อมูล
		ฟังก์ชันนี้จะคืนค่า false แต่คำสั่ง SQL จะทำงานสำเร็จและลบแถวที่ตรงกับเงื่อนไข ID = 103
	สรุปผลลัพธ์:
	- คำสั่ง DELETE ทำงานสำเร็จและลบข้อมูลจากตารางจริง ๆ (2 แถวที่มี ID = 103)
	- แต่ ฟังก์ชัน execute() คืนค่าเป็น false เพราะมันไม่ต้องการผลลัพธ์ (ResultSet) เมื่อใช้กับคำสั่ง DELETE

	
	Answer
	B
	 */
}
