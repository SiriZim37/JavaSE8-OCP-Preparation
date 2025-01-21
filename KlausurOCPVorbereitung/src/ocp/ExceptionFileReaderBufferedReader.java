package ocp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
	import java.io.*;
	
	class Gutsy {
		
		  public static void main(String[] args) {
		    new Gutsy().go();
		  }
		  
		  void go() throws IOException {
		    String row;
		    try {
		      FileReader fr = new FileReader("TestFile.txt");
		      BufferedReader br = new BufferedReader(fr);
		      while((row = br.readLine()) != null)
		        System.out.println(row);
		    } catch (IOException e) {
		      System.out.print("got io error ");
		    } finally {
		      System.out.println("done ");
		    }
		  }
	}
*/
	/*
	 * And given that TestFile.txt does not exist, what is the result?
	
	A.done
	B.got io error
	C.got io error done
	D.Compilation fails
	E.An uncaught exception is thrown
	
	
	D is correct. Because go() declares that it throws a checked exception, 
	it doesn't matter that it also handles it. Any method invoking go() must
	 handle or declare the exception that go() might throw.
	
	A, B, C, and E are incorrect based on the above. If go() didn't declare 
	that it throws a checked exception, C would have been correct.
	 */

/*
 * D. Compilation fails คือคำตอบที่ถูกต้อง เพราะว่า เมธอด main() ไม่ได้จัดการหรือประกาศว่าโยน 
 * IOException ที่โยนจากเมธอด go() ทำให้เกิดข้อผิดพลาดในการคอมไพล์
 */
public class ExceptionFileReaderBufferedReader {

	 public static void main(String[] args) {
		    try {
				new ExceptionFileReaderBufferedReader().go();
			} catch (IOException e) {
				e.printStackTrace();
			}
		  }
		  
		  void go() throws IOException {
		    String row;
		    try {
		      FileReader fr = new FileReader("TestFile.txt");
		      BufferedReader br = new BufferedReader(fr);
		      while((row = br.readLine()) != null)
		        System.out.println(row);
		    } catch (IOException e) {
		      System.out.print("got io error ");
		    } finally {
		      System.out.println("done ");
		    }
		  }
		  
}
