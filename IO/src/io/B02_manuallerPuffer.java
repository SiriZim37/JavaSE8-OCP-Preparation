package io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class B02_manuallerPuffer {

	public static void main(String[] args) {

		char[] cbuf = new char[1024]; // บรรทัดนี้ประกาศและสร้างอาร์เรย์ของตัวอักษรชื่อว่า cbuf โดยมีขนาด 1024  ตัวอักษร ซึ่งอาร์เรย์นี้ถูกใช้เป็น บัฟเฟอร์ (buffer) ชั่วคราวสำหรับเก็บข้อมูลที่อ่านจากไฟล์ autos.txt ในแต่ละครั้ง

		try (Reader in = new FileReader("autos.txt")) { // เปิด FileReader เพื่ออ่านจากไฟล์ "autos.txt"
		    
		    int anZahlGelesen; //  ประกาศตัวแปรเพื่อเก็บจำนวนตัวอักษรที่อ่านจากไฟล์
		    				   //  ตัวแปร anZahlGelesen ถูกใช้เพื่อเก็บค่าจำนวนตัวอักษรที่ถูกอ่านจากไฟล์ในแต่ละครั้งที่เรียกใช้เมธอด read(cbuf) ซึ่งจะคืนค่าจำนวนตัวอักษรที่อ่านได้จากบัฟเฟอร์ cbuf
		    				   //  การเก็บจำนวนตัวอักษรที่อ่านได้ช่วยให้สามารถตรวจสอบได้ว่ามีข้อมูลเท่าไหร่ที่ถูกอ่านในแต่ละครั้ง ซึ่งจะนำไปใช้ในการสร้าง String จากบัฟเฟอร์ในลำดับถัดไป
		    
		    while ((anZahlGelesen = in.read(cbuf)) != -1) { // การใช้ while ร่วมกับการตรวจสอบค่า anZahlGelesen ว่าไม่เท่ากับ -1 ช่วยให้โปรแกรมสามารถรู้ได้ว่าการอ่านข้อมูลจากไฟล์ยังไม่สิ้นสุด
		         
		    	/*
		    	 * String.valueOf(char[] cbuf, int offset, int count)
		    	 * ใช้เมธอด String.valueOf(char[] cbuf, int offset, int count) เพื่อแปลงข้อมูลในอาร์เรย์ cbuf ที่อ่านได้เป็น String
		    	 * cbuf คือข้อมูลที่อ่านมา
		    	 * offset คือเริ่มต้นที่ตำแหน่ง 0
		    	 * count คือจำนวนตัวอักษรที่อ่านได้ (เก็บใน anZahlGelesen)
		    	 */
		        String s = String.valueOf(cbuf, 0, anZahlGelesen);  // แปลงอาร์เรย์ cbuf เป็น String โดยใช้จำนวนตัวอักษรที่อ่านได้		
		        													// ตัวแปร anZahlGelesen ยังถูกใช้ในการสร้าง String จากบัฟเฟอร์ โดยจะใช้ค่าจำนวนที่อ่านได้เพื่อกำหนดจำนวนตัวอักษรที่ควรนำไปสร้าง String


		        System.out.println(s); // พิมพ์ String ที่อ่านได้ไปที่คอนโซล
		    }
		    
		} catch (IOException e) { // จัดการกับข้อผิดพลาด IOException
		    e.printStackTrace(); // แสดง stack trace ของข้อผิดพลาดในคอนโซล
		}
	}

}
