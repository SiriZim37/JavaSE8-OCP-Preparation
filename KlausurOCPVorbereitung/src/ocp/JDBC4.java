package ocp;

public class JDBC4 {

	/*
	 * In order to be JDBC compliant, for which interfaces must vendors supply implementations? (Choose all that apply.)
	 * 
	 * 
	 * A. Driver
	 * 
	 * B. ResultSet
	 * 
	 * C. Savepoint
	 * 
	 * D. Statement
	 * 
	 * E. Connection
	 * 
	 * F. DriverManager
	 * 
	 * 
	 * 
	 * 
	 * 
	 * A, B, D, and E are correct; these are the interfaces that must be implemented to be JDBC compliant.
	 * C is incorrect; Savepoint is optional.
	 * F is incorrect; DriverManager is a class.
	 * 
	 * คำอธิบาย:
		Correct :
	    ใน JDBC (Java Database Connectivity) เพื่อให้สอดคล้องกับมาตรฐาน, ผู้จำหน่ายฐานข้อมูลต้องให้การสนับสนุนและนำเสนอการใช้งานอินเตอร์เฟซที่จำเป็นเหล่านี้:
	 
	    A: Driver — อินเตอร์เฟซ Driver จำเป็นต้องมี เพื่อให้สามารถเชื่อมต่อกับฐานข้อมูลจากภายนอกได้ โดยการใช้ Driver 
	  			ที่เหมาะสมในการติดต่อกับฐานข้อมูลที่ต่างกัน (เช่น MySQL, Oracle, ฯลฯ)

		B: ResultSet — อินเตอร์เฟซ ResultSet ใช้ในการจัดการข้อมูลที่ได้จากฐานข้อมูลหลังจากที่ทำการสอบถามข้อมูล 
					(เช่น SELECT statement) เป็นอินเตอร์เฟซที่จำเป็นในการรับผลลัพธ์จากการทำคำสั่ง SQL

		D: Statement — อินเตอร์เฟซ Statement ใช้ในการส่งคำสั่ง SQL ไปยังฐานข้อมูล เช่น การสั่งให้ฐานข้อมูลทำการคิวรีหรือปรับปรุงข้อมูล 
					เป็นส่วนสำคัญของ JDBC
		
		E: Connection — อินเตอร์เฟซ Connection เป็นอินเตอร์เฟซหลักที่ใช้ในการเชื่อมต่อกับฐานข้อมูล 
					จำเป็นต้องมีเพื่อให้สามารถเริ่มต้นการทำงานกับฐานข้อมูลได้
		
		
		Wrong :
		
		C: Savepoint — Savepoint เป็นฟีเจอร์เสริมที่ใช้ในการกำหนดจุดที่สามารถย้อนกลับไปได้ในธุรกรรม (transaction) 
					แต่ไม่ได้เป็นข้อบังคับ ผู้จำหน่ายไม่จำเป็นต้องนำเสนออินเตอร์เฟซนี้เพื่อให้เป็น JDBC compliant
					
		F: DriverManager — DriverManager เป็น คลาส ไม่ใช่ อินเตอร์เฟซ ดังนั้นมันไม่ต้องการการสนับสนุนจากผู้จำหน่ายฐานข้อมูลแต่อย่างใด 
					การใช้งานของมันไม่จำเป็นต้องแยกออกเป็นอินเตอร์เฟซ
					
		คำตอบที่ถูกต้องคือ A, B, D, และ E เพราะอินเตอร์เฟซเหล่านี้ต้องการการสนับสนุนเพื่อให้เป็นไปตามมาตรฐาน JDBC 
		โดย Savepoint (C) ไม่ใช่ข้อบังคับ และ DriverManager (F) เป็นคลาสไม่ใช่อินเตอร์เฟซที่ต้องการการสนับสนุน
	 */

	
}
