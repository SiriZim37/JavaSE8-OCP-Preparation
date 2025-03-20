package ocpexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCCreateConnection {

	public static void main(String[] args) {		
		
		   String driverClassName = "com.mysql.cj.jdbc.Driver";
	        String url = "jdbc:mysql://localhost:3306/mydatabase";
	        String user = "root";
	        String password = "password";

	        url = "Class.forName(driverClassName)";  // ข้อผิดพลาดตรงนี้!

	        try (Connection conn = DriverManager.getConnection(url, user, password)) {
	            if (conn != null) {
	                System.out.println("เชื่อมต่อสำเร็จ!");
	            }
	        } catch (SQLException e) {
	            System.out.println("เชื่อมต่อไม่สำเร็จ!");
	        }
		
	}
}
