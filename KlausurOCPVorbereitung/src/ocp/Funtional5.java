package ocp;

public class Funtional5 {

	public static void main(String[] args) {
		// LINE X
//		double readings[] = { 408.7, 409.9, 410.2, 401.9, 410.1, 409.5 };
//		for (double r : readings) { c.accept(r); }
	}

	
	/*
	 * Which code fragment(s), inserted independently at Line X, prints:
	 * 
	 * New record! 410.2
	 * New record! 410.1
	 * 
	 * (Choose all that apply.)
	 * 
	 * A. Consumer c = d -> { 
	 *       if (d > 410) { System.out.println("New record! " + d); } 
	 *    };
	 * 
	 * B. DoubleFunction c = d -> { 
	 *       if (d > 410) { System.out.println("New record! " + d); }
	 *       return d; 
	 *    };
	 * 
	 * C. DoubleConsumer c = d -> { 
	 *       if (d > 410) { System.out.println("New record! " + d); } 
	 *    };
	 * 
	 * D. Consumer<Double> c = d -> { 
	 *       if (d > 410) { System.out.println("New record! " + d); } 
	 *    };
	 * 
	 * E. Consumer<Double, Double> c = d -> { 
	 *       if (d > 410) { System.out.println("New record! " + d); } 
	 *       return d;
	 *    };
	 * 
	 * Answer: C and D are correct.
	 * 
	 * Explanation:
	 * - C: ใช้ `DoubleConsumer` ซึ่งเป็นเวอร์ชันเฉพาะของ `Consumer` สำหรับ primitive double 
	 *      และทำงานได้กับ `accept()` เนื่องจากรองรับชนิดข้อมูล double โดยตรง
	 * - D: ใช้ `Consumer<Double>` ซึ่งทำงานได้กับ `accept()` เช่นกัน แต่ double 
	 *      จะถูก autoboxed เป็น `Double` เพื่อให้เข้ากับชนิดข้อมูลที่ `Consumer<Double>` ต้องการ
	 * 
	 * Why A, B, and E are incorrect:
	 * - A: `Consumer` คาดหวังชนิดข้อมูลเป็น `Object` แต่ `accept(r)` ใช้ข้อมูลชนิด `double` ทำให้เกิดข้อผิดพลาด
	 * - B: `DoubleFunction` ไม่ใช่ `Consumer` และ `accept()` ไม่สามารถใช้งานกับ `DoubleFunction` ได้
	 * - E: `Consumer` ไม่มีรูปแบบที่รองรับพารามิเตอร์สองตัว (`<Double, Double>` ไม่มีอยู่ใน API) และ `Consumer` ไม่สามารถคืนค่าได้
	 * 
	 * อธิบายเพิ่มเติมในภาษาไทย:
	 * - C และ D ถูกต้องเพราะ `accept(r)` ใช้ได้ทั้ง `DoubleConsumer` (แบบ primitive) และ `Consumer<Double>` (แบบ Object)
	 * - A ผิดเพราะใช้ `Consumer` แบบทั่วไปซึ่งไม่รองรับ double โดยตรง
	 * - B ผิดเพราะใช้ `DoubleFunction` ซึ่งเป็นฟังก์ชันที่ต้องคืนค่า แต่ `Consumer` ไม่ได้ออกแบบมาให้คืนค่า
	 * - E ผิดเพราะไม่มี `Consumer` ที่รองรับพารามิเตอร์สองตัว และ `Consumer` ไม่คืนค่าใด ๆ
	 */

	
}
