package ocp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelectDatabase {

	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = DriverManager.getConnection("dbURL", "userName", "passWord");
		String query = "SELECT id FROM Employee";
		try (Statement stmt = conn.createStatement())   {
		    ResultSet rs = stmt.executeQuery(query);
		   stmt.executeQuery("SELECT id FROM Customer");
		    while (rs.next())  {
		        //process the results
		       System.out.println("Employee ID: "+ rs.getInt("id"));
		   }
		} catch (Exception e) {
		    System.out.println ("Error");
		}
		 
	}
	/*
		QUESTION 53
		 Given the code fragment:
		 9. Connection conn = DriveManager.getConnection(dbURL, userName, passWord);
		 10. String query = "SELECT id FROM Employee";
		 11. try (Statement stmt = conn.createStatement())   {
		 12.     ResultSet rs = stmt.executeQuery(query);
		 13.    stmt.executeQuery(“SELECT id FROM Customer”);
		 14.     while (rs.next())  {
		 15.         //process the results
		 16.        System.out.println(“Employee ID: “+ rs.getInt(“id”));
		 17.    }
		 18. } catch (Exception e) {
		 19.     System.out.println (“Error”);
		 20. }
		 Assume that:
		  The required database driver is configured in the classpath.
		  The appropriate database is accessible with the dbURL, userName, and passWord exists.
		  The Employee and Customer tables are available and each table has id column 
		  with a few records and the SQL queries are valid.
		 What is the result of compiling and executing this code fragment?
		 A. The program prints employee IDs.
		 B. The program prints customer IDs.
		 C. The program prints Error.
		 D. compilation fails on line 13
		 
		 
		 
		 
		 โค้ดสามารถคอมไพล์ได้สำเร็จ หากการตั้งค่าฐานข้อมูลและไดรเวอร์ถูกต้อง
		แต่เมื่อรันโค้ด:
		จะเกิด Runtime Error เมื่อพยายามใช้งาน rs ในลูป while เพราะ ResultSet rs
		 ถูกปิดไปแล้วหลังจากเรียก executeQuery ครั้งที่สอง
		 
		ดังนั้นคำตอบที่น่าจะเหมาะสมกว่าคือ C. โปรแกรมแสดงข้อความ Error

		 ปัญหาที่บรรทัด 13:
		โค้ดที่เรียก stmt.executeQuery("SELECT id FROM Customer");
		 ขณะที่ ResultSet rs จาก stmt.executeQuery(query) ยังเปิดใช้งานอยู่
		ใน JDBC เมื่อใช้ Statement และเรียก executeQuery อีกครั้งบน Statement เดิม 
		ระบบจะปิด ResultSet ที่เปิดไว้ก่อนหน้านี้ทันที
		การพยายามเข้าถึง rs ในลูป while ที่บรรทัด 14 จะทำให้เกิดข้อผิดพลาดขณะรันโค้ด 
		(Runtime Error) เพราะ ResultSet ถูกปิดไปแล้ว
	 */
	 
}
