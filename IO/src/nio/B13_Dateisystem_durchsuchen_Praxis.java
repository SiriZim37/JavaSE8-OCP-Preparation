package nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B13_Dateisystem_durchsuchen_Praxis {

	/*
	 * Nicht prüfungrelevant
	 */
	
	public static void main(String[] args) {
		mitWalk();
		mitWalkFileTree();
	}
	
	static void mitWalkFileTree() {
		/*
		 * Aufgabe: Anzahl der Dateien (rekursiv) ermitteln คำนวณจำนวนไฟล์ (แบบเรียกซ้ำ)
		 */
		
		/*
		 * เมธอดในคลาส Files ของ Java สำหรับการสำรวจไฟล์และไดเร็กทอรีแบบลึก (recursive traversal) 
		 * เริ่มจากพาธที่กำหนด โดยใช้ FileVisitor เพื่อกำหนดการกระทำเมื่อพบไฟล์หรือไดเร็กทอรี
		 * 
		 * การใช้งาน:
		 * Path start: พาธเริ่มต้นสำหรับการสำรวจไดเร็กทอรี
		 * FileVisitor<? super Path> visitor: อินเตอร์เฟสที่กำหนดการกระทำเมื่อเจอไฟล์หรือไดเร็กทอรี
		 * 
		 * เมธอดใน FileVisitor:
		 * - visitFile: เรียกเมื่อพบไฟล์
		 * - visitFileFailed: เรียกเมื่อไม่สามารถเข้าถึงไฟล์ได้
		 * - preVisitDirectory: เรียกก่อนเยี่ยมชมไดเร็กทอรี
		 * - postVisitDirectory: เรียกหลังจากเยี่ยมชมไดเร็กทอรีเสร็จ
		 */

		  Path start = Paths.get("src");  
//		  Path start = Paths.get("C:\\");
		  
		  /*
		   * AtomicLong เป็นคลาสที่อยู่ในแพ็คเกจ java.util.concurrent.atomic 
		   * ซึ่งใช้สำหรับการจัดการตัวเลข (long) ในลักษณะที่สามารถใช้งานได้โดยปลอดภัยในหลายเธรด
		   * การใช้งาน AtomicLong มักจะเป็นการเพิ่มหรือลดค่าในตัวแปร count ผ่านเมธอดที่เป็น atomic
		   * เช่น incrementAndGet() หรือ decrementAndGet() 
		   * ซึ่งจะทำให้มั่นใจได้ว่าเมื่อมีหลายเธรดเข้าถึงตัวแปร count 
		   * ค่าจะถูกปรับเปลี่ยนอย่างปลอดภัยโดยไม่มีปัญหาการชนกันของข้อมูล (data race)
		   */
		  AtomicLong count = new AtomicLong();
		  
		  // FileVisitor Annonymouns
		  FileVisitor<Path> visitor = new FileVisitor<Path>() {
			

			    // เมธอดนี้จะถูกเรียกเมื่อไม่สามารถเข้าถึงไฟล์ได้ 
			    // เช่น เมื่อไฟล์ไม่มีสิทธิ์ในการเข้าถึง หรือเกิดข้อผิดพลาดในการอ่านไฟล์
			    // ในที่นี้จะพิมพ์ข้อความแสดงข้อผิดพลาดและให้โปรแกรมดำเนินการต่อ
			    @Override
			    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			        System.out.println("1# Fehler bei Zugriff : " + exc );  // แสดงข้อความข้อผิดพลาด
			        return FileVisitResult.CONTINUE;  // ดำเนินการต่อไป
			    }
			  
			    // เมธอดนี้จะถูกเรียกเมื่อพบไฟล์ในไดเร็กทอรีที่กำลังสำรวจ
			    // ในที่นี้จะพิมพ์พาธของไฟล์และให้โปรแกรมดำเนินการต่อไป
			    @Override
			    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			    	
			    	count.incrementAndGet();   	 // Increment the count for each file found
			    	System.out.println("2# Datei gefunden : " + file );  // แสดงพาธของไฟล์
			       
			    	return FileVisitResult.CONTINUE;  // ดำเนินการต่อไป
			    }
			  
			    // เมธอดนี้จะถูกเรียกก่อนที่จะเยี่ยมชมไดเร็กทอรีที่กำหนด
			    // ในที่นี้จะพิมพ์ข้อความบอกว่าเจอไดเร็กทอรีใหม่
			    @Override
			    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			        System.out.println("3# ein weiteres Verzeichnis gefunden : " + dir );  // แสดงพาธของไดเร็กทอรี
			        return FileVisitResult.CONTINUE;  // ดำเนินการต่อไป
			    }
			  
			    // เมธอดนี้จะถูกเรียกหลังจากที่เยี่ยมชมไดเร็กทอรีเสร็จแล้ว
			    // ในที่นี้จะพิมพ์ข้อความบอกว่าเสร็จสิ้นการเยี่ยมชมไดเร็กทอรีแล้ว
			    @Override
			    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
			        System.out.println("4# mit dem Verzeichnis fertig " + dir);  // แสดงพาธของไดเร็กทอรี
			        return FileVisitResult.CONTINUE;  // ดำเนินการต่อไป
			    }
		  };

			// ใช้ walkFileTree เพื่อเดินทางในไฟล์และไดเร็กทอรีตามพาธที่กำหนด
			try {
			    Files.walkFileTree(start, visitor);
			    System.out.println("count : " + count.get());
			    
			} catch (IOException e) {
			    e.printStackTrace(); // จัดการข้อผิดพลาดที่อาจเกิดขึ้นระหว่างการเดินทางในไดเร็กทอรี
			}
	}

	static void mitWalk() {
		/*
		 * Aufgabe: Anzahl der Dateien (rekursiv) ermitteln คำนวณจำนวนไฟล์ (แบบเรียกซ้ำ)
		 * 
		 * Wenn walk ein Verzeichnis liest, das nicht gelesen werden darf,
		 * wirft sie eine Exception
		 * 
		 * C:\ เป็นไดเร็กทอรีระดับสูงสุด (root directory) ในระบบปฏิบัติการ Windows และอาจจะมีข้อจำกัดในการเข้าถึงหรือการเขียนในไดเร็กทอรีนี้
		 * โดยเฉพาะถ้าโปรแกรมของคุณไม่ได้รับสิทธิ์ (permissions) ที่เหมาะสมในการเข้าถึงหรือทำงานในพาธดังกล่าว
		 * 
		 * - ในกรณีนี้ ถ้าคุณใช้ "C:\" ในพาธอาจพบข้อยกเว้น (Exception) เช่น AccessDeniedException หรือข้อผิดพลาดที่เกี่ยวข้องกับการเข้าถึงไฟล์
		 * - เพื่อให้โปรแกรมสามารถเข้าถึงได้ คุณอาจต้องรันโปรแกรมในฐานะผู้ดูแล (administrator) หรือเลือกพาธที่โปรแกรมสามารถเข้าถึงได้ง่ายขึ้น
		 * 
		 * Lösung: 
		 * - ตรวจสอบสิทธิ์การเข้าถึงหรือรันโปรแกรมในฐานะผู้ดูแล
		 * - เลือกไดเร็กทอรีที่ไม่จำกัดสิทธิ์การเข้าถึงเช่น "C:\\Users\\<YourUsername>\\Documents"
		 */

		
      Path start = Paths.get("src");
//        Path start = Paths.get("C:\\");  
        

        System.out.println("Verzeichnis: " + start);

        try (Stream<Path> s = Files.walk(start)) {

            // Zählt die Dateien (rekursiv)
            long count = s.filter(Files::isRegularFile)
                          .collect(Collectors.counting());

            // Ausgabe der Anzahl der Dateien
            System.out.println("Anzahl der Dateien: " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
			
	}

}
