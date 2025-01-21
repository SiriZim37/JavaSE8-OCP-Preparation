package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class B01_KonzeptLesenSchreiben {

	/*
	 *  Viele Fragen im OCP-Buch sind unnötig kompliziert.
	 *  
	 * 	Bitte in der Praxis die Methoden 'read()' und write(int)'
	 * 	nicht verwenden.
	 * 
	 *  Es gibt alternativen, die effizienter arbeiten
	 * 
	 *  Reader และ Writer เป็นคลาสใน Java ที่ใช้สำหรับการจัดการการอ่าน (Input) และการเขียน (Output) ข้อมูลตัวอักษร (character data) โดยเฉพาะ
	 *
	 * 1. **Reader**: คลาสพื้นฐานสำหรับการอ่านข้อมูลตัวอักษร
	 *    - Subclasses ได้แก่ FileReader, BufferedReader, StringReader, และอื่น ๆ
	 *    - สามารถอ่านข้อมูลตัวอักษรทีละตัว, อาร์เรย์ของตัวอักษร, หรือบรรทัดของข้อความ
	 *
	 * 2. **Writer**: คลาสพื้นฐานสำหรับการเขียนข้อมูลตัวอักษร
	 *    - Subclasses ได้แก่ FileWriter, BufferedWriter, PrintWriter, และอื่น ๆ
	 *    - สามารถเขียนข้อมูลตัวอักษรทีละตัว, อาร์เรย์ของตัวอักษร, หรือข้อความที่เป็นบรรทัด

	 */
	public static void main(String[] args) {
		
		/*
		 * Schreiben , danach schließen (hier mit try-with-resources)
		 */
		try(Writer out = new FileWriter("abc.txt")){
			
			out.write('a');
			out.write('b');
			out.write('c');
			
			System.out.println("Datei geschreiben");
		}catch (IOException e) {
			System.err.println("Fehler beim Schreiben : " + e);
		}
		
		/*
		 * Lesen , danach Schließen (hier mit try-with-resources)
		 */
		try(Reader in = new FileReader("abc.txt")){
			int x = in.read();
			
			char ch = (char)x;
			System.out.println("gelesen : " + ch );		// a
			
			 ch = (char)x;
			System.out.println("gelesen : " + ch );		// a		>>> Duplicate
			
			ch = (char)in.read();
			System.out.println("gelesen : " + ch );		// b
			
			ch = (char)in.read();
			System.out.println("gelesen : " + ch );		// c
			
		}catch (IOException e) {
			System.err.println("Fehler beim Lesen : " + e);
		}
		
		

	}

}
