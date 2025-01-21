package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestFiles1Copy {

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
		
		Path dir1 = TestUtils.createNoneemptyTestDir("dir1");
		
		Path dir2 = Paths.get("mydata/dir2");
		
		Files.copy(dir1, dir2 , StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Kopiert");
		
	}
}
