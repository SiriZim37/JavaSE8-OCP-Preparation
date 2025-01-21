package io;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

public class TestUtils {

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
	/**
	 * Erzeugt im Projektverzeichnis im Unterverzeichnis 'mydata'
	 * das neue Verzeichnis mit dem gewünschten Namen.
	 * In dem Verzeichnis werden zwei Textdateien erzeugt.
	 */
	/**
	 * 1. เมธอด createNoneemptyTestDir
		ใช้สำหรับสร้างไดเรกทอรีที่ไม่ว่างในโฟลเดอร์ mydata พร้อมสร้างไฟล์ตัวอย่างข้างใน
		ขั้นตอนการทำงาน:
		สร้าง Path สำหรับไดเรกทอรีต้นทาง (root) และไดเรกทอรีเป้าหมาย (dir).
		ตรวจสอบว่ามีไดเรกทอรีเป้าหมายอยู่แล้วหรือไม่:
		ถ้ามี ให้ลบทิ้ง (deleteIfExits).
		สร้างไดเรกทอรีใหม่ด้วย Files.createDirectories.
		เขียนไฟล์ตัวอย่าง 2 ไฟล์ในไดเรกทอรีที่สร้างขึ้น โดยแต่ละไฟล์มีข้อมูล line1, line2, line3.
		คืนค่าที่ตั้งของไดเรกทอรีที่สร้างขึ้น.
	 * @param dirName
	 * @return
	 * @throws IOException
	 */
	static Path createNoneemptyTestDir(String dirName) throws IOException{
		
		Path root = Paths.get("mydata");
		
		try{
			
			Path dir = root.resolve(dirName);   // create path for files
			
			deleteIfExits(dir);    				// checked first that files exits and delete
			
			Files.createDirectories(dir);
		
			List<String> lines = Arrays.asList("line1", "line2","line3");
			
			for (int i = 0; i < 2; i++) {
				Path file = dir.resolve("file" + i + ".txt");
				Files.write(file, lines);
			}
			return dir;
		}catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	/**
	 * 2. เมธอด copyDeep
		ใช้คัดลอกไดเรกทอรีและไฟล์ทั้งหมดในแบบลึก (deep copy).
		ขั้นตอนการทำงาน:
		ตรวจสอบว่า Path ต้นทาง (sourceDir) เป็นไดเรกทอรี.
		สร้างไดเรกทอรีปลายทาง (targetDir) หากยังไม่มี.
		สามารถเพิ่มโค้ดเพิ่มเติม (เช่น Files.walkFileTree) เพื่อคัดลอกไฟล์ทีละไฟล์.
	 * @param sourceDir
	 * @param targetDir
	 * @throws IOException
	 */
//	static void copyDeep(Path sourceDir, Path targetDir) {
//	if(!Files.isDirectory(sourceDir)) {
//		throw new IllegalArgumentException("es mus ein Verzeichnis sein: " + sourceDir);
//	}
//	
//	Files.createDirectories(targetDir);
//	
//	//...
//}
	
	
	/**
	 * 3. เมธอด deleteIfExits
		ใช้ลบไดเรกทอรี (รวมไฟล์และไดเรกทอรีย่อย) โดยการเดินผ่านไฟล์ทั้งหมดในโฟลเดอร์นั้น.
		ขั้นตอนการทำงาน:
		ตรวจสอบว่า Path เป็นไดเรกทอรีหรือไม่.
		ใช้ Files.walkFileTree ร่วมกับ SimpleFileVisitor:
		ลบไฟล์ทีละไฟล์ (visitFile).
		ลบไดเรกทอรีหลังจากไฟล์ทั้งหมดถูกลบ (postVisitDirectory).
	 * @param dir
	 */
	static void deleteIfExits(Path dir) {
		if(!Files.isDirectory(dir)) {
			return;
		}		
		FileVisitor<Path> visitor = new SimpleFileVisitor<Path>(){
			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				Files.delete(dir); // ลบไดเรกทอรีย่อย
				return FileVisitResult.CONTINUE;  // ดำเนินการกับไฟล์ถัดไป
			}
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				Files.delete(file); // ลบไฟล์
				return FileVisitResult.CONTINUE;  // ดำเนินการกับโฟลเดอร์ถัดไป
			}
		};
		
		try {
			Files.walkFileTree(dir, visitor);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		
		
	}
}
