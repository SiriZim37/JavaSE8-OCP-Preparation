package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B10_ResultSet {

	public static void main(String[] args) throws SQLException {
		
		JDBCUtils.rebuildTestTable();

		/*
		 * Standard-ResultSet kommt aus dem Standard-Statement
		 */
		/*
		 * ข้อผิดพลาดเกิดจากการใช้ previous() กับ ResultSet แบบปกติ ซึ่งไม่รองรับการเคลื่อนที่ย้อนกลับ.
		 * ต้องใช้ ResultSet ที่สร้างจาก Statement แบบ scrollable เพื่อนำไปใช้ฟังก์ชัน previous() ได้.
		 * 
		 */
//		String url = "jdbc:derby:C:\\path\\to\\mydb";
		String url = "jdbc:derby:/Users/sirivimonmeuntup/Documents/Dev_Project/Java-Workspace/javaocpse8/JDBC/mydb";
		// window > "jdbc:derby:C:\\path\\to\\mydb;";
		
		try (Connection c = DriverManager.getConnection(url) ; 
				Statement stm = c.createStatement();
					ResultSet res = stm.executeQuery("select * from kunden")){
			
			res.next();
			res.previous();		// java.sql.SQLException ! The 'previous()' method is only allowed on scroll cursors.
			
		}catch (SQLException e) {
			System.out.println("1. Fehler ResultSet ist vom Typ FORWARD_ONLY");
		}
		
		
		//-----------------------------------------------------------------//
		/*
		 * สาเหตุของข้อผิดพลาด:
			- ResultSet ที่สร้างขึ้นจาก Statement ด้วยวิธีปกติจะมีลักษณะเป็น Forward-Only Cursor 
				ซึ่งหมายความว่าเราสามารถย้ายตัวชี้ได้แค่ไปข้างหน้าเท่านั้น (โดยใช้ next()).		
			- หากต้องการใช้ previous() หรือ absolute() ต้องใช้ ResultSet 
				แบบ Scroll-Insensitive หรือ Scroll-Sensitive 
				โดยต้องระบุพารามิเตอร์ใน createStatement() เช่น:
		*/		
		/*
		 * Spezeilles ResultSet kommt aus dem speziellen Staement
		 */
		
		int type = ResultSet.TYPE_SCROLL_INSENSITIVE;   //กำหนดให้ ResultSet สามารถเลื่อนขึ้นหรือลงได้ (scrollable cursor) โดยไม่สนใจการเปลี่ยนแปลงข้อมูลที่เกิดขึ้นในฐานข้อมูลขณะที่ ResultSet เปิดอยู่ 
		int concurrency = ResultSet.CONCUR_READ_ONLY;	//  กำหนดให้ ResultSet เป็นแบบอ่านอย่างเดียว (read-only) ซึ่งหมายความว่าเราไม่สามารถอัปเดตข้อมูลใน ResultSet 
		try (Connection c = DriverManager.getConnection(url) ; 
				Statement stm = c.createStatement(type , concurrency);
					ResultSet res = stm.executeQuery("select * from kunden")){
			
			res.next();
			res.previous();		
			System.out.println("2. Rückwärts den Curser bewegt ");	// ok 
			
			System.out.println("2.Ergebnis: " + res.getString("name")	);	// java.sql.SQLException Invalid cursor state - no current row.
		}catch (SQLException e) {
			System.out.println("2. Invalid cursor state - no current row.");
		}
		
		//-----------------------------------------------------------------//
				
		/*
		 * Achtung! Exam
		 * Der Cursor steht zuerst VOR der 1.Zeile!!!
		 */
		/*
		 * โค้ดนี้มีการอธิบายเกี่ยวกับการทำงานของ ResultSet และตำแหน่งของ cursor (ตัวชี้ข้อมูล) 
		 * ที่อยู่ใน ResultSet ซึ่งจะเป็นสาเหตุที่ทำให้เกิดข้อผิดพลาดถ้าเรียกใช้ข้อมูลจาก ResultSet 
		 * ก่อนที่จะทำการขยับตัวชี้ (cursor).
		 * 
		 * ข้อผิดพลาด (Exception): เพราะว่า ResultSet ยังไม่ได้ขยับไปที่แถวใด ๆ (cursor ยังคงอยู่ก่อนแถวแรก) 
		 * ทำให้การเรียก getString("name") จะเกิดข้อผิดพลาดขึ้น 
		 * โดยจะมีข้อผิดพลาดประเภท SQLException เกิดขึ้นเนื่องจากตัวชี้ยังไม่อยู่ในแถวใด ๆ ที่มีข้อมูล.
		 */
		try (Connection c = DriverManager.getConnection(url) ; 
				Statement stm = c.createStatement();
					ResultSet res = stm.executeQuery("select * from kunden")){
			
			res.getString("name");		//Exception 	
										// res.getString("name");: พยายามดึงข้อมูลจากคอลัมน์ name ในแถวแรกของ ResultSet.

		}catch (SQLException e) {
			System.out.println("3. Fehler Cursor zeigt auf keine Zeile" + e);  // SQLException : Invalid cursor state - no current row.
		}
		
		
		//-----------------------------------------------------------------//
				
		/*
		 * Achtung! Exam
		 * Ein Staement kann nur ein ResultSet auf einmal unterstüzen! 
		 * Wenn ein neues ResultSet erstellt wird , wird das vorherige 
		 * ResultSet automatisch geschlossen!!!
		 * 
		 * คำเตือนนี้บอกว่า Statement สามารถรองรับได้แค่ หนึ่ง ResultSet ในครั้งเดียว 
		 * หากมีการสร้าง ResultSet ใหม่ ResultSet เก่าจะถูกปิด โดยอัตโนมัติ.
		 */
		try(Connection c = DriverManager.getConnection(url);
				Statement stm = c.createStatement();) {
			
			ResultSet res1 = stm.executeQuery("select * from kunden");
			
			res1.next();	// res1.next();: ขยับ cursor ไปที่แถวแรก.
			
			System.out.println("4. " + res1.getString("name"));  	// Peter
			
			stm.executeQuery("select* from kunden");  		// neues ResultSet erzeugt
															// altes ResultSet wird dabei
															// automatisch geschlossen
			//เนื่องจาก  Statement สามารถรองรับได้เพียง หนึ่ง ResultSet เท่านั้น, เมื่อมีการสร้าง ResultSet ใหม่, ResultSet เก่าจะถูกปิดโดยอัตโนมัติ.
			
			res1.getString("name");		// java.sql.SQLException : ResultSet not open. Operation 'getString' not permitted. Verify that autocommit is off.
										//res1.getString("name");: เมื่อพยายามดึงข้อมูลจาก res1 
										//ซึ่งเป็น ResultSet เก่าที่ถูกปิดไปแล้ว จะเกิดข้อผิดพลาด SQLException ขึ้น และข้อความข้อผิดพลาดจะเป็น
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
}
