package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class B09_Statement {

	/*
	 * สรุป:
	 * Statement: ใช้สำหรับรันคำสั่ง SQL ที่ไม่ต้องการพารามิเตอร์
	 * PreparedStatement: ใช้สำหรับคำสั่ง SQL ที่มีพารามิเตอร์ที่ต้องการค่าจากผู้ใช้และสามารถป้องกัน SQL Injection
	 * CallableStatement: ใช้สำหรับการเรียกใช้ stored procedures หรือฟังก์ชันในฐานข้อมูล
	 */
	public static void main(String[] args) {
		
		JDBCUtils.rebuildTestTable();
		
		/*
		 * Statment. einfache Variante erzeugt 
		 * Statement เป็นวิธีที่ง่ายที่สุดในการใช้ SQL คำสั่งที่ไม่ต้องการค่าพารามิเตอร์ที่กำหนดจากผู้ใช้
		 * นโค้ดนี้ เรากำหนด SQL คำสั่งเพื่อเพิ่มข้อมูลลงในตาราง kunden โดยตรง
		 * โค้ดในส่วนนี้จะสร้าง Statement จาก Connection แล้วใช้ executeUpdate() เพื่อรัน SQL คำสั่ง
		 */
//		String url = "jdbc:derby:C:\\path\\to\\mydb";
		String url = "jdbc:derby:/Users/sirivimonmeuntup/Documents/Dev_Project/Java-Workspace/javaocpse8/JDBC/mydb";
		// window > "jdbc:derby:C:\\path\\to\\mydb;";
		
		try (Connection c = DriverManager.getConnection(url);
				Statement stm = c.createStatement()){
			
			String sql = "insert into kunden (id,name,kontostand) values ( 4, 'Ute',3200)";
			stm.executeUpdate(sql);
		
			JDBCUtils.printTestTable();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		System.out.println();
		
		/*
		 * PrepareStatement (การใช้ PreparedStatement):
		 * PreparedStatement คือการเตรียม SQL คำสั่งที่สามารถใช้หลายครั้งได้ และสามารถกำหนดพารามิเตอร์แบบไดนามิกได้
		 * การใช้ PreparedStatement ช่วยเพิ่มความปลอดภัย (ป้องกัน SQL Injection) และประสิทธิภาพเมื่อคำสั่ง SQL ต้องทำงานหลายครั้งโดยเปลี่ยนค่าพารามิเตอร์
		 */
		
		String sql = "insert into kunden (id,name,kontostand) values ( ?, ? , ?)";
		
		try (Connection c = DriverManager.getConnection(url);
				PreparedStatement stm = c.prepareStatement(sql)){
			
			int parameterColumnIndex =1; 
			
			// Werte für die Platzhalter festlegen
			stm.setInt(parameterColumnIndex, 5);					// id = 5 
			stm.setString(parameterColumnIndex +1 , "Tobias");		// name = Tobias
			stm.setInt(parameterColumnIndex + 2, 412);      		// kontostand = 412
			
			//Sql-Befehl
			stm.execute();
			
			JDBCUtils.printTestTable();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*
		 * weitere Statement-Art: CallableStatement
		 * 
		 * CallableStatement (การใช้ CallableStatement):
		 * CallableStatement ถูกใช้สำหรับเรียกใช้ stored procedures หรือฟังก์ชันที่อยู่ในฐานข้อมูล
		 */
		
//		?????????????????????????????????
//		try (Connection c = DriverManager.getConnection(url)) {
//	       
//	       String sql = "{call getCustomerById(?, ?)}";  // The stored procedure call
//	       // Prepare the callable statement
//	       try (CallableStatement stmt = c.prepareCall(sql)) {
//	         
//	    	   // Set input parameters
//	           stmt.setInt(1, 1);  // For example, we want to get the customer with ID 1
//	           
//	           // Register the output parameter (the second parameter is a String)
//	           stmt.registerOutParameter(2, Types.VARCHAR);
//	           stmt.execute();
//
//
//	           String customerName = stmt.getString(2);
//	           System.out.println("Customer name: " + customerName);
//
//	       } catch (SQLException e) {
//	           e.printStackTrace();
//	       }
//
//	   } catch (SQLException e) {
//	       e.printStackTrace();
//	   }
		
	}
}
