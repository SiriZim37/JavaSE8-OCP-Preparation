package ocpexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCSelectTableAbsoluMovetoinsert {

	public static void main(String[] args) {		
		
		    String url = "jdbc:mysql://localhost:3306/mydatabase";
	        String user = "root";
	        String password = "password";

	        String query = "SELECT id, name FROM users";

	        try (Connection conn = DriverManager.getConnection(url, user, password);
	             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	             ResultSet rs = stmt.executeQuery(query)) {

	            // Move to the second-to-last row
	            rs.absolute(-2);
	            
	            // Move to the insert row
	            rs.moveToInsertRow();
	            rs.updateInt(1, 2); // Set id = 2
	            rs.updateString(2, "Jerry"); // Set name = Jerry
	            
	            // Insert the new row
	            rs.insertRow();
	            
	            // Display all results
	            while (rs.next()) {
	                System.out.println(rs.getInt(1) + " :: " + rs.getString(2));
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}
}

/*
 What is the result of this code when the users table contains 4 rows with data?
Choose the correct answer:

A) The code will insert a new row with id = 2 and name = Jerry at the second-to-last position, and all 5 rows will be displayed.
B) The code will insert a new row with id = 2 and name = Jerry at the second position, and all 5 rows will be displayed in order.
C) A SQLException will be thrown because absolute(-2) cannot be used with a ResultSet that only has 4 rows.
D) The code will delete the second row and insert the new row at the third position.


✅ Correct Answer:
A) The code will insert a new row with id = 2 and name = Jerry at the second-to-last position (because of absolute(-2)). All 5 rows will be displayed, including the new row.


 */


