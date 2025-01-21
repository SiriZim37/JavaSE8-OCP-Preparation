package nio;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class B05_Files_move {

	/*
	 * static Path move(Path source, Path target, CopyOption... options) throws IOException
	 * 
	 *  - eine möglicher CopyOption in der Prüfung 
	 *  
	 *  		StandardCopyOption.REPLACE_EXISTING:
	 *  
	 *   ในคลาส Files ใช้สำหรับย้ายไฟล์หรือโฟลเดอร์จากตำแหน่งต้นทาง (source) ไปยังตำแหน่งเป้าหมาย (target) 
	 *   โดยมีรายละเอียดการทำงานดังนี้:
	 *   
	 *   - Path source: ระบุพาธไฟล์หรือโฟลเดอร์ต้นทางที่ต้องการย้าย
	 *   - Path target: ระบุพาธปลายทางซึ่งรวมถึงชื่อไฟล์ใหม่หรือโฟลเดอร์ใหม่ที่ต้องการย้ายไป
	 *   - CopyOption... options: ตัวเลือกเพิ่มเติมที่ใช้ในการย้ายไฟล์ เช่น 
	 *   		StandardCopyOption.REPLACE_EXISTING เพื่อให้ย้ายและเขียนทับไฟล์ที่มีอยู่แล้ว  
	 *   		StandardCopyOption.ATOMIC_MOVE เพื่อให้การย้ายเป็นแบบ "อะตอมมิก" คือสำเร็จสมบูรณ์ในครั้งเดียว
	 * 	
	 * ***ข้อควรระวัง:***
	 * 
	 * 1. Source File muss existieren : ไฟล์ต้นทางต้องมีอยู่จริง: ไฟล์หรือโฟลเดอร์ที่ระบุในพาธต้นทาง (source)
	 * 								   ต้องมีอยู่จริง หากไฟล์ต้นทางไม่พบ จะเกิดข้อยกเว้น NoSuchFileException
	 * 2. Ohne REPLACE_EXISTING : Target file ist nicht existiert  
	 * 							  ไฟล์ปลายทาง: พาธของไฟล์เป้าหมาย (target) ควรระบุให้ถูกต้อง 
	 *   						  หากมีไฟล์ปลายทางอยู่แล้วและไม่ได้ใช้ตัวเลือก StandardCopyOption.REPLACE_EXISTING
	 *  						  จะเกิดข้อยกเว้น FileAlreadyExistsException
	 *  
	 * 3. Zielverzeichenis muss existieren :  หากพาธเป้าหมายที่กำหนดเป็นโฟลเดอร์ (ไม่ใช่ไฟล์ที่มีชื่อใหม่) โฟลเดอร์นั้นจะต้องมีอยู่แล้วในระบบ 
	 * 								การใช้ Files.copy() จะไม่สร้างโฟลเดอร์ใหม่ หากโฟลเดอร์นั้นไม่อยู่จะเกิดข้อยกเว้น
	 *  
	 *   Unwahrscheinlich in der Prüfung:
	 * - Methode move kann als Source ein Verzeichnis bekommen. 
	 *   Sie kann damit fürs Umbenennen verwendet werden..
	 *   
	 * เมธอด copy สามารถใช้คัดลอกโฟลเดอร์ต้นทางได้
	 *     เมธอดนี้สามารถรับโฟลเดอร์เป็นแหล่งข้อมูลได้ แต่จะสร้างเพียง "โฟลเดอร์เปล่า" ที่ปลายทาง (target) โดยไม่มีเนื้อหาภายในโฟลเดอร์ต้นทางถูกคัดลอกไป
	 */
	
	public static void main(String[] args) {
		
		Path sourceFile = Paths.get("nichtda");
		Path targetFile = Paths.get("nichtda-kopie");
		
		try {
			
			Files.move(sourceFile, targetFile);
			
		} catch (NoSuchFileException e) {
			System.err.println("1. Fehler! Source-File existiert nicht!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n-------------------------------------------------------------------------");
		
		
		sourceFile = Paths.get("autos-kopie-2.txt");  		// existiert
		targetFile = Paths.get("mydir2/autos-3.txtt");			// nicht existiert 
		System.out.println(sourceFile.toAbsolutePath());
		try {
			// sicherstellen den Test ,  dass es die Source File gibt.
			Files.copy(Paths.get("autos.txt") , sourceFile , StandardCopyOption.REPLACE_EXISTING);
			Files.deleteIfExists(targetFile);  			//Ziel Datei alten Tests löschen
			
			Files.move(sourceFile, targetFile);
			System.out.println("2. Datei wurdoe verschoben");

			System.out.println("\n-------------------------------------------------------------------------");
			
			// sicherstellen den Test ,  dass es die Source File gibt.
			Files.copy(Paths.get("autos.txt") , sourceFile , StandardCopyOption.REPLACE_EXISTING);
			
			Files.move(sourceFile, targetFile , StandardCopyOption.REPLACE_EXISTING);
			System.out.println("3. Datei wurdoe verschoben , Zieldatei wurde überschriben");
		

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n-------------------------------------------------------------------------");
			
		/*
		 * Exam! Achtung! 
		 * 
		 * Das 2. Argument für die copy (und move) muss der Pfad sein , der auch den neuen Dateinamen hat.
		 * 
		 * ในโค้ดนี้พยายามคัดลอกไฟล์ auto.txt ไปยังโฟลเดอร์ mydir โดยใช้คำสั่ง Files.copy() 
		 * แต่เกิดข้อผิดพลาด เนื่องจาก target เป็นโฟลเดอร์ ไม่ได้ระบุชื่อไฟล์ใหม่ในโฟลเดอร์ปลายทาง โค้ดนี้จะทำงานได้เมื่อระบุชื่อไฟล์ใหม่ในพาธเป้าหมาย (target)
		 */
		
		Path source = Paths.get("autos.txt");	// existiert
		Path target = Paths.get("mydir");		// existiert und ist nicht leer Verzeichnis (MyDir is not empty Folder)
//		Path target = Paths.get("mydir/some-file");	// ok 
		try {
			// sicherstellen den Test ,  dass es die Source File gibt.
			Files.copy(Paths.get("autos.txt") , sourceFile , StandardCopyOption.REPLACE_EXISTING);

			Files.move(source , target , StandardCopyOption.REPLACE_EXISTING); 	
		
		} catch (DirectoryNotEmptyException e) {
			System.err.println("4. Fehler! Das Ziel ist ein nichtleeres Verzeichnis , "
								+ "sollte aber die neue Datei sein");		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
