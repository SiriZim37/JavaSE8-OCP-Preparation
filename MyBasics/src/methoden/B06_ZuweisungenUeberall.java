package methoden;

public class B06_ZuweisungenUeberall {

	/*
	 Implicit casting ทำได้ในกรณีค่าคงที่ (int ไป byte) หรือชนิดข้อมูลที่ช่วงค่ากว้างกว่า (byte ไป int)
	Explicit casting จำเป็นในกรณีที่ค่าคงที่หรือชนิดข้อมูลไม่สามารถแปลงได้อัตโนมัติ
	ควรระมัดระวังการใช้ชนิดข้อมูล float และ double เนื่องจากไม่สามารถแปลงได้โดยอัตโนมัติ
	 */
	public static void main(String[] args) {
		
		/*
		 * Implizite Zuweisung beim Übergeben der Argumente.
		 * "การแปลงชนิดข้อมูลโดยอัตโนมัติเมื่อส่งค่าอาร์กิวเมนต์"
		 * 
		 */
		m1(12); // int param = 12
		
		/*
		 * Achtung! 
		 * Bei einer expliziten Zuweisung mit int-Literalen kann 
		 * der Compiler ausnahmsweise den Wert des Literals auswerten.  
		 * 
		 * Keine Ausnahmen beim Übergeben der Argumente!
		 * Der Typ rechts muss in den Typ links passen!
		 */
		byte b1 = 12; // Ausnahme: implizites Casting (byte)12
		
		/*
		 * ฟังก์ชัน m2 รับพารามิเตอร์ชนิด byte
		 * แต่การส่งค่าคงที่ 12 (ชนิด int) จะ ไม่สามารถแปลงอัตโนมัติได้
		 */
		//m2(12); 	// cf: byte <- int
					// byte param = 12, aber kein implizites Casting!
		
		m2((byte)12); // byte <- byte
		
		/*
		 * การส่งค่า double ให้ฟังก์ชัน m3 ซึ่งรับ float จะ ไม่สามารถแปลงอัตโนมัติได้
		 */
		//m3(2.0);	// cf: float <- double
		
		m3(2.0f);   // float <- float
	}
	
	static void m1(int param) {}
	static void m2(byte param) {}
	static void m3(float param) {}

	/*
	 * "การแปลงชนิดข้อมูลโดยอัตโนมัติในคำสั่ง return"
	 * 
	 * Implizite Zuweisung mit return.
	 * 
	 * Es gelten dieselnben Regeln wie bei der 
	 * expliziten Zuweisung.
	 */
	
	// การแปลงข้อมูลแบบ implicit ทำได้ เพราะ int มีช่วงค่ากว้างกว่า byte
	static int m4() {
		byte b = 12;
		return b; 	// int cpu = b
					// ok: int <- byte
	}
	
	/*
	 * ข้อยกเว้น: ค่าคงที่ที่อยู่ในช่วงของ byte จะสามารถแปลงเป็น byte ได้โดยอัตโนมัติ
	 */
	static byte m5() {
					// Implizites Casting (Ausnahme für int-Literale)
		return 12;	// int cpu = (byte)12	
					// byte <- byte
	}
	
	
	
	
	/*
	 * ไม่สามารถ return ตัวแปร int เป็น byte ได้โดยตรง
	 */
//	static byte m55() {
//		int x = 12;
//		return x;	// cf: 	byte cpu = x
//					// 		byte <- int
//	}
	
	static byte m55() {
		int x = 12;
		return (byte) x;	
	}
	
	/*
	 * return 2.0 ซึ่งเป็น double ไปยังชนิด float ไม่สามารถทำได้
	 */
//	static float m6() {
//		return 2.0;		// cf: float cpu = 2.0
//						//     float <- double
//	}
	
}
