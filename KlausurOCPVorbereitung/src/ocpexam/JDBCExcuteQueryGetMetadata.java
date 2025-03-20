package ocpexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExcuteQueryGetMetadata {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "password";

        String query = "SELECT id, name FROM users";
	
	        try (Connection conn = DriverManager.getConnection(url, user, password);
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(query)) {
	
	            // Get the metadata from the ResultSet
	            ResultSetMetaData metaData = rs.getMetaData();
	            
	            // Get the number of columns in the ResultSet
	            int columnCount = metaData.getColumnCount();
	            System.out.println("Number of columns: " + columnCount);
	
	            // Loop through the columns and print their names
	            for (int i = 1; i <= columnCount; i++) {
	                String columnName = metaData.getColumnName(i);
	                System.out.println("Column " + i + ": " + columnName);
	            }
	
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
}


/*
 * 
 * What will be the output of this code when the users table has 2 columns (id and name) and 3 rows of data?

Choose the correct answer:

A) The output will display Number of columns: 2, followed by the column names: id and name.
B) The output will display Number of columns: 3, followed by the column names: id, name, and age.
C) The output will throw a SQLException because the ResultSetMetaData cannot be used with the executeQuery() method.
D) The output will display Number of columns: 2, followed by the column names: id, name, and id.

✅ Correct Answer:
A) The output will display Number of columns: 2, followed by the column names: id and name.
 */
