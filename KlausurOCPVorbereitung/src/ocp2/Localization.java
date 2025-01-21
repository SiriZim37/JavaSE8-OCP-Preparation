package ocp2;

public class Localization {

	/*
	  QUESTION 62
		 Which two code blocks correctly initialize a Locale variable? (Choose two.)
		 A. Locale loc1 = "UK";
		 B. Locale loc2 = Locale.getInstance("ru");
		 C. Locale loc3 = Locale.getLocaleFactory("RU");
		 D. Locale loc4 = Locale.UK;
		 E. Locale loc5 = new Locale ("ru", "RU");

	 */
	
	public static void main(String[] args) {
		
		
		/*
		A. Locale loc1 = "UK";
		ไม่ถูกต้อง. ไม่สามารถกำหนดค่า Locale ด้วยการใช้สตริงโดยตรงได้ วิธีที่ถูกต้องในการสร้างอ็อบเจ็กต์ Locale 
		คือการใช้ตัวสร้างหรือเมธอดสถิติเช่น Locale.getInstance() หรือ new Locale() ไม่ใช่การใช้สตริงโดยตรงแบบนี้
		
		B. Locale loc2 = Locale.getInstance("ru");
		ไม่ถูกต้อง. ไม่มีเมธอด Locale.getInstance() ที่รับสตริงแบบนี้ เมธอดที่ถูกต้องคือ Locale.forLanguageTag(String)
		(ใน Java 7 ขึ้นไป) หรือการใช้ตัวสร้าง Locale ไม่ใช่ getInstance() แบบนี้
		
		C. Locale loc3 = Locale.getLocaleFactory("RU");
		ไม่ถูกต้อง. ไม่มีเมธอด Locale.getLocaleFactory() ในคลาส Locale การใช้เมธอดนี้จึงไม่ถูกต้อง
		
		D. Locale loc4 = Locale.UK;
		ไม่ถูกต้อง. ถึงแม้ว่า Locale.UK จะเป็นค่าคงที่ที่กำหนดไว้ในคลาส Locale แต่ไม่ได้เป็นวิธีการทั่วไปในการกำหนดค่า Locale อ็อบเจ็กต์ 
		นี้ใช้ได้ในกรณีที่ต้องการเฉพาะ Locale.UK เท่านั้น แต่ไม่เหมาะสมในการกำหนดค่า Locale โดยทั่วไป
		
		E. Locale loc5 = new Locale("ru", "RU");
		ถูกต้อง. การใช้ตัวสร้าง Locale ด้วย new Locale(String language, String country) 
		เป็นวิธีที่ถูกต้องในการสร้างอ็อบเจ็กต์ Locale โดย "ru" แทนภาษารัสเซีย และ "RU" แทนประเทศรัสเซีย การกำหนดค่าด้วยวิธีนี้ถูกต้อง
		
		
		คำตอบที่ถูกต้อง:
		E. Locale loc5 = new Locale ("ru", "RU");
		D. Locale loc4 = Locale.UK; (ถึงแม้ว่าจะเป็นค่าคงที่ที่กำหนดไว้ในคลาส แต่ยังคงสามารถใช้ในการกำหนดค่า Locale ได้)
	
	*/
	}
	
}
