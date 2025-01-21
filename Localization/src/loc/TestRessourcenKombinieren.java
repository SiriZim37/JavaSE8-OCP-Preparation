package loc;

import java.util.Locale;
import java.util.ResourceBundle;


public class TestRessourcenKombinieren {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}
	/*
	 * verwendetes Locale = default-Locale = de_DE
	 * 
	 * Kandidaten-Namen (natürlich auch Präfix loc.res und Suffix .properties):
	 * 
	 * 		days_de_DE 		- Datei existiert nicht
	 * 		days_de   		- Datei existiert nicht
	 * 		days
	 * ในโค้ดนี้ เมื่อ Locale.setDefault(Locale.ITALY) จะไม่ส่งผลกระทบเพราะใน
	 * ResourceBundle.getBundle() เรากำหนด Locale.GERMANY (เยอรมัน)
	 * 
	 * หากไม่มีไฟล์ที่ตรงกับ Locale.GERMANY, โปรแกรมจะใช้ days.properties ที่เป็นไฟล์ค่าเริ่มต้น
	 */
	
	static void test5() {
		System.out.println("\n*** test 5");
		
		Locale.setDefault(Locale.ITALY); // it_IT	
		System.out.println(Locale.getDefault());
		
		String baseName = "loc.res.days";
		ResourceBundle bundle2 = ResourceBundle.getBundle(baseName , Locale.GERMANY);
		
		String first = bundle2.getString("first"); // aus days.properties
		System.out.println("first: " + first);
		
		System.out.println("----------------------------------------------------------------");
	}
	

	/*
	 * verwendetes Locale = default-Locale = de_DE
	 * 
	 * Kandidaten-Namen (natürlich auch Präfix loc.res und Suffix .properties):
	 * 
	 * 		days_de_DE 		- Datei existiert nicht
	 * 		days_de   		- Datei existiert nicht
	 * 		days
	 * 	
	 * เนื่องจาก Locale.FRENCH ถูกตั้งค่าเป็นค่าเริ่มต้นด้วย Locale.setDefault(Locale.FRENCH);, 
	 * ถ้าโปรแกรมไม่พบไฟล์ที่เหมาะสมกับ Locale.GERMANY, มันจะไปดึงข้อมูลจากไฟล์ที่รองรับภาษาฝรั่งเศส 
	 * เช่น days_fr.properties ซึ่งอธิบายเหตุผลที่ข้อมูลถูกดึงมาจากไฟล์นี้
	 */
	
	static void test4() {
		System.out.println("\n*** test 4");
		
		Locale.setDefault(Locale.FRENCH);
		
		String baseName = "loc.res.days";
		ResourceBundle bundle2 = ResourceBundle.getBundle(baseName , Locale.GERMANY);
		
		String first = bundle2.getString("first"); // aus days_fr.properties
		System.out.println("first: " + first);
		
		System.out.println("----------------------------------------------------------------");
	}
	
	/*
	 * verwendetes Locale = default-Locale = fr
	 * 
	 * Kandidaten-Namen (natürlich auch Präfix loc.res und Suffix .properties):
	 * 
	 * 		days_fr    
	 * 		days
	 * 
	 * 	การทำงานของ ResourceBundle.getBundle() คือ:
	 *	1. หากคุณใช้ Locale.setDefault(Locale.FRENCH) โปรแกรมจะตั้งค่า locale เป็น fr (ภาษาฝรั่งเศสโดยทั่วไป (ไม่ระบุประเทศ)).
	 *	2. เมื่อเรียกใช้ ResourceBundle.getBundle(baseName), มันจะพยายามหาชื่อไฟล์ที่ตรงกับ baseName โดยพิจารณาจาก Locale ที่ตั้งไว้:
	 *		-โปรแกรมจะมองหาไฟล์ days_fr.properties ก่อน เพราะมันตรงกับ fr (ภาษาฝรั่งเศส(ไม่ระบุประเทศ)).
	 *		-หากไม่พบไฟล์ days_fr.properties, มันจะลองหาฟีล day.properties 
	 * 	3. ในกรณีนี้ โปรแกรมจะใช้ข้อมูลจาก days_fr.properties เพราะไฟล์นี้ตรงกับ Locale.FRENCH ที่ตั้งไว้.
	 */
	
	static void test3() {
		System.out.println("\n*** test 3");
		
		Locale.setDefault(Locale.FRENCH); // fr
		
		String baseName = "loc.res.days";
		ResourceBundle bundle2 = ResourceBundle.getBundle(baseName);
		
		String first = bundle2.getString("first"); // aus days_fr_FR.properties
		System.out.println("first: " + first);
		
		System.out.println("----------------------------------------------------------------");
	}


	/*
	 * verwendetes Locale = default-Locale = fr_FR
	 * 
	 * Kandidaten-Namen (natürlich auch Präfix loc.res und Suffix .properties):
	 * 
	 * 		days_fr_FR 
	 * 		days_fr    
	 * 		days
	 * 
	 *การทำงานของ ResourceBundle.getBundle()คือ:
	 *	1. หากคุณใช้ Locale.setDefault(Locale.FRANCE) โปรแกรมจะตั้งค่า locale เป็น fr_FR (ภาษาฝรั่งเศส สำหรับประเทศฝรั่งเศส).
	 *	2. เมื่อเรียกใช้ ResourceBundle.getBundle(baseName), มันจะพยายามหาชื่อไฟล์ที่ตรงกับ baseName โดยพิจารณาจาก Locale ที่ตั้งไว้:
	 *		-โปรแกรมจะมองหาไฟล์ days_fr_FR.properties ก่อน เพราะมันตรงกับ fr_FR (ภาษาฝรั่งเศสในประเทศฝรั่งเศส).
	 *		-หากไม่พบไฟล์ days_fr_FR.properties, มันจะลองหาฟีล days_fr.properties ที่ใช้ภาษาฝรั่งเศสทั่วไป (ไม่จำกัดแค่ประเทศฝรั่งเศส).
	 * 	3. ในกรณีนี้ โปรแกรมจะใช้ข้อมูลจาก days_fr_FR.properties เพราะไฟล์นี้ตรงกับ Locale.FRANCE ที่ตั้งไว้.
	 * 
	 */
	static void test2() {
		System.out.println("\n*** test 2");
		
		Locale.setDefault(Locale.FRANCE); // fr_FR
		
		String baseName = "loc.res.days";
		ResourceBundle bundle1 = ResourceBundle.getBundle(baseName);
		
		String first = bundle1.getString("first"); // aus days_fr_FR.properties
		System.out.println("first: " + first);
		
		String second = bundle1.getString("second"); // aus days_fr.properties 
		System.out.println("second: " + second);
		
		System.out.println("----------------------------------------------------------------");

	}
	
	/*
	 * verwendetes Locale = default-Locale = de_DE
	 * 
	 * Kandidaten-Namen (natürlich auch Präfix loc.res und Suffix .properties):
	 * 
	 * 		days_de_DE - existiert nicht
	 * 		days_de    - existiert nicht
	 * 		days
	 */
	static void test1() {
		System.out.println("*** test 1");
		Locale.setDefault(Locale.GERMANY);
		
		String baseName = "loc.res.days";

		ResourceBundle bundle = ResourceBundle.getBundle(baseName);
		
		String first = bundle.getString("first"); // aus days.properties
		System.out.println("first: " + first);
	
	}
}
