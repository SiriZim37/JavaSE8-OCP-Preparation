package jdbc.aufgaben;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	
	private static final String URL = "jdbc:derby:C:\\path\\to\\mydb;create=true"; 
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL);
	}
	
	public static void rebuildTable() {
		
		String createTableSql = "create table personnen (" +
				                 "id int primary key, " +
				                 "vorname varchar(50), " +
				                 "nachname varchar(50), " +
				                 "geburtsjahr int)";

		try(Connection c = getConnection();
				Statement stm = c.createStatement()) {
			
			// Drop
			try {
				stm.executeUpdate("drop table personnen");
				System.out.println("***Alte Table 'personnen' gelöscht.");
			} catch (SQLException e) {
				if("42Y55".equals(e.getSQLState())) {
					System.out.println("***Tabelle 'personnen' existiert nicht");
				} else {
					throw e;
				}
			}

			// Create
			stm.executeUpdate(createTableSql);
			System.out.println("***Tabelle 'kunden' erzeugt");
			
			// Insert
			String insertTableSql = "insert into personnen (id, vorname, nachname, geburtsjahr) values ( ?, ? , ? ,?)";
			try (Connection conn = getConnection();
				     PreparedStatement pstm = conn.prepareStatement(insertTableSql)) {
				
				pstm.setInt(1, 1); 				// ID = 1 
				pstm.setString(2, "Zomie"); 	// Vorname
				pstm.setString(3, "Müller"); 	// Nachname
				pstm.setInt(4, 1985); 			// Geburtsjahr
				
				int rowsInserted = pstm.executeUpdate();
				System.out.println(rowsInserted + " Zeile(n) eingefügt.");
				
				pstm.setInt(1, 2); 				// ID = 2 
				pstm.setString(2, "Bibo"); 		
				pstm.setString(3, "Hwak"); 		
				pstm.setInt(4, 1886); 			
				
				rowsInserted = pstm.executeUpdate();
				System.out.println(rowsInserted + " Zeile(n) eingefügt.");
				
				pstm.setInt(1, 3); 				// ID = 3
				pstm.setString(2, "Anna"); 		
				pstm.setString(3, "Popkin"); 	
				pstm.setInt(4, 1994); 			
				
				rowsInserted = pstm.executeUpdate();
				System.out.println(rowsInserted + " Zeile(n) eingefügt.");
				
				pstm.setInt(1, 4); 				// ID = 4
				pstm.setString(2, "Leo"); 		
				pstm.setString(3, "Merzaros"); 	
				pstm.setInt(4, 2020); 			
				
				rowsInserted = pstm.executeUpdate();
				System.out.println(rowsInserted + " Zeile(n) eingefügt.");
				 
			}catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	
	
	public static void printTable() {
		String selectTableSql = "select * from personnen";
	
		try (Connection c = getConnection();
				Statement stm = c.createStatement();
					ResultSet res = stm.executeQuery(selectTableSql)){
			
			 String fmt = "|%3s|%10s|%10s|%11s|%n";
	         System.out.printf(fmt, "ID", "Vorname", "Nachname","Geburtsjahr");
	         System.out.println("---------------------------------------");
	         while (res.next()) {
	        	 System.out.printf(fmt, 
	        			 res.getInt("id"),
	        			 res.getString("vorname"),
	        			 res.getString("nachname"),
	        			 res.getInt("geburtsjahr"));
	         }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		rebuildTable();
		printTable();
	}
}
