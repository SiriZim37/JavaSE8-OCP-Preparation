package nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

public class B03_Files_createXxx_delete_exists {

	public static void main(String[] args) {
		
		/*
		 * static boolean exists(Path path, LinkOption... options)
		 *  
		 * exists() เป็นเมธอดของคลาส Files ที่ใช้เพื่อตรวจสอบว่าไฟล์หรือไดเรกทอรีที่ระบุในพาธ (Path) นั้นมีอยู่จริงในระบบไฟล์หรือไม่
		 * ผลลัพธ์เป็น true หากไฟล์หรือไดเรกทอรีนั้นมีอยู่ และ false หากไม่พบ
		 * 
		 * path: คือพาธ (Path) ที่คุณต้องการตรวจสอบว่ามีอยู่จริงในระบบไฟล์หรือไม่
		 * options: เป็นอาร์กิวเมนต์ที่ใช้ระบุตัวเลือกเพิ่มเติมเกี่ยวกับลิงก์ (ถ้ามี) 
		 * เช่น LinkOption.NOFOLLOW_LINKS ซึ่งจะใช้ในการป้องกันไม่ให้ตรวจสอบลิงก์เชื่อมโยง (symlinks) แต่จะตรวจสอบเฉพาะไฟล์หรือไดเรกทอรีจริงๆ
		 */
	   Path p1 = Paths.get("nicht da");
	   System.out.println("p1: "+ p1);
	   boolean result =	 Files.exists(p1);
	   System.out.println("Existiert p1 : " + result);  // false
	   
	   Path p2 = Paths.get("src");
	   result = Files.exists(p2);
	   System.out.println("Existiert p2 : " + result);  // true
	   
	   System.out.println("\n--------------------------------------------------------------------------------------------");
	   
	   /*
	    * static Path createFile(Path path, FileAttribute<?>... attrs)  throws IOException
	    * 
	    * เมธอดของคลาส Files ใน Java ใช้ในการสร้างไฟล์ใหม่ในระบบไฟล์ที่ตำแหน่งที่ระบุในพาธ (Path) ที่ส่งเข้าไป
	    * เมธอด createFile() จะพยายามสร้างไฟล์ใหม่ที่ตำแหน่งที่ระบุใน path 
	    * หากไฟล์นั้นยังไม่มีอยู่ในระบบไฟล์ ถ้าไฟล์นั้นมีอยู่แล้วจะเกิดข้อผิดพลาด FileAlreadyExistsException และจะไม่ทำการสร้างไฟล์ใหม่.
	    */
	   Path path = Paths.get("hallo");
	   System.out.println(path.toAbsolutePath());
	   try {
		   Files.createFile(path);
		   System.out.println("1. Datei hallo erzeugt. "); // Es kann nur einmal erzeugen und dann wird Exception FileAlreadyExistsException
		   
	   }catch (IOException e) {
			e.printStackTrace();
	   }

	   System.out.println("\n--------------------------------------------------------------------------------------------");
	   
	   /*
	    * static void delete(Path path) throws IOException
	    * 
	    * 			kann eine Datei oder ein leers Verzeichenis löschen
	    * 
	    * delete(Path path) ในคลาส Files ของ Java ใช้สำหรับลบไฟล์หรือโฟลเดอร์ (ไดเรกทอรี) ที่ระบุในพาธ path หากไฟล์หรือไดเรกทอรีนั้นมีอยู่ในระบบไฟล์
	    * ไดเรกทอรี สามารถถูกลบได้ แต่ ต้องเป็นไดเรกทอรีที่ว่างเปล่า !
	    * หากไดเรกทอรีนั้นมีไฟล์หรือไดเรกทอรีอื่นอยู่ภายในจะไม่สามารถลบได้ และจะโยนข้อผิดพลาด DirectoryNotEmptyException
	    *
	    * ตัวอย่างข้อผิดพลาดที่เกิดขึ้น:
	    * -FileNotFoundException: หากไฟล์ไม่พบ
	    * -DirectoryNotEmptyException: หากไดเรกทอรีไม่ว่างเปล่า
	    * 	
	    */
	    try {
	    	Files.delete(path);
	    	System.out.println("2. Datei hallo gelöscht");
	    	
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    System.out.println("\n--------------------------------------------------------------------------------------------");
	    
	    /*
	     * static Path createDirectory(Path dir, FileAttribute<?>... attrs) throws IOException
	     * 
	     * 			- Das Verzeichnis darf nichts existieren
	     * 			- Das Parent-Verzeichenis muss existieren
	     * 
	     * 
	     * สร้างไดเรกทอรีใหม่ที่ตำแหน่งที่ระบุโดย path (พาธ) หากไดเรกทอรีนั้นยังไม่มีอยู่ในระบบไฟล์
	     * 		 -  Directory ที่ต้องการสร้าง (dir) ห้ามมีอยู่แล้ว หากไดเรกทอรีนั้นมีอยู่แล้วจะเกิดข้อผิดพลาด FileAlreadyExistsException
	     * 		 -  Directory Parent (Parent directory) ต้องมีอยู่แล้วในระบบไฟล์ ถ้าไดเรกทอรีแม่ไม่มีอยู่จะเกิดข้อผิดพลาด NoSuchFileException
	     */
	    //ชื่อ mydir.txt ไม่เหมาะกับการสร้างไดเรกทอรี
	    //คำว่า .txt มักใช้สำหรับไฟล์ ไม่ใช่ไดเรกทอรี. ควรใช้ชื่อที่เหมาะสมกว่า เช่น "mydir".
	    Path dirPath = Paths.get("mydir.txt");
	    System.out.println(dirPath.toAbsolutePath());
	    try {
	    	Files.createDirectory(dirPath);
	    	System.out.println("3. Verzeichnis myDir.txt erzeugt");  
	    	
	    	System.out.println(dirPath);
	    	
	    	Files.delete(dirPath);
	    	System.out.println("4. Verzeichnis myDir.txt gelöscht");  
		} catch (IOException e) {
			e.printStackTrace();
		}
	   
	    System.out.println("\n--------------------------------------------------------------------------------------------");
		
	    
	    /*
	     * static Path createDirectories(Path dir, FileAttribute<?>... attrs) throws IOException
	     * 
	     * createDirectories(Path dir, FileAttribute<?>... attrs) ในคลาส Files ของ Java
	     *  ใช้สำหรับสร้างไดเรกทอรีใหม่ พร้อมทั้ง Directory Parent(ถ้ายังไม่มี) 
	     *  ในกรณีที่พาธที่ระบุไม่สามารถใช้ได้หรือไม่พบไดเรกทอรีแม่ Directory Parent
	     */
	    
	    dirPath = Paths.get("dir/subdir/subsubdir");
	    System.out.println(dirPath.toAbsolutePath());
	    try {
	    	Files.createDirectories(path);
	    	System.out.println("5. Die Struktur dir/subdir/subsubdir wurde erezugt");  
	    	   	
	    	Files.createDirectories(dirPath);
	    	System.out.println("6. Nach dem 2. Aufruf der CreateDirectories");  
	    	
	    	while (dirPath!= null) {
				Files.delete(dirPath);
				System.out.println("gelöscht : " + dirPath);
				dirPath = dirPath.getParent();
				
			}
	    	
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    System.out.println("\n--------------------------------------------------------------------------------------------");
		
	    /*
	     *  static boolean deleteIfExists(Path path) throws IOException {
	     * 		- kann einen Datei löschen
	     * 		- kann ein leers Verzeichenis  löschen (muss leer sein)
	     * 		- wirft keine Exception , wenn das Element nicht Existiert
	     * 
	     * เมธอด deleteIfExists(Path path) ในคลาส Files ของ Java 
	     * ใช้สำหรับการลบไฟล์หรือไดเรกทอรี โดยจะไม่โยนข้อผิดพลาดหากไฟล์หรือไดเรกทอรีนั้นไม่พบ
	     * 
	     * 		- ลบไฟล์: ถ้าพาธที่ระบุเป็นไฟล์ เมธอดจะลบไฟล์นั้น
	     * 		- ลบไดเรกทอรี: ถ้าพาธที่ระบุเป็นไดเรกทอรี เมธอดสามารถลบไดเรกทอรีนั้นได้ แต่จะลบได้ก็ต่อเมื่อไดเรกทอรีนั้น ว่างเปล่า (ไม่มีไฟล์หรือโฟลเดอร์อื่น ๆ อยู่ข้างใน)
	     *		- ไม่โยนข้อผิดพลาด: ถ้าไฟล์หรือไดเรกทอรีไม่พบในพาธที่ระบุ เมธอดจะไม่โยนข้อผิดพลาด แต่จะคืนค่า false แทน
	     */
	    
	    try {
			path = Paths.get("nichtda");
			System.out.println("8. path: " + path);
			
			boolean existierteUndWunrdeGeloescht = Files.deleteIfExists(path);
			System.out.println("existierte und wurde gelöscht : " 
							+ existierteUndWunrdeGeloescht);  // false
	    	
			if (existierteUndWunrdeGeloescht) {
	             System.out.println("existierte und wurde gelöschtว");
	        } else {
	             System.out.println("existierte und wurde nicht gelöscht");
	        }
			   
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    
	}

}
