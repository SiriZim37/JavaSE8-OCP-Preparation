package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class B07_Files_Attribute_getAttribute_setAttribute {

	/*
	 * Namen der Attribute : 
	 * 
	 * https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/nio/file/attribute/BasicFileAttributeView.html
	 * https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/nio/file/attribute/DosFileAttributeeView.html
	 * https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/nio/file/attribute/PosixFileAttributeeView.html
	 * 
	 * 
	 * 1.
	 * static Object getAttribute(Path path, String attribute,  LinkOption... options)  throws IOException
	 * เมธอดนี้ใช้เพื่อดึงข้อมูลคุณสมบัติของไฟล์หรือโฟลเดอร์ที่ระบุในพาธ (path).
	 * 
	 * - parameter "path": พาธของไฟล์หรือโฟลเดอร์ที่ต้องการดึงคุณสมบัติ
	 * - parameter "attribute": ระบุชื่อของคุณสมบัติที่ต้องการดึง เช่น "basic:size" สำหรับขนาดไฟล์
	 *   หรือ "basic:creationTime" สำหรับเวลาที่ไฟล์ถูกสร้าง
	 * - parameter "LinkOption... options": ตัวเลือกเพิ่มเติมที่ใช้สำหรับการติดตาม symbolic links (ลิงก์เชิงสัญลักษณ์)
	 *   เช่น "LinkOption.NOFOLLOW_LINKS" เพื่อไม่ให้ติดตาม symbolic links ที่อาจจะชี้ไปยังไฟล์หรือโฟลเดอร์อื่น
	 * 
	 * ตัวอย่าง:
	 * หากต้องการดึงขนาดของไฟล์ในพาธที่กำหนด:
	 * Boolean result = (Boolean) Files.getAttribute(path, "basic:size");
	 * 
	 * เมธอดนี้จะคืนค่าข้อมูลของคุณสมบัติตามที่ระบุ ซึ่งสามารถเป็นประเภทข้อมูลต่าง ๆ ได้ เช่น Boolean, String, หรือ FileTime ขึ้นอยู่กับชนิดของคุณสมบัติที่ดึงมา
	 * 
	 * 
	 * *********************************************************************************************************
	 * 2. 
	 * 
	 * static Path setAttribute(Path path, String attribute, Object value, LinkOption... options)  throws IOException
	 * 
	 * เมธอดนี้ใช้เพื่อปรับเปลี่ยนคุณสมบัติของไฟล์หรือโฟลเดอร์ที่ระบุในพาธ (path).
	 * 
	 * - parameter "path": พาธของไฟล์หรือโฟลเดอร์ที่ต้องการตั้งค่า
	 * - parameter "attribute": ระบุชื่อของคุณสมบัติที่ต้องการตั้งค่า เช่น "basic:creationTime" เพื่อเปลี่ยนเวลาการสร้างไฟล์
	 * - parameter "value": ค่าที่จะใช้ตั้งค่าให้กับคุณสมบัตินั้น ๆ
	 * - parameter "LinkOption... options": ตัวเลือกเพิ่มเติมสำหรับการตรวจสอบ symbolic links (เช่นเดียวกับใน getAttribute)
	 * 
	 * ตัวอย่าง:
	 * หากต้องการเปลี่ยนแปลงเวลาที่ไฟล์ถูกสร้าง:
	 * Files.setAttribute(path, "basic:creationTime", newTime);
	 * 
	 * เมธอดนี้จะทำการตั้งค่าใหม่ให้กับคุณสมบัติที่ระบุในไฟล์หรือโฟลเดอร์ที่พาธกำหนด
	 * ค่าที่ส่งเข้ามาต้องตรงกับประเภทของคุณสมบัตินั้น ๆ เช่น ถ้าเป็นเวลา, ค่าอาจจะเป็น `FileTime`
	 * 
	 */

	
	public static void main(String[] args) throws IOException {
		
		
		Path path = Paths.get("tiere.txt");
		System.out.println("path : " + path);
		
	
		// ดึงค่าคุณสมบัติ "dos:hidden" (คือการตรวจสอบว่าไฟล์ถูกตั้งให้ซ่อนไว้ใน Windows หรือไม่)
		Boolean result = (Boolean) Files.getAttribute(path, "dos:hidden");
		System.out.println("dos:hidden : " + result);

		// ตั้งค่าคุณสมบัติ "dos:hidden" ให้เป็น true (ซ่อนไฟล์)
		Files.setAttribute(path, "dos:hidden", true);
		System.out.println("dos:hidden wurde auf true gesetzt");
		
		// ดึงค่าคุณสมบัติ "dos:hidden" อีกครั้งเพื่อยืนยันการตั้งค่า
		result = (Boolean) Files.getAttribute(path, "dos:hidden");
		System.out.println("dos:hidden : " + result);
		
		// ตั้งค่าคุณสมบัติ "dos:hidden" ให้เป็น false (แสดงไฟล์)
		Files.setAttribute(path, "dos:hidden", false);
		System.out.println("dos:hidden wurde auf false gesetzt");
		
		

		DosFileAttributeView view = Files.getFileAttributeView(path, DosFileAttributeView.class);
		view.setArchive(true);
		view.setHidden(true);
		view.setReadOnly(true);
		
			
		DosFileAttributes dos = Files.readAttributes(path, DosFileAttributes.class);		
		
		System.out.println(dos.isHidden());
		System.out.println(dos.isReadOnly());
		System.out.println(dos.isArchive());
		
		
		System.out.println("\nfix back");
		view.setArchive(false);
		view.setHidden(false);
		view.setReadOnly(false);
		
	}
}
