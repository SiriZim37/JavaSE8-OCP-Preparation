package ocp2;

public class TheorieAboutsingleAbstractMethodOfInterfaceFunction {

	/*
	 Which statement is true about the single abstract method of the java.util.function.Function interface?
	 A. It accepts one argument and returns void.
	 B. It accepts one argument and returns boolean.
	 C. It accepts one argument and always produces a result of the same type as the argument.
	 D. It accepts an argument and produces a result of any data type.
	 */
	
	/*
	 อินเตอร์เฟซ Function ใน Java ใช้สำหรับการเปลี่ยนแปลงหรือแปลงข้อมูลจากประเภทหนึ่งไปยังอีกประเภทหนึ่ง โดยมีเมธอด apply() ซึ่งเป็นเมธอดเดียวที่ต้อง implement และมีลักษณะดังนี้:

		
		R apply(T t);
		T คือประเภทของอาร์กิวเมนต์ที่รับเข้า
		R คือประเภทของค่าที่คืนออกจากเมธอด
		ดังนั้น เมธอด apply() จะรับอาร์กิวเมนต์ประเภท T และคืนค่าผลลัพธ์เป็นประเภท R
		
		
		มาดูคำตอบที่เป็นไปได้:
		
		A. It accepts one argument and returns void.
		ไม่ถูกต้อง เพราะ Function อินเตอร์เฟซไม่ได้คืนค่า void โดยเมธอด apply() ของ Function จะคืนค่าเป็นประเภทที่กำหนด (R) ซึ่งไม่ใช่ void
		คำตอบนี้เหมาะสมกับอินเตอร์เฟซ Consumer ที่รับอาร์กิวเมนต์หนึ่งค่าและไม่คืนค่า (คืนค่า void)
		
		B. It accepts one argument and returns boolean.	
		ไม่ถูกต้อง เพราะ Predicate คืออินเตอร์เฟซที่รับอาร์กิวเมนต์หนึ่งค่าและคืนค่าเป็น boolean
		อินเตอร์เฟซ Function สามารถคืนค่าประเภทใดก็ได้ ไม่จำกัดแค่ boolean
		C. It accepts one argument and always produces a result of the same type as the argument.
		ไม่ถูกต้อง แม้ว่าคำตอบนี้ดูเหมือนจะเป็นคำตอบที่ใกล้เคียง แต่ไม่สมบูรณ์ 100% เพราะอินเตอร์เฟซ Function สามารถแปลงจากประเภทหนึ่งไปยังอีกประเภทหนึ่งได้ เช่น จาก String ไปเป็น Integer
		ดังนั้น ประเภทของค่าที่รับและคืนออกไม่จำเป็นต้องเหมือนกัน
		
		D. It accepts an argument and produces a result of any data type.
		ถูกต้อง: อินเตอร์เฟซ Function รับอาร์กิวเมนต์ประเภทหนึ่ง (T) และคืนค่าผลลัพธ์เป็นประเภทใดก็ได้ (R) ซึ่ง R สามารถเป็นประเภทใดก็ได้ที่แตกต่างจาก T

	 */
}
