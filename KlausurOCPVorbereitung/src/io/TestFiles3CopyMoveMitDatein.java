package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;



public class TestFiles3CopyMoveMitDatein {

	/*
	 * 1. Non-empty Directory กับ Files.delete
		 ทำไม่ได้โดยตรง:
		 Files.delete(Path) จะลบได้เฉพาะไฟล์หรือไดเรกทอรีที่ ว่างเปล่า เท่านั้น
		 ถ้าเป็นไดเรกทอรีที่ไม่ว่าง (non-empty directory) จะเกิดข้อผิดพลาด DirectoryNotEmptyException
		 ทางแก้ไข: ต้องลบไฟล์ภายในไดเรกทอรีก่อนด้วยการใช้ Files.walkFileTree เพื่อเดินผ่านไฟล์ทั้งหมด แล้วลบทีละไฟล์
		 
	   2. Non-empty Directory กับ Files.copy
		 ทำไม่ได้โดยตรง:
		 Files.copy(Path source, Path target) รองรับการคัดลอกเฉพาะไฟล์เดี่ยวๆ หรือไดเรกทอรีที่ไม่ว่างจะถูกคัดลอกได้เฉพาะโครงสร้างเปล่าๆ
		 มันจะไม่คัดลอกเนื้อหาภายในของไดเรกทอรีที่ไม่ว่างโดยอัตโนมัติ
		 ทางแก้ไข:
		 ใช้ Files.walkFileTree เพื่อคัดลอกไฟล์ทีละไฟล์ในไดเรกทอรี
	   3. Non-empty Directory กับ Files.move
		 ทำได้:
		 Files.move(Path source, Path target) รองรับการย้ายไดเรกทอรีที่ไม่ว่างพร้อมกับเนื้อหาภายในไปยังตำแหน่งใหม่
		 เนื้อหาทั้งหมด (รวมไฟล์และไดเรกทอรีย่อย) จะถูกย้ายไปยังตำแหน่งเป้าหมาย
		 
		 สรุปพฤติกรรม:
		การทำงาน				ไฟล์/ไดเรกทอรีว่าง			ไดเรกทอรีไม่ว่าง
		Files.delete		✅ ลบได้				❌ ลบไม่ได้ (DirectoryNotEmptyException)
		Files.copy			✅ คัดลอกได้			❌ คัดลอกได้เฉพาะโครงสร้างเปล่า
		Files.move			✅ ย้ายได้				✅ ย้ายได้ทั้งโครงสร้างและเนื้อหา
	 */
	public static void main(String[] args) throws IOException {
		TestUtils.deleteIfExits(Paths.get("mydata"));
		
		Path dir1 = TestUtils.createNoneemptyTestDir("dir1");
		System.out.println("dir1: " + dir1);
		
		Path source = Paths.get("mydata/dir1/file0.txt");
		
		Path target = Paths.get("mydata");	// falsch : การคัดลอกไฟล์ไปยังโฟลเดอร์โดยไม่มีชื่อไฟล์ใหม่ใน target จะทำให้เกิดข้อผิดพลาด.

		/*
		 * Java จะไม่อนุญาตให้คัดลอกไฟล์ไปยังไดเรกทอรีโดยไม่มีการระบุชื่อไฟล์เป้าหมายใน target.
		 * จะเกิดข้อผิดพลาด FileAlreadyExistsException หรือข้อผิดพลาดเกี่ยวกับ Path.
		 */
		try {
			Files.copy(source, target);
		} catch (FileAlreadyExistsException e) {
			System.out.println("a. Falsch! Exception: " + e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * พยายามย้ายไฟล์ file0.txt ไปยัง mydata.
		 * Files.copy การย้ายไฟล์ไปยังไดเรกทอรีโดยไม่มีชื่อไฟล์ใหม่ใน target จะทำให้เกิดข้อผิดพลาด.
		 */
		try {
			Files.move(source, target);
		} catch (FileAlreadyExistsException e) {
			System.out.println("b. Falsch! Exception: " + e);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		/*
		 * Richtig: target-Pfad soll den den neuen Dateinamen auch beinhalten
		 */
		/*
		 * เป้าหมายใหม่ (target):
			ตั้งค่า target ให้เป็นไฟล์ใหม่ fileA.txt ในโฟลเดอร์ mydata.
			คัดลอกไฟล์อีกครั้ง:
			
			คำสั่ง Files.copy(source, target) ทำงานสำเร็จ.
			ไฟล์ file0.txt ถูกคัดลอกเป็น fileA.txt.
			พิมพ์ข้อความยืนยัน:
			
			หากคัดลอกสำเร็จ จะพิมพ์ข้อความ "c. Datei kopiert".
		 */
		target = Paths.get("mydata/fileA.txt"); // richtig

		try {
			Files.copy(source, target);
			
			System.out.println("c. Datei kopiert");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		target = Paths.get("mydata/fileB.txt"); // richtig
		try {
			source = Paths.get("mydata/dir1/file1.txt");
			Files.move(source, target);
			
			System.out.println("d. Datei kopiert");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
}
