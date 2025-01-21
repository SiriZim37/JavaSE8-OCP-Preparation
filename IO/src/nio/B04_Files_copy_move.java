package nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class B04_Files_copy_move {

	/*
	 * static Path copy(Path source, Path target, CopyOption... options)throws IOException
	 * 
	 * คลาส Files ที่ใช้สำหรับคัดลอกไฟล์หรือไดเรกทอรีจากตำแหน่ง source ไปยังตำแหน่ง target ตามที่ระบุ โดยมีรายละเอียดการทำงานดังนี้:
	 * 
	 *	- Path source: ตำแหน่งไฟล์ต้นทางที่ต้องการคัดลอก
	 * 	- Path target: ตำแหน่งปลายทางที่ไฟล์หรือไดเรกทอรีจะถูกคัดลอกไป
	 * 	- CopyOption... options: ตัวเลือกเพิ่มเติมสำหรับการคัดลอก 
	 * 		StandardCopyOption.REPLACE_EXISTING: ใช้แทนไฟล์ที่มีอยู่แล้วในตำแหน่งเป้าหมาย หากไฟล์ปลายทางมีอยู่แล้ว ระบบจะเขียนทับด้วยไฟล์ใหม่
	 * 		StandardCopyOption.COPY_ATTRIBUTES: คัดลอกแอตทริบิวต์ทั้งหมดจากไฟล์ต้นทางไปยังไฟล์ปลายทาง เช่น วันที่สร้าง วันที่แก้ไข และสิทธิ์การเข้าถึงไฟล์
	 * 		LinkOption.NOFOLLOW_LINKS: ใช้เมื่อไม่ต้องการให้คัดลอกลิงก์สัญลักษณ์ (symbolic link) ให้ตรงตามต้นทาง 
	 * 								   แต่จะคัดลอกเฉพาะลิงก์โดยไม่เข้าไปคัดลอกไฟล์ที่ลิงก์นั้นชี้ไป
	 * 	
	 * ***ข้อควรระวัง:***
	 * 
	 * 1. Source File muss existieren : ไฟล์ต้นทางต้องมีอยู่จริง: ไฟล์หรือโฟลเดอร์ที่ระบุในพาธต้นทาง (source)
	 * 								   ต้องมีอยู่จริง หากไฟล์ต้นทางไม่พบ จะเกิดข้อยกเว้น NoSuchFileException
	 * 2. Ohne REPLACE_EXISTING : Target file ist nicht existiert
	 * 							 ไฟล์ปลายทาง: พาธของไฟล์เป้าหมาย (target) ควรระบุให้ถูกต้อง 
	 *   						  หากมีไฟล์ปลายทางอยู่แล้วและไม่ได้ใช้ตัวเลือก StandardCopyOption.REPLACE_EXISTING
	 *  						  จะเกิดข้อยกเว้น FileAlreadyExistsException
	 * 3. Zielverzeichenis muss existieren :  หากพาธเป้าหมายที่กำหนดเป็นโฟลเดอร์ (ไม่ใช่ไฟล์ที่มีชื่อใหม่) โฟลเดอร์นั้นจะต้องมีอยู่แล้วในระบบ 
	 * 								การใช้ Files.copy() จะไม่สร้างโฟลเดอร์ใหม่ หากโฟลเดอร์นั้นไม่อยู่จะเกิดข้อยกเว้น
	 * 
	 * 
	 *  Unwahrscheinlich in der Prüfung
	 *  
	 * Methode copy kann als Source ein Verzeicheinis bekommen. Sie erstellt
	 *    dabei ein neues LEERS Verzeichnis. Sie kann keine Inhalte aus dem Source-Verzeichnis kopieren
	 * เมธอด copy สามารถใช้คัดลอกโฟลเดอร์ต้นทางได้
	 *     เมธอดนี้สามารถรับโฟลเดอร์เป็นแหล่งข้อมูลได้ แต่จะสร้างเพียง "โฟลเดอร์เปล่า" ที่ปลายทาง (target) โดยไม่มีเนื้อหาภายในโฟลเดอร์ต้นทางถูกคัดลอกไป
	 *   
	 */
	public static void main(String[] args) {
		
		Path sourceFile1 = Paths.get("nichtda");
		Path targetFile1 = Paths.get("nichtda-kopie");
		
		// CopyOption[] copyOps = {StandardCopyOption.REPLACE_EXISTING};
		
		
		//*** 1. Source File muss existieren  > NoSuchFileException
		
		try {
			
			// Files.copy(sourceFile1, targetFile1 , StandardCopyOption.REPLACE_EXISTING);
			Files.copy(sourceFile1, targetFile1);    // java.nio.file.NoSuchFileException: nichtda
			
		}catch (NoSuchFileException e) {
			System.err.println("1. Fehler! Source-File existiert nicht!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n-------------------------------------------------------------------------");
		
		//*** 2. Target-Datei ohne REPLACE_EXISTING > FileAlreadyExistsException
		
		sourceFile1 = Paths.get("autos.txt");				//existiert
		targetFile1 = Paths.get("autos-kopie.txt");			//existiert bereits
		try {
			
			Files.copy(sourceFile1, targetFile1);
			
		}catch (FileAlreadyExistsException e) {
			System.err.println("1. Fehler! Target file existiert bereits");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("\n-------------------------------------------------------------------------");
		
		//** success copied
		sourceFile1 = Paths.get("autos.txt");				//existiert
		targetFile1 = Paths.get("autos-kopie-2.txt");		//existiert noch nicht
		
		try {
			
			Files.copy(sourceFile1, targetFile1 , StandardCopyOption.REPLACE_EXISTING);
			System.out.println("3. Datei wurde kopiert.");
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n-------------------------------------------------------------------------");
		
		//** success deleted and copied
		
		sourceFile1 = Paths.get("autos.txt");				//existiert
		targetFile1 = Paths.get("autos-kopie-2.txt");		//existiert noch nicht
		
		try {
			Files.deleteIfExists(targetFile1);
			System.out.println("4. Datei wurde kopiert.");
			
			Files.copy(sourceFile1, targetFile1 , StandardCopyOption.REPLACE_EXISTING);
			System.out.println("5. Datei wurde kopiert , Zieldatei wurde überschrieben");
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
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
			
			Files.copy(source , target , StandardCopyOption.REPLACE_EXISTING); 	
			System.out.println("6. Datei wurde kopiert.");
		} catch (DirectoryNotEmptyException e) {
			System.err.println("7. Fehler! Das Ziel ist ein nichtleeres Verzeichnis , "
								+ "sollte aber die neue Datei sein");		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
