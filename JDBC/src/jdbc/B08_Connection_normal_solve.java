package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class B08_Connection_normal_solve {

	/*
	 * Achtung! Exam!
	 * 
	 * Wenn die Connection geschlossen ist, kann sie nicht mehr 
	 * verwendet werden.
	 *  
	 * Wenn die Connection geschlossen ist, können damit erstellte
	 * Objekte (Statement, ResultSet...) nicht mehr verwendet werden 
	 */
	
	
	/*
	 * Ergebnis : ***Alte Tebele 'kunden' gelöscht
	 			  ***Tabelle 'kunden' erzeugt
				  java.sql.SQLNonTransientConnectionException: No current connection.
	 */
	
	/*
	 * เหตุผลที่เกิดปัญหานี้: 
	 * 1. การใช้ try-with-resources ใน getConnection(): ใน getConnection() 
	 * คุณใช้ try-with-resources เพื่อจัดการกับการเชื่อมต่อ (connection) 
	 * ซึ่งจะปิดการเชื่อมต่ออัตโนมัติเมื่อออกจากบล็อก try. ดังนั้นการเชื่อมต่อจะถูกปิดลงทันทีที่บล็อก try สิ้นสุด 
	 * ทำให้ในบล็อก main() ที่พยายามใช้ connection ที่สร้างขึ้นนั้นไม่สามารถเข้าถึงได้ (เนื่องจากมันถูกปิดแล้ว).
	 * 
	 * 2. การใช้ connection นอก try: เนื่องจากในโค้ดของคุณ connection ถูกประกาศเป็นตัวแปรแบบ static 
	 * แต่ใน getConnection() คุณใช้ try-with-resources ซึ่งจะปิดการเชื่อมต่อทันทีหลังจากเสร็จสิ้นการทำงานใน try. 
	 * เมื่อโค้ดใน main() พยายามเข้าถึง connection ก็จะเกิดข้อผิดพลาด เนื่องจาก connection ถูกปิดไปแล้ว.
	 * 
	 * วิธีแก้ไข:
	 * เก็บ connection ไว้ในตัวแปรนอก try-with-resources หรือใช้ try-with-resources ภายใน main()
	 * เพื่อลดความซับซ้อน และไม่ให้ connection ถูกปิดไปทันทีที่
	 * 
	 */
	
	/*
	 * ในตัวอย่างนี้ getConnection() จะคืนค่าการเชื่อมต่อที่เปิดอยู่ และไม่ได้ใช้ try-with-resources 
	 * เพื่อปิดมันทันทีในบล็อก getConnection() ซึ่งจะช่วยให้ connection ยังคงเปิดอยู่จนกว่าการใช้งานใน main() จะเสร็จสิ้น.
	 * 
	 */
	static Connection connection;

	static Connection getConnection() throws SQLException{

//		String url = "jdbc:derby:C:\\path\\to\\mydb";	// Exam: bekannt ist , dass die URL korrekt ist
		String url = "jdbc:derby:/Users/sirivimonmeuntup/Documents/Dev_Project/Java-Workspace/javaocpse8/JDBC/mydb";
		// window > "jdbc:derby:C:\\path\\to\\mydb;";
		
	
		connection = DriverManager.getConnection(url); // เปิดการเชื่อมต่อ
		
		return connection;  
	}

	public static void main(String[] args) {
		
		JDBCUtils.rebuildTestTable();
		
		try {
			Connection c = getConnection();
			Statement stm = c.createStatement();		
			ResultSet res = stm.executeQuery("select * from kunden");

			if (res.next()) {
                System.out.println(res.getString("name"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
