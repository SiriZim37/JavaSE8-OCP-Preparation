package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;


public class B06_Files_Attribute_Shortcuts {
	/*
	 * BasicFileAttributes
	 * 
	 * https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/nio/file/attribute/BasicFileAttributes.html
	 * https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/nio/file/attribute/DosFileAttributes.html
	 * https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/nio/file/attribute/PosixFileAttributes.html
	 * 
	 * oder 
	 * https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/nio/file/attribute/BasicFileAttributeView.html
	 * https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/nio/file/attribute/DosFileAttributeeView.html
	 * https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/nio/file/attribute/PosixFileAttributeeView.html
	 * 
	 * 
	 * BasicFileAttributes >
	 * 		เป็นอินเทอร์เฟซใน Java ที่ใช้สำหรับดึงข้อมูลพื้นฐานเกี่ยวกับไฟล์ในระบบไฟล์
	 * 		เช่น เวลาในการสร้างไฟล์, เวลาในการแก้ไขล่าสุด, ขนาดของไฟล์, และประเภทของไฟล์ (เช่น เป็นไฟล์ปกติหรือไม่)
	 * 		โดยไม่คำนึงถึงประเภทของระบบไฟล์ที่ใช้งาน (Windows, Linux, หรือ macOS)
	 *
	 * 		คุณสมบัติของ BasicFileAttributes:
	 * 		- creationTime(): คืนเวลาเมื่อไฟล์ถูกสร้าง
	 *		- lastAccessTime(): คืนเวลาเมื่อไฟล์ถูกเข้าถึงครั้งล่าสุด
	 *		- lastModifiedTime(): คืนเวลาเมื่อไฟล์ถูกแก้ไขครั้งล่าสุด
	 *		- size(): คืนขนาดของไฟล์ในหน่วยไบต์
	 * 		- isDirectory(): ตรวจสอบว่าไฟล์เป็นไดเรกทอรีหรือไม่
	 * 		- isRegularFile(): ตรวจสอบว่าไฟล์เป็นไฟล์ปกติหรือไม่
	 * 		- isSymbolicLink(): ตรวจสอบว่าไฟล์เป็นลิงค์เชิงสัญลักษณ์ (symbolic link) หรือไม่
	 * 		- isOther(): ตรวจสอบว่าไฟล์เป็นประเภทอื่น ๆ (เช่น pipe, socket, หรืออื่น ๆ)
	 * 
	 * DosFileAttributes  > 
	 * 		ใช้เพื่อดึงข้อมูลเกี่ยวกับไฟล์ในระบบไฟล์แบบ DOS หรือ FAT (เช่น ใน Windows)
	 *      ข้อมูลที่สามารถดึงได้จะเกี่ยวข้องกับคุณสมบัติของไฟล์ในระบบ DOS เช่น "readonly", "hidden",
	 * 		อินเทอร์เฟซนี้รองรับในระบบปฏิบัติการ Windows ที่ใช้ระบบไฟล์ FAT หรือ NTFS
	 * 		
	 * 		คุณสมบัติหลักของ DosFileAttributes:
	 * 		- isReadOnly(): ตรวจสอบว่าไฟล์เป็นแบบอ่านอย่างเดียว (readonly) หรือไม่
	 * 		- isHidden(): ตรวจสอบว่าไฟล์เป็นไฟล์ที่ซ่อนอยู่ (hidden) หรือไม่
	 * 		- isArchive(): ตรวจสอบว่าไฟล์มีสถานะเป็นไฟล์ที่สามารถเก็บ (archive) หรือไม่
	 *		- isSystem(): ตรวจสอบว่าไฟล์เป็นไฟล์ระบบ (system) หรือไม่
	 * 		- PosixFileAttributes> Linux
	 * 
	 * PosixFileAttributes > 
	 * 			ใช้เพื่อดึงข้อมูลเกี่ยวกับไฟล์ในระบบไฟล์แบบ POSIX (เช่น UNIX, Linux, macOS)
	 * 			ข้อมูลที่สามารถดึงได้จะเกี่ยวข้องกับคุณสมบัติของไฟล์ในระบบ POSIX เช่น "permissions", "owner", "group", และ "lastModifiedTime"
	 * 			อินเทอร์เฟซนี้รองรับในระบบปฏิบัติการที่ใช้ระบบไฟล์แบบ POSIX เช่น Linux และ macOS
	 * 
	 * 			คุณสมบัติหลักของ PosixFileAttributes:
	 *  		- permissions(): คืนค่า permissions (สิทธิ์การเข้าถึง) ของไฟล์ (เช่น rwx)
	 *  		- owner(): คืนค่าผู้เป็นเจ้าของไฟล์ (user owner)
	 * 			- group(): คืนค่ากลุ่มที่เป็นเจ้าของไฟล์
	 *  		- lastModifiedTime(): เวลาแก้ไขไฟล์ล่าสุด
	 *  		- creationTime(): เวลาในการสร้างไฟล์
	 *  		- isRegularFile(): ตรวจสอบว่าไฟล์เป็นไฟล์ปกติหรือไม่
	 */


	
	
	public static void main(String[] args) {

		testShorcuts(Paths.get("nichtda"));
		
		System.out.println("\n-------------------------------------------------------------------------");
		
		testShorcuts(Paths.get("mydir"));
		
		System.out.println("\n-------------------------------------------------------------------------");

		testShorcuts(Paths.get("autos.txt"));
		
		System.out.println("\n-------------------------------------------------------------------------");

		testShorcuts(Paths.get("mydir2"));
		
	}
	
