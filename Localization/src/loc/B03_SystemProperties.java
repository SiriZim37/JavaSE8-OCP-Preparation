package loc;

import java.util.Properties;

public class B03_SystemProperties {

	/*
	 * System Properties ใน Java คือคุณสมบัติ (หรือ Configuration value) 
	 * ที่ระบบปฏิบัติการหรือ Java Virtual Machine (JVM) กำหนดไว้ล่วงหน้า 
	 * และโปรแกรมสามารถเข้าถึงและใช้งานได้ผ่านคลาส System ของ Java 
	 * โดยเฉพาะการใช้งาน System.getProperty() หรือ System.setProperty() 
	 * เพื่อดึงหรือกำหนดค่าต่างๆ ที่เกี่ยวข้องกับสภาพแวดล้อมของระบบ เช่น เวอร์ชันของ Java, โฟลเดอร์การทำงาน, ที่อยู่ของไฟล์, 
	 * หรือพารามิเตอร์ต่างๆ ที่เกี่ยวข้องกับการทำงานของ JVM
	 * 
	 * ตัวอย่างของ System Properties:
	 * - user.name: ชื่อผู้ใช้ของระบบ
	 * - user.home: ที่อยู่ของโฟลเดอร์บ้าน (Home directory) ของผู้ใช้
	 * - java.version: เวอร์ชันของ Java ที่กำลังใช้งาน
	 * - os.name: ชื่อของระบบปฏิบัติการ
	 * - file.separator: ตัวคั่นไฟล์ (เช่น `/` หรือ `\` ขึ้นอยู่กับระบบปฏิบัติการ) 
	 * 
	 * 
	 * ข้อดีของ System Properties:
	 * - เข้าถึงข้อมูลระบบ: คุณสามารถดึงข้อมูลที่สำคัญเกี่ยวกับสภาพแวดล้อมการทำงาน เช่น โฟลเดอร์ของผู้ใช้, ระบบปฏิบัติการ, เวอร์ชันของ Java เป็นต้น
	 * - การตั้งค่าทั่วไปของระบบ: สามารถใช้สำหรับการกำหนดค่าทั่วไปที่โปรแกรมจะใช้งานตลอดเวลา เช่น การตั้งค่าตัวแปรสภาพแวดล้อม
	 * - รองรับการปรับเปลี่ยน: สามารถใช้ปรับแต่งพฤติกรรมของโปรแกรมตามลักษณะของเครื่องหรือผู้ใช้ที่ใช้งาน
	 * 
	 * สรุป:
	 * System Properties คือค่าคอนฟิกูเรชันที่ Java หรือระบบปฏิบัติการกำหนดให้ และสามารถใช้ในโปรแกรม Java เพื่อดึงข้อมูลหรือกำหนดค่าต่างๆ 
	 * ที่เกี่ยวข้องกับสภาพแวดล้อมการทำงาน ทำให้โปรแกรมสามารถปรับตัวตามสภาพแวดล้อมที่แตกต่างกันได้
	 */

	public static void main(String[] args) {
		
		/*
		 * Alle System-Properties  การดึงข้อมูลทั้งหมดจาก System Properties
		 * 
		 */
		Properties props = System.getProperties();
		printProps(props); // show all 
		
		System.out.println("\n*****************************************************************************************");

		
		/* #1
		 * 
		 * Eine speizielle Property lernen การดึงค่าคุณสมบัติของระบบที่ระบุ
		 * 
		 * static String setProperty(String key, String value)
		 */
		String key = "java.io.tmpdir";
		String value =  System.getProperty(key);
		System.out.printf("%-10s = %s %n" , key , value);
		
		
		System.out.println("\n*****************************************************************************************");

		
		/* #2
		 * 
		 * Eigene Property speichen การตั้งค่าคุณสมบัติใหม่ในระบบ
		 * 
		 * static String setProperty(String key, String value)
		 */
		key = "my.prop";
		value = "my.value";
		System.setProperty(key , value);
		
		value =  System.getProperty(key);
		System.out.printf("%-10s = %s %n" , key , value);
		
		System.out.println("\n*****************************************************************************************");

		
		/*#3
		 * Eine Property lesen , falls es sie nicht gibt wird defaultValue zurück geliefert
		 * 
		 * การอ่านค่าคุณสมบัติในกรณีที่ไม่พบค่าจะส่งค่าดีฟอลต์ที่กำหนดไว้
		 */
		String myDay = System.getProperty("my.day" , "Freitag");
		System.out.println(myDay);
		
		System.out.println("\n*****************************************************************************************");

		
		/*
		 * ผู้ใช้สามารถกำหนดค่าคุณสมบัติของระบบเพิ่มเติมในขณะเริ่มต้นแอปพลิเคชัน
         * โดยการใช้ตัวเลือก -D ในการรันโปรแกรม:
         * 
		 * Der User kann beim Start der Anwendung zusätzliche
		 * Einträge für die System-Properties erstellen:
		 *   
		 *   		java -Dkey=value MyApp
		 *   
		 *  z.B.
		 *  
		 *   	java -Dserver-ip=192.168.1.12 MyApp
		 *   
		 *   Zum Testen unter Eclipse kann die Option --Dserver-ip=192.168.1.12 
		 *   in Menu Run->Run-Configurations im Tab 'Arguments' unter 'VM arguments' festgelegt werden 
		 */
		 /*
		  * In Run 			     : Ausgabe :  server-ip : 192.168.0.1
		  * In Run-Configuration : Ausgabe :  server-ip : 192.168.1.12
		  */
		
		String serverIP = System.getProperty("server-ip" , "192.168.0.1"); 
		
		System.out.println("server-ip : " + serverIP);
		
		
		System.out.println("\n*****************************************************************************************");

		String userName = System.getProperty("user.name");
	    String javaVersion = System.getProperty("java.version");
	    String osName = System.getProperty("os.name");
	        
	    System.out.println("User Name: " + userName);
	    System.out.println("Java Version: " + javaVersion);
	    System.out.println("OS Name: " + osName);
	        
	}

	private static void printProps(Properties props) {

		for( Object key : props.keySet()) {
			Object value = props.get(key);
			System.out.printf("%-30s = %s %n" , key , value);
		}
		
	}

}
