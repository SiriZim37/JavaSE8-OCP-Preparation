package ocp2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*
 QUESTION 77
	 Given that /green.txt and /colors/yellow.txt are accessible, and the code fragment:
	 Path source = Paths.get(“/green.txt);
	 Path target = Paths.get(“/colors/yellow.txt);
	 Files.move(source, target, StandardCopyOption.ATOMIC_MOVE);
	 Files.delete(source);
	 
	 Which statement is true?
	 A. The green.txt file content is replaced by the yellow.txt file content and the yellow.txt file is deleted.
	 B. The yellow.txt file content is replaced by the green.txt file content and an exception is thrown.
	 C. The file green.txt is moved to the /colors directory.
	 D. A FileAlreadyExistsException is thrown at runtime.
 */
public class PathFilesMoveAndDelete {

	public static void main(String[] args) throws IOException {

		Path source = Paths.get("data2/green.txt");
		Path target = Paths.get("data2/colors/yellow.txt");
//		Files.move(source, target); 	// Exception :  java.nio.file.FileAlreadyExistsException: data2\colors\yellow.txt
		Files.move(source, target, StandardCopyOption.ATOMIC_MOVE);
		Files.delete(source);  	// > Exception :  java.nio.file.NoSuchFileException: data2\green.txt

	}
	
	/*
	 วิเคราะห์โค้ด:

	การทำงานของโค้ดทีละบรรทัด:
	Files.move(source, target, StandardCopyOption.ATOMIC_MOVE);
	
	โค้ดนี้พยายามย้ายไฟล์ /green.txt ไปยัง /colors/yellow.txt โดยใช้ตัวเลือก StandardCopyOption.ATOMIC_MOVE 
	ซึ่งทำให้การย้ายไฟล์เกิดขึ้นแบบ "อะตอมมิก" (สำเร็จทั้งหมดหรือไม่สำเร็จเลย).
	
	อย่างไรก็ตาม:
	ถ้าระบบไฟล์ ไม่รองรับ ATOMIC_MOVE:
	ระบบจะใช้การย้ายแบบปกติแทน และในกรณีนี้ เนื้อหาไฟล์ /green.txt จะไปแทนที่เนื้อหาใน /colors/yellow.txt.
	ถ้าระบบไฟล์ รองรับ ATOMIC_MOVE และไม่อนุญาตให้เขียนทับไฟล์ปลายทางที่มีอยู่ (/colors/yellow.txt), จะเกิด FileAlreadyExistsException.
	
	Files.delete(source);
	
	บรรทัดนี้พยายามลบไฟล์ต้นทาง (/green.txt).
	ถ้าไฟล์ต้นทางถูกย้ายสำเร็จ (เนื้อหาไปอยู่ใน /colors/yellow.txt แล้ว), ไฟล์ /green.txt จะไม่อยู่ในตำแหน่งเดิม ทำให้เกิดข้อผิดพลาด NoSuchFileException.
	
	ทำไมคำตอบคือ B:
	หากระบบไฟล์ไม่รองรับ ATOMIC_MOVE:
	ไฟล์ /green.txt จะถูกย้ายไปแทนที่ /colors/yellow.txt (เนื้อหาของ green.txt จะไปแทนที่เนื้อหาของ yellow.txt).
	เมื่อถึงบรรทัด Files.delete(source);, จะเกิด ข้อผิดพลาด (exception) เพราะไฟล์ /green.txt ไม่อยู่ในตำแหน่งเดิมแล้ว.
	ดังนั้นลำดับเหตุการณ์จึงตรงกับคำตอบ B:
	
	"เนื้อหาไฟล์ yellow.txt ถูกแทนที่ด้วย green.txt และเกิด exception."
	 */
}
