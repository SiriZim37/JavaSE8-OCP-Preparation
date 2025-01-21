package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B13_ResultSet_updateRow {

	/*
	 * INSERT INTO table2
	 * SELECT * FROM table1
	 * WHERE condition;
	 */
	
	/*
	คำสั่ง res.updateRow(); ใน Java ใช้ในกรณีที่ต้องการแก้ไขข้อมูลในแถวปัจจุบันของฐานข้อมูล 
	ผ่าน ResultSet ที่รองรับการอัปเดต (Updateable ResultSet) โดยไม่ต้องเขียนคำสั่ง SQL แยกต่างหาก เช่น UPDATE ...

	การทำงานของ updateRow():
	1. เลื่อน Cursor ไปยังแถวที่ต้องการแก้ไข
	   - ใช้คำสั่ง res.next(); เพื่อเลื่อนไปยังแถวที่ต้องการ
	   - ต้องแน่ใจว่า Cursor ชี้ไปยังแถวที่ต้องการแก้ไขก่อนดำเนินการ

	2. กำหนดค่าคอลัมน์ใหม่
	   - ใช้เมธอด updateXXX() (เช่น updateString(), updateInt()) เพื่อตั้งค่าคอลัมน์ที่ต้องการเปลี่ยนในแถวปัจจุบัน เช่น:
	     res.updateString("column_name", "new_value"); // เปลี่ยนค่าคอลัมน์เป็นค่าใหม่
	     res.updateInt("column_name", newValue);      // เปลี่ยนค่าคอลัมน์ตัวเลข

	3. บันทึกการเปลี่ยนแปลง
	   - หลังจากกำหนดค่าคอลัมน์ใหม่เสร็จ ให้เรียก res.updateRow(); เพื่อบันทึกข้อมูลที่แก้ไขกลับไปยังฐานข้อมูล

	เงื่อนไขการใช้งาน updateRow():
	- ต้องเปิดใช้งาน ResultSet แบบ Updateable:
	  ResultSet ต้องถูกสร้างด้วย Statement ที่รองรับ CONCUR_UPDATABLE เช่น:
	  
	  Statement stm = connection.createStatement(
	      ResultSet.TYPE_SCROLL_INSENSITIVE,
	      ResultSet.CONCUR_UPDATABLE
	  );

	- ต้องอยู่ในแถวที่สามารถแก้ไขได้:
	  Cursor ต้องชี้ไปยังแถวที่ต้องการแก้ไขก่อนเรียกใช้คำสั่ง updateRow()

	ข้อควรระวัง:
	- ตรวจสอบสิทธิ์ของผู้ใช้งานในฐานข้อมูล เช่น สิทธิ์ UPDATE
	- หากต้องแก้ไขข้อมูลจำนวนมาก อาจพิจารณาใช้คำสั่ง SQL `UPDATE` แทน
	- ResultSet แบบ CONCUR_READ_ONLY จะไม่สามารถใช้งาน updateRow() ได้

	ข้อดี:
	- ลดความซับซ้อนของโค้ดเมื่อเทียบกับการใช้ SQL แยกต่างหาก
	- เหมาะสำหรับการแก้ไขข้อมูลใน ResultSet ที่มีอยู่แล้ว
	*/

	public static void main(String[] args) {
//		String url = "jdbc:derby:C:\\path\\to\\mydb;";
		String url = "jdbc:derby:/Users/sirivimonmeuntup/Documents/Dev_Project/Java-Workspace/javaocpse8/JDBC/mydb";
		
		JDBCUtils.rebuildTestTable();
		JDBCUtils.printTestTable();
		
		int resultType = ResultSet.TYPE_FORWARD_ONLY;
		int resultSetConcurrency = ResultSet.CONCUR_UPDATABLE;
//		int resultSetConcurrency = ResultSet.CONCUR_READ_ONLY;	// NICHT UPDATE!! SQLException: 'updateString' not allowed because the ResultSet is not an updatable ResultSet. 
		
		try (Connection c = DriverManager.getConnection(url);
				Statement stm = c.createStatement(resultType , resultSetConcurrency);
					ResultSet res = stm.executeQuery("select * from kunden")){
			
			/* 
			 * Spezielles ResultSet(CONCUR_UPDATABLE) kommt aus dem speziellen Statement
			 * 
			 * Dieses ResultSet kann Daten in der Tabelle ändern.
			 * 
			 */
			
			/*
			 * Der Curcor muss auf eine Zeile zeigen	 เลื่อนไป 1 แถว
			 */
			res.next();
			
			/*
			 * Änderung vorbereiten
			 */
			res.updateString("name", "PETER");		// Row index 1
			res.updateInt("kontostand", 100);
			
			/*
			 *  Änderung in die Datenbank übertragen
			 */
			 res.updateRow(); 		// บันทึกการแก้ไขแถวปัจจุบัน
			 
			 
			 //-----------------------------------------------------------------//
			 /*
	         * เลื่อนไปยังแถวที่ต้องการแก้ไข
	         */
	         if (res.next()) { // เลื่อนไปแถวแรก
		        /*
		         * แก้ไขค่าคอลัมน์ในแถวปัจจุบัน
		         */
		        res.updateString("name", "Mary");  		// เปลี่ยนค่าคอลัมน์ name
		        res.updateInt("kontostand", 8000);      // เปลี่ยนค่าคอลัมน์ kontostand
	
		        /*
		         * บันทึกการเปลี่ยนแปลงลงในฐานข้อมูล
		         */
		        res.updateRow(); // บันทึกการแก้ไขแถวปัจจุบัน
	         }
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JDBCUtils.printTestTable();
	}
}
