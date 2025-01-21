package dao;

public class A01_DAOExamToKnow2 {

	/*
	1. การออกแบบวิธีการใน DAO
	วิเคราะห์อินเตอร์เฟซ DAO ต่อไปนี้ ว่าวิธีไหนที่เหมาะสม และวิธีไหนที่ละเมิดหลักการของการออกแบบ DAO? โปรดให้เหตุผลสำหรับคำตอบของคุณ

	interface CarDAO {
	    void save(Car car);                // ถูกต้อง: วิธีนี้เป็นวิธี Create ที่ใช้ได้
	    Car getCarByLicense(String license); // ถูกต้อง: วิธีนี้เป็นวิธี Read ที่ใช้ได้
	    void updateEngineSpecs(Car car);   // ไม่เหมาะสม: วิธีการ Update ควรมีชื่อทั่วไป เช่น `update(Car car)` แทนที่จะระบุรายละเอียดเฉพาะ เช่น `updateEngineSpecs`
	    void deleteAllCars();              // ไม่เหมาะสม: วิธีนี้ละเมิดหลักการการโฟกัสที่เอนทิตีเดียว (Car) ซึ่งอาจจะควรเป็นวิธีอื่นหรือต้องแยกออกไปในอินเตอร์เฟซอื่น
	    List<Car> getAllCars();            // ถูกต้อง: วิธีนี้เป็นวิธี Read ที่ใช้ได้
	}
	คำอธิบาย:

	- `save` และ `getAllCars` ถูกต้องสำหรับการดำเนินการ CRUD มาตรฐาน
	- `updateEngineSpecs` เป็นชื่อที่เจาะจงเกินไป ควรใช้ชื่อที่ทั่วไป เช่น `update`
	- `deleteAllCars` ไม่ใช่สิ่งที่ใช้กันใน DAO เพราะมันลบข้อมูลทั้งหมด DAO ควรจะจัดการเอนทิตีแต่ละตัว
	- `getCarByLicense` ถูกต้อง เพราะมันดึงข้อมูลรถยนต์จากรหัสทะเบียนที่เฉพาะเจาะจง

	*/
	
	//------------------------------------------------------------------------------------------//

	/*
	2. การดำเนินการทางธุรกรรมใน DAO
	วิธีการนี้ออกแบบสำหรับการลบข้อมูลหลายรายการใน DAO ให้ระบุปัญหาและแนะนำการปรับปรุง

	default void deleteMultiple(List<Integer> ids) {
	    for (int id : ids) {
	        deleteOnId(id);
	    }
	}
	คำอธิบาย:

	ปัญหา: วิธีนี้ทำการลบหลายครั้งติดต่อกัน แต่ถ้าการลบครั้งใดครั้งหนึ่งล้มเหลว การลบก่อนหน้านี้อาจจะสำเร็จแล้ว ซึ่งอาจทำให้สถานะของฐานข้อมูลไม่สอดคล้องกัน นอกจากนี้ยังมีการเปิดการเชื่อมต่อหลายครั้งซึ่งไม่เหมาะสม

	วิธีการแก้ไข:

	ใช้ธุรกรรมเพื่อให้มั่นใจว่าเป็นการทำงานที่เป็นอะตอม (ทั้งหมดลบสำเร็จ หรือไม่ลบเลย)
	การปรับปรุงที่แนะนำ:

	default void deleteMultiple(List<Integer> ids) {
	    try (Connection conn = DriverManager.getConnection(URL)) {
	        conn.setAutoCommit(false); // เริ่มธุรกรรม
	        for (int id : ids) {
	            deleteOnId(id, conn); // ส่งการเชื่อมต่อไปที่วิธีการ
	        }
	        conn.commit(); // คอมมิตธุรกรรมหากการลบทั้งหมดสำเร็จ
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            conn.rollback(); // ยกเลิกหากเกิดข้อผิดพลาด
	        } catch (SQLException rollbackEx) {
	            rollbackEx.printStackTrace();
	        }
	    }
	}
	*/
	
	//------------------------------------------------------------------------------------------//

	/*
	3. การจัดการข้อผิดพลาดใน DAO
	คุณได้สร้างวิธีการ DAO สำหรับการแทรกข้อมูลลงในฐานข้อมูล กรุณาตรวจสอบโค้ดด้านล่างและพิจารณาว่ามันปฏิบัติตามแนวปฏิบัติที่ดีที่สุดในการจัดการข้อผิดพลาดหรือไม่:

	@Override
	public void create(Person person) {
	    try (Connection conn = DriverManager.getConnection(URL);
	         PreparedStatement stmt = conn.prepareStatement("INSERT INTO Person VALUES (?, ?)")) {
	        stmt.setInt(1, person.getId());
	        stmt.setString(2, person.getName());
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace(); // ไม่เหมาะสม ข้อมูลที่ละเอียดอาจถูกเปิดเผย
	    }
	}

	คำอธิบาย:

	ปัญหา: การใช้ `e.printStackTrace()` ไม่แนะนำในโค้ดที่ใช้งานจริง เพราะอาจเปิดเผยข้อมูลที่ละเอียด และไม่ได้จัดการข้อผิดพลาดให้เหมาะสมกับผู้ใช้

	การแก้ไขที่แนะนำ:

	ใช้การบันทึกข้อมูล (เช่น SLF4J หรือ Logback) และโยนข้อยกเว้นที่กำหนดเองเพื่อการจัดการข้อผิดพลาดที่ดีกว่า

	คำตอบที่ถูกต้อง:

	@Override
	public void create(Person person) {
	    try (Connection conn = DriverManager.getConnection(URL);
	         PreparedStatement stmt = conn.prepareStatement("INSERT INTO Person VALUES (?, ?)")) {
	        stmt.setInt(1, person.getId());
	        stmt.setString(2, person.getName());
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        logger.error("Error inserting person: " + person, e); // บันทึกข้อผิดพลาด
	        throw new DataAccessException("Failed to insert person", e); // ข้อยกเว้นที่กำหนดเอง
	    }
	}
	*/

