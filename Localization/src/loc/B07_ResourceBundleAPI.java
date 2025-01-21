package loc;

import java.util.Locale;
import java.util.ResourceBundle;

public class B07_ResourceBundleAPI {

	public static void main(String[] args) {
		

		String basename = "loc.res.app";
		
		/*
		 * static final ResourceBundle getBundle(String baseName)
		 * 
		 * Sammelt die Resouren fürs default-Locale
		 * 
		 * เมธอดนี้ใช้ในการดึง ResourceBundle สำหรับค่า default-locale (ค่าเริ่มต้นของระบบ)
		 * โดยในกรณีนี้จะดึงข้อมูลจากไฟล์ 'app.properties' หรือ 'app_<locale>.properties'
		 * ตามค่าภาษาที่ตั้งไว้เป็นค่าเริ่มต้นในระบบ
		 * 
		 * 		
		 * Exam : wenn diese  Methode verwendet wird , kann man default-Locale ignorieren
		 * 		  (in der Praxis ist es komplizierten)
		 */
		 
		
		ResourceBundle bundle1 = ResourceBundle.getBundle(basename);
		
		//----------------------------------------------------------------------------------
		/*
		 *  static final ResourceBundle getBundle(String baseName, Locale locale)                  
		 *  
		 *  Sammelt die Resourcen fürs das spezielle Locale
		 * เมธอดนี้ใช้ในการดึง ResourceBundle สำหรับภาษาหรือท้องถิ่น (locale) ที่ระบุไว้
		 * ในตัวอย่างนี้ loc ถูกตั้งเป็น Locale.ITALY ทำให้ดึงข้อมูลจากไฟล์ 'app_it.properties'
		 * หากมีไฟล์ดังกล่าว
		 */
		
		Locale loc = Locale.ITALY;
		ResourceBundle bundle2 = ResourceBundle.getBundle(basename, loc); 
		
		//----------------------------------------------------------------------------------
		/*
		 * String getString(String key)
		 */
		String s1 = bundle1.getString("greeting"); 	// ดึงข้อความ "greeting" จากค่า default-locale
		String s2 = bundle2.getString("greeting"); 	// ดึงข้อความ "greeting" จาก locale อิตาลี
		System.out.println("s1 : " + s1 ); 			// แสดงข้อความสำหรับค่า default-locale
		System.out.println("s2 : " + s2 ); 			// แสดงข้อความสำหรับ locale อิตาลี
	

		
		/*
		 * ถ้าไม่มีไฟล์ 'app_it.properties' (สำหรับ locale ภาษาอิตาลี):
		 * 
		 * เมธอด `ResourceBundle.getBundle(basename, loc)` จะพยายามหาฟังชั่นอื่นๆ ที่รองรับภาษาและท้องถิ่นที่ระบุ
		 * ในกรณีนี้ ถ้าไม่มีไฟล์สำหรับ locale ภาษาอิตาลี ('app_it.properties')
		 * โปรแกรมจะใช้ไฟล์ค่าเริ่มต้นที่ชื่อว่า 'app.properties' แทน (ซึ่งรองรับ locale เริ่มต้น)
		 * 
		 * แต่ถ้าไม่มีไฟล์ใดๆ เลยสำหรับ locale ที่ระบุ โปรแกรมจะโยน `MissingResourceException`
		 * ซึ่งเป็นข้อผิดพลาดที่บอกว่าไม่พบไฟล์แหล่งข้อมูลที่เหมาะสม
		 */
		
		//----------------------------------------------------------------------------------
		
		/*
		 * final Object getObject(String key) 
		 */
		Object s10 = bundle1.getObject("greeting");
		Object s20 = bundle2.getObject("greeting");
		
		System.out.println("s10 : " + s10 ); 			
		System.out.println("s20 : " + s20 ); 
		
		/*
		 * Exam
		 */
//		String s33 = bundle1.getObject("greeting");		// cf : String <- IST-Kein <- Object
//		Object s44 = bundle2.getObject(22);				// cf : braucht String als Argument
	}
}
