package inner;

import java.time.LocalTime;

/*
 * Tier เป็นคลาสอับสแตรกต์ (abstract class) ซึ่งมีเมธอด doStuff() ที่มีการประกาศคลาสภายใน (local class) 
 * ชื่อว่า Substuff และมีเมธอด seeOuter() ภายใน ซึ่งสามารถเข้าถึงตัวแปรจากคลาสภายนอกได้
 * Tier ไม่มีการสร้างอ็อบเจ็กต์ของตัวเองในเมธอด main โดยตรง เพราะมันเป็นคลาสอับสแตรกต์ (abstract class) 
 * ซึ่งไม่สามารถสร้างอ็อบเจ็กต์ได้โดยตรง เมื่อใช้ new Tier().doStuff(); จะมีข้อผิดพลาดเกิดขึ้น 
 * เนื่องจากไม่สามารถสร้างอ็อบเจ็กต์จากคลาสอับสแตรกต์โดยตรง
 */

class SubTier extends Tier {
    @Override
    void doStuff() {
        super.doStuff();
    }
}

abstract class Tier{
	
	/*
	 * Lokale Methode
	 */
	// static 
	static Tier getLieblingstier() {
		
		LocalTime time = LocalTime.now();

		/*
		 * Eigeschloßende Methode
		 */
		class Hund extends Tier{
			
			/*
			 * Annonymous Methode
			 */
			public String toString() {
				return "Hund. Erstellt um" + time; 	// Zugriff auf die lokale
													// Variable der Methode
													// getLieblingstier
			}
//			time = null;  // an sich ok , aber dadurch ensteht 
						  // ein Compiliertfehler in der toString der Klasse Hund
						  // (สิ่งนี้ทำให้เกิด ข้อผิดพลาดของคอมไพเลอร์ใน toString ของคลาส Hund)
			
		}// end of local class Hund
		
//		time = null;  // an sich ok , aber dadurch ensteht 
					  // ein Compiliertfehler in der toString der Klasse Hund
					  // (สิ่งนี้ทำให้เกิด ข้อผิดพลาดของคอมไพเลอร์ใน toString ของคลาส Hund)

		return new Hund();
		
		/*
		 * time : Local Variable mark final , cant change it ( it will compier fehler "!!!)
		 */
	}
	// non-static 
	void doStuff() {
		
		String strTest = "Test2" ;
		final String strTestFinal = "strTestFinal" ;
	
		class Substuff{
				
			/*
			 * Annonymous Methode
			 */
			public void seeOuter() {
				System.out.println(strTestFinal);
				System.out.println(strTest);   
			}
	
			
		}// end of local class Hund

//		strTest = "test2" ; // an sich ok , aber dadurch ensteht 
						  	// ein Compiliertfehler in der toString der Klasse Hund
							// (สิ่งนี้ทำให้เกิด ข้อผิดพลาดของคอมไพเลอร์ใน toString ของคลาส Hund)
//		strTestFinal = "strTestFinalChange"; //  Das würde einen Fehler verursachen

		// สร้างอ็อบเจ็กต์ Substuff และเรียกใช้เมธอด seeOuter
		 Substuff sub = new Substuff();
	     sub.seeOuter();
	        
	}
	
}

public class B05_SowasWieClosure {

	/*
	 * Closure : https://de.wikipedia.org/wiki/Closure_(Funktion)
	 * 
	 * Der Zugrif auf die lokale Variable der umschließenden Methode
	 * in der Methode einer lokalen Klasse (oder einer lokalen anonymen
	 * Klasse , oder in einer Lamda funktioniert nur , wenn die Variable 
	 * 'effectively final' bleibt)
	 *  การเข้าถึงตัวแปรท้องถิ่นของเมธอดที่ล้อมรอบในเมธอดของคลาสภายในท้องถิ่น
	 * (หรือคลาสอนุกรมท้องถิ่น, หรือใน Lambda) จะทำงานได้ก็ต่อเมื่อ
	 * ตัวแปรนั้นยังคงเป็น 'effectively final'
	 */
	public static void main(String[] args) throws InterruptedException { // oder throws Exception

		Tier t1 = Tier.getLieblingstier();
		System.out.println("t1 :" + t1.toString());		
		
		Thread.sleep(1000);
		
		Tier t2 = Tier.getLieblingstier();
		System.out.println("t2 :" + t2);
		
		System.out.println("t1 :" + t1);	
		
		
		// new Tier(): ใน main() จะสร้างอ็อบเจ็กต์จากคลาสที่สืบทอดจาก Tier เพื่อเรียกใช้ doStuff()
        new Tier() {
        	@Override
        	void doStuff() {
        		super.doStuff();
        	}
        }.doStuff();
	}

	/*
	 * Ausgaben : 
	 *				t1 :Hund. Erstellt um11:44:37.175720400
	 * 				t2 :Hund. Erstellt um11:44:38.180773700
	 * 				t1 :Hund. Erstellt um11:44:37.175720400
	 */
}
