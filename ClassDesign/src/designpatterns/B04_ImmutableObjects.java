package designpatterns;

import java.time.LocalDate;
import java.util.Locale;


public class B04_ImmutableObjects {

	/*
	 * Immutable Object : Klasse so getalten, dass die Objekte davon
	 * nicht geändert werden können.
	 * 
	 * Immutable Pattern (อ็อบเจ็กต์ที่ไม่สามารถเปลี่ยนแปลงได้)
	 * Immutable ใช้เมื่อคุณต้องการสร้างอ็อบเจ็กต์ที่ ไม่สามารถเปลี่ยนแปลง ค่าได้หลังจากที่ถูกสร้างขึ้นแล้ว.
	 */
	public static void main(String[] args) {
		/*
		 * Exam:
		 * 
		 * - String ist immutable
		 * - Wrapper-Klassen sind immutable
		 * - Klassen aus Date&Time sind immutable
		 */
		
		String s = "java";
		s.toUpperCase(); // erstellt neues Objekt
		System.out.println("1. s = " + s); // java
		
		s = s.toUpperCase(); // richtig das neue Objekt behalten
		System.out.println("2. s = " + s); // JAVA
		
		LocalDate d = LocalDate.of(2020, 3, 25);
		d.plusDays(3);
		System.out.println(d.getDayOfMonth()); // 25

		d = d.plusDays(3);
		System.out.println(d.getDayOfMonth()); // 28
		
		Integer x = 1200; // Integer.valueOf(1200)
		Integer y = x;
		
		x++; // x = Integer.valueOf( x.intValue() + 1 )
		
		System.out.println( x +","+y + " : " + (x == y) ); // false: zwei Referenzen, 
													       // die auf unterschiedliche 
													       // Integer-Objekte zeigen
		
		
		
		

	}

}
