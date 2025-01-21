package inner;


class Sonnensystem{
	
	private String name = "Sonnensystem name" ; 
	
	private static int maxSize = 3 ;
	
	private int size = 3 ;   // >> Kann nicht im static Klass Aufrufen in Zeile 37
	
	static class Planet{
		String name =  "Planet name"; 
		
		String getName() {
			return name;
		}
		
		int getSize() {
			Sonnensystem s = new Sonnensystem(); 
			int x = s.size ; // Zugriff auf das private satatische Element der äußere 
			return x;
		}
		
		void testAccess() {
			/*
			 *  Zugriff auf das private satatische Element der äußere 
			 */
			System.out.println(maxSize);
			System.out.println(Sonnensystem.maxSize);
			System.out.println(name);
			
			/*
			 *  kein Sonnensystem Object = kein Zugriff auf Objektattribute
			 */
			
//			System.out.println(size);   // cf   
			
			Sonnensystem s = new Sonnensystem(); 
			System.out.println(s.size);
		}
		
		static void testStaticAccess() {
			/*
			 *  Zugriff auf das private satatische Element der äußere 
			 */
			System.out.println(maxSize);
			System.out.println(Sonnensystem.maxSize);
//			System.out.println(name);
			/*
			 *  kein Sonnensystem Object = kein Zugriff auf Objektattribute
			 */
//			System.out.println(size); 
			
			Sonnensystem s = new Sonnensystem(); 
			System.out.println(s.size);
		}
		
		/*
		 * Egal ob statische Methode oder nicht , es braucht Zugriff auf Objektattribute 
		 */
		
	} // end of class PLanet 
	
	
	String getName() {
		return name;
	}
	
	
} // end of class Sonnensystem 



public class B02_statische_innere_Klasse {

	/*
	 * bei den inneren Klassen : static = 'noemal' 
	 * (in Bezug auf die Instanzbildung)
	 */
	public static void main(String[] args) {

		/*
		 * หมายเหตุ! (Achtung!)
		 * 
		 * คอมไพเลอร์จะค้นหาชนิดของตัวแปร (Types) ที่ใช้ในโค้ดจากด้านในสู่ด้านนอก โดยลำดับการค้นหามีดังนี้:
		 * 
		 * 1. ในเมธอดที่ล้อมรอบ (เช่น ในตัวอย่างนี้คือ main)
		 *    - เมื่อมีการประกาศหรือเรียกใช้ตัวแปรในเมธอด คอมไพเลอร์จะตรวจสอบตัวแปรที่ประกาศในเมธอดนั้นก่อน
		 *    (in der umschließenden Methode)
		 *
		 * 2. ในคลาสที่ล้อมรอบ (ในที่นี้คือคลาสที่เป็นตัวล้อมรอบ inner class)
		 *    - หากตัวแปรที่เรียกใช้ไม่มีในเมธอด คอมไพเลอร์จะค้นหาตัวแปรในคลาสภายนอกที่ล้อมรอบอยู่
		 *    (in der umschließenden Klasse)
		 *
		 * 3. ในแพ็กเกจปัจจุบัน (เฉพาะในคลาสระดับบนสุดเท่านั้น)
		 *    - ถ้าตัวแปรไม่พบในคลาสที่ล้อมรอบ คอมไพเลอร์จะไปค้นหาคลาสที่อยู่ในแพ็กเกจเดียวกัน
		 *    แต่จะใช้กับคลาสระดับบนสุด (Top-level classes) เท่านั้น
		 *    (im aktuellen Paket, nur bei den Toplevel-Klassen)
		 *
		 * โดยสรุป: การค้นหาจะเริ่มจากภายใน (ในระดับเมธอด) แล้วค่อย ๆ ขยายวงออกไปถึงคลาสภายนอก และสุดท้ายถึงแพ็กเกจที่โค้ดนี้อยู่
		 */
//		Planet p1;  // cf ; der Compiler findet die Klasse nicht
					// ( es muss import inner.Sonnensystem.Planet; )
		
		Sonnensystem.Planet p2 ;
		/*
		 * Objekt erzeugen wie mit jeder normalen Klassen : 
		 */
//		new Planet();
		
		new Sonnensystem.Planet(); // ok 
		
		/*
		 * 
		 */
		Sonnensystem.Planet p3 = new Sonnensystem.Planet(); 
		String n = p3.getName();
		System.out.println(n);
		
		


	}

}
