package ocp;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class InstanceOfPolymorphism {
	public static void main(String[] args) throws IOException {
		/*
	    int mask =0;
	    File f = new File("x.txt");
	    FileWriter fw = new FileWriter(f);
	    BufferedWriter bw = new BufferedWriter(fw);
	    if (bw instanceof Closeable)  mask = mask + 1;
	    if (bw instanceof Writer)     mask = mask + 2;
	    if (bw instanceof Object)     mask = mask + 4;
	    if (bw instanceof FileWriter) mask = mask + 8;
	    System.out.println(mask);
	    
	    
	   */
		
		/*
			 What is the result?
				A.4
				B.5
				C.6
				D.7
				E.12
				F.15
				G.Compilation fails
				H.An exception is thrown at runtime
		 */
		
		/*
		 * G is correct. BufferedWriter does not extend from FileWriter. The other three instanceof tests would succeed if the FileWriter test was removed.
			A, B, D, E, F, and H are incorrect based on the above.
		 */
		
		/*
			วิเคราะห์คำตอบ:
			- bw instanceof Closeable: 
			  ถูกต้อง เพราะ BufferedWriter สืบทอดมาจาก Closeable
			- bw instanceof Writer: 
			  ถูกต้อง เพราะ BufferedWriter สืบทอดมาจาก Writer
			- bw instanceof Object: 
			  ถูกต้อง เพราะทุกคลาสใน Java สืบทอดมาจาก Object
			- bw instanceof FileWriter: 
			  ผิด เพราะ BufferedWriter ไม่ได้สืบทอดจาก FileWriter
			  (BufferedWriter ใช้ FileWriter เป็น composition หรือ has-a relationship 
			  ไม่ใช่ inheritance หรือ is-a relationship)

		 */
		
		
	  }
}
