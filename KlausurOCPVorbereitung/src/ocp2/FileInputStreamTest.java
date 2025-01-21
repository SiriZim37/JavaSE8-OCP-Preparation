package ocp2;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileInputStreamTest {

	
	 public static void main(String[] args) {
	        int i;
	        char c;
	        try (FileInputStream fis = new FileInputStream("course.txt");
	             InputStreamReader isr = new InputStreamReader(fis)) {
	            while (isr.ready()) {  // line n1
	                isr.skip(2);  // Skip two characters at a time
	                i = isr.read();  // Read the next character
	                c = (char) i;  // Convert integer to char
	                System.out.print(c);  // Print the character
	            }
	        } catch (Exception e) {
	            e.printStackTrace();  // Print the exception stack trace
	        }
	    }
	 
	 /*
	  * B is correct
	  */
}
