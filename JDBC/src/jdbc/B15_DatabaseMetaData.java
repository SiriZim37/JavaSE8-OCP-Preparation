package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class B15_DatabaseMetaData {

	/**
	 * ตัวอย่างนี้แสดงวิธีการใช้ DatabaseMetaData ใน JDBC เพื่อดึงข้อมูล metadata 
	 * เกี่ยวกับฐานข้อมูลและโครงสร้างของฐานข้อมูล
	 * 
	 * DatabaseMetaData ให้ข้อมูลเกี่ยวกับฐานข้อมูล เช่น:
	 * - ชื่อและเวอร์ชันของฐานข้อมูล
	 * - ชื่อของ JDBC driver
	 * - ฟีเจอร์ SQL ที่รองรับ (batch updates, transactions, etc.)
	 * - ตาราง, คอลัมน์, คีย์หลัก, schemas, catalogs
	 * 
	 * เมธอดต่างๆ เช่น getDatabaseProductName(), getDatabaseProductVersion(), 
	 * getTables(), และ getColumns() ถูกใช้เพื่อดึงข้อมูล metadata ของฐานข้อมูล
	 * 
	 * เอกสารนี้เป็นคำแนะนำในการใช้ DatabaseMetaData ในการเชื่อมต่อ JDBC 
	 * และเป็นประโยชน์ในการเตรียมตัวสำหรับการสอบ OCP (Oracle Certified Professional) Java SE 8
	 */


	public static void main(String[] args) throws SQLException {
		
		try {
//			String url = "jdbc:derby:/Users/sirivimonmeuntup/Documents/Dev_Project/Java-Workspace/javaocpse8/JDBC/mydb";
			  // การเชื่อมต่อไปยังฐานข้อมูล (กรุณาแทนที่ด้วยข้อมูลที่ถูกต้อง)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            
            // ดึง DatabaseMetaData จาก Connection object
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            
            // พิมพ์ข้อมูลเกี่ยวกับฐานข้อมูล
            System.out.println("ชื่อผลิตภัณฑ์ของฐานข้อมูล: " + databaseMetaData.getDatabaseProductName());
            System.out.println("เวอร์ชันของผลิตภัณฑ์ฐานข้อมูล: " + databaseMetaData.getDatabaseProductVersion());
            System.out.println("ชื่อของ JDBC Driver: " + databaseMetaData.getDriverName());

            // ตัวอย่าง: ดึงข้อมูลตารางทั้งหมดในฐานข้อมูล
            ResultSet tables = databaseMetaData.getTables(null, null, "%", null);
            System.out.println("รายชื่อของตารางในฐานข้อมูล:");
            while (tables.next()) {
                // พิมพ์ชื่อของตาราง
                System.out.println("ตาราง: " + tables.getString("TABLE_NAME"));
            }

            // ตัวอย่าง: ดึงข้อมูลคอลัมน์ทั้งหมดของตาราง (กรุณาแทนที่ "TABLE_NAME" ด้วยชื่อจริงของตาราง)
            ResultSet columns = databaseMetaData.getColumns(null, null, "TABLE_NAME", "%");
            System.out.println("คอลัมน์ใน TABLE_NAME:");
            while (columns.next()) {
                // พิมพ์รายละเอียดคอลัมน์: ชื่อ, ประเภท, ขนาด
                System.out.println("ชื่อคอลัมน์: " + columns.getString("COLUMN_NAME"));
                System.out.println("ประเภทคอลัมน์: " + columns.getInt("DATA_TYPE"));
                System.out.println("ขนาดของคอลัมน์: " + columns.getInt("COLUMN_SIZE"));
            }

            // ตัวอย่าง: ตรวจสอบว่าฐานข้อมูลรองรับ batch updates หรือไม่
            boolean supportsBatchUpdates = databaseMetaData.supportsBatchUpdates();
            System.out.println("รองรับ Batch Updates หรือไม่: " + supportsBatchUpdates);
            
            // ตัวอย่าง: ดึงจำนวนการเชื่อมต่อสูงสุดที่ฐานข้อมูลรองรับ
            int maxConnections = databaseMetaData.getMaxConnections();
            System.out.println("จำนวนการเชื่อมต่อสูงสุด: " + maxConnections);

            // ปิดทรัพยากรที่ใช้
            tables.close();
            columns.close();
            connection.close();
        } catch (SQLException e) {
            // Handling SQL exceptions (e.g., issues with connecting to the database)
            e.printStackTrace();
        }
		
	}
}
