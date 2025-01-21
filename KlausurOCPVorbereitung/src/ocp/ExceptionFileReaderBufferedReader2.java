package ocp;



import java.io.*;
	
	class Gutsy {
		
		  public static void main(String[] args) throws IOException {
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

	/*
	 * And given that TestFile.txt does not exist, what is the result?
	
	A.done
	B.got io error
	C.got io error done
	D.Compilation fails
	E.An uncaught exception is thrown
	
	
	C. got io error done: เนื่องจากเกิดข้อผิดพลาด IOException (ไฟล์ไม่พบ) 
		และโปรแกรมจะพิมพ์ข้อความ "got io error" และ "done" จากบล็อก finally
	 */

	/*
		กรณีที่ไฟล์ TestFile.txt ไม่พบ:
		
		เนื่องจากไฟล์ TestFile.txt ไม่มีอยู่ในระบบ เมื่อโปรแกรมพยายามเปิดไฟล์ดังกล่าวโดยใช้ FileReader 
		จะเกิดข้อผิดพลาด FileNotFoundException ซึ่งเป็นชนิดหนึ่งของ IOException
		IOException จะถูกจับในบล็อก catch ซึ่งจะพิมพ์ "got io error"
		หลังจากนั้นจะเข้าสู่บล็อก finally ซึ่งจะพิมพ์ "done" เสมอ
		
	 */
public class ExceptionFileReaderBufferedReader2 {

}
