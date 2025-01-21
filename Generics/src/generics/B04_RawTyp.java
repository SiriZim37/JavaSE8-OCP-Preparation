package generics;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

public class B04_RawTyp {

	public static void main(String[] args) {
		/*
		 * Bitte niemals mit Raw Type programmieren! 
		 * 
		 * Raw Types: การใช้ Raw Type จะทำให้ไม่มีความปลอดภัยในประเภทข้อมูล เพราะคุณอาจเพิ่มข้อมูลประเภทที่ไม่ถูกต้อง ซึ่งจะส่งผลให้เกิดข้อผิดพลาดในการทำงานของโปรแกรมในระยะหลัง
		 */
		
		
		/*
		 * การเพิ่มข้อมูล: ต้องใช้ประเภทข้อมูลที่ถูกต้องตามที่กำหนดไว้ใน Deque หรือ Collection
		 */
		Deque<Long> dequeLong = new ArrayDeque<Long>();
		dequeLong.add(12L);
//		deuLong.add(12.0);   // บรรทัดนี้จะมีข้อผิดพลาดในการคอมไพล์ เนื่องจาก 12.0 เป็น Double
		
		Collection<Long> collLong = dequeLong;  // สร้าง Collection ที่เก็บ Long โดยอิงจาก dequeLong
		collLong.add(13L);
//		collLong.add(13.0);   // บรรทัดนี้จะมีข้อผิดพลาดในการคอมไพล์ เนื่องจาก 13.0 เป็น Double
		
		/*
		 * การกำหนดประเภท: การกำหนดค่าระหว่าง Deque<Long> และ Deque<Number> จะต้องระวัง เนื่องจาก Java Generics ไม่รองรับการทำงานแบบนั้น
		 */
		Deque<Number> deqNum = new LinkedList<>(); // สร้าง Deque ที่เก็บ Number
		// deqNum = dequeLong; // บรรทัดนี้จะมีข้อผิดพลาดในการคอมไพล์ เพราะ dequeLong เป็น Deque<Long> ไม่สามารถกำหนดให้กับ Deque<Number> ได้
		deqNum.add(12L);
		deqNum.add(12);
		deqNum.add(12.0);
		deqNum.add(12.0f);
		
		/*
		 * Keine Typsicherheit mit RawTyp
		 * ไม่มีความปลอดภัยของประเภทกับ Raw Type
		 */
		
		Collection coll; 			// ประกาศ Collection แบบ raw (ไม่มีพารามิเตอร์ประเภท)
		
		coll = dequeLong; 			// กำหนดค่า Deque<Long> ให้กับ Collection แบบ raw
		coll.add("moin"); 			// เพิ่ม String (บรรทัดนี้ไม่มีการตรวจสอบประเภท จึงทำให้สามารถเพิ่มได้)
		coll.add(false);   			// เพิ่ม Boolean (บรรทัดนี้จะไม่มีการตรวจสอบประเภทเช่นเดียวกัน)
		
		System.out.println(dequeLong);	// [12, 13, moin, false]
		
		coll = deqNum;
		coll.add("jan"); 			// เพิ่ม String (บรรทัดนี้ไม่มีการตรวจสอบประเภท จึงทำให้สามารถเพิ่มได้)
		coll.add(LocalDate.now()); 	// เพิ่ม LocalDate (บรรทัดนี้จะไม่มีการตรวจสอบประเภทเช่นเดียวกัน)

		System.out.println(deqNum);  // [12, 12, 12.0, 12.0, jan, 2024-10-11]
		
		/*
			 ข้อดีของ Raw Type:
			 - สามารถเพิ่มข้อมูลประเภทใด ๆ ได้ แม้ว่าอาจจะทำให้เกิดปัญหาตอนนำข้อมูลออกมาใช้งาน
			 
			 ข้อเสียของ Raw Type:
			 - การใช้ Raw Type จะทำให้สูญเสียความปลอดภัยของประเภท (Type Safety)
			 - อาจทำให้เกิดข้อผิดพลาดขณะทำงาน (Runtime Error) หากมีการใช้ข้อมูลประเภทที่ไม่เข้ากัน
	
			 ควรใช้ Generics เสมอเพื่อรักษาความปลอดภัยของประเภท:
			 เช่น การประกาศเป็น Collection<Long> จะช่วยให้เราสามารถเพิ่ม Long เท่านั้น
			
				Collection<Long> coll; // ประกาศ Collection โดยระบุประเภทเป็น Long
				coll = dequeLong; // กำหนดค่า Deque<Long> ให้กับ Collection<Long>
				coll.add(12L); // เพิ่ม Long 12
			
			 หากพยายามเพิ่มข้อมูลประเภทอื่น เช่น String หรือ Boolean จะเกิดข้อผิดพลาดในการคอมไพล์
		 */
	}

}
