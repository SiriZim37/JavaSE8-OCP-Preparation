package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class B16_Transaction {

	/*
	 * Transaction:
	 * 		
	 * 		- besteht aus mehreren Schritten
	 * 			- Den Betrag von Konto A abheben
	 * 			- Den Betrag auf das Konto B gutschreiben
	 * 
	 * 		- sollte atomar laufen (keine parallelen Änderungen dürfen vorkommen)
	 * 
	 * 		- sollten nur stattfinden, wenn alle Schritte erfolgreich sind
	 * 
	 */
	/*
	 * Transaction:
	 * 
	 *      - ประกอบด้วยหลายขั้นตอน
	 *          - การถอนเงินจากบัญชี A
	 *          - การโอนเงินไปยังบัญชี B
	 * 
	 *      - ควรทำงานเป็นแบบ **atomic** (ไม่อนุญาตให้มีการเปลี่ยนแปลงพร้อมกันจากหลายๆ คำสั่ง)
	 * 
	 *      - ควรจะดำเนินการเฉพาะเมื่อทุกขั้นตอนสำเร็จทั้งหมด
	 *      
	 *      คำอธิบาย:
	 *      ประกอบด้วยหลายขั้นตอน:
	 *      1. Transaction คือชุดของการกระทำหลายขั้นตอนที่เกิดขึ้นร่วมกัน เช่น การถอนเงินจากบัญชีหนึ่งและการฝากเงินเข้าอีกบัญชีหนึ่ง 
	 *      		ซึ่งจะถูกดำเนินการเป็นชุดเดียว ถ้าเกิดข้อผิดพลาดในระหว่างการทำงานทั้งหมดก็จะต้องยกเลิกการเปลี่ยนแปลงทั้งหมด
	 *      
	 *      2.ควรทำงานเป็นแบบ atomic:
	 *      	Atomic หมายความว่า Transaction จะต้องทำงานทั้งหมดให้เสร็จสมบูรณ์หรือไม่ทำเลย หากเกิดข้อผิดพลาดในระหว่างขั้นตอนใดขั้นตอนหนึ่ง 
	 *      	การเปลี่ยนแปลงทั้งหมดจะต้องถูกย้อนกลับเพื่อไม่ให้ข้อมูลในฐานข้อมูลเกิดความผิดพลาด 
	 *      3. ควรจะดำเนินการเฉพาะเมื่อทุกขั้นตอนสำเร็จทั้งหมด:
	 *      	Transaction จะต้องทำงานเฉพาะเมื่อทุกขั้นตอนดำเนินการสำเร็จและไม่มีข้อผิดพลาดเกิดขึ้น 
	 *      	ถ้ามีข้อผิดพลาดในขั้นตอนใดขั้นตอนหนึ่งก็จะต้องทำการ rollback (ย้อนกลับ) เพื่อป้องกันไม่ให้ข้อมูลที่ไม่ถูกต้องถูกบันทึกลงในฐานข้อมูล
	 */
	
	/*
	 อธิบายการทำงานในโปรแกรม
		1. การเชื่อมต่อกับฐานข้อมูล: โปรแกรมจะเชื่อมต่อกับฐานข้อมูลที่มีอยู่ในตำแหน่งที่กำหนด 
		(ในตัวอย่างนี้คือ jdbc:derby:C:\\path\\to\\mydb;)
		
		2. การทำงานของธุรกรรม:
			- ขั้นแรกจะทำการดึงยอดเงินจากบัญชี A โดยการใช้ฟังก์ชัน getKontostand(id, stm) เพื่อดึงข้อมูลยอดเงินจากฐานข้อมูล
			- ถ้ายอดเงินในบัญชี A เพียงพอสำหรับการถอนเงิน (betrag = 1500), ก็จะทำการลดยอดเงินในบัญชี A 
			  โดยการอัพเดตฐานข้อมูลด้วยฟังก์ชัน setKontostand(id, betrag, stm)
			- หลังจากนั้นจะเพิ่มยอดเงินในบัญชี B โดยใช้ getKontostand(id, stm) เพื่อดึงยอดเงินในบัญชี B 
			  และใช้ setKontostand(id, betrag, stm) เพื่อเพิ่มเงินเข้าไป
		3. การตรวจสอบข้อผิดพลาด:
			- ถ้ามียอดเงินในบัญชี A ไม่พอสำหรับการถอน จะไม่มีการเปลี่ยนแปลงใด ๆ
			- เมื่อทำการอัพเดตฐานข้อมูล ถ้ามีการอัพเดตที่ไม่ตรงตามที่คาดไว้ (เช่น จำนวนแถวที่ถูกอัพเดตไม่ใช่ 1) จะเกิดข้อผิดพลาด SQLException
		4.การปิดการเชื่อมต่อ: โปรแกรมใช้ try-with-resources เพื่อให้การเชื่อมต่อกับฐานข้อมูลและ Statement ถูกปิดอัตโนมัติเมื่อเสร็จสิ้นการทำงาน
		
			ตัวอย่างการทำงานของโปรแกรม
			ก่อนการทำธุรกรรม:
			
			บัญชี A (Mary) มียอดเงิน 7500
			บัญชี B (Paul) มียอดเงิน 111
			หลังการทำธุรกรรม:
			
			บัญชี A (Mary) ยอดเงินลดลงเหลือ 6000
			บัญชี B (Paul) ยอดเงินเพิ่มขึ้นเป็น 1611
	 */
	public static void main(String[] args) {
		String url = "jdbc:derby:/Users/sirivimonmeuntup/Documents/Dev_Project/Java-Workspace/javaocpse8/JDBC/mydb";
//		String url = "jdbc:derby:C:\\path\\to\\mydb;";
		
		JDBCUtils.rebuildTestTable();
		JDBCUtils.printTestTable();

		try (Connection c = DriverManager.getConnection(url)){
				
			transactionDurchfuehren(c);
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		
		JDBCUtils.printTestTable();
	}
	
	
	/*
	 * Geld überweisen
	 * 
	 * von Konto A : Mary 
	 * nach Konto B : Paul
	 * Betrag : 1500
	 */
	private static void transactionDurchfuehren(Connection c) throws SQLException {

		/*
		 * aktuellen AutoCommit-Zustand merken,
		 * um nach der Transaction die Connection in dem 
		 * Zustand wieder
		 * 
		 * ค่า AutoCommit คือการตั้งค่าที่บ่งบอกว่าการเปลี่ยนแปลงข้อมูลในฐานข้อมูลจะถูกบันทึกทันทีหรือไม่ 
		 * โดยทั่วไปถ้าเป็น true ทุกการเปลี่ยนแปลงจะถูกบันทึก (commit) ทันทีหลังจากคำสั่ง SQL ถูกดำเนินการ 
		 * หากเป็น false ต้องใช้คำสั่ง commit() เพื่อบันทึกการเปลี่ยนแปลง
		 */
		boolean lastAutoCommit = c.getAutoCommit();
		
		try (Statement stm = c.createStatement()){
			/*
			 * *** 1.Transaction starten
			 */
		
			c.setAutoCommit(false);  // เริ่มต้น transaction โดยไม่ให้ commit อัตโนมัติ
			
			final int betrag = 500;
			
			final int idKontoA = 3;
			final int idKontoB = 2;
			
			/*
			 * Transaction, Schritt 1
			 * 
			 * Geld vom Konto A abziehen
			 */
			
			int kontostandA = getKontostand(idKontoA , stm);
			System.out.println("kontostand A : " + kontostandA);
			
			if(kontostandA >= betrag) {
				kontostandA -= betrag;
				setKontostand(idKontoA,kontostandA , stm);
			}else {
				throw new RuntimeException("Nicht genug Geld auf dem Konto mit id = " + idKontoA);
			}
			
			/*
			 * Abbruch simulieren (z.B. Stromausfall oder Netzwerkausfall) 
			 */
			if(new Random().nextBoolean()) {
				throw new RuntimeException("Netzwerkausfall");
			}
			
			
			/*
			 * Transaction, Schritt 1
			 * 
			 * Geld auf dem Konto B addieren
			 */
			int kontostandB = getKontostand(idKontoB, stm);
			System.out.println("kontostand B : " + kontostandB);
		
			kontostandB += betrag;
			setKontostand(idKontoB,kontostandB, stm);
		
			
			/*
			 * Transaction abschließen und
			 * dadurch die Änderungen in der Datenbank übernehmen
			 */
		//	c.commit();			// ohne commit > Exception : Fehler! Cannot close a connection while a transaction is still active.
			
			c.commit();	
					
		} catch (Exception e) {
			System.out.println("Transaction Fehler während der Transaktion! " + e.getMessage());
			c.rollback();		 // Teiländerung zurücksetzen
								 // หากเกิดข้อผิดพลาด ย้อนกลับการเปลี่ยนแปลง
		}
		c.setAutoCommit(lastAutoCommit); 
		//หลังจากธุรกรรมเสร็จสิ้น การตั้งค่าของ AutoCommit จะกลับมาเหมือนเดิม (ไม่ว่าจะเป็น true หรือ false) 
		//เพื่อไม่ให้กระทบกับการทำงานของการเชื่อมต่อในอนาคต
	}
	
	private static void setKontostand(int id , int betrag , Statement stm ) throws SQLException {
		String sql = "update kunden set kontostand=" + betrag + "where id="+id;
		int result = stm.executeUpdate(sql);
		
		if(result!= 1) {
			throw new SQLException("Anzahl der betroffenen Zeilen muss 1 sein, ist aber " + result );
		}
	}
	
	private static int getKontostand(int id , Statement stm ) throws SQLException{
	
		String sql = "select kontostand from kunden where id="+ id;
		
		try (ResultSet res = stm.executeQuery(sql)){
		
			if( !res.next()) {
				throw new IllegalArgumentException("Unbekannte id: " + id);
			}
			
			// SQL Query นี้ทำการเลือกแค่คอลัมน์เดียวคือ kontostand จากตาราง kunden โดยที่มีเงื่อนไขว่า id จะต้องตรงกับค่าที่ระบุ
			// "select kontostand from kunden where id="+ id;
			int result = res.getInt(1);		// get column kontostand  


			if(res.next()) {
				throw new IllegalStateException("Mehrfache id: " + id);
			}
			
			return result;
		}
	}
}
