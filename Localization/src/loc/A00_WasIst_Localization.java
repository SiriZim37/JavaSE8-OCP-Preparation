package loc;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class A00_WasIst_Localization {

	
	/*
	 *  Localization ใน Java OCP SE 8 "Localization" หรือ "การแปลภาษาท้องถิ่น" (Localization) 
	 *  หมายถึงการทำให้โปรแกรมสามารถทำงานและแสดงผลได้ตามภาษาหรือรูปแบบที่เหมาะสมกับผู้ใช้ในแต่ละพื้นที่ 
	 *  โดยเฉพาะในด้านของภาษา, รูปแบบตัวเลข, สกุลเงิน, วันที่, และเวลา 
	 *  การปรับให้เข้ากับท้องถิ่นนั้นจะช่วยให้ผู้ใช้จากต่างวัฒนธรรมสามารถเข้าใจข้อมูลและใช้งานโปรแกรมได้อย่างสะดวกและถูกต้อง
	 *  
	 *   สรุปขั้นตอนการทำ Localization ใน Java:
	 *   - สร้าง `Locale` ที่กำหนดภาษาและประเทศของผู้ใช้
	 *   - ใช้ `ResourceBundle` เพื่อโหลดข้อมูลที่แสดงผลตาม Locale
	 *   - ใช้ Formatter เช่น `DateFormat`, `NumberFormat` เพื่อแสดงวันที่และตัวเลขตามรูปแบบท้องถิ่น
	 *   
	 *   Localization เป็นหัวข้อสำคัญใน Java OCP SE 8 เพราะช่วยให้แอปพลิเคชันสามารถใช้งานได้หลายภาษาและเหมาะสมกับวัฒนธรรมต่างๆ
	 */

	
	public static void main(String[] args) {

		/* 
			 1. Locale Class:
			 `Locale` เป็นคลาสที่ใช้ระบุ "ประเทศ" และ "ภาษา" ของผู้ใช้ เช่น "th_TH" สำหรับภาษาไทยในประเทศไทย
			 สามารถสร้าง `Locale` โดยใช้คอนสตรัคเตอร์หรือค่าที่กำหนดไว้ เช่น `Locale.US`, `Locale.UK`
			 ตัวอย่าง:
		*/
		Locale thaiLocale = new Locale("th", "TH");

		System.out.println("\n---------------------------------------------------------------------------");
		/*
			 2. ResourceBundle:
			 `ResourceBundle` ใช้เก็บข้อความหรือข้อมูลที่แสดงผลตามภาษาของแต่ละท้องถิ่น
			 โดยจะมีไฟล์ properties สำหรับแต่ละ Locale เช่น `Messages_en_US.properties` หรือ `Messages_th_TH.properties`
			 ใช้ `ResourceBundle.getBundle()` เพื่อโหลดข้อมูลตาม Locale ที่กำหนด
		 */
		ResourceBundle bundle = ResourceBundle.getBundle("Messages", thaiLocale);
		String greeting = bundle.getString("greeting");

		System.out.println("\n---------------------------------------------------------------------------");
		/* 
		  	 3. Date and Time Formatting:
			 Java มีคลาส `DateFormat` และ `SimpleDateFormat` สำหรับจัดรูปแบบวันที่และเวลาให้ตรงกับ Locale
			 ใช้ `DateFormat.getDateInstance()` เพื่อสร้างฟอร์แมตตาม `Locale`
		 */

		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, thaiLocale);
		System.out.println(dateFormat.format(new Date()));

		System.out.println("\n---------------------------------------------------------------------------");
		/* 
		  	 4. Number and Currency Formatting:
			 ใช้คลาส `NumberFormat` เพื่อจัดรูปแบบตัวเลขและสกุลเงินตาม Locale ที่กำหนด
			 `NumberFormat.getCurrencyInstance(locale)` ใช้สำหรับการแสดงผลสกุลเงิน เช่น "฿" สำหรับสกุลบาทของไทย
		 */
		 
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(thaiLocale);
		System.out.println(currencyFormat.format(12345.67));

		System.out.println("\n---------------------------------------------------------------------------");

		
		

		
	}
}
