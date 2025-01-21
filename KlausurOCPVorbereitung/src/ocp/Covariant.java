package ocp;

class Programmer {
  Programmer debug() { return this; }
}
class SCJP extends Programmer {
  // insert code here line 5 
		
//    Programmer debug() { return this; } 			// ok A: Override เมธอดเดิม  
//    SCJP debug() { return this; }					// ok B: Override เมธอดเดิม แต่ใช้ covariant return type
//    int debug(int x) { return 1; }				// ok E: Overload เมธอดเดิม โดยเปลี่ยนพารามิเตอร์
//    Object debug(int x) { return this; }			// ok F: Overload เมธอดเดิม โดยเปลี่ยนพารามิเตอร์และชนิดข้อมูลที่คืนค่า
	
}
/*
 * Which, inserted at line 5, will compile? (Choose all that apply.)
 * 
	A.Programmer debug() { return this; }
	B.SCJP debug() { return this; }
	C.Object debug() { return this; }
	D.int debug() { return 1; }
	E.int debug(int x) { return 1; }
	F.Object debug(int x) { return this; }

	A, B, E, and F are correct. A and B are examples of overriding; 
	specifically, B is an example of overriding using a covariant return. 
	E and F are examples of overloading.

	C and D are incorrect. They are illegal overrides because their 
	return types are incompatible. They are illegal overloads because their arguments did not change.
	
	
	*** สรุปคำตอบที่ถูกต้อง: A, B, E และ F
	A และ B: เป็นการ override เมธอดเดิม (B ใช้ covariant return)
	E และ F: เป็นการ overload เมธอดเดิมโดยเปลี่ยนพารามิเตอร์
	
	เหตุผลที่ C และ D ผิด:
	C:ไม่สามารถ override เมธอดได้ เนื่องจากชนิดข้อมูลที่คืนค่า (Object) ไม่เข้ากันกับชนิดข้อมูลเดิม (Programmer) และไม่ใช่ชนิดที่สืบทอดกัน
	D: ชนิดข้อมูลที่คืนค่าเป็น int ซึ่งไม่สามารถ override เมธอดที่คืนค่าเป็นออบเจ็กต์ได้
	ทั้งสองกรณีนี้เป็นการ override ที่ไม่ถูกต้อง และ overload ก็ไม่ใช่ เพราะไม่ได้เปลี่ยนพารามิเตอร์
 * 
 */

		
public class Covariant {

}
