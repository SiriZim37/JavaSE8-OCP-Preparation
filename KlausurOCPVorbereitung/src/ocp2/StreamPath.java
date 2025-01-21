package ocp2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamPath {

	public static void main(String[] args) {
		
		
	
		 Stream<Path> paths = Stream.of (Paths. get("data.doc"),
		  Paths. get("data.txt"),
		  Paths. get("data.xml"));
		 paths.filter(s-> s.toString().endsWith("txt")).forEach(
		    s -> {
		        try {
		            Files.readAllLines(s)
	
		                .stream()
		                .forEach(System.out::println); //line n1
		        } catch (IOException e) {
		            System.out.println("Exception " + e);
		        }
		    }
		 );
		 
		 /*
		 QUESTION 50
		 The data.doc, data.txt and data.xml files are accessible and contain text.
		 What is the result?
			 A. The program prints the content of data.txt file.
			 B. The program prints:
			 Exception
			 <<The content of the data.txt file>> Exception
			 C. A compilation error occurs at line n1.
			 D. The program prints the content of the three files.
		 */
		 
		 /*
		  * 
		  * 
		  * 
The correct answer is:

A. The program prints the content of the data.txt file.


		1.วิเคราะห์โค้ด:

		โค้ดใช้ Stream.of เพื่อสร้างสตรีมของพาธไฟล์ 3 ไฟล์: data.doc, data.txt, และ data.xml
		filter ถูกใช้เพื่อกรองเฉพาะไฟล์ที่ชื่อขึ้นท้ายด้วย "txt" (ซึ่งก็คือ data.txt)
		จากนั้นสำหรับแต่ละพาธที่ผ่านการกรอง:
		อ่านเนื้อหาของไฟล์โดยใช้ Files.readAllLines(s)
		เปลี่ยนข้อมูลที่อ่านได้เป็นสตรีม แล้วพิมพ์แต่ละบรรทัดโดยใช้ System.out::println
		
		2.จุดสำคัญ:
		
		การกรอง (Filter Logic): เฉพาะไฟล์ที่ชื่อจบด้วย "txt" (เช่น data.txt) ที่ผ่านเงื่อนไขการกรอง
		อ่านและพิมพ์เนื้อหา: เนื้อหาใน data.txt จะถูกอ่านและพิมพ์ออกมา
		ไม่มีข้อผิดพลาดในการคอมไพล์: โค้ดที่บรรทัด n1 ถูกต้อง เนื่องจาก Files.readAllLines คืนค่าเป็น List<String> ที่สามารถแปลงเป็นสตรีมได้
		
		3.การจัดการข้อยกเว้น (Exception Handling):

		หากเกิด IOException (เช่น ไฟล์ data.txt เข้าถึงไม่ได้) จะพิมพ์คำว่า "Exception"
		แต่คำถามระบุว่าไฟล์ทั้งหมดเข้าถึงได้ ดังนั้นจะไม่มีข้อยกเว้นเกิดขึ้น
		ผลลัพธ์:
		
		4.โปรแกรมจะอ่านและพิมพ์เนื้อหาของไฟล์ data.txt ไปยังคอนโซล
		  */
	}
}
