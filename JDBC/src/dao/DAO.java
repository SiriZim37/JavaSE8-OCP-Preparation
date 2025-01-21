package dao;

public class DAO {

	/* DAO คืออะไร?
	 * 
	 * DAO = Data Access Object
	 * 
	 * DAO: Design Pattern. Datenverwaltung vom Rest der Anwendung trennen 
	 *      und die Details der Realisierung der Datenverwaltung zu verstecken
	 * ( DAO คือ Design Pattern (รูปแบบการออกแบบ) ที่ใช้ในการจัดการข้อมูล 
	 * โดยมีเป้าหมายเพื่อแยกส่วนของการจัดการข้อมูลออกจากส่วนอื่นของแอปพลิเคชัน)
	 * 
	 *-------------------------------------------------------------------------------------- 
	 * 
	 * Datenverwaltung: Speichern, Laden, Ändern, Löschen der Daten (CRUD)
	 * หน้าที่ของ DAO
	 * DAO ใช้สำหรับการจัดการข้อมูลในรูปแบบ CRUD:
	 * C: Create (สร้างข้อมูล)
	 * R: Read (อ่านหรือดึงข้อมูล)
	 * U: Update (แก้ไขข้อมูล)
	 * D: Delete (ลบข้อมูล)
	 * 
	 *--------------------------------------------------------------------------------------
	 * DAO schlägt vor:
	 * 
	 * 		DAO-Interface (auf das Interface programmiert der Rest der Anwendung)
	 * 		DAO-Implementierungen (konkrete Realisierungen vom DAO-Interface)	
	 * หลักการของ DAO
	 * DAO แนะนำให้มี DAO-Interface:
	 * แอปพลิเคชันส่วนอื่นควรเรียกใช้งาน DAO ผ่าน Interface เท่านั้น
	 * มี DAO-Implementationen (การนำไปใช้งานจริง):
	 * เป็นคลาสที่ลงรายละเอียดวิธีการจัดการข้อมูลและเชื่อมต่อกับฐานข้อมูล
	 * 
	 *--------------------------------------------------------------------------------------
	 * DAO-Interface sollte keine Details zu der konkreten Realisierung 
	 * der Datenverwaltung verraten 
	 * ข้อควรปฏิบัติในการออกแบบ DAO Interface ของ DAO ไม่ควรเปิดเผยรายละเอียดการทำงานที่เฉพาะเจาะจง 
	 * เช่น ฐานข้อมูลที่ใช้ หรือวิธีการจัดเก็บข้อมูล
	 * 
	 *--------------------------------------------------------------------------------------
	 * Beispiel: im Package 'aufgaben.dao.tiere'
	 * ตัวอย่างในแพ็กเกจ aufgaben.dao.tiere:
	 * 
	 * 		DAO-Interface: TierDAO
	 * 
	 * 		DAO-Implementierung: TextFileTierDAO
	 * 
	 * 		Reset der Anwendung: AppMain (benutzt nur die Methoden vom TierDAO )
	 * 		kennt keine Details der Realisierung der Datenverwaltung
	 * 		
	 * 		DAO-Interface: TierDAO
	 * 		ส่วนอื่นของแอปพลิเคชัน: เช่น AppMain จะใช้เฉพาะเมธอดใน TierDAO และไม่สนใจวิธีการทำงานเบื้องหลัง
	 * 
	 * 
	 *-------------------------------------------------------------------------------------- 
	 * Exam:
	 * 	
	 * Welcher Methode sind für folgendes DAO-Interface sinnvoll ? 
	 * (Which methods are appropriate, and which ones violate the principles of DAO design?)
	 * 
	 * interface PersonDAO{
	 * 	
	 * 		void create(Person p);	    <-Create			// ok
	 * 		void removeOnId(int id , Connection c);			// nicht sinnvoll: verrät Details der Realisierung
	 * 		List<Person> getAll();	    <- Read				// ok
	 * 		void setName(String name);						// nicht sinnvoll: ist sinnvoll in einer einfachen Klasse 'Person'
	 * 		Person getOnId(int id);		<-Read				// ok
	 * 		boolean deleteOnId(int id)  <-Delete			// ok 
	 * }
	 */
	public static void main(String[] args) {
		
	}
}
