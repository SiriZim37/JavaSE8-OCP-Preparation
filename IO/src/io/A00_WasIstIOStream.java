package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class A00_WasIstIOStream {

	/*
	 * IO Streams in Java SE 8
	 *
	 * IO Streams คือกลไกที่ช่วยในการจัดการการอ่าน (Input) และการเขียน (Output) ข้อมูล 
	 * ซึ่งสามารถมาจากหลายแหล่ง เช่น ไฟล์, เครือข่าย, หรือข้อมูลในหน่วยความจำ
	 *
	 * ประเภทของ IO Streams:
	 * 1. Byte Streams: สำหรับจัดการข้อมูลในรูปแบบไบต์ (byte)
	 *    - ตัวอย่างคลาส: InputStream, OutputStream, FileInputStream, FileOutputStream
	 * 
	 * 2. Character Streams: สำหรับจัดการข้อมูลในรูปแบบตัวอักษร (character)
	 *    - ตัวอย่างคลาส: Reader, Writer, FileReader, FileWriter
	 *
	 * การอ่านข้อมูล (Input):
	 * - ใช้ FileInputStream เพื่ออ่านข้อมูลจากไฟล์
	 * 
	 * การเขียนข้อมูล (Output):
	 * - ใช้ FileOutputStream เพื่อเขียนข้อมูลลงไฟล์
	 *
	 * การใช้ Character Streams:
	 * - ใช้ FileReader และ FileWriter สำหรับการจัดการข้อมูลตัวอักษร
	 *
	 * การใช้ Buffered Streams:
	 * - BufferedInputStream และ BufferedOutputStream ช่วยเพิ่มประสิทธิภาพในการอ่านและเขียน
	 * 
	 * 
	 * วิธีการอ่านข้อมูล (Input):
	 * - ใช้ FileInputStream เพื่ออ่านข้อมูลจากไฟล์:
	 *   ```java
	 *   FileInputStream fileInputStream = new FileInputStream("input.txt");
	 *   int data;
	 *   while ((data = fileInputStream.read()) != -1) {
	 *       System.out.print((char) data);
	 *   }
	 *   fileInputStream.close();
	 *   ```
	 * 
	 * วิธีการเขียนข้อมูล (Output):
	 * - ใช้ FileOutputStream เพื่อเขียนข้อมูลลงไฟล์:
	 *   ```java
	 *   FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
	 *   String text = "Hello, World!";
	 *   fileOutputStream.write(text.getBytes());
	 *   fileOutputStream.close();
	 *   ```
	 *
	 * วิธีการใช้ Character Streams:
	 * - ใช้ FileReader และ FileWriter สำหรับการจัดการข้อมูลตัวอักษร:
	 *   ```java
	 *   FileReader fileReader = new FileReader("input.txt");
	 *   FileWriter fileWriter = new FileWriter("output.txt");
	 *   int character;
	 *   while ((character = fileReader.read()) != -1) {
	 *       fileWriter.write(character);
	 *   }
	 *   fileReader.close();
	 *   fileWriter.close();
	 *   ```
	 *
	 * การใช้ Buffered Streams:
	 * - BufferedInputStream และ BufferedOutputStream ช่วยเพิ่มประสิทธิภาพในการอ่านและเขียน:
	 *   ```java
	 *   BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("input.txt"));
	 *   BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("output.txt"));
	 *   int data;
	 *   while ((data = bufferedInputStream.read()) != -1) {
	 *       bufferedOutputStream.write(data);
	 *   }
	 *   bufferedInputStream.close();
	 *   bufferedOutputStream.close();
	 *   ```
	 * สรุป: IO Streams เป็นเครื่องมือสำคัญในการจัดการกับการอ่านและเขียนข้อมูลใน Java SE 8
	 */

	

	public static void main(String[] args) {
		
		 // BufferedWriteExample
		
		  String text = "Hello, Buffered World!";
		  
	      try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("example.txt"))) {
	          
	    	  bos.write(text.getBytes()); // เขียนข้อมูลลงในไฟล์
	      
	      } catch (IOException e) {
	         
	    	  e.printStackTrace();
	      }

	}

}
