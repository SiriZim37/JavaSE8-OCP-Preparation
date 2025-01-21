package ocp2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
  QUESTION 56
 Given:
 Item table
 • ID, INTEGER: PK
 • DESCRIP, VARCHAR(100)
 • PRICE, REAL
 • QUANTITY< INTEGER
 And given the code fragment:
 9. try {
 10.    Connection conn = DriveManager.getConnection(dbURL, username, password);
 11.     String query = “Select * FROM Item WHERE ID = 110”;
 12.     Statement stmt = conn.createStatement();
 13.     ResultSet rs = stmt.executeQuery(query);
 14.    while(rs.next())   {
 15.        System.out.println(“ID:        “ + rs.getInt(“Id”));
 16.        System.out.println(“Description:    “ + rs.getString(“Descrip”));
 17.        System.out.println(“Price:        “ + rs.getDouble(“Price”));
 18.         System.out.println(Quantity:        “ + rs.getInt(“Quantity”));
 19.    }
 20. } catch (SQLException se)  {
 21.     System.out.println(“Error”);
 22. }
 Assume that:
    The required database driver is configured in the classpath.
    The appropriate database is accessible with the dbURL, userName, and passWord exists.
    The SQL query is valid.
 What is the result?
 A. An exception is thrown at runtime.
 B. Compilation fails.
 C. The code prints Error.
 D. The code prints information about Item 110
 */
public class JDBCSelectInNormaleTryBlock {

	 public static void main(String[] args) {
	        // Database connection details
	        String dbURL = "jdbc:your_database_url"; // Replace with your database URL
	        String username = "your_username"; // Replace with your database username
	        String password = "your_password"; // Replace with your database password

	        try {
	            // Establishing the connection
	            Connection conn = DriverManager.getConnection(dbURL, username, password);

	            // Query to select Item with ID = 110
	            String query = "SELECT * FROM Item WHERE ID = 110";

	            // Creating a Statement object
	            Statement stmt = conn.createStatement();

	            // Executing the query and getting the result
	            ResultSet rs = stmt.executeQuery(query);

	            // Looping through the result set
	            while (rs.next()) {
	                // Printing the values of ID, Descrip, Price, and Quantity
	                System.out.println("ID:        " + rs.getInt("ID"));
	                System.out.println("Description:    " + rs.getString("DESCRIP"));
	                System.out.println("Price:        " + rs.getDouble("PRICE"));
	                System.out.println("Quantity:        " + rs.getInt("QUANTITY"));
	            }

	        } catch (SQLException se) {
	            // Catching and printing any SQL exceptions
	            System.out.println("Error: " + se.getMessage());
	        }
	    }
	 
	 /*
	  	The correct answer is D. The code prints information about Item 110.

		Explanation:
			The code attempts to execute a SQL query (SELECT * FROM Item WHERE ID = 110) on the Item table.
			The connection is established using DriverManager.getConnection(dbURL, username, password) and a Statement is created to execute the query.
			A ResultSet (rs) is created from the query, and the code iterates through the results using rs.next().
			Inside the loop, it prints information about the ID, Description, Price, and Quantity columns for the item with ID = 110.
		Why D is correct:
			No compilation error: The SQL query is valid, and the column names are correctly referenced in the rs.getX() methods. The syntax is correct, so compilation will succeed.
			No runtime exception: The database connection, query, and result retrieval are all handled properly, so no exceptions are expected at runtime, assuming that the database is accessible and contains a record with ID = 110.
	  */
}
