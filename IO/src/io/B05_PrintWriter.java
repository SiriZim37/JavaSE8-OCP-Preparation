package io;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class B05_PrintWriter {

	public static void main(String[] args) {

		/*
		 * Es gibt viele Konstruktoren, mit denen viele unterschiedliche
		 * Ziele festgelegt werden können
		 * 
		 * PrintWriter(File filePath)
		 * PrintWriter(String filename)
		 * PrintWriter(OutputStream)
		 * PrintWriter(Wwriter)
		 * ...
		 */
		/*
		 * โค้ดนี้ใช้คลาส PrintWriter จาก Java เพื่อเขียนข้อความลงในไฟล์. PrintWriter 
		 * ถูกออกแบบมาเพื่อให้การเขียนข้อความทำได้ง่ายขึ้น โดยรองรับการเขียนข้อความในรูปแบบที่หลากหลาย 
		 * เช่น การเขียนข้อความธรรมดา (print, println) หรือการจัดรูปแบบข้อความ (format).
		 */

		try(PrintWriter out = new PrintWriter("tiere.txt")) {
			
			out.format("Katze %s%n", "Tom");
			out.println("Hund Rex");
			
		
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		System.out.println("fertig");
		

	}

}
