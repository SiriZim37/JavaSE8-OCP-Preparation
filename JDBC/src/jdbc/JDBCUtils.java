package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	
	private static Connection getConnection() throws SQLException {
		String url = "jdbc:derby:/Users/sirivimonmeuntup/Documents/Dev_Project/Java-Workspace/javaocpse8/JDBC/mydb;create=true";
		// window > "jdbc:derby:C:\\path\\to\\mydb;create=true"; 
		return  DriverManager.getConnection(url);
	}
	
	
	/**
	 * Erzeugt in der Datenbank 'mydb' die Tabelle 'kunden':<br/><br/>
	 * 
	 * <table>
	 * <tr>
	 *   <th>id</th><th>name</th><th>kontostand</th>
	 * </tr>
	 * 
	 * <tr>
	 *   <td>1</td><td>Peter</td><td>2000</td>
	 * </tr>
	 * 
	 * <tr>
	 *   <td>2</td><td>Paul</td><td>111</td>
	 * </tr>
	 * 
	 * <tr>
	 *   <td>3</td><td>Mary</td><td>7500</td>
	 * </tr>
	 * </table>
	 */
	public static void rebuildTestTable() {
		
		
		try (Connection c = getConnection();
				Statement stm = c.createStatement()){
			
			// alte Tabelle löschen
			String sql = "drop table kunden";
			try {
				stm.executeUpdate(sql);
				System.out.println("***Alte Tebele 'kunden' gelöscht");
				
			} catch (SQLException e) {
				if("42Y55".equals(e.getSQLState()))
					System.out.println("***Tabelle 'kunden' existiert nicht");
				e.printStackTrace();
			}
			
			// Tabelle erneuet erzeugen
			sql = "create table kunden ( id int , name varchar(255) , kontostand int)";
			stm.executeUpdate(sql);
			
			// todo: besser wäre mit PreparedStatement die Datensätze zu speichern
			sql = getInsertIntoTestTable(1, "Peter", 2000);
			stm.executeUpdate(sql);
			sql = getInsertIntoTestTable(2, "Paul", 111);
			stm.executeUpdate(sql);
			sql = getInsertIntoTestTable(3, "Mary", 7500);
			stm.executeUpdate(sql);
			
			System.out.println("***Tabelle 'kunden' erzeugt");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static String getInsertIntoTestTable(int id, String name, int kontostand) {
	    return "insert into kunden (id, name, kontostand) values (" 
	            + id + ", " 
	            + "'" + name + "', " 
	            + kontostand + ")";
	}
	
	public static void printTestTable() {
	    String sql = "select * from kunden";
	    try (Connection c = getConnection();
	    		Statement stm = c.createStatement();
	    		ResultSet res = stm.executeQuery(sql)) {
	            String smt = "|%3s|%10s|%10s|%n";
	            System.out.printf(smt, "ID", "Name", "Kontostand");
	            System.out.println("---------------------------");
	            while (res.next()) {
	                System.out.printf(smt, res.getInt("id"), res.getString("name"), res.getInt("kontostand"));
	            }
	            System.out.println("---------------------------\n");
	  } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}
	
	
	public static void main(String[] args) {
		rebuildTestTable();
		printTestTable();
	}
}