	/*
	 * 1. 
	 * static boolean isDirectory(Path path, LinkOption... options) 
	 * 
	 * เมธอดนี้ในคลาส Files ใช้เพื่อตรวจสอบว่าเส้นทาง (Path) ที่กำหนดเป็นโฟลเดอร์หรือไม่ 
	 * โดยจะส่งค่าผลลัพธ์เป็น true หากพาธนั้นเป็นโฟลเดอร์ และ false หากไม่ใช่โฟลเดอร์
	 * 
	 * - Path path: พาธที่ต้องการตรวจสอบว่าเป็นโฟลเดอร์หรือไม่
	 * - LinkOption... options: ตัวเลือกที่ใช้สำหรับการตรวจสอบเกี่ยวกับ symbolic links (การเชื่อมโยงสัญลักษณ์) เช่น 
	 *   LinkOption.NOFOLLOW_LINKS หากต้องการไม่ให้ติดตาม symbolic links ที่อาจจะชี้ไปยังโฟลเดอร์หรือไฟล์อื่น
	 * ****************************************************************************************
	 * 2. static boolean isRegularFile(Path path, LinkOption... options) 
	 * 
	 * เมธอดนี้ใช้เพื่อตรวจสอบว่าเส้นทาง (Path) ที่กำหนดเป็นไฟล์ปกติหรือไม่ 
	 * โดยจะส่งค่าผลลัพธ์เป็น true หากเป็นไฟล์ปกติ และ false หากเป็นไดเรกทอรีหรือประเภทอื่น
	 * 
	 * - Path path: พาธที่ต้องการตรวจสอบว่าเป็นไฟล์ปกติหรือไม่
	 * - LinkOption... options: ตัวเลือกที่ใช้สำหรับการตรวจสอบ symbolic links
	 * 
	 * **************************************************************************************** 
	 * 3. static boolean isHidden(Path path) throws IOException
	 * 
	 * เมธอดนี้ใช้เพื่อตรวจสอบว่าไฟล์หรือโฟลเดอร์ที่กำหนดเป็นไฟล์ซ่อน (hidden) หรือไม่ 
	 * เช่นไฟล์ที่มีจุด (.) นำหน้าใน Linux/Unix 
	 * โดยจะส่งค่าผลลัพธ์เป็น true หากไฟล์หรือโฟลเดอร์นั้นเป็นไฟล์ซ่อน และ false หากไม่ใช่ไฟล์ซ่อน
	 * 
	 * ****************************************************************************************
	 * 4. static long size(Path path) throws IOException 
	 * 
	 * เมธอดนี้ใช้เพื่อดึงขนาดของไฟล์หรือโฟลเดอร์ในพาธที่กำหนด โดยจะคืนค่าขนาดเป็นจำนวนไบต์
	 * หากพาธที่ให้มาเป็นไดเรกทอรี จะเกิดข้อยกเว้น IOException เนื่องจากไม่สามารถวัดขนาดของไดเรกทอรีได้โดยตรง
	 * 
	 * ****************************************************************************************
	 * 5. static FileTime getLastModifiedTime(Path path, LinkOption... options) throws IOException
	 * 
	 * เมธอดนี้ใช้เพื่อดึงเวลาที่ไฟล์หรือโฟลเดอร์ถูกแก้ไขครั้งล่าสุด 
	 * ค่าผลลัพธ์ที่ได้จะเป็นประเภท FileTime ซึ่งแสดงเวลาในการแก้ไขไฟล์
	 * หากเกิดข้อผิดพลาดในการเข้าถึงไฟล์จะโยนข้อยกเว้น IOException
	 */


	
	static void testShorcuts(Path path) {
		System.out.println("\n***");
		System.out.println("path: " + path);
		
		  // ตรวจสอบว่า path เป็นโฟลเดอร์หรือไม่
	    boolean result = Files.isDirectory(path);
	    System.out.println("1. path : " + path);
	    System.out.println("1. isDirectory : " + result);  // false

	    // ทดสอบ path ที่เป็นโฟลเดอร์
	    path = Paths.get("mydir");
	    result = Files.isDirectory(path);
	    System.out.println("2. path : " + path);
	    System.out.println("2. isDirectory : " + result);  // true

	    /**********************************************************************/

	    // ทดสอบว่า path เป็นไฟล์ปกติหรือไม่
	    result = Files.isRegularFile(path);
	    System.out.println("3. isRegularFile : " + result);  // false (ถ้า mydir เป็นไดเรกทอรี)

	    /**********************************************************************/

	    try {
	        // ตรวจสอบว่า path เป็นไฟล์ซ่อนหรือไม่
	        result = Files.isHidden(path);
	        System.out.println("4. isHidden : " + result);  
	    } catch (Exception e) {
	        System.out.println("4. isHidden hat IOExeption geworfen : " + e.getMessage());
	    }

	    /**********************************************************************/

	    try {
	        // ดึงขนาดของ path
	        long size = Files.size(path);
	        System.out.println("5. size : " + size);  
	    } catch (Exception e) {
	    	System.out.println("size hat IOException geworfen: " + e.getMessage());
	    }

		try {
			FileTime time = Files.getLastModifiedTime(path);
			System.out.println("getLastModifiedTime: " + time);
		} catch (IOException e) {
			System.out.println("getLastModifiedTime hat IOException geworfen: " + e.getMessage());
		}
	}
	

}
