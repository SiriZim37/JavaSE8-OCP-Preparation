package ocpexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCTest6 {

	public static void main(String[] args) throws SQLException {

			DBInitializer.init();
			String dbURL = DBInitializer.URL, userName = null, passWord = null;
			
	/* 9:*/	Connection conn = DriverManager.getConnection(dbURL, userName, passWord);
	/*10*/	String query = "SELECT id from Employee";
	/*11*/	try(Statement stmt = conn.createStatement()) {
	/*12*/		ResultSet rs = stmt.executeQuery(query);
	/*13*/		stmt.executeQuery("SELECT id from Customer");
	/*14*/		while(rs.next()) {
	/*15*/			// process the result
	/*16*/			System.out.println("Employee ID: "+ rs.getInt("id"));
	/*17*/		}
	/*18*/	} catch( Exception e ) {
	/*19*/		System.out.println("Error");
	/*20*/	}
	}

	/*
	Given the code fragment:
	
		Connection conn = DriverManager.getConnection(dbURL, userName, passWord);
		String query = "SELECT id from Employee";
		try(Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			stmt.executeQuery("SELECT id from Customer");
			while(rs.next()) {
				// process the result
				System.out.println("Employee ID: "+ rs.getInt("id"));
			}
		} catch( Exception e ) {
			System.out.println("Error");
		}
		
	Assume that:
	
		The required database driver is configured in the classpath.
		The appropriate database is accessible with the dbURL, userName, and passWord exists.
		The Employee and Customer tables are available and each table has id column with a few records and the SQL queries are valid.
		
	What is the result of compiling and executing this code fragment?
	
	A. The program prints employee IDs.
	B. The program prints customer IDs.
	C. The program prints Error.
	D. compilation fails on line 13. 
	
	
	
	Answer
	C
	
	[Caught Exception]
	java.sql.SQLException: ResultSet not open. Operation 'next' not permitted. Verify that autocommit is off. (explain later)
	
	[Console]
	Error
	 */
}
