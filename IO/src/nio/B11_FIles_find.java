package nio;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class B11_FIles_find {

    /*
     * static Stream<Path> find(Path start,
     *                           int maxDepth,
     *                           BiPredicate<Path, BasicFileAttributes> matcher,
     *                           FileVisitOption... options) 
     *                     throws IOException
     * 
     * เมธอด find() ในคลาส Files ของ Java NIO ใช้สำหรับค้นหาไฟล์และไดเร็กทอรีในไฟล์ซิสเต็ม 
     * เริ่มต้นจากพาธที่กำหนด และสามารถกำหนดความลึกสูงสุดในการค้นหาผ่านพารามิเตอร์ maxDepth
     * โดยจะส่งคืนผลลัพธ์เป็น Stream<Path> ที่ประกอบด้วยพาธของไฟล์หรือไดเร็กทอรีที่ตรงกับเงื่อนไขที่กำหนด
     * 
     * - Stream<Path>: ผลลัพธ์ที่คืนค่าจะเป็นสตรีมของ Path ซึ่งจะประกอบไปด้วยพาธของไฟล์และไดเร็กทอรีที่ตรงกับเงื่อนไขที่กำหนด
     * - Path start: พารามิเตอร์นี้คือพาธเริ่มต้นที่ใช้ในการค้นหา
     * - int maxDepth: พารามิเตอร์นี้กำหนดความลึกสูงสุดในการค้นหา โดยเริ่มนับจาก 0 คือค้นหาจากไดเร็กทอรีเริ่มต้นและสามารถขยายลึกไปได้
     * - BiPredicate<Path, BasicFileAttributes> matcher: พารามิเตอร์นี้เป็นฟังก์ชันที่ใช้ตรวจสอบว่าไฟล์หรือไดเร็กทอรีนั้นตรงกับเงื่อนไขที่กำหนดหรือไม่ (เช่น การเช็คชื่อไฟล์ หรือการตรวจสอบว่าเป็นไฟล์หรือไดเร็กทอรี)
     * - FileVisitOption... options: พารามิเตอร์นี้เป็นออปชันเสริมที่สามารถใช้กำหนดพฤติกรรมการค้นหา เช่น การค้นหาผ่าน symbolic links หรือไม่
     * 
     * ทำไมไม่แนะนำให้ใช้ Integer.MAX_VALUE?
     * ปัญหาด้านประสิทธิภาพ: การตั้งค่าความลึกสูงสุดให้เป็น Integer.MAX_VALUE อาจทำให้โปรแกรมต้องทำการค้นหาในทุก ๆ ระดับของไดเร็กทอรีอย่างไม่จำกัด ซึ่งอาจทำให้ใช้เวลาในการประมวลผลมากเกินไปในกรณีที่มีโฟลเดอร์ซ้อนกันหลายระดับ
     * ไม่มีการควบคุมความลึกที่เหมาะสม: คุณอาจไม่ต้องการให้ระบบค้นหาในทุกไดเร็กทอรีที่อยู่ลึกมากเกินไป หากใช้ค่า Integer.MAX_VALUE มันจะไม่จำกัดจำนวนระดับการค้นหา
     */

    public static void main(String[] args) {
        
        Path start = Paths.get(".");

        // Nur das Startverzeichenis im Stream   
        // กำหนดความลึกสูงสุดในการค้นหา (ตั้งไว้เป็น 0 หมายถึงค้นหาเฉพาะในไดเร็กทอรีนี้)
        int maxDepth = 0; // เมื่อ maxDepth ถูกตั้งค่าเป็น 0 การค้นหาจะเกิดขึ้นเฉพาะในไดเร็กทอรี start โดยไม่ลึกไปยังไดเร็กทอรีย่อย ๆ (Subdirectories) 

//  	 maxDepth = Integer.MAX_VALUE; 
        
        // การใช้ค่า Integer.MAX_VALUE อาจทำให้ระบบประมวลผลช้าลงหรือเกิดปัญหาด้านประสิทธิภาพ 
        // หากค้นหาในโฟลเดอร์ที่มีไดเร็กทอรีย่อยจำนวนมาก เพราะมันจะทำการค้นหาทุกระดับของไดเร็กทอรีที่ซ้อนกันลงไปจนสุด
        
        // การใช้ค่า maxDepth ที่มีจำนวนจำกัดจะช่วยให้คุณสามารถควบคุมความลึกของการค้นหาได้ดีขึ้น
        maxDepth = 3; // ตั้งค่า maxDepth เป็น 3 เพื่อค้นหาในไดเร็กทอรี 3 ระดับ


        try (Stream<Path> s = Files.find(start, maxDepth, (p, atts) -> true)) {

            s.forEach(System.out::println);
            
        } catch (IOException e) {
            e.printStackTrace(); // หากเกิดข้อผิดพลาดในการอ่านไฟล์หรือไดเร็กทอรี จะแสดงข้อความข้อผิดพลาด
        }
    }
}
