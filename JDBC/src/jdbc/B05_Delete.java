package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class B05_Delete {

	public static void main(String[] args) {
		
		String sql = "delete from animals where name='Tom' and age=5";
		
		String url = "jdbc:derby:/Users/sirivimonmeuntup/Documents/Dev_Project/Java-Workspace/javaocpse8/JDBC/mydb";
		// window > "jdbc:derby:C:\\path\\to\\mydb;";
		
		try (Connection c = DriverManager.getConnection(url);
				Statement stm = c.createStatement()){
			
			int rowsDeleted = stm.executeUpdate(sql);
			
			System.out.println("Zeilen gelöscht: " + rowsDeleted);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
