package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.concurrent.TimeUnit;

public class B08_Files_Atribute_mehrereAufEinmal {

	/*
	 * 					 BasicFileAttributes
	 * 							  |
	 * 					---------------------
	 * 					|				    |
	 * 		DosFileAttributes        	 PosixFileAttributes
	 * 
	 *   ในแผนภาพข้างต้น BasicFileAttributes เป็นคลาสหลักที่ใช้จัดการกับคุณสมบัติของไฟล์ในระบบไฟล์
	 *   โดย DosFileAttributes และ PosixFileAttributes เป็นคลาสลูกที่ใช้จัดการคุณสมบัติที่เฉพาะเจาะจง
	 *   สำหรับระบบไฟล์ DOS และ POSIX ตามลำดับ
	 * 
	 * 					BasicFileAttributeView
	 * 							|
	 * 					---------------------
	 * 					|				    |
	 * 		DosFileAttributeView  	    PosixFileAttributeView
	 */

	/*
	 * static <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> type, LinkOption... options) throws IOException
	 * 
	 * เมธอดนี้ในคลาส Files ใช้เพื่อดึงข้อมูลคุณสมบัติ (attributes) ของไฟล์หรือโฟลเดอร์จากพาธที่กำหนด 
	 * โดยสามารถเลือกประเภทของคุณสมบัติที่ต้องการดึงมาได้ เช่น
	 * - ข้อมูลพื้นฐานของไฟล์ (ผ่าน BasicFileAttributes)
	 * - ข้อมูลที่เกี่ยวข้องกับระบบไฟล์บางประเภท เช่น 
	 *   - DosFileAttributes สำหรับ DOS
	 *   - PosixFileAttributes สำหรับระบบที่รองรับ POSIX
	 * 
	 * พารามิเตอร์:
	 * - path: พาธของไฟล์หรือโฟลเดอร์ที่เราต้องการดึงข้อมูลคุณสมบัติ
	 * - type: เป็นคลาสที่ใช้ระบุประเภทของคุณสมบัติที่ต้องการดึง
	 *   ตัวอย่างเช่น BasicFileAttributes.class, DosFileAttributes.class, หรือ PosixFileAttributes.class
	 * - options: ตัวเลือกเสริมที่สามารถใช้ในการจัดการกับ symbolic links
	 *   เช่น LinkOption.NOFOLLOW_LINKS ที่จะไม่ติดตาม symbolic links
	 */

	/*
	 * static <V extends FileAttributeView> V getFileAttributeView(Path path, Class<V> type, LinkOption... options)
	 * 
	 * เมธอดนี้ในคลาส Files ใช้สำหรับดึงข้อมูลของ FileAttributeView ที่เกี่ยวข้องกับไฟล์หรือโฟลเดอร์
	 * ที่ระบุในพาธตามประเภทที่กำหนด
	 * ซึ่งสามารถใช้เพื่อเข้าถึงข้อมูลคุณสมบัติของไฟล์ในระบบไฟล์ที่รองรับได้
	 * 
	 * พารามิเตอร์:
	 * - path: พาธของไฟล์หรือโฟลเดอร์ที่ต้องการดึงข้อมูลคุณสมบัติ
	 * - type: คลาสที่ใช้สำหรับกำหนดประเภทของ FileAttributeView ที่ต้องการดึงข้อมูล
	 *   เช่น BasicFileAttributeView.class, DosFileAttributeView.class, หรือ PosixFileAttributeView.class
	 * - options: ตัวเลือกเสริมสำหรับการจัดการกับ symbolic links
	 *   เช่น LinkOption.NOFOLLOW_LINKS เพื่อไม่ติดตาม symbolic links
	 */

	
	/*
	 
	 BasicFileAttributeView
		Name	Type
		"lastModifiedTime"	FileTime
		"lastAccessTime"	FileTime
		"creationTime"	FileTime
		"size"	Long
		"isRegularFile"	Boolean
		"isDirectory"	Boolean
		"isSymbolicLink"	Boolean
		"isOther"	Boolean
		"fileKey"	Object

	 DosFileAttributeView
		Name	Type
		readonly	Boolean
		hidden	Boolean
		system	Boolean
		archive	Boolean


	PosixFileAttributeView
		Name	Type
		"permissions"	Set<PosixFilePermission>
		"group"	GroupPrincipal


	 */
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("autos-kopie.txt");

		// ใช้ดึง BasicFileAttributes จากไฟล์ที่ระบุใน path
		BasicFileAttributes b1 = Files.readAttributes(path, BasicFileAttributes.class); // Basic <- IS-A <- Basic

		// จะเกิด Exception: UnsupportedOperationException หากพยายามใช้กับระบบที่ไม่รองรับ
		BasicFileAttributes b2 = Files.readAttributes(path, DosFileAttributes.class);   // Basic <- IS-A <- Dos : Exception auf einem Linux-Rechner

		// ใช้ดึงข้อมูล PosixFileAttributes ซึ่งจะเกิด Exception หากใช้ใน Windows
		try {
			BasicFileAttributes b3 = Files.readAttributes(path, PosixFileAttributes.class); // Basic <- IS-A <- Pos : Exception auf einem Windows-Rechner
		} catch (Exception e) {
			System.out.println("Fehler! Keine Posix-Attribute unter Windows! " + e );
		}

		// cf: Dos <- IST-KEIN <- Basic
//		DosFileAttributes b4 = Files.readAttributes(path, BasicFileAttributes.class);
		
		// cf: Dos <- IST-KEIN <- Posix
//		DosFileAttributes b5 = Files.readAttributes(path, PosixFileAttributes.class);
		
		/**********************************************************************************************************/
		
		// ตัวอย่างการใช้ getFileAttributeView เพื่อดึงข้อมูลจากไฟล์ที่ระบุ
		BasicFileAttributeView v1 = Files.getFileAttributeView(path, BasicFileAttributeView.class); // Basic <- IS-A <- Basic

		// cf: Dos <- IST-KEIN <- Posix
//		DosFileAttributeView v2 = Files.getFileAttributeView(path, PosixFileAttributeView.class);
		
		// จะลองดึง DosFileAttributeView และ PosixFileAttributeView
		// คำถาม: จะทำงานได้หรือไม่? ขึ้นอยู่กับระบบปฏิบัติการ
		BasicFileAttributeView v2 = Files.getFileAttributeView(path, DosFileAttributeView.class);   // Basic <- IS-A <- Dos ???
		BasicFileAttributeView v3 = Files.getFileAttributeView(path, PosixFileAttributeView.class); // Basic <- IS-A <- Pos ???
		
		
		/**********************************************************************************************************/
		// การดึงข้อมูลการแก้ไขไฟล์ (LastModified, LastAccessed, และ Creation Time)
		FileTime lastModifiedTime = null;
		FileTime lastAccessTime = null;
		FileTime creationTime = FileTime.from(0, TimeUnit.MILLISECONDS); // 1.1.1970

		// การตั้งเวลาในไฟล์
		v1.setTimes(lastModifiedTime, lastAccessTime, creationTime);
		
		System.out.println("b1: "+ b1.lastAccessTime());
		System.out.println("b2: "+ b2);
		System.out.println("v1: "+ v1);
		System.out.println("v2: "+ v2);
		System.out.println("v1: "+ v1.readAttributes().lastAccessTime());
	}
}
