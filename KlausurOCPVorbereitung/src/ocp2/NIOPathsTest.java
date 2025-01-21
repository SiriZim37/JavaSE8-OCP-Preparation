package ocp2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOPathsTest {

	public static void main(String[] args) {

		Path p1 = Paths.get("/Pics/MyPic.jpeg");
		 System.out.println (p1.getNameCount() +
		            ":" + p1.getName(1) +
		            ":" + p1.getFileName());
		 
		 
		 /*
		  *  Assume that the Pics directory does NOT exist.
			 What is the result?
			 A. An exception is thrown at run time.
			 B. 2:MyPic.jpeg: MyPic.jpeg
			 C. 1:Pics:/Pics/ MyPic.jpeg
			 D. 2:Pics: MyPic.jpeg
		  */
		 
		 /*
		  * Paths.get("/Pics/MyPic.jpeg") จะสร้าง Path ที่ชี้ไปยังไฟล์ MyPic.jpeg ในโฟลเดอร์ Pics ที่อยู่ใน root directory (จากเครื่องหรือระบบปฏิบัติการที่ใช้)
			p1.getNameCount() จะคืนค่าจำนวนส่วนของเส้นทางที่มีใน Path ซึ่งในกรณีนี้คือ 2 (คือ Pics และ MyPic.jpeg)
			p1.getName(1) จะคืนค่าชื่อโฟลเดอร์ที่มีเลขดัชนีเป็น 1 ซึ่งคือ MyPic.jpeg
			p1.getFileName() จะคืนค่าชื่อไฟล์สุดท้ายในเส้นทาง ซึ่งในกรณีนี้คือ MyPic.jpeg
			
			D. 2:Pics: MyPic.jpeg correct
			
			คำอธิบาย:
			p1.getNameCount() คืนค่า 2 เพราะมี 2 ส่วนในเส้นทาง /Pics/MyPic.jpeg (คือ Pics และ MyPic.jpeg)
			p1.getName(1) คืนค่า Pics ซึ่งเป็นชื่อโฟลเดอร์แรก
			p1.getFileName() คืนค่า MyPic.jpeg ซึ่งเป็นชื่อไฟล์สุดท้าย

		  */
	}
}
