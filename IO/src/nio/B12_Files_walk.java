package nio;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class B12_Files_walk {

    /*
     * static Stream<Path> walk(Path start, int maxDepth, FileVisitOption... options) throws IOException
     * 
     * เมธอดนี้ใช้สำหรับการเดินทางหรือสำรวจไดเร็กทอรี (directory tree) จากพาธที่กำหนด
     * โดยเริ่มจากไดเร็กทอรีที่ระบุในพารามิเตอร์ `start` และสามารถกำหนดตัวเลือกต่าง ๆ 
     * ผ่าน `FileVisitOption... options` เช่น การตามลิงก์ symbolic links หรือไม่
     * 
     * การใช้งานหลัก:
     * 
     * - `Path start`: พารามิเตอร์นี้เป็นพาธเริ่มต้นที่ใช้ในการเดินทางในไดเร็กทอรี
     * - `int maxDepth`: ระบุความลึกสูงสุดในการเดินทาง (0 หมายถึงไม่ลึกลงไปกว่านี้)
     * - `FileVisitOption... options`: พารามิเตอร์นี้สามารถใส่ตัวเลือกที่เกี่ยวกับการเดินทางในไดเร็กทอรี
     *   เช่น `FileVisitOption.FOLLOW_LINKS` เพื่อให้โปรแกรมตามลิงก์ symbolic links
     * - Return type: เมธอดนี้จะคืนค่าเป็น `Stream<Path>` ซึ่งประกอบไปด้วยพาธของไฟล์
     *   และไดเร็กทอรีที่ถูกเข้าถึงระหว่างการเดินทาง
     * 
     * คำเตือน:
     * - การใช้ `Files.walk()` จะทำการสำรวจทุกไฟล์และไดเร็กทอรีในพาธที่กำหนด
     *   ซึ่งอาจทำให้เกิดการใช้หน่วยความจำ (memory) และเวลาการประมวลผลมากขึ้น
     *   โดยเฉพาะถ้าไดเร็กทอรีนั้นมีจำนวนไฟล์หรือไดเร็กทอรีมาก
     *   
     *  *****************************************************************************************
     *  
     * static Stream<Path> walk(Path start, FileVisitOption... options) throws IOException
     * 
     * ใช้สำหรับการเดินทางในไดเร็กทอรีโดยไม่มีการกำหนด maxDepth
     * 
     * จะมีการสำรวจทุกรูปแบบ (ไม่จำกัดความลึก)
     */

    public static void main(String[] args) {

        Path start = Paths.get(".");
        int maxDepth = 0 ;

        // Version 1: Limiting the depth of the directory traversal
        System.out.println("*** Version 1 ");
        try (Stream<Path> s = Files.walk(start, maxDepth)) {
        	
            s.forEach(System.out::println);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*************************************************************************************************/

        // Version 2: Unlimited depth traversal
        
        System.out.println("\n\n*** Version 2 ");
        try (Stream<Path> s = Files.walk(start)) {
        	
            s.forEach(System.out::println);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("=========");
        /*
         * Exam
         */
        try {
			long count = Files.walk(Paths.get("."))
				.filter(Files::isDirectory)
				.count();
			   System.out.println("result: " + count);
		} catch (IOException e) {
			e.printStackTrace();
		}
     
    }
}
