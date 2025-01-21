package jdbc.aufgaben;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AufgabenJDBC {
	
	public static void main(String[] args) {
		Path filePath;
		String text;
		
		JDBCUtils.rebuildTable();
		JDBCUtils.printTable();
		
		System.out.println("\nload files...");
		
		try (Connection c = JDBCUtils.getConnection();
				Statement stm = c.createStatement()){
	
			
//			Path filePath = Paths.get("sql/drop_table.sql"); 			   
//			String text = ResourceLoader.load(filePath);
//			System.out.println(text);  	
//			stm.executeUpdate(text);
			
//			filePath = Paths.get("sql/create_table.sql"); 			   
//			text = ResourceLoader.load(filePath);
//			System.out.println(text);  	
//			stm.executeUpdate(text);
			
			filePath = Paths.get("sql/insert_data.sql"); 			   
			text = ResourceLoader.load(filePath);
			System.out.println(text);  	
			stm.executeUpdate(text);		
			
			JDBCUtils.printTable();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
