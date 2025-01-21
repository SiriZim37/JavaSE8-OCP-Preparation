package jdbc;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class B02_Insert {

	/*
	  กำหนด URL สำหรับการเชื่อมต่อฐานข้อมูล Derby
	  jdbc:derby:mydb; 
		 - jdbc: เป็นโปรโตคอลสำหรับเชื่อมต่อกับฐานข้อมูลใน Java
		- derby: ระบุว่าใช้ฐานข้อมูล Apache Derby
		 - mydb: ชื่อของฐานข้อมูลที่ต้องการเชื่อมต่อ หรือจะสร้างใหม่ถ้ายังไม่มี
		
		String url = "jdbc:derby:C:\\path\\to\\mydb;";
	 */
	
	/*
	 * sql = "INSERT INTO animals (name , age) VALUES ( 'Rex' , 3)";
	 * stm.executeUpdate(sql)  >  ใช้เพื่อดำเนินการคำสั่ง SQL ที่ไม่ต้องการผลลัพธ์กลับมา (เช่น INSERT, UPDATE, DELETE)
	 * 
	 *  java.sql.SQLSyntaxErrorException Table/View 'ANIMALS' does not exist.
	 *  หมายความว่า ฐานข้อมูลที่คุณกำลังพยายามทำงานด้วย (ในกรณีนี้คือฐานข้อมูล mydb) ยังไม่มีตาราง (table) 
	 *  ชื่อ ANIMALS ซึ่งคุณพยายามจะทำการ INSERT ข้อมูลลงไป
	 */

	public static void main(String[] args) {
		String url = "jdbc:derby:/Users/sirivimonmeuntup/Documents/Dev_Project/Java-Workspace/javaocpse8/JDBC/mydb";
		// window > "jdbc:derby:C:\\path\\to\\mydb;";

		// ใช้ try-with-resources เพื่อเปิดการเชื่อมต่อฐานข้อมูลและ Statement อัตโนมัติ
		try (Connection c = DriverManager.getConnection(url); 
				Statement stm = c.createStatement(); ) {

			createTable(stm);
			
			// กำหนดคำสั่ง SQL ที่จะใช้สำหรับการดำเนินการกับฐานข้อมูล
			String sql = "INSERT INTO animals (name, age) VALUES ('Anna', 41)";
			stm.executeUpdate(sql);
			System.out.println("Neue Zeile erzeugt");
			
		} catch (SQLException e) {
			e.printStackTrace();  
		}
	}// end of main
	
	/*
	 * SQL-Befehl zum Erzeugen einer Tabelle sind unwarhscheinlich in der Prüfung
	 */
	static void createTable(Statement stm) throws SQLException {
	    try {
	        String sql = "CREATE TABLE animals ("
	                  + "id INT GENERATED ALWAYS AS IDENTITY, "  // Auto-increment ID
	                  + "name VARCHAR(255), "
	                  + "age INT)";
	        stm.executeUpdate(sql);
	        System.out.println("Die Tabelle 'animals' wurde erzeugt");
	    } catch (SQLException e) {
	        if (e.getSQLState().equals("X0Y32")) {  // Error: Table already exists
	            System.out.println("Table/View 'ANIMALS' already exists in Schema 'APP'.");
	        } else {
	            throw e;
	        }
	    }
	}
}
