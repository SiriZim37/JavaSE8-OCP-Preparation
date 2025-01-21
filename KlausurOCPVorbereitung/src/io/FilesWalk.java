package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesWalk {

	public static void main(String[] args) {
       
        /*
         * Exam
         */
		/*
		 * Files.walk เพื่อเริ่มต้นจากไดเรกทอรีปัจจุบัน (. คือไดเรกทอรีปัจจุบันที่รันโปรแกรม) และเดินผ่านทุกไฟล์ในไดเรกทอรีและไดเรกทอรีย่อยทั้งหมด
		 * ใช้ filter เพื่อกรองเฉพาะไดเรกทอรี (จะรับเฉพาะ Path ที่เป็นไดเรกทอรีเท่านั้น) (Not with files .java)
		 * 
		 * ไดเรกทอรีปัจจุบัน (.) หมายถึงไดเรกทอรีที่โปรแกรมหรือคำสั่งถูกเรียกใช้งาน ซึ่งอาจจะเป็นไดเรกทอรีหลักของโปรเจกต์
		 * แพ็กเกจ io อยู่ภายในโฟลเดอร์ src ดังนั้นเส้นทางเต็มไปยังแพ็กเกจ io คือ .\src\io
		 */
        try {
        	Files.walk(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);
        	
        	 System.out.println("=========");
        	 
			long count = Files.walk(Paths.get("."))
				.filter(Files::isDirectory)    // เฉพาะ Path ที่เป็นไดเรกทอรีเท่านั้น
				.count();
			   System.out.println("result: " + count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
