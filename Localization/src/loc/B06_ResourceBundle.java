package loc;

import java.util.ResourceBundle;



public class B06_ResourceBundle {

	/*
	 * Mit ResourceBundle wird eine Anwendung so programmiert , 
	 * dass man die Anwendung einfacher lokalisieren kann
	 */
	
	/*
	 * Localization (การแปล): 
	 * การใช้ ResourceBundle ในการพัฒนาโปรแกรมจะช่วยให้โปรแกรมสามารถปรับเปลี่ยน
	 * ตามภาษาหรือวัฒนธรรมของผู้ใช้งานได้ง่ายขึ้น โดย ResourceBundle จะทำให้การดึงข้อมูล
	 * ที่เป็นข้อความหรือข้อมูลเฉพาะของแต่ละท้องถิ่นง่ายขึ้น 
	 * โดยเราไม่จำเป็นต้องแก้ไขโค้ดหลัก แต่เพียงแค่สร้างไฟล์ ResourceBundle ที่มีการแปลข้อมูล
	 * ตามภาษาหรือวัฒนธรรมที่ต้องการเท่านั้น
	 *
	 * กล่าวคือ เมื่อใช้ ResourceBundle นักพัฒนาสามารถสร้างไฟล์ที่เก็บข้อมูล
	 * เช่น ข้อความหรือการตั้งค่าต่าง ๆ สำหรับแต่ละภาษาไว้ในไฟล์แยกต่างหาก 
	 * ซึ่งจะช่วยให้การแปลและการปรับโปรแกรมให้เข้ากับท้องถิ่น (Localization) 
	 * ง่ายและรวดเร็วยิ่งขึ้น
	 */

	public static void main(String[] args) {

		/*
		 * Ohne ResourceBundle: 
		 * กรณีที่ไม่ได้ใช้ ResourceBundle:
		 * ข้อความจะถูกกำหนดโดยตรงในโค้ด เช่น:
		 */
		String greeting = "Hello";   // กำหนดข้อความทักทายเป็นภาษาเยอรมันในโค้ดโดยตรง
		System.out.println(greeting);
		
		
		/*
		 * Mit ResourceBundle: 
		 * กรณีที่ใช้ ResourceBundle:
		 * ข้อความจะถูกเก็บไว้ในไฟล์ภายนอก เช่น 'app.properties' ซึ่งช่วยให้การแปลง่ายขึ้น
		 * 
		 * Vorteil :  Lokalisiern ist einfach
		 * * Vorteile (ข้อดีของการใช้ ResourceBundle):
		 * - การแปลเป็นภาษาต่าง ๆ (Localization) สามารถทำได้ง่ายขึ้น เนื่องจากไม่ต้องแก้ไขโค้ดหลัก
		 * - เพียงแค่สร้างไฟล์ properties สำหรับแต่ละภาษาเท่านั้น เช่น
		 *   - 'app.properties' สำหรับข้อความหลักที่ใช้หากไม่มีภาษาที่ระบุ
		 *   - 'app_de.properties' สำหรับภาษาเยอรมัน
		 *   
		 * การทำงานของ ResourceBundle:
		 * 1. ResourceBundle จะค้นหาไฟล์ properties ตามภาษาที่ตั้งไว้ในระบบหรือภาษาที่กำหนดในโค้ด
		 * 2. หากพบไฟล์ที่ตรงกับภาษาที่กำหนด เช่น 'app_de.properties' สำหรับภาษาเยอรมัน 
		 *    ก็จะใช้ไฟล์นั้นในการดึงข้อความ
		 * 3. ถ้าไม่พบภาษาที่ตรงกัน จะใช้ไฟล์หลัก 'app.properties' แทน
		 * 
		 * Die Datei 'app.properties' im Pakage 'loc.res' wurde erzeugt.
		 * Dort gibt es den String 'greeting'.
		 * Das ist die Lokalisierung für den Fall, dass keine speziellere 
		 * Lokalisierung gefunden werden konnte.
		 *  ไฟล์ 'app.properties' ในแพ็กเกจ 'loc.res' ได้ถูกสร้างขึ้นมา
		 * ซึ่งในไฟล์นี้จะมีสตริงที่ชื่อ 'greeting' สำหรับข้อความที่ใช้เป็นค่าเริ่มต้น
		 * ไฟล์นี้จะถูกใช้ในกรณีที่ไม่พบการแปลเฉพาะเจาะจงสำหรับภาษาที่กำหนด
		 * 
		 * 
		 * Deutsche Lokalisierung: 
		 * Die Datei 'app_de.properties' im Pakage 'loc.res' erzeugen.
		 * การแปลภาษาเยอรมัน:
		 * หากต้องการแสดงผลเป็นภาษาเยอรมัน ให้สร้างไฟล์ 'app_de.properties'
		 * ในแพ็กเกจ 'loc.res' ซึ่งในไฟล์นี้จะมีข้อความ 'greeting' เป็นภาษาเยอรมัน
		 * 
		 * 
		 * Wenn die System-Sprache 'de' ist ,  passt sich die Anwendung automatisch
		 * an und zeigt den Text in Deutsch.
		 * วิธีการทำงาน:
		 * หากภาษาที่ตั้งไว้ในระบบ (System-Sprache) คือ 'de' (ภาษาเยอรมัน)
		 * โปรแกรมจะดึงข้อความจากไฟล์ 'app_de.properties' โดยอัตโนมัติ 
		 * และแสดงข้อความเป็นภาษาเยอรมันให้กับผู้ใช้
		 */
		
		String baseName = "loc.res.app";
		ResourceBundle bundle = ResourceBundle.getBundle(baseName);
		
		greeting = bundle.getString("greeting");
		System.out.println(greeting);
		
	}




}
