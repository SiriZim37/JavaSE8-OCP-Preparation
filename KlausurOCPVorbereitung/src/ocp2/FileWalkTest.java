package ocp2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class FileWalkTest {

    public static void main(String[] args) {
        try (Stream<Path> files = Files.walk(Paths.get(System.getProperty("user.home")))) {
            files.forEach(fName -> {  //line n1
                try {
                    Path aPath = fName.toAbsolutePath();  //line n2
                    System.out.println(fName + ":"
                            + Files.readAttributes(aPath, BasicFileAttributes.class).creationTime());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    /*
      What is the result?
		 A. All files and directories under the home directory are listed along with their attributes.
		 B. A compilation error occurs at line n1.
		 C. The files in the home directory are listed along with their attributes.
		 D. A compilation error occurs at line n2
     */
    
    /*
     	ตัวเลือก A ถูกต้อง ถ้า files ที่ถูกอ้างอิงในโค้ดคือ collection ของไฟล์และไดเรกทอรีที่มาจาก home directory (หรือ directory ที่คุณต้องการทำงานด้วย) เนื่องจาก:

		files.forEach() จะวนลูปผ่านทุกไฟล์ใน collection ของ files ที่ถูกต้อง
		คำสั่ง Files.readAttributes(aPath, BasicFileAttributes.class) 
		จะดึงข้อมูลคุณสมบัติพื้นฐานของไฟล์ รวมถึงเวลาในการสร้างของไฟล์
		ถ้า files ถูกสร้างมาจากการค้นหาไฟล์ใน home directory โดยใช้ Files.list() 
		หรือ Files.walk() ก็จะทำให้ไฟล์และไดเรกทอรีทั้งหมดใน home directory 
		ถูกพิมพ์พร้อมข้อมูลของมัน เช่น เวลาในการสร้าง
     */
}

