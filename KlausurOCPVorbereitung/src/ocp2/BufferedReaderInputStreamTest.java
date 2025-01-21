package ocp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderInputStreamTest {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.print("Enter GDP: ");
	    // line 1
	    
	    
	}
	
	/*
	 *  Which code fragment, when inserted at line 1, enables the code to read the GDP from the user?
		 A. int GDP = Integer.parseInt (br.readline());
		 B. int GDP = br.read();
		 C. int GDP = br.nextInt();
		 D. int GDP = Integer.parseInt (br.next());
	 */
	
	
	/*
	 * A. int GDP = Integer.parseInt(br.readLine());
			ถูกต้อง: br.readLine() จะอ่านข้อความที่ผู้ใช้ป้อนเข้ามาจากคีย์บอร์ดในรูปแบบของสตริง (String). 
			จากนั้น Integer.parseInt() จะเปลี่ยนสตริงที่อ่านได้ให้เป็นจำนวนเต็ม (integer).
			วิธีนี้จะทำให้โปรแกรมสามารถอ่านค่า GDP จากผู้ใช้และแปลงเป็นจำนวนเต็มได้อย่างถูกต้อง.
		
		B. int GDP = br.read();
			ไม่ถูกต้อง: เมธอด read() ของ BufferedReader จะอ่านข้อมูลเป็นรหัส ASCII (int) 
			ของตัวอักษรตัวแรกที่ผู้ใช้พิมพ์ ไม่ใช่การอ่านข้อมูลทั้งหมดเป็นสตริงหรือจำนวนเต็ม.
			ผลลัพธ์จาก br.read() คือการรับค่าเป็นรหัส ASCII ของอักขระแรก ไม่ใช่การแปลงเป็นจำนวนเต็มจากอินพุตของผู้ใช้.
		
		C. int GDP = br.nextInt();
			ไม่ถูกต้อง: BufferedReader ไม่มีเมธอด nextInt(). เมธอด nextInt() เป็นเมธอดของ Scanner 
			ซึ่งเป็นคลาสที่ใช้ในการอ่านข้อมูลจากผู้ใช้, ไม่ใช่ของ BufferedReader. หากต้องการใช้ nextInt(), 
			ควรใช้ Scanner แทน BufferedReader.
		
		D. int GDP = Integer.parseInt(br.next());
			ไม่ถูกต้อง: เช่นเดียวกับตัวเลือก C, next() เป็นเมธอดของ Scanner และไม่สามารถใช้งานกับ 
			BufferedReader. นอกจากนี้, next() อ่านค่าที่เป็นสตริงและไม่เหมาะสมในการอ่านค่า GDP 
			ซึ่งควรแปลงจากสตริงเป็นจำนวนเต็มด้วย Integer.parseInt().
	 */
}
