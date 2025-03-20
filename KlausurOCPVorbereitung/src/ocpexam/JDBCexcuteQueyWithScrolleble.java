package ocpexam;

import java.sql.*;

public class JDBCexcuteQueyWithScrolleble {

	public static void main(String[] args) {
		
		
		String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "password";

        String query = "SELECT id, name FROM users";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery(query)) {
        	 
            // Scroll the cursor to before the first row
            rs.beforeFirst();

            // Move to the first row
            rs.next();
            System.out.println("First Row: " + rs.getInt("id") + " :: " + rs.getString("name"));

            // Move the cursor to after the last row
            rs.afterLast();

            // Move the cursor back to the previous row (from afterLast)
            rs.previous();
            System.out.println("Last Row (from afterLast): " + rs.getInt("id") + " :: " + rs.getString("name"));

            // Use relative(-2) to move the cursor two rows back
            rs.relative(-2);
            System.out.println("Row after moving -2 rows: " + rs.getInt("id") + " :: " + rs.getString("name"));

            // Move to the next row and print the data
            rs.next();
            System.out.println("Next Row: " + rs.getInt("id") + " :: " + rs.getString("name"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}



