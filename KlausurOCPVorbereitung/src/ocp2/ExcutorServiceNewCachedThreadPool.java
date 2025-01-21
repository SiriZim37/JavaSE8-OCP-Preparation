package ocp2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/*
 QUESTION 74
 Given the code fragment:
 public class FileThread implements Runnable  {
    String fName;
    public FileThread(String fName)   { this.fName = fName;  }
    public void run () System.out.println(fName);}
    public static void main (String[] args) throws IOException, InterruptedException   {
        ExecutorService executor = Executors.newCachedThreadPool();
        Stream<Path> listOfFiles = Files.walk(Paths.get(“Java Projects”));
        listOfFiles.forEach(line ->   {
            executor.execute(new FileThread(line.getFileName().toString()));     //line n1
        });
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.DAYS);                    //line n2
    }
 }
 The Java Projects directory exists and contains a list of files.
 What is the result?
 A. The program throws a runtime exception at line n2.
 B. The program prints files names concurrently.
 C. The program prints files names sequentially.
 D. A compilation error occurs at line n1.
 */

/*
	B. โปรแกรมพิมพ์ชื่อไฟล์พร้อมกัน (concurrently)

	คำอธิบาย:
	โค้ดสร้าง ExecutorService executor = Executors.newCachedThreadPool(); ซึ่งเป็นการสร้าง thread pool ที่สามารถทำงานได้หลายเธรดพร้อมกัน (concurrent).
	โค้ดใช้ Files.walk(Paths.get("Java Projects")) เพื่อดึงข้อมูลไฟล์ในไดเรกทอรี "Java Projects" และแปลงเป็น Stream ของ Path.
	ในการใช้ forEach เพื่อประมวลผลแต่ละ Path จะสร้าง FileThread ใหม่ที่มีการพิมพ์ชื่อไฟล์ออกมา และจะถูกส่งไปทำงานด้วย executor.execute(...).
	เนื่องจาก newCachedThreadPool() สามารถทำงานในหลายเธรดพร้อมกันได้ ทำให้ชื่อไฟล์แต่ละไฟล์จะถูกพิมพ์ออกมาพร้อมกัน (concurrently) โดยแต่ละเธรด.
	เมธอด executor.awaitTermination(5, TimeUnit.DAYS); จะทำให้เธรดหลักรอจนกว่าเธรดทั้งหมดจะเสร็จสิ้นหรือล่วงเลยเวลาที่กำหนด.
	ทำไมคำตอบอื่นไม่ถูกต้อง:
	A. โปรแกรมโยน runtime exception ที่บรรทัด n2: ไม่มีเหตุผลที่ชัดเจนที่โปรแกรมจะโยน runtime exception ที่บรรทัด n2 ในกรณีนี้.
	C. โปรแกรมพิมพ์ชื่อไฟล์แบบลำดับ (sequentially): โปรแกรมพิมพ์ชื่อไฟล์พร้อมกัน (concurrently) เนื่องจาก executor.execute() จะให้แต่ละงานทำในเธรดแยกต่างหาก.
	D. เกิดข้อผิดพลาดในการคอมไพล์ที่บรรทัด n1: ไม่มีข้อผิดพลาดในการคอมไพล์ที่บรรทัด n1 โค้ดถูกต้องตามหลักไวยากรณ์.

 */
class FileThread implements Runnable  {
    String fName;
    
    // สร้าง Constructor ที่รับชื่อไฟล์เป็นพารามิเตอร์
    public FileThread(String fName) {
        this.fName = fName;
    }

    // เมธอด run จะพิมพ์ชื่อไฟล์ที่ได้รับจาก Constructor
    public void run () {
        System.out.println(fName);
    }

 
}


public class ExcutorServiceNewCachedThreadPool {

	   public static void main (String[] args) throws IOException, InterruptedException   {
	        // สร้าง ExecutorService ที่ใช้ในการทำงานหลายเธรดพร้อมกัน
	        ExecutorService executor = Executors.newCachedThreadPool();
	        
	        // ใช้ Files.walk เพื่อดึงลิสต์ของไฟล์ในไดเรกทอรี "Java Projects"
	        Stream<Path> listOfFiles = Files.walk(Paths.get("Java Projects"));
	        
	        // ใช้ forEach เพื่อประมวลผลแต่ละไฟล์
	        listOfFiles.forEach(line -> {
	            // สร้าง FileThread สำหรับแต่ละไฟล์และให้มันทำงานในเธรดแยก
	            executor.execute(new FileThread(line.getFileName().toString()));     
	        });
	        
	        // บอก ExecutorService ว่าหยุดรับงานใหม่แล้ว
	        executor.shutdown();
	        
	        // รอให้เธรดทั้งหมดเสร็จสิ้นก่อนจะออกจากโปรแกรม
	        // Anhalten , bis die Threads vom ExecutorService beendet sind
	        executor.awaitTermination(5, TimeUnit.DAYS);                    
	    }
	
	
}
