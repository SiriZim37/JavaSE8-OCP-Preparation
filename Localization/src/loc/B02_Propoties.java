package loc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Properties;

public class B02_Propoties {

	/*
	 *  ใน Localization ของ Java Properties คือไฟล์ที่เก็บข้อมูลแบบข้อความในรูปแบบคู่คีย์-ค่า (Key-Value)
	 *  ซึ่งสามารถใช้ในการแปลข้อความของแอปพลิเคชันให้เป็นภาษาท้องถิ่นต่างๆ โดยไม่ต้องเปลี่ยนโค้ดหลักของโปรแกรม 
	 *  ตัวอย่างเช่น การแสดงข้อความที่แตกต่างกันตาม Locale ที่ผู้ใช้กำหนด
	 */
	
	/*
	 * - Properties sind Konfigurationen für ein Programm.
	 * 
	 * z.B. wenn ein Programm übers Netzwerk von einem Server Daten 
	 * holen soll, kann die Server-IP-Adresse eine Property sein.
	 * 
	 * - Klasse java.util.Properties: Klasse zum Speichern/Laden der 
	 *   Konfigurationen
	 *   
	 * - Datei 'name.properties': Datei mit Properties
	 * 
	 */
	
	/*
	 * Properties sind Konfigurationen für ein Programm.
	 * 
	 * z.B. wenn ein Programm übers Netzwerk von einem Server Daten
	 * holen soll, kann die Server-IP-Address eine Property sein
	 * 
	 * - Klasse java.util.Properties: Klasse zum Speichern/Laden der 
	 *   Konfigurationen
	 *   
	 * - Datei 'name.properties': Datei mit Properties
	 * 
	 * 
	 * Properties เป็นวิธีการเก็บค่าคอนฟิกูเรชัน (Configuration) 
	 * สำหรับโปรแกรม ซึ่งสามารถใช้ในการตั้งค่าต่างๆ ที่โปรแกรมสามารถใช้ได้ในระหว่างการทำงาน 
	 * โดยค่าพวกนี้มักจะถูกเก็บในไฟล์ที่มีรูปแบบเป็นคู่อักษร (Key-Value Pair) เช่นเดียวกับไฟล์ .properties
	 * 
	 * ข้อดีของการใช้ Properties:
	 * 1. ความยืดหยุ่น: สามารถเปลี่ยนแปลงค่าคอนฟิกูเรชันได้โดยไม่ต้องแก้ไขโค้ด
	 * 2. การจัดการง่าย: เมื่อโปรแกรมต้องการค่าที่เปลี่ยนแปลงบ่อยๆ เช่น URL ของเซิร์ฟเวอร์, การตั้งค่าการเชื่อมต่อ, หรือข้อมูลความปลอดภัย
	 * 3. แยกข้อมูลจากโค้ด: ทำให้โปรแกรมสามารถปรับใช้ค่าคอนฟิกูเรชันต่างๆ ได้โดยไม่ต้องพึ่งโค้ดหลัก
	 * 
	 */
	

	public static void main(String[] args) {

//		String serverIP = "192.168.1.1";
//		System.out.println("server-ip :" + serverIP);
		
		
		Properties props = new Properties();
		
		try(Reader in = new FileReader("myapp-proproties")){
			
			props.load(in);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		
		/*
		 * Statt die Server-IP hartkodiert zu haben, 
		 * wird sie als Property 'Server-ip' gelanden
		 */
		String serverIP = props.getProperty("server-ip");
		String serverPort = props.getProperty("server-port");

		
		System.out.println("Server IP: " + serverIP);
        System.out.println("Server Port: " + serverPort);
    
        // Nicht Relevant in der Prüfung 
        System.out.println("my.multiline.prop: " + props.getProperty("my.multiline.prop"));
        System.out.println("My.path: " + props.getProperty("my.path"));
        System.out.println("x1: " + props.getProperty("x1"));
        System.out.println("x2: " + props.getProperty("x2"));
        System.out.println("x3: " + props.getProperty("x3"));
      
        
        /*
         * Speizielle geht auch
         */
        
//		try(Writer out = new FileWriter("myapp-test.properties", Charset.forName("UTF-8"))) {
//			props.setProperty("my.key", "my value");
//			props.setProperty("my.path", "C:\\Dir\\File"); // es wird speziell gespeichert (s. die Datei)
//			
//			props.store(out, "my comment");
//		} catch (IOException e) {
//			throw new UncheckedIOException(e);
//		}
       
	}

}
