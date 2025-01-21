package ocp;

public class Localization3 {
	/*
	 * Code:
	 * import java.util.*;
	 * class Travel {
	 *   public static void main(String[] args) {
	 *     Locale i1 = Locale.getDefault();       // US
	 *     Locale i2 = new Locale("it");          // Italy
	 *     Locale i3 = new Locale("it", "CH");    // Switzerland
	 *     System.out.println(i3.getDisplayCountry(i1));    
	 *   }
	 * }
	 *
	 * Given:
	 * - The executing JVM's default locale is en_US.
	 * - The locale "it_CH" represents Italian in Switzerland.
	 * - In Italian, Switzerland is spelled "Svizzera."
	 * - In Italian, United States is spelled "Stati Uniti."
	 *
	 * Question: What is the result?
	 * 
	 * A. Svizzera
	 * B. Switzerland
	 * C. United States
	 * D. Stati Uniti
	 * E. Compilation fails
	 *
	 *
	 *
	 *+
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
	 * Correct Answer:
	 * B. Switzerland
	 * 
	 * Explanation:
	 * - The method `getDisplayCountry(Locale)` takes the invoking Locale (`i3` in this case, representing Italian in Switzerland) 
	 *   and uses the argument Locale (`i1`, representing the default locale, en_US) to format the country's name.
	 * - The result will be the country name of the invoking locale (`i3`, i.e., Switzerland) displayed in the format of the argument 
	 *   locale (`i1`, i.e., English).
	 * - Therefore, the output is "Switzerland" since the default locale (`en_US`) formats the name in English.
	 * 
	 * Why others are incorrect:
	 * - A. "Svizzera" would be correct if the argument locale (`i1`) were set to Italian instead of English.
	 * - C. "United States" is incorrect because the method displays the country of the invoking locale, not the default locale.
	 * - D. "Stati Uniti" is incorrect because it is the Italian translation of "United States," not the country of the invoking locale.
	 * - E. "Compilation fails" is incorrect because the code compiles without issues.
	 *
	 * คำอธิบาย:
	 * - เมธอด `getDisplayCountry(Locale)` ใช้ Locale ที่เรียกใช้ (`i3` คือ it_CH หรือ Switzerland) เป็นชื่อประเทศที่จะแสดงผล 
	 *   และใช้ Locale ที่ส่งเป็นพารามิเตอร์ (`i1` คือ en_US) เพื่อจัดรูปแบบชื่อประเทศ
	 * - คำตอบคือ "Switzerland" เพราะ `i1` เป็น en_US ซึ่งแสดงผลชื่อประเทศเป็นภาษาอังกฤษ
	 * 
	 * อธิบายโค้ด:
	 * 1. Locale i1 = Locale.getDefault();
	 * 		บรรทัดนี้ใช้ Locale.getDefault() เพื่อดึง Locale ปัจจุบันของเครื่องที่กำลังทำงาน ซึ่งในกรณีนี้คือ en_US (ภาษาอังกฤษ, สหรัฐอเมริกา).
	 * 2.Locale i2 = new Locale("it");
	 * 		สร้าง Locale ที่ระบุว่าเป็นภาษาอิตาลี (Italy) โดยใช้โค้ดภาษา "it" (ภาษาอิตาลี). ในกรณีนี้ i2 จะมีค่าเป็นภาษาอิตาลีโดยไม่ระบุประเทศ.
	 * 3. Locale i3 = new Locale("it", "CH");
	 * 		สร้าง Locale สำหรับประเทศสวิตเซอร์แลนด์ ("CH") ที่ใช้ภาษาอิตาลี ("it") ซึ่งในสวิตเซอร์แลนด์จะมีหลายภาษาใช้ร่วมกัน หนึ่งในนั้นคือภาษาอิตาลี.
	 * 4. System.out.println(i3.getDisplayCountry(i1));
	 * 		คำสั่งนี้จะใช้ i3.getDisplayCountry(i1) เพื่อแสดงชื่อประเทศใน Locale ของ i3 (ภาษาอิตาลีในสวิตเซอร์แลนด์) 
	 * 		แต่แสดงผลออกมาเป็นภาษาที่กำหนดใน i1 ซึ่งเป็นภาษาอังกฤษ (en_US).
	 * 		ในกรณีนี้ i3 คือสวิตเซอร์แลนด์ในภาษาอิตาลี ซึ่งจะถูกแสดงเป็น "Svizzera" (ชื่อประเทศในภาษาอิตาลี) แต่เมื่อแสดงผลในภาษาอังกฤษ 
	 * 		(ตาม i1 ที่เป็น en_US), ระบบจะต้องแปล "Svizzera" เป็น "Switzerland" ซึ่งเป็นชื่อประเทศในภาษาอังกฤษ.
	 * 

	 * 
	 * ทำไมคำตอบอื่นถึงผิด:
	 * - A. "Svizzera" จะถูกต้องถ้า Locale ที่ส่งเป็นพารามิเตอร์เป็นภาษาอิตาลีแทนภาษาอังกฤษ
	 * - C. "United States" ผิดเพราะเมธอดจะแสดงชื่อประเทศของ Locale ที่เรียกใช้ ไม่ใช่ Locale ของระบบ
	 * - D. "Stati Uniti" ผิดเพราะเป็นการแปลชื่อ "United States" เป็นภาษาอิตาลี ไม่ใช่ชื่อประเทศของ `i3`
	 * - E. "Compilation fails" ผิดเพราะโค้ดสามารถคอมไพล์ได้อย่างถูกต้อง
	 */

}
