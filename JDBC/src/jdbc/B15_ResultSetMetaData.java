package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class B15_ResultSetMetaData {

	/*
	 * การใช้งาน ResultSetMetaData ใน Java
	 *
	 * ResultSetMetaData ใช้สำหรับดึงข้อมูลเกี่ยวกับโครงสร้างของ ResultSet เช่น ข้อมูลเกี่ยวกับคอลัมน์ในฐานข้อมูล
	 * ซึ่งจะช่วยให้เราทราบข้อมูลเช่น จำนวนคอลัมน์, ชื่อคอลัมน์, ประเภทข้อมูลของคอลัมน์ และอื่นๆ
	 *
	 * วิธีการใช้งาน:
	 * 1. getMetaData() 						- ใช้เพื่อดึงข้อมูลเมตาของ ResultSet (ข้อมูลโครงสร้างของคอลัมน์)
	 *    											ตัวอย่าง: ResultSetMetaData rsmd = resultSet.getMetaData();
	 * 2. getColumnCount():int 					- ใช้เพื่อดึงจำนวนคอลัมน์ใน ResultSet
	 * 3. getColumnName(int column):String		- ใช้เพื่อดึงชื่อคอลัมน์ที่ระบุ (ตามหมายเลขคอลัมน์)
	 * 4. getColumnType(int column):int 		- ใช้เพื่อดึงประเภทข้อมูลในคอลัมน์ (เช่น VARCHAR, INT)
	 * 5. getColumnTypeName(int column): String	- ใช้เพื่อดึงชื่อประเภทข้อมูลในคอลัมน์ (เช่น VARCHAR, INTEGER)
	 * 6. isNullable(int column):int 			- ใช้เพื่อตรวจสอบว่าคอลัมน์นั้นรองรับค่า NULL หรือไม่(ค่าระบุว่า nullable หรือไม่ เช่น ResultSetMetaData.columnNullable)
	 * 7. getColumnDisplaySize(int column):int	- ใช้เพื่อดึงขนาดการแสดงผลของคอลัมน์ (ความยาวที่เหมาะสมในการแสดงข้อมูล)
	 * 8. isAutoIncrement(int column):boolean 	- ใช้เพื่อตรวจสอบว่าคอลัมน์นั้นมีการเพิ่มค่าอัตโนมัติหรือไม่ (true ถ้าเป็นคอลัมน์ auto-increment)
	 */


	public static void main(String[] args) throws SQLException {
		String url = "jdbc:derby:/Users/sirivimonmeuntup/Documents/Dev_Project/Java-Workspace/javaocpse8/JDBC/mydb";
//		String url = "jdbc:derby:C:\\path\\to\\mydb;";

		JDBCUtils.rebuildTestTable();


		try (Connection c = DriverManager.getConnection(url);
				Statement stm = c.createStatement();
				ResultSet res = stm.executeQuery("select * from kunden")) {
		
		ResultSetMetaData rsmd = res.getMetaData();
		
		int column = 1;
		String tableName = rsmd.getTableName(column); 
		System.out.println("tableName: " + tableName); // KUNDEN
		
		int columnCount = rsmd.getColumnCount();
		System.out.println("columnCount: " + columnCount); // 3


		String columnTypeName = rsmd.getColumnTypeName(1);
		System.out.println("getColumnTypeName: " + columnTypeName); // 3
		
		for(column = 1; column <= columnCount; column++) {
			String columnName = rsmd.getColumnName(column);
			System.out.println("  columnName: " + columnName);
		}
		
	}
		
	}
}
