package oca;

public class ThrownByJVM_or_Developer {

	/*
	 * Tips for OCP
	 * JVM โยน: Exceptions ที่เกิดจาก Runtime Errors โดยอัตโนมัติ
	 * Developer โยน: Exceptions ที่ต้องการ validate หรือป้องกันข้อผิดพลาดในโค้ด
	 * จำลักษณะ:
	 * 
	 * JVM: เช่น Null, Index, Memory, Cast
	 * Developer: เช่น Invalid Input, Custom Validation
	 * 
	 * จำง่าย: JVM โยนข้อผิดพลาดที่ระบบตรวจพบเอง ส่วน Developer ใช้ Exception เพื่อจัดการ input หรือสถานะโปรแกรม

	 *//*
	 * Tips for OCP:
	 * 
	 * - JVM-Thrown Exceptions: These are typically caused by runtime errors that the JVM detects automatically.
	 * - Developer-Thrown Exceptions: These are thrown when the developer wants to validate input or prevent errors in the code.
	 * 
	 * Key Characteristics:
	 * - JVM-Thrown: Examples include NullPointerException, ArrayIndexOutOfBoundsException, ClassCastException, StackOverflowError, and OutOfMemoryError.
	 * - Developer-Thrown: Examples include NumberFormatException, IllegalArgumentException, IllegalStateException, and IOException.
	 * 
	 * Easy Reminder:
	 * - JVM throws errors that the system detects automatically, while the developer uses exceptions to handle input or object state.
	 * 
	 * ============================
	 * Exception                  | Thrown By  | Explanation (Thai) 
	 * ============================
	 * NullPointerException       | JVM        | เกิดจากการเข้าถึงออบเจ็กต์ที่เป็น null เช่น str.length()
	 * ArrayIndexOutOfBoundsException | JVM    | เกิดจากการเข้าถึงตำแหน่งของอาร์เรย์ที่เกินขอบเขต เช่น arr[5]
	 * ClassCastException         | JVM        | เกิดเมื่อแคสออบเจ็กต์ไปยังคลาสที่เข้ากันไม่ได้ เช่น (String) obj
	 * StackOverflowError         | JVM        | เกิดจากการเรียกเมธอดซ้ำมากเกินไป (Recursion ไม่สิ้นสุด)
	 * OutOfMemoryError           | JVM        | เกิดเมื่อ JVM ใช้หน่วยความจำหมด
	 * NumberFormatException      | Developer  | เกิดจากการแปลง String ที่ไม่ใช่ตัวเลข เช่น Integer.parseInt("abc")
	 * IllegalArgumentException   | Developer  | เกิดจากการส่งพารามิเตอร์ที่ไม่ถูกต้องให้เมธอด
	 * IllegalStateException      | Developer  | เกิดเมื่อสถานะของออบเจ็กต์ไม่เหมาะสมกับการเรียกเมธอดนั้น
	 * IOException                | Developer  | เกิดจากการทำงานกับ I/O เช่น การอ่านไฟล์ที่ไม่มี (Checked Exception)
	 */
}


