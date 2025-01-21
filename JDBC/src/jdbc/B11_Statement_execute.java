package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B11_Statement_execute {

	/*
	 *  ResultSet executeQuery(String sql) throws SQLException
	 *  - ใช้สำหรับการเรียกคำสั่ง SQL ประเภท SELECT
	 *  - ผลลัพธ์ที่ได้จะอยู่ในรูปของ ResultSet ซึ่งสามารถใช้ในการวนลูปเพื่ออ่านข้อมูลแต่ละแถวจากฐานข้อมูล
	 *  - หากเกิดข้อผิดพลาดระหว่างการประมวลผล จะโยน SQLException
	 *
	 *  int executeUpdate(String sql) throws SQLException
	 *  - ใช้สำหรับคำสั่ง SQL ที่เปลี่ยนแปลงข้อมูล เช่น INSERT, UPDATE, DELETE
	 *  - ผลลัพธ์จะคืนค่าจำนวนแถวที่ได้รับผลกระทบจากคำสั่ง
	 *  - หากเกิดข้อผิดพลาด จะโยน SQLException
	 *
	 *  boolean execute(String sql) throws SQLException
	 *  - ใช้สำหรับการรันคำสั่ง SQL ที่ไม่ทราบลักษณะคำสั่งที่แน่นอน เช่น SELECT หรือ DDL (CREATE, DROP)
	 *  - คืนค่า true หากคำสั่งเป็น SELECT (สามารถเรียก getResultSet() เพื่ออ่านข้อมูล)
	 *  - คืนค่า false หากคำสั่งเป็นประเภทที่ไม่คืนผลลัพธ์ (เช่น UPDATE)
	 *  - หากเกิดข้อผิดพลาด จะโยน SQLException
	 */

	public static void main(String[] args) {
//		String url = "jdbc:derby:C:\\path\\to\\mydb";
		String url = "jdbc:derby:/Users/sirivimonmeuntup/Documents/Dev_Project/Java-Workspace/javaocpse8/JDBC/mydb";

		JDBCUtils.rebuildTestTable();
		JDBCUtils.printTestTable();
		
		try (Connection c = DriverManager.getConnection(url);
				Statement stm = c.createStatement()){
			
			/*
			 * ResultSet executeQuery(String sql) throws SQLException
			 */
			try (ResultSet res = stm.executeQuery("select * from kunden")){
				res.next();
				System.out.println("1. name: "+ res.getString("name") );
			}
			/*
			 * int executeUpdate(String sql) throws SQLException;
			 */
			int zeile = stm.executeUpdate("update kunden set kontostand=0 where kontostand > 1000");
			System.out.println("\n2. Zeiel, die für die where-Klausel passen: "+ zeile);
			JDBCUtils.printTestTable();
			
			/*
			 * boolean execute(String sql) throws SQLException;
			 */
			stm.execute("select * from kunden");		// erzeugt ein neues ResultSet
			System.out.println("\n3. ResultSet erzeugt");
			
			ResultSet res = stm.getResultSet();
			res.next();
			System.out.println("\n4. name: " + res.getString(2));
			
			/* 
			  * - kann andere Befehle auch ausführen
			  */
			stm.execute("update kunden set kontostand=555 where kontostand =0");
			JDBCUtils.printTestTable();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
