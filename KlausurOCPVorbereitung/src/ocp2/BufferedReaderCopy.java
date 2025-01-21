package ocp2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
  QUESTION 80
 Given the code fragment:
 public static void main (String[] args) throws IOException   {
    BufferedReader brCopy = null;
    try (BufferedReader br = new BufferedReader (new FileReader(“employee.txt”))) { // line n1
        br.lines().forEach(c -> System.out.println(c));
        brCopy = br;        //line n2
    }
    brCopy.ready();   //line n3;
 }
 Assume that the ready method of the BufferedReader, when called on a closed BufferedReader, 
 throws an exception, and employee.txt is accessible and contains valid text.
 What is the result?
 A. A compilation error occurs at line n3.
 B. A compilation error occurs at line n1.
 C. A compilation error occurs at line n2.
 D. The code prints the content of the employee.txt file and throws an exception at line n3
 */
public class BufferedReaderCopy {

	 public static void main (String[] args) throws IOException   {
		    BufferedReader brCopy = null;
		    try (BufferedReader br = new BufferedReader (new FileReader("data2/colors/yellow.txt"))) { 
		        br.lines().forEach(c -> System.out.println(c));
		        brCopy = br;        //line n2
		    }
		    brCopy.ready();   //line n3;
		 }
	 
	 /*
	  
	   โปรแกรมจะแสดงเนื้อหาของไฟล์ employee.txt ออกมาเนื่องจาก br.lines().forEach ทำงานได้ตามปกติ.
		หลังจากจบ try block และ BufferedReader ถูกปิด, การเรียก brCopy.ready() 
		(Line n3) จะทำให้เกิด IOException เพราะ Reader ถูกปิดไปแล้ว.


	  	Green
		Exception in thread "main" java.io.IOException: Stream closed
	  */
	 
}
