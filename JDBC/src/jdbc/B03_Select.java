package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class B03_Select {

	public static void main(String[] args) {
		
		String sql = "select * from animals";
		
		String url = "jdbc:derby:/Users/sirivimonmeuntup/Documents/Dev_Project/Java-Workspace/javaocpse8/JDBC/mydb";
		// window > "jdbc:derby:C:\\path\\to\\mydb;";
		
		try (Connection c = DriverManager.getConnection(url) ;
				Statement stm = c.createStatement();
					ResultSet res = stm.executeQuery(sql)){
		
			while (res.next() ) {
				int id = res.getInt("id");
				
				int column = 2; // Achtung! JDBC-Nummerierung startet mit 1!
				String name = res.getString(column);
				
				// alternativ mit dem Spaltennamen als Argument:
//				String name = res.getString("name"); // auch ok
				
				
				
				// alternativ mit dem Spaltennamen:
//				int age = res.getInt("age");
				int age = res.getInt(3); // auch ok

				System.out.println("id: " + id + ", name: " + name + ", age: " + age);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
