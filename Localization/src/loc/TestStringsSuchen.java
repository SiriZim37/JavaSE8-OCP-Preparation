package loc;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class TestStringsSuchen {

	// loc.res.labels ที่จะใช้ในการค้นหาไฟล์ properties หรือ class ในแพ็กเกจ loc.res เพื่อดึงข้อความตาม Locale ที่กำหนด
	
	private static final String baseName = "loc.res.labels";  
	
	public static void main(String[] args) {
		
		suche("nichtda");
		/*
		 * suche("nichtda") จะไม่พบค่าในทุกไฟล์ และจะเกิด MissingResourceException
		 * 
		 */
		
		//-------------------------------------------------------------------------------------
		suche("cancel");
		/*
		 * คีย์ "cancel" จะถูกค้นหาในไฟล์ labels_de_DE.properties ก่อน (เนื่องจาก locale เป็น de_DE)
		 * ใน labels_de_DE.properties จะพบค่า cancel = ABBREACHEN
		 */
		
		//-------------------------------------------------------------------------------------
		
		suche("help");
		/*
		 * ระบบจะค้นหาค่าจาก labels_de.java ซึ่งเป็น ListResourceBundle ที่มีคีย์ 'help' และค่าของคีย์นั้นคือ "Hilfe".
		 * หากพบคีย์ใน labels_de.java จะคืนค่าของคีย์ 'help' ซึ่งในที่นี้คือ "Hilfe".
		 * ระบบจะหยุดการค้นหาทันทีหลังจากพบค่าจาก labels_de.java.
		 */
		//-------------------------------------------------------------------------------------
		
		suche("greeting");	 	// ERROR! Can't find resource for bundle loc.res.labels, key greeting
		/*
		 * ระบบจะไม่ค้นหาเพิ่มเติมในไฟล์ .properties หลังจากพบ ListResourceBundle ที่ตรงกับ locale แล้ว
		 * ดังนั้นในกรณีนี้ เมื่อระบบพบ labels_de.java ซึ่งเป็น ListResourceBundle แต่ไม่พบคีย์ "greeting"
		 * ระบบจะหยุดการค้นหาทันทีและไม่ไปค้นหาต่อใน labels_de.properties หรือไฟล์อื่น ๆ
		 * ค้นหา labels_de_DE.java → ไม่มีไฟล์นี้
		 * ค้นหา labels_de_DE.properties → พบไฟล์นี้แต่ไม่มีคีย์ "greeting"
		 * ค้นหา labels_de.java → พบไฟล์นี้และเป็น ListResourceBundle แต่ไม่พบคีย์ "greeting"
		 * ระบบจึงหยุดการค้นหาทันที และเกิด MissingResourceException
		 */

		//-------------------------------------------------------------------------------------
		
		suche("edit");
		/*
		 * เมื่อเรียกใช้ 'edit', ระบบจะค้นหาจาก labels.java
		 * ค่าที่พบจะเป็น "Edit"
		 */
		
		suche("search"); // Value: Search

		/*
		 * เมื่อเรียกค้นหาคีย์ "search" ระบบจะค้นหาจาก ResourceBundle ตามลำดับ:
		 * 1. ค้นหาใน labels_de_DE.properties → ไม่มีคีย์ "search"
		 * 2. ค้นหาใน labels_de.java → ไม่มีคีย์ "search"
		 * 3. ค้นหาใน labels.java → พบคีย์ "search" และค่าเป็น "Search"
		 * ระบบจะพบคีย์ "search" ใน labels.java ซึ่งเป็นไฟล์ ListResourceBundle และจะคืนค่าเป็น "Search"
		 * ดังนั้นค่าที่ได้จะเป็น "Search"
		 * เพราะฉะนั้นระบบจะใช้ค่าใน labels.java เป็นค่า "search" และแสดงผลลัพธ์ "Search"
		 */
	}
	
	/*
	 * 	Locale : de_DE
	 *  
	 *  Kandidaten : 
	 *  		
	 *  
	 *  		loc.res.labels_de_DE			.class oder properties
	 *  		
	 *  				loc.res.labels_de_DE.class gibt es nicht , aber 
	 *  				loc.res.labels_de_DE.properties gibt es!  (gehört zum Bundle)
	 *  				
	 *  				>>> ไฟล์ loc.res.labels_de_DE.properties มีอยู่ ซึ่งจะถูกใช้ใน ResourceBundle 
	 *  					สำหรับ Locale de_DE เพื่อดึงข้อมูลหรือข้อความที่แปลเป็นภาษาเยอรมัน (เยอรมนี)
	 *  
	 *  
	 *  		loc.res.labels_de				.class oder properties
	 *  
	 *  				loc.res.labels_de.class gibt es (gehört zum Bundle)
	 * 					und
	 * 					loc.res.labels_de.properties gibt es auch, 
	 *            	  	aber sie wird NICHT zu dem Bundle gehören
	 *            
	 *           		>>> ลำดับการค้นหาของ ResourceBundle
	 *           		เมื่อเรียกใช้ ResourceBundle.getBundle(baseName, locale); ระบบจะค้นหาไฟล์ตามลำดับดังนี้:
	 *          		1. ค้นหา ListResourceBundle ที่ตรงกับ locale ก่อน
	 *          		2. หากไม่เจอ ListResourceBundle ที่ตรงกับ locale จะค้นหา .properties ไฟล์แทน
	 *          
	 * 			       	ResourceBundle เมื่อระบบพบไฟล์ ListResourceBundle ที่ตรงกับ locale ที่ตั้งไว้ 
	 * 					ระบบจะถือว่าเจอทรัพยากร (resource) สำหรับ locale นั้นแล้ว และจะ "หยุดการค้นหาทันที" ไม่ว่าจะมีคีย์ที่ต้องการอยู่ในไฟล์นั้นหรือไม่ก็ตาม
	 * 					
	 * 					
	 * 
	 *  		loc.res.labels					.class oder properties
	 *  				
	 *  				loc.res.labels_de_DE.class gibt es.  (gehört zum Bundle)
	 *  				loc.res.labels_de_DE.properties gibt es
	 *  
	 * 
	 * ถ้าไฟล์ labels_de_DE.properties หรือ labels_de_DE.class มีคีย์ "edit", ค่าที่เกี่ยวข้องจะถูกดึงออกมาและแสดง.
หากไม่พบคีย์ "edit" ในไฟล์ที่ตรงกับ de_DE, โปรแกรมจะพยายามใช้ไฟล์ labels_de.properties (หากมี) หรือไฟล์ที่ตรงกับชื่อไฟล์ที่ใช้เป็นฐาน.
	 */
	static void suche(String property) {
		System.out.println("\n***");
													 	 // ตั้งค่า default locale ให้เป็นภาษาเยอรมัน (Germany)
		Locale.setDefault(Locale.GERMANY);   //	de_DE 	 // damit auf einem anderen Rechner die Ergebnisse 
		
		Locale locale = Locale.getDefault();
		System.out.println("locale: " + locale);  	 	// ดึงค่า locale ปัจจุบัน แสดงค่า locale ที่ตั้งไว้ (ในที่นี้จะเป็น de_DE)
		
		
		System.out.println("Name: " + property);	
		
		ResourceBundle bundle = ResourceBundle.getBundle(baseName , locale);	// โหลด ResourceBundle ด้วยชื่อฐานและ locale ที่ตั้งไว้
		

		try {
			String result = bundle.getString(property);	  // ดึงค่าจาก ResourceBundle โดยใช้ชื่อ property
			System.out.println("Value: " + result);
			
		} catch (MissingResourceException e) {
			System.out.println("ERROR! " + e.getMessage());
		}
	
		
	}
}


