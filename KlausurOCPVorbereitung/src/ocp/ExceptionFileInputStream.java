package ocp;
/*
import java.io.*;


class Test {
  public static void main(String [] args){
    FileInputStream in = null;
    try {
      in = new FileInputStream("test.txt");
      int x = in.read();
    }catch(IOException io) {
        System.out.println("IO Error.");
    }finally {
        in.close();
     }
   }
 }
*/
/*
 * and given that all methods of class FileInputStream throw an IOException, which is true?
 * 
 * 
	A.This program compiles successfully
	B.This program fails to compile due to an error at line 4
	C.This program fails to compile due to an error at line 6
	D.This program fails to compile due to an error at line 9
	E.This program fails to compile due to an error at line 15
	
	
	E is correct. Any method (in this case, the main() method) that 
	throws a checked exception (in this case, in.close()) must be called 
	within a try clause, or the method must declare that it throws the exception. 
	Either main() must declare that it throws an exception, or the call to in.close() 
	in the finally block must fall inside a (in this case nested) try-catch block.
	
	A, B, C, and D are incorrect based on the program logic described above.
 */

/*
 * ปัญหาที่เกิดขึ้นในโค้ด:
	
	ในโค้ดนี้ เมธอด main() พยายามที่จะปิดไฟล์ที่เปิดอยู่โดยใช้ in.close() ในบล็อก finally แต่เนื่องจากเมธอด close() 
	ของคลาส FileInputStream อาจโยนข้อยกเว้นชนิดที่ตรวจสอบได้ (checked exception) เช่น IOException 
	เมธอด main() จึงต้องจัดการข้อยกเว้นนี้ด้วยวิธีการใดวิธีการหนึ่ง เช่น ใช้บล็อก try-catch 
	หรือประกาศว่าเมธอดนั้นสามารถโยนข้อยกเว้นนี้ออกไปได้ด้วยการใช้ throws ในการประกาศเมธอด
*/
public class ExceptionFileInputStream {

}
