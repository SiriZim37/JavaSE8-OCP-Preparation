package designpatterns;

/*
 * Singleton คือคลาสที่มีการออกแบบให้สามารถสร้างออบเจ็กต์ (Object) ได้แค่หนึ่งเดียวในโปรแกรมนั้นๆ 
 * ( ONLY 1 Instanz !!!! )
 * ซึ่งจะช่วยป้องกันไม่ให้มีการสร้างออบเจ็กต์ซ้ำหลายๆ ครั้ง โดยสามารถเข้าถึงตัวเดียวที่ถูกสร้างขึ้นมาเท่านั้น
 * และสามารถเข้าถึงได้จากทุกที่ในแอปพลิเคชัน.
 */

class AppSettingsV1{
	
	/*
	 * Singleton : statisches Attribut
	 * สร้าง instance แบบ static เพื่อให้สามารถเข้าถึงได้จากที่อื่น
	 */
	public static AppSettingsV1 INSTANCE = new AppSettingsV1(); 
	
	// INSTANCE เป็นตัวแปร static ที่เก็บออบเจ็กต์ของ AppSettingsV1 ซึ่งจะมีแค่หนึ่งเดียวในโปรแกรม

	/*
	 * Singleton : alle Konstruktoren sind private 
	 * constructor แบบ private เพื่อไม่ให้สามารถสร้างออบเจ็กต์ใหม่ได้จากภายนอก
	 */
	private AppSettingsV1(){} // Konstruktoren muss private sein 
	
	/*
	 * weitere Attribute und Methoden der Klasse
	 */
	
	private String appName = "myapp";
	
	public String getAppName() {
		return appName;
	}
	
	public void setAppName(String appName) {
		this.appName = appName;
	}
	//...
}
/*
 * eine weitere Variante einer Singleton-Klasse
 * (Achtung in der Praxis! Diese Version ins nicht threadsicher)
 */

class AppSettingsV2{ // AppSettingsV2 (Singleton แบบที่สอง)
	
	private static AppSettingsV2 instance; 
	
	/*
	 * เราใช้ getInstance() เพื่อดึงออบเจ็กต์เดียวของคลาสนี้ โดยจะสร้างออบเจ็กต์ใหม่แค่เมื่อยังไม่มีออบเจ็กต์ใดๆ ถูกสร้าง
	 */
	public static AppSettingsV2 getInstance() {
		if(instance==null) {
			instance = new AppSettingsV2();
		}
		return instance;
	}
	
	// constructor เป็น private เช่นเดียวกัน เพื่อไม่ให้สร้างออบเจ็กต์ใหม่จากภายนอก
	private AppSettingsV2() { // Konstruktoren muss private sein 
		
	}
	
	// weitere Attribute und Methoden...
}

/*
 * eine weitere Variante einer Singleton-Klasse
 */
// AppSettingsV3 (Singleton แบบที่สาม)
/*
 * เราใช้ enum เพื่อสร้าง Singleton ที่ง่ายและปลอดภัยจากปัญหาของการใช้หลายเธรด (thread-safe)
 * enum ใน Java รับประกันได้ว่าแค่มีออบเจ็กต์เดียวของ INSTANCE ในโปรแกรมนี้
 */
enum AppSettingsV3{
	INSTANCE
}



public class B01_Singleton {

	/*
	 * Singleton : die Klasse so gestalten ,
	 * dass nur ein einziges Objekt dieser KLasse erstellt werden kann.
	 */
	
	/*
	 * Exam ! Achten Sie darauf , dass alle Konstruktoren private sind!!!! 
	 */
	
	public static void main(String[] args) {

//		new AppSettingsV1();	// The constructor AppSettingsV1() is not visible
		
		System.out.println(AppSettingsV1.INSTANCE );
		System.out.println(AppSettingsV2.getInstance() );
		System.out.println(AppSettingsV3.INSTANCE );

		/*
		 * สรุป:
		 * Singleton Pattern ช่วยให้สามารถสร้างออบเจ็กต์เดียวในโปรแกรม และควบคุมการเข้าถึงจากภายนอก
		 * ใช้การ private constructor เพื่อป้องกันการสร้างออบเจ็กต์จากภายนอก
		 * Singleton แบบ enum คือวิธีที่ง่ายและปลอดภัยจากการใช้หลายเธรด
		 */
	}

}
