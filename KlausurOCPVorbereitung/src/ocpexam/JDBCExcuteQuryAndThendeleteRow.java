package ocpexam;

import java.sql.*;

public class JDBCExcuteQuryAndThendeleteRow {

	public static void main(String[] args) {
		
		String query = "SELECT id, name FROM users";
		try (Connection conn = DriverManager.getConnection("url", "user", "password");
		     Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		     ResultSet rs = stmt.executeQuery(query)) {

		    // Assume there are 4 rows in the ResultSet
		    rs.next();  // Move to the first row
		    rs.deleteRow(); // Delete the current row (first row)

		    rs.next(); // Move to the second row
		    rs.updateString("name", "UpdatedName"); // Update the 'name' column
		    rs.updateRow(); // Apply the update

		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
	}
	
	
	/*
	 * What will be the result of executing the code?

		A)
		The first row is deleted successfully.
		The second row's name is updated successfully to "UpdatedName".
		The third row and fourth row remain unchanged.
		B)
		The first row is deleted successfully.
		The second row is updated to "UpdatedName", but the changes are not applied to the database.
		C)
		An exception is thrown when trying to delete the first row because deleteRow() cannot be used in a ResultSet with CONCUR_READ_ONLY.
		D)
		The first row is deleted, but no update will occur to the second row because updateRow() needs to be called in the correct order.
		
		
		
		
		
		
		Answer:
		A)
		
		Explanation:
		deleteRow() deletes the current row from the ResultSet.
		updateString() changes the value of the name column in the second row.
		updateRow() applies the update to the ResultSet, but it also affects the underlying database.
		Since the ResultSet is of type TYPE_SCROLL_SENSITIVE and CONCUR_UPDATABLE, the changes will be reflected in the database after calling updateRow().
	 */
}
