package ocp2;

import java.sql.*;

/*
 
 
 Given the records from the Employee table:
 and given the code fragment:
    try {
 		Connection conn = DriverManager.getConnection (URL, userName, passWord);
	 Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_UPDATABLE);
	 st.execute(“SELECT*FROM Employee”);
	 ResultSet rs = st.getResultSet();
	 while (rs.next())   {
	    if (rs.getInt(1) ==112)   {
	        rs.updateString(2, “Jack”);
	 }
	    }
	    rs.absolute(2);
	    System.out.println(rs.getInt(1) + “ “ + rs.getString(2));
	 } catch (SQLException ex)  {
	    System.out.println(“Exception is raised”);
	 }
		 Assume that:
		 The required database driver is configured in the classpath.
		 The appropriate database accessible with the URL, userName, and passWord exists.
		 What is the result?
		 A. The Employee table is updated with the row:
		 112 Jack
		 and the program prints:
		 112 Jerry
		 B. The Employee table is updated with the row:
		 112 Jack
		 and the program prints:
		 112 Jack
		 C. The Employee table is not updated and the program prints:
		 112 Jerry
		 D. The program prints Exception is raised.
		 
		
		Correct Answer: C

		คำตอบที่ถูกต้อง: C. The Employee table is not updated and the program prints: 112 Jerry
		คำอธิบาย:
		โค้ดนี้มีการเชื่อมต่อกับฐานข้อมูลโดยใช้ JDBC และทำการดึงข้อมูลจากตาราง Employee จากนั้นจะอัปเดตข้อมูลในแถวที่มี eid = 112 และพยายามแสดงข้อมูลจากแถวที่ 2 ของ ResultSet แต่มีจุดที่สำคัญที่ทำให้ผลลัพธ์เป็นเช่นนี้:
		
		การทำงานของโค้ด:
		เชื่อมต่อกับฐานข้อมูล:
		
		โค้ดเริ่มต้นด้วยการเชื่อมต่อกับฐานข้อมูลโดยใช้ DriverManager.getConnection พร้อมด้วย URL, userName, และ passWord.
		การเลือกข้อมูลจากฐานข้อมูล:
		
		โค้ดใช้ Statement ที่สามารถเลื่อนได้ (ResultSet.TYPE_SCROLL_INSENSITIVE) และสามารถอัปเดตได้ (ResultSet.CONCUR_UPDATABLE).
		st.execute("SELECT * FROM Employee"); ดึงข้อมูลทั้งหมดจากตาราง Employee มาเก็บใน ResultSet (rs).
		การอัปเดตข้อมูล:
		
		ในลูป while(rs.next()), โค้ดจะตรวจสอบว่าค่า eid ในคอลัมน์แรก (แถวปัจจุบัน) เท่ากับ 112 หรือไม่ (if (rs.getInt(1) == 112)).
		ถ้าค่าเป็น 112 จะทำการอัปเดตชื่อพนักงานในแถวนั้นให้เป็น "Jack" ด้วย rs.updateString(2, "Jack");.
		การพิมพ์ข้อมูลจากแถวที่ 2:
		
		หลังจากการอัปเดต, โค้ดใช้ rs.absolute(2) เพื่อย้ายไปยังแถวที่ 2 และพิมพ์ค่าของ eid และชื่อจากแถวที่ 2.
		ผลลัพธ์จะถูกแสดงด้วย System.out.println(rs.getInt(1) + " " + rs.getString(2));.
		ทำไมคำตอบเป็น C:
		การอัปเดตข้อมูลใน ResultSet:
		
		เมื่อใช้ rs.updateString(2, "Jack"), ข้อมูลใน ResultSet ถูกอัปเดต แต่ การอัปเดตนี้จะไม่ส่งผลกระทบต่อฐานข้อมูลโดยตรง (เช่นไม่มีการเรียก rs.updateRow() หลังจากการอัปเดตข้อมูล). การอัปเดตจะเกิดขึ้นแค่ใน ResultSet เท่านั้นและจะไม่ได้บันทึกไปที่ฐานข้อมูล.
		ผลลัพธ์ของ rs.absolute(2):
		
		เมื่อโค้ดย้ายไปแถวที่ 2 ด้วย rs.absolute(2), ข้อมูลในแถวที่ 2 จะยังคงเป็นค่าที่ดึงมาจากฐานข้อมูลก่อนหน้านี้ และชื่อในแถวที่ 2 จะยังคงเป็น "Jerry" (ชื่อในฐานข้อมูลเดิม).
		การอัปเดตในฐานข้อมูล:
		
		เนื่องจากไม่มีการเรียก rs.updateRow() หลังจากการอัปเดตข้อมูลใน ResultSet, ข้อมูลในฐานข้อมูลยังคงเหมือนเดิม (แถวที่มี eid = 112 ยังคงชื่อเป็น "Jerry").
		ผลลัพธ์:
		ฐานข้อมูลไม่ได้รับการอัปเดต และข้อมูลในแถวที่ 2 ยังเป็น 112 Jerry (ตามข้อมูลที่มีในฐานข้อมูลก่อนหน้า).
		ดังนั้นโปรแกรมจะพิมพ์ผลลัพธ์ว่า 112 Jerry.
		ทำไมคำตอบอื่นๆ ไม่ถูกต้อง:
		A. The Employee table is updated with the row: 112 Jack and the program prints: 112 Jerry:
		ผิด เพราะแม้ว่า ResultSet ถูกอัปเดตเป็น "Jack" แต่การอัปเดตนั้นไม่ได้ส่งผลต่อฐานข้อมูล เนื่องจากไม่ได้เรียก rs.updateRow() หรือคำสั่งบันทึกการเปลี่ยนแปลงไปยังฐานข้อมูล.
		B. The Employee table is updated with the row: 112 Jack and the program prints: 112 Jack:
		ผิด เพราะฐานข้อมูลไม่ได้รับการอัปเดต ข้อมูลในฐานข้อมูลยังคงเป็น "Jerry".
		D. The program prints Exception is raised:
		ผิด เพราะไม่มีข้อผิดพลาดในการเชื่อมต่อฐานข้อมูลหรือการทำงานกับ ResultSet ดังนั้นโปรแกรมจะไม่พิมพ์ "Exception is raised".

 */
public class JDBCSelectToUpdate {

    public static void main(String[] args) {
        String URL = "jdbc:your_database_url";
        String userName = "your_username";
        String passWord = "your_password";

        try {
            // Verbindung zur Datenbank herstellen
            Connection conn = DriverManager.getConnection(URL, userName, passWord);

            // Statement erstellen, um ein scrollbares und updatables ResultSet zu bekommen
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            // SQL-Abfrage ausführen
            st.execute("SELECT * FROM Employee");

            // Das ResultSet erhalten
            ResultSet rs = st.getResultSet();

            // Über alle Zeilen iterieren
            while (rs.next()) {
                // Überprüfen, ob die ID 112 ist
                if (rs.getInt(1) == 112) {
                    // Den Namen des Mitarbeiters auf "Jack" ändern
                    rs.updateString(2, "Jack");

                    // Die Änderungen in die Datenbank übernehmen
                    rs.updateRow(); // Dieser Aufruf speichert die Änderungen in der Datenbank
                }
            }

            // Den zweiten Datensatz ausgeben
            rs.absolute(2);
            System.out.println(rs.getInt(1) + " " + rs.getString(2));

        } catch (SQLException ex) {
            // Fehlerbehandlung
            System.out.println("Exception is raised");
        }
    }
}


