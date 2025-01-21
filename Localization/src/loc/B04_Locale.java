package loc;

import java.util.Locale;

public class B04_Locale {

	/*
	 * Locale-Objekt speichert Sprache- und Land-Einstellung
	 * 
	 * https://docs.oracle.com/javase/8/docs/api/java/util/Locale.html
	 */
	/*
	 * Locale ใน Java คือคลาสที่ใช้สำหรับการจัดการกับการแสดงผลข้อมูลที่เกี่ยวข้องกับ 
	 * ภาษาหรือภูมิภาค เช่น การแสดงผลวันและเวลา, ตัวเลข, สกุลเงิน, หรือข้อความในภาษาที่ต่างกัน
	 * โดย Locale ช่วยให้โปรแกรมสามารถปรับตัวให้เหมาะสมกับภูมิภาคและภาษาของผู้ใช้
	 * ทำให้โปรแกรมสามารถทำงานได้ตามคอนเท็กซ์ของผู้ใช้งาน
	 * 
	 * การใช้ Locale ใน Java:
	 * - Locale สามารถระบุได้ด้วยภาษาที่ใช้งานและประเทศที่เกี่ยวข้อง
	 * - ประกอบด้วย 3 ส่วนหลักๆ ได้แก่
	 *   1. **Language** (ภาษา): เช่น "en" (อังกฤษ), "th" (ไทย)
	 *   2. **Country** (ประเทศ): เช่น "US" (สหรัฐอเมริกา), "TH" (ประเทศไทย)
	 *   3. **Variant** (ตัวแปรเพิ่มเติม): เช่น "POSIX" หรือ "EURO"
	 *
	 * ตัวอย่างการใช้งาน Locale:
	 * 1. การแสดงผลภาษาและชื่อประเทศ:
	 *    - `getDisplayLanguage()`: ใช้เพื่อดึงชื่อของภาษาตาม Locale
	 *    - `getDisplayCountry()`: ใช้เพื่อดึงชื่อของประเทศตาม Locale
	 * 
	 * 2. ใช้ในการจัดรูปแบบวันเวลาและตัวเลขตามภาษา:
	 *    - ตัวอย่างเช่น การแสดงผลวันที่ในรูปแบบที่แตกต่างกันตามประเทศ
	 * 
	 * ข้อดีของการใช้ Locale:
	 * - ทำให้โปรแกรมสามารถรองรับหลายภาษาและหลายภูมิภาคได้
	 * - การปรับปรุงหรือเปลี่ยนแปลงค่าของโปรแกรมสามารถทำได้ตามภาษาหรือประเทศ
	 * - ช่วยให้โปรแกรมสามารถแสดงผลข้อมูลต่างๆ ได้อย่างเหมาะสมกับผู้ใช้
	 * */
	public static void main(String[] args) {
	
		/*
		 * Locale-Objekte
		 */
		
		/*
		 * Mit Konstruktoren.
		 * - สามารถสร้าง Locale ได้โดยใช้ Constructor ที่รับพารามิเตอร์ 2 หรือ 3 ตัว เช่น
		 *     - `Locale(String language)`: ใช้สำหรับกำหนดแค่ภาษาที่ต้องการ
		 *     - `Locale(String language, String country)`: ใช้สำหรับกำหนดภาษาพร้อมประเทศ
		 *     - `Locale(String language, String country, String variant)`: ใช้สำหรับกำหนดภาษา, ประเทศ และตัวแปรเพิ่มเติม
		 * 
		 * In Java 8 waren die Konstruktoren nicht deprecated
		 */
		
        Locale loc1 = new Locale("de");     
        Locale loc2 = new Locale("de", "DE");
        
        System.out.println("loc1: " + loc1.getDisplayLanguage());
        System.out.println("loc2: " + loc2.getDisplayCountry());

        
        //******************************************************************************************
        
        System.out.println("\n***Mit dem Locale.Builder");
        /*
		 * Mit dem Locale.Builder.
		 * 	- เป็นทางเลือกในการสร้าง Locale โดยใช้ Builder Pattern ซึ่งช่วยให้การสร้าง Locale มีความยืดหยุ่นและง่ายขึ้น
		 *   - สามารถตั้งค่าต่างๆ เช่น ภาษา, ประเทศ, และตัวแปรได้แบบไดนามิกและมีความยืดหยุ่นสูง
		 */
        
        Locale loc3 = new Locale.Builder()
        				.setLanguage("de")
        		        .setRegion("DE")
        		        .build();
        System.out.println("loc3: " + loc3);


        //******************************************************************************************
        /*
         * Ab Java 19
         * 
         * Locale loc1 = Locale.of("de");
         * Locale loc2 = Locale("de", "DE");
         */
        System.out.println("\n***Mit Konstanten");
        /*
         * Mit Konstanten
         */
        Locale loc4 = Locale.GERMAN;     // de  
        Locale loc5 = Locale.GERMANY;    // de_DE
        System.out.println("loc4: " + loc4);
        System.out.println("loc5: " + loc5);
       
        
        //******************************************************************************************
        
        
        System.out.println("\n***ausgewählte Instanzmethode");
        /*
         * ausgewählte Instanzmethode
         */
        
        System.out.println("loc4.getLanguage(): " + loc4.getLanguage()); 	// de
        System.out.println("loc4.getCountry(): " + loc4.getCountry());		// _____ (Es gibt nicht)
        
        System.out.println("loc5.getLanguage(): " + loc5.getLanguage());	// de
        System.out.println("loc5.getCountry(): " + loc5.getCountry());		// DE
        
        System.out.println("loc4.getDisplayLanguage(): " 
        					+ loc5.getDisplayLanguage());  // Deutsch (oder übersetzt)
        System.out.println("loc4.getDisplayCountry(): "
        					+ loc5.getDisplayCountry());   // Deutschland (oder übersetzt)

        
        //******************************************************************************************
        
        
        System.out.println("\n***ausgewählte statische Methode");
        /*
         * ausgewählte statische Methode
         */
        
        Locale defLocale = Locale.getDefault();
        System.out.println("default-Locale : " + defLocale); 			//	de_DE 
        
        defLocale = Locale.ITALIAN; 		 // เปลี่ยน Locale เริ่มต้นของระบบเป็นของประเทศอิตาลี
        Locale.setDefault(defLocale); 	 // กำหนดให้ Locale เริ่มต้นของระบบเป็นอิตาลี
        System.out.println("Test: " + loc5.getDisplayCountry()); 
        
        System.out.println("\n*** setDefault(Locale.ITALY)");
      
        defLocale = Locale.ITALY; 		 // เปลี่ยน Locale เริ่มต้นของระบบเป็นของประเทศอิตาลี
        Locale.setDefault(defLocale); 	 // กำหนดให้ Locale เริ่มต้นของระบบเป็นอิตาลี
        
     // ทดสอบการเปลี่ยนแปลงค่า default Locale โดยแสดงชื่อของภาษาตาม Locale ที่กำหนด
        System.out.println("Test: " + loc5.getDisplayLanguage());   // tedesco (ชื่อภาษาเยอรมันตามที่ระบบอิตาลีกำหนด)
        
        
     // ทดสอบการเปลี่ยนแปลงค่า default Locale โดยแสดงชื่อของภาษาตาม Locale ที่กำหนด
        System.out.println("Test: " + loc5.getDisplayLanguage());   // tedesco (ชื่อภาษาเยอรมันตามที่ระบบอิตาลีกำหนด)
        
        

        System.out.println("\n** getAvailableLocales()");
	    /*
	     *  ใช้เมธอด getAvailableLocales() เพื่อดึงรายชื่อทั้งหมดของ Locale ที่สามารถใช้งานได้ในระบบ
	     */
        Locale[] allLocales = Locale.getAvailableLocales();
        System.out.println("avaliable locales: " + allLocales.length); // แสดงจำนวนของ Locales ทั้งหมดที่ระบบรองรับ
        
        //******************************************************************************************
	}

}
