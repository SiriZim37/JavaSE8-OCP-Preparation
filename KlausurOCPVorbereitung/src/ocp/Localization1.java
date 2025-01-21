package ocp;

public class Localization1 {
	/*
	 * Which will create a ResourceBundle for U.S. English when run with a default 
	 * Locale of US English? (Choose all that apply.)
	 * 
	 * A. new ResourceBundle("bundle");
	 * 
	 * B. new ResourceBundle("bundle", Locale.getDefault());
	 * 
	 * C. ResourceBundle.getBundle("bundle");
	 * 
	 * D. ResourceBundle.getBundle("bundle", new Locale("en", "US"));
	 * 
	 * E. ResourceBundle.getBundle("bundle", new Locale("US", "en"));
	 * 
	 * F. ResourceBundle.getBundle(new Locale("US", "en"), "bundle");
	 * 
	 * G. ResourceBundle.getBundle(new Locale("en", "US"), "bundle");
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
	 * Answer:
	 * C and D are correct.
	 * - C works because we are able to assume the Locale of the JVM matches the Locale we want.
	 * - D successfully creates a bundle with the requested Locale.
	 * 
	 * A, B, E, F, and G are incorrect.
	 * - A and B: Incorrect because a ResourceBundle must be created through a factory method (e.g., `getBundle`) and not a constructor.
	 * - E: Incorrect because the `Locale` requires the language code before the country code.
	 * - F and G: Incorrect because the `getBundle` method expects the resource bundle name as the first parameter, not the `Locale`.
	 * 
	 * คำอธิบายเพิ่มเติม:
	 * 
	 * ข้อที่ถูกต้อง:
	 * - C: ใช้งานได้เพราะ JVM จะใช้ Locale เริ่มต้น (default Locale) ซึ่งตรงกับ Locale ที่เราต้องการ (ในที่นี้คือ US English)
	 * - D: ใช้งานได้เพราะเราสร้าง `Locale` ที่ระบุภาษา ("en") และประเทศ ("US") อย่างถูกต้อง และส่งให้ `getBundle`
	 * 
	 * ข้อที่ไม่ถูกต้อง:
	 * - A: ไม่ถูกต้องเพราะไม่สามารถสร้าง ResourceBundle ด้วยตัวสร้าง (constructor) ได้ ต้องใช้วิธี factory method เช่น `ResourceBundle.getBundle`
	 * - B: เช่นเดียวกับ A ไม่ถูกต้องเพราะ ResourceBundle ต้องสร้างผ่าน factory method
	 * - E: ไม่ถูกต้องเพราะ `Locale` ต้องการให้กำหนดภาษาก่อน ("en") แล้วตามด้วยรหัสประเทศ ("US") แต่ในข้อนี้กลับลำดับผิด
	 * - F และ G: ไม่ถูกต้องเพราะ `getBundle` คาดหวังว่าชื่อ resource bundle ("bundle") ต้องเป็นพารามิเตอร์ตัวแรก ไม่ใช่ `Locale`
	 */

}
