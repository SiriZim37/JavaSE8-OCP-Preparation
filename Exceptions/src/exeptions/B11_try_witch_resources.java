package exeptions;

import java.io.FileReader;
import java.io.IOException;


// ทำให้คลาสนี้ปิดทรัพยากรได้โดยการ implement AutoCloseable
class MeineResource implements AutoCloseable{
	public void close() {
	}
}

public class B11_try_witch_resources {

	public static void main(String[] args) {

		/*
		 * So kann man garantiert eine Ressource mit
		 * try-with-resources schliessen
		 */
		try (FileReader fr = new FileReader("file.txt")){
			// Datei lesen hier...
			System.out.println("Datei geöffnet");
		}catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * 
		 * Achtung ! 
		 * Mit try-with-resources funktionieren NUR 
		 * die Typen , die Interface AutoCloseable als
		 * Basistyp haben.
		 * 
		 * ข้อควรระวัง!
         * กับ try-with-resources จะใช้ได้เฉพาะคลาสที่ implement
         * Interface AutoCloseable เท่านั้น
		 */
		
//		try(String s = new String("abc")){	// cf : String ist nicht AutoCloseable
//			
//		}
		
		/*
		 * Achtung! 
		 * nach dem try-with-resources muss nichts stehen
		 * ข้อควรระวัง!
         * โครงสร้าง try-with-resources จำเป็นต้องมีการปิดทรัพยากรที่ try{} หรือ
         * ต้องมี catch หรือ finally ต่อท้ายเสมอ
		 */
//		try {}  // cf : nach dem try-Block  muss catch oder finally stehen
		
		
		try(MeineResource mr = new MeineResource()) { // ok : es implementiert AutoCloseable
		
		} 
		
		/*
		 * Nach dem try-with-ressources kann alles stehen , 
		 * was nach einem try-Block stehen kann
		 * หลัง try-with-resources สามารถตามด้วย catch, finally หรือทั้งคู่ได้
		 */
		try(MeineResource mr = new MeineResource()) { // ok : es implementiert AutoCloseable
			
		} catch (Exception e) {
			
		}
		
		try(MeineResource mr = new MeineResource()) { // ok : es implementiert AutoCloseable
			
		} finally {
			
		} 
		
	}

}
