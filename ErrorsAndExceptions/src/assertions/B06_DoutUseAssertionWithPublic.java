package assertions;

public class B06_DoutUseAssertionWithPublic {

	public static void main(String[] args) {
		/*
		Assertion กับ Public Method ใน Java

		Java มีข้อแนะนำสำคัญเกี่ยวกับการใช้ assertions กับ public methods นั่นคือ ไม่ควรใช้ assertions เพื่อ validate input ใน public methods เนื่องจาก assertion สามารถถูกปิดการทำงานได้ (ด้วยการไม่ใช้ flag -ea ขณะรันโปรแกรม) ซึ่งอาจทำให้ validation หายไปใน production environment

		ทำไมไม่ควรใช้ assertion ใน public methods?
		Public methods ควรถูกออกแบบให้รองรับการใช้งานทั่วไป (API) และต้องมีการตรวจสอบค่า input อย่างปลอดภัย
		หากใช้ assertion สำหรับตรวจสอบ input แล้ว assertion ถูกปิด (disabled) จะทำให้เงื่อนไขนั้นไม่ถูกตรวจสอบเลย
		ตัวอย่างการใช้ assertion ใน public method (ที่ไม่แนะนำ):
	
		 
		 */
		class TestA{

			private int age;
			public void setAge(int age) {
			    assert age > 0 : "Age must be positive";
			    this.age = age;
			}
		}
		/*
		ปัญหา: หาก assertion ถูกปิด (-da หรือไม่ใช้ -ea) การตรวจสอบค่า age จะไม่เกิดขึ้น ทำให้สามารถส่งค่าไม่ถูกต้อง เช่น age = -5 ได้
		วิธีที่ถูกต้องในการตรวจสอบ input ใน public method:
		ควรใช้ exception แทน assertion ใน public methods เพื่อให้การตรวจสอบทำงานเสมอ ไม่ว่าจะเปิดหรือปิด assertion
		*/
		class Testb{
			private int age;
			public void setAge(int age) {
			    if (age <= 0) {
			        throw new IllegalArgumentException("Age must be positive");
			    }
			    this.age = age;
			}
		}

		/*
		การใช้ assertion อย่างเหมาะสม:
		ใช้ใน private methods หรือโค้ดส่วนที่ developer ควบคุมได้
		ใช้เพื่อ "ยืนยัน" ว่าสถานะหรือเงื่อนไขภายในโปรแกรมถูกต้องตามที่คาดไว้
		ไม่ใช้เพื่อตรวจสอบ input จากภายนอก (input validation)
		*/
	}
}
