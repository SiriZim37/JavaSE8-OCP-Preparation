package ocp;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localization2 {
	/*
	 * Code:
	 * import java.util.*;
	 * class RB {
	 *   public static void main(String[] args) {
	 *     System.out.println(Locale.getDefault());
	 *     Locale myLocale = new Locale("en", "US");
	 *     ResourceBundle rb = ResourceBundle.getBundle("myProps", myLocale);
	 *     System.out.println(rb.getString("k2"));
	 *     System.out.println(rb.getLocale());
	 *   }
	 * }
	 *
	 * And a properties file named myProps.properties that contains the following data:
	 * 
	 * Locale=EN_US
	 * k2=val2
	 * k1=v1
	 * country=us
	 * language=en
	 * 
	 * Assuming you're in the United States, what is the result?
	 * 
	 * Options:
	 * 
	 * A. en_US
	 *    val2
	 * 
	 * B. en_US
	 *    val2
	 *    en_us
	 * 
	 * C. en_US
	 *    val2
	 *    en_US
	 * 
	 * D. en_US
	 *    val2
	 *    EN_US
	 * 
	 * E. Compilation fails
	 * 
	 * F. An exception is thrown at runtime
	 * 
	 * Answer:
	 * 
	 * A is correct. 
	 * The properties file should be named myProps_en_US.properties for it to be considered a resource bundle. 
	 * Since it's named incorrectly, the `rb.getLocale()` invocation cannot find a matching locale and defaults to the base locale.
	 * 
	 * Explanation:
	 * - A: ถูกต้อง เพราะ Locale เริ่มต้นคือ `en_US` และสามารถโหลดข้อมูลจากไฟล์ `myProps.properties` ได้ 
	 *       ดังนั้น `rb.getString("k2")` จึงคืนค่า `val2` และ `rb.getLocale()` จะคืนค่า locale เริ่มต้น (`en_US`)
	 *       เนื่องจากไม่มีไฟล์ที่ระบุ locale ไว้ เช่น `myProps_en_US.properties`
	 * 
	 * - B, C, D: ไม่ถูกต้อง เพราะ `rb.getLocale()` ไม่สามารถคืนค่าที่ไม่ได้มีในไฟล์ resource bundle ได้ 
	 *       จะคืนเฉพาะ locale เริ่มต้นเท่านั้น
	 * 
	 * - E: ไม่ถูกต้อง เพราะโค้ดนี้สามารถคอมไพล์ได้ไม่มีปัญหา
	 * 
	 * - F: ไม่ถูกต้อง เพราะไม่มี exception เกิดขึ้นใน runtime แม้ว่าไฟล์ resource bundle จะไม่ระบุ locale อย่างถูกต้อง
	 */

	
	public static void main(String[] args) {
		
		System.out.println(Locale.getDefault());
		Locale myLocale = new Locale("en", "US");
		ResourceBundle rb = ResourceBundle.getBundle("myProps", myLocale);
		System.out.println(rb.getString("k2"));
		System.out.println(rb.getLocale());
			    
	}
}
