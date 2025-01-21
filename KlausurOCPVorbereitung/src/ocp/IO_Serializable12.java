package ocp;

import java.io.*;



public class IO_Serializable12 extends Dog {
	
	public static void main(String[] args) {
		
//		BufferedWriter b1 = new BufferedWriter(new File("f"));		
//		BufferedWriter b2 = new BufferedWriter(new FileWriter("f1"));
//		BufferedWriter b3 = new BufferedWriter(new PrintWriter("f2"));
//		BufferedWriter b4 = new BufferedWriter(new BufferedWriter(bw));
	}
	/*
	 * Given that bw is a reference to a valid BufferedWriter, and the snippet:
	 * 
	 * 15. BufferedWriter b1 = new BufferedWriter(new File("f"));
	 * 16. BufferedWriter b2 = new BufferedWriter(new FileWriter("f1"));
	 * 17. BufferedWriter b3 = new BufferedWriter(new PrintWriter("f2"));
	 * 18. BufferedWriter b4 = new BufferedWriter(new BufferedWriter(bw));
	 * 
	 * What is the result?
	 * 
	 * A. Compilation succeeds.
	 * 
	 * B. Compilation fails due only to an error on line 15.
	 * 
	 * C. Compilation fails due only to an error on line 16.
	 * 
	 * D. Compilation fails due only to an error on line 17.
	 * 
	 * E. Compilation fails due only to an error on line 18.
	 * 
	 * F. Compilation fails due to errors on multiple lines.
	 * 
	 * 
	 * B is correct. A BufferedWriter can be constructed only by wrapping a Writer. Lines 16, 17, and 18 are correct because BufferedWriter, FileWriter, and PrintWriter all extend Writer. (Note: BufferedWriter is a decorator class. Decorator classes are used extensively in the java.io package to allow you to extend the functionality of other classes.)
	 * 
	 * A, C, D, E, and F are incorrect based on the above.
	 * 
	 * คำอธิบาย:
	 * - ข้อ A: ข้อ A ไม่ถูกต้อง เพราะบรรทัดที่ 15 เป็นการใช้งานผิด เนื่องจากการสร้าง `BufferedWriter` 
	 * 		ควรต้องมี `Writer` อยู่ในตัว (เช่น `FileWriter` หรือ `PrintWriter`) 
	 * 		แต่ในบรรทัดที่ 15 ใช้ `new File("f")` ซึ่งไม่ถูกต้อง เพราะ `File` ไม่ได้สืบทอดจาก `Writer`
	 * - ข้อ B: ข้อ B ถูกต้อง เพราะบรรทัดที่ 15 ใช้ `File` ซึ่งไม่สามารถใช้กับ `BufferedWriter` ได้
	 * - ข้อ C: ข้อ C ไม่ถูกต้อง เพราะ `FileWriter` นั้นสามารถใช้งานได้กับ `BufferedWriter` ดังนั้นบรรทัดที่ 16 จึงไม่ผิด
	 * - ข้อ D: ข้อ D ไม่ถูกต้อง เพราะ `PrintWriter` ก็สามารถใช้กับ `BufferedWriter` ได้ เนื่องจากมันสืบทอดจาก `Writer`
	 * - ข้อ E: ข้อ E ไม่ถูกต้อง เพราะ `BufferedWriter` สามารถรับ `BufferedWriter` อื่น ๆ ในตัว constructor ได้ ซึ่งเป็นการทำงานของ "decorator pattern"
	 * - ข้อ F: ข้อ F ไม่ถูกต้อง เพราะข้อที่ผิดเพียงข้อเดียวคือข้อ 15 เท่านั้น
	 */

	
}

