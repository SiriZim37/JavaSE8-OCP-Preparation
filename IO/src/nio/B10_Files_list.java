package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class B10_Files_list {

	/*
	 * static Stream<Path> list(Path dir) throws IOException
	 * 
	 * เมธอด list(Path dir) คือเมธอดในคลาส Files ของ Java NIO ที่ใช้ในการดึงรายการของไฟล์และไดเร็กทอรีที่อยู่ในพาธที่กำหนด (ในที่นี้คือ dir) 
	 * และคืนค่าผลลัพธ์เป็น Stream<Path> ซึ่งประกอบไปด้วยพาธของไฟล์และไดเร็กทอรีในไดเร็กทอรีที่กำหนด
	 * 
	 * - static: เมธอดนี้เป็นเมธอดสแตติก (ไม่จำเป็นต้องสร้างอ็อบเจ็กต์ของคลาสเพื่อเรียกใช้)
	 * - Stream<Path>: ผลลัพธ์ที่คืนค่าจะเป็นสตรีมของ Path โดยแต่ละสมาชิกในสตรีมจะเป็นพาธของไฟล์หรือไดเร็กทอรีในไดเร็กทอรีที่กำหนด
	 * - Path dir: พารามิเตอร์ที่รับพาธของไดเร็กทอรีที่ต้องการดึงข้อมูล
	 * - throws IOException: ระบุว่าเมธอดนี้อาจเกิดข้อผิดพลาดที่เกี่ยวกับการเข้าถึงไฟล์หรือไดเร็กทอรี เช่น ไฟล์ไม่พบ หรือไม่สามารถเปิดได้
	 */

	public static void main(String[] args) {

		System.out.println("*** Items aus dem Verzeichnis src : ");
		
		Path dir = Paths.get("src");
		
		try (Stream<Path> s = Files.list(dir)) {
			//s.filter(Files::isRegularFile)
			s.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n*** Items aus dem aktuelle Arbeitsvrzeichnis src : ");

		dir = Paths.get(".");
		
		try (Stream<Path> s = Files.list(dir)) {
			
			s.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
