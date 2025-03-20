package ocpexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * CREATE TABLE TableA (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    year INT
);

CREATE TABLE TableB (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    year INT
);

 */
public class JDBCSelectFrom2Tables {

	public static void main(String[] args) {		
		
		  String url = "jdbc:mysql://localhost:3306/mydatabase";
	        String user = "root";
	        String password = "password";

	        String query = "SELECT a.id, a.name, b.id, b.name " +
	                       "FROM TableA a INNER JOIN TableB b ON a.year = b.year";

	        try (Connection conn = DriverManager.getConnection(url, user, password);
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(query)) {
	            
	            while (rs.next()) {
	                System.out.println(rs.getInt(1) + " :: " + rs.getString(2) + " - " +
	                                   rs.getInt(3) + " :: " + rs.getString(4));
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}
}

/*
  
A) จะเกิด SQLException เพราะทั้งสองตารางไม่มีข้อมูล

B) คำสั่ง SQL จะทำงานได้ และคืนค่า ตารางว่าง (Empty Result Set)

C) การใช้ JOIN แทน WHERE จะช่วยให้ได้ผลลัพธ์ที่ดีขึ้น

D) ถ้าเพิ่ม ON a.id = b.id ใน WHERE จะได้ผลลัพธ์ที่เหมือนเดิม

E) ต้องมี ORDER BY เพื่อให้ผลลัพธ์ไม่เป็น NULL



✅ B ถูกต้อง → ถึงแม้ตารางจะไม่มีข้อมูล SQL จะทำงานได้ และคืน ผลลัพธ์ว่าง (Empty Result Set) ไม่เกิด Error

✅ C ถูกต้อง → ควรใช้ JOIN แทนการใช้ WHERE เพราะทำให้โค้ดอ่านง่ายขึ้น เช่น

*/
