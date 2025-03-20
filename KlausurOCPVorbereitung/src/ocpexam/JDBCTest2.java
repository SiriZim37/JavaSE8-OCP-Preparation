package ocpexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest2 {

	public static void main(String[] args) {
		
		
		
	}
	/*
	 Given:

	Item table
	
	* ID, INTEGER: PK
	
	* DESCRIP, VARCHAR(100)
	
	* PRICE, REAL
	
	* QUANTITY< INTEGER
	
	
	And given the code fragment:
	
	try {
	
		Connection conn = DriveManager.getConnection(dbURL, username, password);
		
		 String query = "Select * FROM Item WHERE ID = 110";
		
		 Statement stmt = conn.createStatement();
		
		 ResultSet rs = stmt.executeQuery(query);
	
		while(rs.next()) {
		
			System.out.println(''ID:'' + rs.getString(1));
			
			System.out.println(''Description:'' + rs.getString(2));
			
			System.out.println(''Price:'' + rs.getString(3));
			
			System.out.println(Quantity:'' + rs.getString(4));
		
		}
	
	 }catch (SQLException se) {
	
	 System.out.println(''Error'');
	
	 }
	
	Assume that:
	
	The required database driver is configured in the classpath.
	
	The appropriate database is accessible with the dbURL, userName, and passWord exists.
	
	The SQL query is valid.
	
	What is the result?
	
	
	Options
	A	An exception is thrown at runtime.
	B	Compilation fails.
	C	The code prints Error.
	D	The code prints information about Item 110.
	
	
	
	Answer
	B
	 */
}
