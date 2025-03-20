package inheritance;

public class Casting3 {

	public static void main(String[] args) {
		
		
	/*
	 * 1. Überprüfen ob Casting kompiliert! 
	 *   ในขณะคอมไพล์: ตรวจสอบความสัมพันธ์การสืบทอดของชนิดอ้างอิง (Reference Type)
	 * 
	 * 		- Referenz-Typ beachten (nicht den Objekt-Typ)
	 * 		- Kompiliert nur bei Vererbung (Down- oder Up-Casting)!
	 * 
	 * 2. Wenn Casting kompiliert , dann überprüfen ob es 
	 * 		ClassCastException gibt.
	 *    ในขณะรัน: ตรวจสอบความสัมพันธ์ IS-A ของชนิดวัตถุ (Object Type) เพื่อหลีกเลี่ยง ClassCastException
	 * 
	 *		- Objekt-Typ beachten (nicht den Referenz-Typ)
	 *		- Die Klasse des Objektes muss IS-A-Beziehung zu 
	 *		  dem Ziel-Typ haben, sonst gibt es ClassCastException 
	 *
	 *
	 *
	 */
		
		Object obj = "moin";   // Object <- IS-A <- String
		try {
			System.out.println((Integer)obj);	// ClassCastException
		} catch (ClassCastException e) {
			System.out.println("1. ClassCastException ");
		}
		

		String i = "f";
//		i = (Object)i;	// cf : Bassisklasse 
		
		String s = "string";
//		System.out.println((Integer)s);	 // cf : Geschwester kompiliert nicht! 
		
		/*
		 * Nochmal
		 */
		Object nnn = "str" ; 
		String xXXX = (String)nnn;
		System.out.println("2. OK ");
	
		
		Number n1 = 12; 			// สร้างตัวแปร n1 เป็น Number 12 (upcast) ไปเป็น Integer อัตโนมัติ  ซึ่งเป็น int (Integer <- IS-A <- Number)
		Integer x = (Integer) n1;  // ดาวน์แคสต์ (downcast) จาก Number (n1) กลับมาเป็น Integer ได้เพราะ n1 เก็บค่า Integer อยู่
		System.out.println("3. OK");  

		Number n2 = (Number) x;  // อัพแคสต์ (upcast) จาก Integer (x) ไปเป็น Number ได้โดยตรง เนื่องจาก Integer เป็น subtype ของ Number
		System.out.println(n2);  // แสดงค่า n2 ซึ่งก็คือค่า Integer 12

		Object n3 = (Number) x;  // อัพแคสต์สองชั้น จาก Integer -> Number -> Object ซึ่งทำได้เนื่องจาก Integer สืบทอดจาก Object ผ่าน Number
		System.out.println(n3);  // แสดงค่า n3 ซึ่งก็คือค่า Integer 12 เช่นกัน
		
		Integer x2 = 5;
//		Integer n3 = (Number) x2 ; 	// cf : Bassisklasse 

	}

}
