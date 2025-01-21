package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class B04_Update {

	public static void main(String[] args) {
		
		String sql = "update animals set age=50 , name ='Ashley'  where id=201 and name='Mike' and age=50";
		
		String url = "jdbc:derby:/Users/sirivimonmeuntup/Documents/Dev_Project/Java-Workspace/javaocpse8/JDBC/mydb";
		// window > "jdbc:derby:C:\\path\\to\\mydb;";
		
		try (Connection c = DriverManager.getConnection(url) ;
				Statement stm = c.createStatement();){

//			int rowsChanged = stm.executeUpdate(sql);		
//			if(rowsChanged >0 ) {
//				System.out.println("Table animals geändert");
//			}else {
//				System.out.println("Tabelle animals wurde nicht geändert");
//			}
			
			int rowsFound = stm.executeUpdate(sql);
			
			System.out.println("Tabelle animals (evtl.) geändert");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
