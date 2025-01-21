package errors;

class Auto {
	private int baujahr;
	
	public Auto(int baujahr) {
		if(baujahr < 1900) {
			throw new IllegalArgumentException("Falsches Baujahr : " + baujahr);
		}
		
		this.baujahr = baujahr;
	}
	/*
	 * Was ist wenn späte diese Methode erzegt wird ? 
	 */
//	public void setBaujahr(int baujahr) {
//		this.baujahr = baujahr;
//	}
	
	@Override
	public String toString() {


		/*
		 * if-Abfrage ist sinnlos. Die Klasse ist bereites garantiert korrekt.
		 * 
		 * Garantiert ist : baujahr <= 1900 (Invariante)
		 * Baujahr ist garantiert
		 *  
         * การใช้ if ในการตรวจสอบนั้นเป็นเรื่องที่ไม่จำเป็น
         * เนื่องจากในตัว class นี้ เราได้ทำการรับประกันแล้วว่า baujahr จะต้องไม่ต่ำกว่า 1900
         * เพราะใน constructor ได้มีการตรวจสอบไว้แล้ว
         */
		 
		
//		if(baujahr < 1900) {
//			throw new IllegalArgumentException("Auto hat falsches Baujahr : " + baujahr);
//		}
		
		// assert เป็นการตรวจสอบที่เกิดขึ้นในช่วงการทดสอบเท่านั้น
        // ถ้าเงื่อนไขใน assert เป็นจริง จะไม่มีการทำอะไร แต่ถ้าเป็นเท็จ (ผิด) จะขว้าง AssertionError
		
		assert baujahr >= 1900;
		
		return "Auto. Bj: " + baujahr;
	}
}

/*
 * การใช้งาน assert ต้องเปิดการใช้งานใน JVM ด้วยคำสั่ง -ea (enable assertions) ซึ่งไม่ได้เปิดใช้งานโดยดีฟอลต์
 */
public class B01_Assertions {
	/*
	 * 	- Assertions bitte nur beim Testen verwenden ควรใช้เฉพาะในการทดสอบเท่านั้น
	 *  - Assertions dürfen die die Logik der Anwendung nicht ändert  ไม่ควรมีผลต่อการทำงานหลักของโปรแกรม
	 *  - Assertions müssen aktiviert werden ต้องเปิดใช้งานในการคอมไพล์หรือรันโปรแกรม
	 */

	public static void main(String[] args) {
		

	}

}
