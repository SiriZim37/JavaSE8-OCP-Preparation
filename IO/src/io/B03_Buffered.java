package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

public class B03_Buffered {

	public static void main(String[] args) {
	
		/*
		 *  BufferedReader unf BufferedWriter haben beide auch die Konstruktoren-Varianten,
		 *  die es erlauben die Größe des internen Puffers festzulegen 
		 *  
		 *  การใช้ BufferedReader และ BufferedWriter:
		 *  - BufferedReader ใช้สำหรับอ่านไฟล์แบบ บรรทัดต่อบรรทัด ซึ่งสะดวกสำหรับไฟล์ข้อความ
		 *  - BufferedWriter ใช้สำหรับเขียนไฟล์พร้อมรองรับการเขียนทีละบรรทัดและมีบัฟเฟอร์เพื่อเพิ่มประสิทธิภาพ
		 */
		
		try(BufferedReader in = new BufferedReader(new FileReader("autos.txt"));  
			BufferedWriter out = new BufferedWriter(new FileWriter("autos-kopie.txt"))){
			
			String line;
			
			while ((line = in.readLine()) !=null ) {
				out.write(line);
				out.write("\n");
			}
			System.out.println("fertig");

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Interessant : es gibt Methode lines , die ein Stream<String> öffnet
		 */
		
		String s = "Line A\nLine B\nLine C";
		
		try (BufferedReader br = new BufferedReader(new StringReader(s))){
			
			br.lines()		// Stream<String>
			  .forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
