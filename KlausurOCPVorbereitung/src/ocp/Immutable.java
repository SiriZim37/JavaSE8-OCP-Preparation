package ocp;

public class Immutable {

	public static void main(String[] args) {

		/*
		 * Which steps must be included when creating an immutable class? (Choose all that apply.)
		 * 
		 * A. The class must be marked private.
		 * B. All static and instance variables must be private and final. 
		 * C. All setter methods must be marked private.
		 * D. Any getter methods that return references to mutable objects must return references to copies.
		 * E. Any constructors that take references to mutable objects must make copies of the objects sent.
		 * 
		 * 
		 * 
		 * B, D, and E are correct statements.
		 * A is incorrect. Immutable classes must be marked final.
		 * C is incorrect. Immutable classes cannot contain setter methods.
		 */


		/*
		 * ขั้นตอนที่จำเป็นในการสร้าง Immutable Class:
		 * 
		 * A. คลาสต้องถูกกำหนดเป็น private: 
		 * ข้อนี้ไม่ถูกต้อง เพราะคลาสที่ไม่สามารถเปลี่ยนแปลงได้ต้องเป็น final เพื่อป้องกันไม่ให้คลาสถูกสืบทอด (subclass) โดยไม่ใช่ private
		 * 
		 * B. ตัวแปร static และ instance ต้องเป็น private และ final:
		 * ข้อนี้ถูกต้อง เพราะตัวแปรต้องเป็น private เพื่อไม่ให้สามารถเข้าถึงจากภายนอก และต้องเป็น final เพื่อไม่ให้สามารถเปลี่ยนแปลงค่าของตัวแปรได้หลังจากสร้างอ็อบเจ็กต์
		 * 
		 * C. เมธอด setter ต้องเป็น private:
		 * ข้อนี้ไม่ถูกต้อง เพราะคลาสที่ไม่สามารถเปลี่ยนแปลงได้ไม่ควรมีเมธอด setter เลย เนื่องจากไม่ควรอนุญาตให้มีการเปลี่ยนแปลงค่าของตัวแปร
		 * 
		 * D. เมธอด getter ที่คืนค่าอ้างอิงถึงอ็อบเจ็กต์ที่สามารถเปลี่ยนแปลงได้ (mutable) ต้องคืนสำเนาของอ็อบเจ็กต์:
		 * ข้อนี้ถูกต้อง เพราะเมื่อมีการเก็บข้อมูลที่เป็นอ็อบเจ็กต์ที่สามารถเปลี่ยนแปลงได้ เช่น ArrayList, Date เป็นต้น เมธอด getter ต้องคืนค่าของสำเนาอ็อบเจ็กต์ ไม่ใช่การอ้างอิงถึงอ็อบเจ็กต์ต้นฉบับ
		 * 
		 * E. คอนสตรัคเตอร์ที่รับอ้างอิงถึงอ็อบเจ็กต์ที่สามารถเปลี่ยนแปลงได้ต้องทำการสร้างสำเนาของอ็อบเจ็กต์ที่ส่งมา:
		 * ข้อนี้ถูกต้อง เพราะเมื่อคอนสตรัคเตอร์รับอ็อบเจ็กต์ที่สามารถเปลี่ยนแปลงได้เป็นพารามิเตอร์ ควรทำการสร้างสำเนาของอ็อบเจ็กต์นั้นๆ เพื่อป้องกันการเปลี่ยนแปลงค่าภายนอกหลังจากที่อ็อบเจ็กต์ถูกสร้าง
		 */
		
	}

}
