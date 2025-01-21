package ocp;

import java.io.*;



public class IO_Serializable4 extends Dog {
	
	/*
	 * Which can be constructed using an instance of java.io.File? (Choose all that apply.)
	 * 
	 * A. java.io.FileWriter
	 * 
	 * B. java.io.BufferedWriter
	 * 
	 * C. java.io.PrintWriter
	 * 
	 * D. java.io.FileReader
	 * 
	 * E. java.io.BufferedReader
	 * 
	 * 
	 * 
	 * 
	 * A, C, and D are correct.
	 * B and E are incorrect. These classes don't have constructors that take a file.
	 * 
	 * คำอธิบาย:
	 * - A (java.io.FileWriter): ถูกต้อง เพราะ FileWriter ใช้ในการเขียนข้อมูลลงไฟล์ โดยรับ instance ของ java.io.File เพื่อเป็นไฟล์ที่จะเขียน
	 * - B (java.io.BufferedWriter): ไม่ถูกต้อง เพราะ BufferedWriter ไม่มี constructor ที่รับ java.io.File โดยตรง มันต้องใช้ OutputStreamWriter หรือ Writer อื่นๆ
	 * - C (java.io.PrintWriter): ถูกต้อง เพราะ PrintWriter สามารถสร้างได้จาก java.io.File ซึ่งจะใช้สำหรับการเขียนข้อมูลไปยังไฟล์
	 * - D (java.io.FileReader): ถูกต้อง เพราะ FileReader ใช้ในการอ่านข้อมูลจากไฟล์ โดยรับ instance ของ java.io.File เพื่อเป็นไฟล์ที่ต้องการอ่าน
	 * - E (java.io.BufferedReader): ไม่ถูกต้อง เพราะ BufferedReader ไม่สามารถสร้างได้จาก java.io.File โดยตรง มันต้องใช้ FileReader หรือ InputStreamReader
	 */
	//-------------------------------------------------------------------------------------------//
	
	/*
	 * Which can be constructed using a String? (Choose all that apply.)
	 * 
	 * A. java.io.File
	 * 
	 * B. java.io.FileWriter
	 * 
	 * C. java.io.BufferedWriter
	 * 
	 * D. java.io.PrintWriter
	 * 
	 * E. java.io.BufferedReader
	 * 
	 * 
	 * 
	 * A, B, and D are correct.
	 * C and E are incorrect. These classes don't have constructors that can take a String.
	 * 
	 * คำอธิบาย:
	 * - A: java.io.File สามารถถูกสร้างด้วย String ได้ เพราะมี constructor ที่รับ String ซึ่งเป็น path ของไฟล์หรือ directory
	 * - B: java.io.FileWriter สามารถสร้างได้จาก String ที่ระบุ path ของไฟล์เพื่อเขียนข้อมูลไปยังไฟล์
	 * - C: java.io.BufferedWriter ไม่สามารถสร้างได้จาก String โดยตรง เพราะมันต้องการ FileWriter หรือ OutputStreamWriter เป็นตัวเริ่มต้น
	 * - D: java.io.PrintWriter สามารถสร้างได้จาก String ซึ่งเป็น path ของไฟล์ที่ต้องการเขียนข้อมูล
	 * - E: java.io.BufferedReader ไม่สามารถสร้างได้จาก String โดยตรง ต้องใช้ InputStreamReader หรือ FileReader ในการสร้าง BufferedReader
	 */



}

