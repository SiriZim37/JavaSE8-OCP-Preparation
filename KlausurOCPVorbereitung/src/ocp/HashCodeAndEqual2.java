package ocp;

public class HashCodeAndEqual2 {

	public static void main(String[] args) {
		/*
		If class Dog follows the equals and hashCode contracts, and if x and y are reference variables
		for two Dog objects, which are true? (Choose all that apply.)

		A.If x.equals(y) is true, then x == y must be true.
		B.If x.equals(y) is false, then x == y may be true.
		C.If x.equals(y) is true, then x == y may be false.
		D.If x.equals(y) is true, then (x.hashCode() == y.hashCode()) may be false.
		E.If x.equals(y) is false, then (x.hashCode() == y.hashCode()) may be true.
		F.If x == y is false, then x.equals(y) must be false.
		
		C and E are correct. C is correct because equals() can be less strict than ==.
		E is correct because hashCode() can be less strict than equals().
				
		*/
		
		/*
	    ถ้าคลาส Dog ปฏิบัติตามข้อกำหนดของ equals และ hashCode และถ้า x และ y 
	    เป็นตัวแปรอ้างอิง (reference variables) ของออบเจ็กต์ Dog สองตัว
	    ข้อใดต่อไปนี้เป็นจริง? (เลือกทั้งหมดที่ถูกต้อง)
		*/
	
		// ตัวเลือก A: ถ้า x.equals(y) คืนค่า true แสดงว่า x == y ต้องเป็นจริง
		// => ไม่ถูกต้อง เพราะ equals() ตรวจสอบความเท่าเทียมกันของค่าหรือคุณสมบัติ ไม่ใช่การเปรียบเทียบการอ้างอิง
	
		// ตัวเลือก B: ถ้า x.equals(y) คืนค่า false แสดงว่า x == y อาจเป็นจริงได้
		// => ไม่ถูกต้อง เพราะการเปรียบเทียบ == ตรวจสอบการอ้างอิง ไม่เกี่ยวข้องกับ equals()
	
		// ตัวเลือก C: ถ้า x.equals(y) คืนค่า true แสดงว่า x == y อาจเป็น false ได้
		// => ถูกต้อง เพราะ equals() สามารถตรวจสอบความเท่าเทียมกันของค่าหรือคุณสมบัติได้
		// โดยที่ x และ y อาจอ้างถึงออบเจ็กต์ต่างกันในหน่วยความจำ
	
		// ตัวเลือก D: ถ้า x.equals(y) คืนค่า true แสดงว่า (x.hashCode() == y.hashCode()) อาจเป็น false ได้
		// => ไม่ถูกต้อง เพราะ contract ของ equals() และ hashCode() กำหนดไว้ว่าถ้า equals() คืนค่า true 
		// hashCode() ของออบเจ็กต์ทั้งสองต้องเท่ากันเสมอ
	
		// ตัวเลือก E: ถ้า x.equals(y) คืนค่า false แสดงว่า (x.hashCode() == y.hashCode()) อาจเป็น true ได้
		// => ถูกต้อง เพราะ hashCode() ไม่จำเป็นต้องแตกต่างกันเมื่อ equals() คืนค่า false 
		// hashCode() อาจชนกันได้ (เรียกว่า hash collision)
	
		// ตัวเลือก F: ถ้า x == y คืนค่า false แสดงว่า x.equals(y) ต้องเป็น false
		// => ไม่ถูกต้อง เพราะ == ตรวจสอบการอ้างอิงในหน่วยความจำ ซึ่งต่างจาก equals()
	
		/*
		    คำตอบที่ถูกต้องคือ C และ E
		    - C ถูกต้องเพราะ equals() สามารถตรวจสอบค่าหรือคุณสมบัติได้โดยที่ออบเจ็กต์ไม่ใช่อันเดียวกัน
		    - E ถูกต้องเพราะ hashCode() ไม่ได้เข้มงวดเท่ากับ equals()
		*/
	
	}
}