	//------------------------------------------------------------------------------------------//
	
	/*
	4. อินเตอร์เฟซ DAO ทั่วไป
	คำตอบที่ถูกต้อง:

	interface GenericDAO<T> {
	    void create(T entity);  // ถูกต้อง: วิธีทั่วไปสำหรับการสร้างเอนทิตี
	    T getById(int id);      // ถูกต้อง: ดึงข้อมูลเอนทิตีตาม ID
	    List<T> getAll();       // ถูกต้อง: ดึงข้อมูลทั้งหมด
	    boolean delete(int id); // ถูกต้อง: ลบเอนทิตีตาม ID
	}
	คำอธิบาย:

	อินเตอร์เฟซนี้เป็นแบบทั่วไปและสามารถใช้กับเอนทิตีใดๆ (เช่น Person, Car, Product) วิธีการเหล่านี้ใช้ได้กับเอนทิตีทุกประเภท
	*/
	
	//------------------------------------------------------------------------------------------//

	/*
	5. การจัดการการเชื่อมต่อฐานข้อมูล
	ในการออกแบบ DAO ควรจัดการการเชื่อมต่อฐานข้อมูลอย่างไรเพื่อประสิทธิภาพและการใช้งานใหม่? เลือกวิธีที่ถูกต้อง:

	A. สร้างการเชื่อมต่อใหม่สำหรับแต่ละวิธีใน DAO
	B. ใช้พูลการเชื่อมต่อในการจัดการการเชื่อมต่อฐานข้อมูล
	C. รักษาการเชื่อมต่อสแตติกเดียวตลอดอายุการใช้งานของแอปพลิเคชัน
	D. อนุญาตให้โค้ดของลูกค้าจัดการการเชื่อมต่อในวิธีการของ DAO

	คำตอบที่ถูกต้อง: B. ใช้พูลการเชื่อมต่อในการจัดการการเชื่อมต่อฐานข้อมูล

	คำอธิบาย:

	- A: การสร้างการเชื่อมต่อใหม่สำหรับแต่ละวิธีไม่เหมาะสมและอาจทำให้ทรัพยากรหมด
	- B: การใช้พูลการเชื่อมต่อเป็นวิธีที่มีประสิทธิภาพในการจัดการการเชื่อมต่อฐานข้อมูล เพราะมันใช้การเชื่อมต่อที่มีอยู่แล้ว
	- C: การใช้การเชื่อมต่อสแตติกอาจทำให้เกิดการรั่วไหลของทรัพยากรและไม่สามารถขยายตัวได้
	- D: การให้โค้ดของลูกค้าจัดการการเชื่อมต่อเป็นการผสมผสานหน้าที่กันและไม่แนะนำ
	*/
	
	//------------------------------------------------------------------------------------------//

	/*
	6. การตรวจสอบการดำเนินการของ DAO
	คุณได้รับการดำเนินการ DAO ที่ละเมิดหลักการของการห่อหุ้ม (encapsulation) ระบุปัญหา:

	class ProductDAO {
	    Connection connection = DriverManager.getConnection(URL); // ปัญหา: การจัดการการเชื่อมต่อละเมิดหลักการของการห่อหุ้ม
	    
	    public ProductDAO() throws SQLException {
	        this.connection = DriverManager.getConnection(URL);
	    }
	    
	    public void create(Product product) {
	        // การดำเนินการ
	    }
	    
	    public void closeConnection() throws SQLException {
	        connection.close();
	    }
	}

	คำอธิบาย:

	ปัญหา: การดำเนินการนี้กำหนดค่าการเชื่อมต่อและแสดงออกภายนอก DAO ซึ่งละเมิดหลักการการห่อหุ้ม

	การแก้ไข:

	การเชื่อมต่อควรจะถูกจัดการโดยพูลการเชื่อมต่อหรือถูกส่งเป็นพารามิเตอร์แทนที่จะถูกสร้างภายใน DAO
	การดำเนินการที่ถูกต้อง:

	class ProductDAO {
	    private Connection connection;
	    
	    public ProductDAO(Connection connection) {
	        this.connection = connection; // การเชื่อมต่อถูกส่งมาจากผู้เรียก
	    }
	    
	    public void create(Product product) {
	        // การดำเนินการ
	    }
	    
	    public void closeConnection() throws SQLException {
	        connection.close(); // ปิดการเชื่อมต่อที่ได้รับมา
	    }
	}
	*/

	//------------------------------------------------------------------------------------------//

}
