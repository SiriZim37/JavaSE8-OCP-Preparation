package interfaces;


/**
 * อินเทอร์เฟซใน Java เป็นโครงสร้างที่ใช้ประกาศชุดของเมท็อด (methods) และคงที่ (constants) 
 * ที่คลาสที่นำไปใช้งาน (implement) จะต้องปฏิบัติตาม
 */

interface BaseInterfaces {
	
	// ค่าคงที่ในอินเทอร์เฟซจะมีการกำหนดเป็น public static final โดยอัตโนมัติ
	
	public static final String SX = "di";
	
	// เมท็อดแบบ static ในอินเทอร์เฟซ (เพิ่มเข้ามาใน Java 8) 
    // สามารถเรียกใช้งานได้โดยตรงผ่านชื่ออินเทอร์เฟซ
	static void mx() { System.out.println("mx"); }
	
	 
	 /*
     * เมท็อด testAusnahme แสดงตัวอย่างการเรียกใช้เมท็อด static 
     * ภายในอินเทอร์เฟซเอง ซึ่งสามารถทำได้โดยตรง
     */
	static void testAusnahme() {
		BaseInterfaces.mx();
		mx();    // die einzige Ausnahme : im Interface selbst. !!!! 
				 // Sonst nut mit dem Interface-Namen aufrufen! 
				 // เรียกโดยตรงในอินเทอร์เฟซ (กรณีพิเศษเท่านั้น)
		         // **หมายเหตุ**: โดยปกติแล้ว เมท็อด static ของอินเทอร์เฟซ 
		         // จะต้องเรียกใช้งานผ่านชื่อของอินเทอร์เฟซ
	}
}

class BaseClass{
	public static final String SA = "mo";
	static void ma() { System.out.println("ma");}
}


/*
 * คลาส DeriedClass สืบทอดจาก BaseClass และ implements BaseInterfaces
 * - ค่าคงที่ static ของอินเทอร์เฟซและคลาสจะถูกมองเห็นในคลาสที่สืบทอด
 * - เมท็อด static ของอินเทอร์เฟซจะไม่ถูกสืบทอด
 */
class DeriedClass extends BaseClass implements BaseInterfaces{
	

}

public class B03_statischeMethoden {

	/*
	 * 	Achtung! 
	 * 
	 * 	Statische Methode eines Interfaces kann NUR mit dem Interface-Name aufgerufen werden
	 * 
	 * 	Aber auf die statischen Konstanten kann man 
	 * 	mit dem Name der implementierenden Klass aud zugrifen
	 * 
	 */
	 /*
     * เมธอด main แสดงตัวอย่างการทำงานของค่าคงที่และเมท็อด static
     * - เมท็อด static ของคลาสสามารถสืบทอดและเรียกใช้งานได้
     * - เมท็อด static ของอินเทอร์เฟซ **ไม่สามารถสืบทอด** และต้องเรียกผ่านชื่ออินเทอร์เฟซเท่านั้น! 
     */
	
	public static void main(String[] args) {
	
		BaseClass.ma();
		DeriedClass.ma();	    // statische Methode , geerbt aus der Basisklasse

		BaseInterfaces.mx();
//		DeriedClass.mx();	    // cf : statische methode wird des dem Basisinterfaces 
						        // nicht geerbt
								// *** Error: Methode static ของอินเทอร์เฟซไม่ถูกสืบทอด

		
		/*
		 * 	Bei statischen Konstanten ist es anders : 
		 */
		 /*
         * การเรียกใช้ค่าคงที่ static
         * - ค่าคงที่ static ของคลาสถูกสืบทอด
         * - ค่าคงที่ static ของอินเทอร์เฟซสามารถเข้าถึงได้
         */
		System.out.println(BaseClass.SA); 
		System.out.println(DeriedClass.SA); // statische Konstante der Basisklasse
		
		System.out.println(BaseInterfaces.SX); 
		System.out.println(DeriedClass.SX);  // statische Konstante der BaseInterfaces
		
		
		/*
		 * 	Achtung! Auch dort , wo der Compiler
		 * 	den Aufruf einer statischen Methode mit einer Referent
		 * 	durch den korrekten Aufruf korrigiert : es geht nicht mit
		 *  statischen Interface-Methoden
		 */
		 /*
         * การเรียกใช้เมท็อด static โดยอ้างอิงผ่านตัวแปร
         * - สำหรับคลาส: Compiler จะแก้ไขให้ถูกต้อง
         * - สำหรับอินเทอร์เฟซ: ไม่สามารถเรียกผ่านตัวแปรได้
         */
		BaseClass var1 = null ; // Statische Methode wird von Referenz aufrufen !!! EXAM OCA 
		var1.ma(); // korrigiert mit BaseClass.ma();  // Compiler จะทำการแก้ไขเป็น BaseClass.ma();
		
		BaseInterfaces var2;// = null ;
//		var2.mx();	     // cf : Statische Methode eines Interfaces kann NUR 
						 //mit dem Interface-Name aufgerufen werden 
						// *** Error: เมท็อด static ของอินเทอร์เฟซต้องเรียกผ่านชื่ออินเทอร์เฟซ
//		var2.SX;		 // cf :
		BaseInterfaces.mx();		// call static
	}

}
