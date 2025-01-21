package loc;

import java.util.Locale;
import java.util.ResourceBundle;

public class B09_RessourceBundle_Quellen {

	/*
	 * The method getBundle() can obtain resources from two main sources:
	 * 
	 *   - Java Classes (.class files)
	 *   - .properties files
	 * 
	 * getBundle() สามารถดึงข้อมูลจากสองแหล่งได้ดังนี้:
	 * 
	 * 1. **Java-Klassen (คลาส Java)**:
	 *    - getBundle() can retrieve information from compiled Java classes (i.e., .class files),
	 *      which store constants, methods, and other data that the program can use.
	 *    - เมธอด getBundle() สามารถดึงข้อมูลจากคลาส Java ที่ถูกคอมไพล์แล้ว (ไฟล์ .class) ซึ่งเก็บค่าคงที่ (constants) หรือเมธอดต่างๆ ที่โปรแกรมสามารถใช้งานได้.
	 * 
	 * 2. **.properties-Dateien (ไฟล์ .properties)**:
	 *    - Another source is .properties files, which are text files storing key-value pairs, 
	 *    	such as messages for localization or configuration settings.
	 *    - อีกแหล่งที่ getBundle() สามารถดึงข้อมูลมาได้คือไฟล์ .properties ซึ่งเป็นไฟล์ข้อความที่เก็บค่าต่างๆ เช่น ข้อความแปลภาษา หรือการตั้งค่าคอนฟิกต่างๆ.
	 * 
	 * ***************************************************************************************************************
	 * 
	 * **Exam Note **:
	 * 
	 * Exam: als Quelle werden in der Prüfung .java-Dateien
	 * 		 und .properties-Dateien als richtigen Quellen gesehen.
	 * 		 In Wirklichkeit wird natürlich die .java-Datei
	 * 		 zuerst kompliiert (die echte Quelle wird .class-Datei sein)
	 * 
	 * ในการสอบ, ไฟล์ .java และไฟล์ .properties ถูกมองว่าเป็นแหล่งข้อมูลที่ถูกต้องในการใช้กับ getBundle().
	 * ในความเป็นจริง, เมื่อคุณเขียนโปรแกรมใน Java, ไฟล์ .java จะถูกคอมไพล์เป็นไฟล์ .class, ซึ่งไฟล์ .class จะเป็นแหล่งข้อมูลที่โปรแกรมเรียกใช้จริง.
	 * 
	 * 
	 * 
	 * Exam 2:  1. wenn eine Java-Klasse die Ressource für RessourceBundle sein soll , 
	 * 				muss die Klasse von ListResourcen erben. 
	 * 				ถ้าคลาส Java ต้องการใช้เป็นแหล่งข้อมูลสำหรับ ResourceBundle,
	 * 				คลาสนั้นต้องสืบทอดมาจาก `ListResourceBundle`.
	 * 
	 * 		    2. wenn die Klasse von ListRessourcenBundle erbt, muss sie die Methode 
	 * 						Object[][] getCountents() 
	 * 		 	   überschreiben
	 * 			การสืบทอดจาก ListResourceBundle : 
	 *   		 - ถ้าคลาสนั้นสืบทอดมาจาก `ListResourceBundle`, มันจะต้องเขียนทับ (override) เมธอด:
	 *     		 		`Object[][] getContents()`
	 *   		 - เมธอดนี้จะใช้สำหรับให้ข้อมูลจริงๆ ของ resource bundle.
	 * 
	 * 1. 
	 */

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.GERMANY);	// de_DE
		
		String basename = "loc.res.MyString";
		
		ResourceBundle bundle = ResourceBundle.getBundle(basename);
		
		String topic = bundle.getString("topic");
		
		System.out.println("topic: " + topic);		// aus MyStrings_de_DE.java
		
	}
}
