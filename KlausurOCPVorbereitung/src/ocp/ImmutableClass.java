package ocp;

public class ImmutableClass {

	public static void main(String[] args) {
		int n = new Integer(3);
		System.out.println(n);
	}
	/*
		1. Classes should be marked final:
		Preventing inheritance ensures the class structure cannot be modified unpredictably.
		คลาสควรเป็น final
		เพื่อป้องกันไม่ให้คลาสถูกสืบทอด (subclassed) ทำให้โครงสร้างของคลาสคงที่และไม่มีการเปลี่ยนแปลงที่ไม่คาดคิด
		
		2.Immutable classes can use constructors or factory methods:
		Factory methods offer additional flexibility (e.g., caching, object pooling). Constructors are the basic mechanism for creating objects.
		การใช้ Constructor
		คลาส Immutable สามารถสร้างวัตถุได้ผ่าน Constructor หรือ Factory Method
		วิธีนี้ช่วยให้ควบคุมการสร้างวัตถุได้อย่างปลอดภัย

		3.Fields can be mutable but must be handled defensively:
		If a field holds a mutable type, using defensive copying or wrapping ensures immutability by preventing unintended modifications.
		ฟิลด์ที่เป็นชนิด Mutable
		ถึงแม้ฟิลด์จะเป็นชนิด Mutable (เช่น List, Map) แต่ต้องจัดการฟิลด์เหล่านี้ด้วยการคัดลอกข้อมูล (Defensive Copy) เพื่อหลีกเลี่ยงการเปลี่ยนแปลงจากภายนอก

		4.Reference variables passed into the constructor must be handled defensively:
		Defensive copying ensures that any mutable arguments don't affect the internal state of the object.
		การจัดการ Reference Variable ที่ส่งเข้ามาใน Constructor
		หากมีการรับอาร์กิวเมนต์ที่เป็น Reference Variable ควรทำการป้องกันด้วยการคัดลอกข้อมูลก่อนเก็บไว้ในฟิลด์

		5.Reference variables returned from getters must be handled defensively:
		Returning a copy prevents external code from modifying the internal state.
		การจัดการ Reference Variable ที่ส่งออกไปผ่าน Getter
		หากมี Getter ที่ส่งคืน Reference Variable ควรส่งคืนสำเนา (Copy) แทนการส่งคืนออบเจกต์ต้นฉบับ เพื่อป้องกันการแก้ไขจากภายนอก

		6.Properly designed immutable classes are well-encapsulated:
		Encapsulation ensures fields are private and accessible only via controlled methods, maintaining immutability.
		การห่อหุ้ม (Encapsulation)
		คลาส Immutable ที่ออกแบบอย่างเหมาะสมจะมีการห่อหุ้มข้อมูลที่ดี (Well-encapsulated) ทำให้วัตถุมีความปลอดภัยและไม่เปลี่ยนแปลง
	 */
	

}
