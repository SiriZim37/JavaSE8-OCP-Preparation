package ocp2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IONIOCopyPaths {

	public static void main(String[] args) throws IOException {
		Path source = Paths.get("/data/december/log.txt");
		Path destination = Paths.get("/data");
		Files.copy(source, destination);

		
		// ??????????????????????
		/*
		ทำไมถึงทำงานไม่ได้
		destination ที่ระบุเป็นไดเรกทอรี (/data) แต่ Files.copy ไม่สามารถสรุปชื่อไฟล์จากต้นทางได้เองในกรณีนี้
		หากไม่ได้ระบุชื่อไฟล์ในเส้นทางปลายทาง ระบบจะโยนข้อผิดพลาด เช่น FileAlreadyExistsException หรือข้อผิดพลาดที่เกี่ยวข้อง ขึ้นอยู่กับสถานการณ์
		
		วิธีแก้ไขที่ถูกต้อง
		หากต้องการคัดลอกไฟล์ไปยังไดเรกทอรี /data และใช้ชื่อไฟล์เดิมจากต้นทาง (log.txt):
		

		Files.copy(source, destination.resolve(source.getFileName()));
		คำอธิบาย:
		
		source.getFileName() จะคืนค่าเฉพาะชื่อไฟล์ (log.txt)
		destination.resolve(source.getFileName()) จะสร้างเส้นทางปลายทางที่สมบูรณ์ เช่น /data/log.txt
		 *
		 */

	}
}
