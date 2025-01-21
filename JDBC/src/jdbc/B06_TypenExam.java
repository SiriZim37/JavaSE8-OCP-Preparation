package jdbc;

public class B06_TypenExam {
	/*
	 * JDBC-Typen aus der Standardbibliothek:
	 * 
	 * 	- DriverManager (Klasse)
	 *  - Driver
	 *  - Connection
	 *  - Statement
	 *  - ResultSet
	 *  - SQLException (Klasse)
	 *  
	 * Die Interfaces Driver, Connection, Statement, ResultSet
	 * werden von den Treiber-Entwicklern realisiert
	 * 
	 */
	/*
	 * สำหรับการสอบ Oracle Certified Professional (OCP) Java SE 8 เรื่อง JDBC (Java Database Connectivity) 
	 * เป็นหัวข้อสำคัญที่ควรศึกษา รายละเอียดที่ควรรู้เกี่ยวกับ JDBC และตัวอย่างคำถามที่อาจเจอในการสอบมีดังนี้:

	**หัวข้อหลักของ JDBC**

	**DriverManager และ Connection**
	- เข้าใจวิธีการเชื่อมต่อกับฐานข้อมูล
	- ตัวอย่าง:
	    Connection conn = DriverManager.getConnection("jdbc:database_url", "user", "password");

	**ประเภทของ Statement**
	- **Statement**: ใช้สำหรับการรันคำสั่ง SQL แบบง่าย
	- **PreparedStatement**: ใช้สำหรับคำสั่ง SQL ที่มีการเตรียมไว้ล่วงหน้าและรองรับพารามิเตอร์
	- **CallableStatement**: ใช้สำหรับการรัน Stored Procedures
	- ตัวอย่าง:
	    PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
	    ps.setInt(1, 1); // กำหนดพารามิเตอร์

	**การรัน SQL**
	- **executeQuery**: ใช้สำหรับคำสั่ง SELECT (คืนค่า ResultSet)
	- **executeUpdate**: ใช้สำหรับ INSERT, UPDATE, DELETE (คืนค่าจำนวนรายการที่เปลี่ยนแปลง)
	- **execute**: ใช้สำหรับคำสั่งทั่วไป (คืนค่าเป็น boolean)

	**ResultSet**
	- การนำทางแถวและคอลัมน์ในผลลัพธ์ของคำสั่ง SQL
	- เข้าใจวิธีการใช้งาน เช่น `next()`, `getInt()`, `getString()`
	- ตัวอย่าง:
	    ResultSet rs = stmt.executeQuery("SELECT id, name FROM users");
	    while (rs.next()) {
	        System.out.println(rs.getInt("id") + " " + rs.getString("name"));
	    }

	**การจัดการ Transaction**
	- เข้าใจโหมด Auto-Commit และการควบคุมธุรกรรมแบบ Manual:
	    conn.setAutoCommit(false); // ปิด Auto-Commit
	    conn.commit(); // ยืนยันการเปลี่ยนแปลง
	    conn.rollback(); // ยกเลิกการเปลี่ยนแปลง

	**ข้อยกเว้นใน JDBC**
	- การจัดการ SQLException และการเข้าใจรหัสข้อผิดพลาดและ SQL state

	---

	**หัวข้อสำคัญสำหรับการสอบ OCP**

	**รูปแบบ URL ของ JDBC**
	- รูปแบบทั่วไป: jdbc:subprotocol:subname
	- ตัวอย่าง: jdbc:mysql://localhost:3306/mydb

	**Batch Updates**
	- ใช้ addBatch() และ executeBatch() สำหรับการประมวลผลแบบกลุ่ม
	- ตัวอย่าง:
	    Statement stmt = conn.createStatement();
	    stmt.addBatch("INSERT INTO users (name) VALUES ('Alice')");
	    stmt.addBatch("INSERT INTO users (name) VALUES ('Bob')");
	    stmt.executeBatch();

	**ResultSet แบบ Scrollable และ Updatable**
	- เข้าใจวิธีการสร้าง ResultSet ที่สามารถเลื่อนไปมาและแก้ไขข้อมูลได้
	- ตัวอย่าง:
	    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    ResultSet rs = stmt.executeQuery("SELECT * FROM users");

	**RowSet**
	- ประเภทของ RowSet:
	  - **JdbcRowSet**: เชื่อมต่ออยู่เสมอ
	  - **CachedRowSet**: ตัดการเชื่อมต่อและสามารถ serialize ได้
	- เข้าใจการใช้งานแพ็คเกจ javax.sql.rowset

	**Metadata**
	- **DatabaseMetaData**: ให้ข้อมูลเกี่ยวกับฐานข้อมูล
	- **ResultSetMetaData**: ให้ข้อมูลเกี่ยวกับคอลัมน์ใน ResultSet

	**Stored Procedures**
	- เข้าใจวิธีการเรียกใช้งาน Stored Procedures โดยใช้ CallableStatement
	- ตัวอย่าง:
	    CallableStatement cs = conn.prepareCall("{call my_stored_procedure(?, ?)}");
	    cs.setInt(1, 1); // กำหนด Input Parameter
	    cs.registerOutParameter(2, Types.VARCHAR); // กำหนด Output Parameter
	    cs.execute();

	**Connection Pooling**
	- เข้าใจพื้นฐานของการจัดการ Connection Pooling และเหตุผลที่ควรใช้เพื่อเพิ่มประสิทธิภาพ

	---

	**ตัวอย่างคำถามสำหรับการสอบ**

	1. จะเกิดอะไรขึ้นถ้าคุณเรียกใช้ executeQuery กับคำสั่ง SQL แบบ UPDATE?
	   - ข้อผิดพลาดใน Runtime (SQLException)

	2. วิธีไหนที่ใช้เรียก Metadata ของฐานข้อมูล?
	   - conn.getMetaData() (คืนค่า DatabaseMetaData)

	3. จะควบคุม Transaction ใน JDBC ได้อย่างไร?
	   - ปิด Auto-Commit ด้วย conn.setAutoCommit(false) และใช้ conn.commit() หรือ conn.rollback()

	4. ถ้ามีวัตถุ ResultSet คุณจะเลื่อนไปยังแถวก่อนหน้าได้อย่างไร?
	   - ใช้ rs.previous() (ต้องใช้ ResultSet แบบ Scrollable)

	5. วิธีไหนที่ใช้ดึงจำนวนคอลัมน์ใน ResultSet?
	   - ResultSetMetaData.getColumnCount()

	---

	**คำแนะนำที่ดีที่สุด**
	- ปิดทรัพยากร (Connection, Statement, ResultSet) เสมอใน finally หรือใช้ try-with-resources
	- หลีกเลี่ยง SQL Injection โดยใช้ PreparedStatement
	- ใช้ Connection Pooling เพื่อประสิทธิภาพในแอปพลิเคชันจริง
	*/

	public static void main(String[] args) {
		
	}
}
