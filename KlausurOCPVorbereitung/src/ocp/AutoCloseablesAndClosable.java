package ocp;

public class AutoCloseablesAndClosable {

	/*
	 * Which are true? (Choose all that apply.)
	 * 
	 * A.	AutoCloseable extends Closeable
	 * B.	Closeable extends AutoCloseable
	 * C.	Closeable is a marker interface and does not require the implementer to define any methods
	 * D.	A concrete class implementing Closeable must implement at least one method
	 * E.	Classes implementing AutoCloseable can be in the try of try-with-resources
	 * F.	Classes implementing Closeable can be in the try of try-with-resources




		B, D, E, and F are correct. AutoCloseable was added after Closeable, and Closeable extends it for existing code to work. Both interfaces have a close() method to work with Automatic Resource Management for try-with-resources.

		A and C are incorrect based on the above.
	 */
	
	
	/*
	 * คำถาม: ตัวเลือกไหนที่ถูกต้อง? (เลือกทุกข้อที่ใช้)

		A. AutoCloseable extends Closeable		
		ไม่ถูกต้อง: จริงๆ แล้ว Closeable ขยายจาก AutoCloseable ไม่ใช่ในทางกลับกัน
		
		B. Closeable ขยายจาก AutoCloseable		
		ถูกต้อง: Closeable extends AutoCloseable เพื่อให้รองรับโค้ดที่มีอยู่แล้ว ซึ่ง AutoCloseable ถูกเพิ่มเข้ามาหลังจาก Closeable
		
		C. Closeable เป็น marker interface และไม่จำเป็นต้องกำหนดเมธอดใด ๆ		
		ไม่ถูกต้อง: Closeable เป็น interface ที่มีเมธอด close() ซึ่งต้องถูกกำหนด
	
		D. คลาสที่ใช้ Closeable ต้องมีการกำหนดเมธอดอย่างน้อยหนึ่งเมธอด	
		ถูกต้อง: คลาสที่ implements Closeable จะต้องกำหนดเมธอด close() ซึ่งเป็นเมธอดที่อยู่ใน Closeable
		
		E. คลาสที่ implements AutoCloseable สามารถใช้ใน try ของ try-with-resources		
		ถูกต้อง: คลาสที่ implements AutoCloseable สามารถใช้ใน try-with-resources ได้ 
		เนื่องจาก AutoCloseable มีการกำหนดเมธอด close() ที่สามารถใช้งานได้
		
		F. คลาสที่ implements Closeable สามารถใช้ใน try ของ try-with-resources	
		ถูกต้อง: คลาสที่ implements Closeable ก็สามารถใช้ใน try-with-resources ได้เช่นกัน 
		เพราะ Closeable ก็มีเมธอด close() ที่ใช้ในการจัดการทรัพยากรอัตโนมัติ
		
		
		สรุป: คำตอบที่ถูกต้องคือ B, D, E, และ F
		
			A และ C ไม่ถูกต้องตามคำอธิบายข้างต้น.
	 */
}
