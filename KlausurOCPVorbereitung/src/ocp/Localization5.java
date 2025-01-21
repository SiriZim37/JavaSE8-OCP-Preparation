package ocp;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localization5 {
	
	public static void main(String[] args) {
	    ResourceBundle rb = ResourceBundle.getBundle("Flag", new Locale("fr_CA"));
	    System.out.println(rb.getString("key"));
	  }
	
	
	/*
	 * If each of the following is the only resource bundle on the classpath and contains key=value, 
	 * which will be used? Assume the default locale is U.S. English. (Choose all that apply.)
	 *
	 * A. Flag.java
	 * B. Flag_CA.properties
	 * C. Flag_en.java
	 * D. Flag_en.properties
	 * E. Flag_en_CA.properties
	 * F. Flag_fr_CA.properties
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 * A, C, D, and F are correct. A uses the default resource bundle. 
	 * C and D use the language from the default locale. F matches the locale specifically requested.
	 *
	 * B and E are incorrect. B is incorrect because the language code CA does not match fr, 
	 * and CA isn't a valid language code. E is incorrect because the language code matches the default, 
	 * but the country code does not.
	 */

	/*
	 * คำอธิบาย:
	 * - A: ใช้ resource bundle เริ่มต้นที่เป็นค่า default ซึ่งคือ U.S. English ในกรณีนี้
	 * - B: ไม่ถูกต้อง เพราะ CA ไม่ใช่โค้ดภาษาที่ถูกต้อง (ไม่ตรงกับ "fr" ที่กำหนดไว้)
	 * - C: ใช้ภาษา "en" จาก locale ค่า default ซึ่งคือ U.S. English
	 * - D: ใช้ resource bundle ที่เป็น "en" สำหรับภาษาอังกฤษจาก locale ค่า default
	 * - E: ไม่ถูกต้อง เนื่องจากโค้ดภาษาตรงกับค่า default แต่โค้ดประเทศไม่ตรงกับที่ระบุในคำขอ (fr_CA)
	 * - F: ถูกต้อง เพราะตรงกับ locale ที่ร้องขอโดยเฉพาะ (fr_CA)
	 */
	
}
