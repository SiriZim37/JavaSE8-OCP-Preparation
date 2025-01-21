package ocp;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IO_NIO4 extends Dog {

	/*
	  public class Visit extends SimpleFileVisitor<Path> {
		  // INSERT CODE HERE
		
		  public static void main(String[] args) throws Exception {
		    Visit v = new Visit();
		    Files.walkFileTree(Paths.get("/myDir"), v);
		  }
		}

	 */
	
	/*
	 * Which of the following, when inserted independently, 
	 * will print out the provided directory and all subdirectories? (Choose all that apply.)
	 * มื่อถูกแทรกเข้าไปอย่างอิสระ จะพิมพ์ไดเรกทอรีที่ให้มาและไดเรกทอรีย่อยทั้งหมด?
	 * 
	 * A. 
	 * public FileVisitResult preVisitDirectory(
	 *           Path dir, BasicFileAttributes attrs) throws IOException {
	 *   System.out.println(dir);
	 *   return FileVisitResult.CONTINUE;
	 * }
	 * 
	 * B. 
	 * public FileVisitResult visitFile(
	 *          Path file, BasicFileAttributes attrs) throws IOException {
	 *   if ( attrs.isDirectory()) { System.out.println(file); }
	 *   return FileVisitResult.CONTINUE;
	 * }
	 * 
	 * C. 
	 * public FileVisitResult visitFile(
	 *          Path file, BasicFileAttributes attrs) throws IOException {
	 *   if ( file.isDirectory()) { System.out.println(file); }
	 *   return FileVisitResult.CONTINUE;
	 * }
	 * 
	 * D. 
	 * public FileVisitResult postVisitDirectory(
	 *          Path dir, IOException exc) throws IOException {
	 *   System.out.println(dir);
	 *   return FileVisitResult.CONTINUE;
	 * }
	 * 
	 * E. 
	 * public FileVisitResult visitDirectory(
	 *          Path dir, IOException exc) throws IOException {
	 *   System.out.println(dir);
	 *   return FileVisitResult.CONTINUE;
	 * }
	 * 
	 * 
	 * 
	 * A and D are correct. They show you can print the directory either before or after the directory contents are visited.
	 * 
	 * B is incorrect because it doesn't output anything. visitFile() is called for only files and not directories. This means that attrs.isDirectory() will never return true in this method.
	 * 
	 * C is incorrect because it does not compile. Checking if an object is a directory is not a method on a Path object. It is a method on BasicFileAttributes. It is also a static method on Files.
	 * 
	 * E is incorrect because visitDirectory is not a method in SimpleFileVisitor so it's never invoked. The methods for directories are preVisitDirectory and postVisitDirectory.
	 * 
	 * 
	 * ในโค้ดที่ให้มา เรากำลังใช้ SimpleFileVisitor<Path> ซึ่งเป็นคลาสที่ช่วยให้เราเยี่ยมชมไฟล์และไดเรกทอรีทั้งหมดในเส้นทางที่กำหนด 
	 * โดยใช้ Files.walkFileTree() ซึ่งจะเดินทางไปยังไฟล์และไดเรกทอรีทั้งหมดในเส้นทางที่ให้มา
	 * โค้ดนี้จะใช้เมธอดต่างๆ ที่ถูกกำหนดใน SimpleFileVisitor
	 *  เช่น preVisitDirectory(), visitFile(), และ postVisitDirectory() 
	 *  เพื่อกำหนดว่าเราต้องการทำอะไรกับไดเรกทอรีและไฟล์ในระหว่างที่เราเยี่ยมชม
		preVisitDirectory(Path dir, BasicFileAttributes attrs): จะถูกเรียกก่อนที่ไฟล์ในไดเรกทอรีจะถูกเยี่ยมชม ใช้ในการทำงานกับไดเรกทอรีที่ต้องการก่อน
		visitFile(Path file, BasicFileAttributes attrs): จะถูกเรียกเมื่อเยี่ยมชมไฟล์ในไดเรกทอรีนั้น
		postVisitDirectory(Path dir, IOException exc): จะถูกเรียกหลังจากที่ไดเรกทอรีทั้งหมดและไฟล์ในไดเรกทอรีนั้นๆ ได้รับการเยี่ยมชมแล้ว
		visitFileFailed(Path file, IOException exc): จะถูกเรียกถ้ามีข้อผิดพลาดเกิดขึ้นระหว่างการเยี่ยมชมไฟล์
		
		
	 * คำอธิบาย:
	 * - A: ใช้ preVisitDirectory เพื่อพิมพ์ชื่อไดเรกทอรี ก่อนที่จะเข้าถึงไฟล์หรือไดเรกทอรีภายใน
	 * - D: ใช้ postVisitDirectory เพื่อพิมพ์ชื่อไดเรกทอรี หลังจากที่ได้เยี่ยมชมเนื้อหาภายในแล้ว
	 * - B: ไม่ถูกต้องเพราะ visitFile ถูกเรียกใช้กับไฟล์เท่านั้น ไม่ใช่ไดเรกทอรี และ attrs.isDirectory() จะไม่เป็นจริงในกรณีนี้
	 * - C: ไม่ถูกต้องเนื่องจากจะไม่สามารถคอมไพล์ได้ การตรวจสอบว่าเป็นไดเรกทอรีจะใช้ได้เฉพาะใน BasicFileAttributes ไม่ใช่ใน Path
	 * - E: visitDirectory ไม่ใช่เมธอดใน SimpleFileVisitor ดังนั้นจะไม่ได้รับการเรียกใช้ เมธอดสำหรับไดเรกทอรีคือ preVisitDirectory และ postVisitDirectory
	 */
	
}

