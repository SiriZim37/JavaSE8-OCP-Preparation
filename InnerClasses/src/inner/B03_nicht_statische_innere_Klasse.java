package inner;


class Roboter {
	private String name = "Roboter Name";
	private static int staticAtt = 1 ; 	
	public Roboter(String name) {
		this.name = name;
	}	
	
	class Arm{
	
		String name =  "Planet name"; 
		
		void testAccess() {
			 class test1 {
				void methodeTest() {
					System.out.println(staticAtt);
				}
			}
			/*
			 *  implizierter Zugriff auf ein Objekt vom äußeren Typ.
			 *	
			 *	Das funktioniert , weil die nichtstatische inere Klasse
			 *	eine spezielle Referenz hat : 
			 *			NameDerÄußerenKlasse.this  
			 *  
			 */	
			/*
			 * การเข้าถึงแบบเป็นนัย (implizierter Zugriff) ของอ็อบเจกต์จากคลาสภายนอก (äußeren Typ)
			 * 
			 * การทำงานนี้เป็นไปได้เพราะว่าคลาสภายในที่ไม่ใช่แบบ static 
			 * จะมีการอ้างอิงพิเศษ (spezielle Referenz) ไปยังอ็อบเจกต์ของคลาสภายนอกเสมอ:
			 *         ชื่อคลาสภายนอก.this (NameDerÄußerenKlasse.this)
			 * 
			 * กล่าวคือ คลาสภายในที่ไม่ใช่ static สามารถเข้าถึงสมาชิกของอ็อบเจกต์ของคลาสภายนอกได้ 
			 * โดยใช้อ้างอิงนี้ ทำให้สามารถเข้าถึงข้อมูลของคลาสภายนอกได้อย่างเป็นธรรมชาติ
			 */
			System.out.println(name);					// mit Roboter.this
			System.out.println(Roboter.this.name);
//			System.out.println(Roboter.super.name); 	// cf 
			
			Roboter ref = Roboter.this;
			System.out.println(ref.getClass().getSimpleName());
			Arm ref2 = this;
			System.out.println(ref2.getClass().getSimpleName());
		}
		
//		static void testAccess() {			// cf 
//		}
		
	}
}
public class B03_nicht_statische_innere_Klasse {

	/*
	 * in Bezug auf die Instanzbildung ist eine niocht statische inere KLasse sehr seltsam.
	 */
	public static void main(String[] args) {

		/*
		 * Achtung! Der Compiler sucht nach verwendet Typen
		 * von innen nach außen : 
		 * 
		 * 			- in der umscließende Methode (hier main)
		 * 			- in der umscließende Klasse
		 * 			- in dem akutellen Pakage (nur bei den Toplevelklassen)
		 * 
		 */
		/*
		 * คำเตือน! ตัวคอมไพเลอร์จะค้นหาประเภท (Typen) ที่ถูกใช้งาน 
		 * จากด้านในไปสู่ด้านนอก (von innen nach außen) ดังนี้:
		 * 
		 *      - ในเมธอดที่ล้อมรอบ (in der umschließenden Methode) เช่น main ในกรณีนี้
		 *      - ในคลาสที่ล้อมรอบ (in der umschließenden Klasse)
		 *      - ในแพ็กเกจปัจจุบัน (im aktuellen Paket) สำหรับคลาสระดับสูงสุดเท่านั้น (nur bei den Toplevelklassen)
		 * 
		 * กล่าวคือ ตัวคอมไพเลอร์จะตรวจสอบการใช้งานประเภทจากภายในออกไปด้านนอกตามลำดับนี้
		 * เพื่อให้แน่ใจว่าการอ้างอิงคลาสหรือประเภทในโค้ดนั้นถูกต้อง
		 */
		
		// Arm a1 ; // cf 
		Roboter.Arm a2 ;
		
		/*
		 * Achtung! 
		 * Zum Erzeugen eines Objektes mit der inneren nicht statischen Klasse 
		 * braucht man ein Objekt vom äußeren Typ
		 */
//		
//		new Roboter.Arm(); // cf : nicht static
		new Roboter("TEST").new Arm();
		
		Roboter r1 = new Roboter("R2D2");
		r1.new Arm();
		
		/*
		 * Ingesamt : 
		 */
		
		Roboter.Arm a3 =  r1.new Arm() ;     			// ok 
		
		System.out.println("*** testAcces mit a3 ");
		a3.testAccess();
		
		Roboter.Arm a4 =  new Roboter("C3PO").new Arm() ; 	// ok 
		
		System.out.println("*** testAcces mit a4 ");
		a4.testAccess();
		
	
		
	

	}

}
