package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class B04_flush {

	/*
	 * flush() เป็นเมธอดที่ใช้สำหรับ ส่งข้อมูลที่เก็บอยู่ในบัฟเฟอร์ (buffer) ของสตรีมหรือ writer ออกไปยังปลายทาง (ไฟล์, เครือข่าย ฯลฯ) ทันที โดยไม่รอให้บัฟเฟอร์เต็มก่อน
	 * 
	 * - โดยปกติแล้ว เมื่อเราใช้ Writer หรือ OutputStream ข้อมูลจะถูกเขียนลง บัฟเฟอร์ ก่อนที่จะถูกส่งไปยังปลายทางจริง ๆ เพื่อเพิ่มประสิทธิภาพ
	 * - เมื่อเรียกใช้ flush() ข้อมูลที่อยู่ในบัฟเฟอร์จะถูก เขียนออกไป โดยทันที ทำให้มั่นใจได้ว่าข้อมูลทั้งหมดถูกส่งไปยังไฟล์หรือปลายทางจริง ๆ
	 * - ใช้ flush() เมื่อคุณต้องการให้ข้อมูลถูกเขียนออกไป ในขณะที่ยังคงเปิดสตรีมอยู่
	 */
	/*
	 * ใช้ flush() เพื่อ บังคับ ให้ข้อมูลที่อยู่ในบัฟเฟอร์ถูกเขียนลงไฟล์หรือปลายทางทันที
	 * เหมาะสำหรับสถานการณ์ที่ต้องการควบคุมเวลาการเขียนข้อมูล
	 * flush() สามารถใช้ได้กับ Writer และ OutputStream และยังรวมถึง PrintWriter
	 * ด้วย เพราะ PrintWriter เป็น subclass ของ Writer และสนับสนุนการใช้งาน flush()
	 */
	public static void main(String[] args) throws IOException {

		Writer fw = new FileWriter("lines.txt");
		
		fw.write("Line A\n"); // Die Zeichen werden im Puffer vom FileWriter gespeichert
							  // เขียนข้อมูล "Line A" ลงในบัฟเฟอร์ของ FileWriter
		
		fw.flush(); 		  // ส่งข้อมูลที่เขียนไปยังไฟล์ในทันที  Inhalte aus dem Puffer an das Ziel weiter schreiben
		
		fw.close(); 		  // wurde fürs Testen ausgelassen // ปิด FileWriter (ในโค้ดนี้แสดงให้เห็นว่า flush() ใช้ก่อนปิด)
		
		System.out.println("fertig");
		
		/*
		 * Exam! NUr Writer (oder OutputStream) haben die Methode flush()
		 * เฉพาะ Writer หรือ OutputStream เท่านั้นที่มี flush():
		 */
		
		Reader in = null;
//		in.flush();  // compiler fehler // Reader (สำหรับอ่านข้อมูล) ไม่มีเมธอด flush() เพราะมันไม่ได้เขียนข้อมูล
		
		
		
		

	}

}
