package ocp;

public class Localization4 {
	
	/*
	 * Given:
	 * import java.util.*;
	 * import java.io.*;
	 * class Props {
	 *   public static void main(String[] args) {
	 *     Properties p = new Properties();
	 *     p.setProperty("k1", "v1");
	 *     p.setProperty("k2", "v2");
	 *     p.list(System.out);
	 *     try {
	 *       FileOutputStream out = new FileOutputStream("myProps.properties");
	 *       p.store(out, "test");           // Line A
	 *       out.close();
	 *     } catch (IOException e) {
	 *       System.out.println("exc 1");
	 *     }
	 *     Properties p2 = new Properties();
	 *     p2.setProperty("a1", "a2");
	 *     try {
	 *       FileInputStream in = new FileInputStream("myProps.properties");
	 *       p2.load(in);                    // Line B
	 *       in.close();
	 *       p2.list(System.out);
	 *     } catch (IOException e) {
	 *       System.out.println("exc 2");
	 * } } }
	 * Which are true?
	 * 
	 * A. Four key/value pairs will be output.
	 * 
	 * B. Five key/value pairs will be output.
	 * 
	 * C. The file names must end in .properties.
	 * 
	 * D. The order in which the key/value pairs is output is predictable.
	 * 
	 * E. Compilation fails due to an error at Line A.
	 * 
	 * F. Compilation fails due to an error at Line B.
	 * 
	 * 
	 * 	 * อธิบายโค้ด:
	 * 1.การสร้างออบเจกต์ Properties และตั้งค่าคู่ key-value:
	 * 
			Properties p = new Properties();
			p.setProperty("k1", "v1");
			p.setProperty("k2", "v2");
			p.list(System.out);
			
	 * สร้างออบเจกต์ Properties ชื่อ p
	 * ใช้เมธอด setProperty(key, value) เพื่อเพิ่มคู่ key-value ลงใน Properties
	 * p.list(System.out) พิมพ์ข้อมูลใน Properties ไปที่คอนโซล
	 *--------------------------------------------------------------------------- 
	  2. บันทึก Properties ลงในไฟล์:

		try {
		    FileOutputStream out = new FileOutputStream("myProps.properties");
		    p.store(out, "test");           // Line A
		    out.close();
		} catch (IOException e) {
		    System.out.println("exc 1");
		}
		สร้าง FileOutputStream เพื่อเชื่อมต่อกับไฟล์ myProps.properties
		p.store(out, "test") บันทึกข้อมูลจาก Properties ลงในไฟล์ myProps.properties 
		โดยมีคอมเมนต์ "test" เป็นการอธิบายเพิ่มเติมในไฟล์
		หลังจากบันทึกเสร็จแล้วปิดไฟล์ด้วย out.close() 

	 *--------------------------------------------------------------------------- 
	 *
	 *การสร้าง Properties ออบเจกต์ใหม่และโหลดข้อมูลจากไฟล์:

		Properties p2 = new Properties();
		p2.setProperty("a1", "a2");
		try {
		    FileInputStream in = new FileInputStream("myProps.properties");
		    p2.load(in);                    // Line B
		    in.close();
		    p2.list(System.out);
		} catch (IOException e) {
		    System.out.println("exc 2");
		}
		สร้าง Properties ออบเจกต์ใหม่ p2 และตั้งค่าเริ่มต้นเป็น a1=a2
		ใช้ FileInputStream เพื่อเปิดไฟล์ myProps.properties ที่สร้างขึ้นในขั้นตอนก่อนหน้า
		p2.load(in) โหลดข้อมูลจากไฟล์เข้าไปใน p2
		หลังจากโหลดข้อมูลเสร็จแล้วปิดไฟล์ด้วย in.close()
		p2.list(System.out) พิมพ์ข้อมูลใน p2 ไปที่คอนโซล
	 *--------------------------------------------------------------------------- 
		พิมพ์ข้อมูลจาก Properties p หลังจากตั้งค่า k1=v1 และ k2=v2:

		k1=v1
		k2=v2
		
		บันทึกข้อมูลลงในไฟล์ myProps.properties ในรูปแบบดังนี้:

		# test
		k1=v1
		k2=v2
		
		พิมพ์ข้อมูลจาก Properties p2 หลังจากที่โหลดข้อมูลจากไฟล์ myProps.properties:

		a1=a2
		k1=v1
		k2=v2
	 *--------------------------------------------------------------------------- 


	 * 
	 * B is correct.
	 * 
	 * คำอธิบาย:
	 * - A: ข้อนี้ไม่ถูกต้องเพราะหลังจากที่โปรแกรมอ่านไฟล์ที่ถูกเก็บไว้แล้ว จะมีทั้งหมด 3 คู่คีย์/ค่าออกมา (2 คู่จาก p และ 1 คู่จาก p2)
	 * - B: ข้อนี้ถูกต้อง เพราะหลังจากที่ p ถูกเก็บลงในไฟล์แล้ว และ p2 โหลดข้อมูลจากไฟล์นั้น จะมีทั้งหมด 5 คู่คีย์/ค่า (2 คู่จาก p และ 3 คู่จาก p2)
	 * - C: ข้อนี้ไม่ถูกต้อง การใช้ชื่อไฟล์ที่ลงท้ายด้วย .properties ไม่ใช่ข้อกำหนดที่จำเป็นสำหรับ `Properties` class
	 * - D: ข้อนี้ไม่ถูกต้อง เพราะ `Properties` ใช้ `Hashtable` ซึ่งไม่รับประกันลำดับการจัดเก็บ ดังนั้นไม่สามารถทำนายลำดับการออกของคีย์/ค่าได้
	 * - E: ข้อนี้ไม่ถูกต้อง เพราะ `Properties` class รองรับการใช้งาน `store()` ซึ่งทำให้โปรแกรมสามารถคอมไพล์ได้
	 * - F: ข้อนี้ไม่ถูกต้อง เพราะ `Properties` class รองรับการใช้งาน `load()` ซึ่งทำให้โปรแกรมสามารถคอมไพล์ได้
	 */

	
}
