package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class B09_Files_lines_readAllLines {
	/*
	 * Exam!
	 */
	public static void main(String[] args) {

		Path file = Paths.get("autos.txt");


		System.out.println("\n*** lines");
		/* 
		 * static Stream<String> lines(Path path) throws IOException
		 * 
		 * เมธอดในคลาส Files ของ Java NIO (New I/O) ที่ใช้ในการอ่านข้อมูลจากไฟล์และคืนค่าเป็น Stream<String>
		 * โดยจะทำการอ่านไฟล์แบบ "lazy" ซึ่งแต่ละบรรทัดในไฟล์จะเป็นสมาชิกของ Stream นั้น
		 * 
		 * Important: Always close the Stream when done using try-with-resources to avoid resource leaks.
         * ควรปิด Stream เมื่อใช้เสร็จโดยใช้ try-with-resources เพื่อหลีกเลี่ยงการรั่วไหลของทรัพยากร
		 */
		
		
		
		//   Files.lines(file); 	// Stream<String>
		try (Stream<String> lines = Files.lines(file)) {
			
			lines.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		System.out.println("\n*** readAllLines");
		
		/*
		 * static List<String> readAllLines(Path path) throws IOException
		 * 
		 * The 'readAllLines' method reads all lines from a file into a List of Strings.
		 * 
		 * เมธอด 'readAllLines' ใช้ในการอ่านไฟล์ทั้งหมดและเก็บบรรทัดต่างๆ ลงใน List<String>
         * ซึ่งต่างจาก 'lines()' ที่จะอ่านไฟล์ทีละบรรทัด โดยเมธอดนี้จะโหลดข้อมูลทั้งไฟล์เข้าไปในหน่วยความจำในครั้งเดียว
         * เหมาะสำหรับไฟล์ขนาดเล็กหรือกรณีที่ต้องการเข้าถึงข้อมูลทุกบรรทัดพร้อมกัน (เช่น การประมวลผลไฟล์ทั้งหมดในหน่วยความจำ)
		 * 
		 */
		//  Files.readAllLines(file); 	// List <String>
		try {
			
			List<String> lines = Files.readAllLines(file);
			
			lines.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
