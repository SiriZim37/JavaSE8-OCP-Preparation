package dao;

public class A00_WasIstDAO {

	/*
	DAO (Data Access Object) คือ รูปแบบการออกแบบซอฟต์แวร์ที่ใช้ในการแยกการเข้าถึงข้อมูล (Data Access) 
	ออกจากส่วนอื่นๆ ของโปรแกรม โดยการใช้ DAO จะทำให้โปรแกรมมีความยืดหยุ่นในการเปลี่ยนแปลงแหล่งข้อมูล
	หรือฐานข้อมูลโดยไม่ต้องปรับเปลี่ยนส่วนของโปรแกรมที่ใช้งานฐานข้อมูล

	** หลักการของ DAO:
	1.แยกการเข้าถึงข้อมูล: DAO จะทำหน้าที่จัดการการเชื่อมต่อกับฐานข้อมูลและการทำงานกับข้อมูล 
	  (เช่น การดึงข้อมูล การเพิ่มข้อมูล การอัปเดตข้อมูล และการลบข้อมูล) แยกจากธุรกิจหลักของโปรแกรม
	2.ใช้ Interface: DAO มักจะมีการกำหนด Interface ที่กำหนดเมธอดต่างๆ สำหรับการเข้าถึงข้อมูล 
	  เช่น findById(), save(), update(), delete() เป็นต้น
	3.การใช้งานแบบแยกส่วน: โดยที่ส่วนของธุรกิจหลัก (Business Logic) จะไม่รู้รายละเอียดการทำงานกับฐานข้อมูล 
	  เช่น ไม่รู้ว่าใช้ SQL แบบไหน หรือเชื่อมต่อกับฐานข้อมูลอะไร
	
	ตัวอย่างการใช้งาน DAO ใน Java:
		// DAO Interface
		public interface EmployeeDAO {
		    public void save(Employee employee);
		    public Employee findById(int id);
		    public void update(Employee employee);
		    public void delete(int id);
		}
		
		// DAO Implementation (เชื่อมต่อกับฐานข้อมูลจริง)
		public class EmployeeDAOImpl implements EmployeeDAO {
		    private Connection connection;
		
		    public EmployeeDAOImpl() {
		        // ตั้งค่าการเชื่อมต่อกับฐานข้อมูล
		        this.connection = DatabaseConnection.getConnection();
		    }
		
		    @Override
		    public void save(Employee employee) {
		        // การบันทึกข้อมูลลงฐานข้อมูล
		    }
		
		    @Override
		    public Employee findById(int id) {
		        // การดึงข้อมูลจากฐานข้อมูลโดยใช้ id
		    }
		
		    @Override
		    public void update(Employee employee) {
		        // การอัปเดตข้อมูลในฐานข้อมูล
		    }
		
		    @Override
		    public void delete(int id) {
		        // การลบข้อมูลจากฐานข้อมูล
		    }
		}

	ข้อดีของการใช้ DAO:
	แยกความรับผิดชอบ: ช่วยให้แยกการเข้าถึงข้อมูลออกจากส่วนอื่นๆ ของโปรแกรม ทำให้โค้ดสะอาดและดูแลได้ง่ายขึ้น
	ความยืดหยุ่น: ถ้าต้องการเปลี่ยนแหล่งข้อมูล (เช่น เปลี่ยนจาก MySQL เป็น PostgreSQL) สามารถทำได้โดยไม่ต้องแก้ไขส่วนที่ใช้ DAO
	การทดสอบง่ายขึ้น: สามารถทดสอบได้ง่ายขึ้นเนื่องจากแยกส่วนการเข้าถึงข้อมูลออกจากธุรกิจหลัก
	สรุป:
	DAO เป็นรูปแบบการออกแบบซอฟต์แวร์ที่ใช้แยกการเข้าถึงข้อมูลจากส่วนที่เกี่ยวข้องกับธุรกิจหลัก เพื่อให้โค้ดมีความยืดหยุ่นและสามารถบำรุงรักษาได้ง่ายขึ้น โดยการใช้ Interface และการแยกการทำงานของฐานข้อมูลออกจากส่วนอื่นๆ ในโปรแกรม
	 */
	
	public static void main(String[] args) {
		
	}
}
