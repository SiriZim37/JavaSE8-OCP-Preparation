package ocpexam;

import java.sql.*;

/*
 stmt.setFetchSize(50): การตั้งค่า fetchSize เป็น 50 หมายความว่า JDBC driver จะดึงข้อมูล 50 แถวจากฐานข้อมูลในแต่ละครั้งที่มีการ query
เมื่อ executeQuery() ถูกเรียก JDBC driver จะดึงข้อมูลจากฐานข้อมูลเป็นชุด ๆ โดยใช้ค่าที่กำหนดไว้ใน fetchSize (50 แถวในกรณีนี้)
 */


public class JDBCexcuteQueyWithFetchSize {

	public static void main(String[] args) {
		
		 String url = "jdbc:mysql://localhost:3306/mydatabase";
	        String user = "root";
	        String password = "password";
	        String query = "SELECT id, name FROM users";

	        try (Connection conn = DriverManager.getConnection(url, user, password);
	             Statement stmt = conn.createStatement()) {

	            // กำหนด fetch size ให้ดึงข้อมูล 50 แถวในแต่ละครั้ง
	            stmt.setFetchSize(50);

	            // Execute query
	            ResultSet rs = stmt.executeQuery(query);

	            // ทำการวนลูปผ่าน ResultSet
	            while (rs.next()) {
	                System.out.println(rs.getInt("id") + " :: " + rs.getString("name"));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
}

