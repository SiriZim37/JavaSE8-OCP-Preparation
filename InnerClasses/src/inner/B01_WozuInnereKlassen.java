package inner;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;


class Seite {  // Seite ist Toplevel-Klasse
	private Buch buch ; 
	
	public Seite(Buch buch) {
		this.buch = buch;
	}
	
	void testAccess() {
		
	}
	
}
class Buch { // Buch ist Toplevel-Klasse
	
	private String title = "Harry P.";
	
	private static String static_title = "JK. Ro";
	
	/*
	 * Instanzt Methode
	 */	
	class Seite1 { // Seite ist innere (inner , nested) Klasse		
		void testAccess() {
			Buch b = new Buch();
			System.out.println(b.title);
			System.out.println(static_title);
		}
	} 
	
	public class Seite2 { // Seite ist innere (inner , nested) Klasse
	}
	
	protected class Seite3 { // Seite ist innere (inner , nested) Klasse
	}
	
	private class Seite4 { // Seite ist innere (inner , nested) Klasse
	}
	
	
	/*
	 * Statische Methode
	 */
	static class StaticSeit1 {

		static void testAccess() {
			System.out.println(static_title);
		
		}

	}
	
	interface InterfaceSeit1{
		void testAccess();
	}
	
} // end of class Buch

/*
 * NUR FÜR TEST 
 */
class SubBuch1 implements Buch.InterfaceSeit1{

	@Override
	public void testAccess() {}
	
}

class SubBuch2 extends Buch{

//	@Override
//	public void testAccess() {}  // Override is compiler fehler 
	
	void testAccess() {}   // ok , nicht Override
	
}



public class B01_WozuInnereKlassen {

	/*
	 * ข้อดีของ Inner Class (Mögliche Vorteile der inneren Klassen)
	 *
	 * 1. ไม่มีปัญหาการชนกันของชื่อคลาส:
	 *    หากมีคลาสที่มีชื่อเหมือนกันใน package เดียวกัน แต่เป็น Inner Class 
	 *    จะไม่มีปัญหาการชนกันของชื่อคลาสนั้น (Konflikte bei gleichen Klassennamen gibt es nicht, 
	 *    wenn im selben Paket gleichnamige Klassen als innere Klassen existieren)
	 *
	 * 2. มีความสัมพันธ์เชิงตรรกะที่แข็งแรงกับคลาสภายนอก:
	 *    Inner Class ถูกสร้างขึ้นเพื่อทำงานร่วมกับคลาสภายนอก จึงมีการเชื่อมโยงกันอย่างแน่นแฟ้น 
	 *    (starke logische Verbindung mit äußeren Typ)
	 *
	 * 3. ลดจำนวนของ Toplevel Class:
	 *    การใช้ Inner Class ช่วยลดจำนวนคลาสระดับบนใน package ทำให้โครงสร้างโค้ดดูเรียบร้อยและง่ายต่อการจัดการ 
	 *    (Anzahl der Toplevel-Typen reduzieren)
	 *
	 * 4. กำหนดระดับการเข้าถึง (Visibility) ได้ตามต้องการ:
	 *    Inner Class สามารถกำหนดการเข้าถึงได้อย่างยืดหยุ่น เช่น `public`, `private`, `protected` หรือระดับ package 
	 *    ตามที่ต้องการ (Innere Klassen beliebige (public) Sichtbarkeiten bekommen)
	 *
	 * 5. เข้าถึงสมาชิก private ของคลาสภายนอกได้:
	 *    Inner Class สามารถเข้าถึงสมาชิกที่เป็น `private` ของคลาสภายนอกได้โดยตรง 
	 *    (Innere Klasse kann private Elemente der äußeren Klasse sehen)
	 *
	 * 6. Inner Class ที่ไม่ใช่ static สามารถเข้าถึงอ็อบเจ็กต์ของคลาสภายนอกได้:
	 *    Inner Class ที่ไม่เป็น `static` สามารถอ้างถึงและทำงานกับอ็อบเจ็กต์ของคลาสภายนอกได้ 
	 *    (Innere Klasse, die nicht statisch ist, hat Zugriff auf ein Objekt der äußeren Klasse)
	 *
	 * 7. อื่นๆ:
	 *    ข้อดีอื่น ๆ อาจรวมถึงการจัดการโครงสร้างโค้ดให้เป็นระเบียบมากขึ้น และเพิ่มความปลอดภัยของโค้ด 
	 *    เนื่องจากสามารถซ่อนไว้ได้ในคลาสภายนอกโดยไม่เปิดเผยต่อภายนอก (weitere Vorteile …)
	 */
	
	public static void main(String[] args) {
	
		// Aufruf instanzMehtode
		Buch.Seite1 s1 = new Buch().new Seite1();
		Buch.Seite2 s2 ;
		Buch.Seite3 s3 ;
//		Buch.Seite4 s4 ;

//		new Buch.Seite1(); // cf : Not static
//		new Buch.Seite2(); // cf : Not static
//		new Buch.Seite3(); // cf : Not static
//		new Buch.Seite4(); // cf : Not static
	
		// Aufruf statische Mehtode
		Buch.StaticSeit1 ss1 ;
		Buch.StaticSeit1 ss2  = new Buch.StaticSeit1(); // ok
		
		
		Buch.InterfaceSeit1 i1 ; 
		
		
		Locale.Builder b1; 
		
		
		Map.Entry e1 ;          
		/*Bsp. aus der Stan
		 * 
		 */
		Arrays.asList(null);
		

	}

}
