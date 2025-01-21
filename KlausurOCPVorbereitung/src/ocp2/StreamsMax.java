package ocp2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamsMax {

	public static void main(String[] args) {
		 List<Integer> nums = Arrays.asList (-10, 20, 8);
		 System.out.println(nums.stream().max(Comparator.comparing(a -> a)).get());    // line n1 
					 
		
		 /*
		  * Which code fragment must be inserted at line n1 to enable the code to print the maximum number in the nums list?
		  	 A. nums.stream().max(Comparator.comparing(a -> a)).get()
			 B. nums.stream().max(Integer : : max).get()
			 C. nums.stream().max()
			 D. nums.stream().map(a -> a).max()
		  */

	}
	
	/*
		 A. nums.stream().max(Comparator.comparing(a -> a)).get()
	อธิบาย:
	stream() แปลงลิสต์ nums เป็น Stream เพื่อให้สามารถใช้งานฟังก์ชันที่เป็นของ Stream API ได้
	max(Comparator.comparing(a -> a)) ใช้ Comparator เพื่อเปรียบเทียบค่าของ Integer ในลิสต์ และเลือกค่ามากที่สุดจากนั้น
	.get() ใช้ดึงค่าที่ได้จาก Optional ที่คืนค่ามาจาก max()
	ผลลัพธ์: ตัวเลือกนี้จะทำงานได้ถูกต้องและจะพิมพ์ค่ามากที่สุดในลิสต์ ซึ่งในกรณีนี้คือ 20.
	
	B. nums.stream().max(Integer::max).get()
	อธิบาย:
	
	max(Integer::max) ใช้ Integer::max ซึ่งเป็น method reference ที่ใช้ฟังก์ชัน max ของ Integer ในการเปรียบเทียบค่าภายใน Stream
	วิธีนี้ไม่เหมาะสมในการหาค่าสูงสุดของลิสต์ เพราะ Integer::max เปรียบเทียบคู่ค่าทีละคู่ (เช่น เปรียบเทียบ 10 กับ 20, 20 กับ 8) และไม่สามารถใช้กับ Stream ในการหาค่าสูงสุดในลิสต์ทั้งหมด
	นั่นหมายความว่า Integer::max จะทำงานในลักษณะนี้ไม่เหมาะสมเพราะมันจะส่งคืนผลลัพธ์ที่ไม่ถูกต้องในบางกรณี
	ผลลัพธ์: ตัวเลือกนี้จะทำงานได้ผิดพลาดและพิมพ์ค่าผลลัพธ์ที่ไม่คาดคิด เช่น ค่าผลลัพธ์อาจจะเป็น 10 เนื่องจากการเปรียบเทียบแต่ละคู่.
	
	C. nums.stream().max()
	อธิบาย:
	
	max() ต้องการ Comparator ในการเปรียบเทียบค่าของ Integer ในลิสต์ แต่ที่นี่ไม่ได้ระบุ Comparator ดังนั้นโค้ดนี้จะเกิดข้อผิดพลาดในการคอมไพล์
	ไม่มีการระบุวิธีเปรียบเทียบค่าจากตัวเลขที่มีในลิสต์
	ผลลัพธ์: ตัวเลือกนี้จะทำให้เกิด ข้อผิดพลาดในการคอมไพล์ เพราะว่า max() ต้องการ Comparator เพื่อเปรียบเทียบค่าภายใน Stream.
	
	D. nums.stream().map(a -> a).max()
	อธิบาย:
	
	map(a -> a) จะไม่เปลี่ยนแปลงค่าของแต่ละตัวใน Stream (แค่ผ่านค่ามาโดยไม่มีการแปลงอะไรเลย)
	การใช้ max() โดยไม่ได้ระบุ Comparator แบบนี้จะทำให้เกิดข้อผิดพลาดเช่นเดียวกับตัวเลือก C เพราะต้องการ Comparator ในการเปรียบเทียบ
	ผลลัพธ์: ตัวเลือกนี้จะทำให้เกิด ข้อผิดพลาดในการคอมไพล์ เช่นเดียวกับตัวเลือก C เนื่องจาก max() ต้องการ Comparator.
	
	สรุป:
	ตัวเลือก A คือคำตอบที่ถูกต้องที่สุด เพราะมันใช้ Comparator.comparing(a -> a) ซึ่งเปรียบเทียบค่าภายในลิสต์ และเลือกค่ามากที่สุดจากนั้น
	ตัวเลือก B, C, D จะทำให้เกิดข้อผิดพลาดเนื่องจากการใช้ max() โดยไม่มีการระบุ Comparator ที่เหมาะสม.
	คำตอบที่ถูกต้อง: A.
	 */
}
