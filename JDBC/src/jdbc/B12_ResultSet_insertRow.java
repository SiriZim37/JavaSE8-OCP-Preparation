package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B12_ResultSet_insertRow {

	/*
	 * INSERT INTO table2
	 * SELECT * FROM table1
	 * WHERE condition;
	 */
	
	/*
	คำสั่ง res.insertRow(); ใน Java ใช้ในกรณีที่ต้องการเพิ่มข้อมูลใหม่เข้าไปในฐานข้อมูลผ่าน ResultSet 
	ที่รองรับการอัปเดต (Updateable ResultSet) โดยไม่ต้องใช้คำสั่ง SQL แยกต่างหาก เช่น INSERT INTO ...

	การทำงานของ insertRow():
	1. แถวพิเศษ ("Insert Row")
	   เมื่อใช้งาน ResultSet ที่สามารถอัปเดตได้ จะมีแถวพิเศษเรียกว่า Insert Row 
	   คุณสามารถกำหนดค่าข้อมูลใหม่ในแถวนี้ได้ด้วยเมธอด updateXXX() เช่น:

	   res.moveToInsertRow(); // ย้ายไปยังแถว "Insert Row"
	   res.updateString("column_name", "value"); // กำหนดค่าคอลัมน์
	   res.updateInt("column_name", value); // กำหนดค่าอีกคอลัมน์

	2. บันทึกข้อมูลลงในตาราง
	   เมื่อข้อมูลใน Insert Row ถูกกำหนดครบแล้ว ให้เรียก insertRow() เพื่อบันทึกข้อมูลนี้ลงในฐานข้อมูล:

	   res.insertRow(); // บันทึกข้อมูลจาก Insert Row ลงในตาราง

	3. ย้ายกลับไปแถวเดิม
	   หลังจากเพิ่มข้อมูลใหม่เสร็จแล้ว สามารถย้าย Cursor กลับไปยังแถวก่อนหน้าได้:

	   res.moveToCurrentRow(); // กลับไปยังแถวก่อนหน้า

	เงื่อนไขการใช้งาน insertRow():
	- ต้องเปิดใช้งาน ResultSet แบบ Updateable:
	  ResultSet ต้องถูกสร้างด้วย Statement ที่รองรับ CONCUR_UPDATABLE เช่น:

	  Statement stm = connection.createStatement(
	      ResultSet.TYPE_SCROLL_INSENSITIVE,
	      ResultSet.CONCUR_UPDATABLE
	  );

	- ต้องอยู่ใน Insert Row:
	  ก่อนจะเรียก insertRow() ต้องใช้ moveToInsertRow() เพื่อย้ายไปยังแถวพิเศษนี้ก่อน

	ข้อควรระวัง:
	- ตรวจสอบสิทธิ์ของผู้ใช้งานฐานข้อมูลให้เหมาะสม เช่น สิทธิ์ INSERT
	- การเพิ่มข้อมูลด้วย ResultSet อาจไม่เหมาะกับกรณีที่ต้องเพิ่มข้อมูลจำนวนมาก
*/

	public static void main(String[] args) {
//		String url = "jdbc:derby:C:\\path\\to\\mydb;";
		String url = "jdbc:derby:/Users/sirivimonmeuntup/Documents/Dev_Project/Java-Workspace/javaocpse8/JDBC/mydb";

		JDBCUtils.rebuildTestTable();
		JDBCUtils.printTestTable();
		
		int resultType = ResultSet.TYPE_FORWARD_ONLY;
		int resultSetConcurrency = ResultSet.CONCUR_UPDATABLE;
		
		try (Connection c = DriverManager.getConnection(url);
				Statement stm = c.createStatement(resultType , resultSetConcurrency);
					ResultSet res = stm.executeQuery("select * from kunden")){
			
			/* 
			 * Spezielles ResultSet(CONCUR_UPDATABLE) kommt aus dem speziellen Statement
			 * Spezielles ResultSet hat eine spezielle Zeile: 'insert-row'
			 */
			
			/*
			 * Den Cursor zu der 'insert-row bewegen
			 */
			res.moveToInsertRow();   // Cursor ย้ายไปยังแถวพิเศษ  "Insert Row"
			
			/*
			 * Daten für den neuen Eintrag in der 'insert-row' vorbereiten
			 */
			res.updateInt(1, 4);				// oder res.updateInt("id",0)	// Spalte 1 (id)		
			res.updateString("name", "Jerry");
			res.updateInt("kontostand", 12345);
			/*
			 * Vorbereitete Daten in die Tabelle der Datenbank übertragen
			 */
			res.insertRow();   // บันทึกข้อมูลจาก Insert Row ลงในตาราง
			
			/*
			 * Optional. Den Cursor zu seiner urspunglich Position bewegen
			 */
			res.moveToCurrentRow();   // ย้ายกลับไปยังแถวเดิม
			
			/*
			 * wieder normal mit dem ResultSet arbeiten
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JDBCUtils.printTestTable();
	}
}
