package func;

import java.util.Optional;

/*
 * Optional คลาสใน Java ถูกแนะนำเข้ามาเพื่อลดปัญหา NullPointerException (NPE) 
 * และช่วยให้โค้ดที่จัดการกับค่าที่อาจเป็น null มีความชัดเจนและปลอดภัยมากขึ้น
 * 
 * Version 1: ผู้ใช้ต้องรับผิดชอบตรวจสอบค่า null เอง ซึ่งถ้าลืมตรวจสอบอาจเกิด NullPointerException ได้
 * Version 2: ใช้ Optional เพื่อบังคับให้ผู้ใช้ตรวจสอบค่าก่อนใช้งาน ช่วยลดความเสี่ยงที่จะเกิด NPE
 */
public class B19_Optional {

	/*
	 * Wozu gibt es die Klasse Optional:
	 * 
	 * https://www.oracle.com/technical-resources/articles/java/java8-optional.html
	 */
	
	
	/*
	 * Entwickler Tom.
	 * 
	 * Version 1.
	 * 
	 * Diese Version erhöht die Wahrscheinlichkeit
	 * einer NullPointerException in der Anwendung. 
	 * 
	 * ฟังก์ชัน getAny จะรับอาร์เรย์ของ String เป็นพารามิเตอร์ ถ้าอาร์เรย์เป็น null หรือว่าง จะคืนค่า null กลับมา
	 * ในเวอร์ชันนี้ การไม่ตรวจสอบว่าผลลัพธ์เป็น null ก่อนใช้งานอาจทำให้เกิดข้อผิดพลาด NullPointerException 
	 * เมื่อเรียกใช้เมธอดเช่น toUpperCase โดยไม่มีการตรวจสอบค่า null ก่อน
	 */
	static String getAny1(String... array) {
		if(array==null || array.length==0) {
			return null;
		}
		
		return array[0];
	}
	
	/*
	 * Entwickler Tom.
	 * 
	 * Version 2.
	 * 
	 * Diese Version macht den Benutzer darauf aufmerksam,
	 * dass der String auch nicht gefunden werden kann 
	 * ฟังก์ชัน getAny จะคืนค่า Optional<String> แทนที่จะเป็น String ตรง ๆ
	 * ถ้าอาร์เรย์เป็น null หรือว่าง ฟังก์ชันจะคืนค่า Optional.empty() ซึ่งเป็นค่าที่บ่งบอกว่าไม่มีค่ามาแทน null
	 * ฟังก์ชันจะวนลูปผ่านแต่ละค่าในอาร์เรย์และคืนค่า Optional.of(s) ถ้าเจอ String ที่ไม่เป็น null ถ้าไม่เจอก็จะคืน Optional.empty()
	 */
	static Optional<String> getAny2(String... array) {
		if(array==null || array.length==0) {
			return Optional.empty();
		}
		
		for(String s : array) {
			if(s!=null) {
				return Optional.of(s);
			}
		}
		
		return Optional.empty();
	}

	public static void main(String[] args) {
		/*
		 *  String s = getAny(array);
		 *  
		 * Mit der Version 1 der Methode getAny kann die 
		 * notwendige if-Abfrage vergessen werden:
		 * 
		 * if(s!=null) {
		 *   System.out.println( s.toUpperCase() );
		 * }
		 * 
		 * Ohne if-Abfrage kommt es zu NullPointerException:
		 * 
		 * 	 System.out.println( s.toUpperCase() );
		 * 
		 * เมื่อเรียก getAny(array) จะได้รับค่าเป็น Optional<String> จากนั้นต้องตรวจสอบค่าด้วย .isPresent() เพื่อดูว่ามีค่าอยู่หรือไม่
		 * ถ้ามีค่า สามารถเรียก .get() เพื่อดึงค่าออกมาใช้งาน เช่น แปลงเป็นตัวพิมพ์ใหญ่ด้วย toUpperCase()
		 */
		
		String[] array = {};
		
		// เรียกใช้ getAny1 และตรวจสอบว่าได้ค่า null หรือไม่
		String ss = getAny1(array);
//		System.out.println( ss.toUpperCase() );
		if(ss!=null) {
			// ถ้า ss ไม่เป็น null ก็สามารถใช้งานได้ เช่น แปลงเป็นตัวพิมพ์ใหญ่
			System.out.println( ss.toUpperCase() );
		}
		
		/*
		 * Komplizirte Anwendung.
		 * Entwickler Jerry.
		 * Irgendwo in seinem Code:
		 * 
		 * ฟังก์ชัน getAny2 ใช้ Optional เพื่อให้เราตรวจสอบว่าได้ค่าที่ไม่เป็น null หรือไม่
		 */
		
		// เรียกใช้ getAny2 ซึ่งจะคืนค่าเป็น Optional<String>		
		Optional<String> maybeString = getAny2(array);
		
		// ตรวจสอบว่า Optional นี้มีค่าหรือไม่
		if(maybeString.isPresent()) {
			// ถ้ามีค่า สามารถดึงค่าออกมาใช้ได้
			String s = maybeString.get();
			System.out.println(s.toUpperCase());
		}

		
		

	}

}
