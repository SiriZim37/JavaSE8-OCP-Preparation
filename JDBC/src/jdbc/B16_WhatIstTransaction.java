package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class B16_WhatIstTransaction {

	/*
	 * การทำงานของ Transaction ใน Java (สำหรับ OCP SE 8) เป็นเรื่องสำคัญในการจัดการกับฐานข้อมูลในระดับการเชื่อมต่อ (connection) เช่นกับ JDBC หรือ JPA เพื่อให้มั่นใจว่าการทำงานทั้งหมดในฐานข้อมูลเป็นไปตามหลักการ ACID (Atomicity, Consistency, Isolation, Durability)
	 * 
	 * คำอธิบายเกี่ยวกับ Transaction ใน Java SE 8:
	 * 
	 * 1. Transaction คืออะไร?
	 * - Transaction เป็นชุดของคำสั่งที่ทำงานร่วมกันบนฐานข้อมูล ซึ่งจะต้องทำงานทั้งหมดให้เสร็จสมบูรณ์หรือไม่ทำงานเลย (ถ้ามีข้อผิดพลาด)
	 * - การทำงานในฐานข้อมูลมักจะต้องการการรักษาความถูกต้องและความสมบูรณ์ของข้อมูล
	 * 
	 * -------------------------------------------------------------------------------------------
	 * 2. การเริ่มต้น Transaction ใน Java:
	 * - ใน JDBC เราสามารถใช้ Connection เพื่อเริ่มต้นและจัดการกับ transaction
	 * - การเปิดใช้งาน transaction จะทำได้โดยการตั้งค่า auto-commit ของ Connection เป็น false
	 * 
	 * ตัวอย่าง:
	 * Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
	 * con.setAutoCommit(false);  // เริ่มต้น transaction โดยไม่ให้ commit อัตโนมัติ
	 * 
	 * ------------------------------------------------------------------------------------------- 
	 * 3. การ Commit และ Rollback:
	 * - Commit: เมื่อคำสั่งทั้งหมดใน transaction ถูกดำเนินการสำเร็จแล้ว เราสามารถใช้ commit() เพื่อบันทึกการเปลี่ยนแปลงทั้งหมดในฐานข้อมูล
	 * - Rollback: ถ้ามีข้อผิดพลาดเกิดขึ้นระหว่างการทำงานใน transaction เราสามารถใช้ rollback() เพื่อย้อนกลับการเปลี่ยนแปลงทั้งหมดที่ทำไปแล้วใน transaction
	 * 
	 * ตัวอย่าง:
	 * con.commit();  // บันทึกการเปลี่ยนแปลงทั้งหมด
	 * con.rollback();  // ย้อนกลับการเปลี่ยนแปลงทั้งหมดใน transaction
	 * 
	 *  -------------------------------------------------------------------------------------------
	 * 4. การใช้ Savepoints:
	 * - Savepoints ช่วยให้สามารถบันทึกสถานะของ transaction ในจุดที่ต้องการและสามารถย้อนกลับไปยังจุดนั้นได้หากเกิดข้อผิดพลาด
	 * 
	 * ตัวอย่าง:
	 * Savepoint savepoint = con.setSavepoint();  // ตั้งค่า savepoint
	 * // ทำงานใน transaction
	 * con.rollback(savepoint);  // ย้อนกลับไปยัง savepoint
	 * 
	 * -------------------------------------------------------------------------------------------
	 * 5. การปิด Transaction:
	 * - เมื่อเสร็จสิ้นการทำงานกับฐานข้อมูลแล้ว อย่าลืมที่จะปิดการเชื่อมต่อ (Connection) เพื่อป้องกันการรั่วไหลของทรัพยากร
	 * 
	 * ตัวอย่าง:
	 * con.close();  // ปิดการเชื่อมต่อ
	 * 
	 * -------------------------------------------------------------------------------------------
	 *  
	 * ACID (คุณสมบัติหลักของ Transaction):
	 * - การทำงานใน transaction ต้องมีคุณสมบัติ ACID เพื่อให้มั่นใจว่าการทำงานทั้งหมดมีความถูกต้อง:
	 * 
	 * - Atomicity: การทำงานทั้งหมดใน transaction จะต้องสำเร็จหรือล้มเหลวทั้งหมด ถ้ามีการล้มเหลวจะย้อนกลับทั้งหมด
	 * - Consistency: ข้อมูลในฐานข้อมูลจะต้องอยู่ในสภาพที่ถูกต้องหลังจากทำงาน transaction เสร็จสมบูรณ์
	 * - Isolation: การทำงานของ transaction แต่ละตัวจะต้องแยกจากกัน ทำให้การทำงานใน parallel ไม่กระทบกับกัน
	 * - Durability: เมื่อ transaction เสร็จสมบูรณ์ การเปลี่ยนแปลงในฐานข้อมูลจะต้องถูกบันทึกและคงอยู่ถาวร
	 * 
	 * ตัวอย่างโค้ด:
	 * Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
	 * try {
	 *     con.setAutoCommit(false);  // เปิดการทำงานแบบ Transaction
	 * 
	 *     // ทำการอัพเดตข้อมูลในฐานข้อมูล
	 *     Statement stmt = con.createStatement();
	 *     stmt.executeUpdate("UPDATE account SET balance = balance - 100 WHERE account_id = 1");
	 *     stmt.executeUpdate("UPDATE account SET balance = balance + 100 WHERE account_id = 2");
	 * 
	 *     // Commit การเปลี่ยนแปลง
	 *     con.commit();  // หากไม่เกิดข้อผิดพลาด ข้อมูลจะถูกบันทึก
	 * } catch (SQLException e) {
	 *     con.rollback();  // หากเกิดข้อผิดพลาด ย้อนกลับการเปลี่ยนแปลง
	 * } finally {
	 *     con.close();  // ปิดการเชื่อมต่อ
	 * }
	 * 
	 * -------------------------------------------------------------------------------------------
	 * สรุป:
	 * - Transaction เป็นกระบวนการที่ช่วยให้เราจัดการกับชุดของคำสั่งในฐานข้อมูลให้มีความสมบูรณ์
	 * - ใช้ commit() เพื่อบันทึกการเปลี่ยนแปลง และ rollback() เพื่อยกเลิกการเปลี่ยนแปลงหากเกิดข้อผิดพลาด
	 * - การใช้ Savepoint ช่วยให้ย้อนกลับบางส่วนของการทำงานได้
	 */

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
		try {
		    con.setAutoCommit(false);  // เปิดการทำงานแบบ Transaction

		    // ทำการอัพเดตข้อมูลในฐานข้อมูล
		    Statement stmt = con.createStatement();
		    stmt.executeUpdate("UPDATE account SET balance = balance - 100 WHERE account_id = 1");
		    stmt.executeUpdate("UPDATE account SET balance = balance + 100 WHERE account_id = 2");

		    // Commit การเปลี่ยนแปลง
		    con.commit();  // หากไม่เกิดข้อผิดพลาด ข้อมูลจะถูกบันทึก
		} catch (SQLException e) {
		    con.rollback();  // หากเกิดข้อผิดพลาด ย้อนกลับการเปลี่ยนแปลง
		} finally {
		    con.close();  // ปิดการเชื่อมต่อ
		}

	}
}
