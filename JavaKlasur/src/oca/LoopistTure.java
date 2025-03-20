package oca;

public class LoopistTure {

	public static void main(String[] args) {
		/*
		 * - Any kind of loop can be labeled
		 * - The do loop is guaranteed to be excuted at least one
		 * - An unlabeled break statement always terminated the loop that contains it
		 * 
		 * - while loop excuted zero or more timed
		 * - do while loop excuted one or more times
		 * - for loop can look at every other element of an array
		 */
		
		/*
		 *  ลูปใด ๆ ใน Java สามารถตั้ง ป้ายกำกับ (label) ได้
					outerLoop:
					for (int i = 0; i < 3; i++) {
					    for (int j = 0; j < 3; j++) {
					        if (i == j) {
					            break outerLoop; // ออกจากลูปที่มีป้ายกำกับ
					        }
					    }
					}
			ลูป do-while จะทำงานอย่างน้อย 1 ครั้ง ก่อนตรวจสอบเงื่อนไข
			
			คำสั่ง break ที่ไม่มีป้ายกำกับ จะหยุด ลูปที่ครอบคลุมมัน
			
			ลูป while อาจทำงาน 0 ครั้งหรือมากกว่า
			
			ลูป do-while ทำงานอย่างน้อย 1 ครั้งหรือมากกว่า
			
			ลูป for สามารถใช้ตรวจสอบ ทุก ๆ องค์ประกอบที่สองในอาร์เรย์ ได้
		 */
	}
}
