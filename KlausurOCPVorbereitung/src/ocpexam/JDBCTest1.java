package ocpexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest1 {

	public static void main(String[] args) {
		
		
		
	}
	/*
	 Given records from the Player table: 
	 
	 PID 		PNAME
	 1			Dave
	 2			Jack
	 3			Sam
	 
	 and given the code fragment:
	
		try {
			
			Connection conn = DriverManager.getConnection(URL, username, password);
			
			Statement st= conn.createStatement(
			
			ResultSet.TYPE_SCROLL_SENSITIVE,
			
			ResultSet.CONCUR_UPDATABLE);
			
			st.execute ("SELECT * FROM Player");
			
			st.setMaxRows(2);
			
			ResultSet rs = st.getResultSet();
			
			rs.absolute(3);
		
			while (rs.next ()) {
			
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
			
			}
		
		} catch (SQLException ex) {
		
			System.out.print("SQLException is thrown.");
		
		}
	
	Assume that:
	
	The required database driver is configured in the classpath.
	
	The appropriate database is accessible with URL, username, and password.
	
	The SQL query is valid.
	
	What is the result?
	
	Options
	A	2 Jack3 Sam
	B	The program prints nothing.
	C	3 Sam
	D	SQLException is thrown.
	
	
	Answer
	D
	 */
}
