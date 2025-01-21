package loc;

import java.util.Locale;
import java.util.MissingFormatArgumentException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class B08_ResourceBundel_KombinierenDerRessourcen {

	public static void main(String[] args) {

		/*
		 * Hier wird die getBundle vereinfacht dargestellt.
		 * 
		 * ResourceBundle erhält den Basisnamen und  generiert Kandidaten-Namen.
		 * 
		 * Finden Sie , für welches Locale die getBundle die Ressourcen sammelt : 
		 * 
		 * 		getBundle(String baseName)
		 * 			- Sammelt die Ressourcen fürs default-Locale
		 * 
		 * 		getBundle(String baseName , Locale locale)
		 * 			- Sammelt die Ressourcen fürs das spezeielle Locale.
		 * 
		 * Z.B baseName = "loc.res.app"
		 * 		getBundle sammelt für default-Locale (de_DE)
		 * 
		 * kandidatennamen generiert: 
		 * 
		 * 		loc.res.app_de_DE.properties		<- Datei gibt es nicht in unserem Pakage ถ้ามีไฟล์นี้จะใช้สำหรับ de_DE (ภาษาเยอรมัน, ประเทศเยอรมนี).
		 * 		loc.res.app_de.properties			<- Datei gibt es  ถ้ามีไฟล์นี้จะใช้สำหรับภาษาเยอรมัน (หากไม่มีไฟล์ที่ตรงกับ de_DE).
		 * 		loc.res.app.properties				<- Datei gibt es  ถ้าไม่มีไฟล์ที่ตรงกับภาษาเฉพาะ จะใช้ไฟล์นี้ซึ่งเป็นค่าเริ่มต้น.
		 * 
		 * Dateien (Ressourcen )im Bundle : 
		 * 		loc.res.app_de.properties
		 * 		loc.res.app.properties
		 */
		
		Locale.setDefault(Locale.GERMAN);	// de_DE
		
		String baseName = "loc.res.app";
		
		ResourceBundle bundle = ResourceBundle.getBundle(baseName);
		
		/*
		 * getString sucht nur in den Ressourcen aus dem Bundle
		 * 
		 * getString sucht zuerst in den präzieseren Ressourcen , 
		 * dann (wenn nicht gefunden) in allgemeineren
		 * 
		 * เมื่อโปรแกรมทำงาน มันจะพิมพ์ข้อความที่ดึงจากไฟล์ทรัพยากรที่ตรงกับ Locale.GERMAN 
		 * ซึ่งในกรณีนี้จะดึงจาก loc.res.app_de.properties หรือถ้าไม่มีจะดึงจาก loc.res.app.properties แทน.
		 */
		
		String greeting = bundle.getString("greeting");
		System.out.println("greeting : " + greeting  ); 		// aus der app_de.properties

		String day = bundle.getString("day");
		System.out.println("day : " + day  ); 					// aus der app.properties
		
		try {
			String month = bundle.getString("month");
			System.out.println("month : " + month  ); 			// aus der app.properties und app_de.properties gibt es nicht!
		} catch (Exception e) {
			System.out.println("Kein String month gefunden" + e); // Exception : MissingResourceException
		}
		

	}

}
